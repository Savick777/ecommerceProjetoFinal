/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ariel
 */
public class Conexao {
    
    private static String url = "jdbc:mysql://localhost:3306/senaiecommerce?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "233491";
    
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}