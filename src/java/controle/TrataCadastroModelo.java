  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import model.*;
import dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karen
 */
public class TrataCadastroModelo extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html"); 
            
            HttpSession session = getRequest().getSession(false);          
            String modelo = getRequest().getParameter("veiculo_modelo_cad"); 
            int marca = Integer.parseInt(getRequest().getParameter("veiculo_marca_select"));
            
            Veiculo veiculo = new Veiculo();
            veiculo.setModelo(modelo);
            veiculo.setIdMarca(marca);
                        
            String msg = "";
            VeiculoDAO veic = new VeiculoDAO();
            if (veic.inserirModelo(veiculo)) {
                msg = "Inserido com sucesso!";
               
            }
            
            else{
                msg = "Erro na inserção";
            }
            
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse()); 

            
           // getResponse().sendRedirect("/WEB-INF/cms_admin.jsp");  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } 
    }

}
