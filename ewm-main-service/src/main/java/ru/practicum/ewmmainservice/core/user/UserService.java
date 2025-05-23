package ru.practicum.ewmmainservice.core.user;

import java.util.List;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UserDto;

public interface UserService {

  UserDto create(CreateUserRequest createUserRequest);

  UserDto update(Long userId, UpdateUserRequest updateUserRequest);

  void delete(Long categoryId);

  List<UserDto> getList();
}
