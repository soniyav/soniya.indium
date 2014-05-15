package com.example.pos;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class OutletModule extends Activity{
	
	private GridView newgridView;
	static final String[] numbers = new String[] { 
		"ROOM SERVICE", "THE EMPEROR", "BANQUET HALL-ASSEMBLY", "BANQUET HALL-DYNASTY", 
		"BANQUET HALL-OTHERS"
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outlets);
		
		newgridView=(GridView)findViewById(R.id.newgridview);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(OutletModule.this, R.layout.griditem, R.id.textView1, numbers);
		newgridView.setAdapter(adapter);
		
		
		newgridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent myintent=new Intent(OutletModule.this,Counter.class);
				startActivity(myintent);
				
			}
		});
		
	}

}
