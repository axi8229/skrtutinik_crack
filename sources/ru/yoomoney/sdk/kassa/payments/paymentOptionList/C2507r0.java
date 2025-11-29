package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.r0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2507r0 extends FrameLayout {
    public final ru.yoomoney.sdk.kassa.payments.databinding.j a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final ImageView f;
    public final ImageView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2507r0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ru.yoomoney.sdk.kassa.payments.databinding.j jVarA = ru.yoomoney.sdk.kassa.payments.databinding.j.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(jVarA, "inflate(...)");
        this.a = jVarA;
        ImageView image = jVarA.c.c;
        Intrinsics.checkNotNullExpressionValue(image, "image");
        this.b = image;
        TextView primaryText = jVarA.c.e;
        Intrinsics.checkNotNullExpressionValue(primaryText, "primaryText");
        this.c = primaryText;
        TextView secondaryText = jVarA.c.f;
        Intrinsics.checkNotNullExpressionValue(secondaryText, "secondaryText");
        this.d = secondaryText;
        View root = jVarA.c.b.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.e = root;
        ImageView delete = jVarA.b;
        Intrinsics.checkNotNullExpressionValue(delete, "delete");
        this.f = delete;
        ImageView options = jVarA.c.d;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        this.g = options;
    }

    public final View getContentContainer() {
        ConstraintLayout constraintLayout = this.a.c.a;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    public final ImageView getDelete() {
        return this.f;
    }

    public final View getDivider() {
        return this.e;
    }

    public final ImageView getImage() {
        return this.b;
    }

    public final ImageView getOptions() {
        return this.g;
    }

    public final TextView getPrimaryText() {
        return this.c;
    }

    public final TextView getSecondaryText() {
        return this.d;
    }

    public final View getSwipeMenuContainer() {
        ImageView delete = this.a.b;
        Intrinsics.checkNotNullExpressionValue(delete, "delete");
        return delete;
    }
}
