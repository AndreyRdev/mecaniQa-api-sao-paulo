package br.com.mecaniQA.api.Mappers;

import br.com.mecaniQA.api.Dto.ServicosDTO;
import br.com.mecaniQA.api.model.Servicos;


public class ServicosMapper {

    public static ServicosDTO toDTO(Servicos servico) {
        if (servico == null) {
            return null;
        }

        ServicosDTO dto = new ServicosDTO();
        dto.setCodUnico(servico.getCodUnico());
        dto.setDescricao(servico.getNomeServico());
        dto.setCustoTabelado(servico.getCustoTabelado());
        dto.setTempoEstimadoMinutos(servico.getTempoEstimadoMinutos());
        dto.setDataCadastro(servico.getDataCriacao());
        dto.setDataAtualizacao(servico.getDataAtualizacao());

        return dto;
    }


    public static Servicos toEntity(ServicosDTO dto) {
        if (dto == null) {
            return null;
        }

        Servicos servico = new Servicos(
                dto.getDescricao(),
                dto.getTempoEstimadoMinutos(),
                dto.getCustoTabelado()
        );

        return servico;
    }
}