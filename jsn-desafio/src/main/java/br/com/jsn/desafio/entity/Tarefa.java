package br.com.jsn.desafio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "tarefa_id")
    private Integer id;
    @Column(name="tarefa_titulo")
    private String titulo;
    @Column(name="tarefa_descricao")
    private String descricao;
    @Column(name="tarefa_prioridade")
    private String prioridade;
    @Column(name="tarefa_estimativa")
    private String estimativa;
    @Column(name="projeto_id")
    private Integer projeto;

    public Tarefa(){}

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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getEstimativa() {
        return estimativa;
    }

    public void setEstimativa(String estimativa) {
        this.estimativa = estimativa;
    }

    public Integer getProjeto() {
        return projeto;
    }

    public void setProjeto(Integer projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", prioridade=" + prioridade
                + ", estimativa=" + estimativa + ", projeto=" + projeto + ", getId()=" + getId() + ", getTitulo()="
                + getTitulo() + ", getDescricao()=" + getDescricao() + ", getPrioridade()=" + getPrioridade()
                + ", getEstimativa()=" + getEstimativa() + ", getClass()=" + getClass() + ", getProjeto()="
                + getProjeto() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
    
}
