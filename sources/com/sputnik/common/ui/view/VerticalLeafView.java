package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.LayoutViewVerticalLeafBinding;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerticalLeafView.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/sputnik/common/ui/view/VerticalLeafView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/sputnik/common/databinding/LayoutViewVerticalLeafBinding;", "getBinding", "()Lcom/sputnik/common/databinding/LayoutViewVerticalLeafBinding;", "setBinding", "(Lcom/sputnik/common/databinding/LayoutViewVerticalLeafBinding;)V", "setSubtitle", "", "subtitle", "", "setTitle", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VerticalLeafView extends ConstraintLayout {
    private LayoutViewVerticalLeafBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerticalLeafView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VerticalLeafView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalLeafView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutViewVerticalLeafBinding layoutViewVerticalLeafBindingInflate = LayoutViewVerticalLeafBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(layoutViewVerticalLeafBindingInflate, "inflate(...)");
        this.binding = layoutViewVerticalLeafBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SettingsMenuView, 0, 0);
        try {
            this.binding.tvTitle.setText(typedArrayObtainStyledAttributes.getString(R$styleable.SettingsMenuView_title));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final LayoutViewVerticalLeafBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(LayoutViewVerticalLeafBinding layoutViewVerticalLeafBinding) {
        Intrinsics.checkNotNullParameter(layoutViewVerticalLeafBinding, "<set-?>");
        this.binding = layoutViewVerticalLeafBinding;
    }

    public final void setTitle(String title) {
        this.binding.tvTitle.setText(title);
    }

    public final void setSubtitle(String subtitle) {
        this.binding.tvSubtitle.setText(subtitle);
    }
}
