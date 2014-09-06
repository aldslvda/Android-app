package com.example.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
		Button bt_dial =  (Button) findViewById(R.id.bt_dial);
		bt_dial.setOnClickListener(new Mylistener());
		
	}
	private class Mylistener implements OnClickListener{
		@Override
		public void onClick(View v){
			EditText et_number = (EditText)MainActivity.this.findViewById(R.id.et_number);
			String number = et_number.getText().toString();
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+ number));
			startActivity(intent);
			
		}
		
	}
	
}
