package br.school.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "professor")
@Getter
@Setter
public class Professor extends Pessoa {

    @OneToMany(mappedBy = "professor")
    public List<Curso> cursoProfessor;
}