package br.com.jsn.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jsn.desafio.entity.Account;
import br.com.jsn.desafio.repository.AccountRepository;

@Service("accountService")
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

   

    public List<Account> listAccount(){
        
        System.out.println("------------- MUNIZ SOARES ENGENHARIA DE SOFTWARE ----------------");
        System.out.println("-------------LOG ----------------");
        System.out.println(accountRepository.listar());
        return accountRepository.findAll();
    }

  

    
}
