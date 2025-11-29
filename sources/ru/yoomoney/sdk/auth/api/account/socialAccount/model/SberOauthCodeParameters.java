package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JG\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/SberOauthCodeParameters;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "responseType", "", "clientType", "clientId", "state", "nonce", "scope", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getClientType", "getNonce", "getResponseType", "getScope", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SberOauthCodeParameters extends OauthCodeParameters {
    public static final Parcelable.Creator<SberOauthCodeParameters> CREATOR = new Creator();

    @SerializedName("clientId")
    private final String clientId;

    @SerializedName("clientType")
    private final String clientType;

    @SerializedName("nonce")
    private final String nonce;

    @SerializedName("responseType")
    private final String responseType;

    @SerializedName("scope")
    private final String scope;

    @SerializedName("state")
    private final String state;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SberOauthCodeParameters> {
        @Override // android.os.Parcelable.Creator
        public final SberOauthCodeParameters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SberOauthCodeParameters(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SberOauthCodeParameters[] newArray(int i) {
            return new SberOauthCodeParameters[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SberOauthCodeParameters(String responseType, String str, String clientId, String state, String nonce, String scope) {
        super(OauthServiceProvider.SBER, null);
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.responseType = responseType;
        this.clientType = str;
        this.clientId = clientId;
        this.state = state;
        this.nonce = nonce;
        this.scope = scope;
    }

    public static /* synthetic */ SberOauthCodeParameters copy$default(SberOauthCodeParameters sberOauthCodeParameters, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sberOauthCodeParameters.responseType;
        }
        if ((i & 2) != 0) {
            str2 = sberOauthCodeParameters.clientType;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = sberOauthCodeParameters.clientId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = sberOauthCodeParameters.state;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = sberOauthCodeParameters.nonce;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = sberOauthCodeParameters.scope;
        }
        return sberOauthCodeParameters.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getResponseType() {
        return this.responseType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientType() {
        return this.clientType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: component6, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    public final SberOauthCodeParameters copy(String responseType, String clientType, String clientId, String state, String nonce, String scope) {
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new SberOauthCodeParameters(responseType, clientType, clientId, state, nonce, scope);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SberOauthCodeParameters)) {
            return false;
        }
        SberOauthCodeParameters sberOauthCodeParameters = (SberOauthCodeParameters) other;
        return Intrinsics.areEqual(this.responseType, sberOauthCodeParameters.responseType) && Intrinsics.areEqual(this.clientType, sberOauthCodeParameters.clientType) && Intrinsics.areEqual(this.clientId, sberOauthCodeParameters.clientId) && Intrinsics.areEqual(this.state, sberOauthCodeParameters.state) && Intrinsics.areEqual(this.nonce, sberOauthCodeParameters.nonce) && Intrinsics.areEqual(this.scope, sberOauthCodeParameters.scope);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientType() {
        return this.clientType;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        int iHashCode = this.responseType.hashCode() * 31;
        String str = this.clientType;
        return this.scope.hashCode() + a.a(this.nonce, a.a(this.state, a.a(this.clientId, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31), 31), 31);
    }

    public String toString() {
        return "SberOauthCodeParameters(responseType=" + this.responseType + ", clientType=" + this.clientType + ", clientId=" + this.clientId + ", state=" + this.state + ", nonce=" + this.nonce + ", scope=" + this.scope + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.responseType);
        parcel.writeString(this.clientType);
        parcel.writeString(this.clientId);
        parcel.writeString(this.state);
        parcel.writeString(this.nonce);
        parcel.writeString(this.scope);
    }
}
