package com.example.msdksample.utils;

import android.os.Handler;
import android.os.Looper;
import android.transition.ChangeBounds;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import dji.v5.utils.common.ContextUtil;
import kotlin.jvm.Synchronized;

public class Notification {
    private static Handler handler = new Handler(Looper.getMainLooper());
    private static WeakReference<Toast> toastRef = null;

    public static void showToast(String msg) {
        showLongToast(msg);
    }

    public static void showLongToast(String msg) {
        showToastSync(msg, Toast.LENGTH_LONG);
    }

    public static void showShortToast(String msg) {
        showToastSync(msg, Toast.LENGTH_SHORT);
    }
    private synchronized static void showToastSync(String msg, int duration) {
        handler.post( new Runnable() {
            @Override
            public void run() {
                if(toastRef != null) {
                    toastRef.get().cancel();
                    toastRef.clear();
                }
                toastRef = null;
                Toast toast = Toast.makeText(ContextUtil.getContext(), msg, duration);
                toastRef = new WeakReference(toast);
                toast.show();
            }
        });
    }
}
