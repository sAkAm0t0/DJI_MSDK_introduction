package com.example.msdksample.dji;

import androidx.annotation.NonNull;

import dji.sdk.keyvalue.key.RemoteControllerKey;
import dji.sdk.keyvalue.value.flightcontroller.*;
import dji.sdk.keyvalue.value.flightcontroller.FlightControlAuthorityChangeReason;
import dji.v5.common.callback.CommonCallbacks.CompletionCallback;
import dji.v5.manager.aircraft.virtualstick.IStick;
import dji.v5.manager.aircraft.virtualstick.VirtualStickManager;
import dji.v5.manager.aircraft.virtualstick.VirtualStickState;
import dji.v5.manager.aircraft.virtualstick.VirtualStickStateListener;

public class VirtualStick {
    private double currentSpeedLevel;
    private int currentRightVerticalPosition = 0;
    private int currentRightHorizontalPosition = 0;
    private int currentLeftVerticalPosition = 0;
    private int currentLeftHorizontalPosition = 0;
    private CompletionCallback callback;
    private VirtualStickStateListener listener = new VirtualStickStateListener() {
        @Override
        public void onVirtualStickStateUpdate(@NonNull VirtualStickState stickState) {

        }

        @Override
        public void onChangeReasonUpdate(@NonNull FlightControlAuthorityChangeReason reason) {

        }
    };
    private VirtualStickState state = new VirtualStickState(true, null, false);
    private FlightControlAuthorityChangeReason reason;

    public VirtualStick() {
        VirtualStickManager.getInstance().setVirtualStickStateListener(this.listener);
        this.listener.onVirtualStickStateUpdate(this.state);
        this.listener.onChangeReasonUpdate(this.reason);


        this.currentSpeedLevel = VirtualStickManager.getInstance().getSpeedLevel();
    }

    public void destroy() {
        this.disableVirtualStick(this.callback);
        this.clearAllVirtualStickStateListener();
    }

    public void enableVirtualStick(CompletionCallback callback) {
        VirtualStickManager.getInstance().enableVirtualStick(callback);
    }

    public void disableVirtualStick(CompletionCallback callback) {
        VirtualStickManager.getInstance().disableVirtualStick(callback);
    }

    private void clearAllVirtualStickStateListener() {
        VirtualStickManager.getInstance().clearAllVirtualStickStateListener();
    }

    public void setSpeedLevel(double speedLevel) {
        VirtualStickManager.getInstance().setSpeedLevel(speedLevel);
        this.currentSpeedLevel = speedLevel;
    }

    public void setRightStick(int vertical, int horizontal) {
        this.currentRightVerticalPosition = vertical;       // range is [-660, 660]
        this.currentRightHorizontalPosition = horizontal;   // range is [-660, 660]

        VirtualStickManager.getInstance().getRightStick().setVerticalPosition(vertical);
        VirtualStickManager.getInstance().getRightStick().setHorizontalPosition(horizontal);
    }

    public void setLeftStick(int vertical, int horizontal) {
        this.currentLeftVerticalPosition = vertical;        // range is [-660, 660]
        this.currentLeftHorizontalPosition = horizontal;    // range is [-660, 660]

        VirtualStickManager.getInstance().getLeftStick().setVerticalPosition(vertical);
        VirtualStickManager.getInstance().getLeftStick().setHorizontalPosition(horizontal);
    }
}
