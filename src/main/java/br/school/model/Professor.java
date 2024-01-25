package br.school.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

}