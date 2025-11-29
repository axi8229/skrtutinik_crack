package ru.yoomoney.sdk.guiCompose.views.chips;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Chips.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0004H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u0004H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u0004H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/chips/ChipViewStyle;", "", "(Ljava/lang/String;I)V", "getBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor-WaAFU9c$guiCompose_release", "(Landroidx/compose/runtime/Composer;I)J", "getDisabledBackgroundColor", "getDisabledBackgroundColor-WaAFU9c$guiCompose_release", "getDisabledTextColor", "getDisabledTextColor-WaAFU9c$guiCompose_release", "getTextColor", "getTextColor-WaAFU9c$guiCompose_release", "Tint", "FadeTint", "Alert", "Success", "Inverse", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChipViewStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChipViewStyle[] $VALUES;
    public static final ChipViewStyle Tint = new ChipViewStyle("Tint", 0);
    public static final ChipViewStyle FadeTint = new ChipViewStyle("FadeTint", 1);
    public static final ChipViewStyle Alert = new ChipViewStyle("Alert", 2);
    public static final ChipViewStyle Success = new ChipViewStyle("Success", 3);
    public static final ChipViewStyle Inverse = new ChipViewStyle("Inverse", 4);

    /* compiled from: Chips.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChipViewStyle.values().length];
            try {
                iArr[ChipViewStyle.Tint.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChipViewStyle.FadeTint.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChipViewStyle.Alert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChipViewStyle.Success.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ChipViewStyle.Inverse.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ChipViewStyle[] $values() {
        return new ChipViewStyle[]{Tint, FadeTint, Alert, Success, Inverse};
    }

    public static ChipViewStyle valueOf(String str) {
        return (ChipViewStyle) Enum.valueOf(ChipViewStyle.class, str);
    }

    public static ChipViewStyle[] values() {
        return (ChipViewStyle[]) $VALUES.clone();
    }

    private ChipViewStyle(String str, int i) {
    }

    static {
        ChipViewStyle[] chipViewStyleArr$values = $values();
        $VALUES = chipViewStyleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(chipViewStyleArr$values);
    }

    /* renamed from: getTextColor-WaAFU9c$guiCompose_release, reason: not valid java name */
    public final long m3435getTextColorWaAFU9c$guiCompose_release(Composer composer, int i) {
        long inverse;
        composer.startReplaceableGroup(-44886318);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-44886318, i, -1, "ru.yoomoney.sdk.guiCompose.views.chips.ChipViewStyle.getTextColor (Chips.kt:47)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            composer.startReplaceableGroup(-1930283335);
            inverse = YooTheme.INSTANCE.getColors(composer, 6).getType().getInverse();
            composer.endReplaceableGroup();
        } else if (i2 == 2) {
            composer.startReplaceableGroup(-1930283285);
            inverse = YooTheme.INSTANCE.getColors(composer, 6).getTheme().getTint();
            composer.endReplaceableGroup();
        } else if (i2 == 3) {
            composer.startReplaceableGroup(-1930283242);
            inverse = YooTheme.INSTANCE.getColors(composer, 6).getType().getInverse();
            composer.endReplaceableGroup();
        } else if (i2 == 4) {
            composer.startReplaceableGroup(-1930283194);
            inverse = YooTheme.INSTANCE.getColors(composer, 6).getType().getInverse();
            composer.endReplaceableGroup();
        } else {
            if (i2 != 5) {
                composer.startReplaceableGroup(-1930285117);
                composer.endReplaceableGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceableGroup(-1930283145);
            inverse = YooTheme.INSTANCE.getColors(composer, 6).getTheme().getTint();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return inverse;
    }

    /* renamed from: getDisabledTextColor-WaAFU9c$guiCompose_release, reason: not valid java name */
    public final long m3434getDisabledTextColorWaAFU9c$guiCompose_release(Composer composer, int i) {
        long disable;
        composer.startReplaceableGroup(1314403766);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1314403766, i, -1, "ru.yoomoney.sdk.guiCompose.views.chips.ChipViewStyle.getDisabledTextColor (Chips.kt:56)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            composer.startReplaceableGroup(1772784069);
            disable = YooTheme.INSTANCE.getColors(composer, 6).getType().getDisable();
            composer.endReplaceableGroup();
        } else {
            if (i2 != 5) {
                composer.startReplaceableGroup(1772781919);
                composer.endReplaceableGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceableGroup(1772784117);
            disable = YooTheme.INSTANCE.getColors(composer, 6).getType().getGhostInverse();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return disable;
    }

    /* renamed from: getBackgroundColor-WaAFU9c$guiCompose_release, reason: not valid java name */
    public final long m3432getBackgroundColorWaAFU9c$guiCompose_release(Composer composer, int i) {
        long tint;
        composer.startReplaceableGroup(-1541382159);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1541382159, i, -1, "ru.yoomoney.sdk.guiCompose.views.chips.ChipViewStyle.getBackgroundColor (Chips.kt:65)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            composer.startReplaceableGroup(-733302623);
            tint = YooTheme.INSTANCE.getColors(composer, 6).getTheme().getTint();
            composer.endReplaceableGroup();
        } else if (i2 == 2) {
            composer.startReplaceableGroup(-733302576);
            tint = YooTheme.INSTANCE.getColors(composer, 6).getTheme().getTintGhost();
            composer.endReplaceableGroup();
        } else if (i2 == 3) {
            composer.startReplaceableGroup(-733302522);
            tint = YooTheme.INSTANCE.getColors(composer, 6).getBackground().getAlert();
            composer.endReplaceableGroup();
        } else if (i2 == 4) {
            composer.startReplaceableGroup(-733302470);
            tint = YooTheme.INSTANCE.getColors(composer, 6).getBackground().getSuccess();
            composer.endReplaceableGroup();
        } else {
            if (i2 != 5) {
                composer.startReplaceableGroup(-733304956);
                composer.endReplaceableGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceableGroup(-733302416);
            tint = YooTheme.INSTANCE.getColors(composer, 6).getBackground().getCard();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tint;
    }

    /* renamed from: getDisabledBackgroundColor-WaAFU9c$guiCompose_release, reason: not valid java name */
    public final long m3433getDisabledBackgroundColorWaAFU9c$guiCompose_release(Composer composer, int i) {
        long actionRipple;
        composer.startReplaceableGroup(1969472469);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1969472469, i, -1, "ru.yoomoney.sdk.guiCompose.views.chips.ChipViewStyle.getDisabledBackgroundColor (Chips.kt:74)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            composer.startReplaceableGroup(1544445642);
            actionRipple = YooTheme.INSTANCE.getColors(composer, 6).getBackground().getActionRipple();
            composer.endReplaceableGroup();
        } else {
            if (i2 != 5) {
                composer.startReplaceableGroup(1544442912);
                composer.endReplaceableGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceableGroup(1544445701);
            actionRipple = YooTheme.INSTANCE.getColors(composer, 6).getBackground().getActionRippleInverse();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return actionRipple;
    }
}
