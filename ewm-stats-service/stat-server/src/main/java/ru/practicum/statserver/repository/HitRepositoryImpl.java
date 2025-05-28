package ru.practicum.statserver.repository;

import dto.HitValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import ru.practicum.statserver.exceptions.ValidationException;
import ru.practicum.statserver.model.Hit;

@Repository
public class HitRepositoryImpl implements HitRepositoryCustom {

  private final EntityManager em;

  public HitRepositoryImpl(EntityManager em) {
    this.em = em;
  }


  @Override
  public List<HitValue> filterByParams(LocalDateTime start, LocalDateTime end,
      List<String> uris, Boolean unique) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<HitValue> cq = cb.createQuery(HitValue.class);

    Root<Hit> root = cq.from(Hit.class);

    List<Predicate> predicates = new ArrayList<>();
    if (start != null && end != null) {
      if (start.isAfter(end)) {
        throw new ValidationException("Start date is after end date");
      }
      predicates.add(cb.greaterThanOrEqualTo(root.get("created"), start));
      predicates.add(cb.lessThanOrEqualTo(root.get("created"), end));

    } else {
      throw new ValidationException("Date range is not specified");
    }

    if (uris != null && !uris.isEmpty()) {
      In<String> inClause = cb.in(root.get("uri"));
      for (String uri : uris) {
        inClause.value(uri);
      }
      predicates.add(inClause);
    }

    cq.where(predicates.toArray(new Predicate[0]));

    if (unique) {
      cq.multiselect(
          root.get("app"),
          root.get("uri"),
          cb.countDistinct(root.get("ip"))
      );
      cq.orderBy(
          cb.desc(cb.countDistinct(root.get("ip")))
      );
    } else {
      cq.multiselect(root.get("app"), root.get("uri"), cb.count(root.get("ip")));
      cq.orderBy(
          cb.desc(cb.count(root.get("id")))
      );
    }

    cq.groupBy(root.get("uri"), root.get("app"));

    return em.createQuery(cq).getResultList().stream().toList();
  }
}
