package coil.request;

import coil.content.Collections;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Parameters.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0003$#%B\u001d\b\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ!\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0014H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\"¨\u0006&"}, d2 = {"Lcoil/request/Parameters;", "", "Lkotlin/Pair;", "", "Lcoil/request/Parameters$Entry;", "", "entries", "<init>", "(Ljava/util/Map;)V", "()V", "", "T", "key", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;)Ljava/lang/Object;", "", "isEmpty", "()Z", "memoryCacheKeys", "()Ljava/util/Map;", "", "iterator", "()Ljava/util/Iterator;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lcoil/request/Parameters$Builder;", "newBuilder", "()Lcoil/request/Parameters$Builder;", "Ljava/util/Map;", "Companion", "Builder", "Entry", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Parameters implements Iterable<Pair<? extends String, ? extends Entry>>, KMappedMarker {
    public static final Parameters EMPTY = new Parameters();
    private final Map<String, Entry> entries;

    public /* synthetic */ Parameters(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private Parameters(Map<String, Entry> map) {
        this.entries = map;
    }

    public Parameters() {
        this(MapsKt.emptyMap());
    }

    public final <T> T value(String key) {
        Entry entry = this.entries.get(key);
        if (entry != null) {
            return (T) entry.getValue();
        }
        return null;
    }

    public final boolean isEmpty() {
        return this.entries.isEmpty();
    }

    public final Map<String, String> memoryCacheKeys() {
        if (isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<String, Entry> map = this.entries;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Entry> entry : map.entrySet()) {
            String memoryCacheKey = entry.getValue().getMemoryCacheKey();
            if (memoryCacheKey != null) {
                linkedHashMap.put(entry.getKey(), memoryCacheKey);
            }
        }
        return linkedHashMap;
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends Entry>> iterator() {
        Map<String, Entry> map = this.entries;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Entry> entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), entry.getValue()));
        }
        return arrayList.iterator();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Parameters) && Intrinsics.areEqual(this.entries, ((Parameters) other).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* compiled from: Parameters.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcoil/request/Parameters$Entry;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "memoryCacheKey", "Ljava/lang/String;", "getMemoryCacheKey", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Entry {
        private final String memoryCacheKey;
        private final Object value;

        public final Object getValue() {
            return this.value;
        }

        public final String getMemoryCacheKey() {
            return this.memoryCacheKey;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Entry) {
                Entry entry = (Entry) other;
                if (Intrinsics.areEqual(this.value, entry.value) && Intrinsics.areEqual(this.memoryCacheKey, entry.memoryCacheKey)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.value;
            int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
            String str = this.memoryCacheKey;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Entry(value=" + this.value + ", memoryCacheKey=" + this.memoryCacheKey + ')';
        }
    }

    /* compiled from: Parameters.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcoil/request/Parameters$Builder;", "", "Lcoil/request/Parameters;", "parameters", "<init>", "(Lcoil/request/Parameters;)V", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcoil/request/Parameters;", "", "", "Lcoil/request/Parameters$Entry;", "entries", "Ljava/util/Map;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final Map<String, Entry> entries;

        public Builder(Parameters parameters) {
            this.entries = MapsKt.toMutableMap(parameters.entries);
        }

        public final Parameters build() {
            return new Parameters(Collections.toImmutableMap(this.entries), null);
        }
    }
}
