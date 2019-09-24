package com.ecommerce.microcommerce;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MicrocommerceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MicrocommerceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner start(ProductDao productDao) {
		 productDao.deleteAll();
		return args->{
			Product p1=new Product(1,"Ordinateur portable", 250, 170);
			Product p2=new Product(2,"Aspirateur Robot", 750, 560);
			Product p3=new Product(3,"Table de Ping Pong", 1050,450);
			productDao.save(p1);
			productDao.save(p2);
			productDao.save(p3);
		};
		
	}
}
