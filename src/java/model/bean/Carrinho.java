/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ariel
 */
public class Carrinho {
    
    private static List<Produtos> itens = new ArrayList<>();

    public static void adicionarItem(Produtos produto) {
        itens.add(produto);
    }
    
    public static Carrinho getOrCreateCarrinho(HttpServletRequest request) {
        Carrinho carrinho = (Carrinho) request.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new Carrinho();
            request.setAttribute("carrinho", carrinho);
        }
        return carrinho;
    }

    public static void removerItem(int index) {
        itens.remove(index);
    }

    public static List<Produtos> getItens() {
        return itens;
    }

    public static float calcularTotal() {
        float total = 0;
        for (Produtos produto : itens) {
            total += produto.getValor();
        }
        return total;
    }
}
