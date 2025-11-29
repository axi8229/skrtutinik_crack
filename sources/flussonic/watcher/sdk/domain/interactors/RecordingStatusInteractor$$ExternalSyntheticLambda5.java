package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor;
import flussonic.watcher.sdk.domain.pojo.Range;
import io.reactivex.functions.Function;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RecordingStatusInteractor$$ExternalSyntheticLambda5 implements Function {
    public final /* synthetic */ RecordingStatusInteractor.RangesProcessor f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.splitRange((Range) obj);
    }
}
