package com.example.varanasi.galleryexample;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
public class GalleryActivity extends AppCompatActivity {
Gallery simpleGallery;
CustomGalleryAdapter customGalleryAdapter;
ImageView selectedImageView;
int[]
images={R.drawable.sachin1,R.drawable.sachin2,R.drawable.sachin3,R.drawable.sachin4,R.drawable.sac
hin5,R.drawable.sachin6,
R.drawable.sachin7,R.drawable.sachin8,R.drawable.sachin9,R.drawable.sachin10};
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_gallery);
simpleGallery=(Gallery)findViewById(R.id.gallery);
selectedImageView=(ImageView)findViewById(R.id.imageView);
customGalleryAdapter=new CustomGalleryAdapter(getApplicationContext(),images);
simpleGallery.setAdapter(customGalleryAdapter);
simpleGallery.setSpacing(10);
simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
selectedImageView.setImageResource(images[i]);
}
});
}
}