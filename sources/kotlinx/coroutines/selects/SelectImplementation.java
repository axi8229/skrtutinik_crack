package kotlinx.coroutines.selects;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;

/* compiled from: Select.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001-J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0018\u00010\tR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R(\u0010%\u001a\u0014\u0012\u000e\u0012\f0\tR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0011\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030+8\u0002X\u0082\u0004¨\u0006."}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "", "clauseObject", "internalResult", "", "trySelectInternal", "(Ljava/lang/Object;Ljava/lang/Object;)I", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "findClause", "(Ljava/lang/Object;)Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "Lkotlinx/coroutines/internal/Segment;", "segment", "index", "", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "selectInRegistrationPhase", "(Ljava/lang/Object;)V", "result", "", "trySelect", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectDetailed", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "", "clauses", "Ljava/util/List;", "disposableHandleOrSegment", "Ljava/lang/Object;", "indexInSegment", "I", "Lkotlinx/atomicfu/AtomicRef;", "state", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class SelectImplementation<R> extends CancelHandler implements SelectInstance, Waiter {
    private static final AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    private List<SelectImplementation<R>.ClauseData> clauses;
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    private Object internalResult;
    private volatile Object state;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(Object internalResult) {
        this.internalResult = internalResult;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object clauseObject, Object result) {
        return trySelectInternal(clauseObject, result) == 0;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object clauseObject, Object result) {
        return SelectKt.TrySelectDetailedResult(trySelectInternal(clauseObject, result));
    }

    private final int trySelectInternal(Object clauseObject, Object internalResult) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof CancellableContinuation)) {
                if (Intrinsics.areEqual(obj, SelectKt.STATE_COMPLETED) ? true : obj instanceof ClauseData) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj, SelectKt.STATE_CANCELLED)) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj, SelectKt.STATE_REG)) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj, CollectionsKt.listOf(clauseObject))) {
                        return 1;
                    }
                } else {
                    if (!(obj instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj).toString());
                    }
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj, CollectionsKt.plus((Collection<? extends Object>) obj, clauseObject))) {
                        return 1;
                    }
                }
            } else {
                SelectImplementation<R>.ClauseData clauseDataFindClause = findClause(clauseObject);
                if (clauseDataFindClause == null) {
                    continue;
                } else {
                    Function1<Throwable, Unit> function1CreateOnCancellationAction = clauseDataFindClause.createOnCancellationAction(this, internalResult);
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj, clauseDataFindClause)) {
                        this.internalResult = internalResult;
                        if (SelectKt.tryResume((CancellableContinuation) obj, function1CreateOnCancellationAction)) {
                            return 0;
                        }
                        this.internalResult = null;
                        return 2;
                    }
                }
            }
        }
    }

    private final SelectImplementation<R>.ClauseData findClause(Object clauseObject) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).clauseObject == clauseObject) {
                obj = next;
                break;
            }
        }
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable cause) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_COMPLETED) {
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj, SelectKt.STATE_CANCELLED));
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ClauseData) it.next()).dispose();
        }
        this.internalResult = SelectKt.NO_RESULT;
        this.clauses = null;
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rRH\u0010\u0011\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "", "dispose", "()V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "internalResult", "Lkotlin/Function1;", "", "createOnCancellationAction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "clauseObject", "Ljava/lang/Object;", RemoteMessageConst.MessageBody.PARAM, "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "Lkotlin/jvm/functions/Function3;", "disposableHandleOrSegment", "", "indexInSegment", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ClauseData {
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment;
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        private final Object param;
        final /* synthetic */ SelectImplementation<R> this$0;

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            SelectImplementation<R> selectImplementation = this.this$0;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Function1<Throwable, Unit> createOnCancellationAction(SelectInstance<?> select, Object internalResult) {
            Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.onCancellationConstructor;
            if (function3 != null) {
                return function3.invoke(select, this.param, internalResult);
            }
            return null;
        }
    }
}
