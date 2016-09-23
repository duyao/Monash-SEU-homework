package example.dy.com.homework.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.ArrayList;
import java.util.List;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonReport;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/25.
 */
public class DurationFragment2 extends Fragment {
    private JsonUser u;
    private FragmentManager manager;
    private FragmentTransaction ft;
    private View vDuration;
    private String start;
    private String end;

    private LinearLayout cbchart;
    private LinearLayout stepChart;
    private LinearLayout goalChart;
    private TextView title;

    private GraphicalView graphicalView;

    private static final String IP = StringUtils.IPString;
    final static String URL = "http://" + IP + "/SportServer/webresources/com.dy.entity.report/findByTime";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vDuration = inflater.inflate(R.layout.fragment_duration2, container, false);

        start = this.getArguments().getString("start");
        end = this.getArguments().getString("end");
        u = this.getArguments().getParcelable("user");

        cbchart = (LinearLayout) vDuration.findViewById(R.id.chart_duration2);
        stepChart = (LinearLayout) vDuration.findViewById(R.id.step_chart_duration2);
        goalChart = (LinearLayout) vDuration.findViewById(R.id.goal_chart_duration2);
        title = (TextView) vDuration.findViewById(R.id.time_duration2);

        title.setText("Reports from " + start + " to " + end);

