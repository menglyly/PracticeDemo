package com.weimenglyly.hellopager;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements  OnClickListener, OnPageChangeListener{
	
	private ViewPager vp;  
    private ViewPagerAdapter vpAdapter;  
    private List<View> views;  
      
    //����ͼƬ��Դ  
    private static final int[] pics = { R.drawable.nature1,  
            R.drawable.nature2, R.drawable.nature3,  
            R.drawable.natrue4};  
      
    //�ײ�С��ͼƬ  
    private ImageView[] dots ;  
      
    //��¼��ǰѡ��λ��  
    private int currentIndex;  
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 views = new ArrayList<View>();  
         
	        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,  
	                LinearLayout.LayoutParams.WRAP_CONTENT);  
	          
	        //��ʼ������ͼƬ�б�  
	        for(int i=0; i<pics.length; i++) {  
	            ImageView iv = new ImageView(this);  
	            iv.setLayoutParams(mParams);  
	            iv.setImageResource(pics[i]);  
	            views.add(iv);  
	        }  
	        vp = (ViewPager) findViewById(R.id.viewpager);  
	        //��ʼ��Adapter  
	        vpAdapter = new ViewPagerAdapter(views);  
	        vp.setAdapter(vpAdapter);  
	        //�󶨻ص�  
	        vp.setOnPageChangeListener(this);  
	          
	        //��ʼ���ײ�С��  
	        initDots();  
	          
	}
	private void initDots() {
		// TODO Auto-generated method stub
		LinearLayout ll = (LinearLayout) findViewById(R.id.ll);  
		  
        dots = new ImageView[pics.length];  
  
        //ѭ��ȡ��ͼƬ  
        for (int i = 0; i < pics.length; i++) {  
            dots[i] = (ImageView) ll.getChildAt(i);  
            dots[i].setEnabled(true);//����Ϊ�Ҽ�ͷ
            dots[i].setOnClickListener(this);  
            dots[i].setTag(i);//����λ��tag������ȡ���뵱ǰλ�ö�Ӧ  
        }  
  
        currentIndex = 0;  
        dots[currentIndex].setEnabled(false);//����Ϊ���ϼ�ͷ����ѡ��״̬  
	}
	
	/** 
     *���õ�ǰ������ҳ  
     */  
    private void setCurView(int position)  
    {  
        if (position < 0 || position >= pics.length) {  
            return;  
        }  
  
        vp.setCurrentItem(position);  
    }  
  
    /** 
     *��ֻ��ǰ����С���ѡ��  
     */  
    private void setCurDot(int positon)  
    {  
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {  
            return;  
        }  
  
        dots[positon].setEnabled(false);  
        dots[currentIndex].setEnabled(true);  
  
        currentIndex = positon;  
    }  
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int position = (Integer)v.getTag();  
        setCurView(position);  
        setCurDot(position);  
	}

	//������״̬�ı�ʱ����
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	 //����ǰҳ�汻����ʱ����  
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	   //���µ�ҳ�汻ѡ��ʱ���� 
	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		setCurDot(arg0);
	}
}