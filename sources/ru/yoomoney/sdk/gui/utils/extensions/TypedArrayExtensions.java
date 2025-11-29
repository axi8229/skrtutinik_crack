package ru.yoomoney.sdk.gui.utils.extensions;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypedArrayExtensions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"getStyleableDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/content/res/TypedArray;", "context", "Landroid/content/Context;", "index", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TypedArrayExtensions {
    public static final Drawable getStyleableDrawable(TypedArray typedArray, Context context, int i) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Integer numValueOf = Integer.valueOf(typedArray.getResourceId(i, -1));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return AppCompatResources.getDrawable(context, numValueOf.intValue());
        }
        return null;
    }
}
