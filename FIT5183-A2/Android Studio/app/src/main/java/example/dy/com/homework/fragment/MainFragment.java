package example.dy.com.homework.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonUser;


public class MainFragment extends Fragment {

    View vMain;
    private TextView curUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vMain = inflater.inflate(R.layout.fragment_main, container, false);

        curUser = (TextView) vMain.findViewById(R.id.curUser_mainFrag);
        JsonUser u  = this.getArguments().getParcelable("user");
        System.out.println("frag u->" + u);
        curUser.setText(u.getName());

        return vMain;
    }
}
