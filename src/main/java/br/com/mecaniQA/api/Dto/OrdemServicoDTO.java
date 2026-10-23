package br.com.mecaniQA.api.Dto;

import br.com.mecaniQA.api.Enums.StatusOrdemServico;
import java.time.LocalDateTime;
import java.util.List;

public class OrdemServicoDTO {
    private long numeroOS;
    private long idCliente;
    private long idVeiculo;
    private List<Long> idsServicos;
    private List<Long> idsPedidosPecas;
    private StatusOrdemServico status;
    private String descricaoProblema;
    private String observacoes;
    private double valorTotal;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataFinalizacao;

    public OrdemServicoDTO() {
    }

    public OrdemServicoDTO(long numeroOS, long idCliente, long idVeiculo, StatusOrdemServico status,
                           String descricaoProblema) {
        this.numeroOS = numeroOS;
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.status = status;
        this.descricaoProblema = descricaoProblema;
    }

    public long getNumeroOS() {
        return numeroOS;
    }

    public void setNumeroOS(long numeroOS) {
        this.numeroOS = numeroOS;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public List<Long> getIdsServicos() {
        return idsServicos;
    }

    public void setIdsServicos(List<Long> idsServicos) {
        this.idsServicos = idsServicos;
    }

    public List<Long> getIdsPedidosPecas() {
        return idsPedidosPecas;
    }

    public void setIdsPedidosPecas(List<Long> idsPedidosPecas) {
        this.idsPedidosPecas = idsPedidosPecas;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    @Override
    public String toString() {
        return "OrdemServicoDTO{" +
                "numeroOS=" + numeroOS +
                ", idCliente=" + idCliente +
                ", idVeiculo=" + idVeiculo +
                ", status=" + status +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}