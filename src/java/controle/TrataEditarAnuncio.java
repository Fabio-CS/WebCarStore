/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AnuncioDAO;
import dao.RevendaDAO;
import dao.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Anuncio;
import model.Revenda;
import model.Usuario;
import model.Veiculo;

/**
 *
 * @author Marcos
 */
public class TrataEditarAnuncio extends Comando{

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
            getResponse().setContentType("text/html");
            
            HttpSession session = getRequest().getSession(false);
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            
            int id_veiculo = Integer.parseInt(getRequest().getParameter("veiculo_select_cad"));
            int status = Integer.parseInt(getRequest().getParameter("status_select_cad"));
            double valor_anuncio = Double.parseDouble(getRequest().getParameter("valor_anuncio_cad"));
            int destaque = Integer.parseInt(getRequest().getParameter("status_anuncio_cad"));
            int id_revenda = usuarioLogado.getRevenda().getId();

            Veiculo veiculo = (Veiculo) new VeiculoDAO().pesquisarChave(id_veiculo);
            Revenda revenda = (Revenda) new RevendaDAO().pesquisarChave(id_revenda);
            
            Anuncio edit = new Anuncio();
            //veiculo, status, valor_anuncio, destaque, revenda
            edit.setId(id_veiculo);
            edit.setVeiculo(veiculo);
            edit.setValor_anuncio(valor_anuncio);
            edit.setStatus(status);
            edit.setDestaque(destaque);
            edit.setRevenda(revenda);
            AnuncioDAO admin = new AnuncioDAO();
            String msg = "";
            if (admin.editar(edit)) {
                msg = "Editado com sucesso!";
            } else {
                msg = "Erro na edição!";
            }
            
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse());
    }
}
