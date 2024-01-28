package br.school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaAlunoCursoDTO {

    private Long id;
    @Schema(example = "Gustavo Lemos", required = true)
    private String nome;

    private CursoDTO curso;
}
