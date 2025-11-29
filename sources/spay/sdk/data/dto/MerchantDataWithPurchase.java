package spay.sdk.data.dto;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001$B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lspay/sdk/data/dto/MerchantDataWithPurchase;", "Landroid/os/Parcelable;", "authorization", "", "merchantLogin", "purchase", "Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "appPackage", "(Ljava/lang/String;Ljava/lang/String;Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;Ljava/lang/String;Ljava/lang/String;)V", "getAppPackage", "()Ljava/lang/String;", "getAuthorization", "getLanguage", "getMerchantLogin", "getPurchase", "()Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Purchase", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantDataWithPurchase implements Parcelable {
    public static final Parcelable.Creator<MerchantDataWithPurchase> CREATOR = new Creator();
    private final String appPackage;
    private final String authorization;
    private final String language;
    private final String merchantLogin;
    private final Purchase purchase;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MerchantDataWithPurchase> {
        @Override // android.os.Parcelable.Creator
        public final MerchantDataWithPurchase createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MerchantDataWithPurchase(parcel.readString(), parcel.readString(), Purchase.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MerchantDataWithPurchase[] newArray(int i) {
            return new MerchantDataWithPurchase[i];
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001(BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "Landroid/os/Parcelable;", "amount", "", "currency", "", "mobilePhone", "orderNumber", "orderDescription", "recurrent", "Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase$Recurrent;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase$Recurrent;)V", "getAmount", "()I", "getCurrency", "()Ljava/lang/String;", "getMobilePhone", "getOrderDescription", "getOrderNumber", "getRecurrent", "()Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase$Recurrent;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Recurrent", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Purchase implements Parcelable {
        public static final Parcelable.Creator<Purchase> CREATOR = new Creator();
        private final int amount;
        private final String currency;
        private final String mobilePhone;
        private final String orderDescription;
        private final String orderNumber;
        private final Recurrent recurrent;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Purchase> {
            @Override // android.os.Parcelable.Creator
            public final Purchase createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Purchase(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Recurrent.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final Purchase[] newArray(int i) {
                return new Purchase[i];
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase$Recurrent;", "Landroid/os/Parcelable;", "enabled", "", "expiry", "", "frequency", "", "(ZLjava/lang/String;Ljava/lang/Integer;)V", "getEnabled", "()Z", "getExpiry", "()Ljava/lang/String;", "getFrequency", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;)Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase$Recurrent;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Recurrent implements Parcelable {
            public static final Parcelable.Creator<Recurrent> CREATOR = new Creator();
            private final boolean enabled;
            private final String expiry;
            private final Integer frequency;

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Recurrent> {
                @Override // android.os.Parcelable.Creator
                public final Recurrent createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Recurrent(parcel.readInt() != 0, parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final Recurrent[] newArray(int i) {
                    return new Recurrent[i];
                }
            }

            public Recurrent(boolean z, String str, Integer num) {
                this.enabled = z;
                this.expiry = str;
                this.frequency = num;
            }

            public static /* synthetic */ Recurrent copy$default(Recurrent recurrent, boolean z, String str, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = recurrent.enabled;
                }
                if ((i & 2) != 0) {
                    str = recurrent.expiry;
                }
                if ((i & 4) != 0) {
                    num = recurrent.frequency;
                }
                return recurrent.copy(z, str, num);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            /* renamed from: component2, reason: from getter */
            public final String getExpiry() {
                return this.expiry;
            }

            /* renamed from: component3, reason: from getter */
            public final Integer getFrequency() {
                return this.frequency;
            }

            public final Recurrent copy(boolean enabled, String expiry, Integer frequency) {
                return new Recurrent(enabled, expiry, frequency);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Recurrent)) {
                    return false;
                }
                Recurrent recurrent = (Recurrent) other;
                return this.enabled == recurrent.enabled && Intrinsics.areEqual(this.expiry, recurrent.expiry) && Intrinsics.areEqual(this.frequency, recurrent.frequency);
            }

            public final boolean getEnabled() {
                return this.enabled;
            }

            public final String getExpiry() {
                return this.expiry;
            }

            public final Integer getFrequency() {
                return this.frequency;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r0v7 */
            public int hashCode() {
                boolean z = this.enabled;
                ?? r0 = z;
                if (z) {
                    r0 = 1;
                }
                int i = r0 * 31;
                String str = this.expiry;
                int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
                Integer num = this.frequency;
                return iHashCode + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                return "Recurrent(enabled=" + this.enabled + ", expiry=" + this.expiry + ", frequency=" + this.frequency + ')';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.enabled ? 1 : 0);
                parcel.writeString(this.expiry);
                Integer num = this.frequency;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            public /* synthetic */ Recurrent(boolean z, String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num);
            }
        }

        public Purchase(int i, String currency, String str, String orderNumber, String str2, Recurrent recurrent) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
            this.amount = i;
            this.currency = currency;
            this.mobilePhone = str;
            this.orderNumber = orderNumber;
            this.orderDescription = str2;
            this.recurrent = recurrent;
        }

        public static /* synthetic */ Purchase copy$default(Purchase purchase, int i, String str, String str2, String str3, String str4, Recurrent recurrent, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = purchase.amount;
            }
            if ((i2 & 2) != 0) {
                str = purchase.currency;
            }
            String str5 = str;
            if ((i2 & 4) != 0) {
                str2 = purchase.mobilePhone;
            }
            String str6 = str2;
            if ((i2 & 8) != 0) {
                str3 = purchase.orderNumber;
            }
            String str7 = str3;
            if ((i2 & 16) != 0) {
                str4 = purchase.orderDescription;
            }
            String str8 = str4;
            if ((i2 & 32) != 0) {
                recurrent = purchase.recurrent;
            }
            return purchase.copy(i, str5, str6, str7, str8, recurrent);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMobilePhone() {
            return this.mobilePhone;
        }

        /* renamed from: component4, reason: from getter */
        public final String getOrderNumber() {
            return this.orderNumber;
        }

        /* renamed from: component5, reason: from getter */
        public final String getOrderDescription() {
            return this.orderDescription;
        }

        /* renamed from: component6, reason: from getter */
        public final Recurrent getRecurrent() {
            return this.recurrent;
        }

        public final Purchase copy(int amount, String currency, String mobilePhone, String orderNumber, String orderDescription, Recurrent recurrent) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
            return new Purchase(amount, currency, mobilePhone, orderNumber, orderDescription, recurrent);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Purchase)) {
                return false;
            }
            Purchase purchase = (Purchase) other;
            return this.amount == purchase.amount && Intrinsics.areEqual(this.currency, purchase.currency) && Intrinsics.areEqual(this.mobilePhone, purchase.mobilePhone) && Intrinsics.areEqual(this.orderNumber, purchase.orderNumber) && Intrinsics.areEqual(this.orderDescription, purchase.orderDescription) && Intrinsics.areEqual(this.recurrent, purchase.recurrent);
        }

        public final int getAmount() {
            return this.amount;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getMobilePhone() {
            return this.mobilePhone;
        }

        public final String getOrderDescription() {
            return this.orderDescription;
        }

        public final String getOrderNumber() {
            return this.orderNumber;
        }

        public final Recurrent getRecurrent() {
            return this.recurrent;
        }

        public int hashCode() {
            int iA = AbstractC1553e.a(this.currency, Integer.hashCode(this.amount) * 31, 31);
            String str = this.mobilePhone;
            int iA2 = AbstractC1553e.a(this.orderNumber, (iA + (str == null ? 0 : str.hashCode())) * 31, 31);
            String str2 = this.orderDescription;
            int iHashCode = (iA2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Recurrent recurrent = this.recurrent;
            return iHashCode + (recurrent != null ? recurrent.hashCode() : 0);
        }

        public String toString() {
            return "Purchase(amount=" + this.amount + ", currency=" + this.currency + ", mobilePhone=" + this.mobilePhone + ", orderNumber=" + this.orderNumber + ", orderDescription=" + this.orderDescription + ", recurrent=" + this.recurrent + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.amount);
            parcel.writeString(this.currency);
            parcel.writeString(this.mobilePhone);
            parcel.writeString(this.orderNumber);
            parcel.writeString(this.orderDescription);
            Recurrent recurrent = this.recurrent;
            if (recurrent == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                recurrent.writeToParcel(parcel, flags);
            }
        }

        public /* synthetic */ Purchase(int i, String str, String str2, String str3, String str4, Recurrent recurrent, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? null : str2, str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : recurrent);
        }
    }

    public MerchantDataWithPurchase(String authorization, String str, Purchase purchase, String str2, String appPackage) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        this.authorization = authorization;
        this.merchantLogin = str;
        this.purchase = purchase;
        this.language = str2;
        this.appPackage = appPackage;
    }

    public static /* synthetic */ MerchantDataWithPurchase copy$default(MerchantDataWithPurchase merchantDataWithPurchase, String str, String str2, Purchase purchase, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantDataWithPurchase.authorization;
        }
        if ((i & 2) != 0) {
            str2 = merchantDataWithPurchase.merchantLogin;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            purchase = merchantDataWithPurchase.purchase;
        }
        Purchase purchase2 = purchase;
        if ((i & 8) != 0) {
            str3 = merchantDataWithPurchase.language;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = merchantDataWithPurchase.appPackage;
        }
        return merchantDataWithPurchase.copy(str, str5, purchase2, str6, str4);
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
    public final Purchase getPurchase() {
        return this.purchase;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppPackage() {
        return this.appPackage;
    }

    public final MerchantDataWithPurchase copy(String authorization, String merchantLogin, Purchase purchase, String language, String appPackage) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        return new MerchantDataWithPurchase(authorization, merchantLogin, purchase, language, appPackage);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MerchantDataWithPurchase)) {
            return false;
        }
        MerchantDataWithPurchase merchantDataWithPurchase = (MerchantDataWithPurchase) other;
        return Intrinsics.areEqual(this.authorization, merchantDataWithPurchase.authorization) && Intrinsics.areEqual(this.merchantLogin, merchantDataWithPurchase.merchantLogin) && Intrinsics.areEqual(this.purchase, merchantDataWithPurchase.purchase) && Intrinsics.areEqual(this.language, merchantDataWithPurchase.language) && Intrinsics.areEqual(this.appPackage, merchantDataWithPurchase.appPackage);
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

    public final Purchase getPurchase() {
        return this.purchase;
    }

    public int hashCode() {
        int iHashCode = this.authorization.hashCode() * 31;
        String str = this.merchantLogin;
        int iHashCode2 = (this.purchase.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        String str2 = this.language;
        return this.appPackage.hashCode() + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MerchantDataWithPurchase(authorization=");
        sb.append(this.authorization);
        sb.append(", merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", purchase=");
        sb.append(this.purchase);
        sb.append(", language=");
        sb.append(this.language);
        sb.append(", appPackage=");
        return Q1.a(sb, this.appPackage, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.authorization);
        parcel.writeString(this.merchantLogin);
        this.purchase.writeToParcel(parcel, flags);
        parcel.writeString(this.language);
        parcel.writeString(this.appPackage);
    }

    public /* synthetic */ MerchantDataWithPurchase(String str, String str2, Purchase purchase, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, purchase, (i & 8) != 0 ? null : str3, str4);
    }
}
