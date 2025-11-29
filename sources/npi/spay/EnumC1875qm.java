package npi.spay;

/* renamed from: npi.spay.qm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1875qm implements InterfaceC1852q {
    TOUCH_BACK("TouchBack"),
    TOUCH_LOG_OUT("TouchLogOut"),
    /* JADX INFO: Fake field, exist only in values array */
    RQ_REVOKE_TOKEN_SDK("RQRevokeTokenSdk"),
    RQ_GOOD_REVOKE_TOKEN_SDK("RQGoodRevokeTokenSdk"),
    RQ_FAIL_REVOKE_TOKEN_SDK("RQFailRevokeTokenSdk"),
    RS_GOOD_REVOKE_TOKEN_SDK("RSGoodRevokeTokenSdk"),
    RS_FAIL_REVOKE_TOKEN_SDK("RSFailRevokeTokenSdk"),
    /* JADX INFO: Fake field, exist only in values array */
    ST_REMOVE_REFRESH("STRemoveRefresh"),
    LC_PROFILE_VIEW_APPEARED("LCProfileViewAppeared"),
    LC_PROFILE_VIEW_DISAPPEARED("LCProfileViewDisappeared");

    public final String a;

    EnumC1875qm(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
