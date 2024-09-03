package br.com.jsn.desafio;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext ;

import br.com.jsn.desafio.entity.Account;
import br.com.jsn.desafio.repository.AccountRepository;


//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
     // App.run(Application.class, args);

      ApplicationContext  context = new ClassPathXmlApplicationContext("spring.xml");

    
  
    }
}
