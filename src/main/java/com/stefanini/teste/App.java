package com.stefanini.teste;

import java.util.Optional;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaServico;

public class App {

	@Inject
	private PessoaServico pessoaServico;
	@Inject 
	private PerfilServico perfilServico;
	@Inject EnderecoServico enderecoServico;

	public static void main(String[] args) {
		// CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
//		buscarTodos();
//		encontrar();
		salvar();
//		remover();
	}
	
	
	private void remover() {
		pessoaServico.remover(5L);
		perfilServico.remover(1L);
	}

	private void encontrar() {
		Optional<Pessoa> pessoa = pessoaServico.encontrar(5L);
		if (pessoa.isPresent()) {
			System.out.println("Pessoa encontrada");
			System.out.println(pessoa.get());
		} else {
			System.out.println("Pessoa não encontrada");
		}
		
		Optional<Perfil> perfil = perfilServico.encontrar(5L);
		if (pessoa.isPresent()) {
			System.out.println("Perfil encontrado!");
			System.out.println(perfil.get());
		} else {
			System.out.println("Perfil não encontrado");
		}
		
	}

	private void buscarTodos() {
		pessoaServico.getList().ifPresent(i -> {
			i.forEach(b -> {
				System.out.println("Pessoa: " + b);
			});
		});
		perfilServico.getList().ifPresent(i -> {
			i.forEach(b -> {
				System.out.println("Perfil: " + b);
			});
		});
		
//		System.out.println();
	}

	public void salvar() {

		//Pessoa pessoa = new Pessoa("JOAO","joaoteste123@teste.com", LocalDate.of(1995, 8, 24),true);
		//pessoa.setEmail("joaom.dev@hotmail.com");
		//pessoaServico.salvar(pessoa);
		
		//Perfil perfil = new Perfil("testeSEQ","Perfil de Testes", LocalDate.now());
		//perfilServico.salvar(perfil);
		
		Optional<Pessoa> pessoa = pessoaServico.encontrar(1L);
		
		Endereco endereco = new Endereco(pessoa.get(),"LogradouroTeste", "ComplementoTeste", "BairroTeste", "CidadeTeste", "UFTeste", "CEPTeste");
		enderecoServico.salvar(endereco);

	}

}
