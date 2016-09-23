package example.dy.com.homework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import example.dy.com.homework.R;
import example.dy.com.homework.myUtil.StringUtils;
import example.dy.com.homework.myUtil.ConnectionUtils;

public class MainActivity extends AppCompatActivity {
    private EditText nameText;
    private EditText passwordText;

    private  static final String IP = StringUtils.IPString;
    //    private  static final String IP = "172.16.153.14";

    private static final String URL = "http://"+IP+"/SportServer/webresources/com.dy.entity.user/checkUser";

//    private static final String URL = "http://"+IP+":8080/SportServer/webresources/com.dy.entity.user/checkUser";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameText = (EditText)findViewById(R.id.name);
        passwordText = (EditText)findViewById(R.id.password);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void signIn(View view) {

        final String userName = nameText.getText().toString().trim();
        final String password = passwordText.getText().toString().trim();
        new ConnectionUtils(URL, new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
                String res = (String) result;
                if("true".equals(res)){
                    Intent i = new Intent(MainActivity.this, ContentActivity.class);
                    i.putExtra("userName", userName);
                    startActivity(i);
                    MainActivity.this.finish();
                }else{
                    onFail();
                }

            }

            @Override
            public void onFail() {
                Toast.makeText(getApplicationContext(), "Wrong name or password",
                        Toast.LENGTH_SHORT).show();
                nameText.setText("");
                passwordText.setText("");

            }
        },userName,password);


    }


    public void signUp(View view) {
        Intent i = new Intent(MainActivity.this, RegisterActivity.class);
//        Intent i = new Intent(MainActivity.this, MapsActivity.class);

        startActivity(i);
    }




}
