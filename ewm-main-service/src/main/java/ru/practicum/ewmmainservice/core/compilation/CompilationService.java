package ru.practicum.ewmmainservice.core.compilation;

import java.util.List;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationRequest;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationRequest;

public interface CompilationService {

  CompilationDto create(CreateCompilationRequest createCompilationRequest);

  CompilationDto update(Long id, UpdateCompilationRequest updateCompilationRequest);

  void delete(Long id);

  List<CompilationDto> getList();

  CompilationDto getById(Long id);
}
