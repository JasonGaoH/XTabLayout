package com.gaohui.main;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaohui.xtablayout.R;
import com.gaohui.xtablayout.XTabLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayoutOne;
    private TabLayout tabLayoutTwo;
    private TabLayout tabLayoutThree;
    private XTabLayout tabLayoutFour;
    private XTabLayout tabLayoutFive;
    private ViewPager viewPager;

   private String[] strArray = new String[]{"关注", "推荐", "视频", "直播", "图片", "段子", "精华", "热门"};

    private List<String> stringList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initViews() {
        tabLayoutOne = findViewById(R.id.tabsOne);
        tabLayoutTwo = findViewById(R.id.tabsTwo);
        tabLayoutThree = findViewById(R.id.tabsThree);
        tabLayoutFour = findViewById(R.id.tabsFour);
        tabLayoutFive = findViewById(R.id.tabsFive);
        viewPager = findViewById(R.id.viewPager);

        initData();

        IndexPagerAdapter indexPagerAdapter = new IndexPagerAdapter(getSupportFragmentManager(),stringList,fragmentList);
        viewPager.setAdapter(indexPagerAdapter);

        tabLayoutOne.setupWithViewPager(viewPager);
        tabLayoutTwo.setupWithViewPager(viewPager);
        tabLayoutThree.setupWithViewPager(viewPager);
        tabLayoutFour.setupWithViewPager(viewPager);
        tabLayoutFive.setupWithViewPager(viewPager);


        tabLayoutTwo.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //了解源码得知 线的宽度是根据 tabView的宽度来设置的
                    LinearLayout mTabStrip = (LinearLayout) tabLayoutTwo.getChildAt(0);
                    int dp10 = dip2px(tabLayoutTwo.getContext(), 10);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField =
                                tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding
                        // 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params =
                                (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (Exception e) {

                }
            }
        });

        tabLayoutThree.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Class<?> tablayout = tabLayoutThree.getClass();
                    Field tabStrip = tablayout.getDeclaredField("mTabStrip");
                    tabStrip.setAccessible(true);
                    LinearLayout ll_tab= (LinearLayout) tabStrip.get(tabLayoutThree);
                    for (int i = 0; i < ll_tab.getChildCount(); i++) {
                        View child = ll_tab.getChildAt(i);
                        child.setPadding(0,0,0,0);
                        LinearLayout.LayoutParams params = new
                        LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,1);
                        params.setMarginStart(dip2px(MainActivity.this,1f));
                        params.setMarginEnd(dip2px(MainActivity.this,15f));
                        child.setLayoutParams(params);
                        child.invalidate();
                    }
                } catch (Exception e) {

                }
            }
        });


        //add badgeView



    }

    private void initData() {
        stringList.addAll(Arrays.asList(strArray));
        for (int i=0;i<stringList.size();i++) {
            Fragment fragment = EmptyFragment.newInstance(i);
            fragmentList.add(fragment);
        }
    }

    class IndexPagerAdapter extends FragmentPagerAdapter {
        private List<String> titleList;

        public IndexPagerAdapter(FragmentManager fm,List<String> titleList,List<Fragment> fragmentList) {
            super(fm);
            this.titleList = titleList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return titleList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
