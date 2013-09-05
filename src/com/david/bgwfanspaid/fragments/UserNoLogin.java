package com.david.bgwfanspaid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.david.bgwfanspaid.R;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 9/1/13
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserNoLogin extends RoboSherlockFragment {

    View view;
    Button facebookBtn;
    Button fourSquareBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_user_no_login, container, false);

        facebookBtn = (Button) view.findViewById(R.id.user_signin_facebook);
        fourSquareBtn = (Button) view.findViewById(R.id.user_signin_foursquare);

        setOnClick();

        return view;
    }

    public void setOnClick(){
        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO set facebook login session
            }
        });

        fourSquareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO set foursquare login session
            }
        });
    }
}
