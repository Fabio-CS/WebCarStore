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
import model.Anuncio;
import model.Revenda;
import model.Status;
import model.Veiculo;
import util.PropertiesManager;

/**
 *
 * @author Saturno
 */
public class AnuncioDAO implements InterfaceDAO {
    private HashMap dados;
    
    public AnuncioDAO() throws IOException {
    dados = new PropertiesManager("sql.properties").readPropertiesFile();
    }

    
    
    @Override
    public boolean inserir(Object obj) throws SQLException {
        Anuncio anuncio = (Anuncio) obj;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Anuncio");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, anuncio.getVeiculo().getId());
        stmt.setInt(2, anuncio.getStatus());
        stmt.setDouble(3, anuncio.getValor_anuncio());
        stmt.setInt(4, anuncio.getDestaque());
        stmt.setInt(5, anuncio.getRevenda().getId());
        stmt.execute();
        stmt.close();
        return true;
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        Integer num = (Integer) obj;
        int id = num.intValue();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Deleta.Anuncio");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return true;
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList anuncioList = new ArrayList();
        Anuncio anuncio = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Anuncio");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            anuncio = new Anuncio();
            anuncio.setId(rs.getInt("id_anuncio"));
            anuncio.setData_inicio(rs.getString("data"));
            anuncio.setStatus(rs.getInt("id_status"));
            anuncio.setDestaque(rs.getInt("destaque"));
            anuncio.setValor_anuncio(rs.getLong("valor_vendido"));
            
                int rev = rs.getInt("id_revenda");
                int vei = rs.getInt("id_veiculo");
                Revenda revenda = null;
                Veiculo veiculo = null;
            try {
                revenda = (Revenda) new RevendaDAO().pesquisarChave(rev);
                veiculo = (Veiculo) new VeiculoDAO().pesquisarChave(vei);
                
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            anuncio.setRevenda(revenda);
            anuncio.setVeiculo(veiculo);
            
            anuncioList.add(anuncio);
        }
        pstmt.close();
        return anuncioList;
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        Anuncio anuncio = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Anuncio");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, chave);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            anuncio = new Anuncio();
            anuncio.setId(rs.getInt("id_anuncio"));
            anuncio.setData_inicio(rs.getString("data"));
            anuncio.setStatus(rs.getInt("id_status"));
            anuncio.setDestaque(rs.getInt("destaque"));
            anuncio.setValor_anuncio(rs.getLong("valor_vendido"));
            
                int rev = rs.getInt("id_revenda");
                int vei = rs.getInt("id_veiculo");
                Revenda revenda = null;
                Veiculo veiculo = null;
            try {
                revenda = (Revenda) new RevendaDAO().pesquisarChave(rev);
                veiculo = (Veiculo) new VeiculoDAO().pesquisarChave(vei);
                
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            anuncio.setRevenda(revenda);
            anuncio.setVeiculo(veiculo);
        }
        pstmt.close();
        return anuncio;
    }

    @Override
    public boolean editar(Object obj) throws SQLException {
        Anuncio anuncio = (Anuncio) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Update.Anuncio");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        int id = anuncio.getVeiculo().getId();
        int status = anuncio.getStatus();
        double valor = anuncio.getValor_anuncio();
        int destaque = anuncio.getDestaque();
        int revenda = anuncio.getRevenda().getId();
        int anuncia = anuncio.getId();
        
        stmt.setInt(1, anuncio.getStatus());
        stmt.setDouble(2, anuncio.getValor_anuncio());
        stmt.setInt(3, anuncio.getDestaque());
        stmt.setInt(4, anuncio.getRevenda().getId());
        stmt.setInt(5, anuncio.getId());
        stmt.execute();
        stmt.close();
        return true;
    }
    
     public ArrayList pesquisarTudoRevenda(int chave) throws SQLException {
        ArrayList anuncioList = new ArrayList();
        Anuncio anuncio = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAllRevenda.Anuncio");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, chave);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            anuncio = new Anuncio();
            anuncio.setId(rs.getInt("id_anuncio"));
            anuncio.setData_inicio(rs.getString("data"));
            anuncio.setStatus(rs.getInt("id_status"));
            anuncio.setDestaque(rs.getInt("destaque"));
            anuncio.setValor_anuncio(rs.getLong("valor_vendido"));
            
                int rev = rs.getInt("id_revenda");
                int vei = rs.getInt("id_veiculo");
                Revenda revenda = null;
                Veiculo veiculo = null;
            try {
                revenda = (Revenda) new RevendaDAO().pesquisarChave(rev);
                veiculo = (Veiculo) new VeiculoDAO().pesquisarChave(vei);
                
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            anuncio.setRevenda(revenda);
            anuncio.setVeiculo(veiculo);
            
            anuncioList.add(anuncio);
        }
        pstmt.close();
        return anuncioList;
    }
     
     public boolean anuncioVendido(int id) throws SQLException{
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Vender.Anuncio");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeQuery();
        pstmt.close();
        return true;
     }
     
     public ArrayList pesquisarTudoStatus() throws SQLException{
        ArrayList statusList = new ArrayList();
        Status status = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Status");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            status = new Status();
            status.setIdStatus(rs.getInt("id_status"));
            status.setDescricao(rs.getString("descricao"));
            statusList.add(status);
        }
        
        pstmt.close();
        return statusList;
     }
     
     public String statusId(int id) throws SQLException{
        String desc = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Status");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            desc = rs.getString("descricao");
        }        
        pstmt.close();
        return desc;
     }
    
}
