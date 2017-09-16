package com.example.shru.tabslidingexample;

/**
 * Created by Shru on 3/2/2016.
 */
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment {
    private static final String TAG = "Tab1";
    ViewPager viewPagertab1,viewPagertab2;
    View vw;
    private static final String [] text={"Android","Ios","BlackBerry","Windows","Xp","ubantu"};
    private static final String [] text1={"Android","Ios","BlackBerry","Windows","Xp","ubantu"};
    private static final Integer[] IMAGES = {R.drawable.greenimage, R.drawable.header, R.drawable.blueimage, R.drawable.image1};
    private static final Integer[] IMAGES1 = {R.drawable.pinkimage, R.drawable.lightblueimage, R.drawable.blueimage, R.drawable.header};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private ArrayList<String> textArray = new ArrayList<>();
    private ArrayList<Integer> ImagesArray1 = new ArrayList<Integer>();
    private ArrayList<String> textArray1 = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vw = inflater.inflate(R.layout.tab_2, container, false);
        init();

        // to create buttons dynamically
        RelativeLayout rl2 = (RelativeLayout) vw.findViewById(R.id.reltab2);

        HorizontalScrollView sv = new HorizontalScrollView(this.getActivity());
        sv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        sv.setHorizontalScrollBarEnabled(false);
        LinearLayout ll = new LinearLayout(this.getActivity());
        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ll.setOrientation(LinearLayout.HORIZONTAL);
        sv.addView(ll);

        for (int i = 0; i < 3; i++)

        {
            Button b = new Button(this.getActivity());
            b.setBackground(this.getResources().getDrawable(R.drawable.layou_border));
            LinearLayout.LayoutParams rel_button1 = new LinearLayout.LayoutParams(190, 60);
            rel_button1.setMargins(40, 10, 0, 0);
            b.setLayoutParams(rel_button1);
            b.setText("Button " + i);
            b.setTextColor(Color.WHITE);
            b.setTextSize(15);

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

        rl2.addView(sv);
        return vw;
    }
    private void init() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        for(int j=0; j<text.length;j++)
            textArray.add(text[j]);
        for (int k = 0; k < IMAGES1.length; k++)
            ImagesArray1.add(IMAGES1[k]);
        for(int L=0; L<text1.length;L++)
            textArray1.add(text1[L]);
        viewPagertab1 = (ViewPager) vw.findViewById(R.id.pager);
        viewPagertab2=(ViewPager)vw.findViewById(R.id.pager2);

        viewPagertab1.setAdapter(new CustomSlidingAdapter(this.getActivity(), ImagesArray,textArray));
        viewPagertab2.setAdapter(new CustomSlidingAdapter(this.getActivity(), ImagesArray1,textArray1));
    }
}
