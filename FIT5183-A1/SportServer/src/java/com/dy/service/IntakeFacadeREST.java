/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dy.service;

import com.dy.entity.Food;
import com.dy.entity.Intake;
import com.dy.entity.MyUtil;
import com.dy.entity.User;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author dy
 */
@Stateless
@Path("com.dy.entity.intake")
public class IntakeFacadeREST extends AbstractFacade<Intake> {

    @EJB
    private UserFacadeREST userFacadeREST;

    @EJB
    private FoodFacadeREST foodFacadeREST;

    @PersistenceContext(unitName = "SportServerPU")
    private EntityManager em;

    public IntakeFacadeREST() {
        super(Intake.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Intake entity) {
        entity.setId(MyUtil.getid());
//        entity.setTime(MyUtil.getDate());
//         Food food = foodFacadeREST.find(entity.getFoodId().getId());
////        System.out.println(food+"id:"+food.getId()+"name:"+food.getName());
//        entity.setFoodId(food);
//        User u = userFacadeREST.find(entity.getUserId().getId());
//        entity.setUserId(u);

        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Intake entity) {
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
    public Intake find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Intake> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Intake> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getTotalCalByIntake/{id}/{start}/{end}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getTotalCalByIntake(@PathParam("id") String id, @PathParam("start") String start, @PathParam("end") String end) {
        Query query = em.createNamedQuery("Intake.getTotalCalByIntake");
//        Date startDate = MyUtil.transTime(start + " 00:00:00");
//        Date endDate = MyUtil.transTime(end + " 23:59:59");
        query.setParameter("id", id);
        query.setParameter("start", MyUtil.transTime(start));
        query.setParameter("end", MyUtil.transTime(end));

        List tmp = query.getResultList();
        double sum = 0;
        for (int i = 0; i < tmp.size(); i++) {
            Object[] o = (Object[]) tmp.get(i);
            Food f = (Food) o[0];
            double quan = Double.valueOf(o[1].toString());
//            System.out.println(f);
//            System.out.println("getCalorie = "+f.getCalorie() + ", quan = "+quan);
            sum += quan * f.getCalorie();
        }
        return Double.toString(sum);
    }

    @GET
    @Path("findByFoodId/{foodId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Intake> findByFoodId(@PathParam("foodId") String foodId) {
        String sql = "select intake from Intake intake where intake.foodId.id = :foodId";
        TypedQuery<Intake> q = em.createQuery(sql, Intake.class);
        q.setParameter("foodId", foodId);
        return q.getResultList();
    }

    @GET
    @Path("findByUserId/{userId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Intake> findByUserId(@PathParam("userId") String userId) {
        String sql = "select intake from Intake intake where intake.userId.id = :userId";
        TypedQuery<Intake> q = em.createQuery(sql, Intake.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    @GET
    @Path("findByQuantiy/{quantiy}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Intake> findByQuantiy(@PathParam("quantiy") String quantiy) {
        String sql = "select intake from Intake intake where intake.quantiy = :quantiy";
        TypedQuery<Intake> q = em.createQuery(sql, Intake.class);
        q.setParameter("quantiy", Integer.valueOf(quantiy));
        return q.getResultList();
    }

}
