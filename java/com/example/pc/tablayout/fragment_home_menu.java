package com.example.pc.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by PC on 2016/8/18.
 */
public class fragment_home_menu extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.home_menu, container, false);
        ImageView mImageView = (ImageView) view.findViewById(R.id.imageView1);
        return view;
    }

}

