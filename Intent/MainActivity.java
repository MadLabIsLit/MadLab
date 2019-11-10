package com.example.passingdata;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends ActionBarActivity {
Button button;
EditText et;
/** Called when the activity is first created. */
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
button=(Button)findViewById(R.id.button1);
et=(EditText)findViewById(R.id.etName);
}
public void sendMessage(View v)
{
String name= et.getText().toString();
 /*we create the intent defining the caller activity (FirstActivity) and the destination
activity (ReceiverActivity) */
Intent i = new Intent(MainActivity.this, SecondActivity.class);
/*we use putExtra to add our data. In the destination activity to retrieve the data sent */
/* Use putExtra() to add a new name/value pairs*/
i.putExtra("message", name);
startActivity(i);
}
}