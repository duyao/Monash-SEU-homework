package example.dy.com.homework.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import example.dy.com.homework.R;
import example.dy.com.homework.adapter.FoodAdapter;
import example.dy.com.homework.entity.JsonFood;
import example.dy.com.homework.entity.JsonIntake;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.entity.OFood;
import example.dy.com.homework.entity.ONutrient;
import example.dy.com.homework.entity.OReslut;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.DatabaseHelper;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/22.
 */
public class DietFragment2 extends Fragment {
    private View vDiet;
    private ListView foodListView;
    private Button addButton;
    private Button detailButton;
    private DatabaseHelper databaseHelper;
    private JsonUser u;
    private FragmentManager manager;
    private FragmentTransaction ft;
    private FoodAdapter adapter;
    private int selectedPosition = -1;
    List<JsonFood> list;
    private static final String IP = StringUtils.IPString;
    final static String URL = "http://" + IP + "/SportServer/webresources/com.dy.entity.food/findByServing";
    final static String ADDURL = "http://" + IP + "/SportServer/webresources/com.dy.entity.intake";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //1. get String of foodList
        //2. selct food info based on food list
        //3. fisrt show category, show food name, fat, details, add or decrease, weight (get from API)
        //4. checkbox? or radio

        vDiet = inflater.inflate(R.layout.fragment_diet2, container, false);

        foodListView = (ListView) vDiet.findViewById(R.id.food_listview);
        addButton = (Button) vDiet.findViewById(R.id.addnum_food_button);
        detailButton = (Button) vDiet.findViewById(R.id.detail_food_button);
        databaseHelper = new DatabaseHelper(vDiet.getContext());
        manager = getFragmentManager();
        Bundle b = getArguments();
        String category = "";
        if (b != null) {
            u = this.getArguments().getParcelable("user");
            category = this.getArguments().getString("category");
        }

        new ConnectionUtils(URL, new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("reslut" + result);
                Gson gson = new Gson();
                //Json object array [{..},{}]

                list = gson.fromJson(result.toString(), new TypeToken<List<JsonFood>>() {
                }.getType());

                adapter = new FoodAdapter(vDiet.getContext(), list);
                foodListView.setAdapter(adapter);

                foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        adapter.select(position);
                        selectedPosition = position;

                    }
                });

            }

            @Override
            public void onFail() {
                System.out.println("cannot find food in server");

            }
        }, category);


//        //after submitting return this view
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText editText = new EditText(vDiet.getContext());
                editText.setEms(3);
                editText.setWidth(5);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                AlertDialog.Builder builder = new AlertDialog.Builder(vDiet.getContext());
                builder.setTitle("Input the quantity of food");
                builder.setView(editText);
                builder.setPositiveButton("finish",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Double quantity = Double.valueOf(editText.getText().toString().trim());
                                System.out.println("num" + quantity);
                                System.out.println("selelted item->" + list.get(selectedPosition));

                                //add into database, post
                                Gson gson = new Gson();
                                final JsonIntake intake = new JsonIntake(list.get(selectedPosition), quantity, u);
                                String s = gson.toJson(intake);
                                System.out.println("generate json" + s);
                                new ConnectionUtils(ADDURL, new ConnectionUtils.ConnectionCallback() {
                                    @Override
                                    public void onSuccess(Object result) {
                                        if ("204".equals(result.toString())) {
                                            Toast.makeText(getActivity(),"Add successfully!",Toast.LENGTH_LONG).show();
                                            MainFragment mainFragment = new MainFragment();
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable("user", u);
                                            mainFragment.setArguments(bundle);

                                            ft = manager.beginTransaction();
                                            ft.replace(R.id.content_frame, mainFragment);
                                            ft.addToBackStack(null);

                                            ft.commit();

                                        } else {
                                            onFail();
                                        }

                                    }

                                    @Override
                                    public void onFail() {

                                    }
                                }, s, 0);


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
                builder.show();


            }
        });


        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String url = "http://api.nal.usda.gov/ndb/reports/?ndbno=" + list.get(selectedPosition).getId() +
                        "&type=f&format=json&api_key=p5aLD8nQMekwaaiWIlAQZu3Lr9LSdL75YEMK0CIP";
                System.out.println("Myurl->" + url);


                new ConnectionUtils(url, new ConnectionUtils.ConnectionCallback() {
                    @Override
                    public void onSuccess(Object result) {
                        System.out.println("reslut" + result);
                        Gson gson = new Gson();
                        //Json object array [{..},{}]

                        OReslut apiResult = gson.fromJson(result.toString(), new TypeToken<OReslut>() {
                        }.getType());

                        OFood food =apiResult.getReport().getFood();
                        List<ONutrient> nutrients = food.getNutrients();
                        int[] nutrientList = new int[]{268, 203, 204, 255, 269};
//                        String[] nutrientName = new String[]{"Energy", "Protein", "Total lipid (fat)", "Carbohydrate", "Sugars total"};
//                        Double cal = 0.0;
                        ArrayList<String> nName = new ArrayList<String>();
                        ArrayList<String> nValue = new ArrayList<String>();
                        for (ONutrient tmp : nutrients) {
//                            System.out.println(tmp);
                            for (int i = 0; i < nutrientList.length; i++) {
                                if (tmp.getNutrient_id() == nutrientList[i]) {
                                    nName.add(tmp.getName());
                                    nValue.add(tmp.getValue()+" "+tmp.getUnit());

                                    System.out.println("get->" + tmp.getNutrient_id() + "," + tmp.getName() + "," + tmp.getValue() + "," + tmp.getUnit());
                                }

                            }
                        }



                        DietFragment3 dietFragment3 = new DietFragment3();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("user", u);
                        bundle.putString("foodName", food.getName());
                        bundle.putString("foodCategory", food.getFg());
                        bundle.putStringArrayList("nName", nName);
                        bundle.putStringArrayList("nValue",nValue);


                        dietFragment3.setArguments(bundle);


                        ft = manager.beginTransaction();
                        ft.replace(R.id.content_frame, dietFragment3);
                        ft.addToBackStack(null);

                        ft.commit();



                    }

                    @Override
                    public void onFail() {
                        System.out.println("cannot find food in api");

                    }
                }, new String[]{});


            }
        });


        return vDiet;
    }
}
