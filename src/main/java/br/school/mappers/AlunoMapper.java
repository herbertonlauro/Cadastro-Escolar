package br.school.mappers;

import br.school.dto.AlunoDTO;
import br.school.dto.ListaAlunoCursoDTO;
import br.school.model.Aluno;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI, uses = {CursoMapper.class})
public interface AlunoMapper {

    AlunoDTO toDTO(Aluno aluno);
    ListaAlunoCursoDTO toCursoDTO(Aluno aluno);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "curso", ignore = true)
    @InheritInverseConfiguration
    Aluno toEntity(AlunoDTO alunoDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "curso", ignore = true)
    @InheritInverseConfiguration
    Aluno upAluno(@MappingTarget Aluno aluno, AlunoDTO alunoDTO);
}
