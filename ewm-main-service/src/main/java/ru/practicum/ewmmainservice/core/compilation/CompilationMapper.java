package ru.practicum.ewmmainservice.core.compilation;


import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationRequest;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationRequest;
import ru.practicum.ewmmainservice.core.event.Event;

@Mapper(componentModel = "spring")
public interface CompilationMapper {

  @Mapping(target = "events", source = "events")
  CompilationDto toDto(Compilation compilation);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "events", source = "events")
  Compilation toEntity(CreateCompilationRequest compilationDto);

  @Mapping(target = "events", source = "events")
  Compilation toEntity(UpdateCompilationRequest compilationDto);

  default Set<Event> mapEventIdsToEvents(Set<Integer> eventIds) {
    if (eventIds == null) {
      return Collections.emptySet();
    }

    return eventIds.stream()
        .map(id -> {
          Event event = new Event();
          event.setId(id.longValue());

          return event;
        })
        .collect(Collectors.toSet());
  }
}
