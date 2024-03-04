package br.com.diego6699.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.diego6699.escola.dto.AlunoDTO;
import br.com.diego6699.escola.dto.ProfessorDTO;
import br.com.diego6699.escola.entities.Aluno;
import br.com.diego6699.escola.entities.Professor;
import br.com.diego6699.escola.repository.AlunoRepository;
import br.com.diego6699.escola.repository.ProfessorRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAllPaged(Pageable pageable) {
		Page<Aluno> list = repository.findAll(pageable);
		return list.map(x -> new AlunoDTO(x));
	}

	@Transactional(readOnly = true)
	public AlunoDTO findById(Long id) {
		//Aluno aluno = repository.getReferenceById(id);
		return new AlunoDTO(1l,"diego");
	}

	@Transactional
	public AlunoDTO insert(AlunoDTO dto) {
		Aluno entity = new Aluno();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AlunoDTO(entity);
	}

	@Transactional
	public AlunoDTO update(Long id, AlunoDTO dto) {
		Aluno entity = repository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AlunoDTO(entity);

	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private void copyDtoToEntity(AlunoDTO dto, Aluno entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());

		entity.getProfessores().clear();
		for (ProfessorDTO professorDTO : dto.getProfessores()) {
			Professor professor = professorRepository.getReferenceById(professorDTO.getId());
			entity.getProfessores().add(professor);
		}
	}

}