package ru.yoomoney.sdk.gui.widgetV2.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.utils.color.ColorStateSetKt;

/* compiled from: IconVectorView.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/image/IconVectorView;", "Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "Landroid/content/res/ColorStateList;", "getBackgroundColor", "()Landroid/content/res/ColorStateList;", "imageColor", "getImageColor", "setEnabled", "", "enabled", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class IconVectorView extends AbstractIconImageView {
    private final ColorStateList backgroundColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IconVectorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IconVectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ IconVectorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListVectorView_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconVectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ImageView imageView = getImageView();
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(enabled);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected ColorStateList getImageColor() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ColorStateSetKt.getLinkTextColorState(context);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected ColorStateList getBackgroundColor() {
        return this.backgroundColor;
    }
}
