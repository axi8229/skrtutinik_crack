package flussonic.watcher.sdk.data.repository;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class WatcherRepository$$ExternalSyntheticLambda0 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return Observable.fromIterable((List) obj);
    }
}
