package br.school.mappers;

import org.mapstruct.*;
import br.school.dto.NotaDTO;
import br.school.model.Nota;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface NotaMapper {


    NotaDTO toDTO(Nota nota);

    @Mapping(target = "id", ignore = true)
    @InheritInverseConfiguration
    Nota toEntity(NotaDTO notaDTO);
}
