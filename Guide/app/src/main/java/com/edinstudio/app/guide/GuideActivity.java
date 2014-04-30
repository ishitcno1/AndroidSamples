package com.edinstudio.app.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albert on 14-4-30.
 */
public class GuideActivity extends Activity {
    private ViewPager mPager;
    private LinearLayout mDotsContainer;

    private List<View> mViews = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mPager = (ViewPager) findViewById(R.id.guide_pager);
        mDotsContainer = (LinearLayout) findViewById(R.id.guide_dots_container);

        int[] guideImages = {R.drawable.ic_guide_1, R.drawable.ic_guide_2, R.drawable.ic_guide_3, R.drawable.ic_guide_4};
        int[] guideTexts = {R.drawable.ic_guide_text_1, R.drawable.ic_guide_text_2, R.drawable.ic_guide_text_3, R.drawable.ic_guide_text_4};
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < guideImages.length; i++) {
            View view = inflater.inflate(R.layout.item_guide, null);
            ImageView image = (ImageView) view.findViewById(R.id.guide_image);
            ImageView text = (ImageView) view.findViewById(R.id.guide_text);
            image.setImageResource(guideImages[i]);
            text.setImageResource(guideTexts[i]);

            if (i == guideImages.length - 1) {
                final View start = view.findViewById(R.id.guide_start);
                start.setVisibility(View.VISIBLE);
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }

            mViews.add(view);
        }

        for (int i = 0; i < mViews.size(); i++) {
            View view = inflater.inflate(R.layout.item_guide_dot, null);
            if (i == 0) {
                view.setSelected(true);
            }
            mDotsContainer.addView(view);
        }

        mPager.setAdapter(new ViewPagerAdapter(mViews));
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mDotsContainer.getChildCount(); i++) {
                    mDotsContainer.getChildAt(i).setSelected(false);
                }
                mDotsContainer.getChildAt(position).setSelected(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class ViewPagerAdapter extends PagerAdapter {
        List<View> views;

        public ViewPagerAdapter(List<View> views) {
            super();
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }

}
