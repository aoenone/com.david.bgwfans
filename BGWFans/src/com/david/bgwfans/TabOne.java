package com.david.bgwfans;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TabOne extends Fragment
{
	RelativeLayout b1;
	Context ctx = null;

         public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //ctx = getApplication();
            }

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
                        Bundle savedInstanceState)
        {
                View view = inflater.inflate(R.layout.coasters, container, false);
                return view;
        }

		private AssetManager getAssets() {
			// TODO Auto-generated method stub
			return null;
		}
		
}



