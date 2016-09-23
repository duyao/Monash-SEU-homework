package example.dy.com.homework.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonConsumed;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.entity.Step;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.DatabaseHelper;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/25.
 */
public class CalTrackFragment extends Fragment {

    //the set goal, total number of consumed and burned calories
    private TextView dateText;
    private TextView consumedText;
    private TextView burnedText;
    private TextView goalText;
    private View vCal;
    private DatabaseHelper databaseHelper;
    private JsonUser u;
    private static final String IP = StringUtils.IPString;
    final static String UPDATESTEPURL = "http://" + IP + "/SportServer/webresources/com.dy.entity.consume/undateSteps";
    final static String CONSUMEDBURNEDURL = "http://" + IP + "/SportServer/webresources/com.dy.entity.report/getConsumedBurnedCal";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vCal = inflater.inflate(R.layout.fragment_cal_track, container, false);
        dateText = (TextView) vCal.findViewById(R.id.date_cal_track);
        consumedText = (TextView) vCal.findViewById(R.id.consume_cal_track);
        burnedText = (TextView) vCal.findViewById(R.id.burned_cal_track);
        goalText = (TextView) vCal.findViewById(R.id.setgoal_cal_track);


        final String dateString = StringUtils.getCurTime().substring(0, 10);
        dateText.setText("Today is " + dateString);

        u = this.getArguments().getParcelable("user");
        goalText.setText(u.getGoal() + "");

        databaseHelper = new DatabaseHelper(vCal.getContext());


        //consumed = rest + step
        List<Step> stepList = databaseHelper.getStep(u.getId(), dateString);
        int totalSteps = 0;
        for (Step s : stepList) {
            totalSteps += s.getSteps();
        }
        System.out.println("totalSteps->" + totalSteps);


        //add steps to server
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
                            consumedText.setText(tmp[0].substring(0,8));
                            burnedText.setText(tmp[1]);

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
        }, u.getId(), String.valueOf(totalSteps), dateString);


        //2.



//        System.out.println("setp->u" + u);


        return vCal;
    }

}
