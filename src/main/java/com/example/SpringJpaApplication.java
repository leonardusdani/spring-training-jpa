package com.example;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@SpringBootApplication
public class SpringJpaApplication {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx){
		return args -> {
			Employee employee = new Employee();
			employee.setFirstName("Bintoro");
			employee.setLastName("Adi");
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date sqlDate = new Date(df.parse("11-12-1992").getTime());
			employee.setDob(sqlDate);
			employee.setGender("male");
			employeeRepository.save(employee);
			
			Employee employee1 = new Employee();
			employee1.setFirstName("Steven");
			employee1.setLastName("Indra");
			DateFormat df1 = new SimpleDateFormat("MM-dd-yyyy");
			Date sqlDate1 = new Date(df1.parse("03-01-1993").getTime());
			employee1.setDob(sqlDate1);
			employee1.setGender("male");
			employeeRepository.save(employee1);
		};
	}
}
