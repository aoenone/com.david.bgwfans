package com.david.bgwfans;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TabOne extends Fragment
{
	RelativeLayout b1;
	Context ctx = null;
	public AdView adView;

         public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //ctx = getApplication();
            }

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
                        Bundle savedInstanceState)
        {
                View view = inflater.inflate(R.layout.coasters, container, false);
                
                //Pay no mind, this is for a few easter eggs. Gotta change it up every now and then
                final Button aButton = (Button)view.findViewById(R.id.apolloButton);
                final TextView aText = (TextView)view.findViewById(R.id.apollot);
                final Button gButton = (Button)view.findViewById(R.id.griffonButton);
                final TextView gText = (TextView)view.findViewById(R.id.griffont);
                final Button vButton = (Button)view.findViewById(R.id.vboltButton);
                final TextView vText = (TextView)view.findViewById(R.id.vboltt);
                
                aButton.setOnLongClickListener(new OnLongClickListener()
            	{
            	@Override
            	public boolean onLongClick(View v) {
            	
            			aButton.setBackgroundResource(R.drawable.fabio);
            			aText.setText("Apollo's Chariot -> Poor Fabio");
            			return true;
            		}
            	});
                
                gButton.setOnLongClickListener(new OnLongClickListener()
            	{
            	@Override
            	public boolean onLongClick(View v) {
           
            			gButton.setBackgroundResource(R.drawable.lemans);
            			gText.setText("Griffon -> RIP Le Mans Raceway");
            			return true;
            		}
            	});
                
                vButton.setOnLongClickListener(new OnLongClickListener()
            	{
            	@Override
            	public boolean onLongClick(View v) {
            	
            			vButton.setBackgroundResource(R.drawable.bbw);
            			vText.setText("Verbolten -> RIP Big Bad Wolf");
            			return true;
            		}
            	});
                return view;
        }
		

		private AssetManager getAssets() {
			// TODO Auto-generated method stub
			return null;
		}
		
}



