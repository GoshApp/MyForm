package com.rikmen00.myform.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rikmen00.myform.R;
import com.rikmen00.myform.adapter.TabsFragmentAdapter;
import com.rikmen00.myform.extras.Constans;

import butterknife.ButterKnife;

public class ShowCurrencyFragment extends AbstractTabFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int LAYOUT = R.layout.activity_tabs;
    private View view;
    private FragmentActivity myContext;
    private ViewPager viewPager;
    private TabsFragmentAdapter adapter;
    private String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        initTabs();
        return view;
    }//onCreateView
    public void setContext(Context context) {
        this.context = context;
    }

    public static ShowCurrencyFragment getInstance(Context context){
        Bundle args = new Bundle();
        ShowCurrencyFragment fragment = new ShowCurrencyFragment();
        fragment.setArguments(args);
        fragment.setContext(context);

        return fragment;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void initTabs() {
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(getContext(), getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(Constans.TAB_ONE);

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }// initTabs

    @Override
    public void onRefresh() {

    }

    /**
     *   updates UI to reflect model
     */
}
