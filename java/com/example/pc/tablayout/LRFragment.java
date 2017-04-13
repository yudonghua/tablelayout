package com.example.pc.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by PC on 2016/8/21.
 */
public class LRFragment extends Fragment {
    View view;
    LayoutInflater inflater;
    ViewGroup container;
    TextView register_link;
    FragmentTransaction ft;
    Fragment lfragment;
    Fragment rfragment;

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
            view = inflater.inflate(R.layout.login_register, container, false);
            lfragment=getChildFragmentManager().findFragmentById(R.id.loginf);
            rfragment=getChildFragmentManager().findFragmentById(R.id.registerf);
         } catch (InflateException e) {}
        this.inflater=inflater;
        this.container=container;
        register_link = (TextView)view.findViewById(R.id.register_link);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();

        getChildFragmentManager().beginTransaction().hide(rfragment).show(lfragment).commit();
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        if(lfragment !=null){
            getChildFragmentManager().beginTransaction().remove(lfragment).commitAllowingStateLoss();
        }
        if(rfragment !=null){
            getChildFragmentManager().beginTransaction().remove(rfragment).commitAllowingStateLoss();
        }
    }
}
