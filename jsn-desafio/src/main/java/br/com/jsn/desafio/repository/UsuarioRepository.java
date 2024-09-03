package br.com.jsn.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jsn.desafio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query(value = "SELECT * FROM usuario u WHERE u.usuario_id = ?", nativeQuery=true)
    public Usuario buscarUsuarioPorId(Integer id);
    
}

