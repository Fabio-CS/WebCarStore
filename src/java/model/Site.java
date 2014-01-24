/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Site {
    private int id;
    private Anuncio[] anuncios;
    private Revenda revenda;
    private Template template;

    public Site() {
    }

    public Site(Anuncio[] anuncios, Revenda revenda, Template template) {
        this.anuncios = anuncios;
        this.revenda = revenda;
        this.template = template;
    }

    public Anuncio[] getAnuncios() {
        return anuncios;
    }

    public int getId() {
        return id;
    }

    public Revenda getRevenda() {
        return revenda;
    }

    public Template getTemplate() {
        return template;
    }

    public void setAnuncios(Anuncio[] anuncios) {
        this.anuncios = anuncios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
