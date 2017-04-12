package com.example.pc.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;


import com.example.pc.tablayout.Find_tab_Adapter;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {

    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private Fragment1 fragment1;//今日热榜fragment
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Fragment1 fragment5;//今日热榜fragment
    private Fragment2 fragment6;
    private Fragment3 fragment7;
    private Fragment4 fragment8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.layout, container, false);
        initControls(view);
        return view;
    }

    private void initControls(ViewGroup view) {
        tab_FindFragment_title = (TabLayout) view.findViewById(R.id.tab_FindFragment_title2);
        vp_FindFragment_pager = (ViewPager) view.findViewById(R.id.vp_FindFragment_pager2);

        //初始化各fragment
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment1();
        fragment6 = new Fragment2();
        fragment7 = new Fragment3();
        fragment8 = new Fragment4();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(fragment1);
        list_fragment.add(fragment2);
        list_fragment.add(fragment3);
        list_fragment.add(fragment4);
        list_fragment.add(fragment5);
        list_fragment.add(fragment6);
        list_fragment.add(fragment7);
        list_fragment.add(fragment8);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        list_title.add("本月热榜");
        list_title.add("今日热榜");
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        list_title.add("本月热榜");
        list_title.add("今日热榜");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(4)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(5)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(6)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(7)));

        fAdapter = new Find_tab_Adapter(getActivity().getSupportFragmentManager(), list_fragment, list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }


}

