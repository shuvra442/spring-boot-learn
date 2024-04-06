package com.firstExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * shuvra patra
 * Date: 06/04/2024
 *
 * print hello world in the serverside
 *
 * using 2 way...
 */


@SpringBootApplication
@RestController
public class SpringFirstApplication {

	public static void main(String[] args) {
		System.out.println("Hi i'm main method");
		SpringApplication.run(SpringFirstApplication.class, args);
	}

	@ResponseBody
	@GetMapping("/test")
	public String testing(){
		System.out.println("hi i'm controller ");
		return "hello world";
	}

}
