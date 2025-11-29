package ru.yoomoney.sdk.gui.utils.extensions;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawableExtensions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"tint", "Landroid/graphics/drawable/Drawable;", "colorStateList", "Landroid/content/res/ColorStateList;", RemoteMessageConst.Notification.COLOR, "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DrawableExtensions {
    public static final Drawable tint(Drawable drawable, int i) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(drawableWrap, i);
        Intrinsics.checkNotNull(drawableWrap);
        return drawableWrap;
    }

    public static final Drawable tint(Drawable drawable, ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTintList(drawableWrap, colorStateList);
        Intrinsics.checkNotNull(drawableWrap);
        return drawableWrap;
    }
}
