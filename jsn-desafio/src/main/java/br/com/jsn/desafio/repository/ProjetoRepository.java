package br.com.jsn.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jsn.desafio.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto,Long> {
    


    @Query(value="SELECT * FROM projeto p WHERE p.projeto_id=?1", nativeQuery=true)
    public Projeto buscarProjetoPorId(Integer id);



    @Query(value="SELECT * FROM projeto p WHERE p.usuario_id=?1", nativeQuery=true)
    public List<Projeto> buscarProjetosPorUsuario(Integer id);
}

