package br.school.service;

import br.school.dto.CursoDTO;
import br.school.mappers.CursoMapper;
import br.school.model.Aluno;
import br.school.model.Curso;
import br.school.repository.AlunoRepository;
import br.school.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CursoService {

    @Inject
    CursoMapper cursoMapper;

    @Inject
    CursoRepository cursoRepository;

    @Inject
    AlunoRepository alunoRepository;


    @Transactional
    public List<CursoDTO> listarCurso(){
        List<CursoDTO> cursoListDTO = new ArrayList<>();
        List<Curso> cursos = cursoRepository.listAll();
        for (Curso curso : cursos) {
            CursoDTO dto = cursoMapper.toDTO(curso);
            cursoListDTO.add(dto);
        }

        return cursoListDTO;
    }

    @Transactional
    public CursoDTO criar(CursoDTO cursoDTO){
        Curso criarCurso = cursoMapper.toEntity(cursoDTO);
        cursoRepository.persist(criarCurso);
        return cursoMapper.toDTO(criarCurso);
    }

    @Transactional
    public void adicionarAlunoCurso(Long id, Long idCurso){
        Aluno aluno = alunoRepository.findByIdOptional(id).orElseThrow();
        Curso curso = cursoRepository.findByIdOptional(idCurso).orElseThrow();
        aluno.setCurso(curso);
        alunoRepository.persist(aluno);
    }

    @Transactional
    public CursoDTO editar(Long id, CursoDTO objDTO) {
        Curso curso = cursoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("não encontrado"));
            cursoMapper.upCurso(curso, objDTO);
            cursoRepository.persist(curso);
            return cursoMapper.toDTO(curso);
    }

    @Transactional
    public void deletar(Long id){

        Curso curso = cursoRepository.findById(id);
        if (curso != null) {
            cursoRepository.delete(curso);
        }else {
            throw new NotFoundException("Curso não encontrado " + id);
        }

    }

}
