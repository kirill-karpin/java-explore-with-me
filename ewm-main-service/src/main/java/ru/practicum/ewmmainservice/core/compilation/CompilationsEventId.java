package ru.practicum.ewmmainservice.core.compilation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@Embeddable
public class CompilationsEventId implements Serializable {

  private static final long serialVersionUID = 2102294041233305560L;
  @NotNull
  @Column(name = "compilationid", nullable = false)
  private Long compilationid;

  @NotNull
  @Column(name = "eventid", nullable = false)
  private Long eventid;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    CompilationsEventId entity = (CompilationsEventId) o;
    return Objects.equals(this.compilationid, entity.compilationid) &&
        Objects.equals(this.eventid, entity.eventid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(compilationid, eventid);
  }

}
