package br.school.repository;

import br.school.model.Curso;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CursoRepository implements PanacheRepository<Curso> {


}
