package com.david.bgtfans.geofence;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;

import com.david.bgtfans.R;
import com.david.bgtfans.bgt.MainActivity;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationClient;

import java.util.List;

/**
 * This class receives geofence transition events from Location Services, in the
 * form of an Intent containing the transition type and geofence id(s) that triggered
 * the event.
 */
public class ReceiveTransitionsIntentService extends IntentService {

    /**
     * Sets an identifier for this class' background thread
     */
    public ReceiveTransitionsIntentService() {
        super("ReceiveTransitionsIntentService");
    }

    /**
     * Handles incoming intents
     * @param intent The Intent sent by Location Services. This Intent is provided
     * to Location Services (inside a PendingIntent) when you call addGeofences()
     */
    @Override
    protected void onHandleIntent(Intent intent) {

        // Create a local broadcast Intent
        Intent broadcastIntent = new Intent();

        // Give it the category for all intents sent by the Intent Service
        broadcastIntent.addCategory(GeofenceUtils.CATEGORY_LOCATION_SERVICES);

        // First check for errors
        if (LocationClient.hasError(intent)) {

            // Get the error code
            int errorCode = LocationClient.getErrorCode(intent);

            // Get the error message
            String errorMessage = LocationServiceErrorMessages.getErrorString(this, errorCode);

            // Log the error
            Log.e(GeofenceUtils.APPTAG,
                    getString(R.string.geofence_transition_error_detail, errorMessage)
            );

            // Set the action and error message for the broadcast intent
            broadcastIntent.setAction(GeofenceUtils.ACTION_GEOFENCE_ERROR)
                    .putExtra(GeofenceUtils.EXTRA_GEOFENCE_STATUS, errorMessage);

            // Broadcast the error *locally* to other components in this app
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent);

            // If there's no error, get the transition type and create a notification
        } else {

            // Get the type of transition (entry or exit)
            int transition = LocationClient.getGeofenceTransition(intent);

            // Test that a valid transition was reported
            if (
                    (transition == Geofence.GEOFENCE_TRANSITION_ENTER)
                            ||
                            (transition == Geofence.GEOFENCE_TRANSITION_EXIT)
                    ) {

                // Post a notification
                List<Geofence> geofences = LocationClient.getTriggeringGeofences(intent);
                String[] geofenceIds = new String[geofences.size()];
                for (int index = 0; index < geofences.size() ; index++) {
                    geofenceIds[index] = geofences.get(index).getRequestId();
                }
                String ids = TextUtils.join(GeofenceUtils.GEOFENCE_ID_DELIMITER,geofenceIds);
                String transitionType = getTransitionString(transition);

                sendNotification(transitionType, ids);

                // Log the transition type and a message
                Log.d(GeofenceUtils.APPTAG,
                        getString(
                                R.string.geofence_transition_notification_title,
                                transitionType,
                                ids));
                Log.d(GeofenceUtils.APPTAG,
                        getString(R.string.geofence_transition_notification_text));

                // An invalid transition was reported
            } else {
                // Always log as an error
                Log.e(GeofenceUtils.APPTAG,
                        getString(R.string.geofence_transition_invalid_type, transition));
            }
        }
    }

    /**
     * Posts a notification in the notification bar when a transition is detected.
     * If the user clicks the notification, control goes to the main Activity.
     * @param transitionType The type of transition that occurred.
     *
     */
    private void sendNotification(String transitionType, String ids) {

        //Demon Street stuff
        Intent demonIntent = new Intent(getBaseContext(), MainActivity.class);
        PendingIntent pendingDemonIntent =
                PendingIntent.getActivity(this, 0, demonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Bitmap demonPic = BitmapFactory.decodeResource(getResources(), R.drawable.hostest);
        Intent sendDemonIntent = new Intent();
        sendDemonIntent.setAction(Intent.ACTION_SEND);
        sendDemonIntent.putExtra(Intent.EXTRA_TEXT, "I'm at Demon Street, via the BGWFans for Android app! " + "https://play.google.com/store/apps/details?id=com.david.bgwfans");
        sendDemonIntent.setType("text/plain");
        PendingIntent pendingDemonShareIntent =
                PendingIntent.getActivity(this, 0, sendDemonIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        //Ripper Row stuff
        Intent ripperIntent = new Intent(getBaseContext(), MainActivity.class);
        PendingIntent pendingRipperIntent =
                PendingIntent.getActivity(this, 0, ripperIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Bitmap ripperPic = BitmapFactory.decodeResource(getResources(), R.drawable.hostest);
        Intent sendRipperIntent = new Intent();
        sendRipperIntent.setAction(Intent.ACTION_SEND);
        sendRipperIntent.putExtra(Intent.EXTRA_TEXT, "I'm at Ripper Row, via the BGWFans for Android app! " + "https://play.google.com/store/apps/details?id=com.david.bgwfans");
        sendRipperIntent.setType("text/plain");
        PendingIntent pendingRipperShareIntent =
                PendingIntent.getActivity(this, 0, sendRipperIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        //Vampire Point stuff
        Intent vampireIntent = new Intent(getBaseContext(), MainActivity.class);
        PendingIntent pendingVampireIntent =
                PendingIntent.getActivity(this, 0, vampireIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Bitmap vampirePic = BitmapFactory.decodeResource(getResources(), R.drawable.hostest);
        Intent sendVampireIntent = new Intent();
        sendVampireIntent.setAction(Intent.ACTION_SEND);
        sendVampireIntent.putExtra(Intent.EXTRA_TEXT, "I'm at Demon Street, via the BGWFans for Android app! " + "https://play.google.com/store/apps/details?id=com.david.bgwfans");
        sendVampireIntent.setType("text/plain");
        PendingIntent pendingVampireShareIntent =
                PendingIntent.getActivity(this, 0, sendVampireIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        //Ports of Skull stuff
        Intent portsIntent = new Intent(getBaseContext(), MainActivity.class);
        PendingIntent pendingPortsIntent =
                PendingIntent.getActivity(this, 0, portsIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Bitmap portsPic = BitmapFactory.decodeResource(getResources(), R.drawable.hostest);
        Intent sendPortIntent = new Intent();
        sendPortIntent.setAction(Intent.ACTION_SEND);
        sendPortIntent.putExtra(Intent.EXTRA_TEXT, "I'm at Demon Street, via the BGWFans for Android app! " + "https://play.google.com/store/apps/details?id=com.david.bgwfans");
        sendPortIntent.setType("text/plain");
        PendingIntent pendingPortShareIntent =
                PendingIntent.getActivity(this, 0, sendPortIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        // Create an explicit content Intent that starts the main Activity
//        Intent notificationIntent =
//                new Intent(getApplicationContext(),NewMainActivity.class);

        // Construct a task stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the main Activity to the task stack as the parent
//        stackBuilder.addParentStack(NewMainActivity.class);

        // Push the content Intent onto the stack
//        stackBuilder.addNextIntent(notificationIntent);

        // Get a PendingIntent containing the entire back stack
        PendingIntent notificationPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // Get a notification builder that's compatible with platform versions >= 4
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // Set the notification contents
        if(ids.equals(Integer.toString(1))){
            builder.setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(
                        getString(R.string.geofence_transition_notification_title,
                                transitionType, "Demon Street"))
                .setContentText("Paris is burning....")
                .setPriority(1)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(demonPic))
                .addAction(android.R.drawable.ic_menu_share, "Share", pendingDemonShareIntent)
                .addAction(R.drawable.ic_action_about, "Info", pendingDemonIntent)
                .setContentIntent(notificationPendingIntent);
        }else if (ids.equals(Integer.toString(2))){
            builder.setSmallIcon(R.drawable.iconv2)
                    .setContentTitle(
                            getString(R.string.geofence_transition_notification_title,
                                    transitionType, "Ports of Skull"))
                    .setContentText("Lost souls doomed to haunt the vessels they once sailed...")
                    .setPriority(1)
                    .setAutoCancel(true)
                    .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(portsPic))
                    .addAction(android.R.drawable.ic_menu_share, "Share", pendingPortShareIntent)
                    .addAction(R.drawable.ic_action_about, "Info", pendingPortsIntent)
                    .setContentIntent(notificationPendingIntent);
        }else if(ids.equals(Integer.toString(3))){
            builder.setSmallIcon(R.drawable.iconv2)
                    .setContentTitle(
                            getString(R.string.geofence_transition_notification_title,
                                    transitionType, "Ripper Row"))
                    .setContentText("Watch out for Jack the Ripper!")
                    .setPriority(1)
                    .setAutoCancel(true)
                    .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(ripperPic))
                    .addAction(android.R.drawable.ic_menu_share, "Share", pendingRipperShareIntent)
                    .addAction(R.drawable.ic_action_about, "Info", pendingRipperIntent)
                    .setContentIntent(notificationPendingIntent);
        }else if(ids.equals(Integer.toString(4))){
            builder.setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle(
                            getString(R.string.geofence_transition_notification_title,
                                    transitionType, "Vampire Point"))
                    .setContentText("Perfect destination for bloodsuckers...")
                    .setPriority(1)
                    .setAutoCancel(true)
                    .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(vampirePic))
                    .addAction(android.R.drawable.ic_menu_share, "Share", pendingVampireShareIntent)
                    .addAction(R.drawable.ic_action_about, "Info", pendingVampireIntent)
                    .setContentIntent(notificationPendingIntent);
        }

        // Get an instance of the Notification manager
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Issue the notification
        mNotificationManager.notify(0, builder.build());
    }


    /**
     * Maps geofence transition types to their human-readable equivalents.
     * @param transitionType A transition type constant defined in Geofence
     * @return A String indicating the type of transition
     */
    private String getTransitionString(int transitionType) {
        switch (transitionType) {

            case Geofence.GEOFENCE_TRANSITION_ENTER:
                return getString(R.string.geofence_transition_entered);

            case Geofence.GEOFENCE_TRANSITION_EXIT:
                return getString(R.string.geofence_transition_exited);

            default:
                return getString(R.string.geofence_transition_unknown);
        }
    }
}

