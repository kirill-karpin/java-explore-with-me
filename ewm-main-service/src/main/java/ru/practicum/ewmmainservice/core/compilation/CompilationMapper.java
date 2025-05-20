package ru.practicum.ewmmainservice.core.compilation;


import org.mapstruct.Mapper;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationRequest;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationRequest;

@Mapper(componentModel = "spring")
public interface CompilationMapper {

  Compilation toEntity(CreateCompilationRequest destination);

  CompilationDto toDto(Compilation destination);

  Compilation toEntity(UpdateCompilationRequest destination);
}
