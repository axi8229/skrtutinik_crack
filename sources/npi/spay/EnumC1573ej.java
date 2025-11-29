package npi.spay;

/* renamed from: npi.spay.ej, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1573ej implements InterfaceC1852q {
    LC_HELPERS_VIEW_APPEARED("LCHelpersViewAppeared"),
    LC_HELPERS_VIEW_DISAPPEARED("LCHelpersViewDisappeared"),
    TOUCH_MAKE_CARD("TouchMakeCard"),
    TOUCH_MAKE_TRANSFER("TouchMakeTransfer"),
    TOUCH_CANCEL("TouchCancel");

    public final String a;

    EnumC1573ej(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
