package npi.spay;

/* loaded from: classes4.dex */
public enum Sl implements InterfaceC1852q {
    TOUCH_CARD("TouchCard"),
    TOUCH_PAY("TouchPay"),
    TOUCH_CANCEL("TouchCancel"),
    TOUCH_APPROVE_BNPL("TouchApproveBNPL"),
    TOUCH_CONTRACT_VIEW("TouchContractView"),
    TOUCH_AGREEMENT_VIEW("TouchAgreementView");

    public final String a;

    Sl(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
