package br.school.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private String nomeProfessor;
    private String emailProfessor;
    private String telefoneProfessor;
    private String enderecoProfessor;

}
