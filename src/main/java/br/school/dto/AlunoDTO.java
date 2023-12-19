package br.school.dto;

import br.school.model.Curso;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;

    @Schema(example = "Gustavo Lemos", required = true)
    private String nomeAluno;
    @Schema(example = "gustavolemos@gmail.com", required = true)
    private String emailAluno;
    @Schema(example = "23", required = true )
    private int idadeAluno;
    @Schema(example = "(11)2658-2589" , required = true)
    private String telefoneAluno;
    @Schema(example = "Avenida 23, Bairro: Centro Sul, Cidade: São Paulo, SP", required = true)
    private String enderecoAluno;
    private CursoDTO curso;
}
