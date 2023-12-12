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

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProfessorService {

    @Inject
    ProfessorMapper professorMapper;

    @Inject
    ProfessorRepository professorRepository;

    @Transactional
    public List<ProfessorDTO> listarProfessor(){
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


}
