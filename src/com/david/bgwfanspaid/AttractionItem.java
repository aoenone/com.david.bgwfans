package com.david.bgwfanspaid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/11/13
 * Time: 3:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class AttractionItem extends LinearLayout{

    private int mId;
    private String mText;
    private View.OnClickListener mOnClickListener;
    private View mSelector;

    public AttractionItem(Context context, AttributeSet attrs) {

        super(context, attrs);
        setClickable(true);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater.from(context).inflate(R.layout.attraction_item, this, true);

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

    public AttractionItem(Context context, int id) {
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

