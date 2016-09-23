package example.dy.com.homework.entity;

/**
 * Created by dy on 2016/4/22.
 */
public class JsonFood {
    private String id;
    private String name;
    private String calorie;
    private String serving;

    @Override
    public String toString() {
        return "JsonFood{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", calorie='" + calorie + '\'' +
                ", serving='" + serving + '\'' +
                '}';
    }

    public JsonFood(String id, String name, String calorie, String serving) {
        this.id = id;
        this.name = name;
        this.calorie = calorie;
        this.serving = serving;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }
}
