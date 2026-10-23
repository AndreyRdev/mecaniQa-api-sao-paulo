package br.com.mecaniQA.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Veiculo {
    private long idVeiculo;
    private Cliente cliente;
    private String placa;
    private String marcaModelo;
    private int ano;
    private String cor;
    private String numeroMotor;
    private String numeroChassi;
    private double quilometragem;
    private String observacoes;
    private List<OrdemServico> ordensServico;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private static long contador = 1;


    public Veiculo(Cliente cliente, String placa, String marcaModelo, int ano) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("Placa não pode ser vazia");
        }
        if (marcaModelo == null || marcaModelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca/Modelo não pode ser vazio");
        }
        if (ano <= 0) {
            throw new IllegalArgumentException("Ano deve ser um valor válido");
        }

        this.idVeiculo = contador++;
        this.cliente = cliente;
        this.placa = placa;
        this.marcaModelo = marcaModelo;
        this.ano = ano;
        this.ordensServico = new ArrayList<>();
        this.dataCadastro = LocalDateTime.now();
    }


    public Veiculo() {
        this.idVeiculo = contador++;
        this.ordensServico = new ArrayList<>();
        this.dataCadastro = LocalDateTime.now();
    }




    public void adicionarOrdenServico(OrdemServico ordemServico) {
        if (ordemServico != null) {
            this.ordensServico.add(ordemServico);
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public void removerOrdenServico(OrdemServico ordemServico) {
        if (ordemServico != null && this.ordensServico.remove(ordemServico)) {
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public int getQuantidadeOrdensServico() {
        return this.ordensServico.size();
    }


    public void atualizarQuilometragem(double novaQuilometragem) {
        if (novaQuilometragem < 0) {
            throw new IllegalArgumentException("Quilometragem não pode ser negativa");
        }
        if (novaQuilometragem < this.quilometragem) {
            throw new IllegalArgumentException("A quilometragem não pode diminuir");
        }
        this.quilometragem = novaQuilometragem;
        this.dataAtualizacao = LocalDateTime.now();
    }


    public long getIdVeiculo() {
        return idVeiculo;
    }

    /** Define o identificador gerado pelo banco durante o mapeamento JDBC. */
    public void setIdVeiculo(long id) { this.idVeiculo = id; }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        if (quilometragem < 0) {
            throw new IllegalArgumentException("Quilometragem não pode ser negativa");
        }
        this.quilometragem = quilometragem;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        this.dataAtualizacao = LocalDateTime.now();
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
        return "Veiculo{" +
                "idVeiculo=" + idVeiculo +
                ", placa='" + placa + '\'' +
                ", marcaModelo='" + marcaModelo + '\'' +
                ", ano=" + ano +
                ", quilometragem=" + quilometragem +
                '}';
    }
}