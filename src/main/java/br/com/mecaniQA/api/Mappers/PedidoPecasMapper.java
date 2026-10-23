package br.com.mecaniQA.api.Mappers;

import br.com.mecaniQA.api.Dto.PedidoPecasDTO;
import br.com.mecaniQA.api.model.PedidoPecas;
import br.com.mecaniQA.api.model.OrdemServico;
import br.com.mecaniQA.api.Repository.OrdemServicoRepository;


public class PedidoPecasMapper {
    private static OrdemServicoRepository ordemServicoRepository = OrdemServicoRepository.getInstance();


    public static PedidoPecasDTO toDTO(PedidoPecas pedidoPecas) {
        if (pedidoPecas == null) {
            return null;
        }

        PedidoPecasDTO dto = new PedidoPecasDTO();
        dto.setNumeroPedido(pedidoPecas.getNumeroPedido());
        dto.setNumeroOrdemServico(pedidoPecas.getOrdemServico() != null ? pedidoPecas.getOrdemServico().getNumeroOS() : 0);
        dto.setStatus(pedidoPecas.getStatus());
        dto.setFornecedor(pedidoPecas.getFornecedor());
        dto.setValorTotal(pedidoPecas.getValorTotal());
        dto.setValorPago(pedidoPecas.getValorPago());
        dto.setObservacoes(pedidoPecas.getObservacoes());
        dto.setDataCriacao(pedidoPecas.getDataCriacao());
        dto.setDataAtualizacao(pedidoPecas.getDataAtualizacao());
        dto.setDataEntrega(pedidoPecas.getDataEntrega());

        return dto;
    }


    public static PedidoPecas toEntity(PedidoPecasDTO dto) {
        if (dto == null) {
            return null;
        }

        OrdemServico ordemServico = ordemServicoRepository.buscarPorNumero(dto.getNumeroOrdemServico());
        if (ordemServico == null) {
            throw new IllegalArgumentException("Ordem de Serviço não encontrada");
        }

        PedidoPecas pedidoPecas = new PedidoPecas(ordemServico, dto.getStatus());
        pedidoPecas.setFornecedor(dto.getFornecedor());
        pedidoPecas.setObservacoes(dto.getObservacoes());

        return pedidoPecas;
    }
}