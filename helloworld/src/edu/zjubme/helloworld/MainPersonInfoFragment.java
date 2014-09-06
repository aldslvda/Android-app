package edu.zjubme.helloworld;

import java.util.ArrayList;
import java.util.List;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainPersonInfoFragment extends Fragment{
	Spinner spinner;
	View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		init();
		
		return rootView;
	}

	private void init() {
		// TODO Auto-generated method stub
		spinner = (Spinner)rootView.findViewById(R.id.main_spinner_sex);
		List<String> list = getData();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(R.layout.spinner_dropdown); 
		spinner.setAdapter(adapter);
	}
	
	private static List<String> getData() {
		List<String> list = new ArrayList<String>();
		list.add("ÄÐ");
		list.add("Å®");
		return list;
	}
//    public void cl_to_choose_career(View view){
//    	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//		builder.setTitle("choose one");
//		final String[] items = new String[]{"choice01","choice02","choice03"};
//		builder.setSingleChoiceItems(items, 1, new OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getActivity() ,"ÄãÑ¡ÔñÁË"+items[which], 0).show();	 
//			TextView textview01 =(TextView)rootView.findViewById(R.id.main_tv_career01) ;
//		    textview01.setText(items[which]);
//				}
//		});
//		builder.show();
//    }
}
