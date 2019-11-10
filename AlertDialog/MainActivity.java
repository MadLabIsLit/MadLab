package com.example.alertdialogdemo;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends ActionBarActivity {
Button button;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
button=(Button)findViewById(R.id.button1);
button.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View view) {
// TODO Auto-generated method stub
/* Creates a builder for an alert dialog.*/
AlertDialog.Builder builder=new
AlertDialog.Builder(MainActivity.this);
/* set title for Alert Dialog box */
builder.setTitle("Alert Dialog Demo");
/* set dialog message*/
builder.setMessage("Are you sure you really want to
exit");
//No button
builder.setNegativeButton("NO", new
DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int
which)
{
// TODO Auto-generated method stub
Toast.makeText(getApplicationContext(),
"No is clicked", Toast.LENGTH_LONG).show();
/* if this button is clicked, just close
the dialog box and do nothing */
dialog.cancel();
}
});
//YES button
builder.setPositiveButton("YES", new
DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int
which) {
// TODO Auto-generated method stub
Toast.makeText(getApplicationContext(),
"yes is clicked", Toast.LENGTH_LONG).show();
/* if this button is clicked, close
current activity*/
MainActivity.this.finish();
}
});
/* DialogInterface.OnClickListener: Interface
definition for a callback to be invoked when a view is clicked.*/
// Can't say button
builder.setNeutralButton("Later", new
DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int
which) {
// TODO Auto-generated method stub
Toast.makeText(getApplicationContext(),
"Can't say is clicked", Toast.LENGTH_LONG).show();
dialog.dismiss();
}
});
//builder.setCancelable(false);
/*Creates an AlertDialog with the arguments supplied to
this builder. */
builder.create();
builder.show();
}
});
}
}