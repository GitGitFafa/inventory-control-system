package com.br.estoque;

import com.br.estoque.model.Produto;
import com.br.estoque.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class DataInitializer {

	
	@Bean
	CommandLineRunner initDatabase(ProdutoRepository repository) {
		return args -> {
			if (repository.count()==0) {
				
				Produto p1 = new Produto();
				p1.setNome("Pneu Aro 15");
				p1.setDescricao("Pneu radial para carros de passeio");
				p1.setPreco(350.00);
				p1.setQuantidade(20);
				
				Produto p2 = new Produto();
				p2.setNome("Óleo de Motor 5W30");
				p2.setDescricao("Óleo sintético de alta performance");
				p2.setPreco(30.00);
				p2.setQuantidade(15);
				
				Produto p3 = new Produto();
				p3.setNome("Filtro de Ar");
				p3.setDescricao("Filtro de ar do motor");
				p3.setPreco(35.00);
				p3.setQuantidade(15);
				
				repository.save(p1);
				repository.save(p2);
				repository.save(p3);
			}
		};
	}
}
