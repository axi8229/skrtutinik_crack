package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\n\b\u0017\u0018\u0000 n2\u00020\u0001:\u0001nBE\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ?\u0010\u0012\u001a\u00020\u00002\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ%\u0010\u0018\u001a\u00020\u00012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010!\u001a\u00020\bH\u0010¢\u0006\u0004\b \u0010\u000eJ\u000f\u0010#\u001a\u00020\bH\u0010¢\u0006\u0004\b\"\u0010\u000eJ\u000f\u0010%\u001a\u00020\bH\u0010¢\u0006\u0004\b$\u0010\u000eJ5\u0010-\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00022\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010*\u001a\u00020\u0004H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010/\u001a\u00020\bH\u0000¢\u0006\u0004\b.\u0010\u000eJ\u0017\u00102\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b3\u00101J\u0017\u00109\u001a\u00020\b2\u0006\u00106\u001a\u000205H\u0000¢\u0006\u0004\b7\u00108J\u0017\u0010=\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0004H\u0000¢\u0006\u0004\b;\u0010<J\u0017\u0010B\u001a\u00020\b2\u0006\u0010?\u001a\u00020>H\u0010¢\u0006\u0004\b@\u0010AR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\t\u0010C\u001a\u0004\bD\u0010ER(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\n\u0010C\u001a\u0004\bF\u0010ER\"\u0010G\u001a\u00020\u00028\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u00101R:\u0010N\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010L2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010L8\u0010@VX\u0090\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR*\u0010U\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010T8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010[\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010<R\"\u0010`\u001a\u0002058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u00108R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010HR\"\u0010f\u001a\u00020e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010m\u001a\u00020e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010i¨\u0006o"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "id", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "Lkotlin/Function1;", "", "", "readObserver", "writeObserver", "<init>", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "validateNotApplied", "()V", "validateNotAppliedOrPinned", "abandon", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "apply", "()Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "takeNestedSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "nestedActivated$runtime_release", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "nestedActivated", "nestedDeactivated$runtime_release", "nestedDeactivated", "notifyObjectsInitialized$runtime_release", "notifyObjectsInitialized", "closeLocked$runtime_release", "closeLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "snapshotId", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "optimisticMerges", "invalidSnapshots", "innerApplyLocked$runtime_release", "(ILjava/util/Map;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "innerApplyLocked", "advance$runtime_release", "advance", "recordPrevious$runtime_release", "(I)V", "recordPrevious", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshot", "", "handles", "recordPreviousPinnedSnapshots$runtime_release", "([I)V", "recordPreviousPinnedSnapshots", "snapshots", "recordPreviousList$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "recordPreviousList", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "recordModified$runtime_release", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "recordModified", "Lkotlin/jvm/functions/Function1;", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "getWriteObserver$runtime_release", "writeCount", "I", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "Landroidx/collection/MutableScatterSet;", "<set-?>", "modified", "Landroidx/collection/MutableScatterSet;", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "", "merged", "Ljava/util/List;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "previousIds", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "previousPinnedSnapshots", "[I", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "", "applied", "Z", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "getReadOnly", "readOnly", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private MutableScatterSet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime_release */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public MutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(i, snapshotIdSet, null);
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        NestedMutableSnapshot nestedMutableSnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
            SnapshotIdSet invalid = getInvalid();
            setInvalid$runtime_release(invalid.set(i));
            nestedMutableSnapshot = new NestedMutableSnapshot(i, SnapshotKt.addRange(invalid, getId() + 1, i), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null), SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release()), this);
        }
        if (!getApplied() && !getDisposed()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                int i2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i2 + 1;
                setId$runtime_release(i2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
        }
        return nestedMutableSnapshot;
    }

    public SnapshotApplyResult apply() throws Throwable {
        MutableScatterSet<StateObject> modified$runtime_release;
        int i;
        MutableScatterSet<StateObject> modified$runtime_release2 = getModified$runtime_release();
        Map<StateRecord, ? extends StateRecord> mapOptimisticMerges = modified$runtime_release2 != null ? SnapshotKt.optimisticMerges((MutableSnapshot) SnapshotKt.currentGlobalSnapshot.get(), this, SnapshotKt.openSnapshots.clear(((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getId())) : null;
        List listEmptyList = CollectionsKt.emptyList();
        synchronized (SnapshotKt.getLock()) {
            try {
                SnapshotKt.validateOpen(this);
                if (modified$runtime_release2 == null || modified$runtime_release2.get_size() == 0) {
                    closeLocked$runtime_release();
                    GlobalSnapshot globalSnapshot = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot.getModified$runtime_release();
                    if (modified$runtime_release == null || !modified$runtime_release.isNotEmpty()) {
                        modified$runtime_release = null;
                    } else {
                        listEmptyList = SnapshotKt.applyObservers;
                    }
                } else {
                    GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotApplyResult snapshotApplyResultInnerApplyLocked$runtime_release = innerApplyLocked$runtime_release(SnapshotKt.nextSnapshotId, mapOptimisticMerges, SnapshotKt.openSnapshots.clear(globalSnapshot2.getId()));
                    if (!Intrinsics.areEqual(snapshotApplyResultInnerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                        return snapshotApplyResultInnerApplyLocked$runtime_release;
                    }
                    closeLocked$runtime_release();
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot2, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot2.getModified$runtime_release();
                    setModified(null);
                    globalSnapshot2.setModified(null);
                    listEmptyList = SnapshotKt.applyObservers;
                }
                Unit unit = Unit.INSTANCE;
                this.applied = true;
                if (modified$runtime_release != null) {
                    Set setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release);
                    if (!setWrapIntoSet.isEmpty()) {
                        int size = listEmptyList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ((Function2) listEmptyList.get(i2)).invoke(setWrapIntoSet, this);
                        }
                    }
                }
                if (modified$runtime_release2 != null && modified$runtime_release2.isNotEmpty()) {
                    Set setWrapIntoSet2 = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release2);
                    int size2 = listEmptyList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((Function2) listEmptyList.get(i3)).invoke(setWrapIntoSet2, this);
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    try {
                        releasePinnedSnapshotsForCloseLocked$runtime_release();
                        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                        if (modified$runtime_release != null) {
                            try {
                                Object[] objArr = modified$runtime_release.elements;
                                long[] jArr = modified$runtime_release.metadata;
                                int length = jArr.length - 2;
                                if (length >= 0) {
                                    int i4 = 0;
                                    while (true) {
                                        long j = jArr[i4];
                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i5 = 8 - ((~(i4 - length)) >>> 31);
                                            for (int i6 = 0; i6 < i5; i6++) {
                                                if ((j & 255) < 128) {
                                                    SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr[(i4 << 3) + i6]);
                                                }
                                                j >>= 8;
                                            }
                                            if (i5 != 8) {
                                                break;
                                            }
                                        }
                                        if (i4 == length) {
                                            break;
                                        }
                                        i4++;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        if (modified$runtime_release2 != null) {
                            Object[] objArr2 = modified$runtime_release2.elements;
                            long[] jArr2 = modified$runtime_release2.metadata;
                            int length2 = jArr2.length - 2;
                            if (length2 >= 0) {
                                int i7 = 0;
                                while (true) {
                                    long j2 = jArr2[i7];
                                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i8 = 8 - ((~(i7 - length2)) >>> 31);
                                        for (int i9 = 0; i9 < i8; i9++) {
                                            if ((j2 & 255) < 128) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr2[(i7 << 3) + i9]);
                                            }
                                            j2 >>= 8;
                                        }
                                        i = 1;
                                        if (i8 != 8) {
                                            break;
                                        }
                                    } else {
                                        i = 1;
                                    }
                                    if (i7 == length2) {
                                        break;
                                    }
                                    i7 += i;
                                }
                            }
                        }
                        List<? extends StateObject> list = this.merged;
                        if (list != null) {
                            int size3 = list.size();
                            for (int i10 = 0; i10 < size3; i10++) {
                                SnapshotKt.processForUnusedRecordsLocked(list.get(i10));
                            }
                        }
                        this.merged = null;
                        Unit unit2 = Unit.INSTANCE;
                        return SnapshotApplyResult.Success.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        mo747nestedDeactivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid(), id + 1, i), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null), this);
        }
        if (!getApplied() && !getDisposed()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                int i2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i2 + 1;
                setId$runtime_release(i2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo746nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo747nestedDeactivated$runtime_release(Snapshot snapshot) {
        if (!(this.snapshots > 0)) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (!this.applied || ((Snapshot) this).pinningTrackingHandle >= 0) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void abandon() {
        /*
            r15 = this;
            androidx.collection.MutableScatterSet r0 = r15.getModified$runtime_release()
            if (r0 == 0) goto L77
            r15.validateNotApplied()
            r1 = 0
            r15.setModified(r1)
            int r1 = r15.getId()
            java.lang.Object[] r2 = r0.elements
            long[] r0 = r0.metadata
            int r3 = r0.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L77
            r4 = 0
            r5 = r4
        L1c:
            r6 = r0[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L72
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L36:
            if (r10 >= r8) goto L70
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.32E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L6c
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.runtime.snapshots.StateObject r11 = (androidx.compose.runtime.snapshots.StateObject) r11
            androidx.compose.runtime.snapshots.StateRecord r11 = r11.getFirstStateRecord()
        L4c:
            if (r11 == 0) goto L6c
            int r12 = r11.getSnapshotId()
            if (r12 == r1) goto L64
            androidx.compose.runtime.snapshots.SnapshotIdSet r12 = r15.previousIds
            int r13 = r11.getSnapshotId()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            boolean r12 = kotlin.collections.CollectionsKt.contains(r12, r13)
            if (r12 == 0) goto L67
        L64:
            r11.setSnapshotId$runtime_release(r4)
        L67:
            androidx.compose.runtime.snapshots.StateRecord r11 = r11.getNext()
            goto L4c
        L6c:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L36
        L70:
            if (r8 != r9) goto L77
        L72:
            if (r5 == r3) goto L77
            int r5 = r5 + 1
            goto L1c
        L77:
            r15.closeAndReleasePinning$runtime_release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.abandon():void");
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        MutableScatterSet<StateObject> mutableScatterSet;
        List<? extends StateObject> listPlus;
        SnapshotIdSet snapshotIdSet;
        Object[] objArr;
        long[] jArr;
        int i;
        SnapshotIdSet snapshotIdSet2;
        MutableScatterSet<StateObject> mutableScatterSet2;
        Object[] objArr2;
        long[] jArr2;
        int i2;
        StateRecord stateRecord;
        StateRecord stateRecordMergeRecords;
        SnapshotIdSet snapshotIdSetOr = getInvalid().set(getId()).or(this.previousIds);
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        Object[] objArr3 = modified$runtime_release.elements;
        long[] jArr3 = modified$runtime_release.metadata;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        if (length >= 0) {
            listPlus = null;
            int i3 = 0;
            while (true) {
                long j = jArr3[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            StateObject stateObject = (StateObject) objArr3[(i3 << 3) + i6];
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            mutableScatterSet2 = modified$runtime_release;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            StateRecord stateRecord2 = SnapshotKt.readable(firstStateRecord, snapshotId, invalidSnapshots);
                            if (stateRecord2 == null || (stateRecord = SnapshotKt.readable(firstStateRecord, getId(), snapshotIdSetOr)) == null) {
                                snapshotIdSet2 = snapshotIdSetOr;
                            } else {
                                snapshotIdSet2 = snapshotIdSetOr;
                                if (stateRecord.getSnapshotId() != 1 && !Intrinsics.areEqual(stateRecord2, stateRecord)) {
                                    StateRecord stateRecord3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid());
                                    if (stateRecord3 == null) {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (optimisticMerges == null || (stateRecordMergeRecords = optimisticMerges.get(stateRecord2)) == null) {
                                        stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                                    }
                                    if (stateRecordMergeRecords == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!Intrinsics.areEqual(stateRecordMergeRecords, stateRecord3)) {
                                        if (Intrinsics.areEqual(stateRecordMergeRecords, stateRecord2)) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(TuplesKt.to(stateObject, stateRecord2.create()));
                                            if (listPlus == null) {
                                                listPlus = new ArrayList<>();
                                            }
                                            listPlus.add(stateObject);
                                        } else {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(!Intrinsics.areEqual(stateRecordMergeRecords, stateRecord) ? TuplesKt.to(stateObject, stateRecordMergeRecords) : TuplesKt.to(stateObject, stateRecord.create()));
                                        }
                                    }
                                }
                            }
                            i2 = 8;
                        } else {
                            snapshotIdSet2 = snapshotIdSetOr;
                            mutableScatterSet2 = modified$runtime_release;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i2 = i4;
                        }
                        j >>= i2;
                        i6++;
                        i4 = i2;
                        objArr3 = objArr2;
                        jArr3 = jArr2;
                        modified$runtime_release = mutableScatterSet2;
                        snapshotIdSetOr = snapshotIdSet2;
                    }
                    snapshotIdSet = snapshotIdSetOr;
                    mutableScatterSet = modified$runtime_release;
                    objArr = objArr3;
                    jArr = jArr3;
                    i = 1;
                    if (i5 != i4) {
                        break;
                    }
                } else {
                    snapshotIdSet = snapshotIdSetOr;
                    mutableScatterSet = modified$runtime_release;
                    objArr = objArr3;
                    jArr = jArr3;
                    i = 1;
                }
                if (i3 == length) {
                    break;
                }
                i3 += i;
                objArr3 = objArr;
                jArr3 = jArr;
                modified$runtime_release = mutableScatterSet;
                snapshotIdSetOr = snapshotIdSet;
            }
        } else {
            mutableScatterSet = modified$runtime_release;
            listPlus = null;
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                Pair pair = (Pair) arrayList.get(i7);
                StateObject stateObject2 = (StateObject) pair.component1();
                StateRecord stateRecord4 = (StateRecord) pair.component2();
                stateRecord4.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord4.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord4);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (listPlus != null) {
            int size2 = listPlus.size();
            for (int i8 = 0; i8 < size2; i8++) {
                mutableScatterSet.remove(listPlus.get(i8));
            }
            List<? extends StateObject> list = this.merged;
            if (list != null) {
                listPlus = CollectionsKt.plus((Collection) list, (Iterable) listPlus);
            }
            this.merged = listPlus;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        if (handles.length == 0) {
            return;
        }
        int[] iArr = this.previousPinnedSnapshots;
        if (iArr.length != 0) {
            handles = ArraysKt.plus(iArr, handles);
        }
        this.previousPinnedSnapshots = handles;
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo748recordModified$runtime_release(StateObject state) {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = ScatterSetKt.mutableScatterSetOf();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteCount$runtime_release, reason: from getter */
    public int getWriteCount() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(MutableScatterSet<StateObject> mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    /* renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    /* renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    /* renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    /* compiled from: Snapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void recordPrevious$runtime_release(int id) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }
}
