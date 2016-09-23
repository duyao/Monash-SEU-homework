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

import example.dy.com.homework.R;
import example.dy.com.homework.adapter.CategoryAdapter;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.myUtil.DatabaseHelper;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/22.
 */
public class DietFragment1 extends Fragment {
    private View vDiet;
    private ListView dietListView;
    private Button button;
    private DatabaseHelper databaseHelper;
    private JsonUser u;
    private FragmentManager manager;
    private FragmentTransaction ft;
    private int selectedPosition = -1;
    private String[] list;
    private String[] listId;
    private CategoryAdapter adapter;
    private static final String IP = StringUtils.IPString;
    final static String URL = "http://" + IP + "/SportServer/webresources/com.dy.entity.food/findByServing";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vDiet = inflater.inflate(R.layout.fragment_diet1, container, false);

        dietListView = (ListView) vDiet.findViewById(R.id.category_listview);
        button = (Button) vDiet.findViewById(R.id.select_diet_button);

        databaseHelper = new DatabaseHelper(vDiet.getContext());
        manager = getFragmentManager();

        u = this.getArguments().getParcelable("user");
//        System.out.println("setp->u" + u);

        list = new String[]{"Pork Products", "Fruits and Fruit Juices", "Meals, Entrees, and Side Dishes", "Vegetables and Vegetable Products", "Soups, Sauces, and Gravies", "Breakfast Cereals"};
        listId = new String[]{"1000","0900","2200","1100","0600","0800"};
        adapter = new CategoryAdapter(vDiet.getContext(), list);
        dietListView.setAdapter(adapter);

        dietListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.select(position);
                selectedPosition = position;

            }
        });

        //after submitting return this view
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println("click" + selectedPosition);
                String s = list[selectedPosition].replace(' ','&');

                DietFragment2 dietFragment2 = new DietFragment2();
                Bundle bundle = new Bundle();
                bundle.putParcelable("user", u);
                bundle.putString("category", s);
//                System.out.println("category in 1"+s);
                dietFragment2.setArguments(bundle);


                ft = manager.beginTransaction();
                ft.replace(R.id.content_frame, dietFragment2);
                ft.addToBackStack(null);
                ft.commit();

            }
        });


        return vDiet;
    }
}
