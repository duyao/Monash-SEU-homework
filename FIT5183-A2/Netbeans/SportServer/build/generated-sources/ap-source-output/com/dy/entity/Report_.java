package com.dy.entity;

import com.dy.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-24T18:23:00")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Double> consumed;
    public static volatile SingularAttribute<Report, Double> totalSteps;
    public static volatile SingularAttribute<Report, String> id;
    public static volatile SingularAttribute<Report, Date> time;
    public static volatile SingularAttribute<Report, Double> intaked;
    public static volatile SingularAttribute<Report, Double> calorieSetGoal;
    public static volatile SingularAttribute<Report, User> userId;
    public static volatile SingularAttribute<Report, Double> remaining;

}