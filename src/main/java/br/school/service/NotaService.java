package br.school.service;

import br.school.dto.NotaDTO;
import br.school.dto.ProfessorDTO;
import br.school.mappers.NotaMapper;
import br.school.model.Nota;
import br.school.model.Professor;
import br.school.repository.NotaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotaService {

    @Inject
    NotaRepository notaRepository;

    @Inject
    NotaMapper notaMapper;

    @Transactional
    public List<NotaDTO> listar(){
       return notaRepository.listAll().stream()
               .map(notaMapper::toDTO).toList();
    }
}
