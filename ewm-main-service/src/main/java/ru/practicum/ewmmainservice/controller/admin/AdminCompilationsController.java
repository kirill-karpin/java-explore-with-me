package ru.practicum.ewmmainservice.controller.admin;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.core.compilation.CompilationService;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;
import ru.practicum.ewmmainservice.core.compilation.dto.CreateCompilationRequest;
import ru.practicum.ewmmainservice.core.compilation.dto.UpdateCompilationRequest;

@RestController
@RequestMapping("/admin/compilations")
@Tags({
    @Tag(name = "Admin: Подборки событий", description = "API для работы с подборками событий"),
    @Tag(name = "admin")
})
@RequiredArgsConstructor
class AdminCompilationsController {

  private final CompilationService compilationService;

  @PostMapping
  @ResponseStatus(CREATED)
  public CompilationDto post(@RequestBody CreateCompilationRequest request) {
    return compilationService.create(request);
  }

  @DeleteMapping("/{compId}")
  @ResponseStatus(NO_CONTENT)
  public void delete(@PathVariable Long compId) {

    compilationService.delete(compId);
  }

  @PatchMapping("/{compId}")

  public CompilationDto patch(@PathVariable Long compId, UpdateCompilationRequest request) {
    return compilationService.update(compId, request);
  }

}
