package npi.spay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.R$color;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$plurals;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class no {
    public final Ei a;
    public final C1993vg b;

    public no(Ei sPayStorage, C1993vg featuresHandler) {
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        this.a = sPayStorage;
        this.b = featuresHandler;
    }

    public final Oi a(List listOfCards, int i, long j) {
        Pe pe;
        N5 n5;
        M3 m3;
        Intrinsics.checkNotNullParameter(listOfCards, "listOfCards");
        ArrayList arrayList = new ArrayList();
        Iterator it = listOfCards.iterator();
        while (true) {
            pe = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData = ((ListOfCardsResponseBody.PaymentToolInfo.Tool) next).getAmountData();
            if (AbstractC2095zi.a(amountData != null ? Long.valueOf(amountData.getAmount()) : null) >= j) {
                arrayList.add(next);
            }
        }
        C1993vg c1993vg = this.b;
        EnumC1628h tag = EnumC1628h.CARD_LIST_SORT;
        c1993vg.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
        boolean z = true;
        Collection collectionSortedWith = arrayList;
        if (interfaceC2089zc != null) {
            collectionSortedWith = arrayList;
            if (((Boolean) interfaceC2089zc.a((Pe) null)).booleanValue()) {
                collectionSortedWith = CollectionsKt.sortedWith(CollectionsKt.sortedWith(arrayList, new Al()), new Jm());
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionSortedWith, 10));
        Iterator it2 = collectionSortedWith.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ListOfCardsResponseBody.PaymentToolInfo.Tool card = (ListOfCardsResponseBody.PaymentToolInfo.Tool) it2.next();
            C1993vg c1993vg2 = this.b;
            EnumC1628h tag2 = EnumC1628h.CARD_BALANCE;
            c1993vg2.getClass();
            Intrinsics.checkNotNullParameter(tag2, "tag");
            InterfaceC2089zc interfaceC2089zc2 = (InterfaceC2089zc) c1993vg2.c.get(tag2);
            boolean z2 = (interfaceC2089zc2 == null || ((Boolean) interfaceC2089zc2.a((Pe) null)).booleanValue() != z) ? false : z;
            boolean zA = AbstractC2095zi.a(card.getCountAdditionalCards(), 0);
            String cardNumber = card.getCardNumber();
            ListOfCardsResponseBody.PaymentToolInfo.Tool tool = ((C1604g0) ((C1822oj) this.a).b.getValue()).b;
            int i2 = Intrinsics.areEqual(cardNumber, tool != null ? tool.getCardNumber() : null) ? R$color.spay_card_selected_background_12 : R$color.spay_card_selection_background;
            int i3 = listOfCards.indexOf(card) == i ? R$drawable.spay_ic_selected : R$drawable.spay_ic_unselected;
            C1993vg c1993vg3 = this.b;
            EnumC1628h tag3 = EnumC1628h.S_BONUSES;
            c1993vg3.getClass();
            Intrinsics.checkNotNullParameter(tag3, "tag");
            InterfaceC2089zc interfaceC2089zc3 = (InterfaceC2089zc) c1993vg3.c.get(tag3);
            boolean z3 = interfaceC2089zc3 != null && ((Boolean) interfaceC2089zc3.a((Pe) null)).booleanValue();
            Intrinsics.checkNotNullParameter(card, "card");
            if (z2 && zA) {
                int paymentId = card.getPaymentId();
                String cardNumber2 = card.getCardNumber();
                String str = cardNumber2 == null ? "" : cardNumber2;
                int i4 = R$string.spay_currency_pattern;
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData2 = card.getAmountData();
                String strA = amountData2 != null ? AbstractC2095zi.a(amountData2.getAmount()) : null;
                if (strA == null) {
                    strA = "";
                }
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData3 = card.getAmountData();
                String currency = amountData3 != null ? amountData3.getCurrency() : null;
                Object[] args = {strA, currency != null ? currency : ""};
                Intrinsics.checkNotNullParameter(args, "args");
                C2097zk c2097zk = new C2097zk(i4, ArraysKt.toList(args));
                String cardLogoUrl = card.getCardLogoUrl();
                int i5 = R$string.spay_card_compound_wallet_number_pattern;
                int i6 = R$plurals.spay_order_compound_wallet_f;
                Integer countAdditionalCards = card.getCountAdditionalCards();
                String string = StringsKt.trim(card.getProductName()).toString();
                String precalculateBonuses = card.getPrecalculateBonuses();
                m3 = new M3(paymentId, i2, i3, i5, Integer.valueOf(i6), str, countAdditionalCards, c2097zk, string, cardLogoUrl, false, z3 ? precalculateBonuses != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses)) : null : 0);
            } else if (z2 && !zA) {
                int paymentId2 = card.getPaymentId();
                String cardNumber3 = card.getCardNumber();
                String str2 = cardNumber3 == null ? "" : cardNumber3;
                int i7 = R$string.spay_currency_pattern;
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData4 = card.getAmountData();
                String strA2 = amountData4 != null ? AbstractC2095zi.a(amountData4.getAmount()) : null;
                if (strA2 == null) {
                    strA2 = "";
                }
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData5 = card.getAmountData();
                String currency2 = amountData5 != null ? amountData5.getCurrency() : null;
                Object[] args2 = {strA2, currency2 != null ? currency2 : ""};
                Intrinsics.checkNotNullParameter(args2, "args");
                C2097zk c2097zk2 = new C2097zk(i7, ArraysKt.toList(args2));
                String cardLogoUrl2 = card.getCardLogoUrl();
                int i8 = R$string.spay_card_number_pattern;
                String string2 = StringsKt.trim(card.getProductName()).toString();
                String precalculateBonuses2 = card.getPrecalculateBonuses();
                m3 = new M3(paymentId2, i2, i3, i8, null, str2, null, c2097zk2, string2, cardLogoUrl2, false, z3 ? precalculateBonuses2 != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses2)) : null : 0);
            } else if (z2 || !zA) {
                int paymentId3 = card.getPaymentId();
                String paymentSystemType = card.getPaymentSystemType();
                if (paymentSystemType == null) {
                    paymentSystemType = "";
                }
                Ak akA = AbstractC1854q1.a(paymentSystemType, "text", paymentSystemType);
                String cardLogoUrl3 = card.getCardLogoUrl();
                int i9 = R$string.spay_card_number_pattern_old;
                String cardNumber4 = card.getCardNumber();
                String str3 = cardNumber4 == null ? "" : cardNumber4;
                String precalculateBonuses3 = card.getPrecalculateBonuses();
                m3 = new M3(paymentId3, i2, i3, i9, null, str3, null, akA, "", cardLogoUrl3, true, z3 ? precalculateBonuses3 != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses3)) : null : 0);
            } else {
                int paymentId4 = card.getPaymentId();
                String paymentSystemType2 = card.getPaymentSystemType();
                if (paymentSystemType2 == null) {
                    paymentSystemType2 = "";
                }
                Ak akA2 = AbstractC1854q1.a(paymentSystemType2, "text", paymentSystemType2);
                String cardLogoUrl4 = card.getCardLogoUrl();
                int i10 = R$string.spay_card_compound_wallet_number_pattern_old;
                int i11 = R$plurals.spay_order_compound_wallet_old_f;
                Integer countAdditionalCards2 = card.getCountAdditionalCards();
                String cardNumber5 = card.getCardNumber();
                String str4 = cardNumber5 == null ? "" : cardNumber5;
                String precalculateBonuses4 = card.getPrecalculateBonuses();
                m3 = new M3(paymentId4, i2, i3, i10, Integer.valueOf(i11), str4, countAdditionalCards2, akA2, "", cardLogoUrl4, true, z3 ? precalculateBonuses4 != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses4)) : null : 0);
            }
            arrayList2.add(m3);
            z = true;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : listOfCards) {
            ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData6 = ((ListOfCardsResponseBody.PaymentToolInfo.Tool) obj).getAmountData();
            if (AbstractC2095zi.a(amountData6 != null ? Long.valueOf(amountData6.getAmount()) : null) < j) {
                arrayList3.add(obj);
            }
        }
        C1993vg c1993vg4 = this.b;
        EnumC1628h tag4 = EnumC1628h.CARD_LIST_SORT;
        c1993vg4.getClass();
        Intrinsics.checkNotNullParameter(tag4, "tag");
        InterfaceC2089zc interfaceC2089zc4 = (InterfaceC2089zc) c1993vg4.c.get(tag4);
        Collection<ListOfCardsResponseBody.PaymentToolInfo.Tool> collectionSortedWith2 = arrayList3;
        if (interfaceC2089zc4 != null) {
            collectionSortedWith2 = arrayList3;
            if (((Boolean) interfaceC2089zc4.a((Pe) null)).booleanValue()) {
                collectionSortedWith2 = CollectionsKt.sortedWith(arrayList3, new C1475al());
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionSortedWith2, 10));
        for (ListOfCardsResponseBody.PaymentToolInfo.Tool card2 : collectionSortedWith2) {
            C1993vg c1993vg5 = this.b;
            EnumC1628h tag5 = EnumC1628h.CARD_BALANCE;
            c1993vg5.getClass();
            Intrinsics.checkNotNullParameter(tag5, "tag");
            InterfaceC2089zc interfaceC2089zc5 = (InterfaceC2089zc) c1993vg5.c.get(tag5);
            boolean z4 = interfaceC2089zc5 != null && ((Boolean) interfaceC2089zc5.a(pe)).booleanValue();
            boolean zA2 = AbstractC2095zi.a(card2.getCountAdditionalCards(), 0);
            String cardNumber6 = card2.getCardNumber();
            ListOfCardsResponseBody.PaymentToolInfo.Tool tool2 = ((C1604g0) ((C1822oj) this.a).b.getValue()).b;
            int i12 = Intrinsics.areEqual(cardNumber6, tool2 != null ? tool2.getCardNumber() : null) ? R$color.spay_card_selected_background_12 : R$color.spay_card_selection_background;
            int i13 = listOfCards.indexOf(card2) == i ? R$drawable.spay_ic_selected : R$drawable.spay_ic_unselected;
            C1993vg c1993vg6 = this.b;
            EnumC1628h tag6 = EnumC1628h.S_BONUSES;
            c1993vg6.getClass();
            Intrinsics.checkNotNullParameter(tag6, "tag");
            InterfaceC2089zc interfaceC2089zc6 = (InterfaceC2089zc) c1993vg6.c.get(tag6);
            boolean z5 = interfaceC2089zc6 != null && ((Boolean) interfaceC2089zc6.a((Pe) null)).booleanValue();
            Intrinsics.checkNotNullParameter(card2, "card");
            if (z4 && zA2) {
                int paymentId5 = card2.getPaymentId();
                String cardNumber7 = card2.getCardNumber();
                String str5 = cardNumber7 == null ? "" : cardNumber7;
                int i14 = R$string.spay_currency_pattern;
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData7 = card2.getAmountData();
                String strA3 = amountData7 != null ? AbstractC2095zi.a(amountData7.getAmount()) : null;
                if (strA3 == null) {
                    strA3 = "";
                }
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData8 = card2.getAmountData();
                String currency3 = amountData8 != null ? amountData8.getCurrency() : null;
                Object[] args3 = {strA3, currency3 == null ? "" : currency3};
                Intrinsics.checkNotNullParameter(args3, "args");
                C2097zk c2097zk3 = new C2097zk(i14, ArraysKt.toList(args3));
                String cardLogoUrl5 = card2.getCardLogoUrl();
                int i15 = R$string.spay_card_compound_wallet_number_pattern;
                int i16 = R$plurals.spay_order_compound_wallet_f;
                Integer countAdditionalCards3 = card2.getCountAdditionalCards();
                String string3 = StringsKt.trim(card2.getProductName()).toString();
                String precalculateBonuses5 = card2.getPrecalculateBonuses();
                n5 = new N5(paymentId5, i12, i13, i15, Integer.valueOf(i16), str5, countAdditionalCards3, c2097zk3, string3, cardLogoUrl5, false, z5 ? precalculateBonuses5 != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses5)) : null : 0);
            } else if (z4 && !zA2) {
                int paymentId6 = card2.getPaymentId();
                String cardNumber8 = card2.getCardNumber();
                String str6 = cardNumber8 == null ? "" : cardNumber8;
                int i17 = R$string.spay_currency_pattern;
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData9 = card2.getAmountData();
                String strA4 = amountData9 != null ? AbstractC2095zi.a(amountData9.getAmount()) : null;
                if (strA4 == null) {
                    strA4 = "";
                }
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData10 = card2.getAmountData();
                String currency4 = amountData10 != null ? amountData10.getCurrency() : null;
                if (currency4 == null) {
                    currency4 = "";
                }
                Object[] args4 = {strA4, currency4};
                Intrinsics.checkNotNullParameter(args4, "args");
                C2097zk c2097zk4 = new C2097zk(i17, ArraysKt.toList(args4));
                String cardLogoUrl6 = card2.getCardLogoUrl();
                int i18 = R$string.spay_card_number_pattern;
                String string4 = StringsKt.trim(card2.getProductName()).toString();
                String precalculateBonuses6 = card2.getPrecalculateBonuses();
                n5 = new N5(paymentId6, i12, i13, i18, null, str6, null, c2097zk4, string4, cardLogoUrl6, false, z5 ? precalculateBonuses6 != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses6)) : null : 0);
            } else if (z4 || !zA2) {
                int paymentId7 = card2.getPaymentId();
                String paymentSystemType3 = card2.getPaymentSystemType();
                if (paymentSystemType3 == null) {
                    paymentSystemType3 = "";
                }
                Ak akA3 = AbstractC1854q1.a(paymentSystemType3, "text", paymentSystemType3);
                String cardLogoUrl7 = card2.getCardLogoUrl();
                int i19 = R$string.spay_card_number_pattern_old;
                String cardNumber9 = card2.getCardNumber();
                String str7 = cardNumber9 == null ? "" : cardNumber9;
                String precalculateBonuses7 = card2.getPrecalculateBonuses();
                n5 = new N5(paymentId7, i12, i13, i19, null, str7, null, akA3, "", cardLogoUrl7, true, z5 ? precalculateBonuses7 != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses7)) : null : 0);
                arrayList4.add(n5);
                pe = null;
            } else {
                int paymentId8 = card2.getPaymentId();
                String paymentSystemType4 = card2.getPaymentSystemType();
                if (paymentSystemType4 == null) {
                    paymentSystemType4 = "";
                }
                Ak akA4 = AbstractC1854q1.a(paymentSystemType4, "text", paymentSystemType4);
                String cardLogoUrl8 = card2.getCardLogoUrl();
                int i20 = R$string.spay_card_compound_wallet_number_pattern_old;
                int i21 = R$plurals.spay_order_compound_wallet_old_f;
                Integer countAdditionalCards4 = card2.getCountAdditionalCards();
                String cardNumber10 = card2.getCardNumber();
                String str8 = cardNumber10 == null ? "" : cardNumber10;
                String precalculateBonuses8 = card2.getPrecalculateBonuses();
                n5 = new N5(paymentId8, i12, i13, i20, Integer.valueOf(i21), str8, countAdditionalCards4, akA4, "", cardLogoUrl8, true, z5 ? precalculateBonuses8 != null ? Integer.valueOf(AbstractC1946tj.d(precalculateBonuses8)) : null : 0);
            }
            arrayList4.add(n5);
            pe = null;
        }
        ArrayList arrayList5 = new ArrayList();
        if (!arrayList2.isEmpty()) {
            arrayList5.addAll(arrayList2);
        }
        if (!arrayList4.isEmpty()) {
            arrayList5.add(new N4(new C2097zk(R$string.spay_card_selection_header_not_enough_money, CollectionsKt.emptyList()), new C2097zk(R$string.spay_card_selection_description_not_enough_money, CollectionsKt.emptyList())));
            arrayList5.addAll(arrayList4);
        }
        return new Oi(i, arrayList5);
    }
}
