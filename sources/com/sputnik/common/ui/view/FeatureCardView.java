package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.LayoutFeatureCardBinding;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeatureCardView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00102\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/sputnik/common/ui/view/FeatureCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/sputnik/common/databinding/LayoutFeatureCardBinding;", "getBinding", "()Lcom/sputnik/common/databinding/LayoutFeatureCardBinding;", "setBinding", "(Lcom/sputnik/common/databinding/LayoutFeatureCardBinding;)V", "setBetaEnabled", "", "enabled", "", "setButtonInfoListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setColor", RemoteMessageConst.Notification.COLOR, "setSpecialIcon", "resId", "setSubtitle", "text", "", "setTitle", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeatureCardView extends ConstraintLayout {
    private LayoutFeatureCardBinding binding;

    public /* synthetic */ FeatureCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutFeatureCardBinding layoutFeatureCardBindingInflate = LayoutFeatureCardBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(layoutFeatureCardBindingInflate, "inflate(...)");
        this.binding = layoutFeatureCardBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FeatureCardView, 0, 0);
        try {
            LayoutFeatureCardBinding layoutFeatureCardBinding = this.binding;
            layoutFeatureCardBinding.tvTitle.setText(typedArrayObtainStyledAttributes.getString(R$styleable.FeatureCardView_title));
            layoutFeatureCardBinding.tvSubtitle.setText(typedArrayObtainStyledAttributes.getString(R$styleable.FeatureCardView_subtitle));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final LayoutFeatureCardBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(LayoutFeatureCardBinding layoutFeatureCardBinding) {
        Intrinsics.checkNotNullParameter(layoutFeatureCardBinding, "<set-?>");
        this.binding = layoutFeatureCardBinding;
    }

    public final void setTitle(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.tvTitle.setText(text);
    }

    public final void setSubtitle(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.tvSubtitle.setText(text);
    }

    public final void setColor(int color) {
        this.binding.tvTitle.setTextColor(color);
    }

    public final void setButtonInfoListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.binding.btnMoreInfo.setOnClickListener(listener);
    }

    public final void setBetaEnabled(boolean enabled) {
        ConstraintLayout layoutBeta = this.binding.layoutBeta;
        Intrinsics.checkNotNullExpressionValue(layoutBeta, "layoutBeta");
        ViewBindingUtilsKt.visibilityBasedOn(layoutBeta, Boolean.valueOf(enabled));
    }

    public final void setSpecialIcon(int resId) {
        this.binding.ivSpecialIcon.setImageResource(resId);
    }
}
