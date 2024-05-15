/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 * Classe que representa uma categoria de produtos.
 * 
 * Uma categoria possui um identificador único e um nome descritivo.
 * 
 * @author aluno
 */
public class Categorias {
    // Identificador único da categoria
    private int idCategoria;
    // Nome da categoria
    private String nome;

    /**
     * Construtor padrão da classe.
     */
    public Categorias() {
    }

    /**
     * Construtor parametrizado da classe.
     * 
     * @param idCategoria O identificador único da categoria.
     * @param nome O nome descritivo da categoria.
     */
    public Categorias(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    /**
     * Obtém o identificador único da categoria.
     * 
     * @return O identificador único da categoria.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Define o identificador único da categoria.
     * 
     * @param idCategoria O identificador único da categoria.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtém o nome descritivo da categoria.
     * 
     * @return O nome descritivo da categoria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome descritivo da categoria.
     * 
     * @param nome O nome descritivo da categoria.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
