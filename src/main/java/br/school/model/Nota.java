package br.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "notaAluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double nota;

    @OneToMany(mappedBy = "curso_id")
    private List<Curso> cursoNota;

    @OneToMany(mappedBy = "aluno_id")
    private List<Aluno> alunoNota;
}
