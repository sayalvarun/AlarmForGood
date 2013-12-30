package com.sayalVarun.alarmforgood;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.example.alarmforgood.R;

public class NewAlarmActivity extends Activity {
    
    private TimePicker picker;
    
    private EditText etaEditText;
    
    private Button newAlarmButton;
    
    private DatePicker alarmDatePicker;
    
    private Time now;
    private Time then;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.activity_new_alarm);
	
	// Show the Up button in the action bar.
	setupActionBar();
	
	picker = (TimePicker) findViewById(R.id.alarmTimePicker);
	
	now = new Time(picker.getCurrentHour(), picker.getCurrentMinute());
	
	etaEditText = (EditText) findViewById(R.id.etaEditText);
	
	newAlarmButton = (Button) findViewById(R.id.newAlarmButton);
	
	alarmDatePicker = (DatePicker) findViewById(R.id.alarmDatePicker);
	
	setUpOnTimeChangedListener();
	
	setUpOnDateChangedListener();
	
	setUpButtonOnClickListener();
	
    }
    
    private void setUpOnTimeChangedListener(){
	picker.setOnTimeChangedListener(new OnTimeChangedListener(){

	    @Override
	    public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
		then = new Time(picker.getCurrentHour(), picker.getCurrentMinute());
		Time diff = then.calculateDifference(now);
		updateETA(diff);
	    }
	    
	});
	
    }
    
    private void setUpOnDateChangedListener(){
	
    }
    
    
    
    private void setUpButtonOnClickListener(){
	newAlarmButton.setOnClickListener(new OnClickListener(){

	    @Override
	    public void onClick(View arg0) {
		
		
	    }
	    
	});
	
    }
	
    
    
    private void updateETA(Time diff){
	etaEditText.setText(diff.getHours()+" Hours, "+diff.getMinutes()+" Minutes.");
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.new_alarm, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case android.R.id.home:
	    // This ID represents the Home or Up button. In the case of this
	    // activity, the Up button is shown. Use NavUtils to allow users
	    // to navigate up one level in the application structure. For
	    // more details, see the Navigation pattern on Android Design:
	    //
	    // http://developer.android.com/design/patterns/navigation.html#up-vs-back
	    //
	    NavUtils.navigateUpFromSameTask(this);
	    return true;
	}
	return super.onOptionsItemSelected(item);
    }

}
