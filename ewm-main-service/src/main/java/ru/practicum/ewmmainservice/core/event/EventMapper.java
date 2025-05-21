package ru.practicum.ewmmainservice.core.event;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventRequest;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventRequest;

@Mapper(componentModel = "spring")
public interface EventMapper {

  @Mapping(target = "lat", source = "location.lat")
  @Mapping(target = "lon", source = "location.lon")
  Event toEntity(UpdateEventRequest updateEventRequest);

  //@Mapping(target = "category", source = "category", qualifiedByName = "mapCategoryIdToEntity")
  @Mapping(target = "lat", source = "location.lat")
  @Mapping(target = "lon", source = "location.lon")
  Event toEntity(CreateEventRequest updateEventRequest);

  @Mapping(target = "location.lat", source = "lat")
  @Mapping(target = "location.lon", source = "lon")
  EventDto toDto(Event event);


  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Event partialUpdate(
      UpdateEventRequest updateEventRequest, @MappingTarget Event event);
}
