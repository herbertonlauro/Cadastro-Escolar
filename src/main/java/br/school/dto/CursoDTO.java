package br.school.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    private Long id;
    @Schema(example = "Programação", required = true)
    private String nomeCurso;
    @Schema(example = "Desenvolvimento java com quarkus", required = true)
    private String descricaoCurso;
    @Schema(example = "120", required = true)
    private int cargaHorarioCurso;
    @Schema(example = "Matutino | vespertino | Noturno", required = true)
    private String turnoCurso;
}
