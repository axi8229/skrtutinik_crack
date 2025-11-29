package ru.yoomoney.sdk.kassa.payments.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData;", "Landroid/os/Parcelable;", "()V", "BaseScreenData", "SBPConfirmationData", "SberPayConfirmationData", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData$BaseScreenData;", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData$SBPConfirmationData;", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData$SberPayConfirmationData;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class StartScreenData implements Parcelable {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData$BaseScreenData;", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData;", "paymentMethodType", "", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "paymentMethodId", "", "(Ljava/util/Set;Ljava/lang/String;)V", "getPaymentMethodId", "()Ljava/lang/String;", "getPaymentMethodType", "()Ljava/util/Set;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class BaseScreenData extends StartScreenData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<BaseScreenData> CREATOR = new Creator();
        private final String paymentMethodId;
        private final Set<PaymentMethodType> paymentMethodType;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<BaseScreenData> {
            @Override // android.os.Parcelable.Creator
            public final BaseScreenData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashSet.add(PaymentMethodType.valueOf(parcel.readString()));
                }
                return new BaseScreenData(linkedHashSet, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final BaseScreenData[] newArray(int i) {
                return new BaseScreenData[i];
            }
        }

        public BaseScreenData() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BaseScreenData copy$default(BaseScreenData baseScreenData, Set set, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                set = baseScreenData.paymentMethodType;
            }
            if ((i & 2) != 0) {
                str = baseScreenData.paymentMethodId;
            }
            return baseScreenData.copy(set, str);
        }

        public final Set<PaymentMethodType> component1() {
            return this.paymentMethodType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPaymentMethodId() {
            return this.paymentMethodId;
        }

        public final BaseScreenData copy(Set<? extends PaymentMethodType> paymentMethodType, String paymentMethodId) {
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            return new BaseScreenData(paymentMethodType, paymentMethodId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BaseScreenData)) {
                return false;
            }
            BaseScreenData baseScreenData = (BaseScreenData) other;
            return Intrinsics.areEqual(this.paymentMethodType, baseScreenData.paymentMethodType) && Intrinsics.areEqual(this.paymentMethodId, baseScreenData.paymentMethodId);
        }

        public final String getPaymentMethodId() {
            return this.paymentMethodId;
        }

        public final Set<PaymentMethodType> getPaymentMethodType() {
            return this.paymentMethodType;
        }

        public int hashCode() {
            int iHashCode = this.paymentMethodType.hashCode() * 31;
            String str = this.paymentMethodId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "BaseScreenData(paymentMethodType=" + this.paymentMethodType + ", paymentMethodId=" + this.paymentMethodId + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Set<PaymentMethodType> set = this.paymentMethodType;
            parcel.writeInt(set.size());
            Iterator<PaymentMethodType> it = set.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next().name());
            }
            parcel.writeString(this.paymentMethodId);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BaseScreenData(Set<? extends PaymentMethodType> paymentMethodType, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            this.paymentMethodType = paymentMethodType;
            this.paymentMethodId = str;
        }

        public /* synthetic */ BaseScreenData(Set set, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData$SBPConfirmationData;", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData;", "confirmationData", "", "(Ljava/lang/String;)V", "getConfirmationData", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SBPConfirmationData extends StartScreenData {
        public static final int $stable = 0;
        public static final Parcelable.Creator<SBPConfirmationData> CREATOR = new Creator();
        private final String confirmationData;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SBPConfirmationData> {
            @Override // android.os.Parcelable.Creator
            public final SBPConfirmationData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SBPConfirmationData(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SBPConfirmationData[] newArray(int i) {
                return new SBPConfirmationData[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SBPConfirmationData(String confirmationData) {
            super(null);
            Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
            this.confirmationData = confirmationData;
        }

        public static /* synthetic */ SBPConfirmationData copy$default(SBPConfirmationData sBPConfirmationData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sBPConfirmationData.confirmationData;
            }
            return sBPConfirmationData.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConfirmationData() {
            return this.confirmationData;
        }

        public final SBPConfirmationData copy(String confirmationData) {
            Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
            return new SBPConfirmationData(confirmationData);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SBPConfirmationData) && Intrinsics.areEqual(this.confirmationData, ((SBPConfirmationData) other).confirmationData);
        }

        public final String getConfirmationData() {
            return this.confirmationData;
        }

        public int hashCode() {
            return this.confirmationData.hashCode();
        }

        public String toString() {
            return "SBPConfirmationData(confirmationData=" + this.confirmationData + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.confirmationData);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData$SberPayConfirmationData;", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData;", "confirmationData", "", "shopId", "(Ljava/lang/String;Ljava/lang/String;)V", "getConfirmationData", "()Ljava/lang/String;", "getShopId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SberPayConfirmationData extends StartScreenData {
        public static final int $stable = 0;
        public static final Parcelable.Creator<SberPayConfirmationData> CREATOR = new Creator();
        private final String confirmationData;
        private final String shopId;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SberPayConfirmationData> {
            @Override // android.os.Parcelable.Creator
            public final SberPayConfirmationData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SberPayConfirmationData(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SberPayConfirmationData[] newArray(int i) {
                return new SberPayConfirmationData[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SberPayConfirmationData(String confirmationData, String shopId) {
            super(null);
            Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
            Intrinsics.checkNotNullParameter(shopId, "shopId");
            this.confirmationData = confirmationData;
            this.shopId = shopId;
        }

        public static /* synthetic */ SberPayConfirmationData copy$default(SberPayConfirmationData sberPayConfirmationData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sberPayConfirmationData.confirmationData;
            }
            if ((i & 2) != 0) {
                str2 = sberPayConfirmationData.shopId;
            }
            return sberPayConfirmationData.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConfirmationData() {
            return this.confirmationData;
        }

        /* renamed from: component2, reason: from getter */
        public final String getShopId() {
            return this.shopId;
        }

        public final SberPayConfirmationData copy(String confirmationData, String shopId) {
            Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
            Intrinsics.checkNotNullParameter(shopId, "shopId");
            return new SberPayConfirmationData(confirmationData, shopId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SberPayConfirmationData)) {
                return false;
            }
            SberPayConfirmationData sberPayConfirmationData = (SberPayConfirmationData) other;
            return Intrinsics.areEqual(this.confirmationData, sberPayConfirmationData.confirmationData) && Intrinsics.areEqual(this.shopId, sberPayConfirmationData.shopId);
        }

        public final String getConfirmationData() {
            return this.confirmationData;
        }

        public final String getShopId() {
            return this.shopId;
        }

        public int hashCode() {
            return this.shopId.hashCode() + (this.confirmationData.hashCode() * 31);
        }

        public String toString() {
            return "SberPayConfirmationData(confirmationData=" + this.confirmationData + ", shopId=" + this.shopId + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.confirmationData);
            parcel.writeString(this.shopId);
        }
    }

    private StartScreenData() {
    }

    public /* synthetic */ StartScreenData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
