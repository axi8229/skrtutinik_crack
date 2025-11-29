package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda2;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
class CaptureNode {
    private In mInputEdge;
    private Out mOutputEdge;
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;
    private final Set<Integer> mPendingStageIds = new HashSet();
    ProcessingRequest mCurrentRequest = null;

    CaptureNode() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Out transform(In in) {
        Consumer<ProcessingRequest> consumer;
        NoMetadataImageReader noMetadataImageReader;
        Preconditions.checkState(this.mInputEdge == null && this.mSafeCloseImageReaderProxy == null, "CaptureNode does not support recreation yet.");
        this.mInputEdge = in;
        Size size = in.getSize();
        int inputFormat = in.getInputFormat();
        if (!in.isVirtualCamera() && in.getImageReaderProxyProvider() == null) {
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), inputFormat, 4);
            in.setCameraCaptureCallback(metadataImageReader.getCameraCaptureCallback());
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.onRequestAvailable((ProcessingRequest) obj);
                }
            };
            noMetadataImageReader = metadataImageReader;
        } else {
            final NoMetadataImageReader noMetadataImageReader2 = new NoMetadataImageReader(createImageReaderProxy(in.getImageReaderProxyProvider(), size.getWidth(), size.getHeight(), inputFormat));
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda1
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$transform$0(noMetadataImageReader2, (ProcessingRequest) obj);
                }
            };
            noMetadataImageReader = noMetadataImageReader2;
        }
        Surface surface = noMetadataImageReader.getSurface();
        Objects.requireNonNull(surface);
        in.setSurface(surface);
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(noMetadataImageReader);
        noMetadataImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda2
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                this.f$0.lambda$transform$1(imageReaderProxy);
            }
        }, CameraXExecutors.mainThreadExecutor());
        in.getRequestEdge().setListener(consumer);
        in.getErrorEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.sendCaptureError((ImageCaptureException) obj);
            }
        });
        Out outOf = Out.of(in.getInputFormat(), in.getOutputFormat());
        this.mOutputEdge = outOf;
        return outOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$0(NoMetadataImageReader noMetadataImageReader, ProcessingRequest processingRequest) {
        onRequestAvailable(processingRequest);
        noMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$1(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                onImageProxyAvailable(imageProxyAcquireLatestImage);
            } else {
                sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", null));
            }
        } catch (IllegalStateException e) {
            sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", e));
        }
    }

    private static ImageReaderProxy createImageReaderProxy(ImageReaderProxyProvider imageReaderProxyProvider, int i, int i2, int i3) {
        if (imageReaderProxyProvider != null) {
            return imageReaderProxyProvider.newInstance(i, i2, i3, 4, 0L);
        }
        return ImageReaderProxys.createIsolatedReader(i, i2, i3, 4);
    }

    void onImageProxyAvailable(ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest == null) {
            Logger.d("CaptureNode", "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
            imageProxy.close();
            return;
        }
        matchAndPropagateImage(imageProxy);
    }

    private void matchAndPropagateImage(ImageProxy imageProxy) {
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        Integer num = (Integer) tag;
        int iIntValue = num.intValue();
        Preconditions.checkState(this.mPendingStageIds.contains(num), "Received an unexpected stage id" + iIntValue);
        this.mPendingStageIds.remove(num);
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getImageEdge().accept(imageProxy);
        if (this.mPendingStageIds.isEmpty()) {
            ProcessingRequest processingRequest = this.mCurrentRequest;
            this.mCurrentRequest = null;
            processingRequest.onImageCaptured();
        }
    }

    void onRequestAvailable(final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        Preconditions.checkState(getCapacity() > 0, "Too many acquire images. Close image to be able to process next.");
        Preconditions.checkState(this.mCurrentRequest == null || this.mPendingStageIds.isEmpty(), "The previous request is not complete");
        this.mCurrentRequest = processingRequest;
        this.mPendingStageIds.addAll(processingRequest.getStageIds());
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getRequestEdge().accept(processingRequest);
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.CaptureNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest2 = processingRequest;
                CaptureNode captureNode = CaptureNode.this;
                if (processingRequest2 == captureNode.mCurrentRequest) {
                    captureNode.mCurrentRequest = null;
                }
            }
        }, CameraXExecutors.directExecutor());
    }

    void sendCaptureError(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null) {
            processingRequest.onCaptureFailure(imageCaptureException);
        }
    }

    public void release() {
        Threads.checkMainThread();
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        releaseInputResources(in, safeCloseImageReaderProxy);
    }

    private void releaseInputResources(In in, SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        in.getSurface().close();
        ListenableFuture<Void> terminationFuture = in.getSurface().getTerminationFuture();
        Objects.requireNonNull(safeCloseImageReaderProxy);
        terminationFuture.addListener(new ZslControlImpl$$ExternalSyntheticLambda2(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
    }

    public int getCapacity() {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.imagecapture.CaptureNode.In.1
        };
        private DeferrableSurface mSurface;

        abstract Edge<ImageCaptureException> getErrorEdge();

        abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        abstract int getInputFormat();

        abstract int getOutputFormat();

        abstract Edge<ProcessingRequest> getRequestEdge();

        abstract Size getSize();

        abstract boolean isVirtualCamera();

        In() {
        }

        DeferrableSurface getSurface() {
            DeferrableSurface deferrableSurface = this.mSurface;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        void setSurface(Surface surface) {
            Preconditions.checkState(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }

        CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        void setCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        static In of(Size size, int i, int i2, boolean z, ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i, i2, z, imageReaderProxyProvider, new Edge(), new Edge());
        }
    }

    static abstract class Out {
        abstract Edge<ImageProxy> getImageEdge();

        abstract int getInputFormat();

        abstract int getOutputFormat();

        abstract Edge<ProcessingRequest> getRequestEdge();

        Out() {
        }

        static Out of(int i, int i2) {
            return new AutoValue_CaptureNode_Out(new Edge(), new Edge(), i, i2);
        }
    }
}
