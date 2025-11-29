package npi.spay;

/* renamed from: npi.spay.lm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1750lm implements InterfaceC1852q {
    TOUCH_BACK("TouchBack"),
    TOUCH_NEXT("TouchNext"),
    RQ_CREATE_OTP("RQCreateOtp"),
    RQ_GOOD_CREATE_OTP("RQGoodCreateOtp"),
    RQ_FAIL_CREATE_OTP("RQFailCreateOtp"),
    RS_GOOD_CREATE_OTP("RSGoodCreateOtp"),
    RS_FAIL_CREATE_OTP("RSFailCreateOtp"),
    RQ_CONFIRM_OTP("RQConfirmOtp"),
    RQ_GOOD_CONFIRM_OTP("RQGoodConfirmOtp"),
    RQ_FAIL_CONFIRM_OTP("RQFailConfirmOtp"),
    RS_GOOD_CONFIRM_OTP("RSGoodConfirmOtp"),
    RS_FAIL_CONFIRM_OTP("RSFailConfirmOtp"),
    LC_OTP_VIEW_APPEARED("LCOtpViewAppeared"),
    LC_OTP_VIEW_DISAPPEARED("LCOtpViewDisappeared");

    public final String a;

    EnumC1750lm(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
