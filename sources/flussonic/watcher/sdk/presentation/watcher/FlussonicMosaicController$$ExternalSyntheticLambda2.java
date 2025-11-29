package flussonic.watcher.sdk.presentation.watcher;

import io.reactivex.functions.Consumer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlussonicMosaicController$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ FlussonicMosaicController f$0;

    public /* synthetic */ FlussonicMosaicController$$ExternalSyntheticLambda2(FlussonicMosaicController flussonicMosaicController) {
        this.f$0 = flussonicMosaicController;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.f$0.onError((Throwable) obj);
    }
}
