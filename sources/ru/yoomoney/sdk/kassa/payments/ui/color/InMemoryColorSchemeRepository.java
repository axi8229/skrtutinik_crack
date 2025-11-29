package ru.yoomoney.sdk.kassa.payments.ui.color;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$color;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/color/InMemoryColorSchemeRepository;", "", "()V", "colorScheme", "Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;", "getColorScheme", "()Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;", "setColorScheme", "(Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;)V", "backgroundStateList", "Landroid/content/res/ColorStateList;", "context", "Landroid/content/Context;", "stateArray", "", "", "()[[I", "typeColorStateList", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InMemoryColorSchemeRepository {
    public static final InMemoryColorSchemeRepository INSTANCE = new InMemoryColorSchemeRepository();
    private static ColorScheme colorScheme = ColorScheme.INSTANCE.getDefaultScheme();
    public static final int $stable = 8;

    private InMemoryColorSchemeRepository() {
    }

    private final int[][] stateArray() {
        return new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    public final ColorStateList backgroundStateList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(stateArray(), new int[]{ContextCompat.getColor(context, R$color.color_ghost), colorScheme.getPrimaryColor()});
    }

    public final ColorScheme getColorScheme() {
        return colorScheme;
    }

    public final void setColorScheme(ColorScheme colorScheme2) {
        Intrinsics.checkNotNullParameter(colorScheme2, "<set-?>");
        colorScheme = colorScheme2;
    }

    public final ColorStateList typeColorStateList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(stateArray(), new int[]{ContextCompat.getColor(context, R$color.color_type_ghost), colorScheme.getPrimaryColor()});
    }
}
