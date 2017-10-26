package com.wilsonzhou.accessibility

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.FrameLayout

class FullScreenLayout(private val mContext: Context) : FrameLayout(mContext) {
    private var mWindowManger: WindowManager? = null
    private var mView: View? = null

    internal fun init() {
        mWindowManger = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mView = LayoutInflater.from(mContext).inflate(R.layout.full_screen, null)
        mView!!.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            Log.i("FullScreenLayout", "Cancel Clicked")
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(Intent("destroy_view"))
        }
        addView(mView)

        mWindowManger!!.addView(this, windowLayoutParams)
    }

    private val windowLayoutParams: WindowManager.LayoutParams
        get() {
            val params = WindowManager.LayoutParams(
                    WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                    or WindowManager.LayoutParams.FLAG_FULLSCREEN
                    or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    PixelFormat.TRANSLUCENT)
            params.gravity = Gravity.TOP or Gravity.START
            return params
        }

    internal fun destroy() {
        mWindowManger!!.removeView(this)
    }
}
