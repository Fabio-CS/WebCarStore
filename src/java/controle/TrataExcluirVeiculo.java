/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author Fabio-CS
 */
public class TrataExcluirVeiculo extends Comando {

      
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
         
            getResponse().setContentType("text/html");
            String num = getRequest().getParameter("veiculo_id_excluir");
            int id = Integer.parseInt(num);
            VeiculoDAO admin = new VeiculoDAO();
            String msg = "";
            if (admin.excluir(id)) {
                msg = "Excluído com sucesso!";
            }else{
                msg = "Não foi possível excluir o usuário";
            }
            
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse()); 

         }
    
}