        new ConnectionUtils(URL, new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("reslut" + result);
                Gson gson = new Gson();
                List<JsonReport> list = gson.fromJson(result.toString(), new TypeToken<List<JsonReport>>() {
                }.getType());
                if (list.size() == 0) {
                    title.setText("/(ㄒoㄒ)/~~\nNo Data Recorded !");
                    title.setTextSize(30);
                } else {

                    double[] timeX = new double[list.size()];//每个序列中点的X坐标
                    List<double[]> values = new ArrayList<double[]>();
                    double[] con = new double[list.size()];
                    double[] burn = new double[list.size()];
                    double[] step = new double[list.size()];
                    double t0 = StringUtils.dayToNumber(list.get(0).getTime());
                    // remaing >= goal ,that means get goal
                    int goalCnt = 0;
                    int totalCnt = 0;


                    for (int i = 0; i < list.size(); i++) {
                        JsonReport r = list.get(i);
                        if (i != 0) {
                            timeX[i] = StringUtils.dayToNumber(r.getTime()) - StringUtils.dayToNumber(list.get(0).getTime());
                        } else {
                            timeX[i] = 0;
                        }
                        con[i] = r.getConsumed();
                        burn[i] = r.getIntaked();
                        step[i] = r.getTotalSteps();
                        System.out.println("timex->" + timeX[i] + "con->" + con[i] + ",burn->" + burn[i] + "step->" + step[i]);
                        if (r.getRemaining() >= r.getCalorieSetGoal()) {
                            goalCnt++;
                        }
                        totalCnt++;
                    }
                    values.add(con);
                    values.add(burn);
//                    values.add(step);


                    XYMultipleSeriesRenderer renderer1 = new XYMultipleSeriesRenderer();
                    renderer1.setXLabels(timeX.length);//设置x轴显示24个点,根据setChartSettings的最大值和最小值自动计算点的间隔
                    renderer1.setYLabels(10);//设置y轴显示10个点,根据setChartSettings的最大值和最小值自动计算点的间隔
                    renderer1.setShowGrid(true);//是否显示网格
                    renderer1.setXLabelsAlign(Paint.Align.RIGHT);//刻度线与刻度标注之间的相对位置关系
                    renderer1.setYLabelsAlign(Paint.Align.CENTER);//刻度线与刻度标注之间的相对位置关系
                    renderer1.setPanEnabled(false, false);// 上下左右都不可以移动
                    renderer1.setXTitle("Time");
                    renderer1.setYTitle("Calories");
                    renderer1.setLegendTextSize(40);
                    renderer1.setLabelsTextSize(40);
                    renderer1.setPointSize(10);
                    renderer1.setAxisTitleTextSize(50);
                    renderer1.setChartTitleTextSize(60);
                    renderer1.setXLabelsColor(Color.BLACK);
                    renderer1.setYLabelsColor(0, Color.BLACK);
                    renderer1.setXAxisColor(Color.BLACK);
                    renderer1.setYAxisColor(Color.BLACK);
                    renderer1.setApplyBackgroundColor(true);
                    renderer1.setBackgroundColor(Color.WHITE);
                    renderer1.setMarginsColor(Color.WHITE);
                    renderer1.setFitLegend(true);
                    renderer1.setXTitle("Consumed and Burned Calories");
                    //top, left, bottom, right
                    renderer1.setMargins(new int[]{20, 130, 40, 10});
                    renderer1.setPanLimits(new double[]{-10, 20, -10, 40});
                    renderer1.setZoomLimits(new double[]{-10, 20, -10, 40});

                    int[] colors1 = new int[]{Color.RED, Color.MAGENTA};
                    PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE, PointStyle.TRIANGLE};
                    String[] titles = new String[]{"Consumed", "Burned"};
                    for (int i = 0; i < colors1.length; i++) {
                        XYSeriesRenderer r = new XYSeriesRenderer();
                        r.setColor(colors1[i]);
                        r.setPointStyle(styles[i]);
                        r.setFillPoints(true);
                        renderer1.addSeriesRenderer(i, r);
                    }

                    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
                    List<XYSeries> xySeries = new ArrayList<>();
                    for (int i = 0; i < titles.length; i++) {
                        XYSeries s = new XYSeries(titles[i]);
                        for (int j = 0; j < values.get(i).length; j++) {
                            s.add(timeX[j], values.get(i)[j]);
                        }
                        xySeries.add(i, s);
                    }
                    dataset.addAllSeries(xySeries);
                    graphicalView = ChartFactory.getLineChartView(getActivity(), dataset, renderer1);
                    cbchart.addView(graphicalView);


                    //step
                    XYMultipleSeriesRenderer rendererStep = new XYMultipleSeriesRenderer();
                    rendererStep.setXLabels(timeX.length);//设置x轴显示24个点,根据setChartSettings的最大值和最小值自动计算点的间隔
                    rendererStep.setYLabels(10);//设置y轴显示10个点,根据setChartSettings的最大值和最小值自动计算点的间隔
                    rendererStep.setShowGrid(true);//是否显示网格
                    rendererStep.setXLabelsAlign(Paint.Align.RIGHT);//刻度线与刻度标注之间的相对位置关系
                    rendererStep.setYLabelsAlign(Paint.Align.CENTER);//刻度线与刻度标注之间的相对位置关系
                    rendererStep.setPanEnabled(false, false);// 上下左右都不可以移动
                    rendererStep.setXTitle("Time");
                    rendererStep.setYTitle("Steps");
                    rendererStep.setLegendTextSize(40);
                    rendererStep.setLabelsTextSize(40);
                    rendererStep.setPointSize(10);
                    rendererStep.setAxisTitleTextSize(50);
                    rendererStep.setChartTitleTextSize(60);
                    rendererStep.setXLabelsColor(Color.BLACK);
                    rendererStep.setYLabelsColor(0, Color.BLACK);
                    rendererStep.setXAxisColor(Color.BLACK);
                    rendererStep.setYAxisColor(Color.BLACK);
                    rendererStep.setApplyBackgroundColor(true);
                    rendererStep.setBackgroundColor(Color.WHITE);
                    rendererStep.setMarginsColor(Color.WHITE);
                    rendererStep.setXTitle("Step Graph");
                    //top, left, bottom, right
                    rendererStep.setMargins(new int[]{10, 140, 5, 10});
                    rendererStep.setPanEnabled(false, false);
                    rendererStep.setBarSpacing(5);
                    rendererStep.setDisplayValues(true);

//                    rendererStep.setBarWidth(2);

                    XYSeriesRenderer r = new XYSeriesRenderer();
                    r.setColor(Color.BLUE);
                    rendererStep.addSeriesRenderer(r);

                    XYMultipleSeriesDataset dataset1 = new XYMultipleSeriesDataset();
                    XYSeries xySeries1 = new XYSeries("Step");
                    for (int i = 0; i < timeX.length; i++) {
                        xySeries1.add(timeX[i], step[i]);
                    }
                    dataset1.addSeries(xySeries1);
                    graphicalView = ChartFactory.getBarChartView(getActivity(), dataset1, rendererStep, BarChart.Type.DEFAULT);
                    stepChart.addView(graphicalView);


                    //2. burn & comsume -> data from server, draw pie
                    double[] Performance = {goalCnt, totalCnt - goalCnt};  // [0] for correct ans, [1] for wrong ans
                    CategorySeries series = new CategorySeries("pie"); // adding series of charts from array .
                    series.add("Achieve", Performance[0]);
                    series.add("Not Achieve", Performance[1]);
                    int[] colors2 = new int[]{Color.YELLOW, Color.CYAN};            // set style for chart series
                    DefaultRenderer renderer2 = new DefaultRenderer();
                    for (int color : colors2) {
                        SimpleSeriesRenderer rr = new SimpleSeriesRenderer();
                        rr.setColor(color);
                        renderer2.addSeriesRenderer(rr);
                    }
                    renderer2.isInScroll();
                    renderer2.setZoomButtonsVisible(false);   //setting zoom button of Graph
                    renderer2.setApplyBackgroundColor(true);
                    renderer2.setBackgroundColor(Color.WHITE); //setting background color of chart
                    renderer2.setChartTitle("Days of Achieve Goal");   //setting title of chart
                    renderer2.setChartTitleTextSize(60);
                    renderer2.setShowLabels(true);
                    renderer2.setLabelsTextSize(30);
                    renderer2.setLegendTextSize(30);
                    renderer2.setPanEnabled(false);// 上下左右都不可以移动
                    renderer2.setLabelsColor(Color.BLACK);
                    renderer2.setDisplayValues(true);
                    renderer2.setShowLegend(false);
                    graphicalView = ChartFactory.getPieChartView(getActivity(),
                            series, renderer2);

                    // Adding the pie chart to the custom layout
                    goalChart.addView(graphicalView);


                }


            }

            @Override
            public void onFail() {
                System.out.println("cannot find report in consume of server");
            }
        }, u.getId(), start, end);


        return vDuration;
    }

}
