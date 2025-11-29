package npi.spay;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.al, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1475al implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData = ((ListOfCardsResponseBody.PaymentToolInfo.Tool) obj2).getAmountData();
        Long lValueOf = amountData != null ? Long.valueOf(amountData.getAmount()) : null;
        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData2 = ((ListOfCardsResponseBody.PaymentToolInfo.Tool) obj).getAmountData();
        return ComparisonsKt.compareValues(lValueOf, amountData2 != null ? Long.valueOf(amountData2.getAmount()) : null);
    }
}
