package br.com.jsn.desafio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jsn.desafio.entity.Account;
import br.com.jsn.desafio.repository.AccountRepository;
import br.com.jsn.desafio.service.AccountService;

@Component
@ManagedBean(name = "accountManager")
@SessionScoped
public class AccountManager {

    @Autowired
    private AccountService accountService;
    
   
    private List<Account> listAccounyts;

    public List<Account> getListAccounyts() {
        return listAccounyts;
    }

    public void setListAccounyts(List<Account> listAccounyts) {
        this.listAccounyts = listAccounyts;
    }

    
    public void list(){
        System.out.println("---- ACCOUNT MANAGER BEAN ----");
        System.out.println(accountService.listAccount());
        this.listAccounyts = accountService.listAccount();
    }
}
