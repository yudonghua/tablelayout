package com.example.pc.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC on 2016/8/21.
 */
public class Fragment1 extends Fragment {
    View view;
    LayoutInflater inflater;
    ViewGroup container;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.layout2, container, false);
        this.view=view;
        this.inflater=inflater;
        this.container=container;
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        FlowLayoutView flowLayout = (FlowLayoutView)view.findViewById(R.id.flow2);
        View item_view;
        for(int i = 0;i<10;i++){
            item_view = (View) inflater.inflate(R.layout.item_goods, container, false);
            TextView text1 = (TextView) item_view.findViewById(R.id.speed_name);
            text1.setText("test"+i);
            flowLayout.addView(item_view);
        }
    }
}
