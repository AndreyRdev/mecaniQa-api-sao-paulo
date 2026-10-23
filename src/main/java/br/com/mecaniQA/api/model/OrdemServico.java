package br.com.mecaniQA.api.model;

import br.com.mecaniQA.api.Enums.StatusOrdemServico;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdemServico {
    private long numeroOS;
    private Cliente cliente;
    private Veiculo veiculo;
    private List<Servicos> servicos;
    private List<PedidoPecas> pedidosPecas;
    private StatusOrdemServico status;
    private String descricaoProblema;
    private String observacoes;
    private double valorTotal;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataFinalizacao;
    private static long contador = 1;


    private OrdemServico(Builder builder) {
        this.numeroOS = contador++;
        this.cliente = builder.cliente;
        this.veiculo = builder.veiculo;
        this.servicos = builder.servicos != null ? builder.servicos : new ArrayList<>();
        this.pedidosPecas = builder.pedidosPecas != null ? builder.pedidosPecas : new ArrayList<>();
        this.status = builder.status;
        this.descricaoProblema = builder.descricaoProblema;
        this.observacoes = builder.observacoes;
        this.valorTotal = builder.valorTotal;
        this.dataCriacao = LocalDateTime.now();
    }


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private Cliente cliente;
        private Veiculo veiculo;
        private List<Servicos> servicos;
        private List<PedidoPecas> pedidosPecas;
        private StatusOrdemServico status;
        private String descricaoProblema;
        private String observacoes;
        private double valorTotal;


        public Builder comCliente(Cliente cliente) {
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente não pode ser nulo");
            }
            this.cliente = cliente;
            return this;
        }


        public Builder comVeiculo(Veiculo veiculo) {
            if (veiculo == null) {
                throw new IllegalArgumentException("Veículo não pode ser nulo");
            }
            this.veiculo = veiculo;
            return this;
        }


        public Builder comDescricaoProblema(String descricaoProblema) {
            if (descricaoProblema == null || descricaoProblema.trim().isEmpty()) {
                throw new IllegalArgumentException("Descrição do problema não pode ser vazia");
            }
            this.descricaoProblema = descricaoProblema;
            return this;
        }


        public Builder comStatus(StatusOrdemServico status) {
            if (status == null) {
                throw new IllegalArgumentException("Status não pode ser nulo");
            }
            this.status = status;
            return this;
        }


        public Builder adicionarServico(Servicos servico) {
            if (servico == null) {
                throw new IllegalArgumentException("Serviço não pode ser nulo");
            }

            if (this.servicos == null) {
                this.servicos = new ArrayList<>();
            }

            this.servicos.add(servico);
            return this;
        }


        public Builder adicionarServicos(List<Servicos> servicos) {
            if (servicos != null && !servicos.isEmpty()) {
                if (this.servicos == null) {
                    this.servicos = new ArrayList<>();
                }

                this.servicos.addAll(servicos);
            }

            return this;
        }


        public Builder adicionarPedidoPecas(PedidoPecas pedido) {
            if (pedido == null) {
                throw new IllegalArgumentException("Pedido de peças não pode ser nulo");
            }

            if (this.pedidosPecas == null) {
                this.pedidosPecas = new ArrayList<>();
            }

            this.pedidosPecas.add(pedido);
            return this;
        }

        public Builder adicionarPedidosPecas(List<PedidoPecas> pedidos) {
            if (pedidos != null && !pedidos.isEmpty()) {
                if (this.pedidosPecas == null) {
                    this.pedidosPecas = new ArrayList<>();
                }

                this.pedidosPecas.addAll(pedidos);
            }

            return this;
        }


        public Builder comObservacoes(String observacoes) {
            this.observacoes = observacoes;
            return this;
        }


        public Builder comValorTotal(double valorTotal) {
            if (valorTotal < 0) {
                throw new IllegalArgumentException("Valor total não pode ser negativo");
            }

            this.valorTotal = valorTotal;
            return this;
        }


        public OrdemServico build() {
            validarCamposObrigatorios();
            return new OrdemServico(this);
        }


        private void validarCamposObrigatorios() {
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente é obrigatório");
            }

            if (veiculo == null) {
                throw new IllegalArgumentException("Veículo é obrigatório");
            }

            if (descricaoProblema == null || descricaoProblema.trim().isEmpty()) {
                throw new IllegalArgumentException("Descrição do problema é obrigatória");
            }

            if (status == null) {
                throw new IllegalArgumentException("Status é obrigatório");
            }
        }
    }


    public long getNumeroOS() {
        return numeroOS;
    }

    /** Define o identificador gerado pelo banco durante o mapeamento JDBC. */
    public void setNumeroOS(long id) { this.numeroOS = id; }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

    public List<PedidoPecas> getPedidosPecas() {
        return pedidosPecas;
    }

    public void setPedidosPecas(List<PedidoPecas> pedidosPecas) {
        this.pedidosPecas = pedidosPecas;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
        this.dataAtualizacao = LocalDateTime.now();
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
        this.dataAtualizacao = LocalDateTime.now();
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

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }


    public void adicionarServico(Servicos servico) {
        if (servico != null) {
            this.servicos.add(servico);
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public void adicionarPedidoPecas(PedidoPecas pedido) {
        if (pedido != null) {
            this.pedidosPecas.add(pedido);
            this.dataAtualizacao = LocalDateTime.now();
        }
    }


    public double calcularValorTotal() {
        double total = 0;

        for (Servicos servico : servicos) {
            total += servico.getCustoTabelado();
        }

        for (PedidoPecas pedido : pedidosPecas) {
            total += pedido.getValorTotal();
        }

        this.valorTotal = total;
        return total;
    }


    public void finalizar() {
        if (this.status == StatusOrdemServico.EXECUTADO) {
            this.dataFinalizacao = LocalDateTime.now();
            this.dataAtualizacao = LocalDateTime.now();
        }
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "numeroOS=" + numeroOS +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", status=" + status +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
