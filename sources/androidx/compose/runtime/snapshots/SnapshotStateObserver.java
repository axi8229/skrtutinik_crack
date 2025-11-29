package androidx.compose.runtime.snapshots;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: SnapshotStateObserver.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001>B!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0019\u001a\u00020\u0018\"\b\b\u0000\u0010\u0016*\u00020\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\u001e\u001a\u00020\u0004\"\b\b\u0000\u0010\u0016*\u00020\u00012\u0006\u0010\u001b\u001a\u00028\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0001¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\u00042\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b#\u0010\u0007J\r\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\fJ\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\fJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\fR&\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R(\u0010)\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010'j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R,\u0010/\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010&R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0018028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010,R\u0018\u00109\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006?"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "onChangedExecutor", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "drainChanges", "()Z", "sendNotifications", "()V", "", "set", "addChanges", "(Ljava/util/Set;)V", "removeChanges", "()Ljava/util/Set;", "", "report", "()Ljava/lang/Void;", "T", "onChanged", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "ensureMap", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "scope", "onValueChangedForScope", "block", "observeReads", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "clear", "(Ljava/lang/Object;)V", "predicate", "clearIf", "start", "stop", "Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "sendingNotifications", "Z", "Lkotlin/Function2;", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyObserver", "Lkotlin/jvm/functions/Function2;", "readObserver", "Landroidx/compose/runtime/collection/MutableVector;", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "isPaused", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "currentMapThreadId", "J", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            invoke2(set, snapshot);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
            this.this$0.addChanges(set);
            if (this.this$0.drainChanges()) {
                this.this$0.sendNotifications();
            }
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            if (this.this$0.isPaused) {
                return;
            }
            MutableVector mutableVector = this.this$0.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = this.this$0;
            synchronized (mutableVector) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                try {
                    MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        ObservedScopeMap[] content = mutableVector.getContent();
                        int i = 0;
                        do {
                            z2 = content[i].recordInvalidation(setRemoveChanges) || z2;
                            i++;
                        } while (i < size);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver.sendNotifications.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                do {
                    MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        try {
                            if (!snapshotStateObserver.sendingNotifications) {
                                snapshotStateObserver.sendingNotifications = true;
                                try {
                                    MutableVector mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                    int size = mutableVector2.getSize();
                                    if (size > 0) {
                                        Object[] content = mutableVector2.getContent();
                                        int i = 0;
                                        do {
                                            ((ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                            i++;
                                        } while (i < size);
                                    }
                                    snapshotStateObserver.sendingNotifications = false;
                                } finally {
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } while (SnapshotStateObserver.this.drainChanges());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listPlus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, listPlus));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        content[i].clear();
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                    observedScopeMap.clearScopeObservations(scope);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i3 = size - i;
                ArraysKt.fill(mutableVector.getContent(), (Object) null, i3, size);
                mutableVector.setSize(i3);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                    observedScopeMap.removeScopeIf(predicate);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i3 = size - i;
                ArraysKt.fill(mutableVector.getContent(), (Object) null, i3, size);
                mutableVector.setSize(i3);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap observedScopeMapEnsureMap;
        synchronized (this.observedScopeMaps) {
            observedScopeMapEnsureMap = ensureMap(onValueChangedForScope);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j = this.currentMapThreadId;
        if (j != -1) {
            if (!(j == ActualJvm_jvmKt.currentThreadId())) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            this.currentMapThreadId = ActualJvm_jvmKt.currentThreadId();
            observedScopeMapEnsureMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ObservedScopeMap[] content = mutableVector.getContent();
            int i = 0;
            do {
                observedScopeMap = content[i];
                if (observedScopeMap.getOnChanged() == onChanged) {
                    break;
                }
                i++;
            } while (i < size);
            observedScopeMap = null;
        } else {
            observedScopeMap = null;
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0011J7\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u0011J!\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001a0\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\r\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00032\n\u0010&\u001a\u0006\u0012\u0002\b\u00030%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0003¢\u0006\u0004\b)\u0010 R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b+\u0010,R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010-R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00100R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R&\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0001078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00100R$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030%018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00103R<\u0010F\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0006\u0012\u0004\u0018\u00010\u00010Dj\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0006\u0012\u0004\u0018\u00010\u0001`E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006H"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "Lkotlin/Function1;", "", "onChanged", "<init>", "(Lkotlin/jvm/functions/Function1;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "currentToken", "currentScope", "Landroidx/collection/MutableObjectIntMap;", "recordedValues", "recordRead", "(Ljava/lang/Object;ILjava/lang/Object;Landroidx/collection/MutableObjectIntMap;)V", "scope", "clearObsoleteStateReads", "(Ljava/lang/Object;)V", "removeObservation", "(Ljava/lang/Object;Ljava/lang/Object;)V", "readObserver", "Lkotlin/Function0;", "block", "observe", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "clearScopeObservations", "", "predicate", "removeScopeIf", "hasScopeObservations", "()Z", "clear", "()V", "", "changes", "recordInvalidation", "(Ljava/util/Set;)Z", "Landroidx/compose/runtime/DerivedState;", "derivedState", "rereadDerivedState", "(Landroidx/compose/runtime/DerivedState;)V", "notifyInvalidatedScopes", "Lkotlin/jvm/functions/Function1;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "I", "Landroidx/compose/runtime/collection/ScopeMap;", "valueToScopes", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "Landroidx/collection/MutableScatterSet;", "invalidated", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/collection/MutableVector;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "deriveStateScopeCount", "dependencyToDerivedStates", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final Function1<Object, Unit> onChanged;
        private int currentToken = -1;
        private final ScopeMap<Object, Object> valueToScopes = new ScopeMap<>();
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues = new MutableScatterMap<>(0, 1, null);
        private final MutableScatterSet<Object> invalidated = new MutableScatterSet<>(0, 1, null);
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.this$0;
                observedScopeMap.deriveStateScopeCount--;
            }
        };
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final void recordRead(Object value) {
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, mutableObjectIntMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void recordRead(java.lang.Object r21, int r22, java.lang.Object r23, androidx.collection.MutableObjectIntMap<java.lang.Object> r24) {
            /*
                r20 = this;
                r0 = r20
                r1 = r21
                r2 = r22
                int r3 = r0.deriveStateScopeCount
                if (r3 <= 0) goto Lb
                return
            Lb:
                r3 = -1
                r4 = r24
                int r4 = r4.put(r1, r2, r3)
                boolean r5 = r1 instanceof androidx.compose.runtime.DerivedState
                r6 = 2
                if (r5 == 0) goto L91
                if (r4 == r2) goto L91
                r2 = r1
                androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
                androidx.compose.runtime.DerivedState$Record r2 = r2.getCurrentRecord()
                java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r5 = r0.recordedDerivedStateValues
                java.lang.Object r7 = r2.getCurrentValue()
                r5.put(r1, r7)
                androidx.collection.ObjectIntMap r2 = r2.getDependencies()
                androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r5 = r0.dependencyToDerivedStates
                r5.removeScope(r1)
                java.lang.Object[] r7 = r2.keys
                long[] r2 = r2.metadata
                int r8 = r2.length
                int r8 = r8 - r6
                if (r8 < 0) goto L8f
                r10 = 0
            L3b:
                r11 = r2[r10]
                long r13 = ~r11
                r15 = 7
                long r13 = r13 << r15
                long r13 = r13 & r11
                r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r13 = r13 & r15
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 == 0) goto L89
                int r13 = r10 - r8
                int r13 = ~r13
                int r13 = r13 >>> 31
                r14 = 8
                int r13 = 8 - r13
                r15 = 0
            L55:
                if (r15 >= r13) goto L86
                r16 = 255(0xff, double:1.26E-321)
                long r16 = r11 & r16
                r18 = 128(0x80, double:6.32E-322)
                int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
                if (r16 >= 0) goto L7f
                int r16 = r10 << 3
                int r16 = r16 + r15
                r16 = r7[r16]
                r9 = r16
                androidx.compose.runtime.snapshots.StateObject r9 = (androidx.compose.runtime.snapshots.StateObject) r9
                boolean r3 = r9 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r3 == 0) goto L79
                r3 = r9
                androidx.compose.runtime.snapshots.StateObjectImpl r3 = (androidx.compose.runtime.snapshots.StateObjectImpl) r3
                int r14 = androidx.compose.runtime.snapshots.ReaderKind.m749constructorimpl(r6)
                r3.m751recordReadInh_f27i8$runtime_release(r14)
            L79:
                r5.add(r9, r1)
                r3 = 8
                goto L80
            L7f:
                r3 = r14
            L80:
                long r11 = r11 >> r3
                int r15 = r15 + 1
                r14 = r3
                r3 = -1
                goto L55
            L86:
                r3 = r14
                if (r13 != r3) goto L8f
            L89:
                if (r10 == r8) goto L8f
                int r10 = r10 + 1
                r3 = -1
                goto L3b
            L8f:
                r2 = -1
                goto L92
            L91:
                r2 = r3
            L92:
                if (r4 != r2) goto La9
                boolean r2 = r1 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r2 == 0) goto La2
                r2 = r1
                androidx.compose.runtime.snapshots.StateObjectImpl r2 = (androidx.compose.runtime.snapshots.StateObjectImpl) r2
                int r3 = androidx.compose.runtime.snapshots.ReaderKind.m749constructorimpl(r6)
                r2.m751recordReadInh_f27i8$runtime_release(r3)
            La2:
                androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object> r2 = r0.valueToScopes
                r3 = r23
                r2.add(r1, r3)
            La9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordRead(java.lang.Object, int, java.lang.Object, androidx.collection.MutableObjectIntMap):void");
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            Object obj = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object scope) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj = mutableObjectIntMap.keys[i5];
                            boolean z = mutableObjectIntMap.values[i5] != i;
                            if (z) {
                                removeObservation(scope, obj);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        public final void clearScopeObservations(Object scope) {
            MutableObjectIntMap<Object> mutableObjectIntMapRemove = this.scopeToValues.remove(scope);
            if (mutableObjectIntMapRemove == null) {
                return;
            }
            Object[] objArr = mutableObjectIntMapRemove.keys;
            int[] iArr = mutableObjectIntMapRemove.values;
            long[] jArr = mutableObjectIntMapRemove.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            int i5 = iArr[i4];
                            removeObservation(scope, obj);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            long[] jArr;
            int i;
            long[] jArr2;
            int i2;
            long j;
            int i3;
            long j2;
            int i4;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j3 = jArr3[i5];
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j3 & 255) < 128) {
                            int i9 = (i5 << 3) + i8;
                            Object obj = mutableScatterMap.keys[i9];
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i9];
                            Boolean boolInvoke = predicate.invoke(obj);
                            if (boolInvoke.booleanValue()) {
                                Object[] objArr = mutableObjectIntMap.keys;
                                int[] iArr = mutableObjectIntMap.values;
                                long[] jArr4 = mutableObjectIntMap.metadata;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                if (length2 >= 0) {
                                    i3 = i7;
                                    int i10 = 0;
                                    while (true) {
                                        long j5 = jArr4[i10];
                                        i2 = i5;
                                        j = j3;
                                        j2 = -9187201950435737472L;
                                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                            for (int i12 = 0; i12 < i11; i12++) {
                                                if ((j5 & 255) < 128) {
                                                    int i13 = (i10 << 3) + i12;
                                                    Object obj2 = objArr[i13];
                                                    int i14 = iArr[i13];
                                                    removeObservation(obj, obj2);
                                                }
                                                j5 >>= 8;
                                            }
                                            if (i11 != 8) {
                                                break;
                                            }
                                        }
                                        if (i10 == length2) {
                                            break;
                                        }
                                        i10++;
                                        i5 = i2;
                                        j3 = j;
                                    }
                                } else {
                                    i2 = i5;
                                    j = j3;
                                    i3 = i7;
                                    j2 = -9187201950435737472L;
                                }
                            } else {
                                jArr2 = jArr3;
                                i2 = i5;
                                j = j3;
                                i3 = i7;
                                j2 = j4;
                            }
                            if (boolInvoke.booleanValue()) {
                                mutableScatterMap.removeValueAt(i9);
                            }
                            i4 = 8;
                        } else {
                            jArr2 = jArr3;
                            i2 = i5;
                            j = j3;
                            i3 = i7;
                            j2 = j4;
                            i4 = i6;
                        }
                        j3 = j >> i4;
                        i8++;
                        i6 = i4;
                        j4 = j2;
                        jArr3 = jArr2;
                        i7 = i3;
                        i5 = i2;
                    }
                    jArr = jArr3;
                    int i15 = i5;
                    if (i7 != i6) {
                        return;
                    } else {
                        i = i15;
                    }
                } else {
                    jArr = jArr3;
                    i = i5;
                }
                if (i == length) {
                    return;
                }
                i5 = i + 1;
                jArr3 = jArr;
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if (!(value instanceof DerivedState) || this.valueToScopes.contains(value)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:120:0x0315 A[PHI: r20
  0x0315: PHI (r20v40 boolean) = (r20v39 boolean), (r20v41 boolean) binds: [B:110:0x02e5, B:119:0x0313] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0322  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x04c3  */
        /* JADX WARN: Removed duplicated region for block: B:221:0x05da A[PHI: r20
  0x05da: PHI (r20v11 boolean) = (r20v10 boolean), (r20v12 boolean) binds: [B:211:0x05aa, B:220:0x05d8] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0294 A[PHI: r20
  0x0294: PHI (r20v46 boolean) = (r20v45 boolean), (r20v47 boolean) binds: [B:87:0x0264, B:96:0x0292] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean recordInvalidation(java.util.Set<? extends java.lang.Object> r43) {
            /*
                Method dump skipped, instructions count: 1700
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordInvalidation(java.util.Set):boolean");
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            long[] jArr2;
            int i;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState);
            if (obj == null) {
                return;
            }
            if (obj instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr3 = mutableScatterSet.metadata;
                int length = jArr3.length - 2;
                if (length < 0) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    long j = jArr3[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                Object obj2 = objArr[(i2 << 3) + i5];
                                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj2);
                                jArr2 = jArr3;
                                if (mutableObjectIntMap2 == null) {
                                    mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                                    mutableScatterMap.set(obj2, mutableObjectIntMap);
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    mutableObjectIntMap = mutableObjectIntMap2;
                                }
                                recordRead(derivedState, id, obj2, mutableObjectIntMap);
                                i = 8;
                            } else {
                                jArr2 = jArr3;
                                i = i3;
                            }
                            j >>= i;
                            i5++;
                            i3 = i;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i4 != i3) {
                            return;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i2 == length) {
                        return;
                    }
                    i2++;
                    jArr3 = jArr;
                }
            } else {
                MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap3 == null) {
                    mutableObjectIntMap3 = new MutableObjectIntMap<>(0, 1, null);
                    mutableScatterMap.set(obj, mutableObjectIntMap3);
                    Unit unit2 = Unit.INSTANCE;
                }
                recordRead(derivedState, id, obj, mutableObjectIntMap3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void notifyInvalidatedScopes() {
            /*
                r17 = this;
                r0 = r17
                androidx.collection.MutableScatterSet<java.lang.Object> r1 = r0.invalidated
                kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r2 = r0.onChanged
                java.lang.Object[] r3 = r1.elements
                long[] r4 = r1.metadata
                int r5 = r4.length
                int r5 = r5 + (-2)
                if (r5 < 0) goto L49
                r6 = 0
                r7 = r6
            L11:
                r8 = r4[r7]
                long r10 = ~r8
                r12 = 7
                long r10 = r10 << r12
                long r10 = r10 & r8
                r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r10 = r10 & r12
                int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                if (r10 == 0) goto L44
                int r10 = r7 - r5
                int r10 = ~r10
                int r10 = r10 >>> 31
                r11 = 8
                int r10 = 8 - r10
                r12 = r6
            L2b:
                if (r12 >= r10) goto L42
                r13 = 255(0xff, double:1.26E-321)
                long r13 = r13 & r8
                r15 = 128(0x80, double:6.32E-322)
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 >= 0) goto L3e
                int r13 = r7 << 3
                int r13 = r13 + r12
                r13 = r3[r13]
                r2.invoke(r13)
            L3e:
                long r8 = r8 >> r11
                int r12 = r12 + 1
                goto L2b
            L42:
                if (r10 != r11) goto L49
            L44:
                if (r7 == r5) goto L49
                int r7 = r7 + 1
                goto L11
            L49:
                r1.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.notifyInvalidatedScopes():void");
        }
    }
}
