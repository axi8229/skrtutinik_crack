package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import io.reactivex.functions.Consumer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RecordingStatusInteractor$$ExternalSyntheticLambda4 implements Consumer {
    public final /* synthetic */ RecordingStatusInteractor.ProcessRangesOnUiFunction f$0;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.f$0.processRangesOnUi((Ranges) obj);
    }
}
