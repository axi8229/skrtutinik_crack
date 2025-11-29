package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.gui.widgetV2.list.ItemSwitchView;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/ui/ItemSecondarySwitchView;", "Lru/yoomoney/sdk/gui/widgetV2/list/ItemSwitchView;", "Lru/yoomoney/sdk/auth/ui/UiLIbItemSecondarySwitchView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "stateArray", "", "", "[[I", "initThumbColor", "", "initTrackColor", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ItemSecondarySwitchView extends ItemSwitchView {
    private final int[][] stateArray;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemSecondarySwitchView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initThumbColor() {
        int color = ContextCompat.getColor(getContext(), R.color.color_ghost);
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setThumbTintList(new ColorStateList(this.stateArray, new int[]{color, colorScheme.getSecondaryAccentColor(context), ContextCompat.getColor(getContext(), R.color.color_type_inverse)}));
    }

    private final void initTrackColor() {
        int color = ContextCompat.getColor(getContext(), R.color.color_type_ghost);
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int secondaryGhostColor = colorScheme.getSecondaryGhostColor(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        setTrackTintList(new ColorStateList(this.stateArray, new int[]{color, secondaryGhostColor, colorScheme.getSecondaryGhostColor(context2)}));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemSecondarySwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ym_ListItemSecondarySwitch_Style);
        Intrinsics.checkNotNullParameter(context, "context");
        this.stateArray = new int[][]{new int[]{-16842910}, new int[]{android.R.attr.state_checked}, new int[0]};
        initThumbColor();
        initTrackColor();
    }

    public /* synthetic */ ItemSecondarySwitchView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
