/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.VeiculoDAO;
import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;


public class TrataListaCombustivel extends Comando {

    public TrataListaCombustivel() 
            throws ServletException, IOException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            ArrayList lista = new VeiculoDAO().pesquisarCombustiveis();
            HttpSession session = getRequest().getSession(true);
            session.setAttribute("listaCombustiveis", lista);
            
        } catch (IOException ioex) {
            throw new ServletException(ioex);
        } catch(SQLException sqlex){
              throw new ServletException (sqlex);
        }
    }

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
