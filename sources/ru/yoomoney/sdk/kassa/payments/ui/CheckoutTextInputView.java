package ru.yoomoney.sdk.kassa.payments.ui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.widget.TextInputView;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;
import ru.yoomoney.sdk.kassa.payments.utils.e;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/CheckoutTextInputView;", "Lru/yoomoney/sdk/gui/widget/TextInputView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setImeOptions", "", "imeOptions", "stateArray", "", "", "()[[I", "typeColorStateList", "Landroid/content/res/ColorStateList;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckoutTextInputView extends TextInputView {
    public static final int $stable = 0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckoutTextInputView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CheckoutTextInputView this$0, Context context, View view, boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (z) {
            this$0.tintColorStateList(this$0.typeColorStateList(context));
            e.a(this$0.getEditText(), InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor());
        }
    }

    private final int[][] stateArray() {
        return new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    private final ColorStateList typeColorStateList(Context context) {
        return new ColorStateList(stateArray(), new int[]{ContextCompat.getColor(context, R$color.color_type_ghost), InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor()});
    }

    public final void setImeOptions(int imeOptions) {
        getEditText().setImeOptions(imeOptions);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckoutTextInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutTextInputView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.CheckoutTextInputView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
                CheckoutTextInputView._init_$lambda$0(this.f$0, context, view, z);
            }
        });
    }

    public /* synthetic */ CheckoutTextInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
