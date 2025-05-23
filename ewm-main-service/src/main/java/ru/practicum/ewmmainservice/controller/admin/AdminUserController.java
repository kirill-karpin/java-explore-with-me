package ru.practicum.ewmmainservice.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.core.user.UserService;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UserDto;

@RestController
@Tags({
    @Tag(name = "Admin: Пользователи", description = "Контроллер работы с пользователями"),
    @Tag(name = "admin"),
})
@RequestMapping("/admin/users")
@RequiredArgsConstructor
class AdminUserController {

  private final UserService userService;

  @GetMapping
  public List<UserDto> getList() {
    return userService.getList();
  }

  @PostMapping
  public UserDto post(@RequestBody CreateUserRequest createUserRequest) {
    return userService.create(createUserRequest);
  }

  @PatchMapping("/{userId}")
  public UserDto patch(@PathVariable Long userId,
      @RequestBody UpdateUserRequest updateUserRequest) {
    return userService.update(userId, updateUserRequest);
  }
}
