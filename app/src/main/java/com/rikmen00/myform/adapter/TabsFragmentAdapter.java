package com.rikmen00.myform.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rikmen00.myform.fragment.AbstractTabFragment;
import com.rikmen00.myform.fragment.ShowCurrencyFragment;

import java.util.HashMap;
import java.util.Map;

//import com.app.codytutorials.fragment.AndroidBuildingMusicPlayerFragment;


public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap();
    }// TabsFragmentAdapter

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }// getItem

    @Override
    public CharSequence getPageTitle(int position) {

        return tabs.get(position).getTitle();
    }// getPageTitle

    @Override
    public int getCount() {
        return tabs.size();
    }// getCount

    private void initTabsMap() {
        tabs = new HashMap<>();
        tabs.put(0, ShowCurrencyFragment.getInstance(context));
        //tabs.put(1, AndroidBuildingMusicPlayerFragment.getInstance(context));

    }// initTabsMap
}
