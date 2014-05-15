package com.example.pos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Counter extends Activity {
	

	private GridView newgridView;
	static final String[] numbers = new String[] { 
		"1", "2", "3", "4", 
		"5","6","7","8"
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outlets);
		
		newgridView=(GridView)findViewById(R.id.newgridview);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(Counter.this, R.layout.griditem, R.id.textView1, numbers);
		newgridView.setAdapter(adapter);
		
	}

}
