package androidx.paging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidateCallbackTracker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0018\u0010\u0018\u001a\u00060\u0016j\u0002`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"Landroidx/paging/InvalidateCallbackTracker;", "T", "", "Lkotlin/Function1;", "", "callbackInvoker", "Lkotlin/Function0;", "", "invalidGetter", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "callback", "registerInvalidatedCallback$paging_common_release", "(Ljava/lang/Object;)V", "registerInvalidatedCallback", "unregisterInvalidatedCallback$paging_common_release", "unregisterInvalidatedCallback", "invalidate$paging_common_release", "()Z", "invalidate", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/paging/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "callbacks", "Ljava/util/List;", "<set-?>", "invalid", "Z", "getInvalid$paging_common_release", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InvalidateCallbackTracker<T> {
    private final Function1<T, Unit> callbackInvoker;
    private final List<T> callbacks;
    private boolean invalid;
    private final Function0<Boolean> invalidGetter;
    private final ReentrantLock lock;

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidateCallbackTracker(Function1<? super T, Unit> callbackInvoker, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(callbackInvoker, "callbackInvoker");
        this.callbackInvoker = callbackInvoker;
        this.invalidGetter = function0;
        this.lock = new ReentrantLock();
        this.callbacks = new ArrayList();
    }

    public /* synthetic */ InvalidateCallbackTracker(Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function0);
    }

    public final void registerInvalidatedCallback$paging_common_release(T callback) {
        Function0<Boolean> function0 = this.invalidGetter;
        boolean z = true;
        if (function0 != null && function0.invoke().booleanValue()) {
            invalidate$paging_common_release();
        }
        if (this.invalid) {
            this.callbackInvoker.invoke(callback);
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        try {
            reentrantLock.lock();
            if (!this.invalid) {
                this.callbacks.add(callback);
                z = false;
            }
            if (z) {
                this.callbackInvoker.invoke(callback);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void unregisterInvalidatedCallback$paging_common_release(T callback) {
        ReentrantLock reentrantLock = this.lock;
        try {
            reentrantLock.lock();
            this.callbacks.remove(callback);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean invalidate$paging_common_release() {
        if (this.invalid) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        try {
            reentrantLock.lock();
            if (this.invalid) {
                return false;
            }
            this.invalid = true;
            List list = CollectionsKt.toList(this.callbacks);
            this.callbacks.clear();
            reentrantLock.unlock();
            Function1<T, Unit> function1 = this.callbackInvoker;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
