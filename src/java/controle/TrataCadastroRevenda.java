/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RevendaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Revenda;
import model.Usuario;

/**
 *
 * @author Saturno
 */
public class TrataCadastroRevenda extends Comando{

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        
        try {
            HttpSession session = getRequest().getSession(false);
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            
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
            
            
            Revenda revenda = new Revenda(nome, email, endereco, ativo, cidade, estado, bairro, telefone, cnpj, ativo);
            RevendaDAO cadRevenda = new RevendaDAO();
            
            String msg = "";
            
            if(usuarioLogado.getPermissao()==1){
            if (cadRevenda.inserir(revenda)) {
                msg = "Inserido com sucesso!";
            }
            }else{
                msg = "Você não possui permissão para cadastrar um usuário com este nível de acesso.";
            }
            
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse()); 
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
}
