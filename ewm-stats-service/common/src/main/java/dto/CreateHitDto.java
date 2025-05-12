package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime timestamp;
}
