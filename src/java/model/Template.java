/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Template {
    private int id;
    private String folha_estilo;
    private String nome;
    private String descricao;

    public Template() {
    }

    public Template(String folha_estilo, String nome) {
        this.folha_estilo = folha_estilo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getFolha_estilo() {
        return folha_estilo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFolha_estilo(String folha_estilo) {
        this.folha_estilo = folha_estilo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
