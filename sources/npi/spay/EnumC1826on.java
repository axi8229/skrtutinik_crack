package npi.spay;

/* renamed from: npi.spay.on, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1826on implements InterfaceC1852q {
    TOUCH_CONFIRM_OPERATION_BUTTON("TouchConfirmOperationButton"),
    TOUCH_CANCEL_BUTTON("TouchCancelButton"),
    LC_OTP_REVIEW_VIEW_APPEARED("LCOtpReviewViewAppeared"),
    LC_OTP_REVIEW_VIEW_DISAPPEARED("LCOtpReviewViewDisappeared");

    public final String a;

    EnumC1826on(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
