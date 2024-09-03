package br.com.jsn.desafio.dto;


public class ProjetoDto {


    private Integer id;
   
    private String titulo;
  
    private String descricao;
  
    private String  data;
    
    private Integer usuario;

    public ProjetoDto(){}

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
        return "ProjetoDto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", data=" + data
                + ", usuario=" + usuario + "]";
    }

    
    
}
