/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.Produtos;
import model.dao.ProdutosDAO;
import javax.servlet.annotation.MultipartConfig;
import model.bean.Categorias;
import model.dao.CategoriasDAO;



@MultipartConfig

public class ProdutosController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response CategoriasDAO categoriasDAO = new CategoriasDAO();
        
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProdutosDAO produtosDAO = new ProdutosDAO();
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        
        
        List<Categorias> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        
       
        String url = request.getServletPath();
        
        
        if(url.equals("/cadastrarProduto")) {
            
            String nextPage = "/WEB-INF/jsp/cadastrarProduto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if(url.equals("/home")){
           
            List<Produtos> produtos = produtosDAO.listarProdutos();
            request.setAttribute("produtos", produtos);
            String nextPage = "/WEB-INF/jsp/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String  nextPage = "?WEB-INF/jsp/produtos.jsp";
            int categoriaAtual = request.getParameter("busca").equals("") ? Integer.parseInt(request.getParameter("cat")) : 0;
            String buscaAtual = request.getParameter("busca").equals("") ? "" : "%" + request.getParameter("busca")+"%";
            
            if (categoriaAtual > 0) {
                List<Produtos> produtos = produtosDAO.buscaCategoria(categoriaAtual);
                request.setAttribute("produtos", produtos);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            } else {
                List<Produtos> produtos = produtosDAO.buscaProdutos(buscaAtual);
                request.setAttribute("produtos", produtos);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }
          
        }
        
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        ProdutosDAO produtosDAO = new ProdutosDAO();
        
        
        List<Categorias> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        
        String url = request.getServletPath();
        if (url.equals("/login")) {
            processRequest(request, response);
        } else if (url.equals("/cadastrarProduto")) {
            String nextPage = "/WEB-INF/jsp/cadastrarProduto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
            
        }  else if (url.equals("/compra")) {
            String nextPage = "/WEB-INF/jsp/compra.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
            
        } else if (url.equals("/footer")) {
            String nextPage = "/WEB-INF/jsp/footer.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
            
        }
        
        else if (url.equals("/produtos")) {
            String nextPage = "/WEB-INF/jsp/produtos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/home")) {
            String nextPage = "/WEB-INF/jsp/home.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
        
        else if (url.equals("/buscar-produtos")) {
            
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if(busca.equals("")) {
               
                String categoria = request.getParameter("cat");
                List<Produtos> produtos = produtosDAO.buscaCategoria(Integer.parseInt(categoria));
                request.setAttribute("produtos", produtos);
            } else {
                
                busca = "%"+busca+"%";
                List<Produtos> produtos = produtosDAO.buscaProdutos(busca);
                request.setAttribute("produtos", produtos);
            }
            
            String nextPage = "/WEB-INF/jsp/produtos.jsp";
            int categoriaAtual = request.getParameter("busca").equals("") ? Integer.parseInt(request.getParameter("cat")) : 0;
            String buscaAtual = request.getParameter("busca").equals("") ? "" : "%" + request.getParameter("busca")+"%";
            
            if (categoriaAtual > 0) {
                List<Produtos> produtos = produtosDAO.buscaCategoria(categoriaAtual);
                request.setAttribute("produtos", produtos);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            } else {
                List<Produtos> produtos = produtosDAO.buscaProdutos(buscaAtual);
                request.setAttribute("produtos", produtos);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produtos newProduto = new Produtos();
        newProduto.setNome(request.getParameter("nome"));
        newProduto.setCategoria(Integer.parseInt(request.getParameter("categoria")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));

        
        Part filePart = request.getPart("imagem");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
        if (fileName != null && !fileName.isEmpty()) {
            
            String basePath = getServletContext().getRealPath("/") + "assets"; 
            File uploads = new File(basePath);
            if (!uploads.exists()) {
                uploads.mkdirs(); // Cria o diretório se não existir
            }
            File file = new File(uploads, fileName);

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace(); 
            }

            
            newProduto.setImagem("assets/" + fileName);
            
            request.setAttribute("imagePath", newProduto.getImagem());
        } else {
            newProduto.setImagem(null);
        }

        
        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.cadastrarProduto(newProduto);
        response.sendRedirect("./home");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
