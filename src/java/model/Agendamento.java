/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Agendamento {
    private int id;
    private Usuario cliente, vendedor;
    private String data;
    private Anuncio anuncio;

    public Agendamento() {
    }

    public Agendamento(Usuario cliente, Usuario vendedor, String data, Anuncio anuncio) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.data = data;
        this.anuncio = anuncio;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
