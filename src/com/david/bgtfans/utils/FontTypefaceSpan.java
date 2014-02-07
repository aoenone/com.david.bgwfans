package com.david.bgtfans.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

import com.actionbarsherlock.app.ActionBar;
import com.david.bgtfans.R;

import oak.util.OakUtils;

/**
 * Created by david.hodge on 2/6/14.
 */
public class FontTypefaceSpan extends MetricAffectingSpan {

    private Typeface mTypeface;

    public FontTypefaceSpan(Context context, String typefaceName) {
        mTypeface = OakUtils.getStaticTypeFace(context, typefaceName);
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        p.setTypeface(mTypeface);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setTypeface(mTypeface);
    }

    public static void setActionBarTitle(Context context, ActionBar actionBar, String title) {
        SpannableString s = new SpannableString(title);
        s.setSpan(new FontTypefaceSpan(context, context.getString(R.string.action_bar_font)), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);
    }

    public static void setActionBarSubTitle(Context context, ActionBar actionBar, String title) {
        SpannableString s = new SpannableString(title);
        s.setSpan(new FontTypefaceSpan(context, context.getString(R.string.subtitle_font)), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setSubtitle(s);
    }

    public static void setActionBarTitle(Context context, ActionBar actionBar, int titleResId) {
        SpannableString s = new SpannableString(context.getString(titleResId));
        s.setSpan(new FontTypefaceSpan(context, context.getString(R.string.action_bar_font)), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);
    }

    public static void setActionBarTitle(Context context, android.app.ActionBar actionBar, String title) {
        SpannableString s = new SpannableString(title.toUpperCase());
        s.setSpan(new FontTypefaceSpan(context, context.getString(R.string.action_bar_font)), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);
    }

    public static void setActionBarTitle(Context context, android.app.ActionBar actionBar, int titleResId) {
        SpannableString s = new SpannableString(context.getString(titleResId).toUpperCase());
        s.setSpan(new FontTypefaceSpan(context, context.getString(R.string.action_bar_font)), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);
    }
}
