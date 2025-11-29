package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u0007*\u00020\u0002H\u0017ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u000bH\u0017ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u0007H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0013\u001a\u00020\u000b*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0018\u001a\u00020\u0015*\u00020\u0014H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u001a\u001a\u00020\u0014*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001f\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006 À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "Landroidx/compose/ui/unit/Dp;", "", "toPx-0680j_4", "(F)F", "toPx", "", "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "toDp-u2uoSUM", "(I)F", "toDp", "toSp-kPz2Gy4", "(F)J", "toSp", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toSize-XkaWNTQ", "(J)J", "toSize", "toDpSize-k-rfVVM", "toDpSize", "getDensity", "()F", "getDensity$annotations", "()V", "density", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* renamed from: toPx-0680j_4 */
    default float mo254toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* renamed from: roundToPx-0680j_4 */
    default int mo248roundToPx0680j_4(float f) {
        float fMo254toPx0680j_4 = mo254toPx0680j_4(f);
        if (Float.isInfinite(fMo254toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo254toPx0680j_4);
    }

    /* renamed from: toPx--R2X_6o */
    default float mo253toPxR2X_6o(long j) {
        if (!TextUnitType.m2179equalsimpl0(TextUnit.m2168getTypeUIouoOA(j), TextUnitType.INSTANCE.m2184getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px");
        }
        return mo254toPx0680j_4(mo249toDpGaN1DYA(j));
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo251toDpu2uoSUM(int i) {
        return Dp.m2102constructorimpl(i / getDensity());
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo250toDpu2uoSUM(float f) {
        return Dp.m2102constructorimpl(f / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo257toSpkPz2Gy4(float f) {
        return mo256toSp0xMU5do(mo250toDpu2uoSUM(f));
    }

    /* renamed from: toSize-XkaWNTQ */
    default long mo255toSizeXkaWNTQ(long j) {
        if (j != 9205357640488583168L) {
            return SizeKt.Size(mo254toPx0680j_4(DpSize.m2126getWidthD9Ej5fM(j)), mo254toPx0680j_4(DpSize.m2125getHeightD9Ej5fM(j)));
        }
        return Size.INSTANCE.m883getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM */
    default long mo252toDpSizekrfVVM(long j) {
        if (j != 9205357640488583168L) {
            return DpKt.m2112DpSizeYgX7TsA(mo250toDpu2uoSUM(Size.m878getWidthimpl(j)), mo250toDpu2uoSUM(Size.m876getHeightimpl(j)));
        }
        return DpSize.INSTANCE.m2130getUnspecifiedMYxV2XQ();
    }
}
