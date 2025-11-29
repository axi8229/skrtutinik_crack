package ru.yoomoney.sdk.kassa.payments.ui.view;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u000fH\u0016R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/view/BackPressedAppCompatDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lru/yoomoney/sdk/kassa/payments/ui/view/WithBackPressedListener;", "context", "Landroid/content/Context;", "theme", "", "(Landroid/content/Context;I)V", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackPressedAppCompatDialog extends AppCompatDialog implements WithBackPressedListener {
    public static final int $stable = 8;
    private Function0<Boolean> onBackPressed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackPressedAppCompatDialog(Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.view.WithBackPressedListener
    public Function0<Boolean> getOnBackPressed() {
        return this.onBackPressed;
    }

    @Override // androidx.view.ComponentDialog, android.app.Dialog
    public void onBackPressed() {
        Function0<Boolean> onBackPressed = getOnBackPressed();
        if (onBackPressed == null || !onBackPressed.invoke().booleanValue()) {
            super.onBackPressed();
        }
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.view.WithBackPressedListener
    public void setOnBackPressed(Function0<Boolean> function0) {
        this.onBackPressed = function0;
    }
}
