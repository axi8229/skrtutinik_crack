package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor;
import io.reactivex.functions.Function;
import java.util.List;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RecordingStatusInteractor$$ExternalSyntheticLambda6 implements Function {
    public final /* synthetic */ RecordingStatusInteractor.RangesProcessor f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.splitRangeByDuration((List) obj);
    }
}
