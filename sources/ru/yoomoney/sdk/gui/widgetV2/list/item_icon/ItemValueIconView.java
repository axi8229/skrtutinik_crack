package ru.yoomoney.sdk.gui.widgetV2.list.item_icon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.TypedArrayExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widgetV2.image.IconValueView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftValue;

/* compiled from: ItemValueIconView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0014J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0016R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_icon/ItemValueIconView;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_icon/ItemIconView;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasLeftValue;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroid/graphics/drawable/Drawable;", "badge", "getBadge", "()Landroid/graphics/drawable/Drawable;", "setBadge", "(Landroid/graphics/drawable/Drawable;)V", "", "leftValue", "getLeftValue", "()Ljava/lang/CharSequence;", "setLeftValue", "(Ljava/lang/CharSequence;)V", "leftValueView", "Lru/yoomoney/sdk/gui/widgetV2/image/IconValueView;", "notifyBadge", "getNotifyBadge", "setNotifyBadge", "createValueView", "obtainAttrs", "", "a", "Landroid/content/res/TypedArray;", "onViewInflated", "setEnabled", "enabled", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemValueIconView extends ItemIconView implements HasLeftValue {
    private Drawable badge;
    private IconValueView leftValueView;
    private Drawable notifyBadge;

    public /* synthetic */ ItemValueIconView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListItemIcon_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemValueIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public CharSequence getLeftValue() {
        IconValueView iconValueView = this.leftValueView;
        if (iconValueView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftValueView");
            iconValueView = null;
        }
        return iconValueView.getValue();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftValue
    public void setLeftValue(CharSequence charSequence) {
        ViewExtensions.setVisible(getIconContainer(), charSequence != null);
        IconValueView iconValueView = this.leftValueView;
        if (iconValueView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftValueView");
            iconValueView = null;
        }
        iconValueView.setValue(charSequence);
    }

    public Drawable getBadge() {
        return this.badge;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftValue
    public void setBadge(Drawable drawable) {
        this.badge = drawable;
        IconValueView iconValueView = this.leftValueView;
        if (iconValueView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftValueView");
            iconValueView = null;
        }
        iconValueView.setBadge(drawable);
    }

    public final Drawable getNotifyBadge() {
        return this.notifyBadge;
    }

    public final void setNotifyBadge(Drawable drawable) {
        this.notifyBadge = drawable;
        IconValueView iconValueView = this.leftValueView;
        if (iconValueView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftValueView");
            iconValueView = null;
        }
        iconValueView.setNotifyBadge(drawable);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView
    protected void onViewInflated() {
        super.onViewInflated();
        this.leftValueView = createValueView();
        FrameLayout iconContainer = getIconContainer();
        IconValueView iconValueView = this.leftValueView;
        if (iconValueView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftValueView");
            iconValueView = null;
        }
        iconContainer.addView(iconValueView);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView
    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        super.obtainAttrs(a);
        setLeftValue(a.getText(R$styleable.ym_ListItem_ym_leftValue));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBadge(TypedArrayExtensions.getStyleableDrawable(a, context, R$styleable.ym_ListItem_ym_badge));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        setNotifyBadge(TypedArrayExtensions.getStyleableDrawable(a, context2, R$styleable.ym_ListItem_ym_notifyBadge));
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView, android.view.View
    public void setEnabled(boolean enabled) {
        IconValueView iconValueView = this.leftValueView;
        if (iconValueView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftValueView");
            iconValueView = null;
        }
        iconValueView.setEnabled(enabled);
        super.setEnabled(enabled);
    }

    public IconValueView createValueView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new IconValueView(context, null, 0, 6, null);
    }
}
