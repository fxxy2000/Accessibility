package com.wilsonzhou.accessibility

import android.view.accessibility.AccessibilityEvent

internal interface EventProcessor {
    fun init(newTask : Boolean)
    fun process(event: AccessibilityEvent)
    fun isReady() : Boolean
    fun destroy()
}
