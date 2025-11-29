package npi.spay;

/* loaded from: classes4.dex */
public enum Ok implements InterfaceC1852q {
    TOUCH_CONFIRMED_BY_USER("TouchConfirmedByUser"),
    TOUCH_DECLINED_BY_USER("TouchDeclinedByUser"),
    TOUCH_APPROVE_BNPL("TouchApproveBNPL"),
    TOUCH_CONTRACT_VIEW("TouchContractView"),
    TOUCH_AGREEMENT_VIEW("TouchAgreementView"),
    LC_BNPL_VIEW_APPEARED("LCBnplViewAppeared"),
    LC_BNPL_VIEW_DISAPPEARED("LCBnplViewDisappeared");

    public final String a;

    Ok(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
