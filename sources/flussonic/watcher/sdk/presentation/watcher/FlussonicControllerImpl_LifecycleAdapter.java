package flussonic.watcher.sdk.presentation.watcher;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

/* loaded from: classes3.dex */
public class FlussonicControllerImpl_LifecycleAdapter implements GeneratedAdapter {
    final FlussonicControllerImpl mReceiver;

    FlussonicControllerImpl_LifecycleAdapter(FlussonicControllerImpl receiver) {
        this.mReceiver = receiver;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public void callMethods(LifecycleOwner owner, Lifecycle.Event event, boolean onAny, MethodCallsLogger logger) {
        boolean z = logger != null;
        if (onAny) {
            return;
        }
        if (event == Lifecycle.Event.ON_CREATE) {
            if (!z || logger.approveCall("onCreate", 1)) {
                this.mReceiver.onCreate();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_START) {
            if (!z || logger.approveCall("onStart", 1)) {
                this.mReceiver.onStart();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_RESUME) {
            if (!z || logger.approveCall("onResume", 1)) {
                this.mReceiver.onResume();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_PAUSE) {
            if (!z || logger.approveCall("onPause", 1)) {
                this.mReceiver.onPause();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_STOP) {
            if (!z || logger.approveCall("onStop", 1)) {
                this.mReceiver.onStop();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            if (!z || logger.approveCall("onDestroy", 1)) {
                this.mReceiver.onDestroy();
            }
        }
    }
}
