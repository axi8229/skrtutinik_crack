package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.k0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC2490k0 {
    public static final ArrayList a(BankCardPaymentOption bankCardPaymentOption, Context context) throws Resources.NotFoundException {
        List<ru.yoomoney.sdk.kassa.payments.model.Q> paymentInstruments = bankCardPaymentOption.getPaymentInstruments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(paymentInstruments, 10));
        for (ru.yoomoney.sdk.kassa.payments.model.Q q : paymentInstruments) {
            int id = bankCardPaymentOption.getId();
            String strE = q.e();
            String string = context.getResources().getString(R$string.ym_linked_not_wallet_card);
            Drawable drawable = ContextCompat.getDrawable(context, ru.yoomoney.sdk.kassa.payments.utils.b.a(q.a(), q.b()));
            if (drawable == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String str = "•••• " + q.d();
            Intrinsics.checkNotNull(drawable);
            arrayList.add(new C2493l0(id, strE, null, drawable, str, string, false, true, false));
        }
        return arrayList;
    }
}
