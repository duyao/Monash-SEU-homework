package example.dy.com.homework.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.util.List;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonReport;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.DatabaseHelper;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/25.
 */
public class DayReportFragment extends Fragment {
    private View vDay;
    private GraphicalView graphicalView;
    private DatabaseHelper databaseHelper;
    private JsonUser u;
    private FragmentManager manager;
    private FragmentTransaction ft;
    private String dateString;
    private LinearLayout cbchart;
    private LinearLayout grchart;
    private TextView dateText;
    private TextView stepText;
    private TextView noText;

    private static final String IP = StringUtils.IPString;
    final static String URL = "http://" + IP + "/SportServer/webresources/com.dy.entity.report/findByUseridDate";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vDay = inflater.inflate(R.layout.fragment_day, container, false);

        cbchart = (LinearLayout) vDay.findViewById(R.id.cbchart_day);
        grchart = (LinearLayout) vDay.findViewById(R.id.grchart_day);
        dateText = (TextView) vDay.findViewById(R.id.date_fragment_day);
        stepText = (TextView) vDay.findViewById(R.id.steps_fragment_day);
        noText = (TextView) vDay.findViewById(R.id.not_found_fragment_day);

        databaseHelper = new DatabaseHelper(vDay.getContext());

        manager = getFragmentManager();


        u = this.getArguments().getParcelable("user");
        dateString = this.getArguments().getString("time");
        dateText.setText("Report of "+dateString);

        new ConnectionUtils(URL, new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("reslut" + result);
                Gson gson = new Gson();
                List<JsonReport> list= gson.fromJson(result.toString(), new TypeToken<List<JsonReport>>() {
                }.getType());
                if(list.size() == 0){
                    noText.setText("No data found in that day!");
                    stepText.setText("");

                }else{
                    JsonReport report = list.get(0);

                    noText.setHeight(0);
                    stepText.setText("Total Steps : "+report.getTotalSteps());
                    stepText.setTextColor(Color.DKGRAY);

                    //2. burn & comsume -> data from server, draw pie
                    double[] Performance = {report.getConsumed(), report.getIntaked()};  // [0] for correct ans, [1] for wrong ans
                    CategorySeries series = new CategorySeries("pie"); // adding series of charts from array .
                    series.add("Consumed", Performance[0]);
                    series.add("Burned", Performance[1]);
                    int[] colors2 = new int[]{Color.GREEN, Color.RED};            // set style for chart series
                    DefaultRenderer renderer2 = new DefaultRenderer();
                    for (int color : colors2) {
                        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
                        r.setColor(color);
                        renderer2.addSeriesRenderer(r);
                    }
                    renderer2.isInScroll();
                    renderer2.setZoomButtonsVisible(false);   //setting zoom button of Graph
                    renderer2.setApplyBackgroundColor(true);
                    renderer2.setBackgroundColor(Color.WHITE); //setting background color of chart
                    renderer2.setChartTitle("Consumed And Burned  Calories");   //setting title of chart
                    renderer2.setChartTitleTextSize(60);
                    renderer2.setShowLabels(true);
                    renderer2.setLabelsTextSize(60);
                    renderer2.setLegendTextSize(60);
                    renderer2.setPanEnabled(false);// 上下左右都不可以移动
                    renderer2.setLabelsColor(Color.BLACK);
                    graphicalView = ChartFactory.getPieChartView(getActivity(),
                            series, renderer2);

                    // Adding the pie chart to the custom layout
                    cbchart.addView(graphicalView);


                    //3. remaining & goal -> data from server, draw pie
                    double[] dd = {report.getCalorieSetGoal(), report.getRemaining()};
                    CategorySeries ser = new CategorySeries("pie"); // adding series of charts from array .
                    ser.add("Goal", dd[0]);
                    ser.add("Remaining", dd[1]);
                    int[] colors3 = new int[]{Color.BLUE, Color.YELLOW};            // set style for chart series
                    DefaultRenderer renderer3 = new DefaultRenderer();
                    for (int color : colors3) {
                        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
                        r.setColor(color);
                        renderer3.addSeriesRenderer(r);
                    }
                    renderer3.isInScroll();
                    renderer3.setZoomButtonsVisible(false);   //setting zoom button of Graph
                    renderer3.setApplyBackgroundColor(true);
                    renderer3.setBackgroundColor(Color.WHITE); //setting background color of chart
                    renderer3.setChartTitle("Goal And Remaining Calories");   //setting title of chart
                    renderer3.setChartTitleTextSize(60);
                    renderer3.setShowLabels(true);
                    renderer3.setLabelsTextSize(60);
                    renderer3.setLegendTextSize(60);
                    renderer3.setPanEnabled(false);// 上下左右都不可以移动
                    renderer3.setLabelsColor(Color.BLACK);
                    //top, left, bottom, right
                    renderer3.setMargins(new int[]{10, 0, 0, 0});
                    graphicalView = ChartFactory.getPieChartView(getActivity(),
                            ser, renderer3);

                    // Adding the pie chart to the custom layout
                    grchart.addView(graphicalView);

                }


            }

            @Override
            public void onFail() {
                System.out.println("cannot find report in consume of server");
            }
        }, u.getId(),dateString);



        return vDay;

    }
}
