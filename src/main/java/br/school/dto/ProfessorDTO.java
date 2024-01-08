package br.school.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private Long id;

    @Schema(example = "Gustavo Lemos", required = true)
    private String nome;
    @Schema(example = "gustavolemos@gmail.com", required = true)
    private String email;
    @Schema(example = "23", required = true )
    private int idade;
    @Schema(example = "(11)2658-2589" , required = true)
    private String telefone;
    @Schema(example = "Avenida 23, Bairro: Centro Sul, Cidade: São Paulo, SP", required = true)
    private String endereco;

}
