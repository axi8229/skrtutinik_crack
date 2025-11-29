package npi.spay;

/* renamed from: npi.spay.fn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1602fn implements InterfaceC1852q {
    TOUCH_ISSUE_CARD("TouchIssueCard"),
    TOUCH_CANCEL("TouchCancel"),
    LC_NO_ACTIVE_CARDS_VIEW_APPEARED("LCNoActiveCardsViewAppeared"),
    LC_NO_ACTIVE_CARDS_VIEW_DISAPPEARED("LCNoActiveCardsViewDisappeared");

    public final String a;

    EnumC1602fn(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
