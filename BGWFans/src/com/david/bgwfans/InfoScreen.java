package com.david.bgwfans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.simonvt.widget.MenuDrawerManager;
import android.app.ActionBar;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.TextView;

public class InfoScreen extends WindowSample implements View.OnClickListener {
	
	private MenuDrawerManager mMenuDrawer;
	private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
		@Override
		public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();
        
        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy");
        String curDate = df.format(c.getTime());
        
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        
        TextView textTime = (TextView) findViewById(R.id.curTime);
        textTime.setText(curDate);

}
		

		private void createNavigation() {
			// TODO Auto-generated method stub
			
		}
		
}
