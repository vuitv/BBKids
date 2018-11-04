package com.vuitv.bbkids.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vuitv.bbkids.MainActivity;
import com.vuitv.bbkids.R;
import com.vuitv.bbkids.object.CardItem;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends android.support.v4.view.PagerAdapter implements CardAdapter {
    private List<CardView> mView;
    private List<CardItem> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mView = new ArrayList<>();
        mData = new ArrayList<>();
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mView.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.card_view, container, false);
        container.addView(view);
        bindView(mData.get(position), view);
        CardView cardView = view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }
        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mView.set(position, cardView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(container.getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mView.set(position, null);
    }

    private void bindView(CardItem item, View view) {
        TextView title = view.findViewById(R.id.titleTextView);
        title.setText(item.getmTitleResource());
    }

    public void addCardItem(CardItem item) {
        mView.add(null);
        mData.add(item);
    }
}
