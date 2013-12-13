package com.david.bgwfans.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.david.bgwfans.NewMainActivity;
import com.david.bgwfans.R;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 9/15/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class HOSWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        Intent intent = new Intent(context, NewMainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.hos_info_card);
        remoteViews.setTextViewText(R.id.cur_temp_text, "60");
        remoteViews.setOnClickPendingIntent(R.id.cur_temp_text, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }

}
