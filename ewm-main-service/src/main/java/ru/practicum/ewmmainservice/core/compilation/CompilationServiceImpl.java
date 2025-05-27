package ru.practicum.ewmmainservice.core.compilation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationRequest;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationRequest;
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
  public CompilationDto create(CreateCompilationRequest createCompilationRequest) {
    Compilation compilation = mapper.toEntity(createCompilationRequest);
    return mapper.toDto(compilationRepository.save(compilation));
  }

  @Override
  public CompilationDto update(Long id, UpdateCompilationRequest updateCompilationRequest) {
    Compilation compilation = compilationRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Compilation not found"));

    Compilation compilationUpdate = mapper.partialUpdate(updateCompilationRequest, compilation);

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
  public List<CompilationDto> getList() {
    return compilationRepository.findAll()
        .stream()
        .map(mapper::toDto).toList();
  }

  @Override
  public CompilationDto getById(Long id) {
    return mapper.toDto(compilationRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Compilation not found")));
  }
}
