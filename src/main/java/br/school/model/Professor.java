package br.school.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "professor")
@Getter
@Setter
public class Professor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Column(unique = true)
    private String email;

    private String telefone;
    private String endereco;

    @OneToMany(mappedBy = "professor")
    public List<Curso> cursoProfessor;
}