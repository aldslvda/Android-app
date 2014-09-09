package com.nickalds.notepad;

import java.util.List;
import java.util.Map;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_content extends Activity {
	
	private NoteSQLiteOpenHelper noteSQLiteOpenHelper;
	private SQLiteDatabase db;
	private ListView lv ;
	private TextView tv ;
	private List<Map<String, Object>> list;
	private Cursor cursor;
	private int mywhich;
	private int myid;

	
	private EditText et_itemtitle,et_itemcontent;
	private String title , content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		
		noteSQLiteOpenHelper = new NoteSQLiteOpenHelper(Activity_content.this, "notepad.db", null, 1);
		tv = (TextView)findViewById(R.id.tv_null);
		lv = (ListView)findViewById(R.id.lv_content);
		
		db=noteSQLiteOpenHelper.getReadableDatabase();
		cursor = db.query("notepadtable", new String[]{"_id","title","content"}, null, null,null, null, null);
		if(cursor.getCount()>0){
			tv.setVisibility(View.GONE);
		}
		@SuppressWarnings("deprecation")
		SimpleCursorAdapter sca = new SimpleCursorAdapter(Activity_content.this, R.layout.item, cursor, new String[]{"_id","title","content"}, new int[]{R.id.tv_id,R.id.tv_itemtitle,R.id.tv_itemcontent});
		lv.setAdapter(sca);
		lv.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Builder builder = new Builder(Activity_content.this);
				builder.setSingleChoiceItems(new String[]{"查看","修改","删除"}, 0, new OnClickListener() {
					
					@SuppressLint("InflateParams")
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						/*int myidindex = cursor.getColumnIndex("_id");
						myid = cursor.getInt(myidindex);
						int titleindex = cursor.getColumnIndex("title");
						title = cursor.getString(titleindex);
						int contentindex = cursor.getColumnIndex("content");
						content = cursor.getString(contentindex);
						switch (which) {
						case 0:

							Toast.makeText(Activity_content.this, myid+title+content, Toast.LENGTH_LONG).show();

							break;
						case 2:
							
							db.delete("notepadtable", "_id"+myid, null);
							
							Cursor cursor = db.query("notepadtable",new String[]{"_id","title","content"},null,null,null,null,null);
							@SuppressWarnings("deprecation")
							SimpleCursorAdapter sca=new SimpleCursorAdapter(Activity_content.this,R.layout.item,cursor,new String[]{"_id","title","content"},new int[]{R.id.tv_id,R.id.tv_itemtitle,R.id.tv_itemcontent});
							lv.setAdapter(sca);
							
							break;
						case 1:
							Builder builder01 = new Builder(Activity_content.this);
							builder01.setTitle("编辑");
							LayoutInflater inflater=LayoutInflater.from(Activity_content.this);
							View view=inflater.inflate(R.layout.updatedialogview, null);
							et_itemtitle = (EditText)view.findViewById(R.id.et_itemtitle);
							et_itemcontent = (EditText)view.findViewById(R.id.et_itemcontent);
							
							builder01.setView(view);
							builder01.setPositiveButton("确定",new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// 取得数据
									String newtitle = et_itemtitle.getText().toString();
									String newcontent = et_itemcontent.getText().toString();
									ContentValues cv = new ContentValues();
									cv.put("title",newtitle);
									cv.put("content",newcontent);
									db.update("notepadtable", cv,"_id"+myid, null);
									Cursor cursor = db.query("notepadtable", new String[]{"_id","title","content"},null,null,null,null,null );
									@SuppressWarnings("deprecation")
									SimpleCursorAdapter sca=new SimpleCursorAdapter(Activity_content.this,R.layout.item,cursor,new String[]{"_id","title","content"},new int[]{R.id.tv_id,R.id.tv_itemtitle,R.id.tv_itemcontent});
									lv.setAdapter(sca);
									
									
								}
							});
							builder01.setNegativeButton("取消", new OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									
								}
							});
							builder01.show();
							
							break;
						default:
							break;
						}
						*/
						if(which==0){
							//Cursor cursor01=db.query("notepadtable", new String[]{"_id","title","content"}, null, null, null, null, null);
							
							int myidindex=cursor.getColumnIndex("_id");
							myid=cursor.getInt(myidindex);
							int titleindex=cursor.getColumnIndex("title");
							title=cursor.getString(titleindex);
							int contentindex=cursor.getColumnIndex("content");
							content=cursor.getString(contentindex);
							
							Toast.makeText(Activity_content.this, myid+title+content, Toast.LENGTH_LONG).show();	
						}else if(which==2){
							int myidindex=cursor.getColumnIndex("_id");
							myid=cursor.getInt(myidindex);

							db.delete("notepadtable", "_id="+myid, null);
							
							cursor=db.query("notepadtable", new String[]{"_id","title","content"}, null, null, null, null, null);
							SimpleCursorAdapter sca=new SimpleCursorAdapter(Activity_content.this, R.layout.item, cursor, new String[]{"_id","title","content"}, new int[]{R.id.tv_id,R.id.tv_itemtitle,R.id.tv_itemcontent});
							lv.setAdapter(sca);
						}else if(which==1){
							
							int idindex=cursor.getColumnIndex("_id");
							myid=cursor.getInt(idindex);
							
							
							Builder builder01=new Builder(Activity_content.this);
							
							builder01.setTitle("编辑");
							
							LayoutInflater inflater=LayoutInflater.from(Activity_content.this);
							View view=inflater.inflate(R.layout.updatedialogview, null);
							et_itemtitle=(EditText) view.findViewById(R.id.et_itemtitle);
							et_itemcontent=(EditText) view.findViewById(R.id.et_itemcontent);
							
							builder01.setView(view);
							builder01.setPositiveButton("确定", new DialogInterface.OnClickListener(){

								public void onClick(DialogInterface dialog, int which) {
									//取得数据

									//int titleindex=cursor.getColumnIndex("title");
									//title=cursor.getString(titleindex);
									//int contentindex=cursor.getColumnIndex("content");
									//content=cursor.getString(contentindex);
								String newtitle=et_itemtitle.getText().toString();
								String newcontent=et_itemcontent.getText().toString();
								ContentValues cv=new ContentValues();
								cv.put("title", newtitle);
								cv.put("content", newcontent);
								db.update("notepadtable", cv, "_id="+myid, null);
								cursor=db.query("notepadtable", new String[]{"_id","title","content"}, null, null, null, null, null);
								SimpleCursorAdapter sca=new SimpleCursorAdapter(Activity_content.this, R.layout.item, cursor, new String[]{"_id","title","content"}, new int[]{R.id.tv_id,R.id.tv_itemtitle,R.id.tv_itemcontent});
								lv.setAdapter(sca);
								
								}
								
							});
							builder01.setNegativeButton("取消", new DialogInterface.OnClickListener(){

								public void onClick(DialogInterface dialog, int which) {

									
								}
								
							});
							builder01.show();
						}
					}
				});
				builder.show();
			}



		});
	}

}
