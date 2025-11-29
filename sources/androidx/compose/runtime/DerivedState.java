package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DerivedState.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001+B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJA\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "Lkotlin/Function0;", "calculation", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "policy", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "readable", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "", "forceDependencyReads", "currentRecord", "(Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;Landroidx/compose/runtime/snapshots/Snapshot;ZLkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "", "displayValue", "()Ljava/lang/String;", "Landroidx/compose/runtime/snapshots/StateRecord;", "current", "(Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "prependStateRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "toString", "Lkotlin/jvm/functions/Function0;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getValue", "()Ljava/lang/Object;", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.DerivedSnapshotState, reason: from toString */
/* loaded from: classes.dex */
final class DerivedState<T> extends StateObjectImpl implements androidx.compose.runtime.DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();
    private final SnapshotMutationPolicy<T> policy;

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedState(Function0<? extends T> function0, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    /* compiled from: DerivedState.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\r\b\u0007\u0018\u0000 3*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00132\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR(\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u0014\u00102\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010+¨\u00064"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "<init>", "()V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "assign", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "create", "()Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState;", "derivedState", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "", "isValid", "(Landroidx/compose/runtime/DerivedState;Landroidx/compose/runtime/snapshots/Snapshot;)Z", "", "readableHash", "(Landroidx/compose/runtime/DerivedState;Landroidx/compose/runtime/snapshots/Snapshot;)I", "validSnapshotId", "I", "getValidSnapshotId", "()I", "setValidSnapshotId", "(I)V", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "dependencies", "Landroidx/collection/ObjectIntMap;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", "", "result", "Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "setResultHash", "getCurrentValue", "currentValue", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        private ObjectIntMap<StateObject> dependencies = ObjectIntMapKt.emptyObjectIntMap();
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        /* compiled from: DerivedState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public ObjectIntMap<StateObject> getDependencies() {
            return this.dependencies;
        }

        public void setDependencies(ObjectIntMap<StateObject> objectIntMap) {
            this.dependencies = objectIntMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord resultRecord = (ResultRecord) value;
            setDependencies(resultRecord.getDependencies());
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean isValid(androidx.compose.runtime.DerivedState<?> r6, androidx.compose.runtime.snapshots.Snapshot r7) {
            /*
                r5 = this;
                java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                monitor-enter(r0)
                int r1 = r5.validSnapshotId     // Catch: java.lang.Throwable -> L1a
                int r2 = r7.getId()     // Catch: java.lang.Throwable -> L1a
                r3 = 1
                r4 = 0
                if (r1 != r2) goto L1c
                int r1 = r5.validSnapshotWriteCount     // Catch: java.lang.Throwable -> L1a
                int r2 = r7.getWriteCount()     // Catch: java.lang.Throwable -> L1a
                if (r1 == r2) goto L18
                goto L1c
            L18:
                r1 = r4
                goto L1d
            L1a:
                r6 = move-exception
                goto L4d
            L1c:
                r1 = r3
            L1d:
                monitor-exit(r0)
                java.lang.Object r0 = r5.result
                java.lang.Object r2 = androidx.compose.runtime.DerivedState.ResultRecord.Unset
                if (r0 == r2) goto L2f
                if (r1 == 0) goto L30
                int r0 = r5.resultHash
                int r6 = r5.readableHash(r6, r7)
                if (r0 != r6) goto L2f
                goto L30
            L2f:
                r3 = r4
            L30:
                if (r3 == 0) goto L4c
                if (r1 == 0) goto L4c
                java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                monitor-enter(r6)
                int r0 = r7.getId()     // Catch: java.lang.Throwable -> L49
                r5.validSnapshotId = r0     // Catch: java.lang.Throwable -> L49
                int r7 = r7.getWriteCount()     // Catch: java.lang.Throwable -> L49
                r5.validSnapshotWriteCount = r7     // Catch: java.lang.Throwable -> L49
                kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L49
                monitor-exit(r6)
                goto L4c
            L49:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            L4c:
                return r3
            L4d:
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedState.ResultRecord.isValid(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00a4 A[Catch: all -> 0x007c, LOOP:1: B:16:0x003c->B:40:0x00a4, LOOP_END, TryCatch #1 {all -> 0x007c, blocks: (B:13:0x002f, B:16:0x003c, B:18:0x004c, B:20:0x0058, B:22:0x0062, B:34:0x0098, B:25:0x0071, B:27:0x0075, B:31:0x0086, B:30:0x007e, B:42:0x00a8, B:40:0x00a4), top: B:64:0x002f }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00a0 A[EDGE_INSN: B:68:0x00a0->B:38:0x00a0 BREAK  A[LOOP:1: B:16:0x003c->B:40:0x00a4], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int readableHash(androidx.compose.runtime.DerivedState<?> r22, androidx.compose.runtime.snapshots.Snapshot r23) {
            /*
                Method dump skipped, instructions count: 221
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedState.ResultRecord.readableHash(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):int");
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> readable, Snapshot snapshot, boolean forceDependencyReads, Function0<? extends T> calculation) {
        Snapshot.Companion companion;
        SnapshotMutationPolicy<T> policy;
        int i;
        int i2;
        ResultRecord<T> resultRecord = readable;
        int i3 = 1;
        if (!resultRecord.isValid(this, snapshot)) {
            int i4 = 0;
            final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
            final IntRef intRef = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            if (intRef == null) {
                intRef = new IntRef(0);
                SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef);
            }
            final int element = intRef.getElement();
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            int size = mutableVectorDerivedStateObservers.getSize();
            if (size > 0) {
                DerivedStateObserver[] content = mutableVectorDerivedStateObservers.getContent();
                int i5 = 0;
                while (true) {
                    content[i5].start(this);
                    int i6 = i5 + 1;
                    if (i6 >= size) {
                        break;
                    }
                    i5 = i6;
                }
            }
            try {
                intRef.setElement(element + 1);
                Object objObserve = Snapshot.INSTANCE.observe(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$1$result$1
                    final /* synthetic */ DerivedState<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        if (obj == this.this$0) {
                            throw new IllegalStateException("A derived state calculation cannot read itself");
                        }
                        if (obj instanceof StateObject) {
                            int element2 = intRef.getElement();
                            MutableObjectIntMap<StateObject> mutableObjectIntMap2 = mutableObjectIntMap;
                            mutableObjectIntMap2.set(obj, Math.min(element2 - element, mutableObjectIntMap2.getOrDefault(obj, Integer.MAX_VALUE)));
                        }
                    }
                }, null, calculation);
                intRef.setElement(element);
                int size2 = mutableVectorDerivedStateObservers.getSize();
                if (size2 > 0) {
                    DerivedStateObserver[] content2 = mutableVectorDerivedStateObservers.getContent();
                    do {
                        content2[i4].done(this);
                        i4++;
                    } while (i4 < size2);
                }
                synchronized (SnapshotKt.getLock()) {
                    try {
                        companion = Snapshot.INSTANCE;
                        Snapshot current = companion.getCurrent();
                        if (readable.getResult() == ResultRecord.INSTANCE.getUnset() || (policy = getPolicy()) == 0 || !policy.equivalent(objObserve, readable.getResult())) {
                            resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                            resultRecord.setDependencies(mutableObjectIntMap);
                            resultRecord.setResultHash(resultRecord.readableHash(this, current));
                            resultRecord.setResult(objObserve);
                        } else {
                            resultRecord.setDependencies(mutableObjectIntMap);
                            resultRecord.setResultHash(resultRecord.readableHash(this, current));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                IntRef intRef2 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                if (intRef2 != null && intRef2.getElement() == 0) {
                    companion.notifyObjectsInitialized();
                    synchronized (SnapshotKt.getLock()) {
                        Snapshot current2 = companion.getCurrent();
                        resultRecord.setValidSnapshotId(current2.getId());
                        resultRecord.setValidSnapshotWriteCount(current2.getWriteCount());
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return resultRecord;
            } catch (Throwable th2) {
                int size3 = mutableVectorDerivedStateObservers.getSize();
                if (size3 > 0) {
                    DerivedStateObserver[] content3 = mutableVectorDerivedStateObservers.getContent();
                    do {
                        content3[i4].done(this);
                        i4++;
                    } while (i4 < size3);
                }
                throw th2;
            }
        }
        if (forceDependencyReads) {
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
            int size4 = mutableVectorDerivedStateObservers2.getSize();
            if (size4 > 0) {
                DerivedStateObserver[] content4 = mutableVectorDerivedStateObservers2.getContent();
                int i7 = 0;
                do {
                    content4[i7].start(this);
                    i7++;
                } while (i7 < size4);
            }
            try {
                ObjectIntMap<StateObject> dependencies = readable.getDependencies();
                IntRef intRef3 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                if (intRef3 == null) {
                    intRef3 = new IntRef(0);
                    SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef3);
                }
                int element2 = intRef3.getElement();
                Object[] objArr = dependencies.keys;
                int[] iArr = dependencies.values;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i8 = 0;
                    while (true) {
                        long j = jArr[i8];
                        long[] jArr2 = jArr;
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i9 = 8;
                            int i10 = 8 - ((~(i8 - length)) >>> 31);
                            int i11 = 0;
                            while (i11 < i10) {
                                if ((j & 255) < 128) {
                                    int i12 = (i8 << 3) + i11;
                                    StateObject stateObject = (StateObject) objArr[i12];
                                    intRef3.setElement(element2 + iArr[i12]);
                                    Function1<Object, Unit> readObserver = snapshot.getReadObserver();
                                    if (readObserver != null) {
                                        readObserver.invoke(stateObject);
                                    }
                                    i2 = 8;
                                } else {
                                    i2 = i9;
                                }
                                j >>= i2;
                                i11++;
                                i9 = i2;
                                i3 = 1;
                            }
                            int i13 = i9;
                            i = i3;
                            if (i10 != i13) {
                                break;
                            }
                        } else {
                            i = i3;
                        }
                        if (i8 == length) {
                            break;
                        }
                        i8 += i;
                        i3 = i;
                        jArr = jArr2;
                    }
                }
                intRef3.setElement(element2);
                Unit unit2 = Unit.INSTANCE;
                int size5 = mutableVectorDerivedStateObservers2.getSize();
                if (size5 > 0) {
                    DerivedStateObserver[] content5 = mutableVectorDerivedStateObservers2.getContent();
                    int i14 = 0;
                    do {
                        content5[i14].done(this);
                        i14++;
                    } while (i14 < size5);
                }
            } catch (Throwable th3) {
                int size6 = mutableVectorDerivedStateObservers2.getSize();
                if (size6 > 0) {
                    DerivedStateObserver[] content6 = mutableVectorDerivedStateObservers2.getContent();
                    int i15 = 0;
                    do {
                        content6[i15].done(this);
                        i15++;
                    } while (i15 < size6);
                }
                throw th3;
            }
        }
        return resultRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (ResultRecord) value;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Function1<Object, Unit> readObserver = companion.getCurrent().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot current = companion.getCurrent();
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        Snapshot current = Snapshot.INSTANCE.getCurrent();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, false, this.calculation);
    }

    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return String.valueOf(resultRecord.getResult());
        }
        return "<Not calculated>";
    }
}
