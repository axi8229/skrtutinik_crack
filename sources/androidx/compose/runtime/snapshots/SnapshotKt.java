package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u000f\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aI\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a1\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010#\u001a-\u0010$\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020\n2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b$\u0010%\u001a\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010(\u001a'\u0010*\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+\u001a'\u0010*\u001a\u00020\u00112\u0006\u0010-\u001a\u00020,2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010.\u001a3\u00100\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001c*\u00020,2\u0006\u0010/\u001a\u00028\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u00101\u001a#\u00100\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u000202¢\u0006\u0004\b0\u00104\u001a\u000f\u00106\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107\u001a\u0019\u00108\u001a\u0004\u0018\u00010,2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b8\u00109\u001a\u0017\u0010:\u001a\u00020\u00112\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b:\u0010;\u001a\u000f\u0010<\u001a\u00020\u0007H\u0002¢\u0006\u0004\b<\u0010#\u001a\u0017\u0010=\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b=\u0010>\u001a-\u0010?\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0001¢\u0006\u0004\b?\u0010@\u001a5\u0010B\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\n2\u0006\u0010A\u001a\u00028\u0000H\u0000¢\u0006\u0004\bB\u0010C\u001a-\u0010D\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0000¢\u0006\u0004\bD\u0010@\u001a-\u0010E\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\bE\u0010@\u001a%\u0010F\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u000202H\u0000¢\u0006\u0004\bF\u00104\u001a\u001f\u0010G\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0001¢\u0006\u0004\bG\u0010H\u001a5\u0010M\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0018\u00010L2\u0006\u0010\u000b\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u0002H\u0002¢\u0006\u0004\bM\u0010N\u001a\u000f\u0010O\u001a\u000205H\u0002¢\u0006\u0004\bO\u00107\u001a)\u0010P\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,2\u0006\u0010/\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\nH\u0001¢\u0006\u0004\bP\u0010Q\u001a!\u0010P\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,2\u0006\u0010/\u001a\u00028\u0000H\u0001¢\u0006\u0004\bP\u0010R\u001a#\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u0000H\u0000¢\u0006\u0004\bU\u0010V\" \u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X\"\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\n0Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[\" \u0010\\\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\\\u0010]\u0012\u0004\b`\u0010#\u001a\u0004\b^\u0010_\"\u0016\u0010a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010b\"\u0016\u0010c\u001a\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010d\"\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010g\"\u001a\u0010i\u001a\b\u0012\u0004\u0012\u0002020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010j\"4\u0010n\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0m\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070l0k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010o\"(\u0010p\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u000e0k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010o\"4\u0010u\u001a\"\u0012\f\u0012\n s*\u0004\u0018\u00010r0r0qj\u0010\u0012\f\u0012\n s*\u0004\u0018\u00010r0r`t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010v\" \u0010w\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bw\u0010x\u0012\u0004\bz\u0010#\u001a\u0004\by\u0010\f\"\u0016\u0010|\u001a\u00020{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}¨\u0006~"}, d2 = {"", "id", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "trackPinning", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)I", "handle", "", "releasePinningLocked", "(I)V", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "previousSnapshot", "Lkotlin/Function1;", "", "readObserver", "", "ownsPreviousSnapshot", "createTransparentSnapshotWithNoParentReadObserver", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;Z)Landroidx/compose/runtime/snapshots/Snapshot;", "parentObserver", "mergeReadObserver", "mergedReadObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)Lkotlin/jvm/functions/Function1;", "writeObserver", "mergedWriteObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "T", "previousGlobalSnapshot", "block", "takeNewGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "advanceGlobalSnapshot", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "()V", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "validateOpen", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "candidateSnapshot", "valid", "(IILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "Landroidx/compose/runtime/snapshots/StateRecord;", RemoteMessageConst.DATA, "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "r", "readable", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "", "readError", "()Ljava/lang/Void;", "usedLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "overwriteUnusedRecordsLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)Z", "checkAndOverwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "writableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "candidate", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "newWritableRecordLocked", "newOverwritableRecordLocked", "notifyWrite", "(Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateObject;)V", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "", "optimisticMerges", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Landroidx/compose/runtime/snapshots/MutableSnapshot;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Ljava/util/Map;", "reportReadonlySnapshotWrite", "current", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", RemoteMessageConst.FROM, "until", "addRange", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;II)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "emptyLambda", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/runtime/SnapshotThreadLocal;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "getLock$annotations", "openSnapshots", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "nextSnapshotId", "I", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "", "Lkotlin/Function2;", "", "applyObservers", "Ljava/util/List;", "globalWriteObservers", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "snapshotInitializer", "Landroidx/compose/runtime/snapshots/Snapshot;", "getSnapshotInitializer", "getSnapshotInitializer$annotations", "Landroidx/compose/runtime/AtomicInt;", "pendingApplyObserverCount", "Landroidx/compose/runtime/AtomicInt;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotKt {
    private static List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> applyObservers;
    private static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    private static final SnapshotWeakSet<StateObject> extraStateObjects;
    private static List<? extends Function1<Object, Unit>> globalWriteObservers;
    private static int nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final Function1<SnapshotIdSet, Unit> emptyLambda = new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SnapshotIdSet snapshotIdSet) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
            invoke2(snapshotIdSet);
            return Unit.INSTANCE;
        }
    };
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();
    private static final Object lock = new Object();

    public static final int trackPinning(int i, SnapshotIdSet snapshotIdSet) {
        int iAdd;
        int iLowest = snapshotIdSet.lowest(i);
        synchronized (getLock()) {
            iAdd = pinningTable.add(iLowest);
        }
        return iAdd;
    }

    public static final void releasePinningLocked(int i) {
        pinningTable.remove(i);
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        return snapshot == null ? currentGlobalSnapshot.get() : snapshot;
    }

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.INSTANCE;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 2;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet<>();
        applyObservers = CollectionsKt.emptyList();
        globalWriteObservers = CollectionsKt.emptyList();
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        snapshotInitializer = atomicReference.get();
        pendingApplyObserverCount = new AtomicInt(0);
    }

    static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1<Object, Unit> function1, boolean z) {
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (z2 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z2 ? (MutableSnapshot) snapshot : null, function1, null, false, z);
        }
        return new TransparentObserverSnapshot(snapshot, function1, false, z);
    }

    static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return mergedReadObserver(function1, function12, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedReadObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12, boolean z) {
        if (!z) {
            function12 = null;
        }
        if (function1 == null || function12 == null || function1 == function12) {
            return function1 == null ? function12 : function1;
        }
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedWriteObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12) {
        if (function1 == null || function12 == null || function1 == function12) {
            return function1 == null ? function12 : function1;
        }
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.mergedWriteObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    public static final Object getLock() {
        return lock;
    }

    public static final <T extends StateRecord> T newWritableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        T t2;
        synchronized (getLock()) {
            t2 = (T) newWritableRecordLocked(t, stateObject, snapshot);
        }
        return t2;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T tInvoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i = nextSnapshotId;
            nextSnapshotId = i + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i);
            Unit unit = Unit.INSTANCE;
        }
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> T advanceGlobalSnapshot(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.snapshots.SnapshotIdSet, ? extends T> r17) {
        /*
            r0 = 1
            androidx.compose.runtime.snapshots.Snapshot r1 = androidx.compose.runtime.snapshots.SnapshotKt.snapshotInitializer
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            androidx.compose.runtime.snapshots.GlobalSnapshot r1 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r1
            java.lang.Object r1 = getLock()
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicReference<androidx.compose.runtime.snapshots.GlobalSnapshot> r2 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> L25
            r3 = r2
            androidx.compose.runtime.snapshots.GlobalSnapshot r3 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r3     // Catch: java.lang.Throwable -> L25
            androidx.collection.MutableScatterSet r3 = r3.getModified$runtime_release()     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L28
            androidx.compose.runtime.AtomicInt r4 = androidx.compose.runtime.snapshots.SnapshotKt.pendingApplyObserverCount     // Catch: java.lang.Throwable -> L25
            r4.add(r0)     // Catch: java.lang.Throwable -> L25
            goto L28
        L25:
            r0 = move-exception
            goto Lb1
        L28:
            r4 = r2
            androidx.compose.runtime.snapshots.Snapshot r4 = (androidx.compose.runtime.snapshots.Snapshot) r4     // Catch: java.lang.Throwable -> L25
            r5 = r17
            java.lang.Object r4 = takeNewGlobalSnapshot(r4, r5)     // Catch: java.lang.Throwable -> L25
            monitor-exit(r1)
            r1 = 0
            if (r3 == 0) goto L5c
            r5 = -1
            java.util.List<? extends kotlin.jvm.functions.Function2<? super java.util.Set<? extends java.lang.Object>, ? super androidx.compose.runtime.snapshots.Snapshot, kotlin.Unit>> r6 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch: java.lang.Throwable -> L4e
            int r7 = r6.size()     // Catch: java.lang.Throwable -> L4e
            r8 = r1
        L3d:
            if (r8 >= r7) goto L50
            java.lang.Object r9 = r6.get(r8)     // Catch: java.lang.Throwable -> L4e
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9     // Catch: java.lang.Throwable -> L4e
            java.util.Set r10 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r3)     // Catch: java.lang.Throwable -> L4e
            r9.invoke(r10, r2)     // Catch: java.lang.Throwable -> L4e
            int r8 = r8 + r0
            goto L3d
        L4e:
            r0 = move-exception
            goto L56
        L50:
            androidx.compose.runtime.AtomicInt r2 = androidx.compose.runtime.snapshots.SnapshotKt.pendingApplyObserverCount
            r2.add(r5)
            goto L5c
        L56:
            androidx.compose.runtime.AtomicInt r1 = androidx.compose.runtime.snapshots.SnapshotKt.pendingApplyObserverCount
            r1.add(r5)
            throw r0
        L5c:
            java.lang.Object r2 = getLock()
            monitor-enter(r2)
            checkAndOverwriteUnusedRecordsLocked()     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto Lad
            java.lang.Object[] r5 = r3.elements     // Catch: java.lang.Throwable -> La0
            long[] r3 = r3.metadata     // Catch: java.lang.Throwable -> La0
            int r6 = r3.length     // Catch: java.lang.Throwable -> La0
            int r6 = r6 + (-2)
            if (r6 < 0) goto Lab
            r7 = r1
        L70:
            r8 = r3[r7]     // Catch: java.lang.Throwable -> La0
            long r10 = ~r8     // Catch: java.lang.Throwable -> La0
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto La7
            int r10 = r7 - r6
            int r10 = ~r10     // Catch: java.lang.Throwable -> La0
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r1
        L8a:
            if (r12 >= r10) goto La5
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.32E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto La2
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r5[r13]     // Catch: java.lang.Throwable -> La0
            androidx.compose.runtime.snapshots.StateObject r13 = (androidx.compose.runtime.snapshots.StateObject) r13     // Catch: java.lang.Throwable -> La0
            processForUnusedRecordsLocked(r13)     // Catch: java.lang.Throwable -> La0
            goto La2
        La0:
            r0 = move-exception
            goto Laf
        La2:
            long r8 = r8 >> r11
            int r12 = r12 + r0
            goto L8a
        La5:
            if (r10 != r11) goto Lab
        La7:
            if (r7 == r6) goto Lab
            int r7 = r7 + r0
            goto L70
        Lab:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La0
        Lad:
            monitor-exit(r2)
            return r4
        Laf:
            monitor-exit(r2)
            throw r0
        Lb1:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotKt.advanceGlobalSnapshot(kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.advanceGlobalSnapshot.3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SnapshotIdSet snapshotIdSet) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
                invoke2(snapshotIdSet);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(final Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (T) advanceGlobalSnapshot(new Function1<SnapshotIdSet, T>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.takeNewSnapshot.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
            @Override // kotlin.jvm.functions.Function1
            public final Snapshot invoke(SnapshotIdSet snapshotIdSet) {
                Snapshot snapshot = (Snapshot) function1.invoke(snapshotIdSet);
                synchronized (SnapshotKt.getLock()) {
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getId());
                    Unit unit = Unit.INSTANCE;
                }
                return snapshot;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        int iLowestOrDefault;
        if (openSnapshots.get(snapshot.getId())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Snapshot is not open: id=");
        sb.append(snapshot.getId());
        sb.append(", disposed=");
        sb.append(snapshot.getDisposed());
        sb.append(", applied=");
        MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
        sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.getApplied()) : "read-only");
        sb.append(", lowestPin=");
        synchronized (getLock()) {
            iLowestOrDefault = pinningTable.lowestOrDefault(-1);
        }
        sb.append(iLowestOrDefault);
        throw new IllegalStateException(sb.toString().toString());
    }

    private static final boolean valid(int i, int i2, SnapshotIdSet snapshotIdSet) {
        return (i2 == 0 || i2 > i || snapshotIdSet.get(i2)) ? false : true;
    }

    private static final boolean valid(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        return valid(i, stateRecord.getSnapshotId(), snapshotIdSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t, int i, SnapshotIdSet snapshotIdSet) {
        T t2 = null;
        while (t != null) {
            if (valid(t, i, snapshotIdSet) && (t2 == null || t2.getSnapshotId() < t.getSnapshotId())) {
                t2 = t;
            }
            t = (T) t.getNext();
        }
        if (t2 != null) {
            return t2;
        }
        return null;
    }

    public static final <T extends StateRecord> T readable(T t, StateObject stateObject) {
        T t2;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        Function1<Object, Unit> readObserver = current.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        T t3 = (T) readable(t, current.getId(), current.getInvalid());
        if (t3 != null) {
            return t3;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            t2 = (T) readable(firstStateRecord, current2.getId(), current2.getInvalid());
            if (t2 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.INSTANCE.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
            if (firstStateRecord.getSnapshotId() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, iLowestOrDefault, empty)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId() < stateRecord.getSnapshotId() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord firstStateRecord = null;
        int i = 0;
        for (StateRecord firstStateRecord2 = stateObject.getFirstStateRecord(); firstStateRecord2 != null; firstStateRecord2 = firstStateRecord2.getNext()) {
            int snapshotId$runtime_release = firstStateRecord2.getSnapshotId();
            if (snapshotId$runtime_release != 0) {
                if (snapshotId$runtime_release >= iLowestOrDefault) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord2;
                } else {
                    if (firstStateRecord2.getSnapshotId() < stateRecord2.getSnapshotId()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord2;
                    } else {
                        stateRecord = firstStateRecord2;
                    }
                    if (firstStateRecord == null) {
                        firstStateRecord = stateObject.getFirstStateRecord();
                        StateRecord stateRecord3 = firstStateRecord;
                        while (true) {
                            if (firstStateRecord == null) {
                                firstStateRecord = stateRecord3;
                                break;
                            }
                            if (firstStateRecord.getSnapshotId() >= iLowestOrDefault) {
                                break;
                            }
                            if (stateRecord3.getSnapshotId() < firstStateRecord.getSnapshotId()) {
                                stateRecord3 = firstStateRecord;
                            }
                            firstStateRecord = firstStateRecord.getNext();
                        }
                    }
                    stateRecord2.setSnapshotId$runtime_release(0);
                    stateRecord2.assign(firstStateRecord);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
        int size$runtime_release = snapshotWeakSet.getSize();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference<StateObject> weakReference = snapshotWeakSet.getValues$runtime_release()[i];
            StateObject stateObject = weakReference != null ? weakReference.get() : null;
            if (stateObject != null && overwriteUnusedRecordsLocked(stateObject)) {
                if (i2 != i) {
                    snapshotWeakSet.getValues$runtime_release()[i2] = weakReference;
                    snapshotWeakSet.getHashes()[i2] = snapshotWeakSet.getHashes()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size$runtime_release; i3++) {
            snapshotWeakSet.getValues$runtime_release()[i3] = null;
            snapshotWeakSet.getHashes()[i3] = 0;
        }
        if (i2 != size$runtime_release) {
            snapshotWeakSet.setSize$runtime_release(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    public static final <T extends StateRecord> T writableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        T t2;
        if (snapshot.getReadOnly()) {
            snapshot.mo748recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        T t3 = (T) readable(t, id, snapshot.getInvalid());
        if (t3 == null) {
            readError();
            throw new KotlinNothingValueException();
        }
        if (t3.getSnapshotId() == snapshot.getId()) {
            return t3;
        }
        synchronized (getLock()) {
            t2 = (T) readable(stateObject.getFirstStateRecord(), id, snapshot.getInvalid());
            if (t2 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
            if (t2.getSnapshotId() != id) {
                t2 = (T) newWritableRecordLocked(t2, stateObject, snapshot);
            }
        }
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (t3.getSnapshotId() != 1) {
            snapshot.mo748recordModified$runtime_release(stateObject);
        }
        return t2;
    }

    public static final <T extends StateRecord> T overwritableRecord(T t, StateObject stateObject, Snapshot snapshot, T t2) {
        T t3;
        if (snapshot.getReadOnly()) {
            snapshot.mo748recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        if (t2.getSnapshotId() == id) {
            return t2;
        }
        synchronized (getLock()) {
            t3 = (T) newOverwritableRecordLocked(t, stateObject);
        }
        t3.setSnapshotId$runtime_release(id);
        if (t2.getSnapshotId() != 1) {
            snapshot.mo748recordModified$runtime_release(stateObject);
        }
        return t3;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T t, StateObject stateObject, Snapshot snapshot) {
        T t2 = (T) newOverwritableRecordLocked(t, stateObject);
        t2.assign(t);
        t2.setSnapshotId$runtime_release(snapshot.getId());
        return t2;
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T t, StateObject stateObject) {
        T t2 = (T) usedLocked(stateObject);
        if (t2 != null) {
            t2.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return t2;
        }
        T t3 = (T) t.create();
        t3.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        t3.setNext$runtime_release(stateObject.getFirstStateRecord());
        Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$16");
        stateObject.prependStateRecord(t3);
        Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return t3;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount() + 1);
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        int i;
        HashMap map;
        long[] jArr2;
        int i2;
        HashMap map2;
        int i3;
        StateRecord stateRecord;
        MutableScatterSet<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        HashMap map3 = null;
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetOr = mutableSnapshot2.getInvalid().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds());
        Object[] objArr = modified$runtime_release.elements;
        long[] jArr3 = modified$runtime_release.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            HashMap map4 = null;
            int i4 = 0;
            while (true) {
                long j = jArr3[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j) < 128) {
                            StateObject stateObject = (StateObject) objArr[(i4 << 3) + i7];
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            StateRecord stateRecord2 = readable(firstStateRecord, id, snapshotIdSet);
                            if (stateRecord2 == null || (stateRecord = readable(firstStateRecord, id, snapshotIdSetOr)) == null || Intrinsics.areEqual(stateRecord2, stateRecord)) {
                                jArr2 = jArr3;
                                i2 = id;
                            } else {
                                jArr2 = jArr3;
                                i2 = id;
                                StateRecord stateRecord3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid());
                                if (stateRecord3 == null) {
                                    readError();
                                    throw new KotlinNothingValueException();
                                }
                                StateRecord stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                                if (stateRecordMergeRecords == null) {
                                    return null;
                                }
                                if (map4 == null) {
                                    map4 = new HashMap();
                                }
                                map4.put(stateRecord2, stateRecordMergeRecords);
                                map4 = map4;
                            }
                            map2 = null;
                            i3 = 8;
                        } else {
                            jArr2 = jArr3;
                            i2 = id;
                            map2 = map3;
                            i3 = i5;
                        }
                        j >>= i3;
                        i7++;
                        map3 = map2;
                        i5 = i3;
                        jArr3 = jArr2;
                        id = i2;
                    }
                    jArr = jArr3;
                    i = id;
                    map = map3;
                    if (i6 != i5) {
                        return map4;
                    }
                } else {
                    jArr = jArr3;
                    i = id;
                    map = map3;
                }
                if (i4 == length) {
                    map3 = map4;
                    break;
                }
                i4++;
                map3 = map;
                jArr3 = jArr;
                id = i;
            }
        }
        return map3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    public static final <T extends StateRecord> T current(T t, Snapshot snapshot) {
        T t2 = (T) readable(t, snapshot.getId(), snapshot.getInvalid());
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord> T current(T t) {
        T t2;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        T t3 = (T) readable(t, current.getId(), current.getInvalid());
        if (t3 != null) {
            return t3;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            t2 = (T) readable(t, current2.getId(), current2.getInvalid());
        }
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i, int i2) {
        while (i < i2) {
            snapshotIdSet = snapshotIdSet.set(i);
            i++;
        }
        return snapshotIdSet;
    }
}
