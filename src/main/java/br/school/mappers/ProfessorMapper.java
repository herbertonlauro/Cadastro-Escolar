package br.school.mappers;

import br.school.dto.ProfessorDTO;
import br.school.model.Professor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface ProfessorMapper {

  @Mapping(target = "nomeProfessor", source = "nome")
  @Mapping(target = "emailProfessor", source = "email")
  @Mapping(target = "telefoneProfessor", source = "telefone")
  @Mapping(target = "enderecoProfessor", source = "endereco")

  ProfessorDTO toDTO(Professor professor);

  @Mapping(target = "id", ignore = true)
  @InheritInverseConfiguration
  Professor toEntity(ProfessorDTO professorDTO);


}
