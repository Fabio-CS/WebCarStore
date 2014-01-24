/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author Fabio-CS
 */
public class TrataListaUsuario extends Comando {

    private ArrayList<Usuario> listaUsuarios;

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
                HttpSession session = getRequest().getSession(true);          
                UsuarioDAO pesquisar = new UsuarioDAO();
                ArrayList<Usuario> lista = pesquisar.pesquisarTudo();
                this.setListaUsuarios(lista);
                session.setAttribute("listaUsuarios", listaUsuarios);
    }
    
     public ArrayList<Usuario> getListaUsuarios() throws SQLException, IOException {
        return this.listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
