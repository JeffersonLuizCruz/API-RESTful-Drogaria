package br.com.estudos.drogaria.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
@RestController
@RequestMapping("/drogaria")
public class DrogariaController {
	
		@RequestMapping("/testar")
		public String ola() {
			return "Olá, Mundo!";
		}
	
}
