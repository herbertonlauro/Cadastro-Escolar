package br.school.service;

import br.school.dto.ProfessorDTO;
import br.school.mappers.ProfessorMapper;
import br.school.model.Aluno;
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


    public List<ProfessorDTO> listar(){
        List<ProfessorDTO> professorListDTO = new ArrayList<>();
        List<Professor> profLista = professorRepository.listAll();
        for(Professor professorModel : profLista){
            ProfessorDTO dtoProf = professorMapper.toDTO(professorModel);
            professorListDTO.add(dtoProf);
        }
        return professorListDTO;
    }

    @Transactional
    public ProfessorDTO criar(ProfessorDTO professorDTO){
        Professor criarProfessorModel = professorMapper.toEntity(professorDTO);
        professorRepository.persist(criarProfessorModel);
        return professorMapper.toDTO(criarProfessorModel);
    }


    @Transactional
    public ProfessorDTO editar(Long id, ProfessorDTO objDTO){
        Professor professorModel = professorRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Professor não encontrado"));
        professorMapper.upProf(professorModel, objDTO);
        professorRepository.persist(professorModel);
        return  professorMapper.toDTO(professorModel);
    }

    @Transactional
    public void deletar(Long id){
    Professor professorModel = professorRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Professor não encontrado"));
    professorRepository.deleteById(id);

    }

    public ProfessorDTO buscarProfPorIDcurso(long id){
        Professor professor = professorRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Professor não encontrado"));
        return professorMapper.toDTO(professor);
    }

}
