package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/HostParameters;", "Landroid/os/Parcelable;", "host", "", "paymentAuthorizationHost", "authHost", "configHost", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthHost", "()Ljava/lang/String;", "getConfigHost", "getHost", "isDevHost", "", "()Z", "getPaymentAuthorizationHost", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class HostParameters implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<HostParameters> CREATOR = new c();

    @Keep
    private final String authHost;

    @Keep
    private final String configHost;

    @Keep
    private final String host;
    private final boolean isDevHost;

    @Keep
    private final String paymentAuthorizationHost;

    @Keep
    public HostParameters() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ HostParameters copy$default(HostParameters hostParameters, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostParameters.host;
        }
        if ((i & 2) != 0) {
            str2 = hostParameters.paymentAuthorizationHost;
        }
        if ((i & 4) != 0) {
            str3 = hostParameters.authHost;
        }
        if ((i & 8) != 0) {
            str4 = hostParameters.configHost;
        }
        return hostParameters.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPaymentAuthorizationHost() {
        return this.paymentAuthorizationHost;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthHost() {
        return this.authHost;
    }

    /* renamed from: component4, reason: from getter */
    public final String getConfigHost() {
        return this.configHost;
    }

    public final HostParameters copy(String host, String paymentAuthorizationHost, String authHost, String configHost) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(paymentAuthorizationHost, "paymentAuthorizationHost");
        Intrinsics.checkNotNullParameter(configHost, "configHost");
        return new HostParameters(host, paymentAuthorizationHost, authHost, configHost);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostParameters)) {
            return false;
        }
        HostParameters hostParameters = (HostParameters) other;
        return Intrinsics.areEqual(this.host, hostParameters.host) && Intrinsics.areEqual(this.paymentAuthorizationHost, hostParameters.paymentAuthorizationHost) && Intrinsics.areEqual(this.authHost, hostParameters.authHost) && Intrinsics.areEqual(this.configHost, hostParameters.configHost);
    }

    public final String getAuthHost() {
        return this.authHost;
    }

    public final String getConfigHost() {
        return this.configHost;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getPaymentAuthorizationHost() {
        return this.paymentAuthorizationHost;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.paymentAuthorizationHost, this.host.hashCode() * 31, 31);
        String str = this.authHost;
        return this.configHost.hashCode() + ((iA + (str == null ? 0 : str.hashCode())) * 31);
    }

    /* renamed from: isDevHost, reason: from getter */
    public final boolean getIsDevHost() {
        return this.isDevHost;
    }

    public String toString() {
        return "HostParameters(host=" + this.host + ", paymentAuthorizationHost=" + this.paymentAuthorizationHost + ", authHost=" + this.authHost + ", configHost=" + this.configHost + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.host);
        parcel.writeString(this.paymentAuthorizationHost);
        parcel.writeString(this.authHost);
        parcel.writeString(this.configHost);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public HostParameters(String host) {
        this(host, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public HostParameters(String host, String paymentAuthorizationHost) {
        this(host, paymentAuthorizationHost, null, null, 12, null);
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(paymentAuthorizationHost, "paymentAuthorizationHost");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public HostParameters(String host, String paymentAuthorizationHost, String str) {
        this(host, paymentAuthorizationHost, str, null, 8, null);
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(paymentAuthorizationHost, "paymentAuthorizationHost");
    }

    @Keep
    public HostParameters(String host, String paymentAuthorizationHost, String str, String configHost) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(paymentAuthorizationHost, "paymentAuthorizationHost");
        Intrinsics.checkNotNullParameter(configHost, "configHost");
        this.host = host;
        this.paymentAuthorizationHost = paymentAuthorizationHost;
        this.authHost = str;
        this.configHost = configHost;
        this.isDevHost = !Intrinsics.areEqual(host, "https://sdk.yookassa.ru/api/frontend/v3");
    }

    public /* synthetic */ HostParameters(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "https://sdk.yookassa.ru/api/frontend/v3" : str, (i & 2) != 0 ? "https://yoomoney.ru/api/wallet-auth/v1" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "https://yookassa.ru/api/merchant-profile/v1" : str4);
    }
}
