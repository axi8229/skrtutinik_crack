package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: NestedScrollInteropConnection.android.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0002\u001a\"\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\u0014\u001a\u00020\u0004*\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\"\u0018\u0010\u001c\u001a\u00020\u0004*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"", "ceilAwayFromZero", "(F)F", "offset", "", "composeToViewOffset", "(F)I", "reverseAxis", "(I)F", "toViewVelocity", "", "consumed", "Landroidx/compose/ui/geometry/Offset;", "available", "toOffset-Uv8p0NA", "([IJ)J", "toOffset", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "toViewType", "Landroid/view/View;", "hostView", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "rememberNestedScrollInteropConnection", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getScrollAxes-k-4lQ0M", "(J)I", "scrollAxes", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollInteropConnectionKt {
    private static final float reverseAxis(int i) {
        return i * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toViewVelocity(float f) {
        return f * (-1.0f);
    }

    private static final float ceilAwayFromZero(float f) {
        return (float) (f >= 0.0f ? Math.ceil(f) : Math.floor(f));
    }

    public static final int composeToViewOffset(float f) {
        return ((int) ceilAwayFromZero(f)) * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toOffset-Uv8p0NA, reason: not valid java name */
    public static final long m1636toOffsetUv8p0NA(int[] iArr, long j) {
        float fCoerceAtLeast;
        float fCoerceAtLeast2;
        if (Offset.m842getXimpl(j) >= 0.0f) {
            fCoerceAtLeast = RangesKt.coerceAtMost(reverseAxis(iArr[0]), Offset.m842getXimpl(j));
        } else {
            fCoerceAtLeast = RangesKt.coerceAtLeast(reverseAxis(iArr[0]), Offset.m842getXimpl(j));
        }
        if (Offset.m843getYimpl(j) >= 0.0f) {
            fCoerceAtLeast2 = RangesKt.coerceAtMost(reverseAxis(iArr[1]), Offset.m843getYimpl(j));
        } else {
            fCoerceAtLeast2 = RangesKt.coerceAtLeast(reverseAxis(iArr[1]), Offset.m843getYimpl(j));
        }
        return OffsetKt.Offset(fCoerceAtLeast, fCoerceAtLeast2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toViewType-GyEprt8, reason: not valid java name */
    public static final int m1637toViewTypeGyEprt8(int i) {
        return !NestedScrollSource.m1311equalsimpl0(i, NestedScrollSource.INSTANCE.m1313getUserInputWNlRxjI()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getScrollAxes-k-4lQ0M, reason: not valid java name */
    public static final int m1635getScrollAxesk4lQ0M(long j) {
        int i = Math.abs(Offset.m842getXimpl(j)) >= 0.5f ? 1 : 0;
        return Math.abs(Offset.m843getYimpl(j)) >= 0.5f ? i | 2 : i;
    }

    public static final NestedScrollConnection rememberNestedScrollInteropConnection(View view, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1075877987, i, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.android.kt:235)");
        }
        boolean zChanged = composer.changed(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new NestedScrollInteropConnection(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        NestedScrollInteropConnection nestedScrollInteropConnection = (NestedScrollInteropConnection) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return nestedScrollInteropConnection;
    }
}
