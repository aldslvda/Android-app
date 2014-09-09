package com.nickalds.notepad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteSQLiteOpenHelper extends SQLiteOpenHelper{

	public NoteSQLiteOpenHelper(Context context ,String name ,CursorFactory factory, int version) {
		// TODO Auto-generated constructor stub
		super(context, name, factory, 1);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table notepadtable(_id integer primary key autoincrement,title text,content text);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
