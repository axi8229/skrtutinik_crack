package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.Context;
import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes5.dex */
public final class U implements ru.yoomoney.sdk.kassa.payments.errorFormatter.b {
    public final Context a;
    public final ru.yoomoney.sdk.kassa.payments.errorFormatter.b b;

    public U(Context context, ru.yoomoney.sdk.kassa.payments.errorFormatter.b paymentErrorFormatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentErrorFormatter, "paymentErrorFormatter");
        this.a = context;
        this.b = paymentErrorFormatter;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.errorFormatter.b
    public final CharSequence a(Throwable e) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!(e instanceof ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.a)) {
            return this.b.a(e);
        }
        CharSequence text = this.a.getResources().getText(R$string.ym_no_payment_options_error);
        Intrinsics.checkNotNull(text);
        return text;
    }
}
