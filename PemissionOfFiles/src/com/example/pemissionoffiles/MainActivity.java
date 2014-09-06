package com.example.pemissionoffiles;

import com.example.pemissionoffiles.service.LoginService;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity" ;
	private EditText et_usrname;
	private EditText et_passwd;
	private CheckBox cb;
	private RadioGroup rg_mode;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_usrname = (EditText)this.findViewById(R.id.et_usrname);
		et_passwd = (EditText)this.findViewById(R.id.et_passwd);
		cb = (CheckBox)this.findViewById(R.id.cb_savecookies);
		rg_mode = (RadioGroup)this.findViewById(R.id.rg_mode);

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
			Toast.makeText(this, "用户名或密码不能为空哦亲", Toast.LENGTH_SHORT).show();
		}
		else {
			if(cb.isChecked()){
				//保存用户名密码
				Log.i(TAG,"需要保存用户名和密码");
				boolean result = false;
				int id = rg_mode.getCheckedRadioButtonId();
				switch (id) {
				case R.id.rd_private:
					result = LoginService.SaveUserInfo(this, usrname, passwd,0);
					break;
				case R.id.rd_readable:
					result = LoginService.SaveUserInfo(this, usrname, passwd,1);
					break;
				case R.id.rd_writable:
					result = LoginService.SaveUserInfo(this, usrname, passwd,2);
					break;
				case R.id.rd_open:
					result = LoginService.SaveUserInfo(this, usrname, passwd,3);
					break;

				default:
					break;
				}
				
				if(result){
					Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
				}
				else Toast.makeText(this, "登录失败，请检查用户名或密码是否正确", Toast.LENGTH_SHORT).show();
			}
			//登陆
			if("aldslvda".equals (usrname) && "123".equals(passwd)){
				Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "登录失败，请检查用户名或密码是否正确", Toast.LENGTH_SHORT).show();
			}
			
		}
	}

}

