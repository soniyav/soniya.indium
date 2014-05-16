package com.example.pos;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class Modifiers extends Activity{
	
	private ArrayList<HashMap<String, String>> sampleArrayList;
	private SimpleAdapter sampleListAdapter;
	private ListView listView;
	private GridView gridView;
	Button keyboardbtn;
	static final String[] numbers = new String[] { 
		"More Salt", "Less Salt","No Salt", "More Spicy", "Less Spicy", "More Sugar",
		"Less Sugar", "No Sugar",  "More Sour", "Less Sour",
		"No Sour", "More Pepper", "Less Pepper", "No Pepper"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modifier);
		listView=(ListView)findViewById(R.id.listView1);
		gridView=(GridView)findViewById(R.id.gridview);
		keyboardbtn=(Button)findViewById(R.id.keyboardbtn);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(Modifiers.this, R.layout.griditem, R.id.textView1, numbers);
		gridView.setAdapter(adapter);
		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			
				String name = getResources().getResourceEntryName(position);
				
				Log.d("nameeeeeeeeeeeeeeeeeeee",name);
		
		sampleArrayList=new ArrayList<HashMap<String, String>>();
		for (int i=0;i<10;i++) {
			HashMap<String, String> sampleObjectMap= new HashMap<String, String>();
		       
		        sampleObjectMap.put("value1", "SI"+i);
		    sampleObjectMap.put("value2", ""+i);
		     sampleObjectMap.put("value3", "price"+i);
		    
		        sampleArrayList.add(sampleObjectMap);
		}
		sampleListAdapter= new SimpleAdapter(
	           Modifiers.this, sampleArrayList,
	            R.layout.modifierlistitem, new String[] {
	                    "value1", "value2" , "value3"},
	                    new int[] { 
	                            R.id.textView1,
	                            R.id.textView2,
	                            R.id.textView3});
		listView.setAdapter(sampleListAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				view.setSelected(true);
				
			}
		});
			}
		});
		
	}

}
