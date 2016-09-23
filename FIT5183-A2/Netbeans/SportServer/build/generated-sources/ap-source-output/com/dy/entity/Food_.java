package com.dy.entity;

import com.dy.entity.Intake;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-24T18:23:00")
@StaticMetamodel(Food.class)
public class Food_ { 

    public static volatile SingularAttribute<Food, String> name;
    public static volatile SingularAttribute<Food, Double> calorie;
    public static volatile CollectionAttribute<Food, Intake> intakeCollection;
    public static volatile SingularAttribute<Food, String> id;
    public static volatile SingularAttribute<Food, String> serving;

}