package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.IconButtonBinding;
import com.sputnik.common.extensions.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IconButton.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017J\u0006\u0010\u0018\u001a\u00020\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/ui/view/IconButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/sputnik/common/databinding/IconButtonBinding;", "getBinding", "()Lcom/sputnik/common/databinding/IconButtonBinding;", "setBinding", "(Lcom/sputnik/common/databinding/IconButtonBinding;)V", "hideProgress", "", "setData", "text", "", RemoteMessageConst.Notification.ICON, RemoteMessageConst.Notification.COLOR, "onClickListener", "Lkotlin/Function0;", "showProgress", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IconButton extends ConstraintLayout {
    private IconButtonBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IconButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ IconButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        IconButtonBinding iconButtonBindingInflate = IconButtonBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(iconButtonBindingInflate, "inflate(...)");
        this.binding = iconButtonBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.TextViewWithImage, 0, 0);
        try {
            this.binding.tvNumber.setText(typedArrayObtainStyledAttributes.getString(R$styleable.IconButton_android_text));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final IconButtonBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(IconButtonBinding iconButtonBinding) {
        Intrinsics.checkNotNullParameter(iconButtonBinding, "<set-?>");
        this.binding = iconButtonBinding;
    }

    public final void setData(String text, int icon, int color, final Function0<Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        IconButtonBinding iconButtonBinding = this.binding;
        iconButtonBinding.layoutViews.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.ui.view.IconButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IconButton.setData$lambda$2$lambda$1(onClickListener, view);
            }
        });
        iconButtonBinding.tvNumber.setText(text);
        iconButtonBinding.tvNumber.setTextColor(color);
        iconButtonBinding.ivIcon.setImageResource(icon);
        iconButtonBinding.ivIcon.setImageTintList(ColorStateList.valueOf(color));
        iconButtonBinding.pb.setIndeterminateTintList(ColorStateList.valueOf(color));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$2$lambda$1(Function0 onClickListener, View view) {
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        onClickListener.invoke();
    }

    public final void showProgress() {
        IconButtonBinding iconButtonBinding = this.binding;
        LinearLayout layoutViews = iconButtonBinding.layoutViews;
        Intrinsics.checkNotNullExpressionValue(layoutViews, "layoutViews");
        ViewKt.invisible(layoutViews);
        ConstraintLayout layoutPb = iconButtonBinding.layoutPb;
        Intrinsics.checkNotNullExpressionValue(layoutPb, "layoutPb");
        ViewKt.visible(layoutPb);
        ProgressBar pb = iconButtonBinding.pb;
        Intrinsics.checkNotNullExpressionValue(pb, "pb");
        ViewKt.visible(pb);
    }

    public final void hideProgress() {
        IconButtonBinding iconButtonBinding = this.binding;
        LinearLayout layoutViews = iconButtonBinding.layoutViews;
        Intrinsics.checkNotNullExpressionValue(layoutViews, "layoutViews");
        ViewKt.visible(layoutViews);
        ConstraintLayout layoutPb = iconButtonBinding.layoutPb;
        Intrinsics.checkNotNullExpressionValue(layoutPb, "layoutPb");
        ViewKt.invisible(layoutPb);
    }
}
