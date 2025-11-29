package sberid.sdk.auth.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SberIDResultModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u001bR$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u001bR$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u001bR$\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u001bR$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u001b¨\u0006$"}, d2 = {"Lsberid/sdk/auth/model/SberIDResultModel;", "", "", "isSuccess", "", "state", "nonce", "authCode", "errorDescription", "errorCode", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getState", "setState", "(Ljava/lang/String;)V", "getNonce", "setNonce", "getAuthCode", "setAuthCode", "getErrorDescription", "setErrorDescription", "getErrorCode", "setErrorCode", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final /* data */ class SberIDResultModel {
    private String authCode;
    private String errorCode;
    private String errorDescription;
    private Boolean isSuccess;
    private String nonce;
    private String state;

    public SberIDResultModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SberIDResultModel)) {
            return false;
        }
        SberIDResultModel sberIDResultModel = (SberIDResultModel) other;
        return Intrinsics.areEqual(this.isSuccess, sberIDResultModel.isSuccess) && Intrinsics.areEqual(this.state, sberIDResultModel.state) && Intrinsics.areEqual(this.nonce, sberIDResultModel.nonce) && Intrinsics.areEqual(this.authCode, sberIDResultModel.authCode) && Intrinsics.areEqual(this.errorDescription, sberIDResultModel.errorDescription) && Intrinsics.areEqual(this.errorCode, sberIDResultModel.errorCode);
    }

    public int hashCode() {
        Boolean bool = this.isSuccess;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.state;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.nonce;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.authCode;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.errorDescription;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.errorCode;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "SberIDResultModel(isSuccess=" + this.isSuccess + ", state=" + this.state + ", nonce=" + this.nonce + ", authCode=" + this.authCode + ", errorDescription=" + this.errorDescription + ", errorCode=" + this.errorCode + ")";
    }

    public SberIDResultModel(Boolean bool, String str, String str2, String str3, String str4, String str5) {
        this.isSuccess = bool;
        this.state = str;
        this.nonce = str2;
        this.authCode = str3;
        this.errorDescription = str4;
        this.errorCode = str5;
    }

    /* renamed from: isSuccess, reason: from getter */
    public final Boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final void setNonce(String str) {
        this.nonce = str;
    }

    public final String getAuthCode() {
        return this.authCode;
    }

    public final void setAuthCode(String str) {
        this.authCode = str;
    }

    public final void setErrorDescription(String str) {
        this.errorDescription = str;
    }

    public /* synthetic */ SberIDResultModel(Boolean bool, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }
}
