package org.qii.closewifi

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.IBinder
import android.R
import android.app.NotificationManager

class BackgroundService extends Service {
  override def onBind(intent: Intent): IBinder = {
    return null
  }

  override def onStartCommand(intent: Intent, flags: Int, startId: Int): Int = {
    startBroadcastReceivers
    startNotification
    return Service.START_STICKY
  }

  def startBroadcastReceivers = {

    var closewifi = new Closewifi()

    var intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(closewifi, intentFilter);

  }

  def startNotification = {
    var nm = getSystemService(Context.NOTIFICATION_SERVICE).asInstanceOf[NotificationManager]
    var notification = new Notification(android.R.drawable.btn_minus, "1", System.currentTimeMillis());

    notification.flags = Notification.DEFAULT_ALL;

    var pt = PendingIntent.getActivity(this, 0, new Intent(getApplicationContext, classOf[Main]), 0);

    notification.setLatestEventInfo(this, "2", "3", pt);

    nm.notify(1, notification);

  }
}

class Closewifi extends BroadcastReceiver {
  override def onReceive(context: Context, intent: Intent) {

    var manager = context.getSystemService(Context.WIFI_SERVICE).asInstanceOf[WifiManager];

    if (manager.isWifiEnabled()) {
      manager.setWifiEnabled(false);
    }

  }
}