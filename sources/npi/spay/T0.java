package npi.spay;

/* loaded from: classes4.dex */
public enum T0 implements InterfaceC1852q {
    TOUCH_BACK("TouchBack"),
    TOUCH_SHARE("TouchShare"),
    LC_WEB_VIEW_APPEARED("LCWebViewAppeared"),
    LC_WEB_VIEW_DISAPPEARED("LCWebViewDisappeared");

    public final String a;

    T0(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
