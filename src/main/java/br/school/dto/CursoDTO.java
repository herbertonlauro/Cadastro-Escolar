package br.school.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    private Long id;
    private String nomeCurso;
    private String descricaoCurso;
    private int cargaHorarioCurso;
    private String turnoCurso;
}
