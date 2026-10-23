package br.com.mecaniQA.api.model;

import br.com.mecaniQA.api.Enums.CategoriaPeca;
import java.time.LocalDateTime;

public class Pecas{
    private long codigoUnico;
    private String nome;
    private String fornecedorMarca;
    private Integer quantidadeEstoque;
    private String codigoDeBarras;
    private double precoCusto;
    private double precoVenda;
    private Double tamanho;
    private String cor;
    private LocalDateTime dataCadastro; //Mudar o tipo esse tem que por o tempo tambem
    private LocalDateTime dataAtualizacao;
    private CategoriaPeca categoriaPeca;
    private static long contador =1;

    public Pecas(String nome,String fornecedorMarca,Integer quantidadeEstoque,String codigoDeBarras,double precoCusto,double precoVenda,CategoriaPeca categoriaPeca ) {
        this.codigoUnico=contador++;
        this.nome=nome;
        this.fornecedorMarca=fornecedorMarca;
        this.quantidadeEstoque=quantidadeEstoque;
        this.codigoDeBarras=codigoDeBarras;
        this.precoCusto=precoCusto;
        this.precoVenda=precoVenda;
        this.dataCadastro=LocalDateTime.now();
        this.categoriaPeca=categoriaPeca;
        this.cor=null;
        this.tamanho=null;
    }

    public long getCodigoUnico() {
        return codigoUnico;
    }

    /** Define o identificador gerado pelo banco durante o mapeamento JDBC. */
    public void setCodigoUnico(long id) { this.codigoUnico = id; }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
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

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public CategoriaPeca getCategoriaPeca() {
        return categoriaPeca;
    }

    public void setCategoriaPeca(CategoriaPeca categoriaPeca) {
        this.categoriaPeca = categoriaPeca;
    }
}