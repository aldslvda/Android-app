package com.example.mdailog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	public void click01(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("title");
		builder.setMessage("HelloWorld!");
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "你好厉害喔",Toast.LENGTH_SHORT).show();
				
			}
		});
		builder.setNegativeButton("取消", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "蠢飞了", Toast.LENGTH_SHORT).show();
			}
		});
		//AlertDialog dialog = builder.create();
		//dialog.show();
		//比较简单的方式：
		builder.show();
	}
	public void click02(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("choose one");
		final String[] items = new String[]{"choice01","choice02","choice03"};
		builder.setSingleChoiceItems(items, 1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this ,items[which]+"被你点了", Toast.LENGTH_SHORT).show();	 
			TextView textview01 =(TextView)findViewById(R.id.textView1) ;
		    textview01.setText(items[which]);
				}
		});
		builder.show();
	}
	public void click03(View view){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("choose what you want");
		final String[] items = new String[]{"choice01","choice02","choice03"};
		builder.setMultiChoiceItems(items, new boolean[]{true,true,true}, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, items[which]+isChecked,Toast.LENGTH_SHORT).show();	
			}
		});
		builder.show();
	}
	public void click04(View view){
		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pDialog.setTitle("请稍候");
		pDialog.setMessage("正在睡觉。。。。");
		pDialog.setMax(100);
		new Thread(){
				public void run(){
					for (int i = 0; i < 100; i++) {
						pDialog.setProgress(i);
						try {
							Thread.sleep(20);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					pDialog.dismiss();
				};
		}.start();
		pDialog.show();
	}
}