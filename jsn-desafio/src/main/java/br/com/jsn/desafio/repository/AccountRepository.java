package br.com.jsn.desafio.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.jsn.desafio.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {



 @Query(value="SELECT * FROM account c", nativeQuery = true)
 public List<Account> listar();

}
/*public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;



    public List<Account> findAll(){
       try{
         TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM Account a", Account.class);
        return query.getResultList();
       }catch(Exception e){
        e.getMessage();
       }
       return null ;
    }
 

    }*/