package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import ru.yoomoney.sdk.guiCompose.R$font;

/* compiled from: Typography.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"defaultFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "getDefaultFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "typography", "Lru/yoomoney/sdk/guiCompose/theme/Typography;", "getTypography", "()Lru/yoomoney/sdk/guiCompose/theme/Typography;", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TypographyKt {
    private static final FontFamily defaultFontFamily;
    private static final Typography typography;

    public static final FontFamily getDefaultFontFamily() {
        return defaultFontFamily;
    }

    static {
        int i = R$font.roboto_light;
        FontWeight.Companion companion = FontWeight.INSTANCE;
        defaultFontFamily = FontFamilyKt.FontFamily(FontKt.m1835FontYpTlLL0$default(i, companion.getLight(), 0, 0, 12, null), FontKt.m1835FontYpTlLL0$default(R$font.roboto_regular, companion.getNormal(), 0, 0, 12, null), FontKt.m1835FontYpTlLL0$default(R$font.roboto_medium, companion.getMedium(), 0, 0, 12, null), FontKt.m1835FontYpTlLL0$default(R$font.roboto_bold, companion.getBold(), 0, 0, 12, null));
        typography = new Typography(null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public static final Typography getTypography() {
        return typography;
    }
}
