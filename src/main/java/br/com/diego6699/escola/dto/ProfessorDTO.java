package br.com.diego6699.escola.dto;

import java.io.Serializable;

import br.com.diego6699.escola.entities.Professor;

public class ProfessorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public ProfessorDTO() {
		super();
	}

	// request somente de Professor
	public ProfessorDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// response somente de Professor
	public ProfessorDTO(Professor Professor) {
		this(Professor.getId(), Professor.getName());
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