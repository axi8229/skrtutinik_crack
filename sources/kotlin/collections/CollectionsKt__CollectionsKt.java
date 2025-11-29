package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\f\u0010\n\u001a7\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00112\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\n\u001a%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001aG\u0010\u001b\u001a\u00020\u0018\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\b\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a'\u0010!\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u000f\u0010\"\u001a\u00020\u001eH\u0001¢\u0006\u0004\b\"\u0010#\u001a\u000f\u0010$\u001a\u00020\u001eH\u0001¢\u0006\u0004\b$\u0010#\"\u0019\u0010(\u001a\u00020%*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b&\u0010'\"!\u0010+\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"T", "", "", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "emptyList", "()Ljava/util/List;", "elements", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "", "mutableListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayListOf", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "", "element", "listOfNotNull", "(Ljava/lang/Object;)Ljava/util/List;", "optimizeReadOnlyList", "(Ljava/util/List;)Ljava/util/List;", "", "", "fromIndex", "toIndex", "binarySearch", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "size", "", "rangeCheck$CollectionsKt__CollectionsKt", "(III)V", "rangeCheck", "throwIndexOverflow", "()V", "throwCountOverflow", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final <T> Collection<T> asCollection(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static <T> List<T> listOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt.asList(elements) : CollectionsKt.emptyList();
    }

    public static <T> List<T> mutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    public static <T> ArrayList<T> arrayListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(elements, true));
    }

    public static <T> List<T> listOfNotNull(T t) {
        return t != null ? CollectionsKt.listOf(t) : CollectionsKt.emptyList();
    }

    public static <T> List<T> listOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.filterNotNull(elements);
    }

    public static IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : CollectionsKt.listOf(list.get(0));
        }
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, comparable, i, i2);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iCompareValues = ComparisonsKt.compareValues(list.get(i4), t);
            if (iCompareValues < 0) {
                i = i4 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }
}
