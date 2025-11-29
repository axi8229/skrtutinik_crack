package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.contract.savePayment.SavePaymentMethodInfoActivity;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.j0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2235j0 extends Lambda implements Function1 {
    public final /* synthetic */ C2264y0 a;
    public final /* synthetic */ S0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2235j0(C2264y0 c2264y0, S0 s0) {
        super(1);
        this.a = c2264y0;
        this.b = s0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Context contextRequireContext = this.a.requireContext();
        int i = SavePaymentMethodInfoActivity.$r8$clinit;
        Context context = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(context, "requireContext(...)");
        S0 s0 = this.b;
        String title = s0.c;
        String text = s0.d;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intent intent = new Intent(context, (Class<?>) SavePaymentMethodInfoActivity.class);
        intent.putExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TITLE_STRING", title);
        intent.putExtra("ru.yoo.money.android.extra.SAVE_PAYMENT_INFO_TEXT_STRING", text);
        ContextCompat.startActivity(contextRequireContext, intent.setFlags(268435456), null);
        return Unit.INSTANCE;
    }
}
