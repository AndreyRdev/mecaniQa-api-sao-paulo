package br.com.mecaniQA.api.Dto;

import java.time.LocalDateTime;


public class VeiculoDTO {
    private long idVeiculo;
    private long idCliente;
    private String placa;
    private String marcaModelo;
    private int ano;
    private String cor;
    private String numeroMotor;
    private String numeroChassi;
    private double quilometragem;
    private String observacoes;
    private int quantidadeOrdensServico;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;


    public VeiculoDTO() {
    }

    public VeiculoDTO(long idCliente, String placa, String marcaModelo, int ano) {
        this.idCliente = idCliente;
        this.placa = placa;
        this.marcaModelo = marcaModelo;
        this.ano = ano;
    }

    public long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getQuantidadeOrdensServico() {
        return quantidadeOrdensServico;
    }

    public void setQuantidadeOrdensServico(int quantidadeOrdensServico) {
        this.quantidadeOrdensServico = quantidadeOrdensServico;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "VeiculoDTO{" +
                "idVeiculo=" + idVeiculo +
                ", idCliente=" + idCliente +
                ", placa='" + placa + '\'' +
                ", marcaModelo='" + marcaModelo + '\'' +
                ", ano=" + ano +
                ", quilometragem=" + quilometragem +
                '}';
    }
}