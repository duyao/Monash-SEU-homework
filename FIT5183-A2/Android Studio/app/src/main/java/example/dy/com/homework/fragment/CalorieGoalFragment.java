package example.dy.com.homework.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/20.
 */
public class CalorieGoalFragment extends Fragment {

    View vGoalUnit;
    private EditText calorieEditText;
    private Button button;
    private static final String IP = StringUtils.IPString;
    private static final String URL = "http://" + IP + "/SportServer/webresources/com.dy.entity.user/updateGoal";

//    private static final String URL = "http://" + IP + ":8080/SportServer/webresources/com.dy.entity.user/updateGoal";
    private FragmentManager manager;
    private FragmentTransaction ft;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vGoalUnit = inflater.inflate(R.layout.fragment_calorie_goal, container, false);
        calorieEditText = (EditText) vGoalUnit.findViewById(R.id.goalText_fragment);
        button = (Button) vGoalUnit.findViewById(R.id.editButton_fragment);
        final JsonUser u = this.getArguments().getParcelable("user");
        System.out.println("goal->" + u);
        calorieEditText.setText(u.getGoal() + "");
        manager = getFragmentManager();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
                final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Confirm");
                builder.setMessage("Are you sure to edit ?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                new ConnectionUtils(URL, new ConnectionUtils.ConnectionCallback() {
                                    @Override
                                    public void onSuccess(Object result) {
//                                        System.out.println(result);
                                        Gson gson = new Gson();
                                        JsonUser newUser= gson.fromJson(result.toString(), new TypeToken<JsonUser>(){}.getType());
//                                        System.out.println(newUser);
                                        MainFragment mainFragment = new MainFragment();
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("user", newUser);
                                        mainFragment.setArguments(bundle);

                                        ft = manager.beginTransaction();
                                        ft.replace(R.id.content_frame, mainFragment);
                                        ft.addToBackStack(null);

                                        ft.commit();




                                    }

                                    @Override
                                    public void onFail() {

                                    }
                                }, u.getId(), calorieEditText.getText().toString());

                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                                System.out.println("NOOOOOOOOOOO");
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });

        return vGoalUnit;
    }


}
