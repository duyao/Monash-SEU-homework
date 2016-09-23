package example.dy.com.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;

import example.dy.com.homework.R;

/**
 * Created by dy on 2016/4/22.
 */
public class CategoryAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private String[] categories;
    private viewHolder holder;
    HashMap<Integer, Boolean> isSelected;

    public class viewHolder {
        public TextView categoryText;
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

    public CategoryAdapter(Context c, String[] categories) {
        super();

        this.c = c;
        this.categories = categories;
        inflater = LayoutInflater.from(c);
        isSelected = new HashMap<>();
        for (int i = 0; i < categories.length; i++) {
            isSelected.put(i, false);

        }
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int position) {
        return categories[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //button focusable must add !!!
    public void select(int position) {
        if (!isSelected.get(position)) {
            isSelected.put(position, true);
            for (int i = 0; i < isSelected.size(); i++) {
                if (i != position) {
                    isSelected.put(i, false);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            holder = new viewHolder();
            convertView = inflater.inflate(R.layout.category_item_diet_fragment, null);
            holder.selectButton = (RadioButton) convertView.findViewById(R.id.radioCaterogy);
            holder.selectButton.setChecked(false);
            holder.categoryText = (TextView) convertView.findViewById(R.id.categoryText);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.selectButton.setChecked(isSelected.get(position));
        holder.categoryText.setText(categories[position]);
        return convertView;

//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.category_item_diet_fragment, null);
//            holder = new viewHolder();
//            holder.categoryText = (TextView) convertView.findViewById(R.id.categoryText);
//            holder.selectButton = (RadioButton) convertView.findViewById(R.id.radioCaterogy);
//            convertView.setTag(holder);
//        } else {
//            holder = (viewHolder) convertView.getTag();
//        }
//
//        holder.categoryText.setText(categories[position]);
////        holder.selectButton
////                .setOnCheckedChangeListener(new OnCheckedChangeListener() {
////
////                    @Override
////                    public void onCheckedChanged(CompoundButton buttonView,
////                                                 boolean isChecked) {
////                        if (isChecked) {
////                            System.out.println("select c->"+categories[position]);
////                            index = position;
////                            notifyDataSetChanged();
////                        }
////                    }
////                });
//
//        if (index == position) {
//            holder.selectButton.setChecked(true);
//        } else {
//            holder.selectButton.setChecked(false);
//        }
//        return convertView;
    }
}
