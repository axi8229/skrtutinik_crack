package ru.yoomoney.sdk.auth.api.account.phoneChange.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.model.ChangePhoneProcess;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneSuccessResponse;", "", "process", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneProcess;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "(Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneProcess;Ljava/lang/String;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneProcess;", "getTmxSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhoneSuccessResponse {

    @SerializedName("process")
    private final ChangePhoneProcess process;

    @SerializedName(YooMoneyAuth.KEY_TMX_SESSION_ID)
    private final String tmxSessionId;

    public PhoneSuccessResponse(ChangePhoneProcess process, String tmxSessionId) {
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        this.process = process;
        this.tmxSessionId = tmxSessionId;
    }

    public static /* synthetic */ PhoneSuccessResponse copy$default(PhoneSuccessResponse phoneSuccessResponse, ChangePhoneProcess changePhoneProcess, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            changePhoneProcess = phoneSuccessResponse.process;
        }
        if ((i & 2) != 0) {
            str = phoneSuccessResponse.tmxSessionId;
        }
        return phoneSuccessResponse.copy(changePhoneProcess, str);
    }

    /* renamed from: component1, reason: from getter */
    public final ChangePhoneProcess getProcess() {
        return this.process;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public final PhoneSuccessResponse copy(ChangePhoneProcess process, String tmxSessionId) {
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        return new PhoneSuccessResponse(process, tmxSessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneSuccessResponse)) {
            return false;
        }
        PhoneSuccessResponse phoneSuccessResponse = (PhoneSuccessResponse) other;
        return Intrinsics.areEqual(this.process, phoneSuccessResponse.process) && Intrinsics.areEqual(this.tmxSessionId, phoneSuccessResponse.tmxSessionId);
    }

    public final ChangePhoneProcess getProcess() {
        return this.process;
    }

    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public int hashCode() {
        return this.tmxSessionId.hashCode() + (this.process.hashCode() * 31);
    }

    public String toString() {
        return "PhoneSuccessResponse(process=" + this.process + ", tmxSessionId=" + this.tmxSessionId + ")";
    }
}
