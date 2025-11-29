package npi.spay;

/* loaded from: classes4.dex */
public enum K7 implements InterfaceC1852q {
    TOUCH_CARD("TouchCard"),
    TOUCH_BNPL("TouchBNPL"),
    TOUCH_PAY("TouchPay"),
    TOUCH_CANCEL("TouchCancel"),
    RQ_LIST_CARDS("RQListCards"),
    RQ_GOOD_LIST_CARDS("RQGoodListCards"),
    RQ_FAIL_LIST_CARDS("RQFailListCards"),
    RS_GOOD_LIST_CARDS("RSGoodListCards"),
    RS_FAIL_LIST_CARDS("RSFailListCards"),
    RQ_PAYMENT_TOKEN("RQPaymentToken"),
    RQ_GOOD_PAYMENT_TOKEN("RQGoodPaymentToken"),
    RQ_FAIL_PAYMENT_TOKEN("RQFailPaymentToken"),
    RS_GOOD_PAYMENT_TOKEN("RSGoodPaymentToken"),
    RS_FAIL_PAYMENT_TOKEN("RSFailPaymentToken"),
    RQ_PAYMENT_ORDER("RQPaymentOrder"),
    RQ_GOOD_PAYMENT_ORDER("RQGoodPaymentOrder"),
    RQ_FAIL_PAYMENT_ORDER("RQFailPaymentOrder"),
    RS_GOOD_PAYMENT_ORDER("RSGoodPaymentOrder"),
    RS_FAIL_PAYMENT_ORDER("RSFailPaymentOrder"),
    LC_BIO_AUTH_START("LCBioAuthStart"),
    LC_GOOD_BIO_AUTH("LCGoodBioAuth"),
    LC_FAIL_BIO_AUTH("LCFailBioAuth"),
    LC_BANK_APP_AUTH("LCBankAppAuth"),
    LC_BANK_APP_AUTH_GOOD("LCBankAppAuthGood"),
    LC_BANK_APP_AUTH_FAIL("LCBankAppAuthFail"),
    LC_PAY_VIEW_APPEARED("LCPayViewAppeared"),
    LC_PAY_VIEW_DISAPPEARED("LCPayViewDisappeared"),
    LC_PAY_BNPL_AVAILABLE("LCPayBnplAvailable"),
    LC_PAY_BNPL_UNAVAILABLE("LCPayBnplUnavailable"),
    LC_PAY_BNPL_START("LCPayBnplStart");

    public final String a;

    K7(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
