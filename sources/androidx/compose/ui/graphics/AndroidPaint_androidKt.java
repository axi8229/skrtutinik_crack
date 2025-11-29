package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: AndroidPaint.android.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\u000e\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\n\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u0011\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u0013*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0019\u001a\u00020\u0018*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\"\u0010\u001d\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0018H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010 \u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u001eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\r\u001a\u0017\u0010!\u001a\u00020\u0013*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b!\u0010\u0015\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\"\u0010\u0017\u001a\u0017\u0010$\u001a\u00020#*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b$\u0010%\u001a\"\u0010'\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020#H\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010\r\u001a\u0017\u0010)\u001a\u00020(*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b)\u0010%\u001a\"\u0010+\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020(H\u0000ø\u0001\u0000¢\u0006\u0004\b*\u0010\r\u001a\u0017\u0010,\u001a\u00020\u0013*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b,\u0010\u0015\u001a\u001f\u0010-\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0004\b-\u0010\u0017\u001a\u0017\u0010/\u001a\u00020.*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b/\u0010%\u001a\"\u00101\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020.H\u0000ø\u0001\u0000¢\u0006\u0004\b0\u0010\r\u001a'\u00104\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u000e\u0010\u0010\u001a\n\u0018\u000102j\u0004\u0018\u0001`3H\u0000¢\u0006\u0004\b4\u00105\u001a!\u00107\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\b\u0010\u0010\u001a\u0004\u0018\u000106H\u0000¢\u0006\u0004\b7\u00108*\n\u00109\"\u00020\u00032\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Landroidx/compose/ui/graphics/Paint;", "Paint", "()Landroidx/compose/ui/graphics/Paint;", "Landroid/graphics/Paint;", "asComposePaint", "(Landroid/graphics/Paint;)Landroidx/compose/ui/graphics/Paint;", "makeNativePaint", "()Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "Landroidx/compose/ui/graphics/BlendMode;", "mode", "", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeBlendMode", "Landroidx/compose/ui/graphics/ColorFilter;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setNativeColorFilter", "(Landroid/graphics/Paint;Landroidx/compose/ui/graphics/ColorFilter;)V", "", "getNativeAlpha", "(Landroid/graphics/Paint;)F", "setNativeAlpha", "(Landroid/graphics/Paint;F)V", "Landroidx/compose/ui/graphics/Color;", "getNativeColor", "(Landroid/graphics/Paint;)J", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeColor", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeStyle--5YerkU", "setNativeStyle", "getNativeStrokeWidth", "setNativeStrokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "getNativeStrokeCap", "(Landroid/graphics/Paint;)I", "setNativeStrokeCap-CSYIeUk", "setNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeJoin;", "getNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "setNativeStrokeJoin", "getNativeStrokeMiterLimit", "setNativeStrokeMiterLimit", "Landroidx/compose/ui/graphics/FilterQuality;", "getNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativeFilterQuality", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativeShader", "(Landroid/graphics/Paint;Landroid/graphics/Shader;)V", "Landroidx/compose/ui/graphics/PathEffect;", "setNativePathEffect", "(Landroid/graphics/Paint;Landroidx/compose/ui/graphics/PathEffect;)V", "NativePaint", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidPaint_androidKt {

    /* compiled from: AndroidPaint.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(android.graphics.Paint paint) {
        return new AndroidPaint(paint);
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    /* renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m914setNativeBlendModeGB0RdKg(android.graphics.Paint paint, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m1110setBlendModeGB0RdKg(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m888toPorterDuffModes9anfk8(i)));
        }
    }

    public static final void setNativeColorFilter(android.graphics.Paint paint, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    public static final float getNativeAlpha(android.graphics.Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final void setNativeAlpha(android.graphics.Paint paint, float f) {
        paint.setAlpha((int) Math.rint(f * 255.0f));
    }

    public static final long getNativeColor(android.graphics.Paint paint) {
        return ColorKt.Color(paint.getColor());
    }

    /* renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m915setNativeColor4WTKRHQ(android.graphics.Paint paint, long j) {
        paint.setColor(ColorKt.m996toArgb8_81llA(j));
    }

    /* renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m919setNativeStyle5YerkU(android.graphics.Paint paint, int i) {
        paint.setStyle(PaintingStyle.m1055equalsimpl0(i, PaintingStyle.INSTANCE.m1057getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint paint, float f) {
        paint.setStrokeWidth(f);
    }

    public static final int getNativeStrokeCap(android.graphics.Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        if (i == 1) {
            return StrokeCap.INSTANCE.m1090getButtKaPHkGw();
        }
        if (i == 2) {
            return StrokeCap.INSTANCE.m1091getRoundKaPHkGw();
        }
        if (i == 3) {
            return StrokeCap.INSTANCE.m1092getSquareKaPHkGw();
        }
        return StrokeCap.INSTANCE.m1090getButtKaPHkGw();
    }

    /* renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m917setNativeStrokeCapCSYIeUk(android.graphics.Paint paint, int i) {
        Paint.Cap cap;
        StrokeCap.Companion companion = StrokeCap.INSTANCE;
        if (StrokeCap.m1087equalsimpl0(i, companion.m1092getSquareKaPHkGw())) {
            cap = Paint.Cap.SQUARE;
        } else if (StrokeCap.m1087equalsimpl0(i, companion.m1091getRoundKaPHkGw())) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = StrokeCap.m1087equalsimpl0(i, companion.m1090getButtKaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        if (i == 1) {
            return StrokeJoin.INSTANCE.m1098getMiterLxFBmk8();
        }
        if (i == 2) {
            return StrokeJoin.INSTANCE.m1097getBevelLxFBmk8();
        }
        if (i == 3) {
            return StrokeJoin.INSTANCE.m1099getRoundLxFBmk8();
        }
        return StrokeJoin.INSTANCE.m1098getMiterLxFBmk8();
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m918setNativeStrokeJoinkLtJ_vA(android.graphics.Paint paint, int i) {
        Paint.Join join;
        StrokeJoin.Companion companion = StrokeJoin.INSTANCE;
        if (StrokeJoin.m1094equalsimpl0(i, companion.m1098getMiterLxFBmk8())) {
            join = Paint.Join.MITER;
        } else if (StrokeJoin.m1094equalsimpl0(i, companion.m1097getBevelLxFBmk8())) {
            join = Paint.Join.BEVEL;
        } else {
            join = StrokeJoin.m1094equalsimpl0(i, companion.m1099getRoundLxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER;
        }
        paint.setStrokeJoin(join);
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint paint, float f) {
        paint.setStrokeMiter(f);
    }

    public static final int getNativeFilterQuality(android.graphics.Paint paint) {
        if (!paint.isFilterBitmap()) {
            return FilterQuality.INSTANCE.m1010getNonefv9h1I();
        }
        return FilterQuality.INSTANCE.m1009getLowfv9h1I();
    }

    /* renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m916setNativeFilterQuality50PEsBU(android.graphics.Paint paint, int i) {
        paint.setFilterBitmap(!FilterQuality.m1006equalsimpl0(i, FilterQuality.INSTANCE.m1010getNonefv9h1I()));
    }

    public static final void setNativeShader(android.graphics.Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void setNativePathEffect(android.graphics.Paint paint, PathEffect pathEffect) {
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }
}
