package androidx.compose.animation.core;

import com.yandex.varioqub.config.model.ConfigValue;
import kotlin.Metadata;

/* compiled from: SpringEstimation.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a7\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\n\u001a/\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0010\u001a7\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a?\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", "stiffness", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "", "estimateAnimationDurationMillis", "(FFFFF)J", "", "(DDDDD)J", "Landroidx/compose/animation/core/ComplexDouble;", "firstRoot", "p0", "v0", "estimateUnderDamped", "(Landroidx/compose/animation/core/ComplexDouble;DDD)D", "estimateCriticallyDamped", "secondRoot", "estimateOverDamped", "(Landroidx/compose/animation/core/ComplexDouble;Landroidx/compose/animation/core/ComplexDouble;DDD)D", "initialPosition", "estimateDurationInternal", "(Landroidx/compose/animation/core/ComplexDouble;Landroidx/compose/animation/core/ComplexDouble;DDDD)J", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        if (f2 == 0.0f) {
            return 9223372036854L;
        }
        return estimateAnimationDurationMillis(f, f2, f3, f4, f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        double dSqrt = 2.0d * d2 * Math.sqrt(d);
        double d6 = (dSqrt * dSqrt) - (4.0d * d);
        double d7 = -dSqrt;
        ComplexDouble complexDoubleComplexSqrt = ComplexDoubleKt.complexSqrt(d6);
        complexDoubleComplexSqrt._real += d7;
        complexDoubleComplexSqrt._real *= 0.5d;
        complexDoubleComplexSqrt._imaginary *= 0.5d;
        ComplexDouble complexDoubleComplexSqrt2 = ComplexDoubleKt.complexSqrt(d6);
        double d8 = -1;
        complexDoubleComplexSqrt2._real *= d8;
        complexDoubleComplexSqrt2._imaginary *= d8;
        complexDoubleComplexSqrt2._real += d7;
        complexDoubleComplexSqrt2._real *= 0.5d;
        complexDoubleComplexSqrt2._imaginary *= 0.5d;
        return estimateDurationInternal(complexDoubleComplexSqrt, complexDoubleComplexSqrt2, d2, d3, d4, d5);
    }

    private static final double estimateUnderDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double d4 = complexDouble.get_real();
        double d5 = (d2 - (d4 * d)) / complexDouble.get_imaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (d5 * d5))) / d4;
    }

    private static final double estimateCriticallyDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double d4 = d3;
        double d5 = complexDouble.get_real();
        double d6 = d5 * d;
        double d7 = d2 - d6;
        double dLog = Math.log(Math.abs(d4 / d)) / d5;
        double dLog2 = Math.log(Math.abs(d4 / d7));
        double dLog3 = dLog2;
        for (int i = 0; i < 6; i++) {
            dLog3 = dLog2 - Math.log(Math.abs(dLog3 / d5));
        }
        double d8 = dLog3 / d5;
        if (!((Double.isInfinite(dLog) || Double.isNaN(dLog)) ? false : true)) {
            dLog = d8;
        } else if ((Double.isInfinite(d8) || Double.isNaN(d8)) ? false : true) {
            dLog = Math.max(dLog, d8);
        }
        double d9 = (-(d6 + d7)) / (d5 * d7);
        double d10 = d5 * d9;
        double dExp = (Math.exp(d10) * d) + (d7 * d9 * Math.exp(d10));
        if (Double.isNaN(d9) || d9 <= ConfigValue.DOUBLE_DEFAULT_VALUE) {
            d4 = -d4;
        } else if (d9 <= ConfigValue.DOUBLE_DEFAULT_VALUE || (-dExp) >= d4) {
            dLog = (-(2.0d / d5)) - (d / d7);
        } else {
            if (d7 < ConfigValue.DOUBLE_DEFAULT_VALUE && d > ConfigValue.DOUBLE_DEFAULT_VALUE) {
                dLog = 0.0d;
            }
            d4 = -d4;
        }
        double dAbs = Double.MAX_VALUE;
        int i2 = 0;
        while (dAbs > 0.001d && i2 < 100) {
            i2++;
            double d11 = d5 * dLog;
            double d12 = d4;
            double dExp2 = dLog - ((((d + (d7 * dLog)) * Math.exp(d11)) + d4) / ((((1 + d11) * d7) + d6) * Math.exp(d11)));
            dAbs = Math.abs(dLog - dExp2);
            dLog = dExp2;
            d4 = d12;
        }
        return dLog;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final double estimateOverDamped(androidx.compose.animation.core.ComplexDouble r29, androidx.compose.animation.core.ComplexDouble r30, double r31, double r33, double r35) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d, double d2, double d3, double d4) {
        double dEstimateCriticallyDamped;
        double d5 = d2;
        if (d3 == ConfigValue.DOUBLE_DEFAULT_VALUE && d5 == ConfigValue.DOUBLE_DEFAULT_VALUE) {
            return 0L;
        }
        if (d3 < ConfigValue.DOUBLE_DEFAULT_VALUE) {
            d5 = -d5;
        }
        double dAbs = Math.abs(d3);
        if (d > 1.0d) {
            dEstimateCriticallyDamped = estimateOverDamped(complexDouble, complexDouble2, dAbs, d5, d4);
        } else if (d < 1.0d) {
            dEstimateCriticallyDamped = estimateUnderDamped(complexDouble, dAbs, d5, d4);
        } else {
            dEstimateCriticallyDamped = estimateCriticallyDamped(complexDouble, dAbs, d5, d4);
        }
        return (long) (dEstimateCriticallyDamped * 1000.0d);
    }
}
