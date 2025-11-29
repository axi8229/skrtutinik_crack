package npi.spay;

/* loaded from: classes4.dex */
public enum Wl implements InterfaceC1852q {
    TOUCH_TO_PAYMENT_METHODS_BUTTON("TouchToPaymentMethodsButton"),
    LC_DENY_VIEW_APPEARED("LCDenyViewAppeared"),
    LC_DENY_VIEW_DISAPPEARED("LCDenyViewDisappeared");

    public final String a;

    Wl(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
