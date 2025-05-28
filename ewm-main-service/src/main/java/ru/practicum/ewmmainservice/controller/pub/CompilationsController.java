package ru.practicum.ewmmainservice.controller.pub;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.core.compilation.CompilationService;
import ru.practicum.ewmmainservice.core.compilation.dto.CompilationDto;

@RestController
@RequestMapping("/compilations")
@Tags({
    @Tag(name = "Public: Подборки событий", description = "Публичный API для работы с подборками событий")})
@RequiredArgsConstructor
class CompilationsController {

  private final CompilationService compilationsService;

  @GetMapping
  public List<CompilationDto> getList(Paging paging) {

    return compilationsService.getList(paging);
  }

  @GetMapping("/{compId}")
  public CompilationDto getById(@PathVariable Long compId) {
    return compilationsService.getById(compId);
  }
}
