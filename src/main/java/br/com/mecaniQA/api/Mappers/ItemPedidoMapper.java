package br.com.mecaniQA.api.Mappers;

import br.com.mecaniQA.api.Dto.ItemPedidoDTO;
import br.com.mecaniQA.api.model.ItemPedido;
import br.com.mecaniQA.api.model.PedidoPecas;
import br.com.mecaniQA.api.model.Pecas;
import br.com.mecaniQA.api.Repository.PedidoPecasRepository;
import br.com.mecaniQA.api.Repository.PecasRepository;

public class ItemPedidoMapper {
    private static PedidoPecasRepository pedidoPecasRepository = PedidoPecasRepository.getInstance();
    private static PecasRepository pecasRepository = PecasRepository.getInstance();


    public static ItemPedidoDTO toDTO(ItemPedido itemPedido) {
        if (itemPedido == null) {
            return null;
        }

        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setIdItem(itemPedido.getIdItem());
        dto.setNumeroPedido(itemPedido.getPedidoPecas() != null ? itemPedido.getPedidoPecas().getNumeroPedido() : 0);
        dto.setIdPeca(itemPedido.getPeca() != null ? itemPedido.getPeca().getCodigoUnico() : 0);
        dto.setQuantidade(itemPedido.getQuantidade());
        dto.setPrecoUnitario(itemPedido.getPrecoUnitario());
        dto.setSubtotal(itemPedido.getSubtotal());
        dto.setObservacoes(itemPedido.getObservacoes());
        dto.setDataCriacao(itemPedido.getDataCriacao());

        return dto;
    }


    public static ItemPedido toEntity(ItemPedidoDTO dto) {
        if (dto == null) {
            return null;
        }

        PedidoPecas pedidoPecas = pedidoPecasRepository.buscarPorNumero(dto.getNumeroPedido());
        Pecas peca = pecasRepository.buscarPorCodigo(dto.getIdPeca());

        if (pedidoPecas == null || peca == null) {
            throw new IllegalArgumentException("Pedido ou Peça não encontrado");
        }

        ItemPedido itemPedido = new ItemPedido(pedidoPecas, peca, dto.getQuantidade(), dto.getPrecoUnitario());
        itemPedido.setObservacoes(dto.getObservacoes());

        return itemPedido;
    }
}