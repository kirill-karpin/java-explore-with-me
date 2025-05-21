package ru.practicum.ewmmainservice.core.compilation;

import java.util.List;
import ru.practicum.ewmmainservice.core.CRUDService;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationRequest;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationRequest;

public interface CompilationService extends
    CRUDService<Long, CreateCompilationRequest, UpdateCompilationRequest, CompilationDto> {

  @Override
  CompilationDto create(CreateCompilationRequest createCompilationRequest);

  @Override
  CompilationDto update(Long id, UpdateCompilationRequest updateCompilationRequest);

  @Override
  void delete(Long id);

  @Override
  List<CompilationDto> getList();

  @Override
  CompilationDto getById(Long id);
}
