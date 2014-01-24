    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Anuncio {
    private int id;
    private Veiculo veiculo;
    private String data_inicio;
    private int status;
    private double valor_anuncio;
    private int destaque;
    private Revenda revenda;
    
    public Anuncio(){
    }
    
    public Anuncio(Veiculo veiculo, String data_inicio, int status, double valor_anuncio, int destaque, Revenda revenda) {
        this.veiculo = veiculo;
        this.data_inicio = data_inicio;
        this.status = status;
        this.valor_anuncio = valor_anuncio;
        this.destaque = destaque;
        this.revenda = revenda;
    }

    public Anuncio(int id, Veiculo veiculo, String data_inicio, int status, double valor_anuncio, int destaque, Revenda revenda) {
        this.id = id;
        this.veiculo = veiculo;
        this.data_inicio = data_inicio;
        this.status = status;
        this.valor_anuncio = valor_anuncio;
        this.destaque = destaque;
        this.revenda = revenda;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getValor_anuncio() {
        return valor_anuncio;
    }

    public void setValor_anuncio(double valor_anuncio) {
        this.valor_anuncio = valor_anuncio;
    }

    public int getDestaque() {
        return destaque;
    }

    public void setDestaque(int destaque) {
        this.destaque = destaque;
    }

    public Revenda getRevenda() {
        return revenda;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }

    @Override
    public String toString() {
        return super.toString();
        //Sobrescrever toString depois;
    }
    
    
}
