package br.com.jsn.desafio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projeto")
public class Projeto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "projeto_id")
    private Integer id;
    @Column(name="projeto_titulo")
    private String titulo;
    @Column(name="projeto_descricao")
    private String descricao;
    @Column(name="projeto_data")
    private Date data;
    @Column(name="usuario_id")
    private Integer usuario;

    public Projeto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Projeto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", data=" + data + ", usuario="
                + usuario + ", getId()=" + getId() + ", getTitulo()=" + getTitulo() + ", getDescricao()="
                + getDescricao() + ", getData()=" + getData() + ", getUsuario()=" + getUsuario() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
