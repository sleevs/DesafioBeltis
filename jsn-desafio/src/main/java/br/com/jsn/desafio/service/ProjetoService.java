package br.com.jsn.desafio.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jsn.desafio.entity.Projeto;
import br.com.jsn.desafio.entity.Usuario;
import br.com.jsn.desafio.repository.ProjetoRepository;
import br.com.jsn.desafio.repository.UsuarioRepository;
import br.com.jsn.desafio.util.DateUtil;

@Service("projetoService")
@Transactional
public class ProjetoService implements CrudService<Projeto> {
      

        private static final Logger logger =  Logger.getLogger(ProjetoService.class.getName());

        @Autowired
        private ProjetoRepository projetoRepository;

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Override
        public Projeto criar(Projeto o) {
            
            try{
            
                Projeto novoProjeto = costruirEsalvar(o);
                if(novoProjeto != null){
                    
                    return novoProjeto;
                    }
                }catch(Exception e){
                    e.getMessage();
                    logger.log(Level.SEVERE,  "Erro ao tentar criar Projeto : " + o , e);
    
                }
                logger.log(Level.INFO,  "Projeto não foi registrado : " + o);
    
                return null ;
        }

        

        @Override
        public Projeto editar(Projeto o) {


            try{
               
                if (o.getId() == null ||  o.getId() <= 0) {
                    logger.log(Level.INFO,  "Número do Projeto informado é inválido : " + o.getId());
                    return  null;
                    }
                   
                    Projeto projeto =  projetoRepository.buscarProjetoPorId(o.getId());

                    if(projeto != null){

                    return costruirEatualizar(projeto,o);

                    }
                }catch(Exception e){
                    e.getMessage();
                    logger.log(Level.SEVERE,  "Erro ao tentar buscar Projeto número : " + o.getId() , e);
    
                }
                logger.log(Level.INFO,  "Projeto não encontrado : " + o.getId());
    
                return null ;
            }
        

        @Override
        public Integer excluir(Projeto o) {
            try{
                if (o.getId() == null ||  o.getId() <= 0) {
                    logger.log(Level.INFO,  "O número do Projeto informado é inválido : " + o.getId());
                    return  null;
                    }
                    Projeto projeto =  projetoRepository.buscarProjetoPorId(o.getId());
                    if(projeto != null){
                        projetoRepository.delete(projeto);
                    return 1;
                    }
                }catch(Exception e){
                    e.getMessage();
                    logger.log(Level.SEVERE,  "Erro ao tentar deletar o Projeto número : " + o.getId() , e);
    
                }
                logger.log(Level.INFO,  "Projeto não foi encontrado : " + o);
    
                return 0 ;
        }


 
       
        @Override
        public Projeto buscar(Integer param) {
            try{
            if (param == null ||  param <= 0) {
                logger.log(Level.INFO,  "Número do Projeto informado é inválido : " + param);
                return  null;
                }
                Projeto projeto =  projetoRepository.buscarProjetoPorId(param);
                if(projeto != null){
                return projeto;
                }
            }catch(Exception e){
                e.getMessage();
                logger.log(Level.SEVERE,  "Erro ao tentar buscar Projeto número : " + param , e);

            }
            logger.log(Level.INFO,  "Projeto não encontrado : " + param);

            return null ;
        }


        public List<Projeto> listarProjetosPorUsuarioId(Integer usuarioId) {
            try{
            if (usuarioId == null ||  usuarioId <= 0) {
                logger.log(Level.INFO,  "Número do Usuário informado é inválido : " + usuarioId);
                return  null;
                }
                List<Projeto> projetos =  projetoRepository.buscarProjetosPorUsuario(usuarioId);
                if(projetos.size() >= 0){
                return projetos;
                }
            }catch(Exception e){
                e.getMessage();
                logger.log(Level.SEVERE,  "Erro ao tentar buscar Projetos com ID Usuário número : " + usuarioId , e);

            }
            logger.log(Level.INFO,  "Nenhum Projeto foi encontrado : " + usuarioId);

            return null ;
        }



    @Override
    public boolean validar(Projeto projeto) {
        if (projeto.getTitulo() == null || projeto.getTitulo().trim().isEmpty()) {
     
            logger.log(Level.INFO,  "O título do projeto não pode ser vazio.");
            return false;
        }

        if (projeto.getDescricao() == null || projeto.getDescricao().trim().isEmpty()) {
           
            logger.log(Level.INFO,  "A descrição do projeto não pode ser vazia.");
            return false;
        }

        if (projeto.getData() == null ) {
           
            logger.log(Level.INFO,  "A Data do projeto não pode ser vazia.");
            return false;
        }

        if (usuarioExiste(projeto.getUsuario()) != true) {
            logger.log(Level.INFO,  "O usuário com o ID fornecido não existe.");
            return false;
        }

        return true;
    }

    private boolean usuarioExiste(Integer usuarioId) {
        Usuario usuario = usuarioRepository.buscarUsuarioPorId(usuarioId);
        if(usuario != null){
            return true;
        }
        return false;
    }

    @Override
    public Projeto costruirEsalvar(Projeto p) {

        if(validar(p)== true){

        Projeto projeto = new Projeto();
        projeto.setData(p.getData());
        projeto.setTitulo(p.getTitulo());
        projeto.setDescricao(p.getDescricao());
        projeto.setUsuario(p.getUsuario());
        return projetoRepository.save(projeto);
        }
        return null;

       
    }

    public Projeto costruirEatualizar(Projeto antigo, Projeto novo ) {

        if(novo.getData() != null){
            antigo.setData(novo.getData());
        }
        if(novo.getTitulo() != null){
            antigo.setTitulo(novo.getTitulo());
        }
        if(novo.getDescricao() != null){
            antigo.setDescricao(novo.getDescricao());
        }
        if(novo.getUsuario() != null){
            antigo.setUsuario(novo.getUsuario());
        }
        return projetoRepository.save(antigo);
            
    }



    }
