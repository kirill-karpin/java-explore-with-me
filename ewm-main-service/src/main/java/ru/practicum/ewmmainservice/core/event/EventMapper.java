package ru.practicum.ewmmainservice.core.event;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventDto;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventDto;

@Mapper(componentModel = "spring", uses = StateMapper.class)
public interface EventMapper {


  @Mapping(target = "id", ignore = true)
  @Mapping(target = "lat", source = "location.lat")
  @Mapping(target = "lon", source = "location.lon")
  @Mapping(target = "categoryid", ignore = true)
  @Mapping(target = "initiatorid", ignore = true)
  @Mapping(target = "compilations", ignore = true)
  @Mapping(target = "participationRequests", ignore = true)
  @Mapping(target = "views", ignore = true)
  Event toEntity(UpdateEventDto updateEventDto);

  //@Mapping(target = "category", source = "category", qualifiedByName = "mapCategoryIdToEntity")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "categoryid", ignore = true)
  @Mapping(target = "initiatorid", ignore = true)
  @Mapping(target = "compilations", ignore = true)
  @Mapping(target = "participationRequests", ignore = true)
  @Mapping(target = "views", ignore = true)
  @Mapping(target = "confirmedRequests", ignore = true)
  @Mapping(target = "createdOn", ignore = true)
  @Mapping(target = "publishedOn", ignore = true)
  @Mapping(target = "state", ignore = true)
  @Mapping(target = "lat", source = "location.lat")
  @Mapping(target = "lon", source = "location.lon")
  Event toEntity(CreateEventDto updateEventRequest);

  @Mapping(source = "categoryid", target = "category")
  @Mapping(source = "initiatorid", target = "initiator")
  @Mapping(target = "location.lat", source = "lat")
  @Mapping(target = "location.lon", source = "lon")
  EventDto toDto(Event event);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "lat", source = "location.lat")
  @Mapping(target = "lon", source = "location.lon")
  @Mapping(target = "state", source = "stateAction", qualifiedByName = "stateActionToState")
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Event partialUpdate(
      UpdateEventDto updateEventDto, @MappingTarget Event event);

  Event toEntity(EventDto eventDto);
}
