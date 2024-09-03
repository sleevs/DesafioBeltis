package br.com.jsn.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jsn.desafio.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    


    @Query(value="SELECT * FROM tarefa t WHERE t.projeto_id=?1", nativeQuery=true)
    public List<Tarefa> buscarTarefasPorProjetoId(Integer id);




    @Query(value="SELECT * FROM tarefa t WHERE t.tarefa_id=?1", nativeQuery=true)
    public Tarefa buscarTarefaPorId(Integer id);
    
}
