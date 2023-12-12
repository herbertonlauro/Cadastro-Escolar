package br.school.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "curso")
@Getter
@Setter
@ToString
public class Curso  extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nomecurso")
    private String nome;

    @Column(name="descricaocurso")
    private String descricao;

    @Column(name="cargaHorario")
    private int cargaHorario;

    @Column(name="turno")
    private String turno;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    @ManyToOne
    private Professor professor;

}