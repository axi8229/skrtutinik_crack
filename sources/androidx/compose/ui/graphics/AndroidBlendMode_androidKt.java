package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import androidx.compose.ui.graphics.BlendMode;
import kotlin.Metadata;

/* compiled from: AndroidBlendMode.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\b\u001a\u00020\u0005*\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0005H\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toAndroidBlendMode", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {

    /* compiled from: AndroidBlendMode.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[android.graphics.BlendMode.values().length];
            try {
                iArr[android.graphics.BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[android.graphics.BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[android.graphics.BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[android.graphics.BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[android.graphics.BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[android.graphics.BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[android.graphics.BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[android.graphics.BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[android.graphics.BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[android.graphics.BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[android.graphics.BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[android.graphics.BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[android.graphics.BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[android.graphics.BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[android.graphics.BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[android.graphics.BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[android.graphics.BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m888toPorterDuffModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.INSTANCE;
        if (BlendMode.m927equalsimpl0(i, companion.m930getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m953getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m936getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m957getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m940getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m955getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m938getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m956getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m939getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m954getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m937getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m958getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m949getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m951getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m948getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m934getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m944getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m927equalsimpl0(i, companion.m946getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m887toAndroidBlendModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.INSTANCE;
        return BlendMode.m927equalsimpl0(i, companion.m930getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m927equalsimpl0(i, companion.m953getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m927equalsimpl0(i, companion.m936getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m927equalsimpl0(i, companion.m957getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m927equalsimpl0(i, companion.m940getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m927equalsimpl0(i, companion.m955getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m927equalsimpl0(i, companion.m938getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m927equalsimpl0(i, companion.m956getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m927equalsimpl0(i, companion.m939getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m927equalsimpl0(i, companion.m954getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m927equalsimpl0(i, companion.m937getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m927equalsimpl0(i, companion.m958getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m927equalsimpl0(i, companion.m949getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m927equalsimpl0(i, companion.m946getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m927equalsimpl0(i, companion.m951getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m927equalsimpl0(i, companion.m948getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m927equalsimpl0(i, companion.m934getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m927equalsimpl0(i, companion.m944getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m927equalsimpl0(i, companion.m933getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m927equalsimpl0(i, companion.m932getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m927equalsimpl0(i, companion.m942getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m927equalsimpl0(i, companion.m952getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m927equalsimpl0(i, companion.m935getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m927equalsimpl0(i, companion.m941getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m927equalsimpl0(i, companion.m947getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m927equalsimpl0(i, companion.m943getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m927equalsimpl0(i, companion.m950getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m927equalsimpl0(i, companion.m931getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m927equalsimpl0(i, companion.m945getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(android.graphics.BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.INSTANCE.m930getClear0nO6VwU();
            case 2:
                return BlendMode.INSTANCE.m953getSrc0nO6VwU();
            case 3:
                return BlendMode.INSTANCE.m936getDst0nO6VwU();
            case 4:
                return BlendMode.INSTANCE.m957getSrcOver0nO6VwU();
            case 5:
                return BlendMode.INSTANCE.m940getDstOver0nO6VwU();
            case 6:
                return BlendMode.INSTANCE.m955getSrcIn0nO6VwU();
            case 7:
                return BlendMode.INSTANCE.m938getDstIn0nO6VwU();
            case 8:
                return BlendMode.INSTANCE.m956getSrcOut0nO6VwU();
            case 9:
                return BlendMode.INSTANCE.m939getDstOut0nO6VwU();
            case 10:
                return BlendMode.INSTANCE.m954getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.INSTANCE.m937getDstAtop0nO6VwU();
            case 12:
                return BlendMode.INSTANCE.m958getXor0nO6VwU();
            case 13:
                return BlendMode.INSTANCE.m949getPlus0nO6VwU();
            case 14:
                return BlendMode.INSTANCE.m946getModulate0nO6VwU();
            case 15:
                return BlendMode.INSTANCE.m951getScreen0nO6VwU();
            case 16:
                return BlendMode.INSTANCE.m948getOverlay0nO6VwU();
            case 17:
                return BlendMode.INSTANCE.m934getDarken0nO6VwU();
            case 18:
                return BlendMode.INSTANCE.m944getLighten0nO6VwU();
            case 19:
                return BlendMode.INSTANCE.m933getColorDodge0nO6VwU();
            case 20:
                return BlendMode.INSTANCE.m932getColorBurn0nO6VwU();
            case 21:
                return BlendMode.INSTANCE.m942getHardlight0nO6VwU();
            case 22:
                return BlendMode.INSTANCE.m952getSoftlight0nO6VwU();
            case 23:
                return BlendMode.INSTANCE.m935getDifference0nO6VwU();
            case 24:
                return BlendMode.INSTANCE.m941getExclusion0nO6VwU();
            case 25:
                return BlendMode.INSTANCE.m947getMultiply0nO6VwU();
            case 26:
                return BlendMode.INSTANCE.m943getHue0nO6VwU();
            case 27:
                return BlendMode.INSTANCE.m950getSaturation0nO6VwU();
            case 28:
                return BlendMode.INSTANCE.m931getColor0nO6VwU();
            case 29:
                return BlendMode.INSTANCE.m945getLuminosity0nO6VwU();
            default:
                return BlendMode.INSTANCE.m957getSrcOver0nO6VwU();
        }
    }
}
