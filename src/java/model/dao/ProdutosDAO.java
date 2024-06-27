
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Produtos;

 
public class ProdutosDAO {
    
    /**
     
     * @param p  
     */
    public void cadastrarProduto(Produtos p) {
        try {
             Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
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
             e.printStackTrace();
        }
    }
    
    /**
      @return  
     */
    public List<Produtos> listarProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
             conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM produtos LIMIT 10");
            rs = stmt.executeQuery();

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
             e.printStackTrace();
        }

        return produtos;
    }
    
    /**
     @param busca A string contendo o termo de busca.
     * @return Uma lista de objetos do tipo Produtos que correspondem à busca.
     */
    public List<Produtos> buscaProdutos(String busca) {
        List<Produtos> resultadoBusca = new ArrayList();

        try {
             Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
             stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? OR descricao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            
            rs = stmt.executeQuery();
            
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
             e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    /**
      @param categoria O identificador da categoria.
     * @return Uma lista de objetos do tipo Produtos que correspondem à categoria especificada.
     */
    public List<Produtos> buscaCategoria (int categoria) {
        List<Produtos> resultadoBusca = new ArrayList();

        try {
             Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
             stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria = ?");
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
            
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
             e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    public Produtos buscarProduto(int idProduto) {
        Produtos produto = new Produtos();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE  id_produto = ?");
            stmt.setInt(1, idProduto);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getFloat("valor"));
                produto.setImagem(rs.getString("imagem"));
            } else {
                produto.setIdProduto(0);
            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        
        return produto;
    }

  }
