package ru.practicum.ewmmainservice.core.event;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventRequest;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventRequest;

@Mapper(componentModel = "spring")
public interface EventMapper {

  Event toEntity(UpdateEventRequest updateEventRequest);

  Event toEntity(CreateEventRequest updateEventRequest);

  EventDto toDto(Event event);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Event partialUpdate(
      UpdateEventRequest updateEventRequest, @MappingTarget Event event);
}
