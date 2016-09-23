package example.dy.com.homework.entity;


import java.util.Date;

/**
 * Created by dy on 2016/4/24.
 */
public class JsonIntake {
    private String id;
    private JsonFood foodId;
    private JsonUser userId;
    private double quantiy;
    private Date time;

    public JsonIntake(JsonFood foodId, double quantiy, JsonUser userId) {
        this.foodId = foodId;
        this.quantiy = quantiy;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "JsonIntake{" +
                "id='" + id + '\'' +
                ", foodId=" + foodId +
                ", userId=" + userId +
                ", quantiy=" + quantiy +
                ", time=" + time +
                '}';
    }
}
