package ru.yoomoney.sdk.gui.widgetV2.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.utils.color.ColorStateSetKt;

/* compiled from: IconValueFadeView.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/image/IconValueFadeView;", "Lru/yoomoney/sdk/gui/widgetV2/image/IconValueView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "Landroid/content/res/ColorStateList;", "getBackgroundColor", "()Landroid/content/res/ColorStateList;", "imageColor", "getImageColor", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IconValueFadeView extends IconValueView {
    public /* synthetic */ IconValueFadeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListVectorFadeView_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconValueFadeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.IconValueView, ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected ColorStateList getImageColor() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ColorStateSetKt.getFadeTextColorState(context);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.IconValueView, ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected ColorStateList getBackgroundColor() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ColorStateSetKt.getFadeBackgroundColorState(context);
    }
}
