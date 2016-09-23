/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dy.service;

import com.dy.entity.MyUtil;
import com.dy.entity.Report;
import com.dy.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dy
 */
@Stateless
@Path("com.dy.entity.report")
public class ReportFacadeREST extends AbstractFacade<Report> {

    @EJB
    ConsumeFacadeREST consumeFacadeREST;

    @EJB
    IntakeFacadeREST intakeFacadeREST;

    @EJB
    UserFacadeREST userFacadeREST;

    @PersistenceContext(unitName = "SportServerPU")
    private EntityManager em;

    public ReportFacadeREST() {
        super(Report.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Report entity) {
        entity.setId(MyUtil.getid());
        entity.setTime(MyUtil.getDate());

//        String date = "2016-03-27";
//        User u = userFacadeREST.find("1");
//        entity.setUserId(u);
//        entity.setCalorieSetGoal(500);
//        double con = Double.valueOf(getConsumedCal(u.getId(), date));
//        entity.setConsumed(con);
//        double in = Double.valueOf(getIntakedCal(u.getId(), date));
//        entity.setIntaked(in);
//        entity.setRemaining(in - con);
//        entity.setTime(MyUtil.transTime(date+" 12:00:00"));
//        entity.setTotalSteps(Integer.valueOf(consumeFacadeREST.findStepsBefore(u.getId(), date + " 00:00:00", date+" 23:59:59")));
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Report entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Report find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("getRestCal/{actityLevel}/{BMR}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRestCal(@PathParam("actityLevel") String actityLevel, @PathParam("BMR") String bmrString) {
        Double bmr = Double.valueOf(bmrString);
        double res = 0;
        if (actityLevel.equals("1")) {
            res = bmr * 1.2;
        } else if (actityLevel.equals("2")) {
            res = bmr * 1.375;
        } else if (actityLevel.equals("3")) {
            res = bmr * 1.55;
        } else if (actityLevel.equals("4")) {
            res = bmr * 1.725;
        } else {
            //actityLevel.equals("5")
            res = bmr * 1.9;
        }
        return Double.toString(res);

    }

    @GET
    @Path("getConsumedCal/{userid}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConsumedCal(@PathParam("userid") String userid, @PathParam("date") String date) {
        String start = date + " 00:00:00";
        String end = date + " 23:59:59";
        double con1 = Double.valueOf(consumeFacadeREST.getConsumedBySteps(userid, start, end));
        User u = userFacadeREST.find(userid);
        double rest = Double.valueOf(getRestCal(Integer.toString(u.getActivityLevel()), Double.toString(u.getBmr())));
        return String.valueOf(con1 + rest);

    }

    @GET
    @Path("getConsumedCalDuration/{userid}/{start}/{end}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConsumedCalDuration(@PathParam("userid") String userid, @PathParam("start") String start, @PathParam("end") String end) {
//        double steps = Double.valueOf(consumeFacadeREST.findStepsBefore(userid, start, end));
//        double constant = Double.valueOf(userFacadeREST.getCalBurnedPerSteps(userid));
//        User u = userFacadeREST.find(userid);
//        Double rest = Double.valueOf(getRestCal(Integer.toString(u.getActivityLevel()), Double.toString(u.getBmr())));
////        System.out.println("steps * constant =  "+steps * constant);
//        return String.valueOf(steps * constant + rest);
        double con1 = Double.valueOf(consumeFacadeREST.getConsumedBySteps(userid, start, end));
        User u = userFacadeREST.find(userid);
        double rest = Double.valueOf(getRestCal(Integer.toString(u.getActivityLevel()), Double.toString(u.getBmr())));
        return String.valueOf(con1 + rest);
    }

    @GET
    @Path("getIntakedCal/{userid}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIntakedCal(@PathParam("userid") String userid, @PathParam("date") String date) {
        String start = date + " 00:00:00";
        String end = date + " 23:59:59";
        return intakeFacadeREST.getTotalCalByIntake(userid, start, end);
    }

    @GET
    @Path("getIntakedCalDuration/{userid}/{start}/{end}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIntakedCalDuration(@PathParam("userid") String userid, @PathParam("start") String start, @PathParam("end") String end) {
        return intakeFacadeREST.getTotalCalByIntake(userid, start, end);
    }

    @GET
    @Path("findByUserId/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Report> findByUserId(@PathParam("userId") String userId) {
        String sql = "select r from Report r where r.userId.id = :userId";
        TypedQuery<Report> q = em.createQuery(sql, Report.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    @GET
    @Path("findByTime/{userId}/{start}/{end}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Report> findByTime(@PathParam("userId") String userId, @PathParam("start") String start, @PathParam("end") String end) {
        String ss = start + " 00:00:00";
        String ee = end + " 23:59:59";
        String sql = "select r from Report r where r.time >= :start and r.time <= :end and r.userId.id = :userId order by r.time";
        TypedQuery<Report> q = em.createQuery(sql, Report.class);
        q.setParameter("userId", userId);
        q.setParameter("start", MyUtil.transTime(ss));
        q.setParameter("end", MyUtil.transTime(ee));
        return q.getResultList();
    }

    @GET
    @Path("getConsumedBurnedCal/{userid}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConsumedBurnedCal(@PathParam("userid") String userid, @PathParam("date") String date) {
        return this.getConsumedCal(userid, date) + "," + getIntakedCal(userid, date);

    }

    @GET
    @Path("getConsumedBurnedCalDuration/{userid}/{start}/{end}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConsumedBurnedCalDuration(@PathParam("userid") String userid, @PathParam("start") String start, @PathParam("end") String end) {
        return this.getConsumedBurnedCalDuration(userid, start, end) + "," + this.getIntakedCalDuration(userid, start, end);
    }

    @GET
    @Path("findByUseridDate/{userId}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> findByUseridDate(@PathParam("userId") String userid, @PathParam("date") String date) {
        String start = date + " 00:00:00";
        String end = date + " 23:59:59";
        String sql = "select r from Report r where r.time >= :start and r.time <= :end and r.userId.id = :userId";
        TypedQuery<Report> q = em.createQuery(sql, Report.class);
        q.setParameter("start", MyUtil.transTime(start));
        q.setParameter("end", MyUtil.transTime(end));
        q.setParameter("userId", userid);
        return q.getResultList();

    }

    @GET
    @Path("undateReport/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String undateReport(@PathParam("id") String id) {
        String dateString = MyUtil.getCurTime().substring(0, 10);
        List<Report> list = this.findByUseridDate(id, dateString);

        String tmp = this.getConsumedBurnedCal(id, dateString);
        String[] tt = tmp.split(",");
        double con = Double.valueOf(tt[0]);
        double burn = Double.valueOf(tt[1]);
        double remain = con - burn;
        System.out.println("remaining->" + remain);
        int steps = Integer.valueOf(consumeFacadeREST.findStepsBefore(id, dateString + " 00:00:00", dateString + " 23:59:59"));
        User u = userFacadeREST.find(id);
        if (list.size() == 0) {
            Report r = new Report();
            r.setConsumed(con);
            r.setIntaked(burn);
            r.setCalorieSetGoal(u.getGoal());
            r.setRemaining(remain);
            r.setTotalSteps(steps);
            r.setUserId(u);
            this.create(r);
        } else {
            Report r = list.get(0);
            r.setConsumed(con);
            r.setIntaked(burn);
            r.setCalorieSetGoal(u.getGoal());
            r.setRemaining(remain);
            r.setTotalSteps(steps);
            r.setUserId(u);
            this.edit(r);
        }

        return "true";

    }

}
