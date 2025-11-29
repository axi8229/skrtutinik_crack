package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Connector.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB;\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "source", "destination", "transformSource", "transformDestination", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "renderIntent", "", "transform", "<init>", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "transformToColor", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getSource", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getDestination", "I", "getRenderIntent-uksYyKA", "()I", "[F", "Companion", "RgbConnector", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class Connector {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ColorSpace destination;
    private final int renderIntent;
    private final ColorSpace source;
    private final float[] transform;
    private final ColorSpace transformDestination;
    private final ColorSpace transformSource;

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, i);
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i, float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, colorSpace3, colorSpace4, i, fArr);
    }

    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i, float[] fArr) {
        this.source = colorSpace;
        this.destination = colorSpace2;
        this.transformSource = colorSpace3;
        this.transformDestination = colorSpace4;
        this.renderIntent = i;
        this.transform = fArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
        long model = colorSpace.getModel();
        ColorModel.Companion companion = ColorModel.INSTANCE;
        this(colorSpace, colorSpace2, ColorModel.m1112equalsimpl0(model, companion.m1117getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace, ColorModel.m1112equalsimpl0(colorSpace2.getModel(), companion.m1117getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace2, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace2, i, INSTANCE.m1126computeTransformYBCOT_4(colorSpace, colorSpace2, i), null);
    }

    /* compiled from: Connector.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mSource", "mDestination", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "<init>", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "source", "destination", "", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "computeTransform", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "transformToColor", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mTransform", "[F", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RgbConnector extends Connector {
        private final Rgb mDestination;
        private final Rgb mSource;
        private final float[] mTransform;

        public /* synthetic */ RgbConnector(Rgb rgb, Rgb rgb2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rgb, rgb2, i);
        }

        private RgbConnector(Rgb rgb, Rgb rgb2, int i) {
            super(rgb, rgb2, rgb, rgb2, i, null, null);
            this.mSource = rgb;
            this.mDestination = rgb2;
            this.mTransform = m1127computeTransformYBCOT_4(rgb, rgb2, i);
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        /* renamed from: transformToColor-l2rxGTc$ui_graphics_release */
        public long mo1124transformToColorl2rxGTc$ui_graphics_release(long color) {
            float fM982getRedimpl = Color.m982getRedimpl(color);
            float fM981getGreenimpl = Color.m981getGreenimpl(color);
            float fM979getBlueimpl = Color.m979getBlueimpl(color);
            float fM978getAlphaimpl = Color.m978getAlphaimpl(color);
            float fInvoke = (float) this.mSource.getEotfFunc().invoke(fM982getRedimpl);
            float fInvoke2 = (float) this.mSource.getEotfFunc().invoke(fM981getGreenimpl);
            float fInvoke3 = (float) this.mSource.getEotfFunc().invoke(fM979getBlueimpl);
            float[] fArr = this.mTransform;
            return ColorKt.Color((float) this.mDestination.getOetfFunc().invoke((fArr[0] * fInvoke) + (fArr[3] * fInvoke2) + (fArr[6] * fInvoke3)), (float) this.mDestination.getOetfFunc().invoke((fArr[1] * fInvoke) + (fArr[4] * fInvoke2) + (fArr[7] * fInvoke3)), (float) this.mDestination.getOetfFunc().invoke((fArr[2] * fInvoke) + (fArr[5] * fInvoke2) + (fArr[8] * fInvoke3)), fM978getAlphaimpl, this.mDestination);
        }

        /* renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        private final float[] m1127computeTransformYBCOT_4(Rgb source, Rgb destination, int intent) {
            if (ColorSpaceKt.compare(source.getWhitePoint(), destination.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(destination.getInverseTransform(), source.getTransform());
            }
            float[] transform = source.getTransform();
            float[] inverseTransform = destination.getInverseTransform();
            float[] xyz$ui_graphics_release = source.getWhitePoint().toXyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = destination.getWhitePoint().toXyz$ui_graphics_release();
            WhitePoint whitePoint = source.getWhitePoint();
            Illuminant illuminant = Illuminant.INSTANCE;
            if (!ColorSpaceKt.compare(whitePoint, illuminant.getD50())) {
                float[] transform2 = Adaptation.INSTANCE.getBradford().getTransform();
                float[] d50Xyz$ui_graphics_release = illuminant.getD50Xyz$ui_graphics_release();
                float[] fArrCopyOf = Arrays.copyOf(d50Xyz$ui_graphics_release, d50Xyz$ui_graphics_release.length);
                Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(this, size)");
                transform = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform2, xyz$ui_graphics_release, fArrCopyOf), source.getTransform());
            }
            if (!ColorSpaceKt.compare(destination.getWhitePoint(), illuminant.getD50())) {
                float[] transform3 = Adaptation.INSTANCE.getBradford().getTransform();
                float[] d50Xyz$ui_graphics_release2 = illuminant.getD50Xyz$ui_graphics_release();
                float[] fArrCopyOf2 = Arrays.copyOf(d50Xyz$ui_graphics_release2, d50Xyz$ui_graphics_release2.length);
                Intrinsics.checkNotNullExpressionValue(fArrCopyOf2, "copyOf(this, size)");
                inverseTransform = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform3, xyz$ui_graphics_release2, fArrCopyOf2), destination.getTransform()));
            }
            if (RenderIntent.m1129equalsimpl0(intent, RenderIntent.INSTANCE.m1130getAbsoluteuksYyKA())) {
                transform = ColorSpaceKt.mul3x3Diag(new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]}, transform);
            }
            return ColorSpaceKt.mul3x3(inverseTransform, transform);
        }
    }

    /* renamed from: transformToColor-l2rxGTc$ui_graphics_release, reason: not valid java name */
    public long mo1124transformToColorl2rxGTc$ui_graphics_release(long color) {
        float fM982getRedimpl = Color.m982getRedimpl(color);
        float fM981getGreenimpl = Color.m981getGreenimpl(color);
        float fM979getBlueimpl = Color.m979getBlueimpl(color);
        float fM978getAlphaimpl = Color.m978getAlphaimpl(color);
        long xy$ui_graphics_release = this.transformSource.toXy$ui_graphics_release(fM982getRedimpl, fM981getGreenimpl, fM979getBlueimpl);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (xy$ui_graphics_release >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (xy$ui_graphics_release & 4294967295L));
        float z$ui_graphics_release = this.transformSource.toZ$ui_graphics_release(fM982getRedimpl, fM981getGreenimpl, fM979getBlueimpl);
        float[] fArr = this.transform;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            z$ui_graphics_release *= fArr[2];
        }
        float f = fIntBitsToFloat;
        return this.transformDestination.mo1120xyzaToColorJlNiLsg$ui_graphics_release(f, fIntBitsToFloat2, z$ui_graphics_release, fM978getAlphaimpl, this.destination);
    }

    /* compiled from: Connector.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", "", "()V", "computeTransform", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", "identity", "Landroidx/compose/ui/graphics/colorspace/Connector;", "identity$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        public final float[] m1126computeTransformYBCOT_4(ColorSpace source, ColorSpace destination, int intent) {
            if (!RenderIntent.m1129equalsimpl0(intent, RenderIntent.INSTANCE.m1130getAbsoluteuksYyKA())) {
                return null;
            }
            long model = source.getModel();
            ColorModel.Companion companion = ColorModel.INSTANCE;
            boolean zM1112equalsimpl0 = ColorModel.m1112equalsimpl0(model, companion.m1117getRgbxdoWZVw());
            boolean zM1112equalsimpl02 = ColorModel.m1112equalsimpl0(destination.getModel(), companion.m1117getRgbxdoWZVw());
            if (zM1112equalsimpl0 && zM1112equalsimpl02) {
                return null;
            }
            if (!zM1112equalsimpl0 && !zM1112equalsimpl02) {
                return null;
            }
            if (!zM1112equalsimpl0) {
                source = destination;
            }
            Intrinsics.checkNotNull(source, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) source;
            float[] xyz$ui_graphics_release = zM1112equalsimpl0 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = zM1112equalsimpl02 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            return new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]};
        }

        public final Connector identity$ui_graphics_release(final ColorSpace source) {
            final int iM1132getRelativeuksYyKA = RenderIntent.INSTANCE.m1132getRelativeuksYyKA();
            return new Connector(source, iM1132getRelativeuksYyKA) { // from class: androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1
                @Override // androidx.compose.ui.graphics.colorspace.Connector
                /* renamed from: transformToColor-l2rxGTc$ui_graphics_release */
                public long mo1124transformToColorl2rxGTc$ui_graphics_release(long color) {
                    return color;
                }

                {
                    super(source, source, iM1132getRelativeuksYyKA, null);
                }
            };
        }
    }
}
