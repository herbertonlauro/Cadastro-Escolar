package br.school.repository;

import br.school.dto.AlunoDTO;
import br.school.model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {

    public void persist(AlunoDTO alunosaveDTO) {
    }
}