package br.com.diego6699.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diego6699.escola.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
