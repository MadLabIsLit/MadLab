package com.example.passingbundledata;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class SecondActivity extends Activity
{
TextView nameTV,rollNoTV,marksTV;
public void onCreate(Bundle b)
{
super.onCreate(b);
setContentView(R.layout.activity_second);
/* setting up UI */
nameTV=(TextView)findViewById(R.id.tvName);
rollNoTV=(TextView)findViewById(R.id.tvRollNo);
marksTV=(TextView)findViewById(R.id.tvMarks);
/* getIntent():Return the intent that started this activity. */
Intent intent = getIntent();
/*getting Bundle */
Bundle bundle = intent.getExtras();
/* getting data from Bundle */
String recvName=bundle.getString("myname");
String recvRollNo=bundle.getString("myrollno");
Double recvMarks=bundle.getDouble("mymarks");
/* Converting Double type to String */
String convMarks=Double.toString(recvMarks);
/* Binding values to TextViews */
nameTV.setText("Your name is:"+recvName);
rollNoTV.setText("Your Roll No is :"+recvRollNo);
marksTV.setText("Your marks are:"+convMarks);
}
}