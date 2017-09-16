package com.example.shru.tabslidingexample;

/**
 * Created by Shru on 23/3/2016.
 */
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class Tab1 extends Fragment {

    private static final String TAG = "Tab1";
    ViewPager viewPager,viewPager2,viewPager3;
    View vw;

    private static final String [] text={"Android","Ios","BlackBerry","Windows","Abc","Bcd"};
    private static final Integer[] IMAGES = {R.drawable.lightblueimage, R.drawable.greenimage, R.drawable.pinkimage, R.drawable.ic_launcher, R.drawable.color, R.drawable.image1};


    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private ArrayList<String> textArray = new ArrayList<>();
    private  CustomSlidingAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vw = inflater.inflate(R.layout.tab_1, container, false);
        init();

        Integer value = getActivity().getIntent().getExtras().getInt("value_1");
        Integer value2=getActivity().getIntent().getExtras().getInt("value_2");

        // to create buttons dynamically
        RelativeLayout rl = (RelativeLayout) vw.findViewById(R.id.rel);

        HorizontalScrollView sv = new HorizontalScrollView(this.getActivity());
        sv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        sv.setHorizontalScrollBarEnabled(false);
        LinearLayout ll = new LinearLayout(this.getActivity());
        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ll.setOrientation(LinearLayout.HORIZONTAL);
        sv.addView(ll);

        for (
                int i = 0;
                i < value; i++)

        {
            Button b = new Button(this.getActivity());
            b.setBackground(this.getResources().getDrawable(R.drawable.layou_border));
            LinearLayout.LayoutParams rel_button1 = new LinearLayout.LayoutParams(190, 60);
            rel_button1.setMargins(5, 10, 0, 0);
            b.setLayoutParams(rel_button1);
            b.setText("Button " + i);
            b.setTextColor(Color.WHITE);
            b.setTextSize(15);

            //to show toast message onclick of every button.
            final int index=i;
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Log.i("TAG", "index :" + index);

                    Toast.makeText(getActivity(),
                            "Clicked Button Index :" + index,
                            Toast.LENGTH_LONG).show();

                }
            });
            ll.addView(b);
        }

        rl.addView(sv);

        //to create dynamic viewpager
        LinearLayout relpv = (LinearLayout) vw.findViewById(R.id.relpageviewer);
        relpv.setOrientation(LinearLayout.VERTICAL);

        for (
                int i = 0;
                i < value2; i++)

        {

            adapter=new CustomSlidingAdapter(this.getActivity(), ImagesArray,textArray);
            viewPager = new ViewPager(this.getActivity());
            LinearLayout.LayoutParams rel_viewpager1 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
            rel_viewpager1.setMargins(0, 10, 0, 0);
            viewPager.setLayoutParams(rel_viewpager1);
            viewPager.setAdapter(adapter);
            relpv.addView(viewPager);
        }
        return vw;
    }

    private void init() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        for(int j=0; j<text.length;j++)
            textArray.add(text[j]);

    }
}

