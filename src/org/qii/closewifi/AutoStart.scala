package org.qii.closewifi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AutoStart extends BroadcastReceiver {

  override def onReceive(context: Context, intent: Intent) = {

    //    var i = new Intent(context.getApplicationContext(), classOf[Main])
    //    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    //    context.startActivity(i)

    var i = new Intent(context.getApplicationContext(), classOf[BackgroundService])

    context.startService(i)

  }

}