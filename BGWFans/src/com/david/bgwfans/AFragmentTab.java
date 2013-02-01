package com.david.bgwfans;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AFragmentTab extends Fragment{

	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState)
	{
        View view = inflater.inflate(R.layout.coasters, container, false);
        
        return view;
	}
}
