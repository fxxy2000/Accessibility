package com.wilsonzhou.accessibility

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.support.v4.content.LocalBroadcastManager
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class UninstallApplication(val mContext : Context) : EventProcessor {
    private var isOnAppDetailsPage = false
    private var isOnConfirmPage = false
    private var done = false

    override fun isReady(): Boolean {
        return true
    }

    override fun destroy() {
    }

    override fun init(newTask : Boolean) {
        if(!isPackageInstalled()) {
            // destroy block view if needed
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
            return
        }
        done = false
        isOnAppDetailsPage = false
        isOnConfirmPage = false
        // Launch settings page
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        intent.data = Uri.parse("package:com.symantec.mobilesecurity")
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
        if (event.source == null && !done) {
            return
        }

        when(event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                var nodes : List<AccessibilityNodeInfo>?
                isOnConfirmPage = event.source.packageName == "com.android.packageinstaller"
                if (isOnConfirmPage) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        nodes = event.source.findAccessibilityNodeInfosByViewId("android:id/button1")
                    } else {
                        nodes = event.source.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/ok_button")
                    }
                    if (!nodes.isEmpty()) {
                        nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        // destroy block view if needed
                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
                        done = true
                        return
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        nodes = event.source.findAccessibilityNodeInfosByViewId("com.android.settings:id/app_snippet")
                    } else {
                        nodes = event.source.findAccessibilityNodeInfosByViewId("com.android.settings:id/all_details")
                    }

                    isOnAppDetailsPage = !nodes.isEmpty() && event.source.packageName == "com.android.settings"
                    if (isOnAppDetailsPage) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            nodes = event.source.findAccessibilityNodeInfosByViewId("com.android.settings:id/left_button")
                        } else {
                            nodes = nodes[0].findAccessibilityNodeInfosByViewId("com.android.settings:id/right_button")
                        }
                        if(!nodes.isEmpty()) {
                            nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
                            return
                        }
                    }
                }
                init(true)
            }
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && event.source.packageName == "com.android.packageinstaller") {
                    var nodes = event.source.findAccessibilityNodeInfosByViewId("android:id/button1")
                    if (!nodes.isEmpty()) {
                        nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        // destroy block view if needed
                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
                        done = true
                    }
                }
            }
        }
    }
}
