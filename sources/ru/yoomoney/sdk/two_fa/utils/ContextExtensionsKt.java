package ru.yoomoney.sdk.two_fa.utils;

import android.content.Context;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;
import ru.yoomoney.sdk.guiCompose.theme.Palette;
import ru.yoomoney.sdk.guiCompose.theme.ThemeColors;
import ru.yoomoney.sdk.guiCompose.theme.YooColors;
import ru.yoomoney.sdk.two_fa.R;

/* compiled from: ContextExtensions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005¨\u0006\u0006"}, d2 = {"accentColorToComposePalette", "Lru/yoomoney/sdk/guiCompose/theme/Palette;", "colorInt", "", "currentThemeToComposePalette", "Landroid/content/Context;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContextExtensionsKt {
    public static final Palette currentThemeToComposePalette(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        long jColor = ColorKt.Color(GuiContextExtensions.getThemedColor(context, R$attr.colorTint));
        YooColors.Companion companion = YooColors.INSTANCE;
        YooColors defaultColorsLight = companion.getDefaultColorsLight();
        int i = R.attr.colorBgTint;
        long jColor2 = ColorKt.Color(GuiContextExtensions.getThemedColor(context, i));
        int i2 = R.attr.colorCardTint;
        return new Palette(YooColors.copy$default(defaultColorsLight, null, null, new ThemeColors(jColor, 0L, 0L, jColor2, ColorKt.Color(GuiContextExtensions.getThemedColor(context, i2)), 0L, 38, null), 3, null), YooColors.copy$default(companion.getDefaultColorsDark(), null, null, new ThemeColors(jColor, 0L, 0L, ColorKt.Color(GuiContextExtensions.getThemedColor(context, i)), ColorKt.Color(GuiContextExtensions.getThemedColor(context, i2)), 0L, 38, null), 3, null));
    }

    public static final Palette accentColorToComposePalette(int i) {
        YooColors.Companion companion = YooColors.INSTANCE;
        return new Palette(YooColors.copy$default(companion.getDefaultColorsLight(), null, null, new ThemeColors(ColorKt.Color(i), 0L, 0L, companion.getDefaultColorsLight().getTheme().getTintBg(), companion.getDefaultColorsLight().getTheme().getTintCard(), 0L, 38, null), 3, null), YooColors.copy$default(companion.getDefaultColorsDark(), null, null, new ThemeColors(ColorKt.Color(i), 0L, 0L, companion.getDefaultColorsDark().getTheme().getTintBg(), companion.getDefaultColorsDark().getTheme().getTintCard(), 0L, 38, null), 3, null));
    }
}
