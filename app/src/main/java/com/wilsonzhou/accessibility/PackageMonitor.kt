package com.wilsonzhou.accessibility

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager

class PackageMonitor : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val i = Intent()
        i.putExtra("uri", intent.dataString)
        when (intent.action) {
            Intent.ACTION_PACKAGE_ADDED -> {
               i.action = "package_added"
            }
            Intent.ACTION_PACKAGE_REMOVED -> {
                i.action = "package_removed"
            }
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(i)
    }
}
