package com.example.myapplication

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

object NotificationUtil {
    const val CHANNEL_ID = "APPCHANNELID"
    fun showAirplaneEnabledNotification(context: Context){
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
            .setContentTitle("Airplane Mode is Enabled.")
            .setContentText("Your Airplane mode is activated.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification.build())
    }

    fun showAirplaneDisabledNotification(context: Context){
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_airplanemode_inactive_24)
            .setContentTitle("Airplane Mode is Disabled.")
            .setContentText("Your Airplane mode is disabled.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification.build())
    }
}