package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RippleTheme.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/RippleType;", "type", "Lkotlin/Function0;", "", "content", "RippleTheme", "(Lru/yoomoney/sdk/guiCompose/theme/RippleType;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RippleThemeKt {

    /* compiled from: RippleTheme.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RippleType.values().length];
            try {
                iArr[RippleType.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RippleType.Inverse.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RippleType.Colored.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RippleType.AlwaysWhite.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RippleType.AlwaysBlack.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void RippleTheme(final RippleType rippleType, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        RippleTheme rippleTheme;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1284729688);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(rippleType) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                rippleType = RippleType.Colored;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1284729688, i3, -1, "ru.yoomoney.sdk.guiCompose.theme.RippleTheme (RippleTheme.kt:68)");
            }
            int i5 = WhenMappings.$EnumSwitchMapping$0[rippleType.ordinal()];
            if (i5 == 1) {
                rippleTheme = YooRippleTheme.INSTANCE;
            } else if (i5 == 2) {
                rippleTheme = YooRippleInverseTheme.INSTANCE;
            } else if (i5 == 3) {
                rippleTheme = YooRippleColoredTheme.INSTANCE;
            } else if (i5 == 4) {
                rippleTheme = YooRippleAlwaysWhiteTheme.INSTANCE;
            } else {
                if (i5 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                rippleTheme = YooRippleAlwaysBlackTheme.INSTANCE;
            }
            CompositionLocalKt.CompositionLocalProvider(androidx.compose.material.ripple.RippleThemeKt.getLocalRippleTheme().provides(rippleTheme), content, composerStartRestartGroup, (i3 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.theme.RippleThemeKt.RippleTheme.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    RippleThemeKt.RippleTheme(rippleType, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
