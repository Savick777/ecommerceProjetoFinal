
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Usuario;

public class UsuarioDAO {
     public Usuario validarUsuario(String usuario, String senha) {
        Usuario usuarioValido = new Usuario();
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuarioValido.setId_usuario(rs.getInt("id_usuario"));
                usuarioValido.setNome(rs.getString("nome"));
                usuarioValido.setUsuario(rs.getString("usuario"));
                usuarioValido.setSenha(rs.getString("senha"));
                usuarioValido.setCpf(rs.getString("cpf"));
                usuarioValido.setTelefone(rs.getString("telefone"));
                usuarioValido.setData_nascimento(rs.getString("data_nascimento"));
                usuarioValido.setTipo_usuario(rs.getString("tipo_usuario"));
        } 
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioValido;
    }
    
     public void inserirUsuario(Usuario usuario) {
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO usuarios (nome, usuario, senha, cpf, telefone, data_nascimento) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getData_nascimento());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void atualizarUsuario(Usuario usuario) {
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement("UPDATE usuarios SET nome = ?, usuario = ?, senha = ?, cpf = ?, telefone = ?, data_nascimento = ?, tipo_usuario = ? WHERE id_usuario = ?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getData_nascimento());
            stmt.setString(7, usuario.getTipo_usuario());
            stmt.setInt(8, usuario.getId_usuario());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void excluirUsuario(int idUsuario) {
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
}