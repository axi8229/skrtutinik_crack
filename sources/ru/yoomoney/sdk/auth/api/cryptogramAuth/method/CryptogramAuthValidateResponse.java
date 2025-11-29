package ru.yoomoney.sdk.auth.api.cryptogramAuth.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateResponse;", "", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "(Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CryptogramAuthValidateResponse {

    @SerializedName(YooMoneyAuth.KEY_ACCESS_TOKEN)
    private final String accessToken;

    public CryptogramAuthValidateResponse(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.accessToken = accessToken;
    }

    public static /* synthetic */ CryptogramAuthValidateResponse copy$default(CryptogramAuthValidateResponse cryptogramAuthValidateResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cryptogramAuthValidateResponse.accessToken;
        }
        return cryptogramAuthValidateResponse.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final CryptogramAuthValidateResponse copy(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return new CryptogramAuthValidateResponse(accessToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CryptogramAuthValidateResponse) && Intrinsics.areEqual(this.accessToken, ((CryptogramAuthValidateResponse) other).accessToken);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public int hashCode() {
        return this.accessToken.hashCode();
    }

    public String toString() {
        return "CryptogramAuthValidateResponse(accessToken=" + this.accessToken + ")";
    }
}
