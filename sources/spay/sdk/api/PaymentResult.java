package spay.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lspay/sdk/api/PaymentResult;", "Landroid/os/Parcelable;", "()V", "Cancel", "Error", "Processing", "Success", "Lspay/sdk/api/PaymentResult$Cancel;", "Lspay/sdk/api/PaymentResult$Error;", "Lspay/sdk/api/PaymentResult$Processing;", "Lspay/sdk/api/PaymentResult$Success;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PaymentResult implements Parcelable {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/PaymentResult$Cancel;", "Lspay/sdk/api/PaymentResult;", "localSessionId", "", "(Ljava/lang/String;)V", "getLocalSessionId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Cancel extends PaymentResult {
        public static final Parcelable.Creator<Cancel> CREATOR = new Creator();
        private final String localSessionId;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Cancel> {
            @Override // android.os.Parcelable.Creator
            public final Cancel createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Cancel(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Cancel[] newArray(int i) {
                return new Cancel[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancel(String localSessionId) {
            super(null);
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            this.localSessionId = localSessionId;
        }

        public static /* synthetic */ Cancel copy$default(Cancel cancel, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cancel.localSessionId;
            }
            return cancel.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        public final Cancel copy(String localSessionId) {
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            return new Cancel(localSessionId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Cancel) && Intrinsics.areEqual(this.localSessionId, ((Cancel) other).localSessionId);
        }

        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        public int hashCode() {
            return this.localSessionId.hashCode();
        }

        public String toString() {
            return Q1.a(new StringBuilder("Cancel(localSessionId="), this.localSessionId, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.localSessionId);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lspay/sdk/api/PaymentResult$Error;", "Lspay/sdk/api/PaymentResult;", "localSessionId", "", "merchantError", "Lspay/sdk/api/MerchantError;", "(Ljava/lang/String;Lspay/sdk/api/MerchantError;)V", "getLocalSessionId", "()Ljava/lang/String;", "getMerchantError", "()Lspay/sdk/api/MerchantError;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error extends PaymentResult {
        public static final Parcelable.Creator<Error> CREATOR = new Creator();
        private final String localSessionId;
        private final MerchantError merchantError;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Error> {
            @Override // android.os.Parcelable.Creator
            public final Error createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Error(parcel.readString(), (MerchantError) parcel.readParcelable(Error.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            public final Error[] newArray(int i) {
                return new Error[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String localSessionId, MerchantError merchantError) {
            super(null);
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            this.localSessionId = localSessionId;
            this.merchantError = merchantError;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, MerchantError merchantError, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.localSessionId;
            }
            if ((i & 2) != 0) {
                merchantError = error.merchantError;
            }
            return error.copy(str, merchantError);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final MerchantError getMerchantError() {
            return this.merchantError;
        }

        public final Error copy(String localSessionId, MerchantError merchantError) {
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            return new Error(localSessionId, merchantError);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.localSessionId, error.localSessionId) && Intrinsics.areEqual(this.merchantError, error.merchantError);
        }

        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        public final MerchantError getMerchantError() {
            return this.merchantError;
        }

        public int hashCode() {
            int iHashCode = this.localSessionId.hashCode() * 31;
            MerchantError merchantError = this.merchantError;
            return iHashCode + (merchantError == null ? 0 : merchantError.hashCode());
        }

        public String toString() {
            return "Error(localSessionId=" + this.localSessionId + ", merchantError=" + this.merchantError + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.localSessionId);
            parcel.writeParcelable(this.merchantError, flags);
        }

        public /* synthetic */ Error(String str, MerchantError merchantError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : merchantError);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/PaymentResult$Processing;", "Lspay/sdk/api/PaymentResult;", "localSessionId", "", "(Ljava/lang/String;)V", "getLocalSessionId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Processing extends PaymentResult {
        public static final Parcelable.Creator<Processing> CREATOR = new Creator();
        private final String localSessionId;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Processing> {
            @Override // android.os.Parcelable.Creator
            public final Processing createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Processing(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Processing[] newArray(int i) {
                return new Processing[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Processing(String localSessionId) {
            super(null);
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            this.localSessionId = localSessionId;
        }

        public static /* synthetic */ Processing copy$default(Processing processing, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = processing.localSessionId;
            }
            return processing.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        public final Processing copy(String localSessionId) {
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            return new Processing(localSessionId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Processing) && Intrinsics.areEqual(this.localSessionId, ((Processing) other).localSessionId);
        }

        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        public int hashCode() {
            return this.localSessionId.hashCode();
        }

        public String toString() {
            return Q1.a(new StringBuilder("Processing(localSessionId="), this.localSessionId, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.localSessionId);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/PaymentResult$Success;", "Lspay/sdk/api/PaymentResult;", "localSessionId", "", "(Ljava/lang/String;)V", "getLocalSessionId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success extends PaymentResult {
        public static final Parcelable.Creator<Success> CREATOR = new Creator();
        private final String localSessionId;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Success> {
            @Override // android.os.Parcelable.Creator
            public final Success createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Success(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Success[] newArray(int i) {
                return new Success[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String localSessionId) {
            super(null);
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            this.localSessionId = localSessionId;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.localSessionId;
            }
            return success.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        public final Success copy(String localSessionId) {
            Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
            return new Success(localSessionId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.localSessionId, ((Success) other).localSessionId);
        }

        public final String getLocalSessionId() {
            return this.localSessionId;
        }

        public int hashCode() {
            return this.localSessionId.hashCode();
        }

        public String toString() {
            return Q1.a(new StringBuilder("Success(localSessionId="), this.localSessionId, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.localSessionId);
        }
    }

    private PaymentResult() {
    }

    public /* synthetic */ PaymentResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
