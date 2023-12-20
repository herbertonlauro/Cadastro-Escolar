package br.school.mappers;

import br.school.dto.CursoDTO;
import br.school.dto.ProfessorDTO;
import br.school.model.Curso;
import br.school.model.Professor;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface ProfessorMapper {


  ProfessorDTO toDTO(Professor professor);

  @Mapping(target = "id", ignore = true)
  @InheritInverseConfiguration
  Professor toEntity(ProfessorDTO professorDTO);


  @InheritInverseConfiguration
  Professor upProf(@MappingTarget Professor professor, ProfessorDTO professorDTO);


}
