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
      
    //引导图片资源  
    private static final int[] pics = { R.drawable.nature1,  
            R.drawable.nature2, R.drawable.nature3,  
            R.drawable.natrue4};  
      
    //底部小店图片  
    private ImageView[] dots ;  
      
    //记录当前选中位置  
    private int currentIndex;  
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 views = new ArrayList<View>();  
         
	        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,  
	                LinearLayout.LayoutParams.WRAP_CONTENT);  
	          
	        //初始化引导图片列表  
	        for(int i=0; i<pics.length; i++) {  
	            ImageView iv = new ImageView(this);  
	            iv.setLayoutParams(mParams);  
	            iv.setImageResource(pics[i]);  
	            views.add(iv);  
	        }  
	        vp = (ViewPager) findViewById(R.id.viewpager);  
	        //初始化Adapter  
	        vpAdapter = new ViewPagerAdapter(views);  
	        vp.setAdapter(vpAdapter);  
	        //绑定回调  
	        vp.setOnPageChangeListener(this);  
	          
	        //初始化底部小点  
	        initDots();  
	          
	}
	private void initDots() {
		// TODO Auto-generated method stub
		LinearLayout ll = (LinearLayout) findViewById(R.id.ll);  
		  
        dots = new ImageView[pics.length];  
  
        //循环取得图片  
        for (int i = 0; i < pics.length; i++) {  
            dots[i] = (ImageView) ll.getChildAt(i);  
            dots[i].setEnabled(true);//都设为右键头
            dots[i].setOnClickListener(this);  
            dots[i].setTag(i);//设置位置tag，方便取出与当前位置对应  
        }  
  
        currentIndex = 0;  
        dots[currentIndex].setEnabled(false);//设置为向上箭头，即选中状态  
	}
	
	/** 
     *设置当前的引导页  
     */  
    private void setCurView(int position)  
    {  
        if (position < 0 || position >= pics.length) {  
            return;  
        }  
  
        vp.setCurrentItem(position);  
    }  
  
    /** 
     *这只当前引导小点的选中  
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

	//当滑动状态改变时调用
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	 //当当前页面被滑动时调用  
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	   //当新的页面被选中时调用 
	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		setCurDot(arg0);
	}
}
