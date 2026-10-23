package br.com.mecaniQA.api.controller;





import br.com.mecaniQA.api.service.PedidoPecasService;
import br.com.mecaniQA.api.Dto.PedidoPecasDTO;
import br.com.mecaniQA.api.Dto.ItemPedidoDTO;
import br.com.mecaniQA.api.Dto.StatusPedidoChangeDTO;
import br.com.mecaniQA.api.Enums.StatusPedidoPecas;
import br.com.mecaniQA.api.Mappers.PedidoPecasMapper;
import br.com.mecaniQA.api.Mappers.ItemPedidoMapper;
import br.com.mecaniQA.api.model.PedidoPecas;
import br.com.mecaniQA.api.model.ItemPedido;
import br.com.mecaniQA.api.model.OrdemServico;
import br.com.mecaniQA.api.model.Pecas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/pedidoPecas")
public class PedidoPecasController {
    private final PedidoPecasService pedidoPecasRepository;
    public PedidoPecasController(PedidoPecasService service) { this.pedidoPecasRepository = service; }


    @PostMapping
    public ResponseEntity<PedidoPecasDTO> criarPedidoPecas(@RequestBody PedidoPecasDTO dto) {
        try {
            if (dto.getNumeroOrdemServico() == 0) {
                return ResponseEntity.badRequest().build();
            }

            if (dto.getStatus() == null) {
                dto.setStatus(StatusPedidoPecas.ORCANDO);
            }

            OrdemServico ordemServico = pedidoPecasRepository.buscarOrdem(dto.getNumeroOrdemServico());
            if (ordemServico == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            PedidoPecas pedidoPecas = PedidoPecasMapper.toEntity(dto);

            PedidoPecas pedidoCriado = pedidoPecasRepository.cadastrar(pedidoPecas);

            ordemServico.adicionarPedidoPecas(pedidoCriado);

            PedidoPecasDTO dtoRetorno = PedidoPecasMapper.toDTO(pedidoCriado);

            return ResponseEntity.status(HttpStatus.CREATED).body(dtoRetorno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{numeroPedido}/itens")
    public ResponseEntity<ItemPedidoDTO> adicionarPecasAoPedido(
            @PathVariable long numeroPedido,
            @RequestBody ItemPedidoDTO dto) {
        try {
            if (dto.getIdPeca() == 0 || dto.getQuantidade() <= 0 || dto.getPrecoUnitario() < 0) {
                return ResponseEntity.badRequest().build();
            }

            PedidoPecas pedidoPecas = pedidoPecasRepository.buscarPorNumero(numeroPedido);
            Pecas peca = pedidoPecasRepository.buscarPeca(dto.getIdPeca());

            if (pedidoPecas == null || peca == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            if (pedidoPecas.getStatus() != StatusPedidoPecas.ORCANDO &&
                    pedidoPecas.getStatus() != StatusPedidoPecas.PENDENTE_PAGAMENTO) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            ItemPedido itemPedido = ItemPedidoMapper.toEntity(dto);

            ItemPedido itemCriado = pedidoPecasRepository.cadastrarItem(itemPedido);

            pedidoPecas.adicionarItem(itemCriado);

            ItemPedidoDTO dtoRetorno = ItemPedidoMapper.toDTO(itemCriado);

            return ResponseEntity.status(HttpStatus.CREATED).body(dtoRetorno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{numeroPedido}/status")
    public ResponseEntity<PedidoPecasDTO> atualizarStatusPedido(
            @PathVariable long numeroPedido,
            @RequestBody StatusPedidoChangeDTO statusChangeDTO) {
        try {
            if (statusChangeDTO.getNovoStatus() == null) {
                return ResponseEntity.badRequest().build();
            }

            PedidoPecas pedidoPecas = pedidoPecasRepository.buscarPorNumero(numeroPedido);
            if (pedidoPecas == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            PedidoPecas pedidoAtualizado = pedidoPecasRepository.atualizarStatus(numeroPedido, statusChangeDTO.getNovoStatus());

            if (pedidoAtualizado == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            PedidoPecasDTO dtoRetorno = PedidoPecasMapper.toDTO(pedidoAtualizado);

            return ResponseEntity.ok(dtoRetorno);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<PedidoPecasDTO>> listarPedidos() {
        try {
            List<PedidoPecas> pedidos = pedidoPecasRepository.listarTodos();
            List<PedidoPecasDTO> dtos = pedidos.stream()
                    .map(PedidoPecasMapper::toDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{numeroPedido}")
    public ResponseEntity<PedidoPecasDTO> buscarPedido(@PathVariable long numeroPedido) {
        try {
            PedidoPecas pedidoPecas = pedidoPecasRepository.buscarPorNumero(numeroPedido);
            if (pedidoPecas == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            PedidoPecasDTO dto = PedidoPecasMapper.toDTO(pedidoPecas);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/{numeroPedido}")
    public ResponseEntity<Void> deletarPedido(@PathVariable long numeroPedido) {
        try {
            PedidoPecas pedidoPecas = pedidoPecasRepository.deletar(numeroPedido);
            if (pedidoPecas == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}