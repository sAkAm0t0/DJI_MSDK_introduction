package com.example.msdksample

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import dji.v5.common.error.IDJIError
import dji.v5.common.register.DJISDKInitEvent
import dji.v5.manager.SDKManager
import dji.v5.manager.interfaces.SDKManagerCallback

class MyApplication : Application() {

    private val TAG = this::class.simpleName

    val lvRegisterState = MutableLiveData<Pair<Boolean, IDJIError?>>()
    val lvProductConnectionState = MutableLiveData<Pair<Boolean, Int>>()
    val lvProductChanges = MutableLiveData<Int>()
    val lvInitProcess = MutableLiveData<Pair<DJISDKInitEvent, Int>>()
    val lvDBDownloadProgress = MutableLiveData<Pair<Long, Long>>()

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        //Before calling "install", don't call any MSDK related interfaces
        //For versions before MSDK v5.10.0, use com.secneo.sdk.Helper.install(this)
        com.cySdkyc.clx.Helper.install(this)

    }

    override fun onCreate() {
        super.onCreate()

        // Initialize MSDK
        SDKManager.getInstance().init(this,object:SDKManagerCallback{
            override fun onInitProcess(event: DJISDKInitEvent?, totalProcess: Int) {
                Log.i(TAG, "onInitProcess: ")
                if (event == DJISDKInitEvent.INITIALIZE_COMPLETE) {
                    SDKManager.getInstance().registerApp()
                }
            }
            override fun onRegisterSuccess() {
                Log.i(TAG, "onRegisterSuccess: ")
            }
            override fun onRegisterFailure(error: IDJIError?) {
                Log.i(TAG, "onRegisterFailure: ")
            }
            override fun onProductConnect(productId: Int) {
                Log.i(TAG, "onProductConnect: ")
            }
            override fun onProductDisconnect(productId: Int) {
                Log.i(TAG, "onProductDisconnect: ")
            }
            override fun onProductChanged(productId: Int)
            {
                Log.i(TAG, "onProductChanged: ")
            }
            override fun onDatabaseDownloadProgress(current: Long, total: Long) {
                Log.i(TAG, "onDatabaseDownloadProgress: ${current/total}")
            }
        })
    }
}