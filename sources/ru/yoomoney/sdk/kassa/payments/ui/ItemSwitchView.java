package ru.yoomoney.sdk.kassa.payments.ui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$attr;
import ru.yoomoney.sdk.kassa.payments.extensions.e;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/ItemSwitchView;", "Lru/yoomoney/sdk/gui/widgetV2/list/ItemSwitchView;", "Lru/yoomoney/sdk/kassa/payments/ui/UiLIbItemSwitchView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ItemSwitchView extends ru.yoomoney.sdk.gui.widgetV2.list.ItemSwitchView {
    public static final int $stable = 0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemSwitchView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int primaryColor = InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor();
        setThumbTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{primaryColor, -3355444}));
        setTrackTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{ColorUtils.setAlphaComponent(e.a(primaryColor), 97), -7829368}));
    }

    public /* synthetic */ ItemSwitchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListItemSwitchCheckout_Style : i);
    }
}
