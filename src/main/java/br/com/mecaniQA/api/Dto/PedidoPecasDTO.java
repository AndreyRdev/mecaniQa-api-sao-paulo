package br.com.mecaniQA.api.Dto;

import br.com.mecaniQA.api.Enums.StatusPedidoPecas;
import java.time.LocalDateTime;
import java.util.List;


public class PedidoPecasDTO {
    private long numeroPedido;
    private long numeroOrdemServico;
    private List<Long> idsItens;
    private StatusPedidoPecas status;
    private String fornecedor;
    private double valorTotal;
    private double valorPago;
    private String observacoes;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataEntrega;

    public PedidoPecasDTO() {
    }

    public PedidoPecasDTO(long numeroPedido, long numeroOrdemServico, StatusPedidoPecas status) {
        this.numeroPedido = numeroPedido;
        this.numeroOrdemServico = numeroOrdemServico;
        this.status = status;
    }

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public long getNumeroOrdemServico() {
        return numeroOrdemServico;
    }

    public void setNumeroOrdemServico(long numeroOrdemServico) {
        this.numeroOrdemServico = numeroOrdemServico;
    }

    public List<Long> getIdsItens() {
        return idsItens;
    }

    public void setIdsItens(List<Long> idsItens) {
        this.idsItens = idsItens;
    }

    public StatusPedidoPecas getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoPecas status) {
        this.status = status;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public String toString() {
        return "PedidoPecasDTO{" +
                "numeroPedido=" + numeroPedido +
                ", numeroOrdemServico=" + numeroOrdemServico +
                ", status=" + status +
                ", valorTotal=" + valorTotal +
                ", valorPago=" + valorPago +
                '}';
    }
}