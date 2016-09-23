package example.dy.com.homework.entity;

import java.util.List;

/**
 * Created by dy on 2016/4/24.
 */
public class OReport {

    private String sr;
    private String type;
    private OFood food;
    private List<Source> sources;
    private List<Footnote> footnotes;
    private List<Langual> langual;



    public String getSr() {
        return sr;
    }

    public String getType() {
        return type;
    }

    public OFood getFood() {
        return food;
    }

    public List<Source> getSources() {
        return sources;
    }

    public List<Footnote> getFootnotes() {
        return footnotes;
    }

    public List<Langual> getLangual() {
        return langual;
    }

    @Override
    public String toString() {
        return "OReport{" +
                "sr='" + sr + '\'' +
                ", type='" + type + '\'' +
                ", food=" + food +
                ", sources=" + sources +
                ", footnotes=" + footnotes +
                ", langual=" + langual +
                '}';
    }
}

class Source {
    private String title;
    private String authors;
    private String vol;
    private String iss;
    private String year;
    private String start;
    private String end;

    public Source(String title, String authors, String vol, String iss, String year, String start, String end) {
        this.title = title;
        this.authors = authors;
        this.vol = vol;
        this.iss = iss;
        this.year = year;
        this.start = start;
        this.end = end;
    }

}

class Footnote {
    private String idv;
    private String desc;

    public Footnote(String idv, String desc) {
        this.idv = idv;
        this.desc = desc;
    }
}

class Langual {
    private String code;
    private String desc;

    public Langual(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
