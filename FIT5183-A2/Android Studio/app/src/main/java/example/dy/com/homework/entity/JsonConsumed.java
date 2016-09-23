package example.dy.com.homework.entity;

/**
 * Created by dy on 2016/4/25.
 */
public class JsonConsumed {
    private String id;
    private int steps;
    private String time;
    private JsonUser userId;

    public JsonConsumed(int steps, JsonUser userId) {
        this.steps = steps;
        this.userId = userId;
    }
}
