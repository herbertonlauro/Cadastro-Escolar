package br.school.service;

import br.school.dto.CursoDTO;
import br.school.dto.ProfessorDTO;
import br.school.mappers.ProfessorMapper;
import br.school.model.Curso;
import br.school.model.Professor;
import br.school.repository.ProfessorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProfessorService {

    @Inject
    ProfessorMapper professorMapper;

    @Inject
    ProfessorRepository professorRepository;

    @Transactional
    public List<ProfessorDTO> listar(){
        List<ProfessorDTO> professorListDTO = new ArrayList<>();
        List<Professor> profLista = professorRepository.listAll();
        for(Professor professor : profLista){
            ProfessorDTO dtoProf = professorMapper.toDTO(professor);
            professorListDTO.add(dtoProf);
        }

        return professorListDTO;
    }

    @Transactional
    public ProfessorDTO criar(ProfessorDTO professorDTO){
        Professor criarProfessor = professorMapper.toEntity(professorDTO);
        professorRepository.persist(criarProfessor);
        return professorMapper.toDTO(criarProfessor);
    }


    @Transactional
    public ProfessorDTO editar(Long id, ProfessorDTO objDTO){
        Professor professor = professorRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("não encontrado"));
        professorMapper.upProf(professor, objDTO);
        professorRepository.persist(professor);
        return  professorMapper.toDTO(professor);
    }

    @Transactional
    public void deletar(Long id){
    Professor professor = professorRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("não encontrado"));
    professorRepository.deleteById(id);

    }


}
