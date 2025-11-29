package flussonic.watcher.sdk.presentation.watcher;

import io.reactivex.functions.Consumer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlussonicControllerImpl$$ExternalSyntheticLambda5 implements Consumer {
    public final /* synthetic */ FlussonicControllerImpl f$0;

    public /* synthetic */ FlussonicControllerImpl$$ExternalSyntheticLambda5(FlussonicControllerImpl flussonicControllerImpl) {
        this.f$0 = flussonicControllerImpl;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.f$0.onError((Throwable) obj);
    }
}
