package com.weimenglyly.hellopager;

import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter {
	
	private  List<View>  listView;
	
	public  ViewPagerAdapter(List<View>  listView){
		this.listView = listView;
	}
	
	//销毁arg1位置的界面
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(listView.get(arg1));		
		}
	
		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub
			
		}
    //获取当前页数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(listView != null){
			return listView.size();
		}
		return 0;
	}
	//初始化arg1位置的界面
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			
			((ViewPager) arg0).addView(listView.get(arg1), 0);
			
			return listView.get(arg1);
		}
		
		//判断是否由对象生成界面
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return (arg0 == arg1);
	}
	
	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
