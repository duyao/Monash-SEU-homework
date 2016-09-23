package example.dy.com.homework.fragment;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonUser;

/**
 * Created by dy on 2016/4/25.
 */
public class DurationFragment1 extends Fragment {

    private JsonUser u;
    private FragmentManager manager;
    private FragmentTransaction ft;
    private View vDuration;

    private Button startButton;
    private Button endButton;
    private Button submit;
    private TextView startText;
    private TextView endText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vDuration = inflater.inflate(R.layout.fragment_duration1, container, false);

        startButton = (Button) vDuration.findViewById(R.id.start_button_duration1);
        endButton = (Button) vDuration.findViewById(R.id.end_button_duration1);
        submit = (Button) vDuration.findViewById(R.id.submit_duration1);
        startText = (TextView) vDuration.findViewById(R.id.stat_time_duration1);
        endText = (TextView) vDuration.findViewById(R.id.end_time_duration1);
        final String[] start = {""};
        final String[] end = {""};

        u = this.getArguments().getParcelable("user");
        manager = getFragmentManager();

        final boolean[] valid = {false};

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                new DatePickerDialog(vDuration.getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                start[0] = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                                startText.setText("Start Time : " + start[0]);

                            }
                        }
                        , c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(start[0])) {
                    Toast.makeText(vDuration.getContext(), "Choose start time Firstly!", Toast.LENGTH_SHORT).show();
                } else {
                    Calendar c = Calendar.getInstance();
                    new DatePickerDialog(vDuration.getContext(),
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    end[0] = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                                    String[] ss = start[0].split("-");
                                    String[] ee = end[0].split("-");
                                    boolean b = true;
                                    for (int i = 0; i < ss.length; i++) {
                                        if (Integer.valueOf(ss[i]) > Integer.valueOf(ee[i])) {
                                            b = false;
                                            break;
                                        }
                                    }
                                    if (b) {
                                        endText.setText("End time : " + end[0]);
                                        valid[0] = true;
                                    } else {
                                        Toast.makeText(vDuration.getContext(), "End time must be later than Start time!", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            }
                            , c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                            c.get(Calendar.DAY_OF_MONTH)).show();
                }

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (valid[0]) {
                      Bundle bundle = new Bundle();
                      bundle.putParcelable("user", u);
                      bundle.putString("start", start[0]);
                      bundle.putString("end", end[0]);
//                      System.out.println("start->" + start[0] + "," + end[0]);

                      DurationFragment2 fragment = new DurationFragment2();
                      fragment.setArguments(bundle);
                      ft = manager.beginTransaction();
                      ft.replace(R.id.content_frame, fragment);
                      ft.addToBackStack(null);
                      ft.commit();

                  } else {
                      Toast.makeText(vDuration.getContext(), "Choose Time Firstly !", Toast.LENGTH_SHORT).show();
                  }
              }
          }

        );


        return vDuration;

    }


}
