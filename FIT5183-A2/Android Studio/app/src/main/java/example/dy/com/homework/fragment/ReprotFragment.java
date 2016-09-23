package example.dy.com.homework.fragment;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.model.XYMultipleSeriesDataset;


import java.util.Calendar;
import java.util.List;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.entity.Step;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.DatabaseHelper;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/25.
 */
public class ReprotFragment extends Fragment {

    //f1. show today data
    //f2. show selected date
    //f3. period data


    private View vReport;
    private GraphicalView graphicalView;
    private LinearLayout cbchart;
    private LinearLayout grchart;
    private LinearLayout stepChart;
    private DatabaseHelper databaseHelper;
    private JsonUser u;
    private Button dayButton;
    private Button durationButton;
    private FragmentManager manager;
    private FragmentTransaction ft;

    private static final String IP = StringUtils.IPString;
    final static String UPDATESTEPURL = "http://" + IP + "/SportServer/webresources/com.dy.entity.consume/undateSteps";
    final static String CONSUMEDBURNEDURL = "http://" + IP + "/SportServer/webresources/com.dy.entity.report/getConsumedBurnedCal";
    final static String UPDATEREPORTURL = "http://" + IP + "/SportServer/webresources/com.dy.entity.report/undateReport";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vReport = inflater.inflate(R.layout.fragment_report, container, false);

        dayButton = (Button) vReport.findViewById(R.id.specific_button);
        durationButton = (Button) vReport.findViewById(R.id.durationButton);
        cbchart = (LinearLayout) vReport.findViewById(R.id.cbchart);
        grchart = (LinearLayout) vReport.findViewById(R.id.grchart);
        stepChart = (LinearLayout) vReport.findViewById(R.id.step_chart);

        databaseHelper = new DatabaseHelper(vReport.getContext());

        manager = getFragmentManager();


        u = this.getArguments().getParcelable("user");


        if (container == null) {
            return null;
        }

        final String dateString = StringUtils.getCurTime().substring(0, 10);

        //1. steps-> data from sqlite, draw line

//        databaseHelper.addData(u.getId());
        List<Step> stepList = databaseHelper.getStep(u.getId(), dateString);
        int[] timeX = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};//每个序列中点的X坐标
        int[] stepY = new int[24];

        int totalSteps = 0;
        for (Step s : stepList) {
            int hh = Integer.valueOf(s.getDate().substring(11, 13));
            stepY[hh] += s.getSteps();
            totalSteps += s.getSteps();
        }


        int[] colors1 = new int[]{Color.RED};//每个序列的颜色设置
        PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE};//每个序列中点的形状设置
        XYMultipleSeriesRenderer renderer1 = new XYMultipleSeriesRenderer();
        renderer1.setXLabels(12);//设置x轴显示24个点,根据setChartSettings的最大值和最小值自动计算点的间隔
        renderer1.setYLabels(10);//设置y轴显示10个点,根据setChartSettings的最大值和最小值自动计算点的间隔
        renderer1.setShowGrid(true);//是否显示网格
        renderer1.setXLabelsAlign(Paint.Align.RIGHT);//刻度线与刻度标注之间的相对位置关系
        renderer1.setYLabelsAlign(Paint.Align.CENTER);//刻度线与刻度标注之间的相对位置关系
//        renderer1.setZoomButtonsVisible(true);//是否显示放大缩小按钮
//        renderer1.setPanLimits(new double[]{-10, 20, -10, 40}); //设置拖动时X轴Y轴允许的最大值最小值.
//        renderer1.setZoomLimits(new double[]{-10, 20, -10, 40});//设置放大缩小时X轴Y轴允许的最大最小值.
        renderer1.setPanEnabled(false, false);// 上下左右都不可以移动
        renderer1.setXTitle("Time");
        renderer1.setYTitle("Steps");
