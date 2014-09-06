package com.example.mradiobutton;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	RadioButton button;
	RadioGroup group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
			
    public void onRadioButtonClicked(View view) {
			    // Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
			    
			    // Check which radio button was clicked
		switch(view.getId()) {
			case R.id.radio_male:
				if (checked)
			    break;
			case R.id.radio_female:
				if (checked)
			    break;
			    }
			}
		/*	public void onClick(View v) {
				// TODO Auto-generated method stub
				int len = group.getChildCount();
				String msgString = "";
				for (int i = 0; i < len; i++) {
					RadioButton radioButton = (RadioButton)group.getChildAt(i);
					if (radioButton.isChecked()){
						msgString = radioButton.getText().toString();
						break;
						
					}
				}
				Toast.makeText(MainActivity.this, msgString, Toast.LENGTH_SHORT).show();
			}*/


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
}
