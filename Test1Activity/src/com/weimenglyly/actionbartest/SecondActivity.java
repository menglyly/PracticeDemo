package com.weimenglyly.actionbartest;


import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends Activity {
	
	private String number;
	public EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.second_activity);
		editText = (EditText) findViewById(R.id.layout_register_police_phone);
		
		number =editText.getText().toString();		
	
	}
	

}


