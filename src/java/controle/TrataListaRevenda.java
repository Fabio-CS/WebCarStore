/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RevendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Saturno
 */
public class TrataListaRevenda extends Comando{
    
    public void execute()
            throws ServletException, IOException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            ArrayList listaRev = new RevendaDAO().pesquisarTudo();
            HttpSession session = getRequest().getSession(true);
            session.setAttribute("listaRevendas", listaRev);
            //Redireciona para outra página
            getResponse().sendRedirect("admin.jsp"); 
        } catch (IOException ioex) {
            throw new ServletException(ioex);
        } catch(SQLException sqlex){
              throw new ServletException (sqlex);
        }
    }
    
}
