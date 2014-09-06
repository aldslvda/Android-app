package com.example.mpopupwindow;

import android.annotation.SuppressLint;
import android.app.Activity; 
import android.os.Bundle; 
import android.view.Gravity; 
import android.view.LayoutInflater; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.PopupWindow; 
import android.widget.RadioGroup; 
import android.widget.RadioGroup.OnCheckedChangeListener; 
 
public class MainActivity extends Activity implements OnClickListener, 
        OnCheckedChangeListener { 
 
    private Button mbutton01; 
    private Button mbutton02; 
    private Button mbutton03; 
    private Button mbutton04; 
    private PopupWindow mPopupWindow; 
    // ��Ļ��width 
   /* private int mScreenWidth; 
    // ��Ļ��height 
    private int mScreenHeight; 
    // PopupWindow��width 
    private int mPopupWindowWidth; 
    // PopupWindow��height 
    private int mPopupWindowHeight; */
 
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        mbutton01 = (Button) findViewById(R.id.button01); 
        mbutton02 = (Button) findViewById(R.id.button02); 
        mbutton03 = (Button) findViewById(R.id.button03); 
        mbutton04 = (Button) findViewById(R.id.button04); 
 
        mbutton01.setOnClickListener(this); 
        mbutton02.setOnClickListener(this); 
        mbutton03.setOnClickListener(this); 
        mbutton04.setOnClickListener(this); 
    } 
 
    @Override 
    public void onClick(View v) { 
        switch (v.getId()) { 
        // ���ĳ���ؼ���λ�ã������·�������ƫ�� 
        case R.id.button01: 
            getPopupWindowInstance(); 
            mPopupWindow.showAsDropDown(v); 
            break; 
 
        // ���ĳ���ؼ���λ�ã������·�������ƫ�� 
        case R.id.button02: 
            getPopupWindowInstance(); 
            mPopupWindow.showAsDropDown(v, 50, 50);// X��Y�����ƫ��50 
            break; 
 
        // ����ڸ��ؼ���λ�ã���ƫ�� 
        case R.id.button03: 
            getPopupWindowInstance(); 
            mPopupWindow.showAtLocation(v, Gravity.CENTER, 0, 0); 
            break; 
 
        // ����ڸ��ؼ���λ�ã���ƫ�� 
        case R.id.button04: 
            getPopupWindowInstance(); 
            mPopupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 50); 
            break; 
 
        default: 
            break; 
        } 
    } 
 
    @Override 
    public void onCheckedChanged(RadioGroup group, int checkedId) { 
        mPopupWindow.dismiss(); 
    } 
 
    /*
     * ��ȡPopupWindowʵ��
     */ 
    private void getPopupWindowInstance() { 
        if (null != mPopupWindow) { 
            mPopupWindow.dismiss(); 
            return; 
        } else { 
            initPopuptWindow(); 
        } 
    } 
 
    /*
     * ����PopupWindow
     */ 
    @SuppressLint("InflateParams")
	private void initPopuptWindow() { 
        LayoutInflater layoutInflater = LayoutInflater.from(this); 
        View popupWindow = layoutInflater.inflate(R.layout.popup_window, null); 
        RadioGroup radioGroup = (RadioGroup) popupWindow.findViewById(R.id.radioGroup); 
        radioGroup.setOnCheckedChangeListener(this); 
 
        // ����һ��PopupWindow 
        // ����1��contentView ָ��PopupWindow������ 
        // ����2��width ָ��PopupWindow��width 
        // ����3��height ָ��PopupWindow��height 
        mPopupWindow = new PopupWindow(popupWindow,400,570); 
 
        // ��ȡ��Ļ��PopupWindow��width��height 
        ///Display display = getWindowManager().getDefaultDisplay(); 
        //Point size = new Point(); 
       // display.getSize(size); 
       // mPopupWindowWidth = mPopupWindow.getWidth(); 
       // mPopupWindowHeight = mPopupWindow.getHeight(); 
    } 
} 