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
import model.bean.Produtos;

/**
 * Classe responsável por acessar e manipular dados relacionados aos produtos no banco de dados.
 * 
 * Essa classe realiza operações como cadastrar um novo produto, listar todos os produtos e buscar produtos por nome, descrição ou categoria.
 * 
 * Utiliza a classe Conexao para estabelecer a conexão com o banco de dados.
 * 
 * A tabela no banco de dados deve se chamar 'produtos' e possuir as colunas 'id_produto', 'categoria', 'nome', 'valor', 'descricao' e 'imagem'.
 * 
 * @author aluno
 */
public class ProdutosDAO {
    
    /**
     * Método para cadastrar um novo produto no banco de dados.
     * 
     * @param p O objeto do tipo Produtos contendo as informações do produto a ser cadastrado.
     */
    public void cadastrarProduto(Produtos p) {
        try {
            // Estabelecendo conexão com o banco de dados
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            // Preparando e executando a query SQL para inserir o novo produto
            stmt = conexao.prepareStatement("INSERT INTO produtos (categoria, nome, valor, descricao, imagem) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getCategoria());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getValor());
            stmt.setString(4, p.getDescricao());
            stmt.setString(5, p.getImagem());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            // Tratamento de exceção caso ocorra algum erro de SQL
            e.printStackTrace();
        }
    }
    
    /**
     * Método para listar os produtos cadastrados no banco de dados.
     * 
     * @return Uma lista de objetos do tipo Produtos, representando todos os produtos cadastrados.
     */
    public List<Produtos> listarProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Estabelecendo conexão com o banco de dados
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM produtos LIMIT 10");
            rs = stmt.executeQuery();

            // Iterando sobre o resultado da consulta e populando a lista de produtos
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setValor(rs.getFloat("valor"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }
            
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            // Tratamento de exceção caso ocorra algum erro de SQL
            e.printStackTrace();
        }

        return produtos;
    }
    
    /**
     * Método para buscar produtos por nome ou descrição.
     * 
     * @param busca A string contendo o termo de busca.
     * @return Uma lista de objetos do tipo Produtos que correspondem à busca.
     */
    public List<Produtos> buscaProdutos(String busca) {
        List<Produtos> resultadoBusca = new ArrayList();

        try {
            // Estabelecendo conexão com o banco de dados
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            // Preparando e executando a query SQL para buscar produtos por nome ou descrição
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? OR descricao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            
            rs = stmt.executeQuery();
            
            // Iterando sobre o resultado da consulta e populando a lista de produtos
            while(rs.next()) {
                Produtos prod = new Produtos();
                prod.setIdProduto(rs.getInt("id_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setCategoria(rs.getInt("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getFloat("valor"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            // Tratamento de exceção caso ocorra algum erro de SQL
            e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    /**
     * Método para buscar produtos por categoria.
     * 
     * @param categoria O identificador da categoria.
     * @return Uma lista de objetos do tipo Produtos que correspondem à categoria especificada.
     */
    public List<Produtos> buscaCategoria (int categoria) {
        List<Produtos> resultadoBusca = new ArrayList();

        try {
            // Estabelecendo conexão com o banco de dados
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            // Preparando e executando a query SQL para buscar produtos por categoria
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria = ?");
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
            
            // Iterando sobre o resultado da consulta e populando a lista de produtos
            while(rs.next()) {
                Produtos prod = new Produtos();
                prod.setIdProduto(rs.getInt("id_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setCategoria(rs.getInt("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getFloat("valor"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            // Tratamento de exceção caso ocorra algum erro de SQL
            e.printStackTrace();
        }
        return resultadoBusca;
    }

  }
