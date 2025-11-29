package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.sputnik.common.R$color;
import com.sputnik.common.R$drawable;
import com.sputnik.common.R$font;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.LayoutViewLeafBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeafView.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/sputnik/common/ui/view/LeafView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/sputnik/common/databinding/LayoutViewLeafBinding;", "getBinding", "()Lcom/sputnik/common/databinding/LayoutViewLeafBinding;", "setBinding", "(Lcom/sputnik/common/databinding/LayoutViewLeafBinding;)V", "setImage", "", "resId", "setNumberation", "text", "", "setText", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LeafView extends ConstraintLayout {
    private LayoutViewLeafBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LeafView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LeafView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeafView(Context context, AttributeSet attributeSet, int i) {
        int color;
        Typeface font;
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutViewLeafBinding layoutViewLeafBindingInflate = LayoutViewLeafBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(layoutViewLeafBindingInflate, "inflate(...)");
        this.binding = layoutViewLeafBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.LeafView, 0, 0);
        try {
            LayoutViewLeafBinding layoutViewLeafBinding = this.binding;
            layoutViewLeafBinding.tvNumber.setText(typedArrayObtainStyledAttributes.getString(R$styleable.LeafView_numeration));
            boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LeafView_bold, false);
            TextView textView = layoutViewLeafBinding.tvTitle;
            textView.setText(typedArrayObtainStyledAttributes.getString(R$styleable.LeafView_text));
            if (z) {
                color = ContextCompat.getColor(context, R$color.large_text);
            } else {
                color = ContextCompat.getColor(context, R$color.sputnik_black);
            }
            textView.setTextColor(color);
            if (z) {
                font = ResourcesCompat.getFont(textView.getContext(), R$font.opensans_semibold);
            } else {
                font = ResourcesCompat.getFont(textView.getContext(), R$font.opensans_semibold);
            }
            textView.setTypeface(font, 1);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.LeafView_image);
            layoutViewLeafBinding.ivLeaf.setImageDrawable(drawable == null ? ContextCompat.getDrawable(context, R$drawable.ic_leaf_blue) : drawable);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final LayoutViewLeafBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(LayoutViewLeafBinding layoutViewLeafBinding) {
        Intrinsics.checkNotNullParameter(layoutViewLeafBinding, "<set-?>");
        this.binding = layoutViewLeafBinding;
    }

    public final void setText(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.tvTitle.setText(text);
    }

    public final void setImage(int resId) {
        this.binding.ivLeaf.setImageResource(resId);
    }

    public final void setNumberation(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.tvNumber.setText(text);
    }
}
