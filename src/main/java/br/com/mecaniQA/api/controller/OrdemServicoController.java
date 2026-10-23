package br.com.mecaniQA.api.controller;

import br.com.mecaniQA.api.service.OrdemServicoService;


import br.com.mecaniQA.api.Dto.OrdemServicoDTO;
import br.com.mecaniQA.api.Dto.StatusChangeDTO;
import br.com.mecaniQA.api.Enums.StatusOrdemServico;
import br.com.mecaniQA.api.Mappers.OrdemServicoMapper;
import br.com.mecaniQA.api.model.OrdemServico;
import br.com.mecaniQA.api.model.Cliente;
import br.com.mecaniQA.api.model.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/ordensServico")
public class OrdemServicoController {
    private final OrdemServicoService ordemServicoRepository;
    public OrdemServicoController(OrdemServicoService service) { this.ordemServicoRepository = service; }

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> criarOrdenServico(@RequestBody OrdemServicoDTO dto) {
        try {
            if (dto.getIdCliente() == 0 || dto.getIdVeiculo() == 0) {
                return ResponseEntity.badRequest().build();
            }

            if (dto.getDescricaoProblema() == null || dto.getDescricaoProblema().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            if (dto.getStatus() == null) {
                dto.setStatus(StatusOrdemServico.ABERTO);
            }

            Cliente cliente = ordemServicoRepository.buscarCliente(dto.getIdCliente());
            Veiculo veiculo = ordemServicoRepository.buscarVeiculo(dto.getIdVeiculo());

            if (cliente == null || veiculo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            OrdemServico ordemServico = OrdemServicoMapper.toEntity(dto);

            OrdemServico ordemCriada = ordemServicoRepository.cadastrar(ordemServico);

            cliente.adicionarOrdenServico(ordemCriada);
            veiculo.adicionarOrdenServico(ordemCriada);

            OrdemServicoDTO dtoRetorno = OrdemServicoMapper.toDTO(ordemCriada);

            return ResponseEntity.status(HttpStatus.CREATED).body(dtoRetorno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{numeroOS}/status")
    public ResponseEntity<OrdemServicoDTO> atualizarStatusOrdenServico(
            @PathVariable long numeroOS,
            @RequestBody StatusChangeDTO statusChangeDTO) {
        try {
            if (statusChangeDTO.getNovoStatus() == null) {
                return ResponseEntity.badRequest().build();
            }

            OrdemServico ordemServico = ordemServicoRepository.buscarPorNumero(numeroOS);
            if (ordemServico == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            OrdemServico ordemAtualizada = ordemServicoRepository.atualizarStatus(numeroOS, statusChangeDTO.getNovoStatus());

            if (ordemAtualizada == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            OrdemServicoDTO dtoRetorno = OrdemServicoMapper.toDTO(ordemAtualizada);

            return ResponseEntity.ok(dtoRetorno);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> listarOrdensServico() {
        try {
            List<OrdemServico> ordens = ordemServicoRepository.listarTodas();
            List<OrdemServicoDTO> dtos = ordens.stream()
                    .map(OrdemServicoMapper::toDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{numeroOS}")
    public ResponseEntity<OrdemServicoDTO> buscarOrdenServico(@PathVariable long numeroOS) {
        try {
            OrdemServico ordemServico = ordemServicoRepository.buscarPorNumero(numeroOS);
            if (ordemServico == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            OrdemServicoDTO dto = OrdemServicoMapper.toDTO(ordemServico);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<OrdemServicoDTO>> listarPorStatus(@PathVariable StatusOrdemServico status) {
        try {
            List<OrdemServico> ordens = ordemServicoRepository.buscarPorStatus(status);
            List<OrdemServicoDTO> dtos = ordens.stream()
                    .map(OrdemServicoMapper::toDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/{numeroOS}")
    public ResponseEntity<Void> deletarOrdenServico(@PathVariable long numeroOS) {
        try {
            OrdemServico ordemServico = ordemServicoRepository.deletar(numeroOS);
            if (ordemServico == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}