package androidx.compose.ui.unit;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.KotlinNothingValueException;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: Constraints.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0012\u001a7\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u001c\u0010\u0018\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0017\u001a\u001e\u0010\u001e\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010!\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010\u001d\u001a*\u0010&\u001a\u00020\u000e*\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0000H\u0002¢\u0006\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"", "widthVal", "heightVal", "", "invalidConstraint", "(II)V", "size", "", "invalidSize", "(I)Ljava/lang/Void;", "minWidth", "maxWidth", "minHeight", "maxHeight", "Landroidx/compose/ui/unit/Constraints;", "createConstraints", "(IIII)J", "bitsNeedForSizeUnchecked", "(I)I", "maxAllowedForSize", "Constraints", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "constrain", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "width", "constrainWidth-K40F9xA", "(JI)I", "constrainWidth", "height", "constrainHeight-K40F9xA", "constrainHeight", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "offset", "max", AppMeasurementSdk.ConditionalUserProperty.VALUE, "addMaxWithMinimum", "(II)I", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConstraintsKt {
    private static final int bitsNeedForSizeUnchecked(int i) {
        if (i < 8191) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        if (i < 262143) {
            return 18;
        }
        return KotlinVersion.MAX_COMPONENT_VALUE;
    }

    private static final void invalidConstraint(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    private static final Void invalidSize(int i) {
        throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            invalidConstraint(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i7 & (~(i7 >> 31));
        int i9 = i4 + 1;
        int i10 = i9 & (~(i9 >> 31));
        int i11 = 0;
        if (iBitsNeedForSizeUnchecked2 != 13) {
            if (iBitsNeedForSizeUnchecked2 == 18) {
                i11 = 3;
            } else if (iBitsNeedForSizeUnchecked2 == 15) {
                i11 = 1;
            } else if (iBitsNeedForSizeUnchecked2 == 16) {
                i11 = 2;
            }
        }
        int i12 = ((i11 & 1) << 1) + (((i11 & 2) >> 1) * 3);
        return Constraints.m2074constructorimpl((i8 << 33) | i11 | (i << 2) | (i3 << (i12 + 15)) | (i10 << (i12 + 46)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxAllowedForSize(int i) {
        if (i < 8191) {
            return 262142;
        }
        if (i < 32767) {
            return 65534;
        }
        if (i < 65535) {
            return 32766;
        }
        if (i < 262143) {
            return 8190;
        }
        invalidSize(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (!(i2 >= i)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i2 + ") must be >= than minWidth(" + i + ')');
        }
        if (!(i4 >= i3)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + ')');
        }
        if (i >= 0 && i3 >= 0) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m2096constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt.coerceIn(Constraints.m2086getMinWidthimpl(j2), Constraints.m2086getMinWidthimpl(j), Constraints.m2084getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m2084getMaxWidthimpl(j2), Constraints.m2086getMinWidthimpl(j), Constraints.m2084getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m2085getMinHeightimpl(j2), Constraints.m2085getMinHeightimpl(j), Constraints.m2083getMaxHeightimpl(j)), RangesKt.coerceIn(Constraints.m2083getMaxHeightimpl(j2), Constraints.m2085getMinHeightimpl(j), Constraints.m2083getMaxHeightimpl(j)));
    }

    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m2095constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m2156getWidthimpl(j2), Constraints.m2086getMinWidthimpl(j), Constraints.m2084getMaxWidthimpl(j)), RangesKt.coerceIn(IntSize.m2155getHeightimpl(j2), Constraints.m2085getMinHeightimpl(j), Constraints.m2083getMaxHeightimpl(j)));
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m2098constrainWidthK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m2086getMinWidthimpl(j), Constraints.m2084getMaxWidthimpl(j));
    }

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m2097constrainHeightK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m2085getMinHeightimpl(j), Constraints.m2083getMaxHeightimpl(j));
    }

    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m2099offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m2086getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m2084getMaxWidthimpl(j), i), RangesKt.coerceAtLeast(Constraints.m2085getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m2083getMaxHeightimpl(j), i2));
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt.coerceAtLeast(i + i2, 0);
    }
}
