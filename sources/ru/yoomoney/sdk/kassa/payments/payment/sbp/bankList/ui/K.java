package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.ui.focus.FocusManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class K extends Lambda implements Function1 {
    public final /* synthetic */ FocusManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(FocusManager focusManager) {
        super(1);
        this.a = focusManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        KeyboardActionScope $receiver = (KeyboardActionScope) obj;
        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
        FocusManager.clearFocus$default(this.a, false, 1, null);
        return Unit.INSTANCE;
    }
}
