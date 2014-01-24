/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Revenda {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String data_cadastro;
    private int numero;
    private String cidade;
    private String estado;
    private String bairro;
    private long fone;
    private long CNPJ;
    private int ativo;

    public Revenda() {
    }

    public Revenda(int id, String nome, String email, String endereco, String data_cadastro, int numero, String cidade, String estado, String bairro, long fone, long CNPJ, int ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.data_cadastro = data_cadastro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.fone = fone;
        this.CNPJ = CNPJ;
        this.ativo = ativo;
    }
    
    public Revenda(String nome, String email, String endereco, int numero, String cidade, String estado, String bairro, long fone, long CNPJ, int ativo) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.fone = fone;
        this.CNPJ = CNPJ;
        this.ativo = ativo;
    }
    

    public int getAtivo() {
        return ativo;
    }

    public String getBairro() {
        return bairro;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public String getCidade() {
        return cidade;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getFone() {
        return fone;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;

    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setFone(long fone) {
        this.fone = fone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }    
}
