package com.nickalds.notepad;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_edit extends Activity /*implements OnClickListener*/{
	
	private Button  bt_save;
	private EditText et_title , et_content ;
	private NoteSQLiteOpenHelper noteSQLiteOpenHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
		noteSQLiteOpenHelper = new NoteSQLiteOpenHelper(Activity_edit.this, "notepad.db", null, 1);
		
		et_title = (EditText)findViewById(R.id.et_title);
		et_content = (EditText)findViewById(R.id.et_content);
		
		bt_save = (Button)findViewById(R.id.bt_saveedit);
		
		bt_save.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				SQLiteDatabase db = noteSQLiteOpenHelper.getReadableDatabase();
				String title = et_title.getText().toString();
				String content = et_content.getText().toString();
				
				ContentValues cv = new ContentValues();
				cv.put("title", title);
				cv.put("content", content);
				db.insert("notepadtable", null, cv);
			}
		});
	}


	
}
