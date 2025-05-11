package dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateHitDto {

  private String app;
  private String uri;
  private String ip;
  private LocalDateTime timestamp;
}
