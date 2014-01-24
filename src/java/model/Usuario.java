/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private int permissao; //Testaremos a permissão pelo número: 1-administrador, 2-gerente, 3-vendedor, 4-cliente.
    private Revenda revenda;
    private int ativo;
    private long celular;
    private long telefone;

    public Usuario() {
    }

    public Usuario(int id, String nome, String login, String senha, int permissao, Revenda revenda, int ativo, long celular, long telefone) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.permissao = permissao;
        this.revenda = revenda;
        this.ativo = ativo;
        this.celular = celular;
        this.telefone = telefone;
    }


    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public int getPermissao() {
        return permissao;
    }


    public Revenda getRevenda() {
        return revenda;
    }

    public String getSenha() {
        return senha;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    

    @Override
    public String toString() {
        return ("Id = " + id + "\nNome = " + nome + "\n Login = " + login + "\n Senha = " + senha);
        /*Alterar de acordo com a implementação do HTML*/
    }
    
    
    
}
