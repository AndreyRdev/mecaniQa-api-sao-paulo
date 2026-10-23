package br.com.mecaniQA.api.Mappers;

import br.com.mecaniQA.api.Dto.ClienteDTO;
import br.com.mecaniQA.api.model.Cliente;


public class ClienteMapper {


    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setNome(cliente.getNome());
        dto.setCpfCnpj(cliente.getCpfCnpj());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        dto.setEndereco(cliente.getEndereco());
        dto.setCidade(cliente.getCidade());
        dto.setEstado(cliente.getEstado());
        dto.setCep(cliente.getCep());
        dto.setQuantidadeVeiculos(cliente.getQuantidadeVeiculos());
        dto.setQuantidadeOrdensServico(cliente.getQuantidadeOrdensServico());
        dto.setDataCadastro(cliente.getDataCadastro());
        dto.setDataAtualizacao(cliente.getDataAtualizacao());

        return dto;
    }


    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente cliente = new Cliente(dto.getNome(), dto.getCpfCnpj(), dto.getEmail(), dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());
        cliente.setCidade(dto.getCidade());
        cliente.setEstado(dto.getEstado());
        cliente.setCep(dto.getCep());

        return cliente;
    }
}