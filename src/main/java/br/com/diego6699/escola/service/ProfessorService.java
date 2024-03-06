package br.com.diego6699.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.diego6699.escola.dto.ProfessorDTO;
import br.com.diego6699.escola.entities.Professor;
import br.com.diego6699.escola.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;

	@Transactional(readOnly = true)
	public Page<ProfessorDTO> findAllPaged(Pageable pageable) {
		Page<Professor> list = repository.findAll(pageable);
		return list.map(x -> new ProfessorDTO(x));
	}

	@Transactional(readOnly = true)
	public ProfessorDTO findById(Long id) {
		Professor entity = repository.getReferenceById(id);
		return new ProfessorDTO(entity);
	}

	@Transactional
	public ProfessorDTO insert(ProfessorDTO dto) {
		Professor entity = new Professor();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProfessorDTO(entity);
	}

	@Transactional
	public ProfessorDTO update(Long id, ProfessorDTO dto) {
		Professor entity = repository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProfessorDTO(entity);

	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private void copyDtoToEntity(ProfessorDTO dto, Professor entity) {
		entity.setName(dto.getName());

	}

}