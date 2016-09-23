package example.dy.com.homework.entity;

/**
 * Created by dy on 2016/4/24.
 */
public class OReslut {
    private OReport report;

    public OReslut(OReport report) {
        this.report = report;
    }

    public OReport getReport() {
        return report;
    }

    @Override
    public String toString() {
        return "OReslut{" +
                "report=" + report +
                '}';
    }
}
