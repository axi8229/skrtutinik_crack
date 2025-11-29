package ru.yoomoney.sdk.auth.ui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J/\u0010\u001c\u001a\u00020\u001d2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002¢\u0006\u0002\u0010\"J\u000e\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/ui/ColorScheme;", "", "()V", "accentColor", "", "Ljava/lang/Integer;", "accentFadeColor", "accentGhostColor", "secondaryAccentColor", "secondaryFadeColor", "secondaryGhostColor", "thirdAccentColor", "backgroundStateList", "Landroid/content/res/ColorStateList;", "context", "Landroid/content/Context;", "getAccentColor", "getAccentFadeColor", "getAccentGhostColor", "getBackgroundPrimaryButtonStateList", "getBackgroundSecondaryButtonStateList", "getSecondaryAccentColor", "getSecondaryFadeColor", "getSecondaryGhostColor", "getTextColorButtonStateList", "getThirdAccentColor", "()Ljava/lang/Integer;", "getThirdAccentColorForIcon", "setAccentColor", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "stateArray", "", "", "()[[I", "stateArrayButton", "typeColorStateList", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ColorScheme {
    public static final ColorScheme INSTANCE = new ColorScheme();
    private static Integer accentColor;
    private static Integer accentFadeColor;
    private static Integer accentGhostColor;
    private static Integer secondaryAccentColor;
    private static Integer secondaryFadeColor;
    private static Integer secondaryGhostColor;
    private static Integer thirdAccentColor;

    private ColorScheme() {
    }

    public static /* synthetic */ void setAccentColor$default(ColorScheme colorScheme, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        colorScheme.setAccentColor(num, num2, num3);
    }

    private final int[][] stateArray() {
        return new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    private final int[][] stateArrayButton() {
        return new int[][]{new int[]{-16842910}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_enabled}};
    }

    public final ColorStateList backgroundStateList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(stateArray(), new int[]{ContextCompat.getColor(context, ru.yoomoney.sdk.auth.R.color.color_ghost), getSecondaryAccentColor(context)});
    }

    public final int getAccentColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = accentColor;
        return num != null ? num.intValue() : GuiContextExtensions.getThemedColor(context, ru.yoomoney.sdk.auth.R.attr.colorTint);
    }

    public final int getAccentFadeColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = accentFadeColor;
        return num != null ? num.intValue() : GuiContextExtensions.getThemedColor(context, ru.yoomoney.sdk.auth.R.attr.colorFadeTint);
    }

    public final int getAccentGhostColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = accentGhostColor;
        return num != null ? num.intValue() : GuiContextExtensions.getThemedColor(context, ru.yoomoney.sdk.auth.R.attr.colorGhostTint);
    }

    public final ColorStateList getBackgroundPrimaryButtonStateList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(stateArrayButton(), new int[]{ContextCompat.getColor(context, ru.yoomoney.sdk.auth.R.color.color_ghost), getSecondaryFadeColor(context), getSecondaryAccentColor(context)});
    }

    public final ColorStateList getBackgroundSecondaryButtonStateList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(stateArrayButton(), new int[]{ContextCompat.getColor(context, ru.yoomoney.sdk.auth.R.color.color_type_ghost), getSecondaryFadeColor(context), getSecondaryGhostColor(context)});
    }

    public final int getSecondaryAccentColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = secondaryAccentColor;
        return num != null ? num.intValue() : getAccentColor(context);
    }

    public final int getSecondaryFadeColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = secondaryFadeColor;
        return num != null ? num.intValue() : getAccentFadeColor(context);
    }

    public final int getSecondaryGhostColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = secondaryGhostColor;
        return num != null ? num.intValue() : getAccentGhostColor(context);
    }

    public final ColorStateList getTextColorButtonStateList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int color = ContextCompat.getColor(context, ru.yoomoney.sdk.auth.R.color.color_type_ghost);
        Integer thirdAccentColor2 = getThirdAccentColor();
        return new ColorStateList(stateArray(), new int[]{color, thirdAccentColor2 != null ? thirdAccentColor2.intValue() : GuiContextExtensions.getThemedColor(context, ru.yoomoney.sdk.auth.R.attr.colorLink)});
    }

    public final Integer getThirdAccentColor() {
        return thirdAccentColor;
    }

    public final int getThirdAccentColorForIcon(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = thirdAccentColor;
        return num != null ? num.intValue() : getSecondaryAccentColor(context);
    }

    public final void setAccentColor(Integer accentColor2, Integer secondaryAccentColor2, Integer thirdAccentColor2) {
        accentColor = accentColor2;
        secondaryAccentColor = secondaryAccentColor2;
        thirdAccentColor = thirdAccentColor2;
        accentGhostColor = accentColor2 != null ? Integer.valueOf(ColorUtils.setAlphaComponent(accentColor2.intValue(), 40)) : null;
        secondaryGhostColor = secondaryAccentColor2 != null ? Integer.valueOf(ColorUtils.setAlphaComponent(secondaryAccentColor2.intValue(), 40)) : null;
        accentFadeColor = accentColor2 != null ? Integer.valueOf(ColorUtilsKt.adjustSaturationAndBrightness(accentColor2.intValue(), 0.5f, 0.9f)) : null;
        secondaryFadeColor = secondaryAccentColor2 != null ? Integer.valueOf(ColorUtilsKt.adjustSaturationAndBrightness(secondaryAccentColor2.intValue(), 0.5f, 0.9f)) : null;
    }

    public final ColorStateList typeColorStateList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(stateArray(), new int[]{ContextCompat.getColor(context, ru.yoomoney.sdk.auth.R.color.color_type_ghost), getAccentColor(context)});
    }
}
