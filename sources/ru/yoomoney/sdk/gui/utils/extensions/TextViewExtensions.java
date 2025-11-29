package ru.yoomoney.sdk.gui.utils.extensions;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.TextView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewExtensions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"setTextAndVisibility", "", "Landroid/widget/TextView;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "tintDrawables", RemoteMessageConst.Notification.COLOR, "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextViewExtensions {
    public static final void tintDrawables(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(compoundDrawables, "getCompoundDrawables(...)");
        for (Drawable drawable : compoundDrawables) {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    Drawable drawable2 = layerDrawable.getDrawable(i2);
                    Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
                    DrawableExtensions.tint(drawable2, i);
                }
            } else if (drawable != null) {
                Intrinsics.checkNotNull(drawable);
                DrawableExtensions.tint(drawable, i);
            }
        }
    }

    public static final void setTextAndVisibility(TextView textView, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setText(charSequence);
        ViewExtensions.setVisible(textView, !(charSequence == null || charSequence.length() == 0));
    }
}
