package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import com.stefanini.util.IGenericService;

public class EnderecoServico implements IGenericService<Endereco, Long> {

	@Inject
	EnderecoDao enderecoDao;
	
	@Override
	public Endereco salvar(@Valid Endereco endereco) {

		return enderecoDao.salvar(endereco);
	
	}

	@Override
	public Endereco atualizar(@Valid Endereco endereco) {

		return enderecoDao.atualizar(endereco);
	
	}

	@Override
	public void remover(Long id) {

		enderecoDao.remover(id);
		
	}

	@Override
	public Optional<List<Endereco>> getList() {

		return enderecoDao.getList();
	
	}

	@Override
	public Optional<Endereco> encontrar(Long id) {

		return enderecoDao.encontrar(id);
	
	}
	
}