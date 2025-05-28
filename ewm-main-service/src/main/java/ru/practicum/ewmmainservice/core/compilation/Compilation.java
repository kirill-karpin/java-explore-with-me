package ru.practicum.ewmmainservice.core.compilation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.ewmmainservice.core.event.Event;

@Getter
@Setter
@Entity
@Table(name = "compilations")
public class Compilation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "compilationid", nullable = false)
  private Long id;

  @NotNull
  @Column(name = "pinned", nullable = false)
  private Boolean pinned = false;

  @Size(max = 50)
  @NotNull
  @Column(name = "title", nullable = false, length = 50)
  private String title;

  @ManyToMany
  @JoinTable(name = "compilations_events",
      joinColumns = @JoinColumn(name = "compilationid"),
      inverseJoinColumns = @JoinColumn(name = "eventid"))
  private Set<Event> events = new LinkedHashSet<>();

}
