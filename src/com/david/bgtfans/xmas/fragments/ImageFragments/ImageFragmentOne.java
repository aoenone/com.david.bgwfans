package com.david.bgtfans.xmas.fragments.ImageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.david.bgtfans.utils.RenderBlurTransform;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import roboguice.inject.InjectView;
import com.david.bgtfans.R;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 10/22/13
 * Time: 8:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageFragmentOne extends RoboSherlockFragment {

    View view;
    @InjectView(R.id.header_background_image) ImageView headerImage;
    @InjectView(R.id.header_text) TextView headerText;
    @InjectView(R.id.loading) ProgressBar loading;
    private String imageLink;
    private String attrName;

    public ImageFragmentOne(String imageUrl, String attractionName){
        imageLink = imageUrl;
        attrName = attractionName;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.image_fragment_header, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        headerText.setVisibility(View.VISIBLE);
        headerText.setText(attrName);

            Picasso.with(getSherlockActivity())
                    .load(imageLink)
                    .resize(1000, 1000)
                    .centerCrop()
                    .transform(new RenderBlurTransform(getSherlockActivity()))
                    .into(headerImage, new Callback() {
                        @Override
                        public void onSuccess() {
                            loading.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            loading.setVisibility(View.GONE);
                            headerText.setText("Error loading image");
                        }
                    });
    }
}
