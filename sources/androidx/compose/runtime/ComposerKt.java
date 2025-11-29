package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0001\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a/\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0011\u001a\u00020\t*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a-\u0010\u0018\u001a\u00020\t*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\"\u0004\b\u0000\u0010\u001a\"\b\b\u0001\u0010\u001b*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a!\u0010#\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010$\u001a!\u0010%\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010$\u001a3\u0010)\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b)\u0010*\u001a+\u0010-\u001a\u0004\u0018\u00010!*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010.\u001a#\u0010/\u001a\u0004\u0018\u00010!*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u00102\u001a/\u00103\u001a\b\u0012\u0004\u0012\u00020!0 *\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u00104\u001a\u0013\u00105\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b5\u00106\u001a\u0013\u00107\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0004\b7\u00108\u001a#\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160<*\u0002092\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b=\u0010>\u001a#\u0010A\u001a\u00020\u0003*\u00020?2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010B\u001a+\u0010F\u001a\u00020\u0003*\u00020?2\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002¢\u0006\u0004\bF\u0010G\u001a\u0017\u0010I\u001a\u00020\t2\u0006\u0010H\u001a\u00020\u0000H\u0000¢\u0006\u0004\bI\u0010J\u001a\u0017\u0010M\u001a\u00020L2\u0006\u0010K\u001a\u00020\u0007H\u0000¢\u0006\u0004\bM\u0010N\u001a\u0017\u0010O\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0007H\u0000¢\u0006\u0004\bO\u0010P\" \u0010Q\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bQ\u0010R\u0012\u0004\bU\u0010\r\u001a\u0004\bS\u0010T\" \u0010V\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bV\u0010R\u0012\u0004\bX\u0010\r\u001a\u0004\bW\u0010T\" \u0010Y\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bY\u0010R\u0012\u0004\b[\u0010\r\u001a\u0004\bZ\u0010T\" \u0010\\\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\\\u0010R\u0012\u0004\b^\u0010\r\u001a\u0004\b]\u0010T\" \u0010_\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b_\u0010R\u0012\u0004\ba\u0010\r\u001a\u0004\b`\u0010T\" \u0010b\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bb\u0010R\u0012\u0004\bd\u0010\r\u001a\u0004\bc\u0010T\"\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020!0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010g\"\u0018\u0010h\u001a\u00020\u0000*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bh\u0010i\"\u0018\u0010h\u001a\u00020\u0000*\u00020?8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bh\u0010j\"\u0018\u0010n\u001a\u00020\u0016*\u00020k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010m¨\u0006o"}, d2 = {"", "isTraceInProgress", "()Z", "", "key", "dirty1", "dirty2", "", "info", "", "traceEventStart", "(IIILjava/lang/String;)V", "traceEventEnd", "()V", "Landroidx/compose/runtime/SlotWriter;", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "removeCurrentGroup", "(Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "deactivateCurrentGroup", "group", "index", "", RemoteMessageConst.DATA, "removeData", "(Landroidx/compose/runtime/SlotWriter;IILjava/lang/Object;)V", "K", "V", "initialCapacity", "Landroidx/compose/runtime/MutableScatterMultiMap;", "multiMap", "(I)Landroidx/collection/MutableScatterMap;", "", "Landroidx/compose/runtime/Invalidation;", "location", "findLocation", "(Ljava/util/List;I)I", "findInsertLocation", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "instance", "insertIfMissing", "(Ljava/util/List;ILandroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)V", "start", "end", "firstInRange", "(Ljava/util/List;II)Landroidx/compose/runtime/Invalidation;", "removeLocation", "(Ljava/util/List;I)Landroidx/compose/runtime/Invalidation;", "removeRange", "(Ljava/util/List;II)V", "filterToRange", "(Ljava/util/List;II)Ljava/util/List;", "asInt", "(Z)I", "asBool", "(I)Z", "Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/Anchor;", "anchor", "", "collectNodesFrom", "(Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/Anchor;)Ljava/util/List;", "Landroidx/compose/runtime/SlotReader;", "root", "distanceFrom", "(Landroidx/compose/runtime/SlotReader;II)I", "a", "b", "common", "nearestCommonRootOf", "(Landroidx/compose/runtime/SlotReader;III)I", AppMeasurementSdk.ConditionalUserProperty.VALUE, "runtimeCheck", "(Z)V", CrashHianalyticsData.MESSAGE, "", "composeRuntimeError", "(Ljava/lang/String;)Ljava/lang/Void;", "composeImmediateRuntimeError", "(Ljava/lang/String;)V", "invocation", "Ljava/lang/Object;", "getInvocation", "()Ljava/lang/Object;", "getInvocation$annotations", "provider", "getProvider", "getProvider$annotations", "compositionLocalMap", "getCompositionLocalMap", "getCompositionLocalMap$annotations", "providerValues", "getProviderValues", "getProviderValues$annotations", "providerMaps", "getProviderMaps", "getProviderMaps$annotations", "reference", "getReference", "getReference$annotations", "Ljava/util/Comparator;", "InvalidationLocationAscending", "Ljava/util/Comparator;", "isAfterFirstChild", "(Landroidx/compose/runtime/SlotWriter;)Z", "(Landroidx/compose/runtime/SlotReader;)Z", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "joinedKey", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerKt {
    private static final Object invocation = new OpaqueKey("provider");
    private static final Object provider = new OpaqueKey("provider");
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    private static final Object providerValues = new OpaqueKey("providerValues");
    private static final Object providerMaps = new OpaqueKey("providers");
    private static final Object reference = new OpaqueKey("reference");
    private static final Comparator<Invalidation> InvalidationLocationAscending = new Comparator() { // from class: androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ComposerKt.InvalidationLocationAscending$lambda$15((Invalidation) obj, (Invalidation) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int i) {
        return i != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    public static final boolean isTraceInProgress() {
        return false;
    }

    public static final void traceEventEnd() {
    }

    public static final void traceEventStart(int i, int i2, int i3, String str) {
    }

    public static final void removeCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        int slotsSize;
        int iDataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup() + slotWriter.groupSize(slotWriter.getCurrentGroup())));
        for (int iDataIndex2 = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup())); iDataIndex2 < iDataIndex; iDataIndex2++) {
            Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(iDataIndex2)];
            int iAnchorIndex = -1;
            if (obj instanceof ComposeNodeLifecycleCallback) {
                rememberManager.releasing((ComposeNodeLifecycleCallback) obj, slotWriter.getSlotsSize() - iDataIndex2, -1, -1);
            }
            if (obj instanceof RememberObserverHolder) {
                int slotsSize2 = slotWriter.getSlotsSize() - iDataIndex2;
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                Anchor after = rememberObserverHolder.getAfter();
                if (after == null || !after.getValid()) {
                    slotsSize = -1;
                } else {
                    iAnchorIndex = slotWriter.anchorIndex(after);
                    slotsSize = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(iAnchorIndex);
                }
                rememberManager.forgetting(rememberObserverHolder.getWrapped(), slotsSize2, iAnchorIndex, slotsSize);
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }
        slotWriter.removeGroup();
    }

    public static final boolean isAfterFirstChild(SlotWriter slotWriter) {
        return slotWriter.getCurrentGroup() > slotWriter.getParent() + 1;
    }

    public static final boolean isAfterFirstChild(SlotReader slotReader) {
        return slotReader.getCurrent() > slotReader.getParent() + 1;
    }

    public static final void deactivateCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        int iAnchorIndex;
        int slotsSize;
        int currentGroup = slotWriter.getCurrentGroup();
        int currentGroupEnd = slotWriter.getCurrentGroupEnd();
        while (currentGroup < currentGroupEnd) {
            Object objNode = slotWriter.node(currentGroup);
            if (objNode instanceof ComposeNodeLifecycleCallback) {
                rememberManager.deactivating((ComposeNodeLifecycleCallback) objNode, slotWriter.getSlotsSize() - slotWriter.slotsStartIndex$runtime_release(currentGroup), -1, -1);
            }
            int iSlotIndex = slotWriter.slotIndex(slotWriter.groups, slotWriter.groupIndexToAddress(currentGroup));
            int i = currentGroup + 1;
            int iDataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i));
            for (int i2 = iSlotIndex; i2 < iDataIndex; i2++) {
                int i3 = i2 - iSlotIndex;
                Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(i2)];
                if (obj instanceof RememberObserverHolder) {
                    RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                    RememberObserver wrapped = rememberObserverHolder.getWrapped();
                    if (!(wrapped instanceof ReusableRememberObserver)) {
                        removeData(slotWriter, currentGroup, i3, obj);
                        int slotsSize2 = slotWriter.getSlotsSize() - i3;
                        Anchor after = rememberObserverHolder.getAfter();
                        if (after == null || !after.getValid()) {
                            iAnchorIndex = -1;
                            slotsSize = -1;
                        } else {
                            iAnchorIndex = slotWriter.anchorIndex(after);
                            slotsSize = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(iAnchorIndex);
                        }
                        rememberManager.forgetting(wrapped, slotsSize2, iAnchorIndex, slotsSize);
                    }
                } else if (obj instanceof RecomposeScopeImpl) {
                    removeData(slotWriter, currentGroup, i3, obj);
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            currentGroup = i;
        }
    }

    private static final void removeData(SlotWriter slotWriter, int i, int i2, Object obj) {
        if (obj == slotWriter.set(i, i2, Composer.INSTANCE.getEmpty())) {
            return;
        }
        composeImmediateRuntimeError("Slot table is out of sync");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> MutableScatterMap<K, Object> multiMap(int i) {
        return MutableScatterMultiMap.m712constructorimpl(new MutableScatterMap(i));
    }

    private static final int findLocation(List<Invalidation> list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int iCompare = Intrinsics.compare(list.get(i3).getLocation(), i);
            if (iCompare < 0) {
                i2 = i3 + 1;
            } else {
                if (iCompare <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    private static final int findInsertLocation(List<Invalidation> list, int i) {
        int iFindLocation = findLocation(list, i);
        return iFindLocation < 0 ? -(iFindLocation + 1) : iFindLocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int iFindLocation = findLocation(list, i);
        if (iFindLocation < 0) {
            int i2 = -(iFindLocation + 1);
            if (!(obj instanceof DerivedState)) {
                obj = null;
            }
            list.add(i2, new Invalidation(recomposeScopeImpl, i, obj));
            return;
        }
        Invalidation invalidation = list.get(iFindLocation);
        if (obj instanceof DerivedState) {
            Object instances = invalidation.getInstances();
            if (instances == null) {
                invalidation.setInstances(obj);
                return;
            } else if (instances instanceof MutableScatterSet) {
                ((MutableScatterSet) instances).add(obj);
                return;
            } else {
                invalidation.setInstances(ScatterSetKt.mutableScatterSetOf(instances, obj));
                return;
            }
        }
        invalidation.setInstances(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i, int i2) {
        int iFindInsertLocation = findInsertLocation(list, i);
        if (iFindInsertLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(iFindInsertLocation);
        if (invalidation.getLocation() < i2) {
            return invalidation;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i) {
        int iFindLocation = findLocation(list, i);
        if (iFindLocation >= 0) {
            return list.remove(iFindLocation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i, int i2) {
        int iFindInsertLocation = findInsertLocation(list, i);
        while (iFindInsertLocation < list.size() && list.get(iFindInsertLocation).getLocation() < i2) {
            list.remove(iFindInsertLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Invalidation> filterToRange(List<Invalidation> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int iFindInsertLocation = findInsertLocation(list, i); iFindInsertLocation < list.size(); iFindInsertLocation++) {
            Invalidation invalidation = list.get(iFindInsertLocation);
            if (invalidation.getLocation() >= i2) {
                break;
            }
            arrayList.add(invalidation);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        try {
            collectNodesFrom$lambda$10$collectFromGroup(slotReaderOpenReader, arrayList, slotTable.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            slotReaderOpenReader.close();
        }
    }

    private static final void collectNodesFrom$lambda$10$collectFromGroup(SlotReader slotReader, List<Object> list, int i) {
        if (slotReader.isNode(i)) {
            list.add(slotReader.node(i));
            return;
        }
        int iGroupSize = i + 1;
        int iGroupSize2 = i + slotReader.groupSize(i);
        while (iGroupSize < iGroupSize2) {
            collectNodesFrom$lambda$10$collectFromGroup(slotReader, list, iGroupSize);
            iGroupSize += slotReader.groupSize(iGroupSize);
        }
    }

    private static final int distanceFrom(SlotReader slotReader, int i, int i2) {
        int i3 = 0;
        while (i > 0 && i != i2) {
            i = slotReader.parent(i);
            i3++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i, int i2, int i3) {
        if (i == i2) {
            return i;
        }
        if (i == i3 || i2 == i3) {
            return i3;
        }
        if (slotReader.parent(i) == i2) {
            return i2;
        }
        if (slotReader.parent(i2) == i) {
            return i;
        }
        if (slotReader.parent(i) == slotReader.parent(i2)) {
            return slotReader.parent(i);
        }
        int iDistanceFrom = distanceFrom(slotReader, i, i3);
        int iDistanceFrom2 = distanceFrom(slotReader, i2, i3);
        int i4 = iDistanceFrom - iDistanceFrom2;
        for (int i5 = 0; i5 < i4; i5++) {
            i = slotReader.parent(i);
        }
        int i6 = iDistanceFrom2 - iDistanceFrom;
        for (int i7 = 0; i7 < i6; i7++) {
            i2 = slotReader.parent(i2);
        }
        while (i != i2) {
            i = slotReader.parent(i);
            i2 = slotReader.parent(i2);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getReference() {
        return reference;
    }

    public static final void runtimeCheck(boolean z) {
        if (z) {
            return;
        }
        composeImmediateRuntimeError("Check failed");
    }

    public static final Void composeRuntimeError(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void composeImmediateRuntimeError(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InvalidationLocationAscending$lambda$15(Invalidation invalidation, Invalidation invalidation2) {
        return Intrinsics.compare(invalidation.getLocation(), invalidation2.getLocation());
    }
}
