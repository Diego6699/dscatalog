package br.com.diego6699.escola.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.diego6699.escola.entities.Aluno;
import br.com.diego6699.escola.entities.Professor;

public class AlunoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Set<ProfessorDTO> professores = new HashSet<ProfessorDTO>();

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

	// response alunos e professoes
	public AlunoDTO(Aluno aluno, Set<Professor> professores) {
		this(aluno.getId(), aluno.getName());
		professores.forEach(prof -> this.professores.add(new ProfessorDTO(prof)));
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

	public Set<ProfessorDTO> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<ProfessorDTO> professores) {
		this.professores = professores;
	}

}