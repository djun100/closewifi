package org.qii.closewifi

import android.app.Activity
import android.os.Bundle
import R._
import android.widget.Toast
import android.content.Context
import android.content.Intent

class Main extends Activity {

  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)

    Toast.makeText(getApplicationContext(),"πÿ±’wifi∆Ù∂Ø", Toast.LENGTH_SHORT).show()
    
    var i = new Intent(getApplicationContext(), classOf[BackgroundService])

    startService(i)
  }

}