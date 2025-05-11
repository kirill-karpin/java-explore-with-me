package ru.practicum.statserver.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Hit.class)
public abstract class Hit_ {

    public static volatile SingularAttribute<Hit, String> app;
    public static volatile SingularAttribute<Hit, String> uri;
    public static volatile SingularAttribute<Hit, Integer> ip;
    public static volatile SingularAttribute<Hit, Long> id;

    public static final String APP = "app";
    public static final String URI = "uri";
    public static final String IP = "ip";
    public static final String ID = "id";
}
