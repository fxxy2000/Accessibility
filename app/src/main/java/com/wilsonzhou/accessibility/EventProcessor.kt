package com.wilsonzhou.accessibility

import android.view.accessibility.AccessibilityEvent

internal interface EventProcessor {
    fun init()
    fun process(event: AccessibilityEvent)
}
