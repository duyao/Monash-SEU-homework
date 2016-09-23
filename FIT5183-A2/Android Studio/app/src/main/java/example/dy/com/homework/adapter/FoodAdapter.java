package example.dy.com.homework.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonFood;

/**
 * Created by dy on 2016/4/23.
 */
public class FoodAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<JsonFood> foodItems;
    private viewHolder holder;
    HashMap<String, Boolean> isSelected;

    public class viewHolder {
        public TextView foodNameText;
        private TextView foodCalText;
//        private EditText numFood;
        public RadioButton selectButton;

    }

    private int index = -1;
    private Context c;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public FoodAdapter(Context c, List<JsonFood> foodItems) {
        super();

        this.c = c;
        this.foodItems = foodItems;
        inflater = LayoutInflater.from(c);
        isSelected = new HashMap<>();
        for (int i = 0; i < foodItems.size(); i++) {
            isSelected.put(foodItems.get(i).getId(), false);
        }

    }

    @Override
    public int getCount() {
        return foodItems.size();
    }

    @Override
    public Object getItem(int position) {
        return foodItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //button focusable must add !!!
    public void select(int position) {
        if (!isSelected.get(foodItems.get(position).getId())) {
            isSelected.put(foodItems.get(position).getId(), true);

            for (int i = 0; i < isSelected.size(); i++) {
                if (i != position) {
                    isSelected.put(foodItems.get(i).getId(), false);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            holder = new viewHolder();
            convertView = inflater.inflate(R.layout.food_item_diet_fragment, null);
            holder.selectButton = (RadioButton) convertView.findViewById(R.id.radioFood);
            holder.selectButton.setChecked(false);
            holder.foodNameText = (TextView) convertView.findViewById(R.id.name_food_text);
            holder.foodCalText =(TextView) convertView.findViewById(R.id.cal_food_text);
//            holder.numFood = (EditText) convertView.findViewById(R.id.number_food);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        JsonFood food = foodItems.get(position);
        holder.selectButton.setChecked(isSelected.get(food.getId()));
        holder.foodNameText.setText(food.getName());
        holder.foodCalText.setText(food.getCalorie());
//        holder.numFood.setText("1");



        return convertView;


    }

}
