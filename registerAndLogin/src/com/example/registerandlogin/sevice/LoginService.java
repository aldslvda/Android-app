package com.example.registerandlogin.sevice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

public class LoginService {

	public static boolean SaveUserInfo(Context context,String usrname,String passwd){
		try {
			//File file = new File("/data/data/com.example.registerandlogin/info.txt");
			File file = new File(context.getFilesDir(),"info.txt"); 
			FileOutputStream fos = new FileOutputStream(file);
			fos.write((usrname+"##"+passwd).getBytes());
			fos.close();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
			return false;
		}
		
	}
	public static Map<String,String> GetSavedUserInfo(Context context) {
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
		
		
	}
}