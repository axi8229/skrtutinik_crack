package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.LineHeightStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: Typography.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\" \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/font/FontFamily;", "default", "withDefaultFontFamily", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily;)Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultLineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefaultLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Typography;", "LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypographyKt {
    private static final LineHeightStyle DefaultLineHeightStyle;
    private static final TextStyle DefaultTextStyle;
    private static final ProvidableCompositionLocal<Typography> LocalTypography;

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        if (textStyle.getFontFamily() != null) {
            return textStyle;
        }
        return textStyle.m1802copyp1EtxEg((15204351 & 1) != 0 ? textStyle.spanStyle.m1763getColor0d7_KjU() : 0L, (15204351 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (15204351 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (15204351 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (15204351 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (15204351 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (15204351 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (15204351 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (15204351 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (15204351 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (15204351 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (15204351 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (15204351 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (15204351 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (15204351 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (15204351 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (15204351 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (15204351 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (15204351 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (15204351 & 524288) != 0 ? textStyle.platformStyle : null, (15204351 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (15204351 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (15204351 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (15204351 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
    }

    static {
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m2017getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m2026getNoneEVpEnUU(), null);
        DefaultLineHeightStyle = lineHeightStyle;
        TextStyle textStyle = TextStyle.INSTANCE.getDefault();
        DefaultTextStyle = textStyle.m1802copyp1EtxEg((15204351 & 1) != 0 ? textStyle.spanStyle.m1763getColor0d7_KjU() : 0L, (15204351 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (15204351 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (15204351 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (15204351 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (15204351 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (15204351 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (15204351 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (15204351 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (15204351 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (15204351 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (15204351 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (15204351 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (15204351 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (15204351 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (15204351 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (15204351 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (15204351 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (15204351 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (15204351 & 524288) != 0 ? textStyle.platformStyle : DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), (15204351 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle, (15204351 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (15204351 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (15204351 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
        LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0<Typography>() { // from class: androidx.compose.material.TypographyKt$LocalTypography$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Typography invoke() {
                return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
            }
        });
    }

    public static final TextStyle getDefaultTextStyle() {
        return DefaultTextStyle;
    }

    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }
}
