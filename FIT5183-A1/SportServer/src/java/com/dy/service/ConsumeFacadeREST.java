/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dy.service;

import com.dy.entity.Consume;
import com.dy.entity.MyUtil;
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
@Path("com.dy.entity.consume")
public class ConsumeFacadeREST extends AbstractFacade<Consume> {

    @EJB
    private UserFacadeREST userFacadeREST;

    @PersistenceContext(unitName = "SportServerPU")
    private EntityManager em;

    public ConsumeFacadeREST() {
        super(Consume.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consume entity) {
        entity.setId(MyUtil.getid());
//        entity.setTime(MyUtil.getDate());
//        User u = userFacadeREST.find(entity.getUserId().getId());
//        entity.setUserId(u);
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Consume entity) {
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
    public Consume find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consume> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consume> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("findStepsBefore/{userId}/{start}/{end}")
    @Produces(MediaType.APPLICATION_JSON)
    //input type must String
    //Note: ONLY String can be transmitted though network
    public String findStepsBefore(@PathParam("userId") String userId, @PathParam("start") String start, @PathParam("end") String end) {
        int steps = 0;

//        System.out.println("inputDate" + inputDate + "===userId" + userId);
//        Date start = MyUtil.transTime(inputDate + " 00:00:00");
//        Date end = MyUtil.transTime(inputDate + " 23:59:59");
        String sql = "SELECT c FROM Consume c WHERE c.userId.id = :userId AND c.time >= :start and c.time <= :end";
        TypedQuery<Consume> query = em.createQuery(sql, Consume.class);
        query.setParameter("userId", userId);
        query.setParameter("start", MyUtil.transTime(start));
        query.setParameter("end", MyUtil.transTime(end));
        List<Consume> resultList = query.getResultList();
        for (Consume c : resultList) {
//            System.out.println(c.getId());
            steps += c.getSteps();
        }
//        System.out.println("steps" + steps);
        return Integer.toString(steps);

    }

    @GET
    @Path("getConsumedBySteps/{userId}/{start}/{end}")
    @Produces(MediaType.APPLICATION_JSON)
    //input type must String
    //Note: ONLY String can be transmitted though network
    public String getConsumedBySteps(@PathParam("userId") String userId, @PathParam("start") String start, @PathParam("end") String end) {

        String sql = "SELECT u.weight, u.stepsMile,c.steps  FROM User u inner join Consume c WHERE c.userId.id = u.id AND c.time >= :start and c.time <= :end and u.id = :userId";
        TypedQuery<Consume> query = em.createQuery(sql, Consume.class);
        query.setParameter("userId", userId);
        query.setParameter("start", MyUtil.transTime(start));
        query.setParameter("end", MyUtil.transTime(end));
        List resultList = query.getResultList();
        double res = 0;
        for (int i = 0; i < resultList.size(); i++) {
            Object[] o = (Object[]) resultList.get(i);
            double weight = (double) o[0];
            int steps_mile = (int) o[1];
            double constant = weight * 0.49 * 2.20462 / steps_mile;
            int steps = (int) o[2];
//            System.out.println("weight = "+weight);
//            System.out.println("steps_mile = "+steps_mile);
//            System.out.println("constant = "+constant);
//            System.out.println("steps = "+steps);
            res += steps * constant;

        }
//        System.out.println("steps * constant =  "+res);
        return Double.toString(res);

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("findByUserId/{userId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consume> findByUserId(@PathParam("userId") String userId) {
        String sql = "select intake from Consume intake where intake.userId.id = :userId";
        TypedQuery<Consume> q = em.createQuery(sql, Consume.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }
    
    @GET
    @Path("findBySteps/{steps}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consume> findBySteps(@PathParam("steps") String steps) {
        String sql = "select intake from Consume intake where intake.steps = :steps";
        TypedQuery<Consume> q = em.createQuery(sql, Consume.class);
        q.setParameter("steps", Integer.valueOf(steps));
        return q.getResultList();
    }
    
     @GET
    @Path("findByTime/{start}/{end}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consume> findByTime(@PathParam("start") String start,@PathParam("end") String end) {
        String sql = "select intake from Consume intake where intake.time >= :start and intake.time <= :end";
        TypedQuery<Consume> q = em.createQuery(sql, Consume.class);
        q.setParameter("start", MyUtil.transTime(start));
        q.setParameter("end", MyUtil.transTime(end));
        return q.getResultList();
    }

}
