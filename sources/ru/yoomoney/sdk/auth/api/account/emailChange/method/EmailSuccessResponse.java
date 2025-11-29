package ru.yoomoney.sdk.auth.api.account.emailChange.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailProcess;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailSuccessResponse;", "", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "process", "Lru/yoomoney/sdk/auth/api/account/model/ChangeEmailProcess;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/model/ChangeEmailProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/account/model/ChangeEmailProcess;", "getTmxSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EmailSuccessResponse {

    @SerializedName("process")
    private final ChangeEmailProcess process;

    @SerializedName(YooMoneyAuth.KEY_TMX_SESSION_ID)
    private final String tmxSessionId;

    public EmailSuccessResponse(String str, ChangeEmailProcess process) {
        Intrinsics.checkNotNullParameter(process, "process");
        this.tmxSessionId = str;
        this.process = process;
    }

    public static /* synthetic */ EmailSuccessResponse copy$default(EmailSuccessResponse emailSuccessResponse, String str, ChangeEmailProcess changeEmailProcess, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emailSuccessResponse.tmxSessionId;
        }
        if ((i & 2) != 0) {
            changeEmailProcess = emailSuccessResponse.process;
        }
        return emailSuccessResponse.copy(str, changeEmailProcess);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final ChangeEmailProcess getProcess() {
        return this.process;
    }

    public final EmailSuccessResponse copy(String tmxSessionId, ChangeEmailProcess process) {
        Intrinsics.checkNotNullParameter(process, "process");
        return new EmailSuccessResponse(tmxSessionId, process);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailSuccessResponse)) {
            return false;
        }
        EmailSuccessResponse emailSuccessResponse = (EmailSuccessResponse) other;
        return Intrinsics.areEqual(this.tmxSessionId, emailSuccessResponse.tmxSessionId) && Intrinsics.areEqual(this.process, emailSuccessResponse.process);
    }

    public final ChangeEmailProcess getProcess() {
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
        return "EmailSuccessResponse(tmxSessionId=" + this.tmxSessionId + ", process=" + this.process + ")";
    }
}
