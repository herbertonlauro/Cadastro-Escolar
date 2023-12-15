package br.school.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Entity(name = "aluno")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true, name = "nomealuno")
    private String nome;

    @Column(unique = true, name = "emailaluno")
    private String email;

    @Column(name="idadealuno")
    private int idade;

    @Column(name="telefonealuno")
    private String telefone;

    @Column(name="enderecoaluno")
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

}
