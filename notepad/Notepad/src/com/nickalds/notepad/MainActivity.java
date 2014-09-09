package com.nickalds.notepad;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	private Button bt_add , bt_read ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_add = (Button)findViewById(R.id.bt_add);
		bt_read = (Button)findViewById(R.id.bt_read);
		
		bt_add.setOnClickListener(this);
		bt_read.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		// switch buttons
		switch (v.getId()) {
		case R.id.bt_add:
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, Activity_edit.class);
			startActivity(intent);
			break;
		case R.id.bt_read:
			Intent intent1=new Intent();
			intent1.setClass(MainActivity.this, Activity_content.class);
			startActivity(intent1);
			break;
		default:
			break;
		}
		
	}
}
