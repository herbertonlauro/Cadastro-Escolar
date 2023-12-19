package br.school.service;

import br.school.dto.AlunoDTO;
import br.school.mappers.AlunoMapper;
import br.school.model.Aluno;
import br.school.repository.AlunoRepository;
import br.school.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
@AllArgsConstructor
public class AlunoService {

    @Inject
    AlunoRepository alunoRepository;

    @Inject
    CursoRepository cursoRepository;

    @Inject
    AlunoMapper alunoMapper;


    public List<AlunoDTO> listar(){
        List<AlunoDTO> alunoListDTO = new ArrayList<>();
        List<Aluno> alunos = alunoRepository.listAll();
        for (Aluno aluno : alunos) {
            AlunoDTO dto = alunoMapper.toDTO(aluno);
            alunoListDTO.add(dto);
        }
        return alunoListDTO;
    }

    @Transactional
    public AlunoDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id);
        if (aluno != null) return alunoMapper.toDTO(aluno);
        throw new NotFoundException("Aluno não encontrado " + id );
    }

    @Transactional
    public AlunoDTO criar(AlunoDTO alunoDTO){
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        alunoRepository.persist(aluno);
        return alunoMapper.toDTO(aluno);
    }

    @Transactional
    public AlunoDTO editar(Long id, AlunoDTO objDTO) {
        Aluno aluno = alunoRepository.findById(id);
        if (aluno != null) {
            alunoMapper.upAluno(aluno, objDTO);
            alunoRepository.persist(aluno);
            return alunoMapper.toDTO(aluno);
        } else {
            throw new NotFoundException("Aluno não encontrado " + id );
        }
    }

    @Transactional
    public void deletar(Long id) {
        Aluno aluno = alunoRepository.findById(id);
        if (aluno != null) {
            alunoRepository.delete(aluno);
        }else {
            throw new NotFoundException("Aluno não encontrado " + id);
        }
    }
}
