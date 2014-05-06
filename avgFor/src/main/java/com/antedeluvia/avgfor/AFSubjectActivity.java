package com.antedeluvia.avgfor;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;
import android.os.Build;
import android.os.Bundle;

public class AFSubjectActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_af_list_container);		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.pure_list_container);
		if(fragment == null){
			fragment = new AFSubjectFragment();
			fm.beginTransaction().add(R.id.pure_list_container,fragment).commit();
			
		}
		// set app name color
		int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
		TextView actionBarTitle = (TextView) findViewById(titleId);
		actionBarTitle.setTextColor(getResources().getColor(R.color.pale));
	}	
}
