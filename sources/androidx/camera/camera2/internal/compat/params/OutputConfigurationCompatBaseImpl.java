package androidx.camera.camera2.internal.compat.params;

import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
class OutputConfigurationCompatBaseImpl implements OutputConfigurationCompat.OutputConfigurationCompatImpl {
    final Object mObject;

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setStreamUseCase(long j) {
    }

    OutputConfigurationCompatBaseImpl(Object obj) {
        this.mObject = obj;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi21) this.mObject).mIsShared = true;
    }

    boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi21) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String str) {
        ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId = str;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void addSurface(Surface surface) {
        Preconditions.checkNotNull(surface, "Surface must not be null");
        if (getSurface() == surface) {
            throw new IllegalStateException("Surface is already added!");
        }
        if (!isSurfaceSharingEnabled()) {
            throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
        }
        throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile = j;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Surface getSurface() {
        List<Surface> list = ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean equals(Object obj) {
        if (obj instanceof OutputConfigurationCompatBaseImpl) {
            return Objects.equals(this.mObject, ((OutputConfigurationCompatBaseImpl) obj).mObject);
        }
        return false;
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    private static final class OutputConfigurationParamsApi21 {
        final int mConfiguredFormat;
        final int mConfiguredGenerationId;
        final Size mConfiguredSize;
        long mDynamicRangeProfile;
        boolean mIsShared;
        String mPhysicalCameraId;
        final List<Surface> mSurfaces;

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi21)) {
                return false;
            }
            OutputConfigurationParamsApi21 outputConfigurationParamsApi21 = (OutputConfigurationParamsApi21) obj;
            if (!this.mConfiguredSize.equals(outputConfigurationParamsApi21.mConfiguredSize) || this.mConfiguredFormat != outputConfigurationParamsApi21.mConfiguredFormat || this.mConfiguredGenerationId != outputConfigurationParamsApi21.mConfiguredGenerationId || this.mIsShared != outputConfigurationParamsApi21.mIsShared || this.mDynamicRangeProfile != outputConfigurationParamsApi21.mDynamicRangeProfile || !Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi21.mPhysicalCameraId)) {
                return false;
            }
            int iMin = Math.min(this.mSurfaces.size(), outputConfigurationParamsApi21.mSurfaces.size());
            for (int i = 0; i < iMin; i++) {
                if (this.mSurfaces.get(i) != outputConfigurationParamsApi21.mSurfaces.get(i)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int iHashCode = this.mSurfaces.hashCode() ^ 31;
            int i = this.mConfiguredGenerationId ^ ((iHashCode << 5) - iHashCode);
            int iHashCode2 = this.mConfiguredSize.hashCode() ^ ((i << 5) - i);
            int i2 = this.mConfiguredFormat ^ ((iHashCode2 << 5) - iHashCode2);
            int i3 = (this.mIsShared ? 1 : 0) ^ ((i2 << 5) - i2);
            int i4 = (i3 << 5) - i3;
            String str = this.mPhysicalCameraId;
            int iHashCode3 = (str == null ? 0 : str.hashCode()) ^ i4;
            return Long.hashCode(this.mDynamicRangeProfile) ^ ((iHashCode3 << 5) - iHashCode3);
        }
    }
}
