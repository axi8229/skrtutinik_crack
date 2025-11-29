package androidx.compose.animation.core;

import com.yandex.varioqub.config.model.ConfigValue;
import kotlin.Metadata;

/* compiled from: ComplexDouble.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "num", "Landroidx/compose/animation/core/ComplexDouble;", "complexSqrt", "(D)Landroidx/compose/animation/core/ComplexDouble;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComplexDoubleKt {
    public static final ComplexDouble complexSqrt(double d) {
        if (d < ConfigValue.DOUBLE_DEFAULT_VALUE) {
            return new ComplexDouble(ConfigValue.DOUBLE_DEFAULT_VALUE, Math.sqrt(Math.abs(d)));
        }
        return new ComplexDouble(Math.sqrt(d), ConfigValue.DOUBLE_DEFAULT_VALUE);
    }
}
