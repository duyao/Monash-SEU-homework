package example.dy.com.homework.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by dy on 2016/4/24.
 */
public class ONutrient implements Parcelable{
    private int nutrient_id;
    private String name;
    private String sourcecode;
    private String unit;
    private Double value;
    private String dp;
    private String se;
    private List<Measure> measures;



    public ONutrient(int nutrient_id, String name, String sourcecode, String unit, Double value, String dp, String se, List<Measure> measures) {
        this.nutrient_id = nutrient_id;
        this.name = name;
        this.sourcecode = sourcecode;
        this.unit = unit;
        this.value = value;
        this.dp = dp;
        this.se = se;
        this.measures = measures;
    }

    protected ONutrient(Parcel in) {
        nutrient_id = in.readInt();
        name = in.readString();
        sourcecode = in.readString();
        unit = in.readString();
        dp = in.readString();
        se = in.readString();
    }

    public static final Creator<ONutrient> CREATOR = new Creator<ONutrient>() {
        @Override
        public ONutrient createFromParcel(Parcel in) {
            return new ONutrient(in);
        }

        @Override
        public ONutrient[] newArray(int size) {
            return new ONutrient[size];
        }
    };

    public int getNutrient_id() {
        return nutrient_id;
    }

    public String getName() {
        return name;
    }

    public String getSourcecode() {
        return sourcecode;
    }

    public String getUnit() {
        return unit;
    }

    public Double getValue() {
        return value;
    }

    public String getDp() {
        return dp;
    }

    public String getSe() {
        return se;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    @Override
    public String toString() {
        return "ONutrient{" +
                "nutrient_id=" + nutrient_id +
                ", name='" + name + '\'' +
                ", sourcecode='" + sourcecode + '\'' +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                ", dp='" + dp + '\'' +
                ", se='" + se + '\'' +
                ", measures=" + measures +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(nutrient_id);
        dest.writeString(name);
        dest.writeString(sourcecode);
        dest.writeString(unit);
        dest.writeString(dp);
        dest.writeString(se);
    }
}

class Measure {

    private String label;
    private Double eqv;
    private Double qty;
    private Double value;

    public Measure(String label, Double eqv, Double qty, Double value) {
        this.label = label;
        this.eqv = eqv;
        this.qty = qty;
        this.value = value;
    }
}
