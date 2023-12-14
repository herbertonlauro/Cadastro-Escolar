package br.school.service;

import br.school.dto.AlunoDTO;
import br.school.dto.CursoDTO;
import br.school.mappers.AlunoMapper;
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
    AlunoMapper alunoMapper;

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
    public List<AlunoDTO> ListarCursoAluno(Long id){
    Curso curso = cursoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Curso não encontrado"));
    List<AlunoDTO> alunoDTO = new ArrayList<>();
        for (Aluno aluno : curso.getAlunos()) {
            AlunoDTO dto = alunoMapper.toDTO(aluno);
            alunoDTO.add(dto);
        }
        return alunoDTO;
    }

    @Transactional
    public CursoDTO criar(CursoDTO cursoDTO){
        Curso criarCurso = cursoMapper.toEntity(cursoDTO);
        cursoRepository.persist(criarCurso);
        return cursoMapper.toDTO(criarCurso);
    }

    @Transactional
    public void adicionarAlunoCurso(Long id, Long idCurso){
        Aluno aluno = alunoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("não encontrado"));
        Curso curso = cursoRepository.findByIdOptional(idCurso).orElseThrow(() -> new NotFoundException("não encontrado"));
        aluno.setCurso(curso);
        alunoRepository.persist(aluno);
    }

    @Transactional
    public CursoDTO editar(Long id, CursoDTO objDTO) {
        Curso curso = cursoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Curso não encontrado"));
            cursoMapper.upCurso(curso, objDTO);
            cursoRepository.persist(curso);
            return cursoMapper.toDTO(curso);
    }

    @Transactional
    public void deletar(Long id){
        Curso curso = cursoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Curso não encontrado "));
        cursoRepository.delete(curso);
    }

}
