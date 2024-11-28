package com.example.msdksample.dji;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import dji.sdk.keyvalue.key.KeyTools;
import dji.sdk.keyvalue.key.RadarKey;
import dji.v5.common.callback.CommonCallbacks;
import dji.v5.manager.KeyManager;
import dji.v5.manager.aircraft.perception.radar.RadarInformationListener;
import dji.v5.manager.interfaces.IPerceptionManager;
import dji.v5.manager.aircraft.perception.listener.*;
import dji.v5.manager.aircraft.perception.PerceptionManager;
import dji.v5.manager.aircraft.perception.data.PerceptionInfo;
import dji.v5.manager.aircraft.perception.data.ObstacleData;
import dji.v5.manager.aircraft.perception.data.PerceptionDirection;
import dji.v5.manager.aircraft.perception.data.ObstacleAvoidanceType;
import dji.v5.manager.aircraft.perception.radar.RadarInformation;

public class Perception {
    private IPerceptionManager perceptionManger = PerceptionManager.getInstance();
    ;
    MutableLiveData<PerceptionInfo> perceptionInfo = new MutableLiveData<PerceptionInfo>();
    MutableLiveData<RadarInformation> radarInformation = new MutableLiveData<RadarInformation>();
    MutableLiveData<ObstacleData> obstacleData = new MutableLiveData<ObstacleData>();
    MutableLiveData<ObstacleData> obstacleDataForRadar = new MutableLiveData<ObstacleData>();
    MutableLiveData<Boolean> radarConnect = new MutableLiveData<Boolean>();

    public void addPerceptionInfoListener() {
        this.perceptionManger.addPerceptionInformationListener(
                new PerceptionInformationListener() {
                    @Override
                    public void onUpdate(@NonNull PerceptionInfo information) {
                        perceptionInfo.postValue(information);
                    }
                }
        );

        this.perceptionManger.addObstacleDataListener(
                new ObstacleDataListener() {
                    @Override
                    public void onUpdate(ObstacleData data) {
                        obstacleData.postValue(data);
                    }
                }
        );

        this.perceptionManger.getRadarManager().addObstacleDataListener(
                new ObstacleDataListener() {
                    @Override
                    public void onUpdate(ObstacleData data) {
                        obstacleDataForRadar.postValue(data);
                    }
                }
        );

        this.perceptionManger.getRadarManager().addRadarInformationListener(
                new RadarInformationListener() {
                    @Override
                    public void onUpdate(RadarInformation information) {
                        radarInformation.postValue(information);
                    }
                }
        );

        KeyManager.getInstance().listen(
                KeyTools.createKey(
                        RadarKey.KeyConnection
                ),
                this,
                (__, newValue) -> {
                    if(newValue == null) {
                        radarConnect.postValue(false);
                    } else {
                        radarConnect.postValue(true);
                    }
                }
        );
    }

    public void onCleared() {
        KeyManager.getInstance().cancelListen(this);
    }

    public void setObstacleAvoidanceEnabled(boolean isEnable, PerceptionDirection direction, CommonCallbacks.CompletionCallback callback) {
        perceptionManger.setObstacleAvoidanceEnabled(isEnable, direction, callback);
    }

    public void setRadarObstacleAvoidanceEnabled(boolean isEnabled, PerceptionDirection direction, CommonCallbacks.CompletionCallback callback) {
        perceptionManger.getRadarManager().setObstacleAvoidanceEnabled(isEnabled, direction, callback);
    }

    public void  setObstacleAvoidanceType(ObstacleAvoidanceType type, CommonCallbacks.CompletionCallback callback) {
        perceptionManger.setObstacleAvoidanceType(type, callback);
    }

    public void setObstacleAvoidanceWarningDistance(double distance, PerceptionDirection direction, CommonCallbacks.CompletionCallback callback) {
        perceptionManger.setObstacleAvoidanceWarningDistance(distance, direction, callback);
    }

    public void setObstacleAvoidanceBrakingDistance(double distance, PerceptionDirection direction, CommonCallbacks.CompletionCallback callback) {
        perceptionManger. setObstacleAvoidanceBrakingDistance(distance, direction, callback);
    }

    public void setVisionPositioningEnabled(boolean isEnabled, CommonCallbacks.CompletionCallback callback) {
        perceptionManger.setVisionPositioningEnabled(isEnabled, callback);
    }

    public void setPrecisionLandingEnabled(boolean isEnabled, CommonCallbacks.CompletionCallback callback) {
        perceptionManger.setPrecisionLandingEnabled(isEnabled, callback);
    }
}
