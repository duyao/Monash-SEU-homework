package example.dy.com.homework.entity;

import java.util.List;

/**
 * Created by dy on 2016/4/24.
 */
public class OFood {

    private String ndbno;
    private String name;
    private String fg;
    private String sn;
    private String cn;
    private String manu;
    private Double nf;
    private Double cf;
    private Double ff;
    private Double pf;
    private String r;
    private String rd;
    private List<ONutrient> nutrients;

    public String getNdbno() {
        return ndbno;
    }

    public String getName() {
        return name;
    }

    public String getFg() {
        return fg;
    }

    public String getSn() {
        return sn;
    }

    public String getCn() {
        return cn;
    }

    public String getManu() {
        return manu;
    }

    public Double getNf() {
        return nf;
    }

    public Double getCf() {
        return cf;
    }

    public Double getFf() {
        return ff;
    }

    public Double getPf() {
        return pf;
    }

    public String getR() {
        return r;
    }

    public String getRd() {
        return rd;
    }

    public List<ONutrient> getNutrients() {
        return nutrients;
    }

    public OFood(String ndbno, String name, String group, String sn, String cn, String manu, Double nf, Double cf, Double ff, Double pf, String r, String rd, List<ONutrient> nutrients) {
        this.ndbno = ndbno;
        this.name = name;
        this.fg = group;
        this.sn = sn;
        this.cn = cn;
        this.manu = manu;
        this.nf = nf;
        this.cf = cf;
        this.ff = ff;
        this.pf = pf;
        this.r = r;
        this.rd = rd;
        this.nutrients = nutrients;
    }

    @Override
    public String toString() {
        return "OFood{" +
                "ndbno='" + ndbno + '\'' +
                ", name='" + name + '\'' +
                ", fg='" + fg + '\'' +
                ", sn='" + sn + '\'' +
                ", cn='" + cn + '\'' +
                ", manu='" + manu + '\'' +
                ", nf=" + nf +
                ", cf=" + cf +
                ", ff=" + ff +
                ", pf=" + pf +
                ", r='" + r + '\'' +
                ", rd='" + rd + '\'' +
                ", nutrients=" + nutrients +
                '}';
    }
}
