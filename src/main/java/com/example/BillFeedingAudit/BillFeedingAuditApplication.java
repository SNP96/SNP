package com.example.BillFeedingAudit;

import com.example.BillFeedingAudit.Dao.ProductDao;
import com.example.BillFeedingAudit.Entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class BillFeedingAuditApplication {

	public static void main(String[] args) {

//		SpringApplication.run(BillFeedingAuditApplication.class, args);
		ApplicationContext context = SpringApplication.run(BillFeedingAuditApplication.class,args);
		System.out.println("Working");

	}



	@Bean
	public ModelMapper modelMapper(){return new ModelMapper();}

}
