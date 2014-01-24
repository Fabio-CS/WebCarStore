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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karen
 */
public class TrataExcluirRevenda extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
         
            getResponse().setContentType("text/html");
            
            HttpSession session = getRequest().getSession(false);
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            
            String num = getRequest().getParameter("id_revenda_excluir");
            int id = Integer.parseInt(num);
            RevendaDAO admin = new RevendaDAO();
            Revenda revenda = (Revenda) admin.pesquisarChave(id);
            String msg = "";
            if(usuarioLogado.getPermissao()==1){
            if (admin.excluir(id)) {
                msg = "Revenda excluída com sucesso!";
            }
            }else{
                msg = "Você não possui permissão para excluir uma revenda com este nível de acesso.";
            }
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse());
         }
    }
