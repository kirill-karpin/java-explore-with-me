package ru.practicum.ewmmainservice.controller.pub;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.core.like.dto.CreateLikeDto;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;
import ru.practicum.ewmmainservice.core.like.service.LikeService;

@RestController
@RequestMapping("/likes")
@Tags({
    @Tag(
        name = "Public: Лайки",
        description = "Публичный API для работы с лайками"
    )
})
@RequiredArgsConstructor
class LikeController {

  private final LikeService likeService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LikeDto create(CreateLikeDto createLikeDto) {
    return likeService.likeEntity(createLikeDto);
  }

  @GetMapping("/{userId}")
  public List<LikeDto> getUserLikes(@PathVariable Long userId, Paging paging) {
    return likeService.getUserLikes(userId, paging);
  }

  @DeleteMapping("/{userId}/like/{likeId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long userId, @PathVariable Long likeId) {
    likeService.deleteLike(userId, likeId);
  }
}
