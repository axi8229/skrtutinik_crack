package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/ui/TextInputView;", "Lru/yoomoney/sdk/gui/widget/TextInputView;", "Lru/yoomoney/sdk/auth/ui/UiLIbTextInputView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TextInputView extends ru.yoomoney.sdk.gui.widget.TextInputView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(TextInputView this$0, Context context, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (z) {
            this$0.tintColorStateList(ColorScheme.INSTANCE.getBackgroundPrimaryButtonStateList(context));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.yoomoney.sdk.auth.ui.TextInputView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                TextInputView._init_$lambda$0(this.f$0, context, view, z);
            }
        });
    }

    public /* synthetic */ TextInputView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
