/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Combustivel;
import model.Cor;
import model.Item;
import model.Revenda;
import model.Usuario;
import model.Veiculo;
import util.PropertiesManager;

/**
 *
 * @author saturno
 */
public class VeiculoDAO  implements InterfaceDAO{
 private HashMap dados;
 
 public VeiculoDAO() throws IOException {
     dados = new PropertiesManager("sql.properties").readPropertiesFile();     
 }

    @Override
    public boolean inserir(Object obj) throws SQLException {
        Veiculo vel = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
             
        String call =(String) dados.get("Insert.Veiculo.Function");
        CallableStatement cstmt=conexao.prepareCall(call);
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setInt(2, vel.getIdModelo());
        cstmt.setInt(3, vel.getIdCombustivel());
        cstmt.setInt(4, vel.getCategoria().getIdCategoria());
        cstmt.setInt(5, vel.getIdCor());
        cstmt.setInt(6, vel.getAno());
        cstmt.setString(7, vel.getMotor());
        cstmt.setDouble(8, vel.getValor());
        cstmt.setDouble(9, vel.getKm());
        cstmt.executeUpdate();
        
        vel.setId(cstmt.getInt(1));
               
        cstmt.close();  
        
        String[] opcionais=vel.getOpcionais();

        for (int i = 0; i < opcionais.length; i++ ){     
        
        String sql = (String) dados.get("Insert.VeiculoItens");
        PreparedStatement stmt=conexao.prepareStatement(sql);       
        stmt.setInt(1, vel.getId());
        stmt.setString(2,opcionais[i]);
        stmt.execute();
        
        }
        //conexao.close();
        
        return true;
    }
    
    public boolean inserirMarca(Object obj) throws SQLException {
        Veiculo vel = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Marca");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, vel.getMarca());
        
        
        stmt.execute();
        //conexao.close();
        return true;
    }
    
    public boolean inserirModelo(Object obj) throws SQLException {
        Veiculo vel = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Modelo");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(2, vel.getModelo());
        stmt.setInt(1,vel.getIdMarca());
        
        stmt.execute();
        //conexao.close();
        return true;
    }
    
    public boolean inserirItem(Object obj) throws SQLException {
        Item item = (Item) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Item");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1,item.getNome());
       
        
        stmt.execute();
        stmt.close();
        return true;
    }
    
