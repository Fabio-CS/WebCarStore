/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonas
 */
public class Categoria {
    int idCategoria;
    String nome;

    public Categoria() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
}
