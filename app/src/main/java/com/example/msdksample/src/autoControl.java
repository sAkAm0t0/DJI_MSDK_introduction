package com.example.msdksample.src;

import com.example.msdksample.dji.*;

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
        stick.setLeftStick(0, 10);

        try {
            wait(5000);
        } catch (Exception e) {

        }

        stick.setLeftStick(0, 0);
    }
}
