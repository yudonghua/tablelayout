package com.example.pc.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC on 2016/8/21.
 */
public class HomeFragment extends Fragment {
    View item_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_home, container, false);
        FlowLayout flowLayout = (FlowLayout)view.findViewById(R.id.flow);
        initControls(inflater,container,flowLayout);
        return view;
    }
    private void initControls(LayoutInflater inflater,ViewGroup container,FlowLayout flowLayout) {
        for(int i = 0;i<10;i++){
            item_view = (View) inflater.inflate(R.layout.item_goods, container, false);
            TextView text1 = (TextView) item_view.findViewById(R.id.speed_name);
            text1.setText("test"+i);
            flowLayout.addView(item_view);
        }
    }
}
