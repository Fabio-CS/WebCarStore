/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fabio-CS
 */
public class Status {
    private int idStatus;
    private String descricao;

    public Status() {
    }

    public Status(int idStatus, String descricao) {
        this.idStatus = idStatus;
        this.descricao = descricao;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}