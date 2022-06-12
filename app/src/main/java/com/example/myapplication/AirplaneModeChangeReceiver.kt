package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var isAirplaneModeEnabled: Boolean = intent?.getBooleanExtra("state", false) ?: return

        if (isAirplaneModeEnabled){
            NotificationUtil.showAirplaneEnabledNotification(context!!)
            Toast.makeText(context, "Airplane mode is enabled", Toast.LENGTH_LONG).show()
        }else{
            NotificationUtil.showAirplaneDisabledNotification(context!!)
            Toast.makeText(context, "Airplane mode is disabled", Toast.LENGTH_LONG).show()
        }
    }

}