package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class Functions {
    static final Function<Object, Object> IDENTITY = new Identity();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Action EMPTY_ACTION = new EmptyAction();
    static final Consumer<Object> EMPTY_CONSUMER = new EmptyConsumer();
    public static final Consumer<Throwable> ERROR_CONSUMER = new ErrorConsumer();
    public static final Consumer<Throwable> ON_ERROR_MISSING = new OnErrorMissingConsumer();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    static final Predicate<Object> ALWAYS_TRUE = new TruePredicate();
    static final Predicate<Object> ALWAYS_FALSE = new FalsePredicate();
    static final Callable<Object> NULL_SUPPLIER = new NullCallable();
    static final Comparator<Object> NATURAL_COMPARATOR = new NaturalObjectComparator();
    public static final Consumer<Subscription> REQUEST_MAX = new MaxRequestSubscription();

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        final U value;

        JustValue(U u) {
            this.value = u;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.value;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t) throws Exception {
            return this.value;
        }
    }

    public static <T> Callable<T> justCallable(T t) {
        return new JustValue(t);
    }

    public static <T, U> Function<T, U> justFunction(U u) {
        return new JustValue(u);
    }

    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> f;

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f = biFunction;
        }

        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 2) {
                throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1]);
        }
    }

    static final class Identity implements Function<Object, Object> {
        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        Identity() {
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        EmptyRunnable() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class EmptyAction implements Action {
        @Override // io.reactivex.functions.Action
        public void run() {
        }

        EmptyAction() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class EmptyConsumer implements Consumer<Object> {
        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }

        EmptyConsumer() {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }

    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }
    }

    static final class TruePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }

        TruePredicate() {
        }
    }

    static final class FalsePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }

        FalsePredicate() {
        }
    }

    static final class NullCallable implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        NullCallable() {
        }
    }

    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
