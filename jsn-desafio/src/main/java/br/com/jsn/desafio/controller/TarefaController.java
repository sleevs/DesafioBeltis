package br.com.jsn.desafio.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jsn.desafio.entity.Tarefa;
import br.com.jsn.desafio.service.TarefaService;


@Component
@ManagedBean(name = "tarefaController")
@SessionScoped
public class TarefaController implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Autowired
    private TarefaService tarefaService;

    private Tarefa tarefa = new Tarefa();

    List<Tarefa> tarefas ;

    public void listar(){
        this.tarefas = tarefaService.listarTarefasPorProjeto(tarefa.getProjeto());
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }




      public String criarTarefa() {
        try {
          
               this.tarefaService.criar(tarefa);
         
            tarefa = new Tarefa();
            return "sucesso"; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return "erro";
        }
    }

    public String editarTarefa(Tarefa tarefa){
        try {
          
            this.tarefaService.editar(tarefa);
      
       
         return "sucesso"; 
     } catch (Exception e) {
         e.printStackTrace(); 
         return "erro";
     }
 }

    public String excluirTarefa(Tarefa tarefa){
        try {
          
        Integer resultado = this.tarefaService.excluir(tarefa);
        if(resultado == 1){
            return  "index?faces-redirect=true";
                }else{
                    return  "list_projetos.xhtml";
                }
     } catch (Exception e) {
         e.printStackTrace(); 
         return "erro";
     }
 }


 public String atualizar(){
    this.tarefaService.editar(this.tarefa);
    return "index?faces-redirect=true";
}

    
}
