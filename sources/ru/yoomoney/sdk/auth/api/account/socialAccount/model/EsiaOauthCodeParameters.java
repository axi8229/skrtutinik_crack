package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/EsiaOauthCodeParameters;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "clientSecret", "", "clientId", "scope", "timestamp", "state", "redirectUri", "responseType", "accessType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessType", "()Ljava/lang/String;", "getClientId", "getClientSecret", "getRedirectUri", "getResponseType", "getScope", "getState", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EsiaOauthCodeParameters extends OauthCodeParameters {
    public static final Parcelable.Creator<EsiaOauthCodeParameters> CREATOR = new Creator();

    @SerializedName("accessType")
    private final String accessType;

    @SerializedName("clientId")
    private final String clientId;

    @SerializedName("clientSecret")
    private final String clientSecret;

    @SerializedName("redirectUri")
    private final String redirectUri;

    @SerializedName("responseType")
    private final String responseType;

    @SerializedName("scope")
    private final String scope;

    @SerializedName("state")
    private final String state;

    @SerializedName("timestamp")
    private final String timestamp;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EsiaOauthCodeParameters> {
        @Override // android.os.Parcelable.Creator
        public final EsiaOauthCodeParameters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EsiaOauthCodeParameters(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final EsiaOauthCodeParameters[] newArray(int i) {
            return new EsiaOauthCodeParameters[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EsiaOauthCodeParameters(String clientSecret, String clientId, String scope, String timestamp, String state, String redirectUri, String responseType, String accessType) {
        super(OauthServiceProvider.ESIA, null);
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(accessType, "accessType");
        this.clientSecret = clientSecret;
        this.clientId = clientId;
        this.scope = scope;
        this.timestamp = timestamp;
        this.state = state;
        this.redirectUri = redirectUri;
        this.responseType = responseType;
        this.accessType = accessType;
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientSecret() {
        return this.clientSecret;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    /* renamed from: component7, reason: from getter */
    public final String getResponseType() {
        return this.responseType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAccessType() {
        return this.accessType;
    }

    public final EsiaOauthCodeParameters copy(String clientSecret, String clientId, String scope, String timestamp, String state, String redirectUri, String responseType, String accessType) {
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(accessType, "accessType");
        return new EsiaOauthCodeParameters(clientSecret, clientId, scope, timestamp, state, redirectUri, responseType, accessType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EsiaOauthCodeParameters)) {
            return false;
        }
        EsiaOauthCodeParameters esiaOauthCodeParameters = (EsiaOauthCodeParameters) other;
        return Intrinsics.areEqual(this.clientSecret, esiaOauthCodeParameters.clientSecret) && Intrinsics.areEqual(this.clientId, esiaOauthCodeParameters.clientId) && Intrinsics.areEqual(this.scope, esiaOauthCodeParameters.scope) && Intrinsics.areEqual(this.timestamp, esiaOauthCodeParameters.timestamp) && Intrinsics.areEqual(this.state, esiaOauthCodeParameters.state) && Intrinsics.areEqual(this.redirectUri, esiaOauthCodeParameters.redirectUri) && Intrinsics.areEqual(this.responseType, esiaOauthCodeParameters.responseType) && Intrinsics.areEqual(this.accessType, esiaOauthCodeParameters.accessType);
    }

    public final String getAccessType() {
        return this.accessType;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
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

    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.accessType.hashCode() + a.a(this.responseType, a.a(this.redirectUri, a.a(this.state, a.a(this.timestamp, a.a(this.scope, a.a(this.clientId, this.clientSecret.hashCode() * 31, 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "EsiaOauthCodeParameters(clientSecret=" + this.clientSecret + ", clientId=" + this.clientId + ", scope=" + this.scope + ", timestamp=" + this.timestamp + ", state=" + this.state + ", redirectUri=" + this.redirectUri + ", responseType=" + this.responseType + ", accessType=" + this.accessType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.clientId);
        parcel.writeString(this.scope);
        parcel.writeString(this.timestamp);
        parcel.writeString(this.state);
        parcel.writeString(this.redirectUri);
        parcel.writeString(this.responseType);
        parcel.writeString(this.accessType);
    }
}
