/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 * Classe que representa um produto.
 * 
 * Um produto possui um identificador único, uma categoria, um nome, um valor, uma descrição e uma imagem.
 * 
 * @author Iago
 */
public class Produtos {
    // Identificador único do produto
    private int idProduto;
    // Identificador da categoria do produto
    private int categoria;
    // Nome do produto
    private String nome;
    // Valor do produto
    private float valor;
    // Descrição do produto
    private String descricao;
    // URL da imagem do produto
    private String imagem;

    /**
     * Construtor padrão da classe.
     */
    public Produtos() {
    }

    /**
     * Construtor parametrizado da classe.
     * 
     * @param idProduto O identificador único do produto.
     * @param categoria O identificador da categoria do produto.
     * @param nome O nome do produto.
     * @param valor O valor do produto.
     * @param descricao A descrição do produto.
     * @param imagem A URL da imagem do produto.
     */
    public Produtos(int idProduto, int categoria, String nome, float valor, String descricao, String imagem) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    /**
     * Obtém o identificador único do produto.
     * 
     * @return O identificador único do produto.
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Define o identificador único do produto.
     * 
     * @param idProduto O identificador único do produto.
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Obtém o identificador da categoria do produto.
     * 
     * @return O identificador da categoria do produto.
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * Define o identificador da categoria do produto.
     * 
     * @param categoria O identificador da categoria do produto.
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtém o nome do produto.
     * 
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * 
     * @param nome O nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o valor do produto.
     * 
     * @return O valor do produto.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Define o valor do produto.
     * 
     * @param valor O valor do produto.
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * Obtém a descrição do produto.
     * 
     * @return A descrição do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do produto.
     * 
     * @param descricao A descrição do produto.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a URL da imagem do produto.
     * 
     * @return A URL da imagem do produto.
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * Define a URL da imagem do produto.
     * 
     * @param imagem A URL da imagem do produto.
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    } 
}
