package com.example.cvr.adapterview;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {
AutoCompleteTextView ACTV;
Spinner spinner;
ListView listView;
String[] Versions={ "JellyBean", "Kitkat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout. mylayout);
ArrayAdapter<String> arrayAdapter1= new
ArrayAdapter<String>( this,android.R.layout. simple_dropdown_item_1line,Versions);
ACTV=(AutoCompleteTextView)findViewById(R.id. autoCompleteTextView);
ACTV.setThreshold(1);
ACTV.setAdapter(arrayAdapter1);
spinner=(Spinner)findViewById(R.id. spinner);
ArrayAdapter<String> arrayAdapter2= new
ArrayAdapter<String>( this,android.R.layout. simple_spinner_item,Versions);
arrayAdapter2.setDropDownViewResource(android.R.layout. simple_spinner_dropdown_item);
spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
Toast.makeText(getBaseContext(), "Selec ted "+Versions[position],Toast. LENGTH_SHORT).show();
}
@Override
public void onNothingSelected(AdapterView<?> parent) {
}
});
spinner.setAdapter(arrayAdapter2);
 listView=(ListView)findViewById(R.id. listView);
ArrayAdapter<String> arrayAdapter3= new
ArrayAdapter<String>( this,android.R.layout. simple_list_item_1,Versions);
listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
TextView tv=(TextView)view;
Toast.makeText(getBaseContext(),tv.getText()+ " is selected",Toast. LENGTH_SHORT).show();
}
});
listView.setAdapter(arrayAdapter3);
}
}