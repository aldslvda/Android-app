 package com.example.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class PersonSQLiteOpenHelper extends SQLiteOpenHelper{

	/**
	 * 数据库的构造方法，定义数据库的名称、数据库查询的结果集、数据库的版本
	 * @param context
	 */
	public PersonSQLiteOpenHelper(Context context) {
		// TODO Auto-generated constructor stub
		
		super(context, "person.db", null, 1); 

	}



	/**
	 *数据库第一次被创建的时候调用的方法
	 * @param db 被创建的数据库 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
	//初始化数据库的表结构
		db.execSQL("creat table person id integer primary key autoincrement, name text, number integer ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
