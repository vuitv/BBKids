package com.vuitv.bbkids;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.vuitv.bbkids.adapter.CardPagerAdapter;
import com.vuitv.bbkids.object.CardItem;

public class MainActivity extends AppCompatActivity {


    private ViewPager pager;
    private CardPagerAdapter pagerAdapter;
    private ShadowTransformer shadowTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pagerAdapter = new CardPagerAdapter();

        pager.setOffscreenPageLimit(3);
        pager.setPageMargin(12);

        pagerAdapter.addCardItem(new CardItem("Title 1"));
        pagerAdapter.addCardItem(new CardItem("Title 2"));
        pagerAdapter.addCardItem(new CardItem("Title 3"));
        pagerAdapter.addCardItem(new CardItem("Title 4"));
        pagerAdapter.addCardItem(new CardItem("Title 5"));
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(2);

        shadowTransformer = new ShadowTransformer(pager, pagerAdapter);
        shadowTransformer.enableScaling(true);
        pager.setPageTransformer(false, shadowTransformer);
        pager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public ViewPager getPager() {
        return pager;
    }
}
