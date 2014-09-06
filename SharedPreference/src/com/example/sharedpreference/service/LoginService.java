package com.example.sharedpreference.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Space;

public class LoginService {

	public static void  SaveUserInfo(Context context,String usrname,String passwd){
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		//得到一个sp的编辑器
		Editor editor = sp.edit();
		editor.putString("usrname", usrname);
		editor.putString("passwd", passwd);
		editor.commit();
		
	}
/*	public static Map<String,String> GetSavedUserInfo(Context context) {
		try {
			File file = new File(context.getFilesDir(),"info.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String str = br.readLine();
			String[] infos = str.split("##");
			Map<String, String> map = new HashMap<String,String>();
			map.put("usrname", infos[0]);
			map.put("passwd", infos[1]);
			br.close();
			return map; 
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			return null;
		}
		
		
	}*/
}