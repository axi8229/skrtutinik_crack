package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor;
import io.reactivex.functions.Consumer;
import java.util.List;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RecordingStatusInteractor$$ExternalSyntheticLambda9 implements Consumer {
    public final /* synthetic */ RecordingStatusInteractor.RangesProcessor f$0;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.f$0.putLoadingRanges((List) obj);
    }
}
