package br.com.mecaniQA.api.model;

import java.time.LocalDateTime;


public class ItemPedido {
    private long idItem;
    private PedidoPecas pedidoPecas;
    private Pecas peca;
    private int quantidade;
    private double precoUnitario;
    private double subtotal;
    private String observacoes;
    private LocalDateTime dataCriacao;
    private static long contador = 1;


    public ItemPedido(PedidoPecas pedidoPecas, Pecas peca, int quantidade, double precoUnitario) {
        if (pedidoPecas == null) {
            throw new IllegalArgumentException("Pedido de peças não pode ser nulo");
        }
        if (peca == null) {
            throw new IllegalArgumentException("Peça não pode ser nula");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        if (precoUnitario < 0) {
            throw new IllegalArgumentException("Preço unitário não pode ser negativo");
        }

        this.idItem = contador++;
        this.pedidoPecas = pedidoPecas;
        this.peca = peca;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = calcularSubtotal();
        this.dataCriacao = LocalDateTime.now();
    }


    public ItemPedido() {
        this.idItem = contador++;
        this.dataCriacao = LocalDateTime.now();
    }



    private double calcularSubtotal() {
        return this.quantidade * this.precoUnitario;
    }


    public void atualizarQuantidade(int novaQuantidade) {
        if (novaQuantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.quantidade = novaQuantidade;
        this.subtotal = calcularSubtotal();
    }

    public void atualizarPrecoUnitario(double novoPreco) {
        if (novoPreco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.precoUnitario = novoPreco;
        this.subtotal = calcularSubtotal();
    }


    public void atualizar(int novaQuantidade, double novoPreco) {
        atualizarQuantidade(novaQuantidade);
        atualizarPrecoUnitario(novoPreco);
    }


    public long getIdItem() {
        return idItem;
    }

    /** Define o identificador gerado pelo banco durante o mapeamento JDBC. */
    public void setIdItem(long id) { this.idItem = id; }

    public PedidoPecas getPedidoPecas() {
        return pedidoPecas;
    }

    public void setPedidoPecas(PedidoPecas pedidoPecas) {
        this.pedidoPecas = pedidoPecas;
    }

    public Pecas getPeca() {
        return peca;
    }

    public void setPeca(Pecas peca) {
        this.peca = peca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.quantidade = quantidade;
        this.subtotal = calcularSubtotal();
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.precoUnitario = precoUnitario;
        this.subtotal = calcularSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
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

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idItem=" + idItem +
                ", peca=" + (peca != null ? peca.getNome() : "null") +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}