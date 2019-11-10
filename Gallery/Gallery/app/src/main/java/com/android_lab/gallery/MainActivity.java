package com.android_lab.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private int dataset[] = {R.drawable.elon_musk, R.drawable.bill_gates, R.drawable.rdj,
            R.drawable.roadster, R.drawable.model_s, R.drawable.falcon_9, R.drawable.starship};

    private ImageView imageView;
    private TextView textView;
    private Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        gallery = findViewById(R.id.gallery);
        gallery.setAdapter(new MyAdapter(this, dataset));
        gallery.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        imageView.setImageResource(dataset[i]);
        textView.setText(getResources().getResourceEntryName(dataset[i]));
    }
}
