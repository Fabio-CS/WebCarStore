/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Saturno
 */
public interface InterfaceDAO {
    public boolean inserir (Object obj) throws SQLException;
    
    public boolean excluir (Object obj) throws SQLException;
    
    public ArrayList pesquisarTudo () throws SQLException;
    
    public Object pesquisarChave (int chave) throws SQLException;
    
    public boolean editar (Object obj) throws SQLException;
}
