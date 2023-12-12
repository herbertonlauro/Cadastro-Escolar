package br.school.mappers;

import br.school.dto.CursoDTO;
import br.school.model.Curso;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface CursoMapper {


    @Mapping(target = "nomeCurso", source = "nome")
    @Mapping(target = "descricaoCurso", source = "descricao")
    @Mapping(target = "cargaHorarioCurso", source = "cargaHorario")
    @Mapping(target = "turnoCurso", source = "turno")


    CursoDTO toDTO(Curso curso);


    @Mapping(target = "id", ignore = true)
    @InheritInverseConfiguration
    Curso toEntity(CursoDTO cursoDTO);

    @Mapping(target = "id", ignore = true)
    @InheritInverseConfiguration
    Curso upCurso(@MappingTarget Curso curso, CursoDTO cursoDTO);
}
