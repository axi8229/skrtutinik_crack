package npi.spay;

/* renamed from: npi.spay.h6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1635h6 implements InterfaceC1852q {
    RQ_PAY_ONLINE("RQPayOnline"),
    RQ_GOOD_PAY_ONLINE("RQGoodPayOnline"),
    RQ_FAIL_PAY_ONLINE("RQFailPayOnline");

    public final String a;

    EnumC1635h6(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
