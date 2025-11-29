package npi.spay;

import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.ImageViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.sl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1923sl {
    public static final void a(AppCompatImageView appCompatImageView, int i) {
        Intrinsics.checkNotNullParameter(appCompatImageView, "<this>");
        appCompatImageView.setImageDrawable(ResourcesCompat.getDrawable(appCompatImageView.getResources(), i, null));
    }

    public static final void b(AppCompatImageView appCompatImageView, int i) {
        Intrinsics.checkNotNullParameter(appCompatImageView, "<this>");
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(color)");
        ImageViewCompat.setImageTintList(appCompatImageView, colorStateListValueOf);
    }
}
