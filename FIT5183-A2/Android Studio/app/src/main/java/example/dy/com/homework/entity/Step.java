package example.dy.com.homework.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dy on 2016/4/19.
 */
public class Step implements Parcelable {
    private String id;
    private String userId;
    private int steps;
    private String date;

    // Database constants
    public static final String TABLE_NAME = "steps";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERID = "userId";
    public static final String COLUMN_STEPS = "steps";
    public static final String COLUMN_DATE = "date";

    public static final String CREATE_STATEMENT =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    COLUMN_USERID + " TEXT NOT NULL, " +
                    COLUMN_STEPS + " INTEGER NOT NULL, " +
                    COLUMN_DATE + " TEXT NOT NULL " +
                    ")";

    public Step(String id, String userId, int steps, String date) {
        this.id = id;
        this.userId = userId;
        this.steps = steps;
        this.date = date;
    }

    protected Step(Parcel in) {
        id = in.readString();
        userId = in.readString();
        steps = in.readInt();
        date = in.readString();
    }

    public static final Creator<Step> CREATOR = new Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };

    public Step(int steps, String date) {
        this.steps = steps;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(userId);
        dest.writeInt(steps);
        dest.writeString(date);
    }

    @Override
    public String toString() {
        return "Step{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", steps=" + steps +
                ", date='" + date + '\'' +
                '}';
    }
}