package com.example.pos;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private ArrayList<HashMap<String, String>> sampleArrayList;
	private SimpleAdapter sampleListAdapter;
	private ListView listView,listView2;
	private GridView gridView;
	static final String[] numbers = new String[] { 
		"Alu Porotta", "Fish Fry", "gobi manjuri", "payasam", "tiger prawn",
		"Chicken biriyani", "Cupcake", "ecliare", "Icecream Sandwich", "Jellybean",
		"Kitkat", "Lemonade", "Mango juice", "Nadan meen curry", "Oister",
		"Porotta", "Kitkat", "Kitkat", "Kitkat", "Kitkat",
		"UUUUUUU", "Kitkat", "Kitkat", "Kitkat", "Kitkat", "Kitkat"};
	static final String[] cats = new String[] { 
		"Soft Drinks", "Biriyani", "Beverages", "payasam", "Sea food",
		"Tani Nadan", "Fried Chicken", "Icecreams"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		listView=(ListView)findViewById(R.id.listView1);
		listView2=(ListView)findViewById(R.id.listView3);
		gridView = (GridView) findViewById(R.id.listView2);
		ArrayAdapter<String> catadapter = new ArrayAdapter<>(MainActivity.this, R.layout.catitem, R.id.textView1, cats);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.griditem, R.id.textView1, numbers);
		gridView.setAdapter(adapter);
		listView2.setAdapter(catadapter);
		sampleArrayList=new ArrayList<HashMap<String, String>>();
		for (int i=0;i<10;i++) {
			HashMap<String, String> sampleObjectMap= new HashMap<String, String>();
		        sampleObjectMap.put("value1", "name of item"+i);
		        sampleObjectMap.put("value2", "SI"+i);
		    sampleObjectMap.put("value3", ""+i);
		     sampleObjectMap.put("value4", "price"+i);
		     sampleObjectMap.put("value5", "TB-"+i);
		        sampleArrayList.add(sampleObjectMap);
		}
		sampleListAdapter= new SimpleAdapter(
	            MainActivity.this, sampleArrayList,
	            R.layout.cartitem, new String[] {
	                    "value1", "value2" , "value3", "value4","value5"},
	                    new int[] { R.id.textView2,
	                            R.id.textView1,
	                            R.id.textView3,
	                            R.id.textView4,R.id.textView5});
		listView.setAdapter(sampleListAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				view.setSelected(true);
				
			}
		});
		listView2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				view.setSelected(true);
				
			}
		});
	}

	

}
