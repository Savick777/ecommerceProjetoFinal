/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Categorias;

/**
 * Classe responsável por acessar e manipular dados relacionados às categorias no banco de dados.
 * 
 * Essa classe realiza operações de listagem de todas as categorias cadastradas.
 * 
 * Utiliza a classe Conexao para estabelecer a conexão com o banco de dados.
 * 
 * A tabela no banco de dados deve se chamar 'categorias' e possuir as colunas 'id_categoria' e 'nome'.
 * 
 * @author aluno
 */
public class CategoriasDAO {
    
    /**
     * Método para listar todas as categorias cadastradas no banco de dados.
     * 
     * @return Uma lista de objetos do tipo Categorias, representando todas as categorias cadastradas.
     */
    public List<Categorias> listarCategorias() {
        List<Categorias> categorias = new ArrayList();
        
        try {
            // Estabelecendo conexão com o banco de dados
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            // Executando a consulta SQL para selecionar todas as categorias
            stmt = conexao.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();
            
            // Iterando sobre o resultado da consulta e populando a lista de categorias
            while(rs.next()) {
                Categorias categoriaAtual = new Categorias();
                categoriaAtual.setIdCategoria(rs.getInt("id_categoria"));
                categoriaAtual.setNome(rs.getString("nome"));
                
                categorias.add(categoriaAtual);
            }
        } catch(SQLException e) {
            // Tratamento de exceção caso ocorra algum erro de SQL
            e.printStackTrace();
        }
        
        return categorias;
    }

}
