package br.com.mecaniQA.api.Mappers;

import br.com.mecaniQA.api.Dto.OrdemServicoDTO;
import br.com.mecaniQA.api.model.OrdemServico;
import br.com.mecaniQA.api.model.Cliente;
import br.com.mecaniQA.api.model.Veiculo;
import br.com.mecaniQA.api.Repository.ClienteRepository;
import br.com.mecaniQA.api.Repository.VeiculoRepository;


public class OrdemServicoMapper {
    private static ClienteRepository clienteRepository = ClienteRepository.getInstance();
    private static VeiculoRepository veiculoRepository = VeiculoRepository.getInstance();


    public static OrdemServicoDTO toDTO(OrdemServico ordemServico) {
        if (ordemServico == null) {
            return null;
        }

        OrdemServicoDTO dto = new OrdemServicoDTO();
        dto.setNumeroOS(ordemServico.getNumeroOS());
        dto.setIdCliente(ordemServico.getCliente() != null ? ordemServico.getCliente().getIdCliente() : 0);
        dto.setIdVeiculo(ordemServico.getVeiculo() != null ? ordemServico.getVeiculo().getIdVeiculo() : 0);
        dto.setStatus(ordemServico.getStatus());
        dto.setDescricaoProblema(ordemServico.getDescricaoProblema());
        dto.setObservacoes(ordemServico.getObservacoes());
        dto.setValorTotal(ordemServico.getValorTotal());
        dto.setDataCriacao(ordemServico.getDataCriacao());
        dto.setDataAtualizacao(ordemServico.getDataAtualizacao());
        dto.setDataFinalizacao(ordemServico.getDataFinalizacao());

        return dto;
    }


    public static OrdemServico toEntity(OrdemServicoDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente cliente = clienteRepository.buscarPorId(dto.getIdCliente());
        Veiculo veiculo = veiculoRepository.buscarPorId(dto.getIdVeiculo());

        if (cliente == null || veiculo == null) {
            throw new IllegalArgumentException("Cliente ou Veículo não encontrado");
        }

        OrdemServico ordemServico = new OrdemServico.Builder()
                .comCliente(cliente)
                .comVeiculo(veiculo)
                .comDescricaoProblema(dto.getDescricaoProblema())
                .comStatus(dto.getStatus())
                .comObservacoes(dto.getObservacoes())
                .comValorTotal(dto.getValorTotal())
                .build();

        return ordemServico;
    }
}