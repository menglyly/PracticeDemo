package com.weimenglyly.actionbartest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	//���干���������ݼ������ֶ�  
    private String MY_RMBCost ="MY_RMBCost";  
      
    private String TodayTime ="TodayTime";  
      
    public void onCreate(Bundle savedInstanceState ){  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        final Button bt_qiandao = (Button)findViewById(R.id.bt_qiandao);  
        final TextView tv_time = (TextView)findViewById(R.id.tx_qiandao);  
       
        //��ȡ��������  
         SharedPreferences my_rmb_data = getSharedPreferences(MY_RMBCost, 0);  
          
        Time t = new Time();  
        t.setToNow();  
        int lastmonth = t.month + 1 ;  
        final String str =  t.year + "��" + lastmonth + "��" + t.monthDay + "��";    
             
          
        final String nowtime =my_rmb_data.getString(TodayTime, "").toString();  
          
        if(nowtime.equals(str)==true)  
        {  
            tv_time.setText("���ڣ�"+ nowtime +"��ǩ����");   
            bt_qiandao.setBackgroundResource(R.drawable.right);  
        }  
        else  
        {  
            tv_time.setText("���ڣ�"+ str);   
            bt_qiandao.setBackgroundResource(R.drawable.right);  
        }  
                   
        //ǩ������  
        bt_qiandao.setOnClickListener(new OnClickListener() {  
             
           public void onClick(View v) {  
               // TODO Auto-generated method stub  
               SharedPreferences my_rmb_data = getSharedPreferences(MY_RMBCost, 0);   
               if(my_rmb_data.getString(TodayTime, "").toString().equals(str)==true)  
                {  
                   Toast.makeText( MainActivity.this , "������ǩ����", Toast.LENGTH_SHORT).show();  
                }  
                else  
                {  
                      my_rmb_data.edit()  
                      .putString(TodayTime, str)  
                      .commit();  
                      tv_time.setText("���ڣ�"+ str +"��ǩ����");   
                      bt_qiandao.setBackgroundResource(R.drawable.wrong);
                      Toast.makeText( MainActivity.this , "ǩ���ɹ���", Toast.LENGTH_SHORT).show();  
                }  
           }  
       });     
         
    }  
}
