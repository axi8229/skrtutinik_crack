package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: ProgressIndicator.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/ProgressIndicatorDefaults;", "", "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "StrokeWidth", "F", "getStrokeWidth-D9Ej5fM", "()F", "Landroidx/compose/animation/core/SpringSpec;", "", "ProgressAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "getProgressAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressIndicatorDefaults {
    public static final ProgressIndicatorDefaults INSTANCE = new ProgressIndicatorDefaults();
    private static final float StrokeWidth = Dp.m2102constructorimpl(4);
    private static final SpringSpec<Float> ProgressAnimationSpec = new SpringSpec<>(1.0f, 50.0f, Float.valueOf(0.001f));

    private ProgressIndicatorDefaults() {
    }

    /* renamed from: getStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m650getStrokeWidthD9Ej5fM() {
        return StrokeWidth;
    }
}
