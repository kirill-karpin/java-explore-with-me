package ru.practicum.ewmmainservice.core.user;


import org.mapstruct.Mapper;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UserResponse;

@Mapper(componentModel = "spring")
interface UserMapper {

  UserResponse toDto(User user);

  User toEntity(CreateUserRequest userRequest);

  User toEntity(UpdateUserRequest userRequest);

}
