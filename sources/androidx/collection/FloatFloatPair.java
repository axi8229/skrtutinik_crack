package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: FloatFloatPair.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\t\u0088\u0001\b\u0092\u0001\u00020\u0007¨\u0006\n"}, d2 = {"Landroidx/collection/FloatFloatPair;", "", "", "first", "second", "constructor-impl", "(FF)J", "", "packedValue", "(J)J", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class FloatFloatPair {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m82constructorimpl(long j) {
        return j;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m81constructorimpl(float f, float f2) {
        return m82constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
