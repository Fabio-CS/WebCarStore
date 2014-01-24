/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Saturno
 */
public class Veiculo {
    private int id;
    private String nome;
    private String modelo;
    private int idModelo;
    private int ano;
    private String motor;
    private String[] opcionais;
    private String cor;
    private int idCor;
    private Combustivel combustivel;
    private int idMarca;
    private String marca;
    private double valor;
    private String[] fotos;
    private Categoria categoria;
    private double km;
    /*private Lista atributos;*/ //Reservado à outros.

    public Veiculo() {
    }

    public Veiculo(String nome, String modelo, int ano, String motor, String[] opcionais, String cor, String combustivel, String marca, double valor, String[] fotos, int categoria, double km) {
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = motor;
        this.opcionais = opcionais;
        this.cor = cor;
        this.combustivel.setNome(combustivel);
        this.marca = marca;
        this.valor = valor;
        this.fotos = fotos;
        this.categoria.setIdCategoria(categoria);
        this.km = km;
    }

    public Veiculo(int id, String nome, String modelo, int ano, String motor, String[] opcionais, String cor, String combustivel, String marca, double valor, String[] fotos, int categoria, double km) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = motor;
        this.opcionais = opcionais;
        this.cor = cor;
        this.combustivel.setNome(combustivel);
        this.marca = marca;
        this.valor = valor;
        this.fotos = fotos;
        this.categoria.setIdCategoria(categoria);
        this.km = km;
    }
    
    public void setVeiculo(Veiculo vel){
        this.setId(vel.getId());
        this.setNome(vel.getNome());
        this.setAno(vel.getAno());
        this.setCategoria(vel.getCategoria());
        this.setCor(vel.getCor());
        this.setFotos(vel.getFotos());
        this.setModelo(vel.getModelo());
        this.setOpcionais(vel.getOpcionais());
        this.setMarca(vel.getMarca());
        this.setValor(vel.getValor());
        this.setMotor(vel.getMotor());
        this.setKm(vel.getKm());
        this.setCombustivel(vel.getCombustivel());
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }    
    
    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public void setIdCor(int cor) {
        this.idCor = cor;
    }


    public void setFotos(String[] fotos) {
        this.fotos = fotos;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    
    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOpcionais(String[] opcionais) {
        this.opcionais = opcionais;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getAno() {
        return ano;
    }

    public int getIdCor() {
        return idCor;
    }
    
    public int getIdCombustivel() {
        return combustivel.getIdCombustivel();
    }

    public int getIdMarca() {
        return idMarca;
    }   

    public String getCor() {
        return cor;
    }

    public String[] getFotos() {
        return fotos;
    }

    public int getId() {
        return id;
    }

    public double getKm() {
        return km;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getIdModelo() {
        return idModelo;
    }
    
    public String getMotor() {
        return motor;
    }

    public String getNome() {
        return nome;
    }

    public String[] getOpcionais() {
        return opcionais;
    }

    public double getValor() {
        return valor;
    }

    

}
