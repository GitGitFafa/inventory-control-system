package com.br.estoque.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable()) //Desabilita o csrf para permitir requisições POST/PUT/DELETE de ferramentas externas como o Insomnia
			.authorizeHttpRequests(auth -> auth
			.anyRequest().permitAll() //Libera todas as rotas sem exigir senha
			);
		return http.build();
	}
	
}
