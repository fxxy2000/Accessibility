package com.wilsonzhou.accessibility

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v4.content.LocalBroadcastManager

import kotlinx.android.synthetic.main.activity_main.*
import android.net.Uri
import android.os.Build
import android.widget.CompoundButton

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.action_turn_on_stay_awake.setOnClickListener {
            val intent = Intent("action_start")
            intent.putExtra("processorName", "TurnOnStayAwake")
            LocalBroadcastManager.getInstance(this@MainActivity).sendBroadcast(intent)
        }

        this.action_auto_uninstall_app.setOnClickListener {
            val intent = Intent("action_start")
            intent.putExtra("processorName", "UninstallApplication")
            LocalBroadcastManager.getInstance(this@MainActivity).sendBroadcast(intent)
        }

        this.action_block.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            val intent = Intent("action_block")
            intent.putExtra("isBlocked", b)
            LocalBroadcastManager.getInstance(this@MainActivity).sendBroadcast(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            resetButtonState(Settings.canDrawOverlays(this))
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + packageName))
                // request permission via start activity for result
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // check if received result code
        // is equal our requested code for draw permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (requestCode == REQUEST_CODE) {
                // if so check once again if we have permission
                resetButtonState(Settings.canDrawOverlays(this))
            }
        }
    }

    private fun resetButtonState(isEnabled: Boolean) {
        this.action_turn_on_stay_awake.isEnabled = isEnabled
        this.action_auto_uninstall_app.isEnabled = isEnabled
        this.action_block.isEnabled = isEnabled
    }

    companion object {
        val REQUEST_CODE = 110
    }
}
