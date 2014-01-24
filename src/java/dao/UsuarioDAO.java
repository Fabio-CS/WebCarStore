/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Revenda;
import model.Usuario;
import util.PropertiesManager;

/**
 *
 * @author Saturno
 */
public class UsuarioDAO implements InterfaceDAO {

    private HashMap dados;

    public UsuarioDAO() throws IOException {
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
    }

    @Override
    public boolean inserir(Object obj) throws SQLException {
        Usuario user = (Usuario) obj;
        Connection conexao = DBConnection.getInstance();

        String sql = (String) dados.get("Insert.Usuario");

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, user.getLogin());
        stmt.setInt(2, user.getPermissao());
        stmt.setString(3, user.getNome());
        stmt.setString(4, user.getSenha());
        stmt.setLong(5, user.getCelular());
        stmt.setLong(6, user.getTelefone());
        stmt.setInt(7, user.getRevenda().getId());
        stmt.execute();
        stmt.close();
        return true;
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        Integer num = (Integer) obj;
        int id = num.intValue();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Inativa.Usuario");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return true;
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList userList = new ArrayList();
        Usuario usuario = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAllAtivos.Usuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id_usuario"));
            usuario.setLogin(rs.getString("email"));
            usuario.setPermissao(rs.getInt("id_tipo_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getInt("ativo"));
            usuario.setCelular(rs.getLong("celular"));
            usuario.setTelefone(rs.getLong("telefone"));

            int rev = rs.getInt("id_revenda");
            Revenda revenda = null;
            try {
                revenda = (Revenda) new RevendaDAO().pesquisarChave(rev);
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            usuario.setRevenda(revenda);

            userList.add(usuario);
        }



        pstmt.close();
        return userList;
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Usuario usuario = null;
        String sql = (String) dados.get("SelectById.Usuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, chave);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id_usuario"));
            usuario.setLogin(rs.getString("email"));
            usuario.setPermissao(rs.getInt("id_tipo_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getInt("ativo"));
            usuario.setCelular(rs.getLong("celular"));
            usuario.setTelefone(rs.getLong("telefone"));
            int rev = rs.getInt("id_revenda");
            Revenda revenda = null;
            try {
                revenda = (Revenda) new RevendaDAO().pesquisarChave(rev);
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            usuario.setRevenda(revenda);
        }
        pstmt.close();
        return usuario;
    }

    @Override
    public boolean editar(Object obj) throws SQLException {
        Usuario user = (Usuario) obj;
        Connection conexao = DBConnection.getInstance();

        String sql = (String) dados.get("Update.Usuario");

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, user.getLogin());
        stmt.setInt(2, user.getPermissao());
        stmt.setString(3, user.getNome());
        stmt.setString(4, user.getSenha());
        stmt.setLong(5, user.getCelular());
        stmt.setLong(6, user.getTelefone());
        stmt.setInt(7, user.getRevenda().getId());
        stmt.setInt(8, user.getId());
        stmt.execute();
        stmt.close();
        return true;
    }

    public Usuario pesquisarLogin(String login) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Usuario usuario = null;
        String sql = (String) dados.get("SelectByLogin.Usuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, login);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id_usuario"));
            usuario.setLogin(rs.getString("email"));
            usuario.setPermissao(rs.getInt("id_tipo_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getInt("ativo"));
            usuario.setCelular(rs.getLong("celular"));
            usuario.setTelefone(rs.getLong("telefone"));

            int rev = rs.getInt("id_revenda");
            Revenda revenda = null;
            try {
                revenda = (Revenda) new RevendaDAO().pesquisarChave(rev);
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            usuario.setRevenda(revenda);

        }
        pstmt.close();
        return usuario;
    }

    public String pesquisarPermissaoId(int id) throws SQLException {
        String desc = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.TipoUsuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            desc = rs.getString("descricao");
        }
        pstmt.close();
        return desc;
    }
}
