package com.example.passingdata;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class SecondActivity extends Activity {
TextView tv;
public void onCreate(Bundle b)
{
super.onCreate(b);
setContentView(R.layout.activity_second);
tv=(TextView)findViewById(R.id.receiveTV);
/* getIntent() --- return the intent that started this activity */
Intent intent =getIntent();
String recvMessage = intent.getStringExtra("message");
/* Binding value to TextView */
tv.setText("you received the message:"+ recvMessage);
}
}