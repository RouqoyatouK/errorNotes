package com.api.apierrornote;

import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Repository.EtatRepo;
import com.api.apierrornote.Repository.UserRepo;
import com.api.apierrornote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class ApierrornoteApplication {

	/*@Autowired
	UserService userService;
	@Autowired
	UserRepo userRepo;*/

	public static void main(String[] args) {
		//on a ajouter ApplicationContext	 ctx= pour
	 	ApplicationContext	 ctx=SpringApplication.run(ApierrornoteApplication.class, args);
	 	//
		UserRepo userRepo=ctx.getBean(UserRepo.class);

		User user1 = new User();
		user1.setIdUser(1L);
		user1.setNom("KANOUTE");
		user1.setPrenom("ROKIATOU");
		user1.setDate(new Date());
		user1.setRole("Admin");
		user1.setEmail("admin@gmail.com");
		user1.setPassword( "Admin123");

		userRepo.save(user1);
	}



}
