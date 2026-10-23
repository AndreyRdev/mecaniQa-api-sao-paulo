package br.com.mecaniQA.api.model;

import java.time.LocalDateTime;

public class Servicos {
    private long codUnico;
    private String nomeServico;
    private int tempoEstimadoMinutos;
    private double custoTabelado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private static long contador=1;

    public Servicos(String nomeServico,int tempoEstimadoMinutos,double custoTabelado){
        this.codUnico=contador++;
        this.nomeServico=nomeServico;
        this.tempoEstimadoMinutos=tempoEstimadoMinutos;
        this.custoTabelado=custoTabelado;
        this.dataCriacao=LocalDateTime.now();
    }

    public long getCodUnico() {
        return codUnico;
    }

    /** Define o identificador gerado pelo banco durante o mapeamento JDBC. */
    public void setCodUnico(long id) { this.codUnico = id; }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getTempoEstimadoMinutos() {
        return tempoEstimadoMinutos;
    }

    public void setTempoEstimadoMinutos(int tempoEstimadoMinutos) {
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
    }

    public double getCustoTabelado() {
        return custoTabelado;
    }

    public void setCustoTabelado(double custoTabelado) {
        this.custoTabelado = custoTabelado;
    }
}