package br.school.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private Long id;
    private String nomeProfessor;
    private String emailProfessor;
    private String telefoneProfessor;
    private String enderecoProfessor;

}
