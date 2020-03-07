package com.stefanini.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Eduardo Alves
 *
 */
@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable{

	
	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_perfil_co_seq_perfil" )
	@SequenceGenerator(name="seq_tb_perfil_co_seq_perfil", sequenceName = "seq_tb_perfil_co_seq_perfil", allocationSize = 20)
	@Column(name = "CO_SEQ_PERFIL")
	private Long id;
	/**
	 * Nome da pessoa
	 */
	@NotNull
	@Column(name = "NO_PERFIL")
	private String perfil;
	
	/**
	 * Email da Pessoa
	 */
	@NotNull
	@Column(name = "DS_PERFIL")
	private String descricao;
	/**
	 * Data de Nascimento 
	 */
	@NotNull
	@Column(name = "DT_HORA_INCLUSAO")
	private LocalDate dataInclusao; 
	/**
	 * Situacao da Pessoa
	 */
	@Column(name = "DT_HORA_ALTERACAO")
	private LocalDate dataAlteracao;

	/**
	 * Metodo construtor da classe
	 */
	public Perfil() {
	}

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param perfil
	 * @param descricao
	 * @param dataInclusao
	 * @param dataAlteracao <- NÃO É OBRIGATÓRIA
	 */
	public Perfil(@NotNull String perfil, @NotNull String descricao, @NotNull LocalDate dataInclusao) {
		super();
		this.perfil = perfil;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPerfil() {
		return perfil;
	}



	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public LocalDate getDataInclusao() {
		return dataInclusao;
	}



	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}



	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}



	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Perfil [id=" + id + ", perfil=" + perfil + ", descricao=" + descricao + ", dataInclusao=" + dataInclusao
				+ ", dataAlteracao=" + dataAlteracao + "]";
	}
	

}
