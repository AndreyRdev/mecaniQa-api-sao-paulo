package br.com.mecaniQA.api.Mappers;

import br.com.mecaniQA.api.Dto.VeiculoDTO;
import br.com.mecaniQA.api.model.Veiculo;
import br.com.mecaniQA.api.model.Cliente;
import br.com.mecaniQA.api.Repository.ClienteRepository;


public class VeiculoMapper {
    private static ClienteRepository clienteRepository = ClienteRepository.getInstance();


    public static VeiculoDTO toDTO(Veiculo veiculo) {
        if (veiculo == null) {
            return null;
        }

        VeiculoDTO dto = new VeiculoDTO();
        dto.setIdVeiculo(veiculo.getIdVeiculo());
        dto.setIdCliente(veiculo.getCliente() != null ? veiculo.getCliente().getIdCliente() : 0);
        dto.setPlaca(veiculo.getPlaca());
        dto.setMarcaModelo(veiculo.getMarcaModelo());
        dto.setAno(veiculo.getAno());
        dto.setCor(veiculo.getCor());
        dto.setNumeroMotor(veiculo.getNumeroMotor());
        dto.setNumeroChassi(veiculo.getNumeroChassi());
        dto.setQuilometragem(veiculo.getQuilometragem());
        dto.setObservacoes(veiculo.getObservacoes());
        dto.setQuantidadeOrdensServico(veiculo.getQuantidadeOrdensServico());
        dto.setDataCadastro(veiculo.getDataCadastro());
        dto.setDataAtualizacao(veiculo.getDataAtualizacao());

        return dto;
    }


    public static Veiculo toEntity(VeiculoDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente cliente = clienteRepository.buscarPorId(dto.getIdCliente());
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        Veiculo veiculo = new Veiculo(cliente, dto.getPlaca(), dto.getMarcaModelo(), dto.getAno());
        veiculo.setCor(dto.getCor());
        veiculo.setNumeroMotor(dto.getNumeroMotor());
        veiculo.setNumeroChassi(dto.getNumeroChassi());
        veiculo.setQuilometragem(dto.getQuilometragem());
        veiculo.setObservacoes(dto.getObservacoes());

        return veiculo;
    }
}