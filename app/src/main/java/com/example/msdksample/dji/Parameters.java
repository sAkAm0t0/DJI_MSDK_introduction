package com.example.msdksample.dji;

import androidx.lifecycle.MutableLiveData;

import dji.sdk.keyvalue.converter.DJIValueConverter;
import dji.sdk.keyvalue.key.FlightControllerKey;
import dji.sdk.keyvalue.key.DJIKeyInfo;
import dji.sdk.keyvalue.value.common.Velocity3D;

public class Parameters {
    //MutableLiveData<DJIKeyInfo<Velocity3D>> KeyAircraftVelocity = new DJIKeyInfo<>(componentType.value(), subComponentType.value(),"AircraftVelocity", new DJIValueConverter<>(Velocity3D.class)).canGet(true).canSet(false).canListen(true).canPerformAction(false).setIsEvent(false).setInnerIdentifier("Velocity");
}
