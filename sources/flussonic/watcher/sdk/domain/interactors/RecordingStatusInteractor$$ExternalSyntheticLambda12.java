package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.domain.pojo.Range;
import io.reactivex.functions.Function;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RecordingStatusInteractor$$ExternalSyntheticLambda12 implements Function {
    public final /* synthetic */ RecordingStatusInteractor f$0;

    public /* synthetic */ RecordingStatusInteractor$$ExternalSyntheticLambda12(RecordingStatusInteractor recordingStatusInteractor) {
        this.f$0 = recordingStatusInteractor;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.loadRangesInRange((Range) obj);
    }
}
