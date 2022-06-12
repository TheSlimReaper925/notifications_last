package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var airplaneModeChangeReceiver: AirplaneModeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createChannel()
        airplaneModeChangeReceiver = AirplaneModeChangeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneModeChangeReceiver, it)
            NotificationUtil.showAirplaneEnabledNotification(this)
        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airplaneModeChangeReceiver)
    }

    private fun createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notification = NotificationChannel(NotificationUtil.CHANNEL_ID, NotificationUtil.CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Airplane Notification"
            }
            val manager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(notification)
        }
    }
}