package com.dy.entity;

import com.dy.entity.Food;
import com.dy.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-24T18:23:00")
@StaticMetamodel(Intake.class)
public class Intake_ { 

    public static volatile SingularAttribute<Intake, Double> quantiy;
    public static volatile SingularAttribute<Intake, Food> foodId;
    public static volatile SingularAttribute<Intake, String> id;
    public static volatile SingularAttribute<Intake, Date> time;
    public static volatile SingularAttribute<Intake, User> userId;

}