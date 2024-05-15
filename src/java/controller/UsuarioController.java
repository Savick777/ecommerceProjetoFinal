/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/login")) {
            processRequest(request, response);
        } else if (url.equals("/cadastrar")) {
            String nextPage = "/WEB-INF/jsp/cadastrar.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
            
        }else if (url.equals("/header")) {
            String nextPage = "/WEB-INF/jsp/header.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }else if (url.equals("/home")) {
            String nextPage = "/WEB-INF/jsp/home.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Chamada ao método doPost do UsuarioController");
        String url = request.getServletPath();
        if (url.equals("/login")) {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuarioValido = usuarioDAO.validarUsuario(usuario, senha);

            if (usuarioValido.getId_usuario() != 0){
                
                if (usuarioValido.getId_usuario() == 2) {
                    response.sendRedirect("./cadastrar");
                }
                // Usuário válido, redirecionar para página de perfil ou outra página
                // Aqui você pode configurar o redirecionamento conforme necessário
                
                response.sendRedirect("./home");
            } else {
                // Usuário inválido, redirecionar de volta para a página de login com uma mensagem de erro
                
                request.setAttribute("mensagem", "Usuário ou senha inválidos.");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher.forward(request, response);
            }
        } else if (url.equals("/cadastrar")) {
            String nome = request.getParameter("nome");
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            String cpf = request.getParameter("cpf");
            String telefone = request.getParameter("telefone");
            String dataNascimento = request.getParameter("data_nascimento");
            String tipoUsuario = request.getParameter("tipo_usuario");

            Usuario newUser = new Usuario(0, nome, usuario, senha, cpf, telefone, dataNascimento, tipoUsuario);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.inserirUsuario(newUser);

            // Redirecionar para a página de login após o cadastro
            response.sendRedirect("./login");
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}