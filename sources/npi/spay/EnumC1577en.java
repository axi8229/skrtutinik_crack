package npi.spay;

/* renamed from: npi.spay.en, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1577en implements InterfaceC1852q {
    SDK_VERSION("SDKVersion"),
    RQ_REMOTE_CONFIG("RQRemoteConfig"),
    RQ_GOOD_REMOTE_CONFIG("RQGoodRemoteConfig"),
    RQ_FAIL_REMOTE_CONFIG("RQFailRemoteConfig"),
    RS_GOOD_REMOTE_CONFIG("RSGoodRemoteConfig"),
    RS_FAIL_REMOTE_CONFIG("RSFailRemoteConfig"),
    /* JADX INFO: Fake field, exist only in values array */
    ST_GET_GOOD_REMOTE_CONFIG("STGetGoodRemoteConfig"),
    /* JADX INFO: Fake field, exist only in values array */
    ST_GET_FAIL_REMOTE_CONFIG("STGetFailRemoteConfig"),
    LC_BANK_APP_FOUND("LCBankAppFound"),
    LC_NO_BANK_APP_FOUND("LCNoBankAppFound"),
    LC_PAY_BUTTON_INITED("LCPayButtonInited"),
    SC_PERMISSIONS("SCPermissions"),
    SC_GOOD_PERMISSIONS("SCGoodPermissions"),
    SC_FAIL_PERMISSIONS("SCFailPermissions"),
    SC_BIZONE("SCBiZone"),
    SC_GOOD_BIZONE("SCGoodBiZone"),
    SC_FAIL_BIZONE("SCFailBiZone");

    public final String a;

    EnumC1577en(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
