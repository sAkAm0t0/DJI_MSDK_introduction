package com.example.msdksample.dji;

import android.util.Log;
import androidx.annotation.NonNull;
import dji.sdk.keyvalue.key.FlightControllerKey;
import dji.sdk.keyvalue.key.KeyTools;
import dji.v5.common.callback.CommonCallbacks;
import dji.v5.common.error.IDJIError;
import dji.v5.manager.KeyManager;
import dji.sdk.keyvalue.value.common.EmptyMsg;

public class Key {

    public void startTakeoff() {
        KeyManager.getInstance().performAction(KeyTools.createKey(FlightControllerKey.KeyStartTakeoff), new CommonCallbacks.CompletionCallbackWithParam<EmptyMsg>() {
            @Override
            public void onSuccess(EmptyMsg emptyMsg) {
                Log.i("key", "takeoffSucceeded");
            }

            @Override
            public void onFailure(@NonNull IDJIError idjiError) {
                Log.i("key", "takeoffFailed");
            }
        });
    }

    public void startLanding() {
        KeyManager.getInstance().performAction(KeyTools.createKey(FlightControllerKey.KeyStartAutoLanding), new CommonCallbacks.CompletionCallbackWithParam<EmptyMsg>() {
            @Override
            public void onSuccess(EmptyMsg emptyMsg) {
                Log.i("key", "landingSucceeded");
            }

            @Override
            public void onFailure(@NonNull IDJIError idjiError) {
                Log.i("key", "landingFailed");
            }
        });
    }
}
