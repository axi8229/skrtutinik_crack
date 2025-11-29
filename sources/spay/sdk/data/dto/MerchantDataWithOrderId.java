package spay.sdk.data.dto;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006'"}, d2 = {"Lspay/sdk/data/dto/MerchantDataWithOrderId;", "Landroid/os/Parcelable;", "authorization", "", "merchantLogin", "orderId", "orderNumber", "appPackage", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppPackage", "()Ljava/lang/String;", "setAppPackage", "(Ljava/lang/String;)V", "getAuthorization", "getLanguage", "getMerchantLogin", "getOrderId", "getOrderNumber", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantDataWithOrderId implements Parcelable {
    public static final Parcelable.Creator<MerchantDataWithOrderId> CREATOR = new Creator();
    private String appPackage;
    private final String authorization;
    private final String language;
    private final String merchantLogin;
    private final String orderId;
    private final String orderNumber;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MerchantDataWithOrderId> {
        @Override // android.os.Parcelable.Creator
        public final MerchantDataWithOrderId createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MerchantDataWithOrderId(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MerchantDataWithOrderId[] newArray(int i) {
            return new MerchantDataWithOrderId[i];
        }
    }

    public MerchantDataWithOrderId(String authorization, String str, String orderId, String orderNumber, String appPackage, String str2) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        this.authorization = authorization;
        this.merchantLogin = str;
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.appPackage = appPackage;
        this.language = str2;
    }

    public static /* synthetic */ MerchantDataWithOrderId copy$default(MerchantDataWithOrderId merchantDataWithOrderId, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantDataWithOrderId.authorization;
        }
        if ((i & 2) != 0) {
            str2 = merchantDataWithOrderId.merchantLogin;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = merchantDataWithOrderId.orderId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = merchantDataWithOrderId.orderNumber;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = merchantDataWithOrderId.appPackage;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = merchantDataWithOrderId.language;
        }
        return merchantDataWithOrderId.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthorization() {
        return this.authorization;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppPackage() {
        return this.appPackage;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    public final MerchantDataWithOrderId copy(String authorization, String merchantLogin, String orderId, String orderNumber, String appPackage, String language) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        return new MerchantDataWithOrderId(authorization, merchantLogin, orderId, orderNumber, appPackage, language);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MerchantDataWithOrderId)) {
            return false;
        }
        MerchantDataWithOrderId merchantDataWithOrderId = (MerchantDataWithOrderId) other;
        return Intrinsics.areEqual(this.authorization, merchantDataWithOrderId.authorization) && Intrinsics.areEqual(this.merchantLogin, merchantDataWithOrderId.merchantLogin) && Intrinsics.areEqual(this.orderId, merchantDataWithOrderId.orderId) && Intrinsics.areEqual(this.orderNumber, merchantDataWithOrderId.orderNumber) && Intrinsics.areEqual(this.appPackage, merchantDataWithOrderId.appPackage) && Intrinsics.areEqual(this.language, merchantDataWithOrderId.language);
    }

    public final String getAppPackage() {
        return this.appPackage;
    }

    public final String getAuthorization() {
        return this.authorization;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getOrderNumber() {
        return this.orderNumber;
    }

    public int hashCode() {
        int iHashCode = this.authorization.hashCode() * 31;
        String str = this.merchantLogin;
        int iA = AbstractC1553e.a(this.appPackage, AbstractC1553e.a(this.orderNumber, AbstractC1553e.a(this.orderId, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31), 31), 31);
        String str2 = this.language;
        return iA + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAppPackage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appPackage = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MerchantDataWithOrderId(authorization=");
        sb.append(this.authorization);
        sb.append(", merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", orderNumber=");
        sb.append(this.orderNumber);
        sb.append(", appPackage=");
        sb.append(this.appPackage);
        sb.append(", language=");
        return Q1.a(sb, this.language, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.authorization);
        parcel.writeString(this.merchantLogin);
        parcel.writeString(this.orderId);
        parcel.writeString(this.orderNumber);
        parcel.writeString(this.appPackage);
        parcel.writeString(this.language);
    }

    public /* synthetic */ MerchantDataWithOrderId(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3, str4, str5, (i & 32) != 0 ? null : str6);
    }
}
