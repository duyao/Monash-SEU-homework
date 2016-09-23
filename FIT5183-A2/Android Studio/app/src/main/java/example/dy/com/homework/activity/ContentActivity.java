package example.dy.com.homework.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import example.dy.com.homework.fragment.CalTrackFragment;
import example.dy.com.homework.fragment.CalorieGoalFragment;
import example.dy.com.homework.fragment.DietFragment1;
import example.dy.com.homework.fragment.MainFragment;
import example.dy.com.homework.fragment.MapFragment;
import example.dy.com.homework.R;
import example.dy.com.homework.fragment.ReprotFragment;
import example.dy.com.homework.fragment.StepFragment;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.entity.User;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.DatabaseHelper;
import example.dy.com.homework.myUtil.StringUtils;

public class ContentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView nameText;
    private String curUserName;
    private DatabaseHelper dbHelper;
    private static final String IP = StringUtils.IPString;
    private static final String URL = "http://" + IP + "/SportServer/webresources/com.dy.entity.user/findByName";

    private JsonUser user = null;
    private static final String UPDATEUSER = "http://" + IP + "/SportServer/webresources/com.dy.entity.user";


    private TextView curNameTextView;
    private FragmentManager fragmentManager = null;
    private Fragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getFragmentManager();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
/*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/


        Intent i = getIntent();
        curUserName = (String) i.getSerializableExtra("userName");
        curNameTextView = (TextView) header.findViewById(R.id.curName);

        curNameTextView.setText(curUserName);
//        curNameContent.setText(curUserName);

        dbHelper = new DatabaseHelper(getApplicationContext());

        //get Usr by name
        new ConnectionUtils(URL, new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
//                System.out.println("reslut"+result);
                Gson gson = new Gson();
                //Json object array [{..},{}]
                List<JsonUser> list = gson.fromJson(result.toString(), new TypeToken<List<JsonUser>>() {
                }.getType());
                user = list.get(0);
//                System.out.println("fromJson->"+user);
                dbHelper.findAllUser();
                System.out.println("insert before===================");
                dbHelper = new DatabaseHelper(getApplicationContext());
                if (dbHelper.checkUser(curUserName)) {
                    System.out.println("exsist");
                } else {
                    System.out.println("add User");
                    User tmp = new User();
                    tmp.setId(user.getId());
                    tmp.setName(user.getName());
                    tmp.setPassword(StringUtils.getPasswordEncryption(user.getPassword()));
                    tmp.setLatitude(0);
                    tmp.setLongitude(0);
                    tmp.setRegistration(StringUtils.getCurTime());
                    dbHelper.addUser(tmp);
                }
//                System.out.println("insert after===================");
                dbHelper.findAllUser();

                Bundle bundle = new Bundle();
                bundle.putParcelable("user", user);

                mainFragment = new MainFragment();

                mainFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.content_frame, mainFragment, "mainFragment").commit();

            }

            @Override
            public void onFail() {
                System.out.println("cannot find user in server");

            }
        }, curUserName);


    }

    @Override
    public void onBackPressed() {


        if (getFragmentManager().getBackStackEntryCount() == 0) {
            System.out.println("mainFragment->" + mainFragment.getTag());

            if (getFragmentManager().findFragmentByTag("mainFragment") == mainFragment) {
                super.onBackPressed();
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelable("user", user);
//            MainFragment mainFragment = new MainFragment();
                mainFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.content_frame, mainFragment, "mainFragment").commit();

            }

        } else {
            getFragmentManager().popBackStack();
        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content, menu);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment nextFragment = null;


        if (id == R.id.nav_calorie_goal) {
            nextFragment = new CalorieGoalFragment();
        } else if (id == R.id.nav_progress_report) {
            nextFragment = new ReprotFragment();

        } else if (id == R.id.nav_steps) {
            nextFragment = new StepFragment();

        } else if (id == R.id.nav_track_calorie) {
            nextFragment = new CalTrackFragment();

        } else if (id == R.id.nav_map) {
            nextFragment = new MapFragment();

        } else if (id == R.id.nav_diet) {
            nextFragment = new DietFragment1();

        }

        //get Usr by name
        final Fragment finalNextFragment = nextFragment;
        new ConnectionUtils(UPDATEUSER, new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
//                System.out.println("reslut"+result);
                Gson gson = new Gson();
                JsonUser newUser = gson.fromJson(result.toString(), new TypeToken<JsonUser>() {
                }.getType());
//                System.out.println("fromJson->" + newUser);

                Bundle bundle = new Bundle();
                bundle.putParcelable("user", newUser);
                finalNextFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.content_frame, finalNextFragment).addToBackStack(null).commit();


            }

            @Override
            public void onFail() {
                System.out.println("cannot find user in server");

            }
        }, user.getId());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