//        renderer1.setFitLegend(true);
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
        //top, left, bottom, right
        renderer1.setMargins(new int[]{0, 60, 5, 10});
        renderer1.setPanLimits(new double[]{-10, 20, -10, 40}); //设置拖动时X轴Y轴允许的最大值最小值.
        renderer1.setZoomLimits(new double[]{-10, 20, -10, 40});//设置放大缩小时X轴Y轴允许的最大最小值.
        for (int i = 0; i < colors1.length; i++) {
            XYSeriesRenderer r = new XYSeriesRenderer();
            r.setColor(colors1[i]);
            r.setPointStyle(styles[i]);
            r.setFillPoints(true);
            renderer1.addSeriesRenderer(r);
        }
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        XYSeries xySeries = new XYSeries("step");
        for (int i = 0; i < timeX.length; i++) {
            xySeries.add(timeX[i], stepY[i]);
        }
        dataset.addSeries(xySeries);
        graphicalView = ChartFactory.getLineChartView(getActivity(), dataset, renderer1);
        stepChart.addView(graphicalView);


        //add steps to server
        final int finalTotalSteps = totalSteps;
        new ConnectionUtils(UPDATESTEPURL, new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("reslut" + result);
                if ("true".equals(result)) {

                    //get consume and burned
                    new ConnectionUtils(CONSUMEDBURNEDURL, new ConnectionUtils.ConnectionCallback() {
                        @Override
                        public void onSuccess(Object result) {
                            System.out.println("comsume->" + result);
                            String[] tmp = result.toString().split(",");
                            double consumeCal = Double.valueOf(tmp[0]);
                            double burnCal = Double.valueOf(tmp[1]);

                            //2. burn & comsume -> data from server, draw pie
                            double[] Performance = {consumeCal, burnCal};  // [0] for correct ans, [1] for wrong ans
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
                            renderer2.setChartTitleTextSize(45);
                            renderer2.setShowLabels(true);
                            renderer2.setLabelsTextSize(30);
                            renderer2.setLegendTextSize(30);
                            renderer2.setPanEnabled(false);// 上下左右都不可以移动
                            renderer2.setLabelsColor(Color.BLACK);
                            graphicalView = ChartFactory.getPieChartView(getActivity(),
                                    series, renderer2);

                            // Adding the pie chart to the custom layout
                            cbchart.addView(graphicalView);


                            //3. remaining & goal -> data from server, draw pie
                            //remaining = con - burn
                            double remaining = (consumeCal - burnCal) < 0 ? 0 : (consumeCal - burnCal);
                            double[] dd = {u.getGoal(), remaining};
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
                            renderer3.setChartTitleTextSize(45);
                            renderer3.setShowLabels(true);
                            renderer3.setLabelsTextSize(30);
                            renderer3.setLegendTextSize(30);
                            renderer3.setPanEnabled(false);// 上下左右都不可以移动
                            renderer3.setLabelsColor(Color.BLACK);
                            graphicalView = ChartFactory.getPieChartView(getActivity(),ser, renderer3);

                            // Adding the pie chart to the custom layout
                            grchart.addView(graphicalView);


//                            //generate report
                            System.out.println("consumeCal" + consumeCal + "burnCal" + burnCal + "remaining" + remaining + finalTotalSteps + u.getGoal());
//                            //add steps to server
                            new ConnectionUtils(UPDATEREPORTURL, new ConnectionUtils.ConnectionCallback() {
                                @Override
                                public void onSuccess(Object result) {
                                    System.out.println("reslut" + result);
                                }

                                @Override
                                public void onFail() {
                                    System.out.println("cannot update report in consume of server");
                                }
                            }, u.getId());


                        }

                        @Override
                        public void onFail() {
                            System.out.println("cannot find consume and burn of server");

                        }
                    }, u.getId(), dateString);


                } else {
                    onFail();
                }


            }

            @Override
            public void onFail() {
                System.out.println("cannot update step in consume of server");

            }
        }, u.getId(), String.valueOf(totalSteps),dateString);


        dayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                new DatePickerDialog(vReport.getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String pickTime = year + "-" + (monthOfYear+1) + "-" + dayOfMonth;
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("user", u);
                                bundle.putString("time", pickTime);

                                DayReportFragment fragment = new DayReportFragment();
                                fragment.setArguments(bundle);
                                ft = manager.beginTransaction();
                                ft.replace(R.id.content_frame, fragment);
                                ft.addToBackStack(null);
                                ft.commit();


                            }
                        }
                        , c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        durationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("user", u);

                DurationFragment1 fragment = new DurationFragment1();
                fragment.setArguments(bundle);
                ft = manager.beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();



            }
        });


        return vReport;
    }
}
