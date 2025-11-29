package flussonic.watcher.sdk.domain.interactors;

import flussonic.watcher.sdk.data.repository.RecordingStatusRepository;
import flussonic.watcher.sdk.data.repository.WatcherRepository$$ExternalSyntheticLambda0;
import flussonic.watcher.sdk.domain.core.RetryFunction;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.pojo.RangesResponse;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;
import flussonic.watcher.sdk.domain.utils.FlussonicUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class RecordingStatusInteractor {
    private final RecordingStatusRepository recordingStatusRepository;

    @FunctionalInterface
    public interface ProcessRangesOnUiFunction {
        void processRangesOnUi(Ranges ranges);
    }

    public interface RangesProcessor {
        Range expandRange(VisibleRangeChangedEvent event);

        List<Range> expandRangeByConstant(List<Range> ranges);

        long getLastValue();

        Ranges getLoadedRanges();

        void mergeEvents(List<Range> eventRanges);

        void mergeRanges(RangesResponse rangesResponse);

        void putLoadingRanges(List<Range> ranges);

        void setAvailableRange(Range range);

        List<Range> splitRange(Range range);

        List<Range> splitRangeByDuration(List<Range> ranges);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$null$2(final List loadingRanges, Ranges ignored) throws Exception {
        return loadingRanges;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$null$8(final List loadingRanges, Ranges ignored) throws Exception {
        return loadingRanges;
    }

    public RecordingStatusInteractor(RecordingStatusRepository recordingStatusRepository) {
        this.recordingStatusRepository = recordingStatusRepository;
    }

    public Single<Range> initRecordingStatus(final RangesProcessor rangesProcessor) {
        Single<Range> singleAvailableRange = this.recordingStatusRepository.availableRange(RetryFunction.CONSTANT_DELAY_INFINITE);
        rangesProcessor.getClass();
        return singleAvailableRange.doOnSuccess(new Consumer() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                rangesProcessor.setAvailableRange((Range) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Range lambda$updateRecordingStatus$0(final RangesProcessor rangesProcessor) throws Exception {
        return Range.createFromTo(rangesProcessor.getLastValue(), FlussonicUtils.utcTimeSeconds());
    }

    public Observable<Ranges> updateRecordingStatus(final RangesProcessor rangesProcessor, final ProcessRangesOnUiFunction processRangesOnUiFunction) {
        Observable observableFromCallable = Observable.fromCallable(new Callable() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RecordingStatusInteractor.lambda$updateRecordingStatus$0(rangesProcessor);
            }
        });
        rangesProcessor.getClass();
        Observable observableObserveOn = observableFromCallable.map(new RecordingStatusInteractor$$ExternalSyntheticLambda5(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda6(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda7(rangesProcessor)).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                RecordingStatusInteractor.lambda$updateRecordingStatus$1((List) obj);
            }
        }).doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda9(rangesProcessor)).flatMap(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$updateRecordingStatus$3(rangesProcessor, processRangesOnUiFunction, (List) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new WatcherRepository$$ExternalSyntheticLambda0()).filter(new RecordingStatusInteractor$$ExternalSyntheticLambda11()).flatMapSingle(new RecordingStatusInteractor$$ExternalSyntheticLambda12(this)).doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda2(rangesProcessor)).map(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$updateRecordingStatus$4(rangesProcessor, (RangesResponse) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        processRangesOnUiFunction.getClass();
        return observableObserveOn.doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda4(processRangesOnUiFunction)).delay(5L, TimeUnit.SECONDS, Schedulers.io()).repeat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateRecordingStatus$1(List ranges) throws Exception {
        Timber.d("updateRecordingStatus: expand range by constant: %s", ranges);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ObservableSource lambda$updateRecordingStatus$3(final RangesProcessor rangesProcessor, final ProcessRangesOnUiFunction processRangesOnUiFunction, final List loadingRanges) throws Exception {
        Observable observableObserveOn = Observable.just(rangesProcessor.getLoadedRanges()).observeOn(AndroidSchedulers.mainThread());
        processRangesOnUiFunction.getClass();
        return observableObserveOn.doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda4(processRangesOnUiFunction)).map(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$null$2(loadingRanges, (Ranges) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Ranges lambda$updateRecordingStatus$4(final RangesProcessor rangesProcessor, RangesResponse rangesResponse) throws Exception {
        return rangesProcessor.getLoadedRanges();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Single<RangesResponse> loadRangesInRange(final Range range) {
        return this.recordingStatusRepository.ranges(range, RetryFunction.LINEAR_DELAY_LIMITED).onErrorReturn(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$loadRangesInRange$5((Throwable) obj);
            }
        }).map(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$loadRangesInRange$6(range, (RangesResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RangesResponse lambda$loadRangesInRange$5(Throwable throwable) throws Exception {
        return RangesResponse.createFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RangesResponse lambda$loadRangesInRange$6(final Range range, RangesResponse ranges) throws Exception {
        return ranges.withRequestedRange(range);
    }

    public Observable<Ranges> visibleWindowChanges(Subject<VisibleRangeChangedEvent> visibleWindowChanges, final RangesProcessor rangesProcessor, final ProcessRangesOnUiFunction processRangesOnUiFunction) {
        Observable<VisibleRangeChangedEvent> observableDebounce = visibleWindowChanges.debounce(150L, TimeUnit.MILLISECONDS, Schedulers.io());
        rangesProcessor.getClass();
        Observable observableObserveOn = observableDebounce.map(new RecordingStatusInteractor$$ExternalSyntheticLambda1(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda5(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda6(rangesProcessor)).map(new RecordingStatusInteractor$$ExternalSyntheticLambda7(rangesProcessor)).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                RecordingStatusInteractor.lambda$visibleWindowChanges$7((List) obj);
            }
        }).doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda9(rangesProcessor)).flatMap(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$visibleWindowChanges$9(rangesProcessor, processRangesOnUiFunction, (List) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new WatcherRepository$$ExternalSyntheticLambda0()).filter(new RecordingStatusInteractor$$ExternalSyntheticLambda11()).flatMapSingle(new RecordingStatusInteractor$$ExternalSyntheticLambda12(this)).doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda2(rangesProcessor)).map(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$visibleWindowChanges$10(rangesProcessor, (RangesResponse) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        processRangesOnUiFunction.getClass();
        return observableObserveOn.doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda4(processRangesOnUiFunction));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$visibleWindowChanges$7(List ranges) throws Exception {
        Timber.d("visibleWindowChanges: expand range by constant: %s", ranges);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ObservableSource lambda$visibleWindowChanges$9(final RangesProcessor rangesProcessor, final ProcessRangesOnUiFunction processRangesOnUiFunction, final List loadingRanges) throws Exception {
        Observable observableObserveOn = Observable.just(rangesProcessor.getLoadedRanges()).observeOn(AndroidSchedulers.mainThread());
        processRangesOnUiFunction.getClass();
        return observableObserveOn.doOnNext(new RecordingStatusInteractor$$ExternalSyntheticLambda4(processRangesOnUiFunction)).map(new Function() { // from class: flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecordingStatusInteractor.lambda$null$8(loadingRanges, (Ranges) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Ranges lambda$visibleWindowChanges$10(final RangesProcessor rangesProcessor, RangesResponse rangesResponse) throws Exception {
        return rangesProcessor.getLoadedRanges();
    }
}
