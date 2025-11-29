package ru.yoomoney.sdk.auth.api.registrationV2.api.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationInitResponse;", "", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;Ljava/lang/String;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "getTmxSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationInitResponse {
    private final RegistrationProcessBase process;
    private final String tmxSessionId;

    public RegistrationInitResponse(@JsonProperty("process") RegistrationProcessBase process, @JsonProperty(YooMoneyAuth.KEY_TMX_SESSION_ID) String str) {
        Intrinsics.checkNotNullParameter(process, "process");
        this.process = process;
        this.tmxSessionId = str;
    }

    public static /* synthetic */ RegistrationInitResponse copy$default(RegistrationInitResponse registrationInitResponse, RegistrationProcessBase registrationProcessBase, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            registrationProcessBase = registrationInitResponse.process;
        }
        if ((i & 2) != 0) {
            str = registrationInitResponse.tmxSessionId;
        }
        return registrationInitResponse.copy(registrationProcessBase, str);
    }

    /* renamed from: component1, reason: from getter */
    public final RegistrationProcessBase getProcess() {
        return this.process;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public final RegistrationInitResponse copy(@JsonProperty("process") RegistrationProcessBase process, @JsonProperty(YooMoneyAuth.KEY_TMX_SESSION_ID) String tmxSessionId) {
        Intrinsics.checkNotNullParameter(process, "process");
        return new RegistrationInitResponse(process, tmxSessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationInitResponse)) {
            return false;
        }
        RegistrationInitResponse registrationInitResponse = (RegistrationInitResponse) other;
        return Intrinsics.areEqual(this.process, registrationInitResponse.process) && Intrinsics.areEqual(this.tmxSessionId, registrationInitResponse.tmxSessionId);
    }

    public final RegistrationProcessBase getProcess() {
        return this.process;
    }

    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public int hashCode() {
        int iHashCode = this.process.hashCode() * 31;
        String str = this.tmxSessionId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RegistrationInitResponse(process=" + this.process + ", tmxSessionId=" + this.tmxSessionId + ")";
    }

    public /* synthetic */ RegistrationInitResponse(RegistrationProcessBase registrationProcessBase, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(registrationProcessBase, (i & 2) != 0 ? null : str);
    }
}
