 package com.example.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class PersonSQLiteOpenHelper extends SQLiteOpenHelper{

	/**
	 * ���ݿ�Ĺ��췽�����������ݿ�����ơ����ݿ��ѯ�Ľ���������ݿ�İ汾
	 * @param context
	 */
	public PersonSQLiteOpenHelper(Context context) {
		// TODO Auto-generated constructor stub
		
		super(context, "person.db", null, 1); 

	}



	/**
	 *���ݿ��һ�α�������ʱ����õķ���
	 * @param db �����������ݿ� 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
	//��ʼ�����ݿ�ı�ṹ
		db.execSQL("creat table person id integer primary key autoincrement, name text, number integer ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
