package com.example.msdksample.src;

import androidx.annotation.NonNull;

import com.example.msdksample.dji.*;
import com.example.msdksample.utils.Notification;
import dji.v5.common.callback.CommonCallbacks.CompletionCallback;
import dji.v5.common.error.IDJIError;

public class autoControl {
    private Key key;
    private VirtualStick stick;
    public autoControl() {
        key = new Key();
        stick = new VirtualStick();
    }

    public void takeoff() {
        key.startTakeoff();
    }

    public void  landing() {
        key.startLanding();
    }

    public void rotating() {
         stick.setLeftStick(0, 100);
    }

    public void stop() {
        stick.setLeftStick(0, 0);
        stick.setRightStick(0, 0);
    }

    public void enableVS() {
        stick.enableVirtualStick(new CompletionCallback() {
            @Override
            public void onSuccess() {
                Notification.showToast("enableVirtualStick succeeded");
            }

            @Override
            public void onFailure(@NonNull IDJIError idjiError) {
                Notification.showToast("enableVirtualStick failed, " + idjiError);
            }
        });
    }
}
