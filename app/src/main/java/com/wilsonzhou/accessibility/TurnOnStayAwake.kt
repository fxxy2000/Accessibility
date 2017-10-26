package com.wilsonzhou.accessibility

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.support.v4.content.LocalBroadcastManager
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class TurnOnStayAwake(private val mContext: Context): EventProcessor {
    private var isSettingsPage = false
    private var isDeveloperPage = false

    override fun init() {
        // Launch settings page
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        mContext.startActivity(intent)
    }

    override fun process(event: AccessibilityEvent) {
        if (event.source == null) {
            return
        }
        when(event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                // if already on developer page
                isDeveloperPage = event.source.packageName == "com.android.settings"
                        && !event.source.findAccessibilityNodeInfosByText("Stay awake").isEmpty()
                if (isDeveloperPage) {
                    return
                } else {
                    // if already on settings page
                    isSettingsPage = event.source.packageName == "com.android.settings"
                            && !event.source.findAccessibilityNodeInfosByText("Settings").isEmpty()
                    if (isSettingsPage) {
                        // goto developer page
                        val nodes = event.source.findAccessibilityNodeInfosByText("Developer options")
                        if (nodes.isEmpty()) {
                            // scroll the list
                            MyAccessibilityService.scrollList(event)
                        }
                    } else {
                        // Launch settings page if not currently on settings
                        val intent = Intent(Settings.ACTION_SETTINGS)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        mContext.startActivity(intent)
                    }
                }
            }
            AccessibilityEvent.TYPE_VIEW_SCROLLED -> {
                if (isDeveloperPage) {
                    // find Allow mock locations and check it
                    val nodes = event.source.findAccessibilityNodeInfosByText("Stay awake")
                    if (nodes.isEmpty()) {
                        // not found, scroll the list
                        MyAccessibilityService.scrollList(event)
                    } else {
                        // found, check it if not checked
                        val checkbox = nodes[0].parent.findAccessibilityNodeInfosByViewId("android:id/checkbox")
                        if (!checkbox.isEmpty() && !checkbox[0].isChecked) {
                            nodes[0].parent.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        }
                        // destroy block view if needed
                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
                    }
                } else if (isSettingsPage) {
                    // goto developer page
                    val nodes = event.source.findAccessibilityNodeInfosByText("Developer options")
                    if (nodes.isEmpty()) {
                        MyAccessibilityService.scrollList(event)
                    } else {
                        // found, click on "Developer options"
                        nodes[0].parent.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                    }
                }
            }
        }
    }
}
