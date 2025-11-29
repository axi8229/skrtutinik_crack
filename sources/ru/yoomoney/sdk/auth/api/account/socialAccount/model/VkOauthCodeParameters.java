package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/VkOauthCodeParameters;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "clientId", "", "state", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getState", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VkOauthCodeParameters extends OauthCodeParameters {
    public static final Parcelable.Creator<VkOauthCodeParameters> CREATOR = new Creator();

    @SerializedName("clientId")
    private final String clientId;

    @SerializedName("state")
    private final String state;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VkOauthCodeParameters> {
        @Override // android.os.Parcelable.Creator
        public final VkOauthCodeParameters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VkOauthCodeParameters(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final VkOauthCodeParameters[] newArray(int i) {
            return new VkOauthCodeParameters[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VkOauthCodeParameters(String clientId, String state) {
        super(OauthServiceProvider.VK, null);
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(state, "state");
        this.clientId = clientId;
        this.state = state;
    }

    public static /* synthetic */ VkOauthCodeParameters copy$default(VkOauthCodeParameters vkOauthCodeParameters, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vkOauthCodeParameters.clientId;
        }
        if ((i & 2) != 0) {
            str2 = vkOauthCodeParameters.state;
        }
        return vkOauthCodeParameters.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getState() {
        return this.state;
    }

    public final VkOauthCodeParameters copy(String clientId, String state) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(state, "state");
        return new VkOauthCodeParameters(clientId, state);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VkOauthCodeParameters)) {
            return false;
        }
        VkOauthCodeParameters vkOauthCodeParameters = (VkOauthCodeParameters) other;
        return Intrinsics.areEqual(this.clientId, vkOauthCodeParameters.clientId) && Intrinsics.areEqual(this.state, vkOauthCodeParameters.state);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode() + (this.clientId.hashCode() * 31);
    }

    public String toString() {
        return "VkOauthCodeParameters(clientId=" + this.clientId + ", state=" + this.state + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clientId);
        parcel.writeString(this.state);
    }
}
