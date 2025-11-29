package androidx.paging;

import androidx.paging.ViewportHint;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: HintHandler.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/paging/HintHandler;", "", "()V", "lastAccessHint", "Landroidx/paging/ViewportHint$Access;", "getLastAccessHint", "()Landroidx/paging/ViewportHint$Access;", "state", "Landroidx/paging/HintHandler$State;", "forceSetHint", "", "loadType", "Landroidx/paging/LoadType;", "viewportHint", "Landroidx/paging/ViewportHint;", "hintFor", "Lkotlinx/coroutines/flow/Flow;", "processHint", "HintFlow", "State", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HintHandler {
    private final State state = new State();

    /* compiled from: HintHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ViewportHint.Access getLastAccessHint() {
        return this.state.getLastAccessHint();
    }

    public final Flow<ViewportHint> hintFor(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return this.state.getPrependFlow();
        }
        if (i == 2) {
            return this.state.getAppendFlow();
        }
        throw new IllegalArgumentException("invalid load type for hints");
    }

    public final void forceSetHint(final LoadType loadType, final ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        if (loadType != LoadType.PREPEND && loadType != LoadType.APPEND) {
            throw new IllegalArgumentException(("invalid load type for reset: " + loadType).toString());
        }
        this.state.modify(null, new Function2<HintFlow, HintFlow, Unit>() { // from class: androidx.paging.HintHandler.forceSetHint.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HintFlow hintFlow, HintFlow hintFlow2) {
                invoke2(hintFlow, hintFlow2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HintFlow prependHint, HintFlow appendHint) {
                Intrinsics.checkNotNullParameter(prependHint, "prependHint");
                Intrinsics.checkNotNullParameter(appendHint, "appendHint");
                if (loadType == LoadType.PREPEND) {
                    prependHint.setValue(viewportHint);
                } else {
                    appendHint.setValue(viewportHint);
                }
            }
        });
    }

    public final void processHint(final ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.state.modify(viewportHint instanceof ViewportHint.Access ? (ViewportHint.Access) viewportHint : null, new Function2<HintFlow, HintFlow, Unit>() { // from class: androidx.paging.HintHandler.processHint.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HintFlow hintFlow, HintFlow hintFlow2) {
                invoke2(hintFlow, hintFlow2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HintFlow prependHint, HintFlow appendHint) {
                Intrinsics.checkNotNullParameter(prependHint, "prependHint");
                Intrinsics.checkNotNullParameter(appendHint, "appendHint");
                if (HintHandlerKt.shouldPrioritizeOver(viewportHint, prependHint.getValue(), LoadType.PREPEND)) {
                    prependHint.setValue(viewportHint);
                }
                if (HintHandlerKt.shouldPrioritizeOver(viewportHint, appendHint.getValue(), LoadType.APPEND)) {
                    appendHint.setValue(viewportHint);
                }
            }
        });
    }

    /* compiled from: HintHandler.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042 \u0010\n\u001a\u001c\u0012\b\u0012\u00060\u0007R\u00020\b\u0012\b\u0012\u00060\u0007R\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00060\u0007R\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00060\u0007R\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR(\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u00060\u0015j\u0002`\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Landroidx/paging/HintHandler$State;", "", "<init>", "(Landroidx/paging/HintHandler;)V", "Landroidx/paging/ViewportHint$Access;", "accessHint", "Lkotlin/Function2;", "Landroidx/paging/HintHandler$HintFlow;", "Landroidx/paging/HintHandler;", "", "block", "modify", "(Landroidx/paging/ViewportHint$Access;Lkotlin/jvm/functions/Function2;)V", "prepend", "Landroidx/paging/HintHandler$HintFlow;", "append", "<set-?>", "lastAccessHint", "Landroidx/paging/ViewportHint$Access;", "getLastAccessHint", "()Landroidx/paging/ViewportHint$Access;", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/paging/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ViewportHint;", "getPrependFlow", "()Lkotlinx/coroutines/flow/Flow;", "prependFlow", "getAppendFlow", "appendFlow", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class State {
        private final HintFlow append;
        private ViewportHint.Access lastAccessHint;
        private final ReentrantLock lock = new ReentrantLock();
        private final HintFlow prepend;

        public State() {
            this.prepend = HintHandler.this.new HintFlow();
            this.append = HintHandler.this.new HintFlow();
        }

        public final ViewportHint.Access getLastAccessHint() {
            return this.lastAccessHint;
        }

        public final Flow<ViewportHint> getPrependFlow() {
            return this.prepend.getFlow();
        }

        public final Flow<ViewportHint> getAppendFlow() {
            return this.append.getFlow();
        }

        public final void modify(ViewportHint.Access accessHint, Function2<? super HintFlow, ? super HintFlow, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            ReentrantLock reentrantLock = this.lock;
            try {
                reentrantLock.lock();
                if (accessHint != null) {
                    this.lastAccessHint = accessHint;
                }
                block.invoke(this.prepend, this.append);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* compiled from: HintHandler.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/HintHandler$HintFlow;", "", "(Landroidx/paging/HintHandler;)V", "_flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/paging/ViewportHint;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getValue", "()Landroidx/paging/ViewportHint;", "setValue", "(Landroidx/paging/ViewportHint;)V", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class HintFlow {
        private final MutableSharedFlow<ViewportHint> _flow = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        private ViewportHint value;

        public HintFlow() {
        }

        public final ViewportHint getValue() {
            return this.value;
        }

        public final void setValue(ViewportHint viewportHint) {
            this.value = viewportHint;
            if (viewportHint != null) {
                this._flow.tryEmit(viewportHint);
            }
        }

        public final Flow<ViewportHint> getFlow() {
            return this._flow;
        }
    }
}
