package com.dy.entity;

import com.dy.entity.Consume;
import com.dy.entity.Intake;
import com.dy.entity.Report;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-24T18:23:00")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> goal;
    public static volatile SingularAttribute<User, Character> gender;
    public static volatile SingularAttribute<User, Double> bmr;
    public static volatile CollectionAttribute<User, Intake> intakeCollection;
    public static volatile SingularAttribute<User, Double> weight;
    public static volatile SingularAttribute<User, Integer> stepsMile;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Report> reportCollection;
    public static volatile SingularAttribute<User, String> name;
    public static volatile CollectionAttribute<User, Consume> consumeCollection;
    public static volatile SingularAttribute<User, String> id;
    public static volatile SingularAttribute<User, Integer> age;
    public static volatile SingularAttribute<User, Integer> activityLevel;
    public static volatile SingularAttribute<User, Double> height;

}