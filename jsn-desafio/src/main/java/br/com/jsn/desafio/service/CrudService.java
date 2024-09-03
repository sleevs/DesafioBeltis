package br.com.jsn.desafio.service;

import java.util.List;

import br.com.jsn.desafio.entity.Projeto;

public interface CrudService<E> {
    

    public E criar(E o);

    public E editar(E o);

    public Integer excluir(E o);

    public E buscar(Integer param);

     public E costruirEsalvar(E o) ;

     public boolean validar(E o);
}
