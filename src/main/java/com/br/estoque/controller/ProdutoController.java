package com.br.estoque.controller;

import com.br.estoque.model.Produto;
import com.br.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController	
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//Rota para buscar todos os produtos
	@GetMapping
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	//Rota para buscar produto por ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Rota para cadastrar um novo produto
	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody Produto produto){
		Produto produtoSalvo = produtoRepository.save(produto);
		return ResponseEntity.status(201).body(produtoSalvo);
	}
	
	//Rota para atualizar um produto existente
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar (@PathVariable Long id, @RequestBody Produto produtoAtualizado){
		return produtoRepository.findById(id)
				.map(produtoExistente -> {
					produtoExistente.setNome(produtoAtualizado.getNome());
					produtoExistente.setDescricao(produtoAtualizado.getDescricao());
					produtoExistente.setPreco(produtoAtualizado.getPreco());
					produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());
					Produto produtoSalvo = produtoRepository.save(produtoExistente);
					
					return ResponseEntity.ok(produtoSalvo);
						})
				.orElse(ResponseEntity.notFound().build());
	}
	

}
