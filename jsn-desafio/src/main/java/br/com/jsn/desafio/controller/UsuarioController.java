package br.com.jsn.desafio.controller;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jsn.desafio.dto.ProjetoDto;
import br.com.jsn.desafio.entity.Usuario;
import br.com.jsn.desafio.service.UsuarioService;
import br.com.jsn.desafio.util.DtoUtil;

@Component
@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UsuarioService usuarioService;

    
    
    private Usuario usuario =new Usuario() ;

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



      public String criarUsuario() {
        try {
            
            this.usuarioService.criar(this.usuario);
            
            usuario = new Usuario();
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace(); 
            return "erro"; 
        }
    }
      

    public String listarProjeto(Usuario u){

        this.usuarioService.buscar(u.getId());
         return "list_projeto.xhtml";
    }

    public String editarUsuario(Usuario u){
     
        try{
            this.usuarioService.editar(u);
                          
            return  "editar_usuario.xhtml";
    
        } catch (Exception e) {
            e.printStackTrace(); 
            return "erro"; 
        }
    }

    public String excluirUsuario(Usuario u){
       
        try{

        Integer resultado = this.usuarioService.excluir(u);
        if(resultado == 1){
            return "index?faces-redirect=true";
        }
        return  "list_usuarios.xhtml";
        }catch(Exception e){
            e.printStackTrace(); 
            return "erro";
        }
    }
 
    public String atualizar(){
        this.usuarioService.editar(this.usuario);
        return "index?faces-redirect=true";
    }

}