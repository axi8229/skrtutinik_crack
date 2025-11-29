package androidx.compose.material;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/compose/material/MapDraggableAnchors;", "T", "Landroidx/compose/material/DraggableAnchors;", "", "", "anchors", "<init>", "(Ljava/util/Map;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "positionOf", "(Ljava/lang/Object;)F", "", "hasAnchorFor", "(Ljava/lang/Object;)Z", "position", "closestAnchor", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minAnchor", "()F", "maxAnchor", "", "other", "equals", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class MapDraggableAnchors<T> implements DraggableAnchors<T> {
    private final Map<T, Float> anchors;

    public MapDraggableAnchors(Map<T, Float> map) {
        this.anchors = map;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float positionOf(T value) {
        Float f = this.anchors.get(value);
        if (f != null) {
            return f.floatValue();
        }
        return Float.NaN;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public boolean hasAnchorFor(T value) {
        return this.anchors.containsKey(value);
    }

    @Override // androidx.compose.material.DraggableAnchors
    public T closestAnchor(float position) {
        T next;
        Iterator<T> it = this.anchors.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(position - ((Number) ((Map.Entry) next).getValue()).floatValue());
                do {
                    T next2 = it.next();
                    float fAbs2 = Math.abs(position - ((Number) ((Map.Entry) next2).getValue()).floatValue());
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (T) entry.getKey();
        }
        return null;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public T closestAnchor(float position, boolean searchUpwards) {
        T next;
        Iterator<T> it = this.anchors.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
                float f = searchUpwards ? fFloatValue - position : position - fFloatValue;
                if (f < 0.0f) {
                    f = Float.POSITIVE_INFINITY;
                }
                do {
                    T next2 = it.next();
                    float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                    float f2 = searchUpwards ? fFloatValue2 - position : position - fFloatValue2;
                    if (f2 < 0.0f) {
                        f2 = Float.POSITIVE_INFINITY;
                    }
                    if (Float.compare(f, f2) > 0) {
                        next = next2;
                        f = f2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (T) entry.getKey();
        }
        return null;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float minAnchor() {
        Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) this.anchors.values());
        if (fMinOrNull != null) {
            return fMinOrNull.floatValue();
        }
        return Float.NaN;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float maxAnchor() {
        Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) this.anchors.values());
        if (fMaxOrNull != null) {
            return fMaxOrNull.floatValue();
        }
        return Float.NaN;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MapDraggableAnchors) {
            return Intrinsics.areEqual(this.anchors, ((MapDraggableAnchors) other).anchors);
        }
        return false;
    }

    public int hashCode() {
        return this.anchors.hashCode() * 31;
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.anchors + ')';
    }
}
