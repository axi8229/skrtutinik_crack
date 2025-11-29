package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextLayoutResultProxy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\t*\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000bJ\u001a\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "Landroidx/compose/ui/text/TextLayoutResult;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroidx/compose/ui/layout/LayoutCoordinates;", "innerTextFieldCoordinates", "decorationBoxCoordinates", "<init>", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/ui/geometry/Offset;", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "(J)J", "coercedInVisibleBoundsOfInputText", "position", "", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "getOffsetForPosition", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "isPositionOnText", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "translateDecorationToInnerCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "translateInnerToDecorationCoordinates", "Landroidx/compose/ui/text/TextLayoutResult;", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getInnerTextFieldCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setInnerTextFieldCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "setDecorationBoxCoordinates", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextLayoutResultProxy {
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        this.value = textLayoutResult;
        this.innerTextFieldCoordinates = layoutCoordinates;
        this.decorationBoxCoordinates = layoutCoordinates2;
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutResult, (i & 2) != 0 ? null : layoutCoordinates, (i & 4) != 0 ? null : layoutCoordinates2);
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m486getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutResultProxy.m487getOffsetForPosition3MmeM6k(j, z);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m487getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        if (coerceInVisibleBounds) {
            position = m485coercedInVisibleBoundsOfInputTextMKHz9U(position);
        }
        return this.value.m1777getOffsetForPositionk4lQ0M(m489translateDecorationToInnerCoordinatesMKHz9U$foundation_release(position));
    }

    /* renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m488isPositionOnTextk4lQ0M(long offset) {
        long jM489translateDecorationToInnerCoordinatesMKHz9U$foundation_release = m489translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m485coercedInVisibleBoundsOfInputTextMKHz9U(offset));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Offset.m843getYimpl(jM489translateDecorationToInnerCoordinatesMKHz9U$foundation_release));
        return Offset.m842getXimpl(jM489translateDecorationToInnerCoordinatesMKHz9U$foundation_release) >= this.value.getLineLeft(lineForVerticalPosition) && Offset.m842getXimpl(jM489translateDecorationToInnerCoordinatesMKHz9U$foundation_release) <= this.value.getLineRight(lineForVerticalPosition);
    }

    /* renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m489translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return offset;
        }
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return offset;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? offset : layoutCoordinates2.mo1423localPositionOfR5De75A(layoutCoordinates3, offset);
    }

    /* renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m490translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return offset;
        }
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return offset;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? offset : layoutCoordinates3.mo1423localPositionOfR5De75A(layoutCoordinates2, offset);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long m485coercedInVisibleBoundsOfInputTextMKHz9U(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.innerTextFieldCoordinates
            if (r0 == 0) goto L1e
            boolean r1 = r0.isAttached()
            if (r1 == 0) goto L16
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.decorationBoxCoordinates
            r2 = 0
            if (r1 == 0) goto L1c
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r1, r0, r3, r4, r2)
            goto L1c
        L16:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L1c:
            if (r2 != 0) goto L24
        L1e:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L24:
            long r6 = androidx.compose.foundation.text.TextLayoutResultProxyKt.m491access$coerceIn3MmeM6k(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLayoutResultProxy.m485coercedInVisibleBoundsOfInputTextMKHz9U(long):long");
    }
}
