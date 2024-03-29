package com.example.varanasi.galleryexample;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import java.security.PrivateKey;
public class CustomGalleryAdapter extends BaseAdapter{
private Context context;
private int[] images;
public CustomGalleryAdapter(Context c,int[] images){
context=c;
this.images=images;
}
public int getCount(){
return images.length;
}
public Object getItem(int position){
return images[position];
}
public long getItemId(int position){
return position;
}
public View getView(int position,View convertView,ViewGroup parent){
ImageView imageView=new ImageView(context);
imageView.setImageResource(images[position]);
imageView.setLayoutParams(new Gallery.LayoutParams(200,200));
return imageView;
}
}