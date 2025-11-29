package androidx.camera.camera2.internal.concurrent;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class Camera2CameraCoordinator implements CameraCoordinator {
    private final CameraManagerCompat mCameraManager;
    private int mCameraOperatingMode = 0;
    private final Map<String, List<String>> mConcurrentCameraIdMap = new HashMap();
    private Set<Set<String>> mConcurrentCameraIds = new HashSet();
    private final List<CameraCoordinator.ConcurrentCameraModeListener> mConcurrentCameraModeListeners = new ArrayList();
    private List<CameraInfo> mActiveConcurrentCameraInfos = new ArrayList();

    public Camera2CameraCoordinator(CameraManagerCompat cameraManagerCompat) {
        this.mCameraManager = cameraManagerCompat;
        retrieveConcurrentCameraIds();
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public String getPairedConcurrentCameraId(String str) {
        if (!this.mConcurrentCameraIdMap.containsKey(str)) {
            return null;
        }
        for (String str2 : this.mConcurrentCameraIdMap.get(str)) {
            Iterator<CameraInfo> it = this.mActiveConcurrentCameraInfos.iterator();
            while (it.hasNext()) {
                if (str2.equals(Camera2CameraInfo.from(it.next()).getCameraId())) {
                    return str2;
                }
            }
        }
        return null;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public int getCameraOperatingMode() {
        return this.mCameraOperatingMode;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void setCameraOperatingMode(int i) {
        if (i != this.mCameraOperatingMode) {
            Iterator<CameraCoordinator.ConcurrentCameraModeListener> it = this.mConcurrentCameraModeListeners.iterator();
            while (it.hasNext()) {
                it.next().onCameraOperatingModeUpdated(this.mCameraOperatingMode, i);
            }
        }
        if (this.mCameraOperatingMode == 2 && i != 2) {
            this.mActiveConcurrentCameraInfos.clear();
        }
        this.mCameraOperatingMode = i;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void addListener(CameraCoordinator.ConcurrentCameraModeListener concurrentCameraModeListener) {
        this.mConcurrentCameraModeListeners.add(concurrentCameraModeListener);
    }

    private void retrieveConcurrentCameraIds() {
        try {
            this.mConcurrentCameraIds = this.mCameraManager.getConcurrentCameraIds();
        } catch (CameraAccessExceptionCompat unused) {
            Logger.e("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        Iterator<Set<String>> it = this.mConcurrentCameraIds.iterator();
        while (it.hasNext()) {
            ArrayList arrayList = new ArrayList(it.next());
            if (arrayList.size() >= 2) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                if (!this.mConcurrentCameraIdMap.containsKey(str)) {
                    this.mConcurrentCameraIdMap.put(str, new ArrayList());
                }
                if (!this.mConcurrentCameraIdMap.containsKey(str2)) {
                    this.mConcurrentCameraIdMap.put(str2, new ArrayList());
                }
                this.mConcurrentCameraIdMap.get(str).add((String) arrayList.get(1));
                this.mConcurrentCameraIdMap.get(str2).add((String) arrayList.get(0));
            }
        }
    }
}
