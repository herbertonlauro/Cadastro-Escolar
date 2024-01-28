package br.school.repository;

import br.school.dto.AlunoDTO;
import br.school.dto.ProfessorDTO;
import br.school.model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {
    public void persist(ProfessorDTO professorDTO) {
    }
}
