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
public class TrataCadastroUsuario extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");
            
            HttpSession session = getRequest().getSession(false);
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            
            String nome = getRequest().getParameter("user_nome_cad");
            String login = getRequest().getParameter("user_login_cad");
            String senha = getRequest().getParameter("user_senha_cad");
            int permissao = Integer.parseInt(getRequest().getParameter("user_permissao_cad"));
            int id_revenda = Integer.parseInt(getRequest().getParameter("user_revenda_cad"));
            long celular = Long.parseLong(getRequest().getParameter("user_celular_cad"));
            long telefone = Long.parseLong(getRequest().getParameter("user_telefone_cad"));
            
            Revenda revenda = (Revenda) new RevendaDAO().pesquisarChave(id_revenda);
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setLogin(login);
            user.setSenha(senha);
            user.setRevenda(revenda);
            user.setPermissao(permissao);
            user.setCelular(celular);
            user.setTelefone(telefone);
            
            String msg = "";
            if(usuarioLogado.getPermissao()<=user.getPermissao()){
            UsuarioDAO admin = new UsuarioDAO();
            if (admin.inserir(user)) {
                msg = "Inserido com sucesso!";
            }
            
            }else{
                msg = "Você não possui permissão para cadastrar um usuário com este nível de acesso.";
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
