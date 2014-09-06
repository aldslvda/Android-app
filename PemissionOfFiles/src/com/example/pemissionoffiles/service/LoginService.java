package com.example.pemissionoffiles.service;

import java.io.FileOutputStream;
import android.annotation.SuppressLint;
import android.content.Context;

/**
 * @author nick
 * @param  context 上下文
 * @param usrname
 *              用户名 
 *@param passwd 
 *              密码
 *@param mode 0私有1可读2可写3公开
 */
public class LoginService {

	@SuppressLint({ "WorldReadableFiles", "WorldWriteableFiles" })
	@SuppressWarnings("deprecation")
	public static boolean SaveUserInfo(Context context,String usrname,String passwd,int mode){
		try {
			FileOutputStream fos = null;
			switch (mode) {
			case 0:
				fos  =  context.openFileOutput("private.txt", Context.MODE_PRIVATE);
				break;
			case 1:
				fos  =  context.openFileOutput("readable.txt", Context.MODE_WORLD_READABLE);
				break;
			case 2:
				fos  =  context.openFileOutput("writable.txt", Context.MODE_WORLD_WRITEABLE);
				break;
			case 3:
				fos  =  context.openFileOutput("open.txt", Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
				break;
			default:
				break; 
			}
			/*//File file = new File("/data/data/com.example.registerandlogin/info.txt");
			File file = new File(context.getFilesDir(),"info.txt"); 
			FileOutputStream fos = new FileOutputStream(file);*/
			fos.write((usrname+"##"+passwd).getBytes());
			fos.close();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
			return false;
		}
		
	}
}
