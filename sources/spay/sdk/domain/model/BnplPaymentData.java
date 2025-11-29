package spay.sdk.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.C1715kc;
import npi.spay.C1815oc;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lspay/sdk/domain/model/BnplPaymentData;", "", "merchantLogin", "", "apiKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getMerchantLogin", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BnplPaymentData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String apiKey;
    private final String merchantLogin;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lspay/sdk/domain/model/BnplPaymentData$Companion;", "", "()V", "getBnplPaymentData", "Lspay/sdk/domain/model/BnplPaymentData;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BnplPaymentData getBnplPaymentData() {
            int i = C1815oc.b;
            if (i == 1) {
                return new BnplPaymentData("bnpl-sbrf", "AHMjXmv8vkVhvybwIqlm2cIAAAAAAAAADHRDSikJqKmlyVz6NxPPBwS3tuDjhZMYQjoj4LwfvhrdJ2w5XUfZc8/nGNWtc0QVMH37jvx5G3B+HqJ8/eMEN6xOXD7cxvXGdN2eh1l7oc6wqq+IozWI+jtlX6R5ZfpqT2c0aEAEZegwFuhfg66gBKi4DdMcDw==");
            }
            if (i == 3) {
                return new BnplPaymentData("bnpl_sbrf", "AL6zIhba+UMTsQmd/nRpFbQAAAAAAAAADJXNTkFfYPGQfnUNkAile/7RAcbRtqIcsm64coPhlMKLhpc9J5vJq8hTm9JkA2FFyrZPBJ56e1yyaAiQ47r74zhUDkBXwbmVOKOXIQTnhFflBcpIpwsrCMVSNPGAhFR7z3DqbwSf3qzJ0gLOcoEte/nQs8sNbw==");
            }
            if (i == 2) {
                return new BnplPaymentData("bnpl_sbrf", "AHMjXmv8vkVhvybwIqlm2cIAAAAAAAAADHRDSikJqKmlyVz6NxPPBwS3tuDjhZMYQjoj4LwfvhrdJ2w5XUfZc8/nGNWtc0QVMH37jvx5G3B+HqJ8/eMEN6xOXD7cxvXGdN2eh1l7oc6wqq+IozWI+jtlX6R5ZfpqT2c0aEAEZegwFuhfg66gBKi4DdMcDw==");
            }
            if (i == 6 || i == 7) {
                return new BnplPaymentData("bnpl_sbrf", "AL6zIhba+UMTsQmd/nRpFbQAAAAAAAAADJXNTkFfYPGQfnUNkAile/7RAcbRtqIcsm64coPhlMKLhpc9J5vJq8hTm9JkA2FFyrZPBJ56e1yyaAiQ47r74zhUDkBXwbmVOKOXIQTnhFflBcpIpwsrCMVSNPGAhFR7z3DqbwSf3qzJ0gLOcoEte/nQs8sNbw==");
            }
            if (i == 5) {
                return new BnplPaymentData("bnpl_sbrf", "AL6zIhba+UMTsQmd/nRpFbQAAAAAAAAADJXNTkFfYPGQfnUNkAile/7RAcbRtqIcsm64coPhlMKLhpc9J5vJq8hTm9JkA2FFyrZPBJ56e1yyaAiQ47r74zhUDkBXwbmVOKOXIQTnhFflBcpIpwsrCMVSNPGAhFR7z3DqbwSf3qzJ0gLOcoEte/nQs8sNbw==");
            }
            throw C1715kc.a;
        }
    }

    public BnplPaymentData(String merchantLogin, String apiKey) {
        Intrinsics.checkNotNullParameter(merchantLogin, "merchantLogin");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.merchantLogin = merchantLogin;
        this.apiKey = apiKey;
    }

    public static /* synthetic */ BnplPaymentData copy$default(BnplPaymentData bnplPaymentData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bnplPaymentData.merchantLogin;
        }
        if ((i & 2) != 0) {
            str2 = bnplPaymentData.apiKey;
        }
        return bnplPaymentData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    public final BnplPaymentData copy(String merchantLogin, String apiKey) {
        Intrinsics.checkNotNullParameter(merchantLogin, "merchantLogin");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        return new BnplPaymentData(merchantLogin, apiKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BnplPaymentData)) {
            return false;
        }
        BnplPaymentData bnplPaymentData = (BnplPaymentData) other;
        return Intrinsics.areEqual(this.merchantLogin, bnplPaymentData.merchantLogin) && Intrinsics.areEqual(this.apiKey, bnplPaymentData.apiKey);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public int hashCode() {
        return this.apiKey.hashCode() + (this.merchantLogin.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BnplPaymentData(merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", apiKey=");
        return Q1.a(sb, this.apiKey, ')');
    }
}
