package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidColorSpace.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", "", "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    @JvmStatic
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace.Rgb.TransferParameters transferParametersM;
        ColorSpace.Rgb rgbM;
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getSrgb())) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAces())) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAcescg())) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAdobeRgb())) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getBt2020())) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getBt709())) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getCieLab())) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getCieXyz())) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getDciP3())) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getDisplayP3())) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getLinearExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getLinearSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getNtsc1953())) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getProPhotoRgb())) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getSmpteC())) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (colorSpace instanceof Rgb) {
            Rgb rgb = (Rgb) colorSpace;
            float[] xyz$ui_graphics_release = rgb.getWhitePoint().toXyz$ui_graphics_release();
            TransferParameters transferParameters = rgb.getTransferParameters();
            if (transferParameters != null) {
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline3.m();
                transferParametersM = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline0.m(transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
            } else {
                transferParametersM = null;
            }
            if (transferParametersM != null) {
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline4.m();
                rgbM = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline1.m(colorSpace.getName(), rgb.getPrimaries(), xyz$ui_graphics_release, transferParametersM);
            } else {
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline4.m();
                String name = colorSpace.getName();
                float[] primaries = rgb.getPrimaries();
                final Function1<Double, Double> oetf = rgb.getOetf();
                DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda44
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        return ColorSpaceVerificationHelper.androidColorSpace$lambda$0(oetf, d);
                    }
                };
                final Function1<Double, Double> eotf = rgb.getEotf();
                rgbM = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline2.m(name, primaries, xyz$ui_graphics_release, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda45
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        return ColorSpaceVerificationHelper.androidColorSpace$lambda$1(eotf, d);
                    }
                }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0));
            }
            return ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline19.m(rgbM);
        }
        return ColorSpace.get(ColorSpace.Named.SRGB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$0(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$1(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(final ColorSpace colorSpace) {
        WhitePoint whitePoint;
        int id = colorSpace.getId();
        if (id == ColorSpace.Named.SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (id == ColorSpace.Named.ACES.ordinal()) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (id == ColorSpace.Named.ACESCG.ordinal()) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (id == ColorSpace.Named.ADOBE_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (id == ColorSpace.Named.BT2020.ordinal()) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (id == ColorSpace.Named.BT709.ordinal()) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (id == ColorSpace.Named.CIE_LAB.ordinal()) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (id == ColorSpace.Named.CIE_XYZ.ordinal()) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (id == ColorSpace.Named.DCI_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (id == ColorSpace.Named.DISPLAY_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (id == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (id == ColorSpace.Named.NTSC_1953.ordinal()) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (id == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (id == ColorSpace.Named.SMPTE_C.ordinal()) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        if (ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline25.m(colorSpace)) {
            ColorSpace.Rgb.TransferParameters transferParameters = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getTransferParameters();
            if (ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getWhitePoint().length == 3) {
                whitePoint = new WhitePoint(ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getWhitePoint()[0], ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getWhitePoint()[1], ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getWhitePoint()[2]);
            } else {
                whitePoint = new WhitePoint(ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getWhitePoint()[0], ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getWhitePoint()[1]);
            }
            return new Rgb(ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getName(), ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getPrimaries(), whitePoint, ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getTransform(), new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda46
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    return ColorSpaceVerificationHelper.composeColorSpace$lambda$2(colorSpace, d);
                }
            }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda47
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    return ColorSpaceVerificationHelper.composeColorSpace$lambda$3(colorSpace, d);
                }
            }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0), transferParameters != null ? new TransferParameters(transferParameters.g, transferParameters.a, transferParameters.b, transferParameters.c, transferParameters.d, transferParameters.e, transferParameters.f) : null, ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getId());
        }
        return ColorSpaces.INSTANCE.getSrgb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$2(ColorSpace colorSpace, double d) {
        return ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getOetf().applyAsDouble(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$3(ColorSpace colorSpace, double d) {
        return ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m(colorSpace).getEotf().applyAsDouble(d);
    }
}
