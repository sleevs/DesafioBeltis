package br.com.jsn.desafio.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jsn.desafio.entity.Projeto;
import br.com.jsn.desafio.entity.Tarefa;
import br.com.jsn.desafio.repository.ProjetoRepository;
import br.com.jsn.desafio.repository.TarefaRepository;

@Service("tarefaService")
@Transactional
public class TarefaService implements CrudService<Tarefa>{


        private static final Logger logger =  Logger.getLogger(TarefaService.class.getName());

        @Autowired
        private TarefaRepository tarefaRepository;

        @Autowired
        private ProjetoRepository projetoRepository;

        @Override
        public Tarefa criar(Tarefa o) {
            
            try{
               
                    Tarefa novaTarefa = costruirEsalvar(o);
                    if(novaTarefa != null){
                       
                    return novaTarefa;
                    }
                }catch(Exception e){
                    e.getMessage();
                    logger.log(Level.SEVERE,  "Erro ao tentar criar Tarefa : " + o , e);
    
                }
                logger.log(Level.INFO,  "Tarefa não foi registrada : " + o);
    
                return null ;
        }

        @Override
        public Tarefa editar(Tarefa o) {
          
            try{
               
                if (o.getId() == null ||  o.getId() <= 0) {
                    logger.log(Level.INFO,  "O Número da Tarefa informado é inválido : " + o.getId());
                    return  null;
                    }
                   
                    Tarefa tarefa =  tarefaRepository.buscarTarefaPorId(o.getId());

                    if(tarefa != null){

                    return costruirEatualizar(tarefa,o);

                    }
                }catch(Exception e){
                    e.getMessage();
                    logger.log(Level.SEVERE,  "Erro ao tentar buscar Tarefa número : " + o.getId() , e);
    
                }
                logger.log(Level.INFO,  "Tarefa não foi encontrado : " + o.getId());
    
                return null ;
            }



        @Override
        public Integer excluir(Tarefa o) {
            try{
                if (o.getId() == null ||  o.getId() <= 0) {
                    logger.log(Level.INFO,  "O Número da Tarefa informado é inválido : " + o.getId());
                    return  null;
                    }
                    Tarefa tarefa =  tarefaRepository.buscarTarefaPorId(o.getId());
                    if(tarefa != null){
                        tarefaRepository.delete(tarefa);
                    return 1;
                    }
                }catch(Exception e){
                    e.getMessage();
                    logger.log(Level.SEVERE,  "Erro ao tentar deletar a Tarefa número : " + o.getId() , e);
    
                }
                logger.log(Level.INFO,  "Tarefa não foi encontrado : " + o);
    
                return 0 ;
        }



        @Override
        public Tarefa buscar(Integer param) {

            try{
                if (param == null ||  param <= 0) {
                    logger.log(Level.INFO,  "Número da Tarefa informada é inválida : " + param);
                    return  null;
                    }
                    Tarefa tarefa =  tarefaRepository.buscarTarefaPorId(param);
                    if(tarefa != null){
                    return tarefa;
                    }
                }catch(Exception e){
                    e.getMessage();
                    logger.log(Level.SEVERE,  "Erro ao tentar buscar Tarefa número : " + param , e);
    
                }
                logger.log(Level.INFO,  "O número da Tarefa não foi encontrado : " + param);
    
                return null ;
        }


        public List<Tarefa> listarTarefasPorProjeto(Integer projetoId) {
            try{
            if (projetoId == null ||  projetoId <= 0) {
                logger.log(Level.INFO,  "Número do Projeto informado é inválido : " + projetoId);
                return  null;
                }
                List<Tarefa> tarefas =  tarefaRepository.buscarTarefasPorProjetoId(projetoId);
                if(tarefas.size() >= 0){
                return tarefas;
                }
            }catch(Exception e){
                e.getMessage();
                logger.log(Level.SEVERE,  "Erro ao tentar buscar Tarefas associadas ao ID Projeto número : " + projetoId , e);

            }
            logger.log(Level.INFO,  "Nenhuma Tarefa foi encontrado : " + projetoId);

            return null ;
        }

        @Override
        public Tarefa costruirEsalvar(Tarefa o) {
            
            if(validar(o)){
                Tarefa tarefa = new Tarefa();
                tarefa.setDescricao(o.getDescricao());
                tarefa.setEstimativa(o.getEstimativa());
                tarefa.setPrioridade(o.getPrioridade());
                tarefa.setTitulo(o.getTitulo());
                tarefa.setProjeto(o.getProjeto());
                return tarefaRepository.save(tarefa);
            }
           
            return null ;
        }
        
        public Tarefa costruirEatualizar(Tarefa antigo, Tarefa nova ) {

            if(nova.getDescricao() != null){
                antigo.setDescricao(nova.getDescricao());
            }
            if(nova.getEstimativa() != null){
                antigo.setEstimativa(nova.getEstimativa());
            }
            if(nova.getPrioridade() != null){
                antigo.setPrioridade(nova.getPrioridade());
            }
            if(nova.getTitulo() != null){
                antigo.setDescricao(nova.getTitulo());
            }
            if(nova.getDescricao() != null){
                antigo.setDescricao(nova.getDescricao());
            }
            return tarefaRepository.save(antigo);
        }

        @Override
        public boolean validar(Tarefa o) {
       if (o.getTitulo() == null || o.getTitulo().trim().isEmpty()) {
     
            logger.log(Level.INFO,  "O título da tarefa não pode ser vazio.");
            return false;
        }
        if (o.getDescricao() == null || o.getDescricao().trim().isEmpty()) {
     
            logger.log(Level.INFO,  "A descrição da tarefa não pode ser vazia.");
            return false;
        }
        if (o.getPrioridade() == null || o.getPrioridade().trim().isEmpty()) {
     
            logger.log(Level.INFO,  "A prioridade da tarefa não pode ser vazia.");
            return false;
        }
        if (o.getEstimativa() == null || o.getEstimativa().trim().isEmpty()) {
     
            logger.log(Level.INFO,  "A estimativa da tarefa não pode ser vazia.");
            return false;
        }
        if (o.getProjeto() == null || o.getProjeto() <= 0) {
     
            logger.log(Level.INFO,  "O  número do projeto associado a tarefa não pode ser vazio.");
            return false;
        }
        if (projetoExiste(o.getProjeto()) != true) {
            logger.log(Level.INFO,  "O número do projeto fornecido não existe.");
            return false;
        }

        return true ;
        }



        private boolean projetoExiste(Integer projetoId) {
            Projeto projeto = projetoRepository.buscarProjetoPorId(projetoId);
            if(projeto != null){
                return true;
            }
            return false;
        }

    }


    

