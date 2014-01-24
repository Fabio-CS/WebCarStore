/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author Fabio-CS
 */
public class TrataLogin extends Comando {

    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        out.println();

        String login = getRequest().getParameter("login");
        String senha = getRequest().getParameter("senha");
        String lembrar = getRequest().getParameter("lembrar");

        Usuario user = new UsuarioDAO().pesquisarLogin(login);
        if (user != null && user.getSenha().equals(senha)) {

            try {
                if (lembrar != null) {
                    Cookie cookieLogin = new Cookie("usuario", login);
                    Cookie cookieSenha = new Cookie("senha", senha);
                    cookieLogin.setMaxAge(365 * 24 * 60 * 60);
                    cookieSenha.setMaxAge(365 * 24 * 60 * 60);
                    getResponse().addCookie(cookieLogin);
                    getResponse().addCookie(cookieSenha);
                }
                HttpSession session = getRequest().getSession(true);          
                session.setAttribute("usuario", user);

                getResponse().sendRedirect("sistema.jsp");

            } catch (NullPointerException ex) {
                out.println(ex);
            }

            // Cria o objeto de sessão que irá identificar o usuário logado
            //HttpSession session = getRequest().getSession(true);
            //session.setAttribute("usuario", usuario);
            //Redireciona para outra página
            //getResponse().sendRedirect("cms_admin.jsp");
        } else {
            out.println("<h1> Ocorreu um erro durante o processo de autenticação </h1>");
            RequestDispatcher rd = getRequest().getRequestDispatcher("index.jsp");
            //rd.include(getRequest(), getResponse());
            rd.forward(getRequest(), getResponse());
        }
        out.close();

    }
}
