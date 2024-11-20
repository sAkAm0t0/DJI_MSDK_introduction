package com.example.msdksample.src;

import com.example.msdksample.dji.*;

public class autoControl {
    private key key;
    private virtualStick stick;
    public autoControl() {
        key = new key();
        stick = new virtualStick();
    }

    public void init() {
        key.startTakeoff();

        try {
            wait(5000);
        } catch (Exception e) {

        }

        stick.setLeftStick(10, 0);

        try {
            wait(5000);
        } catch (Exception e) {

        }

        key.startLanding();
        stick.destroy();
    }
}
