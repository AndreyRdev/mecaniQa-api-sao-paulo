package br.com.mecaniQA.api.Dto;

import br.com.mecaniQA.api.Enums.CategoriaPeca;
import java.time.LocalDateTime;


public class PecasDTO {
    private long codigoUnico;
    private String nome;
    private String fornecedorMarca;
    private Integer quantidadeEstoque;
    private String codigoDeBarras;
    private double precoCusto;
    private double precoVenda;
    private Double tamanho;
    private String cor;
    private CategoriaPeca categoriaPeca;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public PecasDTO() {
    }

    public PecasDTO(String nome, String fornecedorMarca, Integer quantidadeEstoque,
                    String codigoDeBarras, double precoCusto, double precoVenda, CategoriaPeca categoriaPeca) {
        this.nome = nome;
        this.fornecedorMarca = fornecedorMarca;
        this.quantidadeEstoque = quantidadeEstoque;
        this.codigoDeBarras = codigoDeBarras;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.categoriaPeca = categoriaPeca;
    }

    public long getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(long codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedorMarca() {
        return fornecedorMarca;
    }

    public void setFornecedorMarca(String fornecedorMarca) {
        this.fornecedorMarca = fornecedorMarca;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public CategoriaPeca getCategoriaPeca() {
        return categoriaPeca;
    }

    public void setCategoriaPeca(CategoriaPeca categoriaPeca) {
        this.categoriaPeca = categoriaPeca;
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
        return "PecasDTO{" +
                "codigoUnico=" + codigoUnico +
                ", nome='" + nome + '\'' +
                ", fornecedorMarca='" + fornecedorMarca + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", precoCusto=" + precoCusto +
                ", precoVenda=" + precoVenda +
                '}';
    }
}