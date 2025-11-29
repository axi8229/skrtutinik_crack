package sberid.sdk.auth.model;

import kotlin.Metadata;

/* compiled from: StandName.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lsberid/sdk/auth/model/StandName;", "", "url", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "CLOUD_IFT", "CLOUD_PSI", "ESA_IFT", "ESA_PSI", "PROM", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public enum StandName {
    CLOUD_IFT("https://id-ift.sber.ru/CSAFront/oidc/sberbank_id/authorize.do"),
    CLOUD_PSI("https://id-psi.sber.ru/CSAFront/oidc/sberbank_id/authorize.do"),
    ESA_IFT("https://ift-csa.testonline.sberbank.ru:4456/CSAFront/oidc/authorize.do"),
    ESA_PSI("https://psi-csa.testonline.sberbank.ru/CSAFront/oidc/authorize.do"),
    PROM("https://online.sberbank.ru/CSAFront/oidc/authorize.do");

    private final String url;

    StandName(String str) {
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}
