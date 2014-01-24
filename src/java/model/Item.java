/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonas
 */
public class Item {
    
    int idItem;
    String nome;

    public Item() {
    }

    public Item(int idItem, String nome) {
        this.idItem = idItem;
        this.nome = nome;
    }

    public int getIdItem() {
        return idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
