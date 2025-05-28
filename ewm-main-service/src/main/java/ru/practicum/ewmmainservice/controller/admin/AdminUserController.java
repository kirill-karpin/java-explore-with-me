package ru.practicum.ewmmainservice.controller.admin;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.controller.admin.dto.AdminUserFilter;
import ru.practicum.ewmmainservice.core.user.UserService;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserDto;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserDto;
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
  public List<UserDto> getList(AdminUserFilter filter) {

    return userService.getList(filter);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public UserDto post(@Valid @RequestBody CreateUserDto createUserDto) {
    return userService.create(createUserDto);
  }

  @PatchMapping("/{userId}")
  public UserDto patch(@PathVariable Long userId,
      @RequestBody UpdateUserDto updateUserDto) {
    return userService.update(userId, updateUserDto);
  }

  @DeleteMapping("/{userId}")
  @ResponseStatus(NO_CONTENT)
  public void delete(@PathVariable Long userId) {
    userService.delete(userId);
  }
}
