package br.com.mecaniQA.api.Dto;

import java.time.LocalDateTime;


public class ServicosDTO {
    private long codUnico;
    private String descricao;
    private double custoTabelado;
    private int tempoEstimadoMinutos;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public ServicosDTO() {
    }

    public ServicosDTO(String descricao, double custoTabelado, int tempoEstimadoMinutos) {
        this.descricao = descricao;
        this.custoTabelado = custoTabelado;
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
    }

    public long getCodUnico() {
        return codUnico;
    }

    public void setCodUnico(long codUnico) {
        this.codUnico = codUnico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCustoTabelado() {
        return custoTabelado;
    }

    public void setCustoTabelado(double custoTabelado) {
        this.custoTabelado = custoTabelado;
    }

    public int getTempoEstimadoMinutos() {
        return tempoEstimadoMinutos;
    }

    public void setTempoEstimadoMinutos(int tempoEstimadoMinutos) {
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
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
        return "ServicosDTO{" +
                "codUnico=" + codUnico +
                ", descricao='" + descricao + '\'' +
                ", custoTabelado=" + custoTabelado +
                ", tempoEstimadoMinutos=" + tempoEstimadoMinutos +
                '}';
    }
}