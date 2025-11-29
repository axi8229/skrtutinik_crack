package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.LayoutRadioViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RadioOptionView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/sputnik/common/ui/view/RadioOptionView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "text", "", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "", "checked", "setSwitch", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSwitchListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/sputnik/common/databinding/LayoutRadioViewBinding;", "binding", "Lcom/sputnik/common/databinding/LayoutRadioViewBinding;", "getBinding", "()Lcom/sputnik/common/databinding/LayoutRadioViewBinding;", "setBinding", "(Lcom/sputnik/common/databinding/LayoutRadioViewBinding;)V", "Lkotlin/jvm/functions/Function1;", "itemId", "I", "getItemId", "()I", "setItemId", "(I)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RadioOptionView extends ConstraintLayout {
    private LayoutRadioViewBinding binding;
    private int itemId;
    private Function1<? super Boolean, Unit> listener;

    public /* synthetic */ RadioOptionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioOptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = new Function1<Boolean, Unit>() { // from class: com.sputnik.common.ui.view.RadioOptionView$listener$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.itemId = -1;
        LayoutRadioViewBinding layoutRadioViewBindingInflate = LayoutRadioViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(layoutRadioViewBindingInflate, "inflate(...)");
        this.binding = layoutRadioViewBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FeatureCardView, 0, 0);
        try {
            LayoutRadioViewBinding layoutRadioViewBinding = this.binding;
            layoutRadioViewBinding.domofonCallsView.setText(typedArrayObtainStyledAttributes.getString(R$styleable.FeatureCardView_title));
            layoutRadioViewBinding.domofonCallsHint.setText(typedArrayObtainStyledAttributes.getString(R$styleable.FeatureCardView_subtitle));
            layoutRadioViewBinding.domofonCallsValueView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sputnik.common.ui.view.RadioOptionView$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    RadioOptionView.lambda$2$lambda$1$lambda$0(this.f$0, compoundButton, z);
                }
            });
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final LayoutRadioViewBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(LayoutRadioViewBinding layoutRadioViewBinding) {
        Intrinsics.checkNotNullParameter(layoutRadioViewBinding, "<set-?>");
        this.binding = layoutRadioViewBinding;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final void setItemId(int i) {
        this.itemId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$2$lambda$1$lambda$0(RadioOptionView this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listener.invoke(Boolean.valueOf(z));
    }

    public final void setTitle(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.domofonCallsView.setText(text);
        invalidate();
    }

    public final void setSubtitle(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.domofonCallsHint.setText(text);
        invalidate();
    }

    public final void setSwitch(boolean checked) throws Resources.NotFoundException {
        this.binding.domofonCallsValueView.setChecked(checked);
    }

    public final void setSwitchListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
