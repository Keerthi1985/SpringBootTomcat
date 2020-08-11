package com.example.SpringTomcat.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.SpringTomcat.model.Expense;
import com.example.SpringTomcat.repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;



@RestController
public class SpringTomcatController {
	
	@Autowired
    ExpenseRepository repository;

	@GetMapping("/helloTomcat")
	public String helloTom() {		
	    
		System.out.println("Hello Tomcat");
		
		/*Client client1 = ClientBuilder.newClient();
		System.out.println("setting client");
		String name = client1.target("http://springjetty:8083/jettyHello")
		        .request(MediaType.TEXT_PLAIN)
		        .get(String.class);*/
		
		getExpenseData();
		//helloEmbeddedJetty();
		
		return "Hello Tomcat Headers";
	}
	
	@GetMapping("/setExpense")
	public void setExpenseData() {
	    
		System.out.println("Set Expense");
		repository.save(new Expense("breakfast", 5));
        repository.save(new Expense("coffee", 2));
        repository.save(new Expense("New SSD drive", 200));
        repository.save(new Expense("Tution for baby", 350));
        repository.save(new Expense("Some apples", 5));
		
	}
	
	@GetMapping("/getExpenseData")
	public void getExpenseData() {
	    
		System.out.println("Get Expense");
		
		Iterable<Expense> iterator = repository.findAll();
         
        System.out.println("All expense items: ");
        iterator.forEach(item -> System.out.println(item));
         
        List<Expense> breakfast = repository.findByItem("breakfast");
        System.out.println("\nHow does my breakfast cost?: ");
        breakfast.forEach(item -> System.out.println(item));
		
	}
	
	@GetMapping("/helloEJetty")
	public void helloEmbeddedJetty() {
	    
		System.out.println("helloEmbeddedJetty");
		
		/*Client client1 = ClientBuilder.newClient();
		System.out.println("setting client");
		String name = client1.target("http://embeddedjetty:8084/normaljettyhello")
		        .request(MediaType.TEXT_PLAIN)
		        .get(String.class);*/
		
	}
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${greeting.message}")
	private String greetingMessage;
	
	@GetMapping("/welcome")
	private String welcome() {
        /*String applicationName = System.getenv().getOrDefault("SPRING_BOOT_APP_ENV_CONFIG_APP_NAME", "Hello World");
        String description = System.getenv().getOrDefault("SPRING_BOOT_APP_ENV_CONFIG_APP_DESC", "Simple Application");*/

        return String.format(welcomeMessage);
	}
	
	@GetMapping("/greeting")
	private String greeting() {
        /*String applicationName = System.getenv().getOrDefault("SPRING_BOOT_APP_ENV_CONFIG_APP_NAME", "Hello World");
        String description = System.getenv().getOrDefault("SPRING_BOOT_APP_ENV_CONFIG_APP_DESC", "Simple Application");*/

        return String.format(greetingMessage);
	}
}
