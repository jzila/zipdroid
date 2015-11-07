package com.zipcode.listing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zipcode.model.Media;

import java.util.ArrayList;
import java.util.List;

public class ListingImagePagingAdapter extends FragmentStatePagerAdapter {

    private List<Media> mMedia;

    public ListingImagePagingAdapter(FragmentManager fm, List<Media> media) {
        super(fm);
        mMedia = media;
    }

    public synchronized void setMedia(List<Media> media) {
        if (mMedia == null) {
            mMedia = new ArrayList<>();
        }
        mMedia.clear();
        mMedia.addAll(media);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return ListingImageFragment.getInstance(mMedia.get(position).getUrl());
    }

    @Override
    public int getCount() {
        return mMedia.size();
    }
}
