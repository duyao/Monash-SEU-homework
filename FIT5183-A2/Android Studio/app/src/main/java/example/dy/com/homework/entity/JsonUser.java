package example.dy.com.homework.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dy on 2016/4/19.
 */
public class JsonUser implements Parcelable{

    private String id;
    private String password;
    private String name;
    private int age;
    private Character gender;
    private double height;
    private double weight;
    private int activityLevel;
    private int stepsMile;
    private double bmr;
    private int goal;

    protected JsonUser(Parcel in) {
        id = in.readString();
        password = in.readString();
        name = in.readString();
        age = in.readInt();
        height = in.readDouble();
        weight = in.readDouble();
        activityLevel = in.readInt();
        stepsMile = in.readInt();
        bmr = in.readDouble();
        goal = in.readInt();
    }

    public static final Creator<JsonUser> CREATOR = new Creator<JsonUser>() {
        @Override
        public JsonUser createFromParcel(Parcel in) {
            return new JsonUser(in);
        }

        @Override
        public JsonUser[] newArray(int size) {
            return new JsonUser[size];
        }
    };

    public JsonUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getStepsMile() {
        return stepsMile;
    }

    public void setStepsMile(int stepsMile) {
        this.stepsMile = stepsMile;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public JsonUser(String password, String name, int age, Character gender, double height, double weight, int activityLevel, int stepsMile, int goal) {
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
        this.stepsMile = stepsMile;
        this.goal = goal;
    }

    public JsonUser(String id, String password, String name, int age, Character gender, double height, double weight, int activityLevel, int stepsMile, double bmr, int goal) {

        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
        this.stepsMile = stepsMile;
        this.bmr = bmr;
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "JsonUser{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                ", activityLevel=" + activityLevel +
                ", stepsMile=" + stepsMile +
                ", bmr=" + bmr +
                ", goal=" + goal +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeDouble(height);
        dest.writeDouble(weight);
        dest.writeInt(activityLevel);
        dest.writeInt(stepsMile);
        dest.writeDouble(bmr);
        dest.writeInt(goal);
    }
}
