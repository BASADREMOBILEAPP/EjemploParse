package com.example.edward.ejemploparse;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class PushReceiver extends BroadcastReceiver{
    private static final String TAG = "PushReceiver";

    public void onReceive(Context context, Intent intent) {
        JSONObject json = null;
        try {

            json = new JSONObject(intent.getExtras().getString("com.parse.Data"));


            Intent resultIntent = new Intent(context, MainActivity.class);
            resultIntent.putExtra("texto", json.getString("texto")); //Aquí pasamos la información XD
            PendingIntent resultPendingIntent =
                    PendingIntent.getActivity(
                            context,
                            0,
                            resultIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_launcher).setContentTitle(json.getString("titulo"))
                            .setContentText(json.getString("texto"))
                            .setContentIntent(resultPendingIntent)
                            .setAutoCancel(true);
            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1, mBuilder.build());

        } catch (JSONException e) {
            Log.d(TAG, "JSONException: " + e.getMessage());
        }
    }
}