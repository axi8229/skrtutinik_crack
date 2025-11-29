package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class StreamConfigurationMapCompat {
    private final StreamConfigurationMapCompatImpl mImpl;
    private final OutputSizesCorrector mOutputSizesCorrector;
    private final Map<Integer, Size[]> mCachedFormatOutputSizes = new HashMap();
    private final Map<Integer, Size[]> mCachedFormatHighResolutionOutputSizes = new HashMap();
    private final Map<Class<?>, Size[]> mCachedClassOutputSizes = new HashMap();

    interface StreamConfigurationMapCompatImpl {
        Size[] getHighResolutionOutputSizes(int i);

        Size[] getOutputSizes(int i);

        StreamConfigurationMap unwrap();
    }

    private StreamConfigurationMapCompat(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        this.mImpl = new StreamConfigurationMapCompatApi23Impl(streamConfigurationMap);
        this.mOutputSizesCorrector = outputSizesCorrector;
    }

    static StreamConfigurationMapCompat toStreamConfigurationMapCompat(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        return new StreamConfigurationMapCompat(streamConfigurationMap, outputSizesCorrector);
    }

    public Size[] getOutputSizes(int i) {
        if (this.mCachedFormatOutputSizes.containsKey(Integer.valueOf(i))) {
            if (this.mCachedFormatOutputSizes.get(Integer.valueOf(i)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(i)).clone();
        }
        Size[] outputSizes = this.mImpl.getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            Logger.w("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
            return outputSizes;
        }
        Size[] sizeArrApplyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, i);
        this.mCachedFormatOutputSizes.put(Integer.valueOf(i), sizeArrApplyQuirks);
        return (Size[]) sizeArrApplyQuirks.clone();
    }

    public Size[] getHighResolutionOutputSizes(int i) {
        if (this.mCachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(i))) {
            if (this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i)).clone();
        }
        Size[] highResolutionOutputSizes = this.mImpl.getHighResolutionOutputSizes(i);
        if (highResolutionOutputSizes != null && highResolutionOutputSizes.length > 0) {
            highResolutionOutputSizes = this.mOutputSizesCorrector.applyQuirks(highResolutionOutputSizes, i);
        }
        this.mCachedFormatHighResolutionOutputSizes.put(Integer.valueOf(i), highResolutionOutputSizes);
        if (highResolutionOutputSizes != null) {
            return (Size[]) highResolutionOutputSizes.clone();
        }
        return null;
    }

    public StreamConfigurationMap toStreamConfigurationMap() {
        return this.mImpl.unwrap();
    }
}
