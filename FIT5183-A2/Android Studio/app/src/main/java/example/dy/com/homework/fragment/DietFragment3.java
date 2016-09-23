package example.dy.com.homework.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import example.dy.com.homework.R;
import example.dy.com.homework.adapter.NutrientAdapter;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.ImageDownloader;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/26.
 */
public class DietFragment3 extends Fragment {

    private ListView nListView;
    private TextView nameView;
    private TextView groupView;
    private ImageView image;
    private ProgressBar progressBar;
    private JsonUser u;
    private FragmentManager manager;
    private FragmentTransaction ft;
    private View vDiet;
    private String keyword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vDiet = inflater.inflate(R.layout.fragment_diet3, container, false);




        nListView = (ListView) vDiet.findViewById(R.id.nutrient_list);
        nameView = (TextView) vDiet.findViewById(R.id.food_name);
        groupView = (TextView) vDiet.findViewById(R.id.food_category);
        image = (ImageView) vDiet.findViewById(R.id.food_image);
        progressBar = (ProgressBar) vDiet.findViewById(R.id.progressbar);


        JsonUser u = getArguments().getParcelable("user");
        String foodName = getArguments().getString("foodName");
        String foodCategory = getArguments().getString("foodCategory");
        ArrayList<String> nValue = getArguments().getStringArrayList("nValue");
        ArrayList<String> nName = getArguments().getStringArrayList("nName");
        System.out.println("foodName" + foodName);
        System.out.println("foodCategory" + foodCategory);
        System.out.println("U->" + u);

        for (int i = 0; i < nValue.size(); i++) {
            System.out.println("Nutrient->name=" + nName.get(i) + ",value=" + nValue.get(i));
        }

        nameView.setText("Food Name : "+foodName);
        groupView.setText("Category : " + foodCategory);
        NutrientAdapter nutrientAdapter = new NutrientAdapter(vDiet.getContext(), nName, nValue);
        nListView.setAdapter(nutrientAdapter);


        int i1 = foodName.indexOf(",");
        int i2 = foodName.indexOf(" ");
        int len = i1 < i2 ? i1 : i2;
        keyword = foodName.substring(0, i2);
        System.out.println("keyword->" + keyword);
        //get consume and burned
        new ConnectionUtils(StringUtils.getImageURL(keyword), new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {

                String imagrLink = null;
                try {
                    JSONObject jsonObj = new JSONObject(result.toString());
                    JSONArray jsonArray = jsonObj.getJSONArray("items");
                    JSONObject item = (JSONObject) jsonArray.get(0);
                    imagrLink = item.getString("link");

                    new ImageDownloader(image,progressBar).execute(imagrLink);



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFail() {
                System.out.println("cannot food link");

            }
        }, new String[]{});


        return vDiet;
    }
}
