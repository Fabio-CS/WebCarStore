/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karen
 */
public class FrontController extends HttpServlet {

    Hashtable comandos;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        comandos = new Hashtable();
        comandos.put("trataLogin", "controle.TrataLogin");
        comandos.put("trataCadastroUsuario", "controle.TrataCadastroUsuario");
        comandos.put("trataListaUsuarios", "controle.TrataListaUsuarios");
        comandos.put("trataExcluirUsuario", "controle.TrataExcluirUsuario");
        comandos.put("trataEditarUsuario", "controle.TrataEditarUsuario");
        comandos.put("trataCadastroMarca","controle.TrataCadastroMarca");
        comandos.put("trataCadastroModelo","controle.TrataCadastroModelo");
        comandos.put("trataCadastroRevenda","controle.TrataCadastroRevenda");
        comandos.put("trataEditarRevenda","controle.TrataEditarRevenda");
        comandos.put("trataExcluirRevenda","controle.TrataExcluirRevenda");
        comandos.put("trataCadastroVeiculo","controle.TrataCadastroVeiculo");
        comandos.put("trataCadastroItem","controle.TrataCadastroItem");
        comandos.put("trataExcluirVeiculo","controle.TrataExcluirVeiculo");
        comandos.put("trataEditarVeiculo","controle.TrataEditarVeiculo");
        comandos.put("trataExcluirAnuncio", "controle.TrataExcluirAnuncio");
        comandos.put("trataCadastroAnuncio", "controle.TrataCadastroAnuncio");
        comandos.put("trataEditarAnuncio", "controle.TrataEditarAnuncio");

        
        //Acrescentar o mapeamento para as outras classes

        //Recupera o contexto da aplicação para inicializar o banco de dados
        try {
            ServletContext context = getServletContext();
            String user = (String) context.getInitParameter("user");
            String senha = (String) context.getInitParameter("senha");
            String driver = (String) context.getInitParameter("driver");
            String url = (String) context.getInitParameter("url");

            new DBConnection(user, senha, driver, url);

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cmd = request.getParameter("cmd");
        String actionClass = (String) comandos.get(cmd);
        try {
            //Cria a instância da classe utilizando introspecção
            Comando action = (Comando) Class.forName(actionClass).newInstance();
            action.setRequest(request);
            action.setResponse(response);
            action.setServletContext(getServletContext());
            action.execute();
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP
         * <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response
        )
            throws ServletException
        , IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP
         * <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response
        )
            throws ServletException
        , IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>
    }
