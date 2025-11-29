package ru.yoomoney.sdk.auth.api.account.socialAccount.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.model.ConnectSocialAccountProcess;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/method/ConnectSocialAccountSuccessResponse;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/ConnectSocialAccountResponse;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "process", "Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountProcess;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountProcess;", "getTmxSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ConnectSocialAccountSuccessResponse extends ConnectSocialAccountResponse {

    @SerializedName("process")
    private final ConnectSocialAccountProcess process;

    @SerializedName(YooMoneyAuth.KEY_TMX_SESSION_ID)
    private final String tmxSessionId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectSocialAccountSuccessResponse(String str, ConnectSocialAccountProcess process) {
        super(null);
        Intrinsics.checkNotNullParameter(process, "process");
        this.tmxSessionId = str;
        this.process = process;
    }

    public static /* synthetic */ ConnectSocialAccountSuccessResponse copy$default(ConnectSocialAccountSuccessResponse connectSocialAccountSuccessResponse, String str, ConnectSocialAccountProcess connectSocialAccountProcess, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectSocialAccountSuccessResponse.tmxSessionId;
        }
        if ((i & 2) != 0) {
            connectSocialAccountProcess = connectSocialAccountSuccessResponse.process;
        }
        return connectSocialAccountSuccessResponse.copy(str, connectSocialAccountProcess);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final ConnectSocialAccountProcess getProcess() {
        return this.process;
    }

    public final ConnectSocialAccountSuccessResponse copy(String tmxSessionId, ConnectSocialAccountProcess process) {
        Intrinsics.checkNotNullParameter(process, "process");
        return new ConnectSocialAccountSuccessResponse(tmxSessionId, process);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectSocialAccountSuccessResponse)) {
            return false;
        }
        ConnectSocialAccountSuccessResponse connectSocialAccountSuccessResponse = (ConnectSocialAccountSuccessResponse) other;
        return Intrinsics.areEqual(this.tmxSessionId, connectSocialAccountSuccessResponse.tmxSessionId) && Intrinsics.areEqual(this.process, connectSocialAccountSuccessResponse.process);
    }

    public final ConnectSocialAccountProcess getProcess() {
        return this.process;
    }

    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public int hashCode() {
        String str = this.tmxSessionId;
        return this.process.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public String toString() {
        return "ConnectSocialAccountSuccessResponse(tmxSessionId=" + this.tmxSessionId + ", process=" + this.process + ")";
    }
}
