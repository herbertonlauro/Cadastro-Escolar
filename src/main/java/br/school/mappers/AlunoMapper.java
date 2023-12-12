package br.school.mappers;

import br.school.dto.AlunoDTO;
import br.school.model.Aluno;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface AlunoMapper {


    @Mapping(target = "nomeAluno", source = "nome")
    @Mapping(target = "emailAluno", source = "email")
    @Mapping(target = "enderecoAluno", source = "endereco")
    @Mapping(target = "idadeAluno" , source = "idade")
    @Mapping(target = "telefoneAluno" , source = "telefone")


    AlunoDTO toDTO(Aluno aluno);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "curso", ignore = true)
    @InheritInverseConfiguration
    Aluno toEntity(AlunoDTO alunoDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "curso", ignore = true)
    @InheritInverseConfiguration
    Aluno upAluno(@MappingTarget Aluno aluno, AlunoDTO alunoDTO);
}
