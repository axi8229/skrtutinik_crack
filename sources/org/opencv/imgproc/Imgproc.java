package org.opencv.imgproc;

import org.opencv.core.Mat;

/* loaded from: classes4.dex */
public class Imgproc {
    private static native void cvtColorTwoPlane_0(long j, long j2, long j3, int i);

    private static native void cvtColor_0(long j, long j2, int i, int i2);

    private static native void cvtColor_1(long j, long j2, int i);

    public static void cvtColor(Mat mat, Mat mat2, int i) {
        cvtColor_1(mat.nativeObj, mat2.nativeObj, i);
    }
}
