package kotlin.collections;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0007\u0010\u000b\u001a)\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a1\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0013\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"T", "element", "", "listOf", "(Ljava/lang/Object;)Ljava/util/List;", "E", "", "createListBuilder", "()Ljava/util/List;", "", "capacity", "(I)Ljava/util/List;", "builder", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(Ljava/util/List;)Ljava/util/List;", "", "shuffled", "(Ljava/lang/Iterable;)Ljava/util/List;", "collectionSize", "", "array", "terminateCollectionToArray", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "", "isVarargs", "", "copyToArrayOfAny", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class CollectionsKt__CollectionsJVMKt {
    public static <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static <E> List<E> createListBuilder() {
        return new ListBuilder();
    }

    public static <E> List<E> createListBuilder(int i) {
        return new ListBuilder(i);
    }

    public static <E> List<E> build(List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    public static <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static <T> T[] terminateCollectionToArray(int i, T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (i < array.length) {
            array[i] = null;
        }
        return array;
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (z && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }
}
