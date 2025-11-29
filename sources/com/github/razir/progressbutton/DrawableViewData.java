package com.github.razir.progressbutton;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawableButtonExtensions.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/github/razir/progressbutton/DrawableViewData;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/drawable/Drawable$Callback;", "callback", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "progressbutton_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class DrawableViewData {
    private final Drawable.Callback callback;
    private Drawable drawable;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawableViewData)) {
            return false;
        }
        DrawableViewData drawableViewData = (DrawableViewData) other;
        return Intrinsics.areEqual(this.drawable, drawableViewData.drawable) && Intrinsics.areEqual(this.callback, drawableViewData.callback);
    }

    public int hashCode() {
        Drawable drawable = this.drawable;
        int iHashCode = (drawable != null ? drawable.hashCode() : 0) * 31;
        Drawable.Callback callback = this.callback;
        return iHashCode + (callback != null ? callback.hashCode() : 0);
    }

    public String toString() {
        return "DrawableViewData(drawable=" + this.drawable + ", callback=" + this.callback + ")";
    }

    public DrawableViewData(Drawable drawable, Drawable.Callback callback) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.drawable = drawable;
        this.callback = callback;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }
}
