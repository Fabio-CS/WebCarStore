/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AnuncioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Anuncio;
import model.Usuario;

/**
 *
 * @author Cícero
 */
public class TrataExcluirAnuncio extends Comando {

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
         
            getResponse().setContentType("text/html");
            
            String num = getRequest().getParameter("anuncio_id_excluir");
            int id = Integer.parseInt(num);
            AnuncioDAO admin = new AnuncioDAO();
            Anuncio anun = (Anuncio) admin.pesquisarChave(id);
            String msg = "";
            if (admin.excluir(id)) {
                msg = "Anúncio excluído com sucesso!";
            }
           
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse());
    }
    
}
