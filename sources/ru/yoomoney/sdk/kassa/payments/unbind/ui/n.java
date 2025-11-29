package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView;

/* loaded from: classes5.dex */
public final class n extends Lambda implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, String str2) {
        super(1);
        this.a = str;
        this.b = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context context = (Context) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        BankCardView bankCardView = new BankCardView(context, null, 0, 6, null);
        String str = this.a;
        String str2 = this.b;
        bankCardView.setClickable(false);
        bankCardView.setChangeCardAvailable(false);
        bankCardView.showBankLogo(str);
        bankCardView.setCardData(str, str2);
        bankCardView.hideAdditionalInfo();
        return bankCardView;
    }
}
