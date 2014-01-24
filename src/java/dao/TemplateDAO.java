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
import model.Template;
import util.PropertiesManager;

/**
 *
 * @author Fabio-CS
 */
public class TemplateDAO implements InterfaceDAO {

    private HashMap dados;
    
    public TemplateDAO() throws IOException {
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
    }

    @Override
    public boolean inserir(Object obj) throws SQLException {
        Template tpl = (Template) obj;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Template");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, tpl.getDescricao());
        stmt.setString(2, tpl.getNome());
        stmt.setString(3, tpl.getFolha_estilo());
        stmt.execute();
        stmt.close();
        return true;
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        Integer num = (Integer) obj;
        int id = num.intValue();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Deleta.Template");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return true;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList tplList = new ArrayList();
        Template template = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Template");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            template = new Template();
            template.setId(rs.getInt("id_template"));
            template.setDescricao(rs.getString("descricao"));
            template.setNome(rs.getString("nome"));
            template.setFolha_estilo(rs.getString("path"));
            tplList.add(template);
        }
        pstmt.close();
        return tplList;
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Template template = null;
        String sql = (String) dados.get("SelectById.Template");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, chave);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            template = new Template();
            template.setId(rs.getInt("id_template"));
            template.setDescricao(rs.getString("descricao"));
            template.setNome(rs.getString("nome"));
            template.setFolha_estilo(rs.getString("path"));
    }
        pstmt.close();
        return template;
 }
    @Override
    public boolean editar(Object obj) throws SQLException {
        Template tpl = (Template) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Update.Template");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, tpl.getDescricao());
        stmt.setString(2, tpl.getNome());
        stmt.setString(3, tpl.getFolha_estilo());
        stmt.setInt(4, tpl.getId());
        stmt.execute();
        stmt.close();
        return true;
    }
    
}
