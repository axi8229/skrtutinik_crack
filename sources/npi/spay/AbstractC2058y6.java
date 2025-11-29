package npi.spay;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.R$plurals;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.y6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2058y6 {
    public static C2083z6 a(ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z, boolean z2) {
        C2083z6 c2083z6;
        String precalculateBonuses;
        String precalculateBonuses2;
        String precalculateBonuses3;
        String productName;
        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData;
        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData2;
        String precalculateBonuses4;
        String productName2;
        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData3;
        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData4;
        Integer numValueOf = null;
        if (z && z2) {
            int i = R$string.spay_currency_pattern;
            String strA = (tool == null || (amountData4 = tool.getAmountData()) == null) ? null : AbstractC2095zi.a(amountData4.getAmount());
            if (strA == null) {
                strA = "";
            }
            String currency = (tool == null || (amountData3 = tool.getAmountData()) == null) ? null : amountData3.getCurrency();
            if (currency == null) {
                currency = "";
            }
            Object[] args = {strA, currency};
            Intrinsics.checkNotNullParameter(args, "args");
            C2097zk c2097zk = new C2097zk(i, ArraysKt.toList(args));
            String string = (tool == null || (productName2 = tool.getProductName()) == null) ? null : StringsKt.trim(productName2).toString();
            String str = string == null ? "" : string;
            int i2 = R$string.spay_card_compound_wallet_number_pattern;
            Integer numValueOf2 = Integer.valueOf(R$plurals.spay_order_compound_wallet_f);
            String cardNumber = tool != null ? tool.getCardNumber() : null;
            String str2 = cardNumber == null ? "" : cardNumber;
            Integer countAdditionalCards = tool != null ? tool.getCountAdditionalCards() : null;
            String cardLogoUrl = tool != null ? tool.getCardLogoUrl() : null;
            if (tool != null && (precalculateBonuses4 = tool.getPrecalculateBonuses()) != null) {
                numValueOf = Integer.valueOf(Integer.parseInt(precalculateBonuses4));
            }
            c2083z6 = new C2083z6(c2097zk, str, i2, numValueOf2, str2, countAdditionalCards, cardLogoUrl, false, Integer.valueOf(AbstractC2095zi.a(numValueOf)));
        } else if (z && !z2) {
            int i3 = R$string.spay_currency_pattern;
            String strA2 = (tool == null || (amountData2 = tool.getAmountData()) == null) ? null : AbstractC2095zi.a(amountData2.getAmount());
            if (strA2 == null) {
                strA2 = "";
            }
            String currency2 = (tool == null || (amountData = tool.getAmountData()) == null) ? null : amountData.getCurrency();
            if (currency2 == null) {
                currency2 = "";
            }
            Object[] args2 = {strA2, currency2};
            Intrinsics.checkNotNullParameter(args2, "args");
            C2097zk c2097zk2 = new C2097zk(i3, ArraysKt.toList(args2));
            String string2 = (tool == null || (productName = tool.getProductName()) == null) ? null : StringsKt.trim(productName).toString();
            String str3 = string2 == null ? "" : string2;
            int i4 = R$string.spay_card_number_pattern;
            String cardNumber2 = tool != null ? tool.getCardNumber() : null;
            String str4 = cardNumber2 == null ? "" : cardNumber2;
            String cardLogoUrl2 = tool != null ? tool.getCardLogoUrl() : null;
            if (tool != null && (precalculateBonuses3 = tool.getPrecalculateBonuses()) != null) {
                numValueOf = Integer.valueOf(AbstractC1946tj.d(precalculateBonuses3));
            }
            c2083z6 = new C2083z6(c2097zk2, str3, i4, null, str4, null, cardLogoUrl2, false, numValueOf, 40);
        } else if (z || !z2) {
            String paymentSystemType = tool != null ? tool.getPaymentSystemType() : null;
            if (paymentSystemType == null) {
                paymentSystemType = "";
            }
            Ak akA = AbstractC1854q1.a(paymentSystemType, "text", paymentSystemType);
            int i5 = R$string.spay_card_number_pattern_old;
            String cardNumber3 = tool != null ? tool.getCardNumber() : null;
            String str5 = cardNumber3 == null ? "" : cardNumber3;
            String cardLogoUrl3 = tool != null ? tool.getCardLogoUrl() : null;
            if (tool != null && (precalculateBonuses = tool.getPrecalculateBonuses()) != null) {
                numValueOf = Integer.valueOf(Integer.parseInt(precalculateBonuses));
            }
            c2083z6 = new C2083z6(akA, "", i5, null, str5, null, cardLogoUrl3, true, Integer.valueOf(AbstractC2095zi.a(numValueOf)), 40);
        } else {
            String paymentSystemType2 = tool != null ? tool.getPaymentSystemType() : null;
            if (paymentSystemType2 == null) {
                paymentSystemType2 = "";
            }
            Ak akA2 = AbstractC1854q1.a(paymentSystemType2, "text", paymentSystemType2);
            int i6 = R$string.spay_card_compound_wallet_number_pattern_old;
            Integer numValueOf3 = Integer.valueOf(R$plurals.spay_order_compound_wallet_old_f);
            String cardNumber4 = tool != null ? tool.getCardNumber() : null;
            String str6 = cardNumber4 == null ? "" : cardNumber4;
            Integer countAdditionalCards2 = tool != null ? tool.getCountAdditionalCards() : null;
            String cardLogoUrl4 = tool != null ? tool.getCardLogoUrl() : null;
            if (tool != null && (precalculateBonuses2 = tool.getPrecalculateBonuses()) != null) {
                numValueOf = Integer.valueOf(AbstractC1946tj.d(precalculateBonuses2));
            }
            c2083z6 = new C2083z6(akA2, "", i6, numValueOf3, str6, countAdditionalCards2, cardLogoUrl4, true, numValueOf);
        }
        return c2083z6;
    }
}
