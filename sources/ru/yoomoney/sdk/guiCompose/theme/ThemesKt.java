package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Themes.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010\"\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/Palette;", "palette", "", "darkTheme", "Lru/yoomoney/sdk/guiCompose/theme/RippleType;", "rippleType", "Landroidx/compose/ui/text/font/FontFamily;", "fonts", "Lkotlin/Function0;", "", "content", "YooTheme", "(Lru/yoomoney/sdk/guiCompose/theme/Palette;ZLru/yoomoney/sdk/guiCompose/theme/RippleType;Landroidx/compose/ui/text/font/FontFamily;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "LocalYooColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lru/yoomoney/sdk/guiCompose/theme/Dimens;", "LocalYooDimens", "Lru/yoomoney/sdk/guiCompose/theme/Typography;", "LocalYooTypography", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThemesKt {
    private static final ProvidableCompositionLocal<YooColors> LocalYooColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<YooColors>() { // from class: ru.yoomoney.sdk.guiCompose.theme.ThemesKt$LocalYooColors$1
        @Override // kotlin.jvm.functions.Function0
        public final YooColors invoke() {
            return YooColors.INSTANCE.getDefaultColorsLight();
        }
    });
    private static final ProvidableCompositionLocal<Dimens> LocalYooDimens = CompositionLocalKt.staticCompositionLocalOf(new Function0<Dimens>() { // from class: ru.yoomoney.sdk.guiCompose.theme.ThemesKt$LocalYooDimens$1
        @Override // kotlin.jvm.functions.Function0
        public final Dimens invoke() {
            return DimensKt.getDimens();
        }
    });
    private static final ProvidableCompositionLocal<Typography> LocalYooTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0<Typography>() { // from class: ru.yoomoney.sdk.guiCompose.theme.ThemesKt$LocalYooTypography$1
        @Override // kotlin.jvm.functions.Function0
        public final Typography invoke() {
            return TypographyKt.getTypography();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:100:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void YooTheme(ru.yoomoney.sdk.guiCompose.theme.Palette r33, boolean r34, ru.yoomoney.sdk.guiCompose.theme.RippleType r35, androidx.compose.ui.text.font.FontFamily r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.theme.ThemesKt.YooTheme(ru.yoomoney.sdk.guiCompose.theme.Palette, boolean, ru.yoomoney.sdk.guiCompose.theme.RippleType, androidx.compose.ui.text.font.FontFamily, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
