package br.school.service;

import br.school.dto.AlunoDTO;
import br.school.dto.CursoDTO;
import br.school.dto.ProfessorDTO;
import br.school.mappers.AlunoMapper;
import br.school.mappers.CursoMapper;
import br.school.mappers.ProfessorMapper;
import br.school.model.Aluno;
import br.school.model.Curso;
import br.school.model.Professor;
import br.school.repository.AlunoRepository;
import br.school.repository.CursoRepository;
import br.school.repository.ProfessorRepository;
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
    ProfessorMapper professorMapper;

    @Inject
    CursoRepository cursoRepository;

    @Inject
    AlunoRepository alunoRepository;

    @Inject
    ProfessorRepository professorRepository;



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
    public List<ProfessorDTO> ListarCursoProfessor(Long id){
    Curso curso = cursoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Professor não encontrado"));
    List<ProfessorDTO> professorDTO = new ArrayList<>();
        for (Professor professor : curso.getProfessor()) {
            ProfessorDTO dto = professorMapper.toDTO(professor);
            professorDTO.add(dto);
        }
        return professorDTO;
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
    public void adicionarProfessorCurso(Long id, Long idCurso){
        Professor professor = professorRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Professor não encontrado"));
        Curso curso = cursoRepository.findByIdOptional(idCurso).orElseThrow(() -> new NotFoundException("Curso não encontrado"));
        professor.setCurso(curso);
        professorRepository.persist(professor);
    }

    @Transactional
    public void editarAlunoCurso(Long id, Long idCurso){
        Curso curso = cursoRepository.findByIdOptional(idCurso).orElseThrow(() -> new NotFoundException("Curso não encontrado"));
        Aluno aluno = alunoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
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
        if(!curso.getAlunos().isEmpty()){
            throw new RuntimeException("O curso tem alunos cadastrado e não pode ser deletado");
        }
        cursoRepository.delete(curso);
    }

}
