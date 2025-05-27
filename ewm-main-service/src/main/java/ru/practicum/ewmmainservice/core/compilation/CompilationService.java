package ru.practicum.ewmmainservice.core.compilation;

import java.util.List;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationDto;

public interface CompilationService {

  CompilationDto create(CreateCompilationDto createCompilationDto);

  CompilationDto update(Long id, UpdateCompilationDto updateCompilationDto);

  void delete(Long id);

  List<CompilationDto> getList(Paging paging);

  CompilationDto getById(Long id);
}
