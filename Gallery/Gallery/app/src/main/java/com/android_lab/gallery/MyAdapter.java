package com.android_lab.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private int dataset[];

    public MyAdapter(Context context, int dataset[]) {
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public int getCount() {
        return dataset.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(dataset[i]);
        imageView.setLayoutParams(new Gallery.LayoutParams(400, 400));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }
}
