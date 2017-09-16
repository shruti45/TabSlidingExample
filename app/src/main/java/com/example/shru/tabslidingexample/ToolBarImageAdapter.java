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
public class ToolBarImageAdapter extends PagerAdapter {
    private Context context ;
    private LayoutInflater inflater;
    private ArrayList<Integer> IMAGES;




    public ToolBarImageAdapter(Context context,ArrayList<Integer> IMAGES){
        this.context = context;
        this.IMAGES=IMAGES;
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
        View imageLayout = inflater.inflate(R.layout.imageslidfortoolbarviewpager, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.slidingimagefortoolbar);



        imageView.setImageResource(IMAGES.get(position));

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

}