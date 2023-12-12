package br.school.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nomeAluno;
    private String emailAluno;
    private int idadeAluno;
    private String telefoneAluno;
    private String enderecoAluno;

}
