package com.example.registerandlogin;

import java.util.Map;

import com.example.registerandlogin.sevice.LoginService;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity" ;
	private EditText et_usrname;
	private EditText et_passwd;
	private CheckBox cb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_usrname = (EditText)this.findViewById(R.id.et_usrname);
		et_passwd = (EditText)this.findViewById(R.id.et_passwd);
		cb = (CheckBox)this.findViewById(R.id.cb_savecookies);
		
		Map<String, String> map = LoginService.GetSavedUserInfo(this);
		if(map!= null){
			et_usrname.setText(map.get("usrname"));
			et_passwd.setText(map.get("passwd"));
		}
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
	public void login(View view){
		
		String usrname = et_usrname.getText().toString().trim();
		String passwd = et_passwd.getText().toString().trim();
		if (TextUtils.isEmpty(usrname)||TextUtils.isEmpty(passwd)){
			Toast.makeText(this, "�û��������벻��Ϊ��Ŷ��", Toast.LENGTH_SHORT).show();
		}
		else {
			if(cb.isChecked()){
				//�����û�������
				Log.i(TAG,"��Ҫ�����û���������");
				boolean result = LoginService.SaveUserInfo(this, usrname, passwd);
				if(result){
					Toast.makeText(this, "����ɹ�", Toast.LENGTH_SHORT).show();
				}
				else Toast.makeText(this, "��¼ʧ�ܣ������û����������Ƿ���ȷ", Toast.LENGTH_SHORT).show();
			}
			//��½
			if("aldslvda".equals (usrname) && "123".equals(passwd)){
				Toast.makeText(this, "��½�ɹ�", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "��¼ʧ�ܣ������û����������Ƿ���ȷ", Toast.LENGTH_SHORT).show();
			}
			
		}
	}

}
