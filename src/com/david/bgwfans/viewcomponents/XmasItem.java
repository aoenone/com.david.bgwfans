package com.david.bgwfans.viewcomponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.david.bgwfans.MainApp;
import com.david.bgwfans.R;

/**
 * Created by david.hodge on 11/10/13.
 */
public class XmasItem extends LinearLayout {

    private int mId;
    private String mText;
    private View.OnClickListener mOnClickListener;
    private View mSelector;

    public XmasItem(Context context, AttributeSet attrs) {

        super(context, attrs);
        setClickable(true);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater.from(context).inflate(R.layout.xmas_item, this, true);

        int textRes = attrs.getAttributeResourceValue(MainApp.XMLNS, "itemText", -1);
        if (textRes != -1) {
            mText = context.getString(textRes);
        } else {
            mText = attrs.getAttributeValue(MainApp.XMLNS, "itemText");
        }
        if (mText == null) {
            throw new IllegalArgumentException("Attribute itemText is required.");
        }
        ((TextView) findViewById(R.id.attraction_name)).setText(mText);

        int iconResId = attrs.getAttributeResourceValue(MainApp.XMLNS, "itemIcon", -1);
        if (iconResId != -1) {
            ((ImageView) findViewById(R.id.attraction_image)).setImageDrawable(getResources().getDrawable(iconResId));
        }


    }

    public XmasItem(Context context, int id) {
        super(context);
        setMyId(id);
    }

    public int getMyId() {
        return mId;
    }

    public void setMyId(int myId) {
        mId = myId;
    }

    public String getText() {
        return mText;
    }

    public void setText(int textResId) {
        mText = getContext().getString(textResId);
        if ((findViewById(R.id.attraction_name) != null)) {
            ((TextView) findViewById(R.id.attraction_name)).setText(textResId);
        }
    }

    public void setText(String text) {
        mText = text;
        if ((findViewById(R.id.attraction_name) != null)) {
            ((TextView) findViewById(R.id.attraction_name)).setText(text);
        }
    }
}
