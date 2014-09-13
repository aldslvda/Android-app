package com.nickalds.saveimage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ImageSQLiteOpenHelper extends SQLiteOpenHelper{

	public ImageSQLiteOpenHelper(Context context ,String name, CursorFactory cursor , int version) {
		// TODO Auto-generated constructor stub
		super(context , name, cursor, version);
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE imagetable (_id INTEGER PRIMARY KEY AUTOINCREMENT,image BLOB)");
	}
	public void onUpgrade(SQLiteDatabase db,int oldVersion ,int newVersion ) {
		
	}
}
