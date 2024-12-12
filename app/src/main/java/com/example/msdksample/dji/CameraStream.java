package com.example.msdksample.dji;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import dji.sdk.keyvalue.value.common.ComponentIndexType;
import dji.v5.manager.datacenter.MediaDataCenter;
import dji.v5.manager.interfaces.ICameraStreamManager.AvailableCameraUpdatedListener;

public class CameraStream implements AvailableCameraUpdatedListener {
    private MutableLiveData<List<ComponentIndexType>> _availableCameraListData = new MutableLiveData<List<ComponentIndexType>>(new ArrayList<ComponentIndexType>());

    public void CameraStream() {
        MediaDataCenter.getInstance().getCameraStreamManager().addAvailableCameraUpdatedListener(this);
    }

    public void onCleared() {
        MediaDataCenter.getInstance().getCameraStreamManager().removeAvailableCameraUpdatedListener(this);
    }

    public void onAvailableCameraUpdated(List<ComponentIndexType> availableCameraList) {
        _availableCameraListData.postValue(availableCameraList);
    }
}
