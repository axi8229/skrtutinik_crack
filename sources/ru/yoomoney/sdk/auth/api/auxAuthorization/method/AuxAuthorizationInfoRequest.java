package ru.yoomoney.sdk.auth.api.auxAuthorization.method;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/method/AuxAuthorizationInfoRequest;", "", "clientId", "", "scopes", "", "(Ljava/lang/String;Ljava/util/List;)V", "getClientId", "()Ljava/lang/String;", "getScopes", "()Ljava/util/List;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxAuthorizationInfoRequest {

    @SerializedName("clientId")
    private final String clientId;

    @SerializedName("scopes")
    private final List<String> scopes;

    public AuxAuthorizationInfoRequest(String clientId, List<String> scopes) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        this.clientId = clientId;
        this.scopes = scopes;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final List<String> getScopes() {
        return this.scopes;
    }
}
