package ru.practicum.ewmmainservice.core.user;

import ru.practicum.ewmmainservice.core.user.dto.CreateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UserResponse;

public interface UserService {

  UserResponse create(CreateUserRequest createUserRequest);

  UserResponse update(Long userId, UpdateUserRequest updateUserRequest);

  void delete(Long categoryId);
}
