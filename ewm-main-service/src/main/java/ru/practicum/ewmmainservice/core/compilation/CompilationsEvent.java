package ru.practicum.ewmmainservice.core.compilation;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.practicum.ewmmainservice.core.event.Event;

@Getter
@Setter
@Entity
@Table(name = "compilations_events")
public class CompilationsEvent {

  @EmbeddedId
  private CompilationsEventId id;

  @MapsId("compilationid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "compilationid", nullable = false)
  private Compilation compilationid;

  @MapsId("eventid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "eventid", nullable = false)
  private Event eventid;

}
