package br.com.mecaniQA.api.model;

import br.com.mecaniQA.api.Enums.StatusPedidoPecas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoPecas {
    private long numeroPedido;
    private OrdemServico ordemServico;
    private List<ItemPedido> itens;
    private StatusPedidoPecas status;
    private String fornecedor;
    private double valorTotal;
    private double valorPago;
    private String observacoes;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataEntrega;
    private static long contador = 1;

    public PedidoPecas(OrdemServico ordemServico, StatusPedidoPecas status) {
        this.numeroPedido = contador++;
        this.ordemServico = ordemServico;
        this.status = status;
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
        this.valorPago = 0;
        this.dataCriacao = LocalDateTime.now();
    }

    public PedidoPecas() {
        this.numeroPedido = contador++;
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
        this.valorPago = 0;
        this.dataCriacao = LocalDateTime.now();
    }



    public void adicionarItem(ItemPedido item) {
        if (item != null) {
            this.itens.add(item);
            recalcularValorTotal();
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public void removerItem(ItemPedido item) {
        if (item != null && this.itens.remove(item)) {
            recalcularValorTotal();
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public void recalcularValorTotal() {
        this.valorTotal = 0;
        for (ItemPedido item : this.itens) {
            this.valorTotal += item.getSubtotal();
        }
    }


    public void registrarPagamento(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor de pagamento não pode ser negativo");
        }
        this.valorPago += valor;
        this.dataAtualizacao = LocalDateTime.now();

        // Atualiza status para pago se atingiu o valor total
        if (this.valorPago >= this.valorTotal) {
            this.status = StatusPedidoPecas.PAGO_FATURADO;
        }
    }


    public void marcarEntregue() {
        this.status = StatusPedidoPecas.ENTREGUE;
        this.dataEntrega = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }


    public boolean estaTotalmentePago() {
        return this.valorPago >= this.valorTotal;
    }


    public double getValorPendente() {
        return this.valorTotal - this.valorPago;
    }

    public int getQuantidadeItens() {
        return this.itens.size();
    }


    public long getNumeroPedido() {
        return numeroPedido;
    }

    /** Define o identificador gerado pelo banco durante o mapeamento JDBC. */
    public void setNumeroPedido(long id) { this.numeroPedido = id; }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens != null ? itens : new ArrayList<>();
        recalcularValorTotal();
    }

    public StatusPedidoPecas getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoPecas status) {
        this.status = status;
        this.dataAtualizacao = LocalDateTime.now();
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
        return "PedidoPecas{" +
                "numeroPedido=" + numeroPedido +
                ", status=" + status +
                ", valorTotal=" + valorTotal +
                ", valorPago=" + valorPago +
                ", itens=" + itens.size() +
                '}';
    }
}