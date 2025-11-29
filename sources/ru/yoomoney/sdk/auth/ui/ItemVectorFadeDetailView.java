package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemImageDetailView;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/ui/ItemVectorFadeDetailView;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_detail/ItemImageDetailView;", "Lru/yoomoney/sdk/auth/ui/UiLIbItemImageDetailView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "createImageView", "Lru/yoomoney/sdk/auth/ui/IconVectorFadeView;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ItemVectorFadeDetailView extends ItemImageDetailView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemVectorFadeDetailView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemImageDetailView
    public IconVectorFadeView createImageView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new IconVectorFadeView(context, null, 0, 6, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemVectorFadeDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemVectorFadeDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ItemVectorFadeDetailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
