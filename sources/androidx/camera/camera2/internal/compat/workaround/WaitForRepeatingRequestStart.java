package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class WaitForRepeatingRequestStart {
    private final boolean mHasCaptureSessionStuckQuirk;
    private boolean mHasSubmittedRepeating;
    CallbackToFutureAdapter.Completer<Void> mStartStreamingCompleter;
    private final ListenableFuture<Void> mStartStreamingFuture;
    private final Object mLock = new Object();
    private final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.mStartStreamingCompleter;
            if (completer != null) {
                completer.set(null);
                WaitForRepeatingRequestStart.this.mStartStreamingCompleter = null;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.mStartStreamingCompleter;
            if (completer != null) {
                completer.setCancelled();
                WaitForRepeatingRequestStart.this.mStartStreamingCompleter = null;
            }
        }
    };

    @FunctionalInterface
    public interface OpenCaptureSession {
        ListenableFuture<Void> run(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List<DeferrableSurface> list);
    }

    @FunctionalInterface
    public interface SingleRepeatingRequest {
        int run(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    public WaitForRepeatingRequestStart(Quirks quirks) {
        this.mHasCaptureSessionStuckQuirk = quirks.contains(CaptureSessionStuckQuirk.class);
        if (shouldWaitRepeatingSubmit()) {
            this.mStartStreamingFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart$$ExternalSyntheticLambda1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.lambda$new$0(completer);
                }
            });
        } else {
            this.mStartStreamingFuture = Futures.immediateFuture(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mStartStreamingCompleter = completer;
        return "WaitForRepeatingRequestStart[" + this + "]";
    }

    public boolean shouldWaitRepeatingSubmit() {
        return this.mHasCaptureSessionStuckQuirk;
    }

    public ListenableFuture<Void> getStartStreamFuture() {
        return Futures.nonCancellationPropagating(this.mStartStreamingFuture);
    }

    public ListenableFuture<Void> openCaptureSession(final CameraDevice cameraDevice, final SessionConfigurationCompat sessionConfigurationCompat, final List<DeferrableSurface> list, List<SynchronizedCaptureSession> list2, final OpenCaptureSession openCaptureSession) {
        ArrayList arrayList = new ArrayList();
        Iterator<SynchronizedCaptureSession> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getOpeningBlocker());
        }
        return FutureChain.from(Futures.successfulAsList(arrayList)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return WaitForRepeatingRequestStart.lambda$openCaptureSession$1(openCaptureSession, cameraDevice, sessionConfigurationCompat, list, (List) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ListenableFuture lambda$openCaptureSession$1(OpenCaptureSession openCaptureSession, CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list, List list2) throws Exception {
        return openCaptureSession.run(cameraDevice, sessionConfigurationCompat, list);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, SingleRepeatingRequest singleRepeatingRequest) throws CameraAccessException {
        int iRun;
        synchronized (this.mLock) {
            try {
                if (shouldWaitRepeatingSubmit()) {
                    captureCallback = Camera2CaptureCallbacks.createComboCallback(this.mCaptureCallback, captureCallback);
                    this.mHasSubmittedRepeating = true;
                }
                iRun = singleRepeatingRequest.run(captureRequest, captureCallback);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iRun;
    }

    public void onSessionEnd() {
        synchronized (this.mLock) {
            try {
                if (shouldWaitRepeatingSubmit() && !this.mHasSubmittedRepeating) {
                    this.mStartStreamingFuture.cancel(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
