package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: BringIntoViewRequestPriorityQueue.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", "<init>", "()V", "Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "request", "", "enqueue", "(Landroidx/compose/foundation/gestures/ContentInViewNode$Request;)Z", "", "resumeAndRemoveAll", "", "cause", "cancelAndRemoveAll", "(Ljava/lang/Throwable;)V", "Landroidx/compose/runtime/collection/MutableVector;", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BringIntoViewRequestPriorityQueue {
    public static final int $stable = MutableVector.$stable;
    private final MutableVector<ContentInViewNode.Request> requests = new MutableVector<>(new ContentInViewNode.Request[16], 0);

    public final boolean enqueue(final ContentInViewNode.Request request) {
        Rect rectInvoke = request.getCurrentBounds().invoke();
        if (rectInvoke == null) {
            CancellableContinuation<Unit> continuation = request.getContinuation();
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
            return false;
        }
        request.getContinuation().invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.enqueue.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BringIntoViewRequestPriorityQueue.this.requests.remove(request);
            }
        });
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                Rect rectInvoke2 = this.requests.getContent()[last].getCurrentBounds().invoke();
                if (rectInvoke2 != null) {
                    Rect rectIntersect = rectInvoke.intersect(rectInvoke2);
                    if (Intrinsics.areEqual(rectIntersect, rectInvoke)) {
                        this.requests.add(last + 1, request);
                        return true;
                    }
                    if (!Intrinsics.areEqual(rectIntersect, rectInvoke2)) {
                        CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int size = this.requests.getSize() - 1;
                        if (size <= last) {
                            while (true) {
                                this.requests.getContent()[last].getContinuation().cancel(cancellationException);
                                if (size == last) {
                                    break;
                                }
                                size++;
                            }
                        }
                    }
                }
                if (last == first) {
                    break;
                }
                last--;
            }
        }
        this.requests.add(0, request);
        return true;
    }

    public final void resumeAndRemoveAll() {
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                this.requests.getContent()[first].getContinuation().resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        this.requests.clear();
    }

    public final void cancelAndRemoveAll(Throwable cause) {
        MutableVector<ContentInViewNode.Request> mutableVector = this.requests;
        int size = mutableVector.getSize();
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[size];
        for (int i = 0; i < size; i++) {
            cancellableContinuationArr[i] = mutableVector.getContent()[i].getContinuation();
        }
        for (int i2 = 0; i2 < size; i2++) {
            cancellableContinuationArr[i2].cancel(cause);
        }
        if (!this.requests.isEmpty()) {
            throw new IllegalStateException("uncancelled requests present");
        }
    }
}
