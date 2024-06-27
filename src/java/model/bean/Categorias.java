/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


public class Categorias {
    
    private int idCategoria;
   
    private String nome;

    
    public Categorias() {
    }

    /**
     * 
     * @param idCategoria 
     * @param nome 
     */
    public Categorias(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    /**
     * @return 
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria 
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return O nome descritivo da categoria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome O nome descritivo da categoria.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
