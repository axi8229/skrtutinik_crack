package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* compiled from: Themes.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/YooTheme;", "", "()V", "colors", "Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "dimens", "Lru/yoomoney/sdk/guiCompose/theme/Dimens;", "getDimens", "(Landroidx/compose/runtime/Composer;I)Lru/yoomoney/sdk/guiCompose/theme/Dimens;", "typography", "Lru/yoomoney/sdk/guiCompose/theme/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Lru/yoomoney/sdk/guiCompose/theme/Typography;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YooTheme {
    public static final int $stable = 0;
    public static final YooTheme INSTANCE = new YooTheme();

    private YooTheme() {
    }

    public final YooColors getColors(Composer composer, int i) {
        composer.startReplaceableGroup(688974506);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(688974506, i, -1, "ru.yoomoney.sdk.guiCompose.theme.YooTheme.<get-colors> (Themes.kt:41)");
        }
        YooColors yooColors = (YooColors) composer.consume(ThemesKt.LocalYooColors);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return yooColors;
    }

    public final Dimens getDimens(Composer composer, int i) {
        composer.startReplaceableGroup(-943981937);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-943981937, i, -1, "ru.yoomoney.sdk.guiCompose.theme.YooTheme.<get-dimens> (Themes.kt:44)");
        }
        Dimens dimens = (Dimens) composer.consume(ThemesKt.LocalYooDimens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dimens;
    }

    public final Typography getTypography(Composer composer, int i) {
        composer.startReplaceableGroup(-1883904958);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1883904958, i, -1, "ru.yoomoney.sdk.guiCompose.theme.YooTheme.<get-typography> (Themes.kt:47)");
        }
        Typography typography = (Typography) composer.consume(ThemesKt.LocalYooTypography);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return typography;
    }
}
