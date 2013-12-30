package com.edinstudio.app.mycamera;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
    public static final String TAG = "mycamera";

    private FrameLayout mFlCameraPreview;
    private Camera mCamera;
    private CameraPreview mCameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlCameraPreview = (FrameLayout) findViewById(R.id.main_fl_camera_preview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mCamera == null) {
            mCamera = getCameraInstance();
        }

        if (mCameraPreview == null) {
            mCameraPreview = new CameraPreview(this, mCamera);
            mFlCameraPreview.addView(mCameraPreview);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }

        if (mCameraPreview != null) {
            mFlCameraPreview.removeView(mCameraPreview);
            mCameraPreview = null;
        }
    }

    public static Camera getCameraInstance() {
        Camera camera = null;
        try {
            camera = Camera.open();
        } catch (Exception e) {

        }
        return camera;
    }

    public void onMainBtnCaptureClick(View view) {
        mCamera.takePicture(null, null, null, new MyPictureCallback());
    }
}


