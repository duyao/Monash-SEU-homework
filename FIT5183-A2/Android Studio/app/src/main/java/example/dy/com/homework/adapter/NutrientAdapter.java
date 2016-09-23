package example.dy.com.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import example.dy.com.homework.R;


/**
 * Created by dy on 2016/4/27.
 */
public class NutrientAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> nName;
    private ArrayList<String> nValue;

    public NutrientAdapter(Context context, ArrayList<String> nName, ArrayList<String> nValue) {
        this.context = context;
        this.nName = nName;
        this.nValue = nValue;
    }

    @Override
    public int getCount() {
        return nValue.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.nutrient_item_diet_fragment, null);
        }
        TextView nameView = (TextView)view.findViewById(R.id.nutrient_name);
        TextView valueView = (TextView)view.findViewById(R.id.nutrient_value);
        nameView.setText(nName.get(position));
        valueView.setText(nValue.get(position));


        return view;
    }
}
