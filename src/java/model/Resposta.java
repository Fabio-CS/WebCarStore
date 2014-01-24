/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author saturno
 */
public class Resposta {
    int id_resposta;
    String resposta;
    Usuario vendedor;

    public Resposta() {
    }

    public Resposta(int id_resposta, String resposta, Usuario vendedor) {
        this.id_resposta = id_resposta;       
        this.resposta = resposta;        
        this.vendedor = vendedor;
    }
    
    public Resposta(String resposta, Usuario vendedor) {
        this.resposta = resposta;
        this.vendedor = vendedor;
    }

    public int getId_resposta() {
        return id_resposta;
    }

    public String getResposta() {
        return resposta;
    }
   

    public Usuario getVendedor() {
        return vendedor;
    }

   
    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
    

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

}
