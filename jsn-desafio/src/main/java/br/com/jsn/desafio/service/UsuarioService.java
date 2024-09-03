package br.com.jsn.desafio.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.jsn.desafio.entity.Usuario;
import br.com.jsn.desafio.repository.UsuarioRepository;

@Service("usuarioService")
@Transactional
public class UsuarioService implements CrudService<Usuario> {

        private static final Logger logger =  Logger.getLogger(UsuarioService.class.getName());

        @Autowired
        private UsuarioRepository usuarioRepository;


    @Override
    public Usuario criar(Usuario o) {
         try{
            if(validar(o))
            return usuarioRepository.save(o);
            }catch(Exception e){
                e.getMessage();
                logger.log(Level.SEVERE,  "Erro ao tentar criar um usuário : " + o, e);

            }
            logger.log(Level.INFO,  "Usuário não foi registrado : " + o);
            return null ;
    }

    @Override
    public Usuario editar(Usuario o) {
        try{
            if (o.getId() == null ||  o.getId()  <= 0) {
                logger.log(Level.INFO,  "Número do Usuário informado é inválido : " + o.getId());
                return  null;
                }
               
                Usuario usuario =  usuarioRepository.buscarUsuarioPorId(o.getId());

                if(usuario != null){

                    if(o.getEmail() != null){
                        usuario.setEmail(o.getEmail());
                    }
                    if(o.getNome() != null){
                        usuario.setNome(o.getNome());
                    }
                 
                return usuarioRepository.save(usuario);

                }
            }catch(Exception e){
                e.getMessage();
                logger.log(Level.SEVERE,  "Erro ao tentar buscar Usuário número : " + o.getId() , e);

            }
            logger.log(Level.INFO,  "Usuário não encontrado : " + o.getId());

            return null ;
        }
    

    @Override
    public Integer excluir(Usuario o) {
        try{
            if (o.getId() == null ||  o.getId() <= 0) {
                logger.log(Level.INFO,  "Número do Usuário informado é inválido : " + o.getId());
                return  null;
                }
                Usuario usuario =  usuarioRepository.buscarUsuarioPorId(o.getId());
                if(usuario != null){
                    usuarioRepository.delete(usuario);
                return 1;
                }
            }catch(Exception e){
                e.getMessage();
                logger.log(Level.SEVERE,  "Erro ao tentar deletar o Usuário número : " + o.getId() , e);

            }
            logger.log(Level.INFO,  "Usuário não foi encontrado : " + o);

            return 0 ;
    }



    @Override
    public Usuario buscar(Integer param) {
        try{
            if (param == null ||  param <= 0) {
                logger.log(Level.INFO,  "Número do Usuário informado é inválido : " + param);
                return  null;
                }
                Usuario usuario =  usuarioRepository.buscarUsuarioPorId(param);
                if(usuario != null){
                return usuario;
                }
            }catch(Exception e){
                e.getMessage();
                logger.log(Level.SEVERE,  "Erro ao tentar buscar Usuário número : " + param , e);

            }
            logger.log(Level.INFO,  "Usuário não foi encontrado : " + param);

            return null ;
    }



     public Usuario costruirEsalvar(Usuario u) {

        if(validar(u)== true){

        Usuario usuario = new Usuario();
        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        return usuarioRepository.save(usuario);
        }
        return null;

       
    }

    @Override
    public boolean validar(Usuario o) {
        if (o.getNome() == null || o.getNome().trim().isEmpty()) {
     
            logger.log(Level.INFO,  "O nome do usuário não pode ser vazio.");
            return false;
        }
        if (o.getEmail() == null || o.getEmail().trim().isEmpty()) {
     
            logger.log(Level.INFO,  "O Email do usuário não pode ser vazio.");
            return false;
        }

        return true;
    }
    
}
