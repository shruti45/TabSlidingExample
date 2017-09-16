package com.example.shru.tabslidingexample;

/**
 * Created by user on 3/23/2016.
 */
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 3/19/2016.
 */
public class CustomSlidingAdapter extends PagerAdapter {
    private Context context ;
    TextView tv1,tv2;
    private LayoutInflater inflater;
    private ArrayList<Integer> IMAGES;
    private ArrayList<String> TEXT;



    public CustomSlidingAdapter(Context context,ArrayList<Integer> IMAGES,ArrayList<String> Text){
        this.context = context;
        this.IMAGES=IMAGES;
        this.TEXT=Text;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return IMAGES.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.sliding_image, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.slidingimage);
         tv1=(TextView)imageLayout.findViewById(R.id.text1);
         tv2=(TextView)imageLayout.findViewById(R.id.text2);


        imageView.setImageResource(IMAGES.get(position));
        tv1.setText(TEXT.get(position));
        tv2.setText(TEXT.get(position));

        view.addView(imageLayout, 0);

        return imageLayout;
    }
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.45f;
    }
}