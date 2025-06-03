package ru.practicum.ewmmainservice.core.rating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "rating_likes")
public class RatingLikes {

  @Id
  @Column(nullable = true)
  private Long id;

  @Column(name = "entityType")
  private String entityType;

  @Column(name = "entityId")
  private Long entityId;

  @Column(name = "total")
  private BigDecimal total;

}
