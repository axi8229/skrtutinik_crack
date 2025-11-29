package npi.spay;

/* renamed from: npi.spay.mh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1770mh implements InterfaceC1852q {
    RQ_IP("RQIp"),
    RQ_GOOD_IP("RQGoodIp"),
    RQ_FAIL_IP("RQFailIp"),
    RS_GOOD_IP("RSGoodIp"),
    RS_FAIL_IP("RSFailIp"),
    RQ_SESSION_ID("RQSessionId"),
    RQ_GOOD_SESSION_ID("RQGoodSessionId"),
    RQ_FAIL_SESSION_ID("RQFailSessionId"),
    RS_GOOD_SESSION_ID("RSGoodSessionId"),
    RS_FAIL_SESSION_ID("RSFailSessionId"),
    RQ_SDK_AUTH("RQSdkAuth"),
    RQ_GOOD_SDK_AUTH("RQGoodSdkAuth"),
    RQ_FAIL_SDK_AUTH("RQFailSdkAuth"),
    RS_GOOD_SDK_AUTH("RSGoodSdkAuth"),
    RS_FAIL_SDK_AUTH("RSFailSdkAuth"),
    RQ_LIST_CARDS("RQListCards"),
    RQ_GOOD_LIST_CARDS("RQGoodListCards"),
    RQ_FAIL_LIST_CARDS("RQFailListCards"),
    RS_GOOD_LIST_CARDS("RSGoodListCards"),
    RS_FAIL_LIST_CARDS("RSFailListCards"),
    RQ_PAYMENT_PLAN_BNPL("RQPaymentPlanBnpl"),
    RQ_GOOD_PAYMENT_PLAN_BNPL("RQGoodPaymentPlanBnpl"),
    RQ_FAIL_PAYMENT_PLAN_BNPL("RQFailPaymentPlanBnpl"),
    RS_GOOD_PAYMENT_PLAN_BNPL("RSGoodPaymentPlanBnpl"),
    RS_FAIL_PAYMENT_PLAN_BNPL("RSFailPaymentPlanBnpl"),
    RQ_CREATE_PAYMENT_PLAN("RQCreatePaymentPlan"),
    RQ_GOOD_CREATE_PAYMENT_PLAN("RQGoodCreatePaymentPlan"),
    RQ_FAIL_CREATE_PAYMENT_PLAN("RQFailCreatePaymentPlan"),
    RS_GOOD_CREATE_PAYMENT_PLAN("RSGoodCreatePaymentPlan"),
    RS_FAIL_CREATE_PAYMENT_PLAN("RSFailCreatePaymentPlan"),
    /* JADX INFO: Fake field, exist only in values array */
    LC_BANK_SDK_AUTH_VIEW_DISAPPEARED("RQBnpl"),
    /* JADX INFO: Fake field, exist only in values array */
    LC_BANK_SDK_AUTH_VIEW_DISAPPEARED("RQGoodBnpl"),
    /* JADX INFO: Fake field, exist only in values array */
    LC_BANK_SDK_AUTH_VIEW_DISAPPEARED("RQFailBnpl"),
    /* JADX INFO: Fake field, exist only in values array */
    LC_BANK_SDK_AUTH_VIEW_DISAPPEARED("RSGoodBnpl"),
    /* JADX INFO: Fake field, exist only in values array */
    LC_BANK_SDK_AUTH_VIEW_DISAPPEARED("RSFailBnpl"),
    ST_GET_GOOD_REFRESH("STGetGoodRefresh"),
    ST_GET_FAIL_REFRESH("STGetFailRefresh"),
    ST_SAVE_REFRESH("STSaveRefresh"),
    /* JADX INFO: Fake field, exist only in values array */
    LC_BANK_SDK_AUTH_VIEW_DISAPPEARED("LCBankSdkAuthViewAppeared"),
    /* JADX INFO: Fake field, exist only in values array */
    LC_BANK_SDK_AUTH_VIEW_DISAPPEARED("LCBankSdkAuthViewDisappeared"),
    LC_BANK_APP_SDK_AUTH("LCBankAppSdkAuth"),
    LC_BANK_APP_SDK_AUTH_GOOD("LCBankAppSdkAuthGood"),
    LC_BANK_APP_SDK_AUTH_FAIL("LCBankAppSdkAuthFail");

    public final String a;

    EnumC1770mh(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
