package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.ViewCheckboxPreferenceBinding;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckBoxPreferenceView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJU\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/sputnik/common/ui/view/CheckBoxPreferenceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "", "enabled", "Lkotlin/Function1;", "", "onSwitchChanged", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "visible", "initialize", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Z)V", "checked", "setChecked", "(Z)V", "Lcom/sputnik/common/databinding/ViewCheckboxPreferenceBinding;", "binding", "Lcom/sputnik/common/databinding/ViewCheckboxPreferenceBinding;", "getBinding", "()Lcom/sputnik/common/databinding/ViewCheckboxPreferenceBinding;", "setBinding", "(Lcom/sputnik/common/databinding/ViewCheckboxPreferenceBinding;)V", "initialized", "Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CheckBoxPreferenceView extends ConstraintLayout {
    private ViewCheckboxPreferenceBinding binding;
    private boolean initialized;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckBoxPreferenceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CheckBoxPreferenceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckBoxPreferenceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewCheckboxPreferenceBinding viewCheckboxPreferenceBindingInflate = ViewCheckboxPreferenceBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(viewCheckboxPreferenceBindingInflate, "inflate(...)");
        this.binding = viewCheckboxPreferenceBindingInflate;
        context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CheckBoxPreferenceView, 0, 0);
    }

    public final ViewCheckboxPreferenceBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(ViewCheckboxPreferenceBinding viewCheckboxPreferenceBinding) {
        Intrinsics.checkNotNullParameter(viewCheckboxPreferenceBinding, "<set-?>");
        this.binding = viewCheckboxPreferenceBinding;
    }

    public static /* synthetic */ void initialize$default(CheckBoxPreferenceView checkBoxPreferenceView, String str, String str2, boolean z, Function1 function1, Function0 function0, boolean z2, int i, Object obj) throws Resources.NotFoundException {
        if ((i & 16) != 0) {
            function0 = null;
        }
        Function0 function02 = function0;
        if ((i & 32) != 0) {
            z2 = true;
        }
        checkBoxPreferenceView.initialize(str, str2, z, function1, function02, z2);
    }

    public final void initialize(String title, String subtitle, boolean enabled, final Function1<? super Boolean, Unit> onSwitchChanged, final Function0<Unit> listener, boolean visible) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(onSwitchChanged, "onSwitchChanged");
        if (visible) {
            ViewKt.visible(this);
            this.initialized = true;
            ViewCheckboxPreferenceBinding viewCheckboxPreferenceBinding = this.binding;
            SwitchCompat optionSwitch = viewCheckboxPreferenceBinding.optionSwitch;
            Intrinsics.checkNotNullExpressionValue(optionSwitch, "optionSwitch");
            if (enabled) {
                ViewKt.disable(optionSwitch);
            } else {
                ViewKt.enable(optionSwitch);
            }
            viewCheckboxPreferenceBinding.optionSwitch.setChecked(enabled);
            viewCheckboxPreferenceBinding.tvTitle.setText(title);
            viewCheckboxPreferenceBinding.tvSubtitle.setText(subtitle);
            viewCheckboxPreferenceBinding.optionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sputnik.common.ui.view.CheckBoxPreferenceView$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    CheckBoxPreferenceView.initialize$lambda$3$lambda$1(onSwitchChanged, compoundButton, z);
                }
            });
            ImageView btnAbout = viewCheckboxPreferenceBinding.btnAbout;
            Intrinsics.checkNotNullExpressionValue(btnAbout, "btnAbout");
            ViewBindingUtilsKt.visibilityBasedOn(btnAbout, Boolean.valueOf(listener != null));
            viewCheckboxPreferenceBinding.btnAbout.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.ui.view.CheckBoxPreferenceView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckBoxPreferenceView.initialize$lambda$3$lambda$2(listener, view);
                }
            });
            return;
        }
        ViewKt.gone(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$3$lambda$1(Function1 onSwitchChanged, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(onSwitchChanged, "$onSwitchChanged");
        onSwitchChanged.invoke(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$3$lambda$2(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setChecked(boolean checked) throws Resources.NotFoundException {
        this.binding.optionSwitch.setChecked(checked);
        if (checked) {
            SwitchCompat optionSwitch = this.binding.optionSwitch;
            Intrinsics.checkNotNullExpressionValue(optionSwitch, "optionSwitch");
            ViewKt.disable(optionSwitch);
        } else {
            SwitchCompat optionSwitch2 = this.binding.optionSwitch;
            Intrinsics.checkNotNullExpressionValue(optionSwitch2, "optionSwitch");
            ViewKt.enable(optionSwitch2);
        }
    }
}
