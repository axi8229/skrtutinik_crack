package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* compiled from: RippleTheme.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/YooRippleAlwaysBlackTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YooRippleAlwaysBlackTheme implements RippleTheme {
    public static final YooRippleAlwaysBlackTheme INSTANCE = new YooRippleAlwaysBlackTheme();

    private YooRippleAlwaysBlackTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    /* renamed from: defaultColor-WaAFU9c */
    public long mo689defaultColorWaAFU9c(Composer composer, int i) {
        composer.startReplaceableGroup(-2112988446);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2112988446, i, -1, "ru.yoomoney.sdk.guiCompose.theme.YooRippleAlwaysBlackTheme.defaultColor (RippleTheme.kt:55)");
        }
        long actionRippleInverse = BackgroundColors.INSTANCE.getDefaultColorsLight().getActionRippleInverse();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return actionRippleInverse;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public RippleAlpha rippleAlpha(Composer composer, int i) {
        composer.startReplaceableGroup(1690246503);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1690246503, i, -1, "ru.yoomoney.sdk.guiCompose.theme.YooRippleAlwaysBlackTheme.rippleAlpha (RippleTheme.kt:58)");
        }
        RippleAlpha rippleAlphaM699defaultRippleAlphaDxMtmZc = RippleTheme.INSTANCE.m699defaultRippleAlphaDxMtmZc(Color.INSTANCE.m986getBlack0d7_KjU(), true);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rippleAlphaM699defaultRippleAlphaDxMtmZc;
    }
}
