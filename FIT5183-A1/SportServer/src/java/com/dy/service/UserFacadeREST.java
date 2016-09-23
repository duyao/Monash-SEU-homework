/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dy.service;

import com.dy.entity.MyUtil;
import com.dy.entity.User;
import java.util.List;
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
@Path("com.dy.entity.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "SportServerPU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        entity.setId(MyUtil.getid());

//        double tmp = 0;
//        if (entity.getGender() == '1') {
//           tmp = (9.56 * entity.getWeight()) + (1.85 * entity.getHeight()) - (4.68 * entity.getAge()) + 655;
//        } else {
//            tmp = (13.75 * entity.getWeight()) + (5 * entity.getHeight()) - (6.76 * entity.getAge()) + 66;
//        }
//        entity.setBmr(tmp);
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, User entity) {
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
    public User find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getBMR/{gender}/ {weight}/{height}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBMR(@PathParam("gender") String gender, @PathParam("weight") String weight,
            @PathParam("height") String height, @PathParam("age") String age) {
        double tmp = 0;
        double w = Double.valueOf(weight);
        double h = Double.valueOf(height);
        int ageInt = Integer.valueOf(age);
        if (gender.equals("1")) {
            tmp = (9.56 * w) + (1.85 * h) - (4.68 * ageInt) + 655;
        } else {
            tmp = (13.75 * w) + (5 * h) - (6.76 * ageInt) + 66;
        }
        return Double.toString(tmp);

    }

//    @GET
//    @Path("getBMR/{userid}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getBMR(@PathParam("userid") String userid) {
//        double tmp  = 0;
//        User u = find(userid);
//        if (u.getGender() == '1') {
//           tmp = (9.56 * u.getWeight()) + (1.85 * u.getHeight()) - (4.68 * u.getAge()) + 655;
//        } else {
//            tmp = (13.75 * u.getWeight()) + (5 * u.getHeight()) - (6.76 * u.getAge()) + 66;
//        }
//        return Double.toString(tmp);
//
//    }
    @GET
    @Path("getCalBurnedPerSteps/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCalBurnedPerSteps(@PathParam("userId") String userId) {
        double cal = 0;
        User u = find(userId);
        cal = u.getWeight() * 0.49 * 2.20462 / u.getStepsMile();
        return Double.toString(cal);
    }

    @GET
    @Path("findByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByName(@PathParam("name") String name) {
        String sql = "select u from User u where u.name = :name";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        q.setParameter("name", name);
        return q.getResultList();
    }

    @GET
    @Path("findByAge/{age}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByAge(@PathParam("age") String age) {
        String sql = "select u from User u where u.age = :age";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        q.setParameter("age", Integer.valueOf(age));
        return q.getResultList();
    }

    @GET
    @Path("findByGender/{gender}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByGender(@PathParam("gender") String gender) {
        String sql = "select u from User u where u.gender = :gender";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        char[] c = gender.toCharArray();
        q.setParameter("gender", c[0]);
        return q.getResultList();
    }

    @GET
    @Path("findByWeight/{weight}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByWeight(@PathParam("weight") String weight) {
        String sql = "select u from User u where u.weight = :weight";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        q.setParameter("weight", Double.valueOf(weight));
        return q.getResultList();
    }

    @GET
    @Path("findByHeight/{height}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByHeight(@PathParam("height") String height) {
        String sql = "select u from User u where u.height = :height";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        q.setParameter("height", Double.valueOf(height));
        return q.getResultList();
    }

    @GET
    @Path("findByActivityLevel/{activityLevel}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByActivityLevel(@PathParam("activityLevel") String activityLevel) {
        String sql = "select u from User u where u.activityLevel = :activityLevel";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        q.setParameter("activityLevel", Integer.valueOf(activityLevel));
        return q.getResultList();
    }

    @GET
    @Path("findByStepsMile/{stepsMile}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByStepsMile(@PathParam("stepsMile") String stepsMile) {
        String sql = "select u from User u where u.stepsMile = :stepsMile";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        q.setParameter("stepsMile", Integer.valueOf(stepsMile));
        return q.getResultList();
    }

    @GET
    @Path("findByBmr/{bmr}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findByBmr(@PathParam("bmr") String bmr) {
        String sql = "select u from User u where u.bmr = :bmr";
        TypedQuery<User> q = em.createQuery(sql, User.class);
        q.setParameter("bmr", Double.valueOf(bmr));
        return q.getResultList();
    }

}
