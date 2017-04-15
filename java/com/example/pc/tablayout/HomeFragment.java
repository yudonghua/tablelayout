package com.example.pc.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.InflateException;
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
    View view;
    Fragment fragment_b;
    Fragment fragment_h;
    Fragment fragment_m;
    Fragment fragment_s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.activity_home, container, false);
            fragment_b=getChildFragmentManager().findFragmentById(R.id.f_banner);
            fragment_h=getChildFragmentManager().findFragmentById(R.id.f_home);
            fragment_m=getChildFragmentManager().findFragmentById(R.id.f_h_menu);
            fragment_s=getChildFragmentManager().findFragmentById(R.id.f_h_special);
        } catch (InflateException e) {}

        return view;
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        if(fragment_b !=null){
            getChildFragmentManager().beginTransaction().remove(fragment_b).commitAllowingStateLoss();
        }
        if(fragment_h !=null){
            getChildFragmentManager().beginTransaction().remove(fragment_h).commitAllowingStateLoss();
        }
        if(fragment_m !=null){
            getChildFragmentManager().beginTransaction().remove(fragment_m).commitAllowingStateLoss();
        }
        if(fragment_s !=null){
            getChildFragmentManager().beginTransaction().remove(fragment_s).commitAllowingStateLoss();
        }
    }
}
