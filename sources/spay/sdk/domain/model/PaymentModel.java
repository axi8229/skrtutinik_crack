package spay.sdk.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lspay/sdk/domain/model/PaymentModel;", "Landroid/os/Parcelable;", "authorization", "", "orderId", "paymentToken", "merchantLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorization", "()Ljava/lang/String;", "getMerchantLogin", "getOrderId", "getPaymentToken", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentModel implements Parcelable {
    public static final Parcelable.Creator<PaymentModel> CREATOR = new Creator();
    private final String authorization;
    private final String merchantLogin;
    private final String orderId;
    private final String paymentToken;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PaymentModel> {
        @Override // android.os.Parcelable.Creator
        public final PaymentModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PaymentModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PaymentModel[] newArray(int i) {
            return new PaymentModel[i];
        }
    }

    public PaymentModel(String authorization, String orderId, String paymentToken, String str) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        this.authorization = authorization;
        this.orderId = orderId;
        this.paymentToken = paymentToken;
        this.merchantLogin = str;
    }

    public static /* synthetic */ PaymentModel copy$default(PaymentModel paymentModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentModel.authorization;
        }
        if ((i & 2) != 0) {
            str2 = paymentModel.orderId;
        }
        if ((i & 4) != 0) {
            str3 = paymentModel.paymentToken;
        }
        if ((i & 8) != 0) {
            str4 = paymentModel.merchantLogin;
        }
        return paymentModel.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthorization() {
        return this.authorization;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPaymentToken() {
        return this.paymentToken;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final PaymentModel copy(String authorization, String orderId, String paymentToken, String merchantLogin) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        return new PaymentModel(authorization, orderId, paymentToken, merchantLogin);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentModel)) {
            return false;
        }
        PaymentModel paymentModel = (PaymentModel) other;
        return Intrinsics.areEqual(this.authorization, paymentModel.authorization) && Intrinsics.areEqual(this.orderId, paymentModel.orderId) && Intrinsics.areEqual(this.paymentToken, paymentModel.paymentToken) && Intrinsics.areEqual(this.merchantLogin, paymentModel.merchantLogin);
    }

    public final String getAuthorization() {
        return this.authorization;
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPaymentToken() {
        return this.paymentToken;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.paymentToken, AbstractC1553e.a(this.orderId, this.authorization.hashCode() * 31, 31), 31);
        String str = this.merchantLogin;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PaymentModel(authorization=");
        sb.append(this.authorization);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", paymentToken=");
        sb.append(this.paymentToken);
        sb.append(", merchantLogin=");
        return Q1.a(sb, this.merchantLogin, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.authorization);
        parcel.writeString(this.orderId);
        parcel.writeString(this.paymentToken);
        parcel.writeString(this.merchantLogin);
    }

    public /* synthetic */ PaymentModel(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4);
    }
}
