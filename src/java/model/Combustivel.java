/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonas
 */
public class Combustivel {
    int idCombustivel;
    String nome; 

    public Combustivel() {
    }      

    public int getIdCombustivel() {
        return idCombustivel;
    }

    public String getNome() {
        return nome;
    }

    public void setIdCombustivel(int idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
