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
import ru.practicum.statserver.model.Hit;
import ru.practicum.statserver.model.Hit_;

@Repository
public class HitRepositoryImpl implements HitRepositoryCustom {

  private EntityManager em;

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

    predicates.add(cb.between(root.get("created"), start, end));

    if (uris != null) {
      In<String> inClause = cb.in(root.get("uri"));
      for (String uri : uris) {
        inClause.value(uri);
      }
      predicates.add(inClause);
    }

    cq.where(predicates.toArray(new Predicate[0]));

    if (unique) {
      cq.multiselect(root.get(Hit_.app), root.get(Hit_.uri), cb.countDistinct(root.get(Hit_.ip)));
    } else {
      cq.multiselect(root.get(Hit_.app), root.get(Hit_.uri), cb.count(root.get(Hit_.id)));
    }

    cq.groupBy(root.get(Hit_.uri), root.get(Hit_.app));

    return em.createQuery(cq).getResultList().stream().toList();
  }
}
