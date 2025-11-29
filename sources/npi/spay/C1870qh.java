package npi.spay;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.qh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1870qh extends Lambda implements Function1 {
    public static final C1870qh a = new C1870qh();

    public C1870qh() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ListOfCardsResponseBody.PaymentToolInfo.Tool it = (ListOfCardsResponseBody.PaymentToolInfo.Tool) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData = it.getAmountData();
        return String.valueOf(amountData != null ? Long.valueOf(amountData.getAmount()) : null);
    }
}
