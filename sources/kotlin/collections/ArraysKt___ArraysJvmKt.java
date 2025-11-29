package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\r\u001a\u00020\u0006*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000e\u001aS\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a9\u0010\u0013\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00152\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0016\u001a9\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0017\u001a9\u0010\u0013\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0019\u001a9\u0010\u0013\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u001a\u001a9\u0010\u0013\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u001c\u001a5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u001f\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010 \u001a9\u0010\"\u001a\u00020!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#\u001a-\u0010\"\u001a\u00020!*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010$\u001a-\u0010\"\u001a\u00020!*\u00020\u00182\u0006\u0010\n\u001a\u00020%2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010&\u001a.\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b'\u0010)\u001a6\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b'\u0010+\u001a\u001c\u0010'\u001a\u00020\u0015*\u00020\u00152\u0006\u0010*\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0004\b'\u0010,\u001a\u001c\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b'\u0010-\u001a\u001c\u0010'\u001a\u00020\u0018*\u00020\u00182\u0006\u0010*\u001a\u00020\u0018H\u0086\u0002¢\u0006\u0004\b'\u0010.\u001a\u001c\u0010'\u001a\u00020\b*\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b'\u0010/\u001a\u001c\u0010'\u001a\u000200*\u0002002\u0006\u0010*\u001a\u000200H\u0086\u0002¢\u0006\u0004\b'\u00101\u001a\u001f\u00102\u001a\u00020!\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b2\u00103\u001a%\u00102\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b2\u00104\u001a;\u00108\u001a\u00020!\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00107\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000005j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`6¢\u0006\u0004\b8\u00109\u001aO\u00108\u001a\u00020!\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00107\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000005j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`62\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b8\u0010:\u001a\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005¢\u0006\u0004\b;\u0010<\u001a\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020%0\u0001*\u00020\u0018¢\u0006\u0004\b;\u0010=\u001a\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\b¢\u0006\u0004\b;\u0010>\u001a\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020?0\u0001*\u000200¢\u0006\u0004\b;\u0010@\u001a\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020A0\u0001*\u00020\u001b¢\u0006\u0004\b;\u0010B¨\u0006C"}, d2 = {"T", "", "", "asList", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "([I)Ljava/util/List;", "", "", "element", "fromIndex", "toIndex", "binarySearch", "([FFII)I", "destination", "destinationOffset", "startIndex", "endIndex", "copyInto", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "", "([B[BIII)[B", "([I[IIII)[I", "", "([J[JIII)[J", "([F[FIII)[F", "", "([C[CIII)[C", "copyOfRange", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "([BII)[B", "", "fill", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "([IIII)V", "", "([JJII)V", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "([II)[I", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "([B[B)[B", "([I[I)[I", "([J[J)[J", "([F[F)[F", "", "([Z[Z)[Z", "sort", "([Ljava/lang/Object;)V", "([III)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toTypedArray", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([F)[Ljava/lang/Float;", "", "([Z)[Ljava/lang/Boolean;", "", "([C)[Ljava/lang/Character;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes3.dex */
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static <T> List<T> asList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        List<T> listAsList = ArraysUtilJVM.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(listAsList, "asList(...)");
        return listAsList;
    }

    /* compiled from: _ArraysJvm.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractList<Integer> implements RandomAccess {
        final /* synthetic */ int[] $this_asList;

        AnonymousClass3(int[] iArr) {
            this.$this_asList = iArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return contains(((Number) obj).intValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return indexOf(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return lastIndexOf(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        /* renamed from: getSize */
        public int get_size() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        public boolean contains(int element) {
            return ArraysKt.contains(this.$this_asList, element);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Integer get(int index) {
            return Integer.valueOf(this.$this_asList[index]);
        }

        public int indexOf(int element) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, element);
        }

        public int lastIndexOf(int element) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, element);
        }
    }

    public static List<Integer> asList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new AnonymousClass3(iArr);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return binarySearch(fArr, f, i, i2);
    }

    public static final int binarySearch(float[] fArr, float f, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return Arrays.binarySearch(fArr, i, i2, f);
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return ArraysKt.copyInto(objArr, objArr2, i, i2, i3);
    }

    public static <T> T[] copyInto(T[] tArr, T[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(tArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return ArraysKt.copyInto(bArr, bArr2, i, i2, i3);
    }

    public static byte[] copyInto(byte[] bArr, byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(bArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return ArraysKt.copyInto(iArr, iArr2, i, i2, i3);
    }

    public static int[] copyInto(int[] iArr, int[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(iArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static long[] copyInto(long[] jArr, long[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(jArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return ArraysKt.copyInto(fArr, fArr2, i, i2, i3);
    }

    public static float[] copyInto(float[] fArr, float[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(fArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static char[] copyInto(char[] cArr, char[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(cArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        ArraysKt.fill(objArr, obj, i, i2);
    }

    public static <T> void fill(T[] tArr, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        ArraysKt.fill(iArr, i, i2, i3);
    }

    public static void fill(int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        fill(jArr, j, i, i2);
    }

    public static final void fill(long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Arrays.fill(jArr, i, i2, j);
    }

    public static <T> T[] plus(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t;
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    public static int[] plus(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i;
        Intrinsics.checkNotNull(iArrCopyOf);
        return iArrCopyOf;
    }

    public static <T> T[] plus(T[] tArr, T[] elements) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    public static byte[] plus(byte[] bArr, byte[] elements) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        Intrinsics.checkNotNull(bArrCopyOf);
        return bArrCopyOf;
    }

    public static int[] plus(int[] iArr, int[] elements) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, iArrCopyOf, length, length2);
        Intrinsics.checkNotNull(iArrCopyOf);
        return iArrCopyOf;
    }

    public static long[] plus(long[] jArr, long[] elements) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, jArrCopyOf, length, length2);
        Intrinsics.checkNotNull(jArrCopyOf);
        return jArrCopyOf;
    }

    public static float[] plus(float[] fArr, float[] elements) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, fArrCopyOf, length, length2);
        Intrinsics.checkNotNull(fArrCopyOf);
        return fArrCopyOf;
    }

    public static boolean[] plus(boolean[] zArr, boolean[] elements) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, zArrCopyOf, length, length2);
        Intrinsics.checkNotNull(zArrCopyOf);
        return zArrCopyOf;
    }

    public static <T> void sort(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static void sort(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.sort(iArr, i, i2);
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static <T> void sortWith(T[] tArr, Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Arrays.sort(tArr, i, i2, comparator);
    }

    public static Integer[] toTypedArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] toTypedArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static Float[] toTypedArray(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Boolean[] toTypedArray(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static final Character[] toTypedArray(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }
}
