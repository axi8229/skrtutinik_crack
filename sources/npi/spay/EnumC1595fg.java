package npi.spay;

/* renamed from: npi.spay.fg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1595fg implements InterfaceC1852q {
    TOUCH_TOP_BUTTON("TouchTopButton"),
    TOUCH_BOTTOM_BUTTON("TouchBottomButton"),
    LC_STATUS_SUCCESS_VIEW_APPEARED("LCStatusSuccessViewAppeared"),
    LC_STATUS_IN_PROGRESS_VIEW_APPEARED("LCStatusInProgressViewAppeared"),
    LC_STATUS_ERROR_VIEW_APPEARED("LCStatusErrorViewAppeared"),
    LC_STATUS_VIEW_DISAPPEARED("LCStatusViewDisappeared");

    public final String a;

    EnumC1595fg(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