    public ArrayList pesquisarItems() throws SQLException {
        ArrayList itemList = new ArrayList();
        Item item = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Item");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            item = new Item();
            item.setNome(rs.getString("descricao"));
            item.setIdItem(rs.getInt("cod_item"));
            itemList.add(item);
        }    
            
        
        //pstmt.close();
        return itemList;
    }
    
    
    
    public ArrayList pesquisarMarcas() throws SQLException {
        ArrayList marcaList = new ArrayList();
        Veiculo veiculo = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Marca");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            veiculo = new Veiculo();
            veiculo.setMarca(rs.getString("descricao"));
            veiculo.setIdMarca(rs.getInt("id_marca"));
            marcaList.add(veiculo);
        }
            
            
        
        pstmt.close();
        return marcaList;
    }
    
    public ArrayList pesquisarModelos() throws SQLException {
        ArrayList modeloList = new ArrayList();
        Veiculo veiculo = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Modelo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            veiculo = new Veiculo();
            veiculo.setModelo(rs.getString("descricao"));
            veiculo.setIdModelo(rs.getInt("id_modelo"));
            modeloList.add(veiculo);
        }        
        
        //pstmt.close();
        return modeloList;
    }
    
    public ArrayList pesquisarCombustiveis() throws SQLException {
        ArrayList combustivelList = new ArrayList();
        Combustivel combustivel = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Combustivel");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            combustivel = new Combustivel();
            combustivel.setNome(rs.getString("descricao"));
            combustivel.setIdCombustivel(rs.getInt("cod_combustivel"));
            combustivelList.add(combustivel);
        }        
        
        pstmt.close();
        return combustivelList;
    }

     public ArrayList pesquisarCategorias() throws SQLException {
        ArrayList categoriaList = new ArrayList();
        Categoria categoria = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Categoria");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            categoria = new Categoria();
            categoria.setNome(rs.getString("descricao"));
            categoria.setIdCategoria(rs.getInt("id_categoria"));
            categoriaList.add(categoria);
        }        
        
        //pstmt.close();
        return categoriaList;
    }
     
     public ArrayList pesquisarCores() throws SQLException {
        ArrayList corList = new ArrayList();
        Cor cor = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Cor");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            cor= new Cor();
            cor.setNome(rs.getString("descricao"));
            cor.setIdCor(rs.getInt("id_cor"));
            corList.add(cor);
        }        
        
        //pstmt.close();
        return corList;
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        Integer num = (Integer) obj;
        int id = num.intValue();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Deleta.Veiculo");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return true;
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList velList = new ArrayList();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Veiculo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            Veiculo v = new Veiculo();
            v.setId(rs.getInt("id_veiculo"));
            v.setIdModelo(rs.getInt("id_modelo"));
            Combustivel fuel = new Combustivel();
            fuel.setIdCombustivel(rs.getInt("cod_combustivel"));
            fuel.setNome(this.pesquisarCombustivelId(rs.getInt("cod_combustivel")));
            v.setCombustivel(fuel);
            v.setIdCor(rs.getInt("id_cor"));
            v.setAno(rs.getInt("ano"));
            v.setMotor(rs.getString("motor"));
            v.setValor(rs.getDouble("valor"));
            v.setKm(rs.getDouble("quilometragem"));
            v.setModelo(this.pesquisarModeloId(rs.getInt("id_modelo")));
            v.setCor(this.pesquisarCorId(rs.getInt("id_cor")));
            Categoria cat = new Categoria();
            cat.setIdCategoria(rs.getInt("id_categoria"));
            cat.setNome(this.pesquisarCategoriaId(rs.getInt("id_categoria")));
            v.setCategoria(cat);
            velList.add(v);
        }
        //pstmt.close();
        return velList;
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        Veiculo veiculo = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Veiculo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, chave);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            veiculo = new Veiculo();
            veiculo.setId(rs.getInt("id_veiculo"));
            veiculo.setIdModelo(rs.getInt("id_modelo"));
            Combustivel fuel = new Combustivel();
            fuel.setIdCombustivel(rs.getInt("cod_combustivel"));
            fuel.setNome(this.pesquisarCombustivelId(rs.getInt("cod_combustivel")));
            veiculo.setCombustivel(fuel);
            Categoria cat = new Categoria();
            cat.setIdCategoria(rs.getInt("id_categoria"));
            cat.setNome(this.pesquisarCategoriaId(rs.getInt("id_categoria")));
            veiculo.setCategoria(cat);
            veiculo.setIdCor(rs.getInt("id_cor"));
            veiculo.setAno(rs.getInt("ano"));
            veiculo.setMotor(rs.getString("motor"));
            veiculo.setValor(rs.getDouble("valor"));
            veiculo.setKm(rs.getDouble("quilometragem"));
        }
        pstmt.close();
        return veiculo;
    }

    @Override
    public boolean editar(Object obj) throws SQLException {
        Veiculo veiculo = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Update.Veiculo");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, veiculo.getIdModelo());
        stmt.setInt(2, veiculo.getIdCombustivel());
        stmt.setInt(3, veiculo.getCategoria().getIdCategoria());
        stmt.setInt(4, veiculo.getIdCor());
        stmt.setInt(5, veiculo.getAno());
        stmt.setString(6, veiculo.getMotor());
        stmt.setDouble(7, veiculo.getValor());
        stmt.setDouble(8, veiculo.getKm());
        stmt.setInt(9, veiculo.getId());
        stmt.execute();
        stmt.close();
        return true;
    }
    
    public String pesquisarModeloId(int id) throws SQLException{
        String desc = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Modelo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            desc = rs.getString("descricao");
        }        
        pstmt.close();
        return desc;
    }
    
    public int pesquisarMarcaByModelo(int mod) throws SQLException{
        int id = 0;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectByModelo.Marca");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1,mod);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            id = rs.getInt("id_marca");
        }        
        pstmt.close();
        return id;
    }
    
    public String pesquisarMarcaId(int id) throws SQLException{
        String desc = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Marca");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            desc = rs.getString("descricao");
        }        
        pstmt.close();
        return desc;
    }
    
    public String pesquisarCombustivelId(int id) throws SQLException{
        String desc = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Combustivel");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            desc = rs.getString("descricao");
        }        
        pstmt.close();
        return desc;
    }
    
    public String pesquisarCorId(int id) throws SQLException{
        String desc = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Cor");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            desc = rs.getString("descricao");
        }        
        pstmt.close();
        return desc;
    }
    
    public String pesquisarCategoriaId(int id) throws SQLException{
        String desc = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Categoria");
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
