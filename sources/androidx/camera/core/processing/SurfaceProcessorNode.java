package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class SurfaceProcessorNode {
    final CameraInternal mCameraInternal;
    private In mInput;
    private Out mOutput;
    final SurfaceProcessorInternal mSurfaceProcessor;

    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
    }

    public SurfaceProcessorNode(CameraInternal cameraInternal, SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    public Out transform(In in) throws ProcessingException {
        Threads.checkMainThread();
        this.mInput = in;
        this.mOutput = new Out();
        SurfaceEdge surfaceEdge = in.getSurfaceEdge();
        for (OutConfig outConfig : in.getOutConfigs()) {
            this.mOutput.put(outConfig, transformSingleOutput(surfaceEdge, outConfig));
        }
        sendSurfaceRequest(surfaceEdge, this.mOutput);
        sendSurfaceOutputs(surfaceEdge, this.mOutput);
        return this.mOutput;
    }

    private SurfaceEdge transformSingleOutput(SurfaceEdge surfaceEdge, OutConfig outConfig) {
        Rect cropRect = outConfig.getCropRect();
        int rotationDegrees = outConfig.getRotationDegrees();
        boolean mirroring = outConfig.getMirroring();
        Matrix matrix = new Matrix(surfaceEdge.getSensorToBufferTransform());
        matrix.postConcat(TransformUtils.getRectToRect(new RectF(cropRect), TransformUtils.sizeToRectF(outConfig.getSize()), rotationDegrees, mirroring));
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(cropRect, rotationDegrees), outConfig.getSize()));
        return new SurfaceEdge(outConfig.getTargets(), outConfig.getFormat(), surfaceEdge.getStreamSpec().toBuilder().setResolution(outConfig.getSize()).build(), matrix, false, TransformUtils.sizeToRect(outConfig.getSize()), surfaceEdge.getRotationDegrees() - rotationDegrees, -1, surfaceEdge.getMirroring() != mirroring);
    }

    private void sendSurfaceRequest(SurfaceEdge surfaceEdge, Map<OutConfig, SurfaceEdge> map) throws ProcessingException {
        SurfaceRequest surfaceRequestCreateSurfaceRequest = surfaceEdge.createSurfaceRequest(this.mCameraInternal);
        setUpRotationUpdates(surfaceRequestCreateSurfaceRequest, map);
        this.mSurfaceProcessor.onInputSurface(surfaceRequestCreateSurfaceRequest);
    }

    private void sendSurfaceOutputs(final SurfaceEdge surfaceEdge, Map<OutConfig, SurfaceEdge> map) {
        for (final Map.Entry<OutConfig, SurfaceEdge> entry : map.entrySet()) {
            lambda$sendSurfaceOutputs$0(surfaceEdge, entry);
            entry.getValue().addOnInvalidatedListener(new Runnable() { // from class: androidx.camera.core.processing.SurfaceProcessorNode$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendSurfaceOutputs$0(surfaceEdge, entry);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createAndSendSurfaceOutput, reason: merged with bridge method [inline-methods] */
    public void lambda$sendSurfaceOutputs$0(SurfaceEdge surfaceEdge, Map.Entry<OutConfig, SurfaceEdge> entry) {
        Futures.addCallback(entry.getValue().createSurfaceOutputFuture(surfaceEdge.getStreamSpec().getResolution(), entry.getKey().getFormat(), entry.getKey().getCropRect(), entry.getKey().getRotationDegrees(), entry.getKey().getMirroring(), surfaceEdge.hasCameraTransform() ? this.mCameraInternal : null), new FutureCallback<SurfaceOutput>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(SurfaceOutput surfaceOutput) throws ProcessingException {
                Preconditions.checkNotNull(surfaceOutput);
                SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Logger.w("SurfaceProcessorNode", "Downstream node failed to provide Surface.", th);
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    void setUpRotationUpdates(SurfaceRequest surfaceRequest, final Map<OutConfig, SurfaceEdge> map) {
        surfaceRequest.setTransformationInfoListener(CameraXExecutors.mainThreadExecutor(), new SurfaceRequest.TransformationInfoListener() { // from class: androidx.camera.core.processing.SurfaceProcessorNode$$ExternalSyntheticLambda2
            @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
            public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
                SurfaceProcessorNode.lambda$setUpRotationUpdates$1(map, transformationInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUpRotationUpdates$1(Map map, SurfaceRequest.TransformationInfo transformationInfo) {
        for (Map.Entry entry : map.entrySet()) {
            int rotationDegrees = transformationInfo.getRotationDegrees() - ((OutConfig) entry.getKey()).getRotationDegrees();
            if (((OutConfig) entry.getKey()).getMirroring()) {
                rotationDegrees = -rotationDegrees;
            }
            ((SurfaceEdge) entry.getValue()).updateTransformation(TransformUtils.within360(rotationDegrees), -1);
        }
    }

    public void release() {
        this.mSurfaceProcessor.release();
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.processing.SurfaceProcessorNode$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$release$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2() {
        Out out = this.mOutput;
        if (out != null) {
            Iterator<SurfaceEdge> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public static abstract class In {
        public abstract List<OutConfig> getOutConfigs();

        public abstract SurfaceEdge getSurfaceEdge();

        public static In of(SurfaceEdge surfaceEdge, List<OutConfig> list) {
            return new AutoValue_SurfaceProcessorNode_In(surfaceEdge, list);
        }
    }

    public static abstract class OutConfig {
        public abstract Rect getCropRect();

        public abstract int getFormat();

        public abstract boolean getMirroring();

        public abstract int getRotationDegrees();

        public abstract Size getSize();

        public abstract int getTargets();

        abstract UUID getUuid();

        public static OutConfig of(SurfaceEdge surfaceEdge) {
            return of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), surfaceEdge.getRotationDegrees()), surfaceEdge.getRotationDegrees(), surfaceEdge.getMirroring());
        }

        public static OutConfig of(int i, int i2, Rect rect, Size size, int i3, boolean z) {
            return new AutoValue_SurfaceProcessorNode_OutConfig(UUID.randomUUID(), i, i2, rect, size, i3, z);
        }
    }
}
