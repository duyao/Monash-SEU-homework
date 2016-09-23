package com.dy.entity;

import com.dy.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-24T18:23:00")
@StaticMetamodel(Consume.class)
public class Consume_ { 

    public static volatile SingularAttribute<Consume, String> id;
    public static volatile SingularAttribute<Consume, Date> time;
    public static volatile SingularAttribute<Consume, Integer> steps;
    public static volatile SingularAttribute<Consume, User> userId;

}