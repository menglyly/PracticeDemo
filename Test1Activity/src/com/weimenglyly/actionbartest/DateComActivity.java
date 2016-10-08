package com.weimenglyly.actionbartest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DateComActivity extends Activity{
	
	private SignCalendar calendar;  
    private String date;  
    private int years;  
    private String months;  
    private Button btn_sign;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        this.setContentView(R.layout.activity_date);  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间  
        date = formatter.format(curDate);  
        calendar = (SignCalendar) findViewById(R.id.sc_main);  
        btn_sign = (Button) findViewById(R.id.btn_sign);
        
        btn_sign.setOnClickListener(new OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                List<String> list = new ArrayList<String>();  
                list.add("2016-06-30");  
                list.add(date);  
                // calendar.setCalendarDaysBgColor(list,  
                // R.drawable.bg_sign_today);  
                calendar.addMarks(list, 0); 
            }  
        });  
    }  

}
