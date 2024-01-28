package br.school.service;

import br.school.dto.NotaDTO;
import br.school.mappers.NotaMapper;
import br.school.repository.NotaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

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
