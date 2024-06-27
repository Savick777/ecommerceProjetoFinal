/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


public class Produtos {
    private int idProduto;
    
    private int categoria;
    private String nome;
    private float valor;
    private String descricao;
    private String imagem;

   
    public Produtos() {
    }

    /**
     * 
     * @param idProduto 
     * @param categoria 
     * @param nome 
     * @param valor 
     * @param descricao 
     * @param imagem 
     */
    public Produtos(int idProduto, int categoria, String nome, float valor, String descricao, String imagem) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    /*
     * @return 
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     
     * @param idProduto 
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
    
     * @return 
     */
    public int getCategoria() {
        return categoria;
    }

    /**
    
     * @param categoria 
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
      
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
      @return 
     */
    public float getValor() {
        return valor;
    }

    /**
      @param valor 
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
      @return 
     */
    public String getDescricao() {
        return descricao;
    }

    /**
      @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return 
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param imagem 
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    } 
}
