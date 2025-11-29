package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.domain.pojo.Range;
import io.reactivex.functions.Predicate;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RecordingStatusInteractor$$ExternalSyntheticLambda11 implements Predicate {
    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object obj) {
        return ((Range) obj).isValid();
    }
}
