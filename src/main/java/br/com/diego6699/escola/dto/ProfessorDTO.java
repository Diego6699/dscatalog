package br.com.diego6699.escola.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.diego6699.escola.entities.Aluno;
import br.com.diego6699.escola.entities.Professor;

public class ProfessorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Set<AlunoDTO> alunos = new HashSet<AlunoDTO>();

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

	// response somente de Professor
	public ProfessorDTO(Professor Professor, Set<Aluno> alunos) {
		this(Professor.getId(), Professor.getName());
		alunos.forEach(al -> this.alunos.add(new AlunoDTO(al)));
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

	public Set<AlunoDTO> getAlunos() {
		return alunos;
	}

}