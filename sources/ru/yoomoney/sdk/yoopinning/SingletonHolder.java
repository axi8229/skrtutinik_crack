package ru.yoomoney.sdk.yoopinning;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingletonHolder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\u0006\b\u0001\u0010\u0003 \u0000*\u0006\b\u0002\u0010\u0004 \u00002\u00020\u0002B\u001f\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0088\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/yoopinning/SingletonHolder;", "T", "", "A", "B", "creator", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "instance", "Ljava/lang/Object;", "getInstance", "arg", "host", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SingletonHolder<T, A, B> {
    private Function2<? super A, ? super B, ? extends T> creator;
    private volatile T instance;

    public SingletonHolder(Function2<? super A, ? super B, ? extends T> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.creator = creator;
    }

    public final T getInstance(A arg, B host) {
        T tInvoke;
        T t = this.instance;
        if (t != null) {
            return t;
        }
        synchronized (this) {
            tInvoke = this.instance;
            if (tInvoke == null) {
                Function2<? super A, ? super B, ? extends T> function2 = this.creator;
                Intrinsics.checkNotNull(function2);
                tInvoke = function2.invoke(arg, host);
                this.instance = tInvoke;
                this.creator = null;
            }
        }
        return tInvoke;
    }
}
