package org.qii.closewifi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AutoStart extends BroadcastReceiver {

  override def onReceive(context: Context, intent: Intent) = {

    context.startActivity(new Intent(context.getApplicationContext(), classOf[Main]))

  }

}