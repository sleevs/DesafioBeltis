package br.com.jsn.desafio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jsn.desafio.dto.ProjetoDto;
import br.com.jsn.desafio.entity.Projeto;
import br.com.jsn.desafio.service.ProjetoService;
import br.com.jsn.desafio.util.DtoUtil;

@Component
@ManagedBean(name = "projetoController")
@SessionScoped
public class ProjetoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProjetoService projetoService;

    private List<ProjetoDto> listProjetoDto ;
    private ProjetoDto projetoDto = new ProjetoDto();

    
    public void listar(){
        List<Projeto> list = projetoService.listarProjetosPorUsuarioId(projetoDto.getId());
        for(Projeto p : list){
            this.listProjetoDto.add(DtoUtil.entidadeParaDto(p));
        }
       
    }

    public ProjetoDto getProjetoDto() {
        return projetoDto;
    }

    public void setProjetoDto(ProjetoDto projetoDto) {
        this.projetoDto = projetoDto;
    }

 

    


      public String criarProjeto() {
        try {
            
            this.projetoService.criar(DtoUtil.dtoParaEntidade(projetoDto));
          
            projetoDto = new ProjetoDto();
            return "list_projeto.xhtml"; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return "erro"; 
        }
    }


    public String excluirProjeto(ProjetoDto projeto){

        try{
            Integer resultado  = this.projetoService.excluir(DtoUtil.dtoParaEntidade(projetoDto));
                      
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
    
    public String editarProjeto(ProjetoDto projeto){

        try{
        this.projetoService.editar(DtoUtil.dtoParaEntidade(projetoDto));
                      
        return  "editar_projeto.xhtml";

    } catch (Exception e) {
        e.printStackTrace(); 
        return "erro"; 
    }
}




public String atualizar(){
    this.projetoService.editar(DtoUtil.dtoParaEntidade(this.projetoDto));
    return "index?faces-redirect=true";
}

    
    
}
