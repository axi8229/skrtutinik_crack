package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.text.Editable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.pjsip.pjsua2.pjsip_transport_type_e;
import ru.yoomoney.sdk.auth.R;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/ui/PasswordInputView;", "Lru/yoomoney/sdk/gui/widget/TextInputView;", "Lru/yoomoney/sdk/auth/ui/UiLIbTextInputView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/Function1;", "", "", "displayPasswordListener", "Lkotlin/jvm/functions/Function1;", "getDisplayPasswordListener", "()Lkotlin/jvm/functions/Function1;", "setDisplayPasswordListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/widget/ImageView;", "displayPasswordView", "Landroid/widget/ImageView;", "isPasswordVisible", "()Z", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordInputView extends ru.yoomoney.sdk.gui.widget.TextInputView {
    private Function1<? super Boolean, Unit> displayPasswordListener;
    private final ImageView displayPasswordView;

    public static final class a extends Lambda implements Function1<AppCompatEditText, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AppCompatEditText appCompatEditText) {
            AppCompatEditText it = appCompatEditText;
            Intrinsics.checkNotNullParameter(it, "it");
            Editable text = PasswordInputView.this.getEditText().getText();
            return Boolean.valueOf(!(text == null || text.length() == 0));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PasswordInputView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayPasswordView$lambda$2$lambda$1(PasswordInputView this$0, ImageView this_apply, Context context, View view) {
        int i;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(context, "$context");
        AppCompatEditText editText = this$0.getEditText();
        if (this$0.isPasswordVisible()) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this_apply.setImageResource(R.drawable.ic_hide_m);
            i = R.string.password_input_content_description_show_data;
        } else {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this_apply.setImageResource(R.drawable.ic_show_m);
            i = R.string.password_input_content_description_hide_data;
        }
        this_apply.setContentDescription(context.getString(i));
        editText.setSelection(editText.length());
        Function1<? super Boolean, Unit> function1 = this$0.displayPasswordListener;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this$0.isPasswordVisible()));
        }
    }

    public final Function1<Boolean, Unit> getDisplayPasswordListener() {
        return this.displayPasswordListener;
    }

    public final boolean isPasswordVisible() {
        return Intrinsics.areEqual(getEditText().getTransformationMethod(), HideReturnsTransformationMethod.getInstance());
    }

    public final void setDisplayPasswordListener(Function1<? super Boolean, Unit> function1) {
        this.displayPasswordListener = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordInputView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        final ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ic_hide_m);
        imageView.setContentDescription(context.getString(R.string.password_input_content_description_show_data));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.ui.PasswordInputView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordInputView.displayPasswordView$lambda$2$lambda$1(this.f$0, imageView, context, view);
            }
        });
        this.displayPasswordView = imageView;
        AppCompatEditText editText = getEditText();
        editText.setInputType(pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6);
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        addAction(imageView, new a());
    }

    public /* synthetic */ PasswordInputView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
