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
public class TrataEditarRevenda extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");
            
            int id_revenda = Integer.parseInt(getRequest().getParameter("id_revenda"));
            long cnpj = Long.parseLong(getRequest().getParameter("revenda_cnpj_cad"));
            String nome = getRequest().getParameter("revenda_nome_cad");
            String endereco = getRequest().getParameter("revenda_end");
            long numero = Long.parseLong(getRequest().getParameter("revenda_nro"));
            String bairro = getRequest().getParameter("revenda_bairro");
            String cidade = getRequest().getParameter("revenda_cidade");
            String estado = getRequest().getParameter("revenda_uf");
            long telefone = Long.parseLong(getRequest().getParameter("revenda_telefone_cad"));
            String email = getRequest().getParameter("revenda_mail_cad");
            int ativo = Integer.parseInt(getRequest().getParameter("revenda_ativo_cad"));
            
            Revenda edit = new Revenda(nome, email, endereco, ativo, cidade, estado, bairro, telefone, cnpj, ativo);
            edit.setId(id_revenda);
            RevendaDAO admin = new RevendaDAO();
            String msg = "";
            if (admin.editar(edit)) {
                msg = "Editado com sucesso!";
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
