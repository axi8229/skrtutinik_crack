package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.ViewSettingsMenuItemBinding;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsMenuView.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/sputnik/common/ui/view/SettingsMenuView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/sputnik/common/databinding/ViewSettingsMenuItemBinding;", "getBinding", "()Lcom/sputnik/common/databinding/ViewSettingsMenuItemBinding;", "setBinding", "(Lcom/sputnik/common/databinding/ViewSettingsMenuItemBinding;)V", "setCount", "", "count", "", "setCountColor", RemoteMessageConst.Notification.COLOR, "setOnboardingEnabled", "enabled", "", "setTitle", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsMenuView extends ConstraintLayout {
    private ViewSettingsMenuItemBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SettingsMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SettingsMenuView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewSettingsMenuItemBinding viewSettingsMenuItemBindingInflate = ViewSettingsMenuItemBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(viewSettingsMenuItemBindingInflate, "inflate(...)");
        this.binding = viewSettingsMenuItemBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SettingsMenuView, 0, 0);
        try {
            this.binding.tvNotice.setText(typedArrayObtainStyledAttributes.getString(R$styleable.SettingsMenuView_title));
            this.binding.ivIcon.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R$styleable.SettingsMenuView_image));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final ViewSettingsMenuItemBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(ViewSettingsMenuItemBinding viewSettingsMenuItemBinding) {
        Intrinsics.checkNotNullParameter(viewSettingsMenuItemBinding, "<set-?>");
        this.binding = viewSettingsMenuItemBinding;
    }

    public final void setTitle(String title) {
        this.binding.tvNumber.setText(title);
    }

    public final void setCount(String count) {
        Intrinsics.checkNotNullParameter(count, "count");
        this.binding.tvNotice.setText(count);
        TextView tvNotice = this.binding.tvNotice;
        Intrinsics.checkNotNullExpressionValue(tvNotice, "tvNotice");
        ViewKt.visible(tvNotice);
    }

    public final void setCountColor(int color) {
        this.binding.tvNotice.setTextColor(color);
    }

    public final void setOnboardingEnabled(boolean enabled) {
        View viewOnboarding = this.binding.viewOnboarding;
        Intrinsics.checkNotNullExpressionValue(viewOnboarding, "viewOnboarding");
        ViewBindingUtilsKt.visibilityBasedOn(viewOnboarding, Boolean.valueOf(enabled));
    }
}
