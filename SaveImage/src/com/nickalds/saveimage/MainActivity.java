package com.nickalds.saveimage;

import java.io.ByteArrayOutputStream;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt_save1 , bt_search1 ,bt_save2, bt_search2;
	private ImageView iv_1 ,iv_2;
	private SQLiteOpenHelper imageSQLiteOpenHelper = null;
	private SQLiteDatabase db=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageSQLiteOpenHelper = new ImageSQLiteOpenHelper(this, "savimage.db",null,1);
		db = imageSQLiteOpenHelper.getWritableDatabase();
		
		bt_save1 = (Button)findViewById(R.id.bt_save1); 
		bt_search1 = (Button)findViewById(R.id.bt_search1);
		bt_save2 = (Button)findViewById(R.id.bt_save2); 
		bt_search2 = (Button)findViewById(R.id.bt_search2);
		
		bt_save1.setOnClickListener(this);
		bt_save2.setOnClickListener(this);
		bt_search1.setOnClickListener(this);
		bt_search2.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	
		case R.id.bt_save1:
			//保存图片
			try {
				Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.erweima);
				int size = bitmap1.getWidth()*bitmap1.getHeight()*4;
				//创建一个字节数组输出流，大小为size
				ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
				bitmap1.compress(Bitmap.CompressFormat.PNG, 100, baos);
				byte[] imagedata1 = baos.toByteArray();
				//将字节数组保存到数据库中
				ContentValues cv = new ContentValues();
				cv.put("_id", 1);
				cv.put("image", imagedata1);
				db.insert("imagetable", null,cv);
				baos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case R.id.bt_save2:
			//保存图片
			try {
				Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
				int size = bitmap2.getWidth()*bitmap2.getHeight()*4;
				//创建一个字节数组输出流，大小为size
				ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
				bitmap2.compress(Bitmap.CompressFormat.PNG, 100, baos);
				byte[] imagedata2 = baos.toByteArray();
				//将字节数组保存到数据库中
				ContentValues cv = new ContentValues();
				cv.put("_id", 2);
				cv.put("image", imagedata2);
				db.insert("imagetable", null,cv);
				baos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case R.id.bt_search1:
			//查询图片
			Cursor cursor = db.query("imagetable", new String[]{"_id" ,"image"}, null , null, null, null, null);
			byte[] imagequery=null;
			if(cursor.moveToNext()){
				imagequery=cursor.getBlob(cursor.getColumnIndex("image"));
			}
			Bitmap imageBitmap = BitmapFactory.decodeByteArray(imagequery, 0, imagequery.length);
			iv_1 = (ImageView)findViewById(R.id.iv_01);
			iv_1.setImageBitmap(imageBitmap);
			break;	
			
		case R.id.bt_search2:
			Cursor cursor2 = db.query("imagetable", new String[]{"_id" ,"image"}, null , null, null, null, null);
			byte[] imagequery2=null;
			while(cursor2.moveToNext()){
				imagequery2=cursor2.getBlob(cursor2.getColumnIndex("image"));
			}
			Bitmap imageBitmap2 = BitmapFactory.decodeByteArray(imagequery2, 0, imagequery2.length);
			iv_2 = (ImageView)findViewById(R.id.iv_02);
			iv_2.setImageBitmap(imageBitmap2);
			break;
		default:
			break;
		}
	}
	public void onDestroy(){
		super.onDestroy();
		db.close();
	}
}
