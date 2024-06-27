
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import model.bean.Categorias;
import model.bean.Usuario;
import model.dao.CategoriasDAO;
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
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        
        
        List<Categorias> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
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
        }else if (url.equals("/pedidoFinalizado")) {
            String nextPage = "/WEB-INF/jsp/pedidoFinalizado.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }else if (url.equals("/telaAdm")) {
            String nextPage = "/WEB-INF/jsp/telaAdm.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String url = request.getServletPath();
        if (url.equals("/login")) {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuarioValido = usuarioDAO.validarUsuario(usuario, senha);

            if (usuarioValido.getId_usuario() != 0){
                
                if (usuarioValido.getId_usuario() == 1) {
                    response.sendRedirect("./telaAdm");
                    return;
                }
                
                response.sendRedirect("./home");
                return;
            } else {
                
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

            response.sendRedirect("./login");
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}