package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class I1 implements F1 {
    public final Set a;
    public final ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b b;
    public final ru.yoomoney.sdk.kassa.payments.payment.e c;
    public final ru.yoomoney.sdk.kassa.payments.payment.loadPaymentInfo.a d;
    public final ru.yoomoney.sdk.kassa.payments.payment.b e;
    public final ru.yoomoney.sdk.kassa.payments.payment.c f;
    public final M1 g;

    public I1(Set paymentOptionListRestrictions, ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b paymentOptionListRepository, ru.yoomoney.sdk.kassa.payments.payment.e saveLoadedPaymentOptionsListRepository, ru.yoomoney.sdk.kassa.payments.payment.loadPaymentInfo.a paymentMethodInfoGateway, ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository, ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository, M1 shopPropertiesRepository) {
        Intrinsics.checkNotNullParameter(paymentOptionListRestrictions, "paymentOptionListRestrictions");
        Intrinsics.checkNotNullParameter(paymentOptionListRepository, "paymentOptionListRepository");
        Intrinsics.checkNotNullParameter(saveLoadedPaymentOptionsListRepository, "saveLoadedPaymentOptionsListRepository");
        Intrinsics.checkNotNullParameter(paymentMethodInfoGateway, "paymentMethodInfoGateway");
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(shopPropertiesRepository, "shopPropertiesRepository");
        this.a = paymentOptionListRestrictions;
        this.b = paymentOptionListRepository;
        this.c = saveLoadedPaymentOptionsListRepository;
        this.d = paymentMethodInfoGateway;
        this.e = currentUserRepository;
        this.f = loadedPaymentOptionListRepository;
        this.g = shopPropertiesRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r25, java.lang.String r26, kotlin.coroutines.Continuation r27) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentOptionList.I1.a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ru.yoomoney.sdk.kassa.payments.model.T a(int i) {
        Object next;
        Iterator it = ((ru.yoomoney.sdk.kassa.payments.payment.d) this.f).b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ru.yoomoney.sdk.kassa.payments.model.T) next).getId() == i) {
                break;
            }
        }
        return (ru.yoomoney.sdk.kassa.payments.model.T) next;
    }
}
