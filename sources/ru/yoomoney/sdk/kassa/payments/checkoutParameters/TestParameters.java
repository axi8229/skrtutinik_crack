package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/TestParameters;", "Landroid/os/Parcelable;", "showLogs", "", "googlePayTestEnvironment", "mockConfiguration", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/MockConfiguration;", "hostParameters", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/HostParameters;", "yandexClientId", "", "(ZZLru/yoomoney/sdk/kassa/payments/checkoutParameters/MockConfiguration;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/HostParameters;Ljava/lang/String;)V", "getGooglePayTestEnvironment", "()Z", "getHostParameters", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/HostParameters;", "getMockConfiguration", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/MockConfiguration;", "getShowLogs", "getYandexClientId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class TestParameters implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<TestParameters> CREATOR = new g();

    @Keep
    private final boolean googlePayTestEnvironment;

    @Keep
    private final HostParameters hostParameters;

    @Keep
    private final MockConfiguration mockConfiguration;

    @Keep
    private final boolean showLogs;

    @Keep
    private final String yandexClientId;

    @Keep
    public TestParameters() {
        this(false, false, null, null, null, 31, null);
    }

    public static /* synthetic */ TestParameters copy$default(TestParameters testParameters, boolean z, boolean z2, MockConfiguration mockConfiguration, HostParameters hostParameters, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = testParameters.showLogs;
        }
        if ((i & 2) != 0) {
            z2 = testParameters.googlePayTestEnvironment;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            mockConfiguration = testParameters.mockConfiguration;
        }
        MockConfiguration mockConfiguration2 = mockConfiguration;
        if ((i & 8) != 0) {
            hostParameters = testParameters.hostParameters;
        }
        HostParameters hostParameters2 = hostParameters;
        if ((i & 16) != 0) {
            str = testParameters.yandexClientId;
        }
        return testParameters.copy(z, z3, mockConfiguration2, hostParameters2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShowLogs() {
        return this.showLogs;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getGooglePayTestEnvironment() {
        return this.googlePayTestEnvironment;
    }

    /* renamed from: component3, reason: from getter */
    public final MockConfiguration getMockConfiguration() {
        return this.mockConfiguration;
    }

    /* renamed from: component4, reason: from getter */
    public final HostParameters getHostParameters() {
        return this.hostParameters;
    }

    /* renamed from: component5, reason: from getter */
    public final String getYandexClientId() {
        return this.yandexClientId;
    }

    public final TestParameters copy(boolean showLogs, boolean googlePayTestEnvironment, MockConfiguration mockConfiguration, HostParameters hostParameters, String yandexClientId) {
        Intrinsics.checkNotNullParameter(hostParameters, "hostParameters");
        Intrinsics.checkNotNullParameter(yandexClientId, "yandexClientId");
        return new TestParameters(showLogs, googlePayTestEnvironment, mockConfiguration, hostParameters, yandexClientId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestParameters)) {
            return false;
        }
        TestParameters testParameters = (TestParameters) other;
        return this.showLogs == testParameters.showLogs && this.googlePayTestEnvironment == testParameters.googlePayTestEnvironment && Intrinsics.areEqual(this.mockConfiguration, testParameters.mockConfiguration) && Intrinsics.areEqual(this.hostParameters, testParameters.hostParameters) && Intrinsics.areEqual(this.yandexClientId, testParameters.yandexClientId);
    }

    public final boolean getGooglePayTestEnvironment() {
        return this.googlePayTestEnvironment;
    }

    public final HostParameters getHostParameters() {
        return this.hostParameters;
    }

    public final MockConfiguration getMockConfiguration() {
        return this.mockConfiguration;
    }

    public final boolean getShowLogs() {
        return this.showLogs;
    }

    public final String getYandexClientId() {
        return this.yandexClientId;
    }

    public int hashCode() {
        int iA = ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.googlePayTestEnvironment, Boolean.hashCode(this.showLogs) * 31, 31);
        MockConfiguration mockConfiguration = this.mockConfiguration;
        return this.yandexClientId.hashCode() + ((this.hostParameters.hashCode() + ((iA + (mockConfiguration == null ? 0 : mockConfiguration.hashCode())) * 31)) * 31);
    }

    public String toString() {
        return "TestParameters(showLogs=" + this.showLogs + ", googlePayTestEnvironment=" + this.googlePayTestEnvironment + ", mockConfiguration=" + this.mockConfiguration + ", hostParameters=" + this.hostParameters + ", yandexClientId=" + this.yandexClientId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.showLogs ? 1 : 0);
        parcel.writeInt(this.googlePayTestEnvironment ? 1 : 0);
        MockConfiguration mockConfiguration = this.mockConfiguration;
        if (mockConfiguration == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            mockConfiguration.writeToParcel(parcel, flags);
        }
        this.hostParameters.writeToParcel(parcel, flags);
        parcel.writeString(this.yandexClientId);
    }

    @Keep
    public TestParameters(boolean z) {
        this(z, false, null, null, null, 30, null);
    }

    @Keep
    public TestParameters(boolean z, boolean z2) {
        this(z, z2, null, null, null, 28, null);
    }

    @Keep
    public TestParameters(boolean z, boolean z2, MockConfiguration mockConfiguration) {
        this(z, z2, mockConfiguration, null, null, 24, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public TestParameters(boolean z, boolean z2, MockConfiguration mockConfiguration, HostParameters hostParameters) {
        this(z, z2, mockConfiguration, hostParameters, null, 16, null);
        Intrinsics.checkNotNullParameter(hostParameters, "hostParameters");
    }

    @Keep
    public TestParameters(boolean z, boolean z2, MockConfiguration mockConfiguration, HostParameters hostParameters, String yandexClientId) {
        Intrinsics.checkNotNullParameter(hostParameters, "hostParameters");
        Intrinsics.checkNotNullParameter(yandexClientId, "yandexClientId");
        this.showLogs = z;
        this.googlePayTestEnvironment = z2;
        this.mockConfiguration = mockConfiguration;
        this.hostParameters = hostParameters;
        this.yandexClientId = yandexClientId;
    }

    public /* synthetic */ TestParameters(boolean z, boolean z2, MockConfiguration mockConfiguration, HostParameters hostParameters, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? null : mockConfiguration, (i & 8) != 0 ? new HostParameters(null, null, null, null, 15, null) : hostParameters, (i & 16) != 0 ? "80642c11721c49d69d9936de0c265886" : str);
    }
}
