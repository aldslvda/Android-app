package com.example.makexml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.xmlpull.v1.XmlSerializer;

import com.example.makexml.domain.SmsInfo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * @author nick
 *
 */
public class MainActivity extends Activity {
	private List<SmsInfo> smsInfos;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		smsInfos = new ArrayList<SmsInfo>();
		Random random = new Random();
		Long number = (long) 111111111;
		for (int i = 0; i < 10; i++) {
			smsInfos.add(new SmsInfo(System.currentTimeMillis(), random.nextInt(2)+1 ,"短信内容",Long.toString(number+i),i));
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	/**
	 * 备份手机短信
	 * @param view
	 */
	public void BackupSms(View view) {
		//假设获取到了短信
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<smss>");
		for (SmsInfo info : smsInfos){
			sb.append("<sms>");
			
			sb.append("<adress>");
			sb.append(info.getAdress());
			sb.append("</adress>");
			
			sb.append("<type>");
			sb.append(info.getType());
			sb.append("</type>");
			
			sb.append("<body>");
			sb.append(info.getBody());
			sb.append("</body>");
			
			sb.append("<date>");
			sb.append(info.getDate()); 
			sb.append("</date>");
			
			sb.append("</sms>");
		}
		
		sb.append("</smss>");
		File file = new File(Environment.getExternalStorageDirectory(),"backup.xml");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(sb.toString().getBytes());
			fos.close();
		    Toast.makeText(this, "备份成功", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, "备份失败", Toast.LENGTH_SHORT).show();
		}
		
	}
	public void BackupSms2(View view){
		try {
			XmlSerializer serializer =  Xml.newSerializer();
			File file = new File(Environment.getExternalStorageDirectory(),"backup2.xml");
			FileOutputStream os = new FileOutputStream(file);
			serializer.setOutput(os, "utf-8");
			
			serializer.startDocument("utf-8", true);
			serializer.startTag(null, "smss");
			
			for (SmsInfo info : smsInfos){
				serializer.startTag(null, "sms");
				serializer.attribute(null, "id", info.getId()+"");
				
				serializer.startTag(null, "body");
				serializer.text(info.getBody());
				serializer.endTag(null, "body");
				
				serializer.startTag(null, "adress");
				serializer.text(info.getAdress());
				serializer.endTag(null, "adress");
				
				serializer.startTag(null, "type");
				serializer.text(info.getType()+"");
				serializer.endTag(null, "type");
				
				serializer.startTag(null, "date");
				serializer.text(info.getDate()+"");
				serializer.endTag(null, "date");
				
				serializer.endTag(null, "sms");
			}
			
			serializer.endTag(null, "smss");
			serializer.endDocument();
			
			os.close();
			Toast.makeText(this, "备份成功", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, "备份失败", Toast.LENGTH_SHORT).show();
		}
		
	} 
	
	
	
}
