package ru.roadar.facerecog;

import android.content.Context;
import android.util.Log;
import org.opencv.core.Mat;

/* loaded from: classes4.dex */
public class FaceProcessNative {
    public static ProcessState[] states = {ProcessState.None, ProcessState.Portrait, ProcessState.Left, ProcessState.Right, ProcessState.Done, ProcessState.Error};
    private long _nativePtr;

    public enum ProcessState {
        None,
        Portrait,
        Left,
        Right,
        Done,
        Error
    }

    private static native FaceData nGetEmbeddings(long j);

    private static native int nGetState(long j);

    private static native long nInit(String str, String str2, String str3);

    private static native boolean nProcessFrame(long j, long j2, int i);

    private static native void nRelease(long j);

    private static native void nStart(long j);

    private long getPtr() {
        long j = this._nativePtr;
        if (j != 0) {
            return j;
        }
        throw new IllegalStateException("Native FaceProcess doesn't exist!");
    }

    public FaceProcessNative(Context context) {
        this._nativePtr = 0L;
        AssetUtils assetUtils = AssetUtils.INSTANCE;
        long jNInit = nInit(assetUtils.copy2Cache(context, "face_detect_sim_264.mnn").getPath(), assetUtils.copy2Cache(context, "priors_264.json").getPath(), assetUtils.copy2Cache(context, "face_recognize_sim.mnn").getPath());
        this._nativePtr = jNInit;
        if (jNInit == 0) {
            throw new RuntimeException("Failed to create native FaceProcess");
        }
        nStart(getPtr());
    }

    public ProcessState getState() {
        return states[nGetState(getPtr())];
    }

    public boolean processFrame(Mat mat, int i) {
        return nProcessFrame(getPtr(), mat.getNativeObjAddr(), i);
    }

    public FaceData getEmbeddings() {
        nGetEmbeddings(getPtr());
        return null;
    }

    public void reset() {
        nStart(getPtr());
    }

    public boolean isReleased() {
        return this._nativePtr == 0;
    }

    static {
        System.loadLibrary("MNN");
        try {
            System.loadLibrary("MNN_CL");
            System.loadLibrary("MNN_GL");
            System.loadLibrary("MNN_Vulkan");
        } catch (Throwable th) {
            Log.w("FaceProcessNative", "load MNN GPU libs exception=%s", th);
        }
        System.loadLibrary("opencv_java4");
        System.loadLibrary("facerecog");
    }
}
