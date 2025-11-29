package kotlin.collections.builders;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: MapBuilder.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000b\b\u0000\u0018\u0000 \u0090\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\f\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001BG\b\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0014H\u0002¢\u0006\u0004\b#\u0010\u0011J\u0017\u0010%\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u0013J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u001bJ\u0017\u0010(\u001a\u00020\f2\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010\"J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00028\u0001H\u0002¢\u0006\u0004\b*\u0010\"J\u0017\u0010,\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010\u0013J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\fH\u0002¢\u0006\u0004\b.\u0010\u0013J\u001f\u00101\u001a\u00020\u00192\u000e\u00100\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030/H\u0002¢\u0006\u0004\b1\u00102J#\u00105\u001a\u00020\u00192\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103H\u0002¢\u0006\u0004\b5\u00106J)\u00109\u001a\u00020\u00192\u0018\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010307H\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0019H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00192\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u00192\u0006\u0010)\u001a\u00028\u0001H\u0016¢\u0006\u0004\bA\u0010@J\u001a\u0010B\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bB\u0010CJ!\u0010D\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001H\u0016¢\u0006\u0004\bD\u0010EJ%\u0010F\u001a\u00020\u00142\u0014\u00108\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/H\u0016¢\u0006\u0004\bF\u0010GJ\u0019\u0010H\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0004\bH\u0010CJ\u000f\u0010I\u001a\u00020\u0014H\u0016¢\u0006\u0004\bI\u0010\u0011J\u001a\u0010K\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010JH\u0096\u0002¢\u0006\u0004\bK\u0010@J\u000f\u0010L\u001a\u00020\fH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010R\u001a\u00020\u0014H\u0000¢\u0006\u0004\bQ\u0010\u0011J\u0017\u0010T\u001a\u00020\f2\u0006\u0010 \u001a\u00028\u0000H\u0000¢\u0006\u0004\bS\u0010\"J\u0017\u0010V\u001a\u00020\f2\u0006\u0010 \u001a\u00028\u0000H\u0000¢\u0006\u0004\bU\u0010\"J#\u0010X\u001a\u00020\u00192\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103H\u0000¢\u0006\u0004\bW\u00106J\u001b\u0010[\u001a\u00020\u00192\n\u0010Y\u001a\u0006\u0012\u0002\b\u000307H\u0000¢\u0006\u0004\bZ\u0010:J#\u0010]\u001a\u00020\u00192\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103H\u0000¢\u0006\u0004\b\\\u00106J\u0017\u0010`\u001a\u00020\u00192\u0006\u0010^\u001a\u00028\u0001H\u0000¢\u0006\u0004\b_\u0010@J\u001b\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010aH\u0000¢\u0006\u0004\bb\u0010cJ\u001b\u0010h\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010eH\u0000¢\u0006\u0004\bf\u0010gJ\u001b\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010iH\u0000¢\u0006\u0004\bj\u0010kR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010mR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010mR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010nR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010oR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010oR\u0016\u0010p\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010oR\u0016\u0010q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010oR$\u0010s\u001a\u00020\f2\u0006\u0010r\u001a\u00020\f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bs\u0010o\u001a\u0004\bt\u0010MR\u001e\u0010v\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u001e\u0010y\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR$\u0010|\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R%\u0010~\u001a\u00020\u00192\u0006\u0010r\u001a\u00020\u00198\u0000@BX\u0080\u000e¢\u0006\r\n\u0004\b~\u0010\u007f\u001a\u0005\b\u0080\u0001\u0010>R\u0016\u0010\u0082\u0001\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010MR\u001e\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0083\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R+\u0010\u008d\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u008b\u00010\u0083\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u0085\u0001R\u0016\u0010\u008f\u0001\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010M¨\u0006\u0096\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "keysArray", "valuesArray", "", "presenceArray", "hashArray", "", "maxProbeDistance", "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "", "registerModification", "n", "ensureExtraCapacity", "extraCapacity", "", "shouldCompact", "(I)Z", "minCapacity", "ensureCapacity", "allocateValuesArray", "()[Ljava/lang/Object;", "key", "hash", "(Ljava/lang/Object;)I", "compact", "newHashSize", "rehash", "i", "putRehash", "findKey", AppMeasurementSdk.ConditionalUserProperty.VALUE, "findValue", "index", "removeKeyAt", "removedHash", "removeHashAt", "", "other", "contentEquals", "(Ljava/util/Map;)Z", "", "entry", "putEntry", "(Ljava/util/Map$Entry;)Z", "", RemoteMessageConst.FROM, "putAllEntries", "(Ljava/util/Collection;)Z", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ljava/util/Map;", "isEmpty", "()Z", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "(Ljava/util/Map;)V", "remove", "clear", "", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "checkIsMutable$kotlin_stdlib", "checkIsMutable", "addKey$kotlin_stdlib", "addKey", "removeKey$kotlin_stdlib", "removeKey", "containsEntry$kotlin_stdlib", "containsEntry", "m", "containsAllEntries$kotlin_stdlib", "containsAllEntries", "removeEntry$kotlin_stdlib", "removeEntry", "element", "removeValue$kotlin_stdlib", "removeValue", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator", "[Ljava/lang/Object;", "[I", "I", "hashShift", "modCount", "<set-?>", "size", "getSize", "Lkotlin/collections/builders/MapBuilderKeys;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "Lkotlin/collections/builders/MapBuilderValues;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "Lkotlin/collections/builders/MapBuilderEntries;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "isReadOnly", "Z", "isReadOnly$kotlin_stdlib", "getHashSize", "hashSize", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "", "getEntries", "entries", "getCapacity$kotlin_stdlib", "capacity", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MapBuilder Empty;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i;
        this.length = i2;
        this.hashShift = INSTANCE.computeShift(getHashSize());
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public int getSize() {
        return this.size;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), null, new int[i], new int[INSTANCE.computeHashSize(i)], 2, 0);
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = Empty;
        Intrinsics.checkNotNull(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return findKey(key) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return findValue(value) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object key) {
        int iFindKey = findKey(key);
        if (iFindKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return vArr[iFindKey];
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(key);
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib < 0) {
            int i = (-iAddKey$kotlin_stdlib) - 1;
            V v = vArrAllocateValuesArray[i];
            vArrAllocateValuesArray[i] = value;
            return v;
        }
        vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = value;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object key) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(key);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        V v = vArr[iRemoveKey$kotlin_stdlib];
        ListBuilderKt.resetAt(vArr, iRemoveKey$kotlin_stdlib);
        return v;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        ?? it = new IntRange(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i = iArr[iNextInt];
            if (i >= 0) {
                this.hashArray[i] = 0;
                iArr[iNextInt] = -1;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.keysView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.valuesView = mapBuilderValues2;
        return mapBuilderValues2;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.entriesView = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        return other == this || ((other instanceof Map) && contentEquals((Map) other));
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> entriesItrEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iNextHashCode$kotlin_stdlib = 0;
        while (entriesItrEntriesIterator$kotlin_stdlib.hasNext()) {
            iNextHashCode$kotlin_stdlib += entriesItrEntriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return iNextHashCode$kotlin_stdlib;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr<K, V> entriesItrEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesItrEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            entriesItrEntriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final void registerModification() {
        this.modCount++;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final void ensureExtraCapacity(int n) {
        if (shouldCompact(n)) {
            rehash(getHashSize());
        } else {
            ensureCapacity(this.length + n);
        }
    }

    private final boolean shouldCompact(int extraCapacity) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i = this.length;
        int i2 = capacity$kotlin_stdlib - i;
        int size = i - size();
        return i2 < extraCapacity && i2 + size >= extraCapacity && size >= getCapacity$kotlin_stdlib() / 4;
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > getCapacity$kotlin_stdlib()) {
            int iNewCapacity$kotlin_stdlib = AbstractList.INSTANCE.newCapacity$kotlin_stdlib(getCapacity$kotlin_stdlib(), minCapacity);
            this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, iNewCapacity$kotlin_stdlib);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) ListBuilderKt.copyOfUninitializedElements(vArr, iNewCapacity$kotlin_stdlib) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iNewCapacity$kotlin_stdlib);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iComputeHashSize = INSTANCE.computeHashSize(iNewCapacity$kotlin_stdlib);
            if (iComputeHashSize > getHashSize()) {
                rehash(iComputeHashSize);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final int hash(K key) {
        return ((key != null ? key.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    private final void compact() {
        int i;
        V[] vArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            if (this.presenceArray[i2] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                i3++;
            }
            i2++;
        }
        ListBuilderKt.resetRange(this.keysArray, i3, i);
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, i3, this.length);
        }
        this.length = i3;
    }

    private final void rehash(int newHashSize) {
        registerModification();
        if (this.length > size()) {
            compact();
        }
        int i = 0;
        if (newHashSize != getHashSize()) {
            this.hashArray = new int[newHashSize];
            this.hashShift = INSTANCE.computeShift(newHashSize);
        } else {
            ArraysKt.fill(this.hashArray, 0, 0, getHashSize());
        }
        while (i < this.length) {
            int i2 = i + 1;
            if (!putRehash(i)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i = i2;
        }
    }

    private final boolean putRehash(int i) {
        int iHash = hash(this.keysArray[i]);
        int i2 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iHash] == 0) {
                iArr[iHash] = i + 1;
                this.presenceArray[i] = iHash;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final int findKey(K key) {
        int iHash = hash(key);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[iHash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.areEqual(this.keysArray[i3], key)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final int findValue(V value) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual(vArr[i], value)) {
                    return i;
                }
            }
        }
    }

    public final int addKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iHash = hash(key);
            int iCoerceAtMost = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
            int i = 0;
            while (true) {
                int i2 = this.hashArray[iHash];
                if (i2 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i3 = this.length;
                        int i4 = i3 + 1;
                        this.length = i4;
                        this.keysArray[i3] = key;
                        this.presenceArray[i3] = iHash;
                        this.hashArray[iHash] = i4;
                        this.size = size() + 1;
                        registerModification();
                        if (i > this.maxProbeDistance) {
                            this.maxProbeDistance = i;
                        }
                        return i3;
                    }
                } else {
                    if (Intrinsics.areEqual(this.keysArray[i2 - 1], key)) {
                        return -i2;
                    }
                    i++;
                    if (i > iCoerceAtMost) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
                }
            }
        }
    }

    public final int removeKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(key);
        if (iFindKey < 0) {
            return -1;
        }
        removeKeyAt(iFindKey);
        return iFindKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int index) {
        ListBuilderKt.resetAt(this.keysArray, index);
        removeHashAt(this.presenceArray[index]);
        this.presenceArray[index] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final void removeHashAt(int removedHash) {
        int iCoerceAtMost = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int i = 0;
        int i2 = removedHash;
        do {
            removedHash = removedHash == 0 ? getHashSize() - 1 : removedHash - 1;
            i++;
            if (i > this.maxProbeDistance) {
                this.hashArray[i2] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i3 = iArr[removedHash];
            if (i3 == 0) {
                iArr[i2] = 0;
                return;
            }
            if (i3 < 0) {
                iArr[i2] = -1;
            } else {
                int i4 = i3 - 1;
                if (((hash(this.keysArray[i4]) - removedHash) & (getHashSize() - 1)) >= i) {
                    this.hashArray[i2] = i3;
                    this.presenceArray[i4] = i2;
                }
                iCoerceAtMost--;
            }
            i2 = removedHash;
            i = 0;
            iCoerceAtMost--;
        } while (iCoerceAtMost >= 0);
        this.hashArray[i2] = -1;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual(vArr[iFindKey], entry.getValue());
    }

    private final boolean contentEquals(Map<?, ?> other) {
        return size() == other.size() && containsAllEntries$kotlin_stdlib(other.entrySet());
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m) {
        Intrinsics.checkNotNullParameter(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        if (Intrinsics.areEqual(entry.getValue(), vArrAllocateValuesArray[i])) {
            return false;
        }
        vArrAllocateValuesArray[i] = entry.getValue();
        return true;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        boolean z = false;
        if (from.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(from.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = from.iterator();
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual(vArr[iFindKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(iFindKey);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V element) {
        checkIsMutable$kotlin_stdlib();
        int iFindValue = findValue(element);
        if (iFindValue < 0) {
            return false;
        }
        removeKeyAt(iFindValue);
        return true;
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/MapBuilder;", "", "getEmpty$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.Empty;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeHashSize(int capacity) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(capacity, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeShift(int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0019J\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "expectedModCount", "", "index", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "checkForComodification", "", "checkForComodification$kotlin_stdlib", "hasNext", "", "initNext", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class Itr<K, V> {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.lastIndex = -1;
            this.expectedModCount = ((MapBuilder) map).modCount;
            initNext$kotlin_stdlib();
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        /* renamed from: getIndex$kotlin_stdlib, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.index = i;
        }

        /* renamed from: getLastIndex$kotlin_stdlib, reason: from getter */
        public final int getLastIndex() {
            return this.lastIndex;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.lastIndex = i;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < ((MapBuilder) this.map).length) {
                int[] iArr = ((MapBuilder) this.map).presenceArray;
                int i = this.index;
                if (iArr[i] >= 0) {
                    return;
                } else {
                    this.index = i + 1;
                }
            }
        }

        public final boolean hasNext() {
            return this.index < ((MapBuilder) this.map).length;
        }

        public final void remove() {
            checkForComodification$kotlin_stdlib();
            if (this.lastIndex == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.map.checkIsMutable$kotlin_stdlib();
            this.map.removeKeyAt(this.lastIndex);
            this.lastIndex = -1;
            this.expectedModCount = ((MapBuilder) this.map).modCount;
        }

        public final void checkForComodification$kotlin_stdlib() {
            if (((MapBuilder) this.map).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            K k = (K) ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex()];
            initNext$kotlin_stdlib();
            return k;
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            V v = (V) objArr[getLastIndex()];
            initNext$kotlin_stdlib();
            return v;
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public EntryRef<K, V> next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex());
            initNext$kotlin_stdlib();
            return entryRef;
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            Object obj = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            initNext$kotlin_stdlib();
            return iHashCode2;
        }

        public final void nextAppendString(StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            Object obj = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex()];
            if (obj == getMap$kotlin_stdlib()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex()];
            if (obj2 == getMap$kotlin_stdlib()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            initNext$kotlin_stdlib();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        private final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> map, int i) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.index = i;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.map).keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.map).valuesArray;
            Intrinsics.checkNotNull(objArr);
            return (V) objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] objArrAllocateValuesArray = this.map.allocateValuesArray();
            int i = this.index;
            V v = (V) objArrAllocateValuesArray[i];
            objArrAllocateValuesArray[i] = newValue;
            return v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object other) {
            if (other instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) other;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }
}
