package org.pjsip;

import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes4.dex */
public class PjCamera implements Camera.PreviewCallback, SurfaceHolder.Callback {
    private Camera camera;
    private boolean isRunning;
    private long userData;

    native void PushFrame(byte[] bArr, int i, long j);

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.isRunning) {
            PushFrame(bArr, bArr.length, this.userData);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.d("PjCamera", "VideoCaptureAndroid::surfaceChanged");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        Log.d("PjCamera", "VideoCaptureAndroid::surfaceCreated");
        try {
            Camera camera = this.camera;
            if (camera != null) {
                camera.setPreviewDisplay(surfaceHolder);
            }
        } catch (IOException e) {
            Log.e("PjCamera", "Failed to set preview surface!", e);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) throws IOException {
        Log.d("PjCamera", "VideoCaptureAndroid::surfaceDestroyed");
        try {
            Camera camera = this.camera;
            if (camera != null) {
                camera.setPreviewDisplay(null);
            }
        } catch (IOException e) {
            Log.e("PjCamera", "Failed to clear preview surface!", e);
        } catch (RuntimeException e2) {
            Log.w("PjCamera", "Clear preview surface useless", e2);
        }
    }
}
