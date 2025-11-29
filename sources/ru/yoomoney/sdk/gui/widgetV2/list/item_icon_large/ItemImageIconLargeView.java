package ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large;

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
import ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView;
import ru.yoomoney.sdk.gui.widgetV2.image.IconImageView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftImage;

/* compiled from: ItemImageIconLargeView.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_icon_large/ItemImageIconLargeView;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_icon_large/ItemIconLargeView;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasLeftImage;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroid/graphics/drawable/Drawable;", "badge", "getBadge", "()Landroid/graphics/drawable/Drawable;", "setBadge", "(Landroid/graphics/drawable/Drawable;)V", "leftImage", "getLeftImage", "setLeftImage", "leftImageView", "Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "notifyBadge", "getNotifyBadge", "setNotifyBadge", "createImageView", "obtainAttrs", "", "a", "Landroid/content/res/TypedArray;", "onViewInflated", "setEnabled", "enabled", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemImageIconLargeView extends ItemIconLargeView implements HasLeftImage {
    private Drawable badge;
    private AbstractIconImageView leftImageView;
    private Drawable notifyBadge;

    public /* synthetic */ ItemImageIconLargeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListItemIconLarge_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemImageIconLargeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public Drawable getLeftImage() {
        AbstractIconImageView abstractIconImageView = this.leftImageView;
        if (abstractIconImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
            abstractIconImageView = null;
        }
        return abstractIconImageView.getImage();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftImage
    public void setLeftImage(Drawable drawable) {
        ViewExtensions.setVisible(getIconContainer(), drawable != null);
        AbstractIconImageView abstractIconImageView = this.leftImageView;
        if (abstractIconImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
            abstractIconImageView = null;
        }
        abstractIconImageView.setImage(drawable);
    }

    public Drawable getBadge() {
        return this.badge;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftImage
    public void setBadge(Drawable drawable) {
        this.badge = drawable;
        AbstractIconImageView abstractIconImageView = this.leftImageView;
        if (abstractIconImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
            abstractIconImageView = null;
        }
        abstractIconImageView.setBadge(drawable);
    }

    public final Drawable getNotifyBadge() {
        return this.notifyBadge;
    }

    public final void setNotifyBadge(Drawable drawable) {
        this.notifyBadge = drawable;
        AbstractIconImageView abstractIconImageView = this.leftImageView;
        if (abstractIconImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
            abstractIconImageView = null;
        }
        abstractIconImageView.setNotifyBadge(drawable);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView
    protected void onViewInflated() {
        super.onViewInflated();
        this.leftImageView = createImageView();
        FrameLayout iconContainer = getIconContainer();
        AbstractIconImageView abstractIconImageView = this.leftImageView;
        if (abstractIconImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
            abstractIconImageView = null;
        }
        iconContainer.addView(abstractIconImageView);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView
    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setLeftImage(TypedArrayExtensions.getStyleableDrawable(a, context, R$styleable.ym_ListItem_ym_leftIcon));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        setBadge(TypedArrayExtensions.getStyleableDrawable(a, context2, R$styleable.ym_ListItem_ym_badge));
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        setNotifyBadge(TypedArrayExtensions.getStyleableDrawable(a, context3, R$styleable.ym_ListItem_ym_notifyBadge));
        super.obtainAttrs(a);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        AbstractIconImageView abstractIconImageView = this.leftImageView;
        if (abstractIconImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
            abstractIconImageView = null;
        }
        abstractIconImageView.setEnabled(enabled);
    }

    public AbstractIconImageView createImageView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new IconImageView(context, null, 0, 6, null);
    }
}
