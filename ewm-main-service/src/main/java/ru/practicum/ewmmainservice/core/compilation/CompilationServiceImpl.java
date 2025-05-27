package ru.practicum.ewmmainservice.core.compilation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationDto;
import ru.practicum.ewmmainservice.core.event.EventRepository;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;

@Service
@RequiredArgsConstructor
class CompilationServiceImpl implements
    CompilationService {

  private final CompilationRepository compilationRepository;
  private final EventRepository eventRepository;
  private final CompilationMapper mapper;

  @Override
  public CompilationDto create(CreateCompilationDto createCompilationDto) {
    Compilation compilation = mapper.toEntity(createCompilationDto);
    return mapper.toDto(compilationRepository.save(compilation));
  }

  @Override
  public CompilationDto update(Long id, UpdateCompilationDto updateCompilationDto) {
    Compilation compilation = compilationRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Compilation not found"));

    Compilation compilationUpdate = mapper.partialUpdate(updateCompilationDto, compilation);

    var result = compilationRepository.save(compilationUpdate);
    return mapper.toDto(result);
  }

  @Override
  public void delete(Long id) {
    compilationRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Compilation not found"));
    compilationRepository.deleteById(id);
  }

  @Override
  public List<CompilationDto> getList(Paging paging) {
    return compilationRepository.findAll(paging.toPageable())
        .stream()
        .map(mapper::toDto).toList();
  }

  @Override
  public CompilationDto getById(Long id) {
    return mapper.toDto(compilationRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Compilation not found")));
  }
}
