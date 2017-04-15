package com.example.pc.tablayout;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by PC on 2016/8/18.
 */
public class fragment_banner extends Fragment {
    Fragment[] fragment=new Fragment[4];
    MyPagerListener mypl;
    ViewGroup view;
    ViewPager pager;
    ImageView mImageView;
    ImageView mImgCover;
    int mLastPos;
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
            view =(ViewGroup) inflater.inflate(R.layout.fragment_banner, container, false);
            mImageView = (ImageView) view.findViewById(R.id.img_indicator01);
            mImgCover = (ImageView) view.findViewById(R.id.img_cover);
            initControls(view);
        } catch (InflateException e) {}

        return view;
    }
    private void initControls(ViewGroup view) {
        pager = (ViewPager) view.findViewById(R.id.pager_banner);
        mypl = new MyPagerListener();
        ShopAdapter shopAdapter=new ShopAdapter(getChildFragmentManager());
        pager.setAdapter(shopAdapter);
        pager.setOnPageChangeListener(mypl);
        //初始化各fragment
//        fragment_home_menu fragment[]=new fragment_home_menu[4];
//
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
//        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }
    private class ShopAdapter extends FragmentPagerAdapter {
        public ShopAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int arg0) {
            fragment[arg0%4] =new fragment_banner_item();

            return fragment[arg0%4];
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        for(int i=0;i<4;i++){
            if(fragment[i]!=null){
                getChildFragmentManager().beginTransaction().remove(fragment[i]).commitAllowingStateLoss();
                pager.removeOnPageChangeListener(mypl);
            }
        }

    }
    class MyPagerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            if(mImgCover ==null) Log.d("-->", "image null");
            int width = mImgCover.getWidth();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mImageView
                    .getLayoutParams();
            int rightMargin = layoutParams.rightMargin;
            int endPos = (width + rightMargin) * (position % 4);
            int startPos = 0;
            if (mLastPos < position) {
                // ͼƬ�����ƶ�
                startPos = (width + rightMargin) * (position % 4 - 1);
            } else {
                // ͼƬ�����ƶ�
                startPos = (width + rightMargin) * (position % 4 + 1);
            }
            ObjectAnimator.ofFloat(mImgCover, "translationX", startPos, endPos)
                    .setDuration(300).start();
            mLastPos = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    }

}

