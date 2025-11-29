package ru.yoomoney.sdk.gui.widget.state_screen;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView;

/* compiled from: AbstractStateView.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0012\u0010\u0019\u001a\u00020\u001aX¤\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/gui/widget/state_screen/AbstractStateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroid/graphics/drawable/Drawable;", RemoteMessageConst.Notification.ICON, "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/content/res/ColorStateList;", "iconBackgroundTint", "getIconBackgroundTint", "()Landroid/content/res/ColorStateList;", "setIconBackgroundTint", "(Landroid/content/res/ColorStateList;)V", "iconTint", "getIconTint", "setIconTint", "iconView", "Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "getIconView", "()Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "inflate", "", "onViewInflated", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractStateView extends ConstraintLayout {
    private Drawable icon;
    private ColorStateList iconBackgroundTint;
    private ColorStateList iconTint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractStateView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected abstract AbstractIconImageView getIconView();

    protected void inflate() {
    }

    protected void onViewInflated() {
    }

    public /* synthetic */ AbstractStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        inflate();
        onViewInflated();
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable drawable) {
        Unit unit;
        this.icon = drawable;
        AbstractIconImageView iconView = getIconView();
        if (drawable != null) {
            ViewExtensions.show(iconView);
            iconView.setImage(drawable);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ViewExtensions.hide(iconView);
        }
    }

    public final ColorStateList getIconTint() {
        return this.iconTint;
    }

    public final void setIconTint(ColorStateList colorStateList) {
        this.iconTint = colorStateList;
        getIconView().setImageTintColor(colorStateList);
    }

    public final ColorStateList getIconBackgroundTint() {
        return this.iconBackgroundTint;
    }

    public final void setIconBackgroundTint(ColorStateList colorStateList) {
        this.iconBackgroundTint = colorStateList;
        getIconView().setBackgroundTintColor(colorStateList);
    }
}
