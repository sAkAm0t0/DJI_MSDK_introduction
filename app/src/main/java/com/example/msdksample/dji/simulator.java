package com.example.msdksample.dji;

import dji.sdk.keyvalue.value.common.LocationCoordinate2D;
import dji.v5.common.callback.CommonCallbacks;
import dji.v5.manager.aircraft.simulator.InitializationSettings;
import dji.v5.manager.aircraft.simulator.SimulatorManager;
import dji.v5.manager.aircraft.simulator.SimulatorStatusListener;

public class Simulator {
    private CommonCallbacks.CompletionCallback callback;
    private SimulatorStatusListener listener;
    public void init() {
        if(!SimulatorManager.getInstance().isSimulatorEnabled()) {
            LocationCoordinate2D coordinate2D = new LocationCoordinate2D(0., 0.);
            InitializationSettings data = InitializationSettings.createInstance(coordinate2D, 1);
            SimulatorManager.getInstance().enableSimulator(data, this.callback);
        }

        SimulatorManager.getInstance().addSimulatorStateListener(this.listener);
    }

    public void destroy(){
        SimulatorManager.getInstance().clearAllSimulatorStateListener();
        SimulatorManager.getInstance().disableSimulator(callback);
    }
}
