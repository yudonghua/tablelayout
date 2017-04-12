package com.example.pc.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private HomeFragment homeFragment;              //热门推荐fragment
    private Fragment1 fragment1;            //热门收藏fragment
    private FindFragment hotMonthFragment;                      //本月热榜fragment
    private FindFragment hotToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_FindFragment_title = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager) findViewById(R.id.vp_FindFragment_pager);

        //初始化各fragment
        homeFragment = new HomeFragment();
        fragment1 = new Fragment1();
        hotMonthFragment = new FindFragment();
        hotToday = new FindFragment();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(homeFragment);
        list_fragment.add(fragment1);
        list_fragment.add(hotMonthFragment);
        list_fragment.add(hotToday);


        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("首页");
        list_title.add("分类");
        list_title.add("购物车");
        list_title.add("我的");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));

        fAdapter = new Find_tab_Adapter(getSupportFragmentManager(), list_fragment, list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);

        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        tab_FindFragment_title.getTabAt(0).setIcon(R.drawable.main_bottom_tab_home_focus);
        tab_FindFragment_title.getTabAt(1).setIcon(R.drawable.main_bottom_tab_category_focus);
        tab_FindFragment_title.getTabAt(2).setIcon(R.drawable.main_bottom_tab_cart_focus);
        tab_FindFragment_title.getTabAt(3).setIcon(R.drawable.main_bottom_tab_personal_focus);
        //tab_FindFragment_title.set
    }
}
