package br.com.diego6699.escola.dto;

import java.io.Serializable;

import br.com.diego6699.escola.entities.Aluno;

public class AlunoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public AlunoDTO() {
		super();
	}

	// request somente de aluno
	public AlunoDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// response somente de aluno
	public AlunoDTO(Aluno aluno) {
		this(aluno.getId(), aluno.getName());
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}