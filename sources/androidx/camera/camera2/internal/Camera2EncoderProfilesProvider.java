package androidx.camera.camera2.internal;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Camera2EncoderProfilesProvider implements EncoderProfilesProvider {
    private final String mCameraId;
    private final Map<Integer, Object> mEncoderProfilesCache = new HashMap();
    private final boolean mHasValidCameraId;
    private final int mIntCameraId;

    public Camera2EncoderProfilesProvider(String str) throws NumberFormatException {
        boolean z;
        int i;
        this.mCameraId = str;
        try {
            i = Integer.parseInt(str);
            z = true;
        } catch (NumberFormatException unused) {
            Logger.w("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
            z = false;
            i = -1;
        }
        this.mHasValidCameraId = z;
        this.mIntCameraId = i;
    }
}
