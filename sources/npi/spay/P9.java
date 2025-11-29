package npi.spay;

/* loaded from: classes4.dex */
public enum P9 implements InterfaceC1852q {
    TOUCH_CONFIRM_OPERATION_BUTTON("TouchConfirmOperationButton"),
    TOUCH_CANCEL_BUTTON("TouchCancelButton"),
    TOUCH_HYPERLINK("TouchHyperlink"),
    LC_REVIEW_HINT_VIEW_APPEARED("LCReviewHintViewAppeared"),
    LC_REVIEW_HINT_VIEW_DISAPPEARED("LCReviewHintViewDisappeared");

    public final String a;

    P9(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
