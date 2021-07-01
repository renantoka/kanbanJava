package com.SEPLAG.projetoKanban;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
@Controller
public class ProjetoKanbanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoKanbanApplication.class, args);
	}
	
	@RequestMapping ("/")
	@ResponseBody
	String home() {
		return "index";
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}
