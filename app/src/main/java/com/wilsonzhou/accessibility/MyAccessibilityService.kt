package com.wilsonzhou.accessibility

import android.accessibilityservice.AccessibilityService
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class MyAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        val sb = StringBuilder()
        when (event.eventType) {
            /**
             * VIEW TYPES
             */
            AccessibilityEvent.TYPE_VIEW_CLICKED -> {
                sb.append("====TYPE_VIEW_CLICKED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("isPassword:"+event.isPassword+"\n")
                sb.append("isChecked:"+event.isChecked+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("scrollX:"+event.scrollX+"\n")
                sb.append("scrollY:"+event.scrollY+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("toIndex:"+event.toIndex+"\n")
                sb.append("itemCount:"+event.itemCount+"\n")
                sb.append("====TYPE_VIEW_CLICKED_FOOT===\n")
            }
            AccessibilityEvent.TYPE_VIEW_LONG_CLICKED -> {
                sb.append("====TYPE_VIEW_LONG_CLICKED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("isPassword:"+event.isPassword+"\n")
                sb.append("isChecked:"+event.isChecked+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("scrollX:"+event.scrollX+"\n")
                sb.append("scrollY:"+event.scrollY+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("toIndex:"+event.toIndex+"\n")
                sb.append("itemCount:"+event.itemCount+"\n")
                sb.append("====TYPE_VIEW_LONG_CLICKED_FOOT===\n")
            }
            AccessibilityEvent.TYPE_VIEW_SELECTED -> {
                sb.append("====TYPE_VIEW_SELECTED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("isPassword:"+event.isPassword+"\n")
                sb.append("isChecked:"+event.isChecked+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("scrollX:"+event.scrollX+"\n")
                sb.append("scrollY:"+event.scrollY+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("toIndex:"+event.toIndex+"\n")
                sb.append("itemCount:"+event.itemCount+"\n")
                sb.append("currentItemIndex:"+event.currentItemIndex+"\n")
                sb.append("====TYPE_VIEW_SELECTED_FOOT===\n")
            }
            AccessibilityEvent.TYPE_VIEW_FOCUSED -> {
                sb.append("====TYPE_VIEW_FOCUSED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("isPassword:"+event.isPassword+"\n")
                sb.append("isChecked:"+event.isChecked+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("scrollX:"+event.scrollX+"\n")
                sb.append("scrollY:"+event.scrollY+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("toIndex:"+event.toIndex+"\n")
                sb.append("itemCount:"+event.itemCount+"\n")
                sb.append("currentItemIndex:"+event.currentItemIndex+"\n")
                sb.append("====TYPE_VIEW_FOCUSED_FOOT===\n")
            }
            AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED -> {
                sb.append("====TYPE_VIEW_TEXT_CHANGED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("isPassword:"+event.isPassword+"\n")
                sb.append("isChecked:"+event.isChecked+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("addedCount:"+event.addedCount+"\n")
                sb.append("removedCount:"+event.removedCount+"\n")
                sb.append("beforeText:"+event.beforeText+"\n")
                sb.append("====TYPE_VIEW_TEXT_CHANGED_FOOT===\n")
            }
            AccessibilityEvent.TYPE_VIEW_SCROLLED -> {
                sb.append("====TYPE_VIEW_SCROLLED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("isPassword:"+event.isPassword+"\n")
                sb.append("isChecked:"+event.isChecked+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("scrollX:"+event.scrollX+"\n")
                sb.append("scrollY:"+event.scrollY+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("toIndex:"+event.toIndex+"\n")
                sb.append("itemCount:"+event.itemCount+"\n")
                sb.append("====TYPE_VIEW_SCROLLED_FOOT===\n")
            }
            /**
             * TRANSITION TYPES
             */
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                sb.append("====TYPE_WINDOW_STATE_CHANGED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("====TYPE_WINDOW_STATE_CHANGED_FOOT===\n")
            }
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {
                sb.append("====TYPE_WINDOW_CONTENT_CHANGED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    sb.append("contentChangeTypes:"+event.contentChangeTypes+"\n")
                }
                sb.append("====TYPE_WINDOW_CONTENT_CHANGED_FOOT===\n")
            }
            AccessibilityEvent.TYPE_WINDOWS_CHANGED -> {
                sb.append("====TYPE_WINDOWS_CHANGED_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
                    val windowInfo = event.source.window
                    sb.append("window:"+windowInfo.toString()+"\n")
                }
                sb.append("====TYPE_WINDOWS_CHANGED_FOOT===\n")
            }
            /**
             * EXPLORATION TYPES
             */
            AccessibilityEvent.TYPE_VIEW_HOVER_ENTER -> {
                sb.append("====TYPE_VIEW_HOVER_ENTER_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("scrollX:"+event.scrollX+"\n")
                sb.append("scrollY:"+event.scrollY+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("toIndex:"+event.toIndex+"\n")
                sb.append("itemCount:"+event.itemCount+"\n")
                sb.append("====TYPE_VIEW_HOVER_ENTER_FOOT===\n")
            }
            AccessibilityEvent.TYPE_VIEW_HOVER_EXIT -> {
                sb.append("====TYPE_VIEW_HOVER_EXIT_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("contentDesc:"+event.contentDescription+"\n")
                sb.append("scrollX:"+event.scrollX+"\n")
                sb.append("scrollY:"+event.scrollY+"\n")
                sb.append("fromIndex:"+event.fromIndex+"\n")
                sb.append("toIndex:"+event.toIndex+"\n")
                sb.append("itemCount:"+event.itemCount+"\n")
                sb.append("====TYPE_VIEW_HOVER_EXIT_FOOT===\n")
            }
            AccessibilityEvent.TYPE_TOUCH_INTERACTION_START -> {
                sb.append("====TYPE_TOUCH_INTERACTION_START_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("====TYPE_TOUCH_INTERACTION_START_FOOT===\n")
            }
            AccessibilityEvent.TYPE_TOUCH_INTERACTION_END -> {
                sb.append("====TYPE_TOUCH_INTERACTION_END_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("====TYPE_TOUCH_INTERACTION_END_FOOT===\n")
            }
            AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START -> {
                sb.append("====TYPE_TOUCH_EXPLORATION_GESTURE_START_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("====TYPE_TOUCH_EXPLORATION_GESTURE_START_FOOT===\n")
            }
            AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END -> {
                sb.append("====TYPE_TOUCH_EXPLORATION_GESTURE_END_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("====TYPE_TOUCH_EXPLORATION_GESTURE_END_FOOT===\n")
            }
            AccessibilityEvent.TYPE_GESTURE_DETECTION_START -> {
                sb.append("====TYPE_GESTURE_DETECTION_START_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("====TYPE_GESTURE_DETECTION_START_FOOT===\n")
            }
            AccessibilityEvent.TYPE_GESTURE_DETECTION_END -> {
                sb.append("====TYPE_GESTURE_DETECTION_END_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("====TYPE_GESTURE_DETECTION_END_FOOT===\n")
            }
            /**
             * MISCELLANEOUS TYPES
             */
            AccessibilityEvent.TYPE_ANNOUNCEMENT -> {
                sb.append("====TYPE_ANNOUNCEMENT_HEAD===\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("====TYPE_ANNOUNCEMENT_FOOT===\n")
            }
            else -> {
                sb.append("====TYPE_ELSE_HEAD====\n")
                sb.append("eventType:"+event.eventType+"\n")
                sb.append("source:"+event.source+"\n")
                sb.append("className:"+event.className+"\n")
                sb.append("packageName:"+event.packageName+"\n")
                sb.append("eventTime:"+event.eventTime+"\n")
                sb.append("text:"+event.text+"\n")
                sb.append("isEnabled:"+event.isEnabled+"\n")
                sb.append("====TYPE_ELSE_FOOT====\n")
            }
        }
        Log.i(TAG, sb.toString())
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.i(TAG, "onServiceConnected")
    }

    override fun onInterrupt() {
        Log.i(TAG, "onInterrupt")
    }

    companion object {
        internal val TAG = "MyAccessibilityService"
        internal fun init() {}
    }
}
