package ru.yoomoney.sdk.gui.utils.color;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;

/* compiled from: ColorStateSet.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\u0004\u001a\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/res/ColorStateList;", "getLinkTextColorState", "(Landroid/content/Context;)Landroid/content/res/ColorStateList;", "getFadeTextColorState", "getPrimaryTextColorState", "getPrimaryBackgroundColorState", "getFadeBackgroundColorState", "", "", "getStatesArray", "()[[I", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ColorStateSetKt {
    public static final ColorStateList getLinkTextColorState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(getStatesArray(), new int[]{ContextCompat.getColor(context, R$color.color_type_ghost_light), GuiContextExtensions.getThemedColor(context, R$attr.colorTint)});
    }

    public static final ColorStateList getFadeTextColorState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(getStatesArray(), new int[]{ContextCompat.getColor(context, R$color.color_type_ghost), GuiContextExtensions.getThemedColor(context, R$attr.colorFadeTint)});
    }

    public static final ColorStateList getPrimaryTextColorState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(getStatesArray(), new int[]{ContextCompat.getColor(context, R$color.color_type_ghost), ContextCompat.getColor(context, R$color.color_type_inverse)});
    }

    public static final ColorStateList getPrimaryBackgroundColorState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(getStatesArray(), new int[]{ContextCompat.getColor(context, R$color.color_ghost), GuiContextExtensions.getThemedColor(context, R$attr.colorTint)});
    }

    public static final ColorStateList getFadeBackgroundColorState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(getStatesArray(), new int[]{ContextCompat.getColor(context, R$color.color_ghost), GuiContextExtensions.getThemedColor(context, R$attr.colorGhostTint)});
    }

    private static final int[][] getStatesArray() {
        return new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }
}
