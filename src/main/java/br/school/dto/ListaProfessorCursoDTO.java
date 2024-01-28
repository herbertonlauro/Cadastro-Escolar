package br.school.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ListaProfessorCursoDTO {
    private Long id;
    @Schema(example = "Gustavo Lemos", required = true)
    private String nome;

    private CursoDTO curso;
}
