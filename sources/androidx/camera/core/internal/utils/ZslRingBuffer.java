package androidx.camera.core.internal.utils;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;

/* loaded from: classes.dex */
public final class ZslRingBuffer extends ArrayRingBuffer<ImageProxy> {
    public ZslRingBuffer(int i, RingBuffer$OnRemoveCallback<ImageProxy> ringBuffer$OnRemoveCallback) {
        super(i, ringBuffer$OnRemoveCallback);
    }

    public void enqueue(ImageProxy imageProxy) {
        if (isValidZslFrame(imageProxy.getImageInfo())) {
            super.enqueue((ZslRingBuffer) imageProxy);
        } else {
            this.mOnRemoveCallback.onRemove(imageProxy);
        }
    }

    private boolean isValidZslFrame(ImageInfo imageInfo) {
        CameraCaptureResult cameraCaptureResultRetrieveCameraCaptureResult = CameraCaptureResults.retrieveCameraCaptureResult(imageInfo);
        return (cameraCaptureResultRetrieveCameraCaptureResult.getAfState() == CameraCaptureMetaData$AfState.LOCKED_FOCUSED || cameraCaptureResultRetrieveCameraCaptureResult.getAfState() == CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) && cameraCaptureResultRetrieveCameraCaptureResult.getAeState() == CameraCaptureMetaData$AeState.CONVERGED && cameraCaptureResultRetrieveCameraCaptureResult.getAwbState() == CameraCaptureMetaData$AwbState.CONVERGED;
    }
}
