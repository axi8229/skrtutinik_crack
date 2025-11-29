package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Composer.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0083@\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0018\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \u0088\u0001\u0005\u0092\u0001\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0004¨\u0006!"}, d2 = {"Landroidx/compose/runtime/MutableScatterMultiMap;", "K", "", "V", "Landroidx/collection/MutableScatterMap;", "map", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "key", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "put-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "put", "pop-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "pop", "", "toString-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Landroidx/collection/MutableScatterMap;)I", "hashCode", "other", "", "equals-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "equals", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
final class MutableScatterMultiMap<K, V> {
    private final MutableScatterMap<K, Object> map;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MutableScatterMultiMap m711boximpl(MutableScatterMap mutableScatterMap) {
        return new MutableScatterMultiMap(mutableScatterMap);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <K, V> MutableScatterMap<K, Object> m712constructorimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m713equalsimpl(MutableScatterMap<K, Object> mutableScatterMap, Object obj) {
        return (obj instanceof MutableScatterMultiMap) && Intrinsics.areEqual(mutableScatterMap, ((MutableScatterMultiMap) obj).getMap());
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m714hashCodeimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m717toStringimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return "MutableScatterMultiMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object obj) {
        return m713equalsimpl(this.map, obj);
    }

    public int hashCode() {
        return m714hashCodeimpl(this.map);
    }

    public String toString() {
        return m717toStringimpl(this.map);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: put-impl, reason: not valid java name */
    public static final void m716putimpl(MutableScatterMap<K, Object> mutableScatterMap, K k, V v) {
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(k);
        boolean z = iFindInsertIndex < 0;
        Object obj = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj != null) {
            if (TypeIntrinsics.isMutableList(obj)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                List listAsMutableList = TypeIntrinsics.asMutableList(obj);
                listAsMutableList.add(v);
                v = listAsMutableList;
            } else {
                v = (V) CollectionsKt.mutableListOf(obj, v);
            }
        }
        if (z) {
            int i = ~iFindInsertIndex;
            mutableScatterMap.keys[i] = k;
            mutableScatterMap.values[i] = v;
            return;
        }
        mutableScatterMap.values[iFindInsertIndex] = v;
    }

    private /* synthetic */ MutableScatterMultiMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* renamed from: pop-impl, reason: not valid java name */
    public static final V m715popimpl(MutableScatterMap<K, Object> mutableScatterMap, K k) {
        V v = (V) mutableScatterMap.get(k);
        if (v == null) {
            return null;
        }
        if (TypeIntrinsics.isMutableList(v)) {
            List listAsMutableList = TypeIntrinsics.asMutableList(v);
            Object objRemove = listAsMutableList.remove(0);
            if (listAsMutableList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            v = (V) objRemove;
        } else {
            mutableScatterMap.remove(k);
        }
        Intrinsics.checkNotNull(v, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        return v;
    }
}
