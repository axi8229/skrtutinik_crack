package com.axmor.axvoip.mojo.pjm.endpoint;

import android.os.SystemClock;
import android.util.Log;
import com.axmor.ash.toolset.utils.Lambda$Code0;
import com.axmor.axvoip.mojo.pjm.common.PjmEndpointConfig;
import com.axmor.axvoip.mojo.pjm.common.PjmStartupException;
import com.axmor.axvoip.mojo.pjm.facade.PjmEndpoint;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class PjmAccessPoint {
    private static final Object[] $LOCK = new Object[0];
    private static EndpointBridge endpoint;

    public static void loadLibraries() {
        System.loadLibrary("openh264");
        System.loadLibrary("yuv");
        System.loadLibrary("pjsua2");
    }

    public static boolean isAcquired() {
        boolean z;
        synchronized ($LOCK) {
            z = endpoint != null;
        }
        return z;
    }

    public static PjmEndpoint acquireEndpoint(@NonNull PjmEndpointConfig pjmEndpointConfig, long j) throws PjmStartupException {
        EndpointBridge endpointBridgeMakeEndpoint;
        synchronized ($LOCK) {
            try {
                if (pjmEndpointConfig == null) {
                    throw new NullPointerException("endpointConfig is marked non-null but is null");
                }
                Log.e("PjmAccessPoint", "acquireEndpoint:");
                endpointBridgeMakeEndpoint = makeEndpoint(pjmEndpointConfig, j);
                endpoint = endpointBridgeMakeEndpoint;
            } catch (Throwable th) {
                throw th;
            }
        }
        return endpointBridgeMakeEndpoint;
    }

    private static EndpointBridge makeEndpoint(@NonNull PjmEndpointConfig pjmEndpointConfig, long j) throws PjmStartupException {
        EndpointBridge endpointBridge;
        synchronized ($LOCK) {
            try {
                if (pjmEndpointConfig == null) {
                    throw new NullPointerException("endpointConfig is marked non-null but is null");
                }
                waitEndpoint(j);
                if (isAcquired()) {
                    throw new IllegalStateException();
                }
                endpointBridge = new EndpointBridge(pjmEndpointConfig, new Lambda$Code0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.PjmAccessPoint$$ExternalSyntheticLambda0
                    @Override // com.axmor.ash.toolset.utils.Lambda$Code0
                    public final void invoke() {
                        PjmAccessPoint.onRelease();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
        return endpointBridge;
    }

    private static void waitEndpoint(long j) throws PjmStartupException {
        synchronized ($LOCK) {
            try {
                if (isAcquired() && 0 >= j) {
                    throw new PjmStartupException("Endpoint already acquired.");
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                while (isAcquired()) {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (jElapsedRealtime2 >= j) {
                        throw new PjmStartupException("Failed to acquire endpoint.");
                    }
                    try {
                        Log.e("PjmAccessPoint", "acquireEndpoint:waitingForEndpoint");
                        $LOCK.wait(j - jElapsedRealtime2);
                    } catch (InterruptedException e) {
                        Log.e("PjmAccessPoint", "acquireEndpoint:", e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onRelease() {
        Object[] objArr = $LOCK;
        synchronized (objArr) {
            Log.e("PjmAccessPoint", "ENDPOINT-RELEASED");
            endpoint = null;
            objArr.notifyAll();
        }
    }
}
