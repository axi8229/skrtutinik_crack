package ru.yoomoney.sdk.auth.api.signIn.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/signIn/model/SigninQrCheckResponse;", "", "geolocation", "", "ipAddress", "application", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplication", "()Ljava/lang/String;", "getGeolocation", "getIpAddress", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SigninQrCheckResponse {

    @SerializedName("application")
    private final String application;

    @SerializedName("geolocation")
    private final String geolocation;

    @SerializedName("ipAddress")
    private final String ipAddress;

    public SigninQrCheckResponse(String str, String ipAddress, String str2) {
        Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
        this.geolocation = str;
        this.ipAddress = ipAddress;
        this.application = str2;
    }

    public static /* synthetic */ SigninQrCheckResponse copy$default(SigninQrCheckResponse signinQrCheckResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signinQrCheckResponse.geolocation;
        }
        if ((i & 2) != 0) {
            str2 = signinQrCheckResponse.ipAddress;
        }
        if ((i & 4) != 0) {
            str3 = signinQrCheckResponse.application;
        }
        return signinQrCheckResponse.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGeolocation() {
        return this.geolocation;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIpAddress() {
        return this.ipAddress;
    }

    /* renamed from: component3, reason: from getter */
    public final String getApplication() {
        return this.application;
    }

    public final SigninQrCheckResponse copy(String geolocation, String ipAddress, String application) {
        Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
        return new SigninQrCheckResponse(geolocation, ipAddress, application);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SigninQrCheckResponse)) {
            return false;
        }
        SigninQrCheckResponse signinQrCheckResponse = (SigninQrCheckResponse) other;
        return Intrinsics.areEqual(this.geolocation, signinQrCheckResponse.geolocation) && Intrinsics.areEqual(this.ipAddress, signinQrCheckResponse.ipAddress) && Intrinsics.areEqual(this.application, signinQrCheckResponse.application);
    }

    public final String getApplication() {
        return this.application;
    }

    public final String getGeolocation() {
        return this.geolocation;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public int hashCode() {
        String str = this.geolocation;
        int iA = a.a(this.ipAddress, (str == null ? 0 : str.hashCode()) * 31, 31);
        String str2 = this.application;
        return iA + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SigninQrCheckResponse(geolocation=" + this.geolocation + ", ipAddress=" + this.ipAddress + ", application=" + this.application + ")";
    }

    public /* synthetic */ SigninQrCheckResponse(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2, (i & 4) != 0 ? null : str3);
    }
}
