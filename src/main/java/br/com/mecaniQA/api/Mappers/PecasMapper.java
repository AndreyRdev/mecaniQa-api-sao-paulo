package br.com.mecaniQA.api.Mappers;

import br.com.mecaniQA.api.Dto.PecasDTO;
import br.com.mecaniQA.api.model.Pecas;


public class PecasMapper {


    public static PecasDTO toDTO(Pecas peca) {
        if (peca == null) {
            return null;
        }

        PecasDTO dto = new PecasDTO();
        dto.setCodigoUnico(peca.getCodigoUnico());
        dto.setNome(peca.getNome());
        dto.setFornecedorMarca(peca.getFornecedorMarca());
        dto.setQuantidadeEstoque(peca.getQuantidadeEstoque());
        dto.setCodigoDeBarras(peca.getCodigoDeBarras());
        dto.setPrecoCusto(peca.getPrecoCusto());
        dto.setPrecoVenda(peca.getPrecoVenda());
        dto.setTamanho(peca.getTamanho());
        dto.setCor(peca.getCor());
        dto.setCategoriaPeca(peca.getCategoriaPeca());
        dto.setDataCadastro(peca.getDataCadastro());
        dto.setDataAtualizacao(peca.getDataAtualizacao());

        return dto;
    }


    public static Pecas toEntity(PecasDTO dto) {
        if (dto == null) {
            return null;
        }

        Pecas peca = new Pecas(
                dto.getNome(),
                dto.getFornecedorMarca(),
                dto.getQuantidadeEstoque(),
                dto.getCodigoDeBarras(),
                dto.getPrecoCusto(),
                dto.getPrecoVenda(),
                dto.getCategoriaPeca()
        );

        peca.setTamanho(dto.getTamanho());
        peca.setCor(dto.getCor());

        return peca;
    }
}