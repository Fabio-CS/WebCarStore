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
public class TrataExcluirUsuario extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
         
            getResponse().setContentType("text/html");
            
            HttpSession session = getRequest().getSession(false);
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            
            String num = getRequest().getParameter("user_id_excluir");
            int id = Integer.parseInt(num);
            UsuarioDAO admin = new UsuarioDAO();
            Usuario user = (Usuario) admin.pesquisarChave(id);
            
            String msg = "";
            if(usuarioLogado.getPermissao()<=user.getPermissao()){
            
            if (admin.excluir(id)) {
                msg = "Excluído com sucesso!";
            }
            
            }else{
                msg = "Você não possui permissão para excluir um usuário com este nível de acesso.";
            }
            
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse()); 

         }
    }
