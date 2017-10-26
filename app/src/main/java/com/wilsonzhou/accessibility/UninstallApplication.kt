package com.wilsonzhou.accessibility

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.support.v4.content.LocalBroadcastManager
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class UninstallApplication(val mContext : Context) : EventProcessor {
    private var isOnAppDetailsPage = false
    private var isOnConfirmPage = false

    override fun init() {
        if(!isPackageInstalled()) {
            // destroy block view if needed
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
            return
        }
        // Launch settings page
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.parse("package:com.symantec.mobilesecurity")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        mContext.startActivity(intent)
    }

    private fun isPackageInstalled() : Boolean {
        try {
            mContext.packageManager.getPackageInfo("com.symantec.mobilesecurity", 0)
            return true
        } catch (e : PackageManager.NameNotFoundException) {
            return false
        }
    }
    override fun process(event: AccessibilityEvent) {
        if (event.source == null) {
            return
        }

        when(event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                var nodes : List<AccessibilityNodeInfo>?
                isOnConfirmPage = event.source.packageName == "com.android.packageinstaller"
                if (isOnConfirmPage) {
                    nodes = event.source.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/ok_button")
                    if (!nodes.isEmpty()) {
                        nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        // destroy block view if needed
                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
                        return
                    }
                } else {
                    nodes = event.source.findAccessibilityNodeInfosByViewId("com.android.settings:id/all_details")
                    isOnAppDetailsPage = !nodes.isEmpty() && event.source.packageName == "com.android.settings"
                    if (isOnAppDetailsPage) {
                        nodes = nodes[0].findAccessibilityNodeInfosByViewId("com.android.settings:id/right_button")
                        if(!nodes.isEmpty()) {
                            nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
                            return
                        }
                    }
                }
                init()
            }
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {
            }
        }
    }
}
