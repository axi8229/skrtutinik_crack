package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ArrayMap.kt */
/* loaded from: classes4.dex */
public abstract class ArrayMap<T> implements Iterable<T>, KMappedMarker {
    public /* synthetic */ ArrayMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract T get(int i);

    public abstract int getSize();

    @Override // java.lang.Iterable
    public abstract Iterator<T> iterator();

    public abstract void set(int i, T t);

    private ArrayMap() {
    }
}
