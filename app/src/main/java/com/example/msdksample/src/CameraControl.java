package com.example.msdksample.src;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.msdksample.R;
import com.example.msdksample.dji.CameraStream;
import com.example.msdksample.utils.DJIFragment;
import dji.sdk.keyvalue.value.common.ComponentIndexType;
import java.util.List;


public class CameraControl extends DJIFragment {
        private LinearLayout llCameraList;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                return inflater.inflate(R.layout.frag_camera_stream_list, container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                llCameraList = view.findViewById(R.id.ll_camera_preview_list);

        }

        private void updateAvailableCamera(List<ComponentIndexType> availableCameraList) {
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                List<Fragment> fragmentList = getChildFragmentManager().getFragments();
                for(Fragment fragment: fragmentList) {
                        ft.remove(fragment);
                }
                ft.commitAllowingStateLoss();
                llCameraList.removeAllViews();
                ft = getChildFragmentManager().beginTransaction();
                boolean onlyOneCamera = availableCameraList.size() == 1;
                for(ComponentIndexType cameraIndex: availableCameraList) {
                        FrameLayout frameLayout = new FrameLayout(llCameraList.getContext());
                        frameLayout.setId(View.generateViewId());
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
                        llCameraList.addView(frameLayout, lp);
                        ft.replace(frameLayout.getId(), CameraStreamDetailFragment);
                }
        }
}
