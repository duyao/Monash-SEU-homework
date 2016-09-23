package example.dy.com.homework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.StringUtils;

public class RegisterActivity extends AppCompatActivity {
    private TextView nameText;
    private TextView passwdText;
    private TextView ageText;
    private TextView heightText;
    private TextView weightText;
    private TextView stepText;
    private TextView goalText;
    private RadioGroup radioGroup;
    private RadioButton maleRadio;
    private RadioButton femaleRadio;
    private Spinner spinner;
    String gender = "";

    private static final String IP = StringUtils.IPString;
    //    private  static final String IP = "172.16.153.14";
    private static final String URL = "http://"+IP + "/SportServer/webresources/com.dy.entity.user";

//    private static final String URL = "http://" + IP + ":8080/SportServer/webresources/com.dy.entity.user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nameText = (TextView) this.findViewById(R.id.nameText);
        passwdText = (TextView) this.findViewById(R.id.passwdText);
        ageText = (TextView) this.findViewById(R.id.ageText);
        heightText = (TextView) this.findViewById(R.id.heightText);
        weightText = (TextView) this.findViewById(R.id.weightText);
        stepText = (TextView) this.findViewById(R.id.stepText);
        goalText = (TextView) this.findViewById(R.id.goalText);
        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);
        maleRadio = (RadioButton) this.findViewById(R.id.maleRadio);
        femaleRadio = (RadioButton) this.findViewById(R.id.femaleRadio);
        spinner = (Spinner) this.findViewById(R.id.spinner);

        String[] typeArray = new String[]{
                "1 - Little/no exercise (sedentary)",
                "2 - Lightly active (exercise/sports 1-3 days/week)",
                "3 - Moderately active (exercise/sports 3-5 days/week)",
                "4 - Very active (hard exercise/sports 6-7 days/wk)",
                "5 - Extra active (very hard exercise/sports or training)"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, typeArray);
        spinner.setAdapter(adapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == maleRadio.getId()) {
                    gender = "0";
                } else {
                    gender = "1";
                }
            }
        });




    }

    public void register(View view) {
        boolean flag = true;
        String tmp = (String) spinner.getSelectedItem();
        String level = tmp.substring(0, 1);
        String name = nameText.getText().toString();
        String passwd = passwdText.getText().toString();
        String age = ageText.getText().toString();
        String height = heightText.getText().toString();
        String weight = weightText.getText().toString();
        String step = stepText.getText().toString();
        String goal = goalText.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(passwd) || TextUtils.isEmpty(age) || TextUtils.isEmpty(height) ||
                TextUtils.isEmpty(weight) || TextUtils.isEmpty(step) || TextUtils.isEmpty(goal)) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Empty Field",
                    Toast.LENGTH_SHORT).show();

        }

        if (flag) {
            Gson gson = new Gson();
            final JsonUser user = new JsonUser(name, passwd, Integer.valueOf(age), gender.charAt(0),
                    Double.valueOf(height), Double.valueOf(weight), Integer.valueOf(level), Integer.valueOf(step), Integer.valueOf(goal));
            String s = gson.toJson(user);
            System.out.println("generate json" + s);
            new ConnectionUtils(URL, new ConnectionUtils.ConnectionCallback() {
                @Override
                public void onSuccess(Object result) {
                    if ("204".equals(result.toString())) {
                        Toast.makeText(getApplicationContext(), "Register Successfully, then Sign In",
                                Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        onFail();
                    }

                }

                @Override
                public void onFail() {

                }
            }, s, 0);
        }

    }
}