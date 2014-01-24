/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
/**
 *
 * @author Saturno
 */
public class DBConnection {
    private static String user;
    private static String password;
    private String driver;
    private static String url;
    private static Connection conexao;
    
    public DBConnection(String user, String senha, String driver, String url) throws ClassNotFoundException {
        DBConnection.user = user;
        DBConnection.password = senha;
        this.driver = driver;
        this.url = url;
        Class.forName(driver); //carrega o drive. Pode gerar ClassNotFoundException
    }
    
    public static Connection getInstance() throws SQLException{
         if (conexao == null) {
            openConnection();
        }
        return conexao;
    }

    private static void openConnection() throws SQLException{ 
        conexao = DriverManager.getConnection(url, user, password); // abre a conex�o para esta URL usando o driver carregado na linha anterior   
    }

    /**
     * M�todo que fecha a conex�o.
     * @throws java.sql.SQLException Exce��o gerada em caso de problema no momento de encerrar a conex�o
     */
    public static void closeConnection() throws SQLException {
        if (conexao != null) {
            conexao.close();
            conexao = null;
        }
    }
}
