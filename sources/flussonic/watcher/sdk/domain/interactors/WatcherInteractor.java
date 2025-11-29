package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.data.repository.WatcherRepository;
import flussonic.watcher.sdk.data.repository.WatcherRepository$$ExternalSyntheticLambda0;
import flussonic.watcher.sdk.domain.core.RetryFunction;
import flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor;
import flussonic.watcher.sdk.domain.pojo.Camera;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;
import flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class WatcherInteractor {
    private final WatcherRepository watcherRepository;

    public WatcherInteractor(WatcherRepository watcherRepository) {
        this.watcherRepository = watcherRepository;
    }

    public Single<StreamerConnectionParameters> initStreamer() {
        return this.watcherRepository.findCamera(RetryFunction.CONSTANT_DELAY_INFINITE).map(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.WatcherInteractor$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((Camera) obj).getConnectionParameters();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Ranges> visibleWindowChanges(Subject<VisibleRangeChangedEvent> visibleWindowChanges, final RecordingStatusInteractor.RangesProcessor rangesProcessor, RecordingStatusInteractor.ProcessRangesOnUiFunction processRangesOnUiFunction) {
        Observable<VisibleRangeChangedEvent> observableDebounce = visibleWindowChanges.debounce(75L, TimeUnit.MILLISECONDS, Schedulers.io());
        rangesProcessor.getClass();
        return observableDebounce.map(new RecordingStatusInteractor$$ExternalSyntheticLambda1(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda5(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda6(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda7(rangesProcessor)).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.domain.interactors.WatcherInteractor$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                WatcherInteractor.lambda$visibleWindowChanges$0((List) obj);
            }
        }).flatMap(new WatcherRepository$$ExternalSyntheticLambda0()).filter(new RecordingStatusInteractor$$ExternalSyntheticLambda11()).flatMapSingle(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.WatcherInteractor$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$visibleWindowChanges$2((Range) obj);
            }
        }).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.domain.interactors.WatcherInteractor$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                rangesProcessor.mergeEvents((List) obj);
            }
        }).map(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.WatcherInteractor$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return WatcherInteractor.lambda$visibleWindowChanges$3(rangesProcessor, (List) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$visibleWindowChanges$0(List ranges) throws Exception {
        Timber.d("visibleWindowChanges: expand range by constant: %s", ranges);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$visibleWindowChanges$2(Range range) throws Exception {
        return this.watcherRepository.timelineEvents(range, RetryFunction.LINEAR_DELAY_LIMITED).onErrorReturn(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.WatcherInteractor$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return WatcherInteractor.lambda$null$1((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$null$1(Throwable throwable) throws Exception {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Ranges lambda$visibleWindowChanges$3(final RecordingStatusInteractor.RangesProcessor rangesProcessor, List ignored) throws Exception {
        return rangesProcessor.getLoadedRanges();
    }
}
