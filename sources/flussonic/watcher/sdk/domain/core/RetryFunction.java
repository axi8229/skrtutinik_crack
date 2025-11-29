package flussonic.watcher.sdk.domain.core;

import flussonic.watcher.sdk.domain.core.RetryFunction;
import flussonic.watcher.sdk.domain.exceptions.TryCountExceeded;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

@FunctionalInterface
/* loaded from: classes3.dex */
public interface RetryFunction {
    public static final RetryFunction LINEAR_DELAY_LIMITED = new AnonymousClass1();
    public static final RetryFunction CONSTANT_DELAY_INFINITE = new AnonymousClass2();

    <T> Observable<T> wrap(Single<T> request);

    /* renamed from: flussonic.watcher.sdk.domain.core.RetryFunction$1, reason: invalid class name */
    static class AnonymousClass1 implements RetryFunction {
        AnonymousClass1() {
        }

        @Override // flussonic.watcher.sdk.domain.core.RetryFunction
        public <T> Observable<T> wrap(Single<T> request) {
            return request.toObservable().retryWhen(new Function() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$1$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RetryFunction.AnonymousClass1.lambda$wrap$5((Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$wrap$5(Observable errors) throws Exception {
            return errors.zipWith(Observable.range(1, 5), new BiFunction() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$1$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return RetryFunction.AnonymousClass1.lambda$null$0((Throwable) obj, (Integer) obj2);
                }
            }).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$1$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    RetryFunction.AnonymousClass1.lambda$null$1((Integer) obj);
                }
            }).map(new Function() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$1$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RetryFunction.AnonymousClass1.lambda$null$2((Integer) obj);
                }
            }).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$1$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    RetryFunction.AnonymousClass1.lambda$null$3((Integer) obj);
                }
            }).flatMap(new Function() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$1$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RetryFunction.AnonymousClass1.lambda$null$4((Integer) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$null$0(Throwable throwable, Integer i) throws Exception {
            if (i.intValue() != 5) {
                return i;
            }
            throw new TryCountExceeded(throwable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$null$1(Integer retryCount) throws Exception {
            Timber.d("try %d failed", retryCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$null$2(Integer retryCount) throws Exception {
            return Integer.valueOf((retryCount.intValue() * 3) / 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$null$3(Integer delay) throws Exception {
            Timber.d("next try will start in %d seconds", delay);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$null$4(Integer delay) throws Exception {
            return Observable.timer(delay.intValue(), TimeUnit.SECONDS, Schedulers.io());
        }
    }

    /* renamed from: flussonic.watcher.sdk.domain.core.RetryFunction$2, reason: invalid class name */
    static class AnonymousClass2 implements RetryFunction {
        AnonymousClass2() {
        }

        @Override // flussonic.watcher.sdk.domain.core.RetryFunction
        public <T> Observable<T> wrap(Single<T> request) {
            return request.toObservable().retryWhen(new Function() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$2$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RetryFunction.AnonymousClass2.lambda$wrap$2((Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$wrap$2(Observable errors) throws Exception {
            return errors.doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$2$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    RetryFunction.AnonymousClass2.lambda$null$0((Throwable) obj);
                }
            }).flatMap(new Function() { // from class: flussonic.watcher.sdk.domain.core.RetryFunction$2$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RetryFunction.AnonymousClass2.lambda$null$1((Throwable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$null$0(Throwable error) throws Exception {
            Timber.d(error, "try failed", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$null$1(Throwable error) throws Exception {
            return Observable.timer(5L, TimeUnit.SECONDS, Schedulers.io());
        }
    }
}
