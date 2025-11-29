package ru.yoomoney.sdk.gui.widget.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.utils.extensions.DeviceUtilKt;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;

/* compiled from: ButtonUtils.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0006\u001a+\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a?\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001b\u0010\u001a\u001a\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b \u0010!\u001a\u0017\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\"\u0010!¨\u0006#"}, d2 = {"Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Landroid/graphics/drawable/Drawable;", "createDrawable", "getPrimaryButtonBackground", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Landroid/graphics/drawable/Drawable;", "actionDrawable", "pressedDrawable", "disabledDrawable", "rippleColor", "Landroid/graphics/drawable/StateListDrawable;", "generateStateListDrawable", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;I)Landroid/graphics/drawable/StateListDrawable;", "mask", "getTagButtonBackground", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;ILandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "", "radius", RemoteMessageConst.Notification.COLOR, "Landroid/graphics/drawable/GradientDrawable;", "roundRectDrawable", "(FI)Landroid/graphics/drawable/GradientDrawable;", "Landroid/content/res/ColorStateList;", "getLinkTextColor", "(Landroid/content/Context;)Landroid/content/res/ColorStateList;", "getAlertTextColor", "", "", "getStatesArray", "()[[I", "getLinkColorsArray", "(Landroid/content/Context;)[I", "getAlertColorsArray", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ButtonUtilsKt {
    public static /* synthetic */ Drawable getPrimaryButtonBackground$default(final Context context, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, GradientDrawable>() { // from class: ru.yoomoney.sdk.gui.widget.button.ButtonUtilsKt.getPrimaryButtonBackground.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ GradientDrawable invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final GradientDrawable invoke(int i2) {
                    return ButtonUtilsKt.roundRectDrawable(context.getResources().getDimension(R$dimen.ym_spaceXS), i2);
                }
            };
        }
        return getPrimaryButtonBackground(context, function1);
    }

    public static final Drawable getPrimaryButtonBackground(Context context, Function1<? super Integer, ? extends Drawable> createDrawable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(createDrawable, "createDrawable");
        int themedColor = GuiContextExtensions.getThemedColor(context, R$attr.colorTint);
        int color = ContextCompat.getColor(context, R$color.color_ripple_inverse);
        return generateStateListDrawable(createDrawable.invoke(Integer.valueOf(themedColor)), createDrawable.invoke(Integer.valueOf(color)), createDrawable.invoke(Integer.valueOf(ContextCompat.getColor(context, R$color.color_ghost))), color);
    }

    private static final StateListDrawable generateStateListDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (DeviceUtilKt.supportLollipop()) {
            stateListDrawable.addState(new int[]{-16842910}, drawable3);
            stateListDrawable.addState(StateSet.WILD_CARD, new RippleDrawable(ColorStateList.valueOf(i), drawable, drawable));
        } else {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable2);
            stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawable);
            stateListDrawable.addState(new int[]{-16842910}, drawable3);
            stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        }
        return stateListDrawable;
    }

    public static /* synthetic */ Drawable getTagButtonBackground$default(Context context, Function1 function1, int i, Drawable drawable, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = ContextCompat.getColor(context, R$color.color_ripple_inverse);
        }
        if ((i2 & 8) != 0) {
            drawable = null;
        }
        return getTagButtonBackground(context, function1, i, drawable);
    }

    public static final Drawable getTagButtonBackground(Context context, Function1<? super Integer, ? extends Drawable> createDrawable, int i, Drawable drawable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(createDrawable, "createDrawable");
        int themedColor = GuiContextExtensions.getThemedColor(context, R$attr.colorTint);
        int color = ContextCompat.getColor(context, R$color.color_ghost);
        int iBlendARGB = ColorUtils.blendARGB(themedColor, color, 0.5f);
        Drawable drawableInvoke = createDrawable.invoke(Integer.valueOf(themedColor));
        createDrawable.invoke(Integer.valueOf(iBlendARGB));
        Drawable drawableInvoke2 = createDrawable.invoke(Integer.valueOf(color));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, drawableInvoke2);
        int[] iArr = StateSet.WILD_CARD;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (drawable == null) {
            drawable = drawableInvoke;
        }
        stateListDrawable.addState(iArr, new RippleDrawable(colorStateListValueOf, drawableInvoke, drawable));
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GradientDrawable roundRectDrawable(float f, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    public static final ColorStateList getLinkTextColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(getStatesArray(), getLinkColorsArray(context));
    }

    public static final ColorStateList getAlertTextColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(getStatesArray(), getAlertColorsArray(context));
    }

    private static final int[][] getStatesArray() {
        return new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    private static final int[] getLinkColorsArray(Context context) {
        return new int[]{ContextCompat.getColor(context, R$color.color_type_ghost), GuiContextExtensions.getThemedColor(context, R$attr.colorTint)};
    }

    private static final int[] getAlertColorsArray(Context context) {
        return new int[]{ContextCompat.getColor(context, R$color.color_type_ghost), ContextCompat.getColor(context, R$color.color_alert)};
    }
}
