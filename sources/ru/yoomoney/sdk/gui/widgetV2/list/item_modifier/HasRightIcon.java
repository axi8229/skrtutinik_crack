package ru.yoomoney.sdk.gui.widgetV2.list.item_modifier;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* compiled from: HasRightIcon.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasRightIcon;", "", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", RemoteMessageConst.Notification.ICON, "Landroid/content/res/ColorStateList;", "getRightIconTint", "()Landroid/content/res/ColorStateList;", "setRightIconTint", "(Landroid/content/res/ColorStateList;)V", "rightIconTint", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HasRightIcon {
    void setIcon(Drawable drawable);

    void setRightIconTint(ColorStateList colorStateList);
}
