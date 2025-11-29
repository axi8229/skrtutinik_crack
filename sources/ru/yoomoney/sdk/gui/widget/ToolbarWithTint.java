package ru.yoomoney.sdk.gui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.TextViewCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$style;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.TextViewExtensions;

/* compiled from: ToolbarWithTint.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000fH\u0002R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/gui/widget/ToolbarWithTint;", "Landroidx/appcompat/widget/Toolbar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onIconsColorsRefreshed", "Lkotlin/Function0;", "", "getOnIconsColorsRefreshed", "()Lkotlin/jvm/functions/Function0;", "setOnIconsColorsRefreshed", "(Lkotlin/jvm/functions/Function0;)V", "tintColor", "", "getTintColor", "()I", "setTintColor", "(I)V", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "setActionsColor", RemoteMessageConst.Notification.COLOR, "setNavigationIcon", RemoteMessageConst.Notification.ICON, "Landroid/graphics/drawable/Drawable;", "tintToolbarChildView", "view", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolbarWithTint extends Toolbar {
    private Function0<Unit> onIconsColorsRefreshed;
    private int tintColor;

    public /* synthetic */ ToolbarWithTint(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarWithTint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tintColor = -1;
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: ru.yoomoney.sdk.gui.widget.ToolbarWithTint.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                ActionMenuView actionMenuView = child instanceof ActionMenuView ? (ActionMenuView) child : null;
                if (actionMenuView != null) {
                    actionMenuView.setOnHierarchyChangeListener(this);
                }
                ToolbarWithTint toolbarWithTint = ToolbarWithTint.this;
                toolbarWithTint.setActionsColor(toolbarWithTint.getTintColor());
            }
        });
    }

    public final int getTintColor() {
        return this.tintColor;
    }

    public final void setTintColor(int i) {
        this.tintColor = i;
    }

    public final Function0<Unit> getOnIconsColorsRefreshed() {
        return this.onIconsColorsRefreshed;
    }

    public final void setOnIconsColorsRefreshed(Function0<Unit> function0) {
        this.onIconsColorsRefreshed = function0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable icon) {
        super.setNavigationIcon(icon != null ? DrawableExtensions.tint(icon, this.tintColor) : null);
    }

    public final void setActionsColor(int color) {
        this.tintColor = color;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            tintToolbarChildView(childAt, color);
        }
        Drawable overflowIcon = getOverflowIcon();
        setOverflowIcon(overflowIcon != null ? DrawableExtensions.tint(overflowIcon, color) : null);
        Function0<Unit> function0 = this.onIconsColorsRefreshed;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void tintToolbarChildView(View view, int color) {
        if (view instanceof ActionMenuView) {
            ActionMenuView actionMenuView = (ActionMenuView) view;
            int childCount = actionMenuView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = actionMenuView.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                tintToolbarChildView(childAt, color);
            }
            return;
        }
        if (view instanceof ActionMenuItemView) {
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
            TextViewCompat.setTextAppearance(actionMenuItemView, R$style.Text_Headline1_Link);
            actionMenuItemView.setTextColor(color);
            TextViewExtensions.tintDrawables(actionMenuItemView, color);
            return;
        }
        if (view instanceof ImageButton) {
            ImageButton imageButton = (ImageButton) view;
            Drawable drawable = imageButton.getDrawable();
            imageButton.setImageDrawable(drawable != null ? DrawableExtensions.tint(drawable, color) : null);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        tintToolbarChildView(child, this.tintColor);
        super.addView(child, index, params);
    }
}
