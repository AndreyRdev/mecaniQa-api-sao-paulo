package br.com.mecaniQA.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private long idCliente;
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private List<Veiculo> veiculos;
    private List<OrdemServico> ordensServico;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private static long contador = 1;


    public Cliente(String nome, String cpfCnpj, String email, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
        }
        if (cpfCnpj == null || cpfCnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF/CNPJ não pode ser vazio");
        }

        this.idCliente = contador++;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.telefone = telefone;
        this.veiculos = new ArrayList<>();
        this.ordensServico = new ArrayList<>();
        this.dataCadastro = LocalDateTime.now();
    }


    public Cliente() {
        this.idCliente = contador++;
        this.veiculos = new ArrayList<>();
        this.ordensServico = new ArrayList<>();
        this.dataCadastro = LocalDateTime.now();
    }



    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            this.veiculos.add(veiculo);
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public void removerVeiculo(Veiculo veiculo) {
        if (veiculo != null && this.veiculos.remove(veiculo)) {
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public void adicionarOrdenServico(OrdemServico ordemServico) {
        if (ordemServico != null) {
            this.ordensServico.add(ordemServico);
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public int getQuantidadeVeiculos() {
        return this.veiculos.size();
    }


    public int getQuantidadeOrdensServico() {
        return this.ordensServico.size();
    }


    public long getIdCliente() {
        return idCliente;
    }

    /** Define o identificador gerado pelo banco durante o mapeamento JDBC. */
    public void setIdCliente(long id) { this.idCliente = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos != null ? veiculos : new ArrayList<>();
    }

    public List<OrdemServico> getOrdensServico() {
        return ordensServico;
    }

    public void setOrdensServico(List<OrdemServico> ordensServico) {
        this.ordensServico = ordensServico != null ? ordensServico : new ArrayList<>();
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", email='" + email + '\'' +
                ", veiculos=" + veiculos.size() +
                '}';
    }
}