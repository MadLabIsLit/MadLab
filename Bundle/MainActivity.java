package com.example.passingbundledata;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends ActionBarActivity {
EditText etName,etRollNo,etMarks;
@Override
 protected void onCreate(Bundle savedInstanceState)
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
/* accessing id's from activity_main.xml layout file */
etName=(EditText)findViewById(R.id.nameET);
etRollNo=(EditText)findViewById(R.id.rollNoET);
etMarks=(EditText)findViewById(R.id.marksET);
}
public void sendData(View v)
{
/* getting data from EditText */
String name=etName.getText().toString();
String rollno=etRollNo.getText().toString();
String marks=etMarks.getText().toString();
/* Converting marks to Double type */
Double dMarks=Double.parseDouble(marks);
/*Creating Bundle Object */
Bundle b = new Bundle();
/*Storing data into Bundle */
b.putString("myname", name);
b.putString("myrollno", rollno);
b.putDouble("mymarks", dMarks);
/* creating Intent object */
Intent intent = new Intent(MainActivity.this,SecondActivity.class);
intent.putExtras(b);
startActivity(intent);
}
}