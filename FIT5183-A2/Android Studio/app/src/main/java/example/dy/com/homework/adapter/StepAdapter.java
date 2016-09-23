package example.dy.com.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.Step;

/**
 * Created by dy on 2016/4/21.
 */
public class StepAdapter extends BaseAdapter {
    private Context context;
    private List<Step> steps;

    public StepAdapter(Context context, List<Step> steps) {
        this.context = context;
        this.steps = steps;
    }

    @Override
    public int getCount() {
        return steps.size();
    }

    @Override
    public Object getItem(int position) {
        return steps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.step_item_listview, null);
        }
        TextView dateView = (TextView)view.findViewById(R.id.dateText_step_fragment);
        TextView stepView = (TextView)view.findViewById(R.id.stepText_step_fragment);
        String s = steps.get(position).getDate();
        dateView.setText(s.substring(11,s.length()));
        stepView.setText(String.valueOf(steps.get(position).getSteps()));


        return view;
    }

}
