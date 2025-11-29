package spay.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u0013\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lspay/sdk/api/MerchantError;", "Landroid/os/Parcelable;", "description", "", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "NoInternetConnection", "RequiredDataNotSent", "SPayApiError", "SdkClosedByUser", "TimeoutException", "UnexpectedError", "Lspay/sdk/api/MerchantError$NoInternetConnection;", "Lspay/sdk/api/MerchantError$RequiredDataNotSent;", "Lspay/sdk/api/MerchantError$SPayApiError;", "Lspay/sdk/api/MerchantError$SdkClosedByUser;", "Lspay/sdk/api/MerchantError$TimeoutException;", "Lspay/sdk/api/MerchantError$UnexpectedError;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MerchantError implements Parcelable {
    private final String description;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/MerchantError$NoInternetConnection;", "Lspay/sdk/api/MerchantError;", "description", "", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NoInternetConnection extends MerchantError {
        public static final Parcelable.Creator<NoInternetConnection> CREATOR = new Creator();
        private final String description;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoInternetConnection> {
            @Override // android.os.Parcelable.Creator
            public final NoInternetConnection createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NoInternetConnection(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final NoInternetConnection[] newArray(int i) {
                return new NoInternetConnection[i];
            }
        }

        public NoInternetConnection() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NoInternetConnection copy$default(NoInternetConnection noInternetConnection, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noInternetConnection.getDescription();
            }
            return noInternetConnection.copy(str);
        }

        public final String component1() {
            return getDescription();
        }

        public final NoInternetConnection copy(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new NoInternetConnection(description);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoInternetConnection) && Intrinsics.areEqual(getDescription(), ((NoInternetConnection) other).getDescription());
        }

        @Override // spay.sdk.api.MerchantError
        public String getDescription() {
            return this.description;
        }

        public int hashCode() {
            return getDescription().hashCode();
        }

        public String toString() {
            return "NoInternetConnection(description=" + getDescription() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.description);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoInternetConnection(String description) {
            super(description, null);
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
        }

        public /* synthetic */ NoInternetConnection(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Отсутствует подключение к интернету" : str);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/MerchantError$RequiredDataNotSent;", "Lspay/sdk/api/MerchantError;", "description", "", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class RequiredDataNotSent extends MerchantError {
        public static final Parcelable.Creator<RequiredDataNotSent> CREATOR = new Creator();
        private final String description;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<RequiredDataNotSent> {
            @Override // android.os.Parcelable.Creator
            public final RequiredDataNotSent createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new RequiredDataNotSent(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final RequiredDataNotSent[] newArray(int i) {
                return new RequiredDataNotSent[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequiredDataNotSent(String description) {
            super(description, null);
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
        }

        public static /* synthetic */ RequiredDataNotSent copy$default(RequiredDataNotSent requiredDataNotSent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requiredDataNotSent.getDescription();
            }
            return requiredDataNotSent.copy(str);
        }

        public final String component1() {
            return getDescription();
        }

        public final RequiredDataNotSent copy(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new RequiredDataNotSent(description);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RequiredDataNotSent) && Intrinsics.areEqual(getDescription(), ((RequiredDataNotSent) other).getDescription());
        }

        @Override // spay.sdk.api.MerchantError
        public String getDescription() {
            return this.description;
        }

        public int hashCode() {
            return getDescription().hashCode();
        }

        public String toString() {
            return "RequiredDataNotSent(description=" + getDescription() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.description);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/MerchantError$SPayApiError;", "Lspay/sdk/api/MerchantError;", "description", "", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SPayApiError extends MerchantError {
        public static final Parcelable.Creator<SPayApiError> CREATOR = new Creator();
        private final String description;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SPayApiError> {
            @Override // android.os.Parcelable.Creator
            public final SPayApiError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SPayApiError(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SPayApiError[] newArray(int i) {
                return new SPayApiError[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SPayApiError(String description) {
            super(description, null);
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
        }

        public static /* synthetic */ SPayApiError copy$default(SPayApiError sPayApiError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sPayApiError.getDescription();
            }
            return sPayApiError.copy(str);
        }

        public final String component1() {
            return getDescription();
        }

        public final SPayApiError copy(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new SPayApiError(description);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SPayApiError) && Intrinsics.areEqual(getDescription(), ((SPayApiError) other).getDescription());
        }

        @Override // spay.sdk.api.MerchantError
        public String getDescription() {
            return this.description;
        }

        public int hashCode() {
            return getDescription().hashCode();
        }

        public String toString() {
            return "SPayApiError(description=" + getDescription() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.description);
        }
    }

    @Deprecated
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lspay/sdk/api/MerchantError$SdkClosedByUser;", "Lspay/sdk/api/MerchantError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SdkClosedByUser extends MerchantError {
        public static final SdkClosedByUser INSTANCE = new SdkClosedByUser();
        public static final Parcelable.Creator<SdkClosedByUser> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SdkClosedByUser> {
            @Override // android.os.Parcelable.Creator
            public final SdkClosedByUser createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return SdkClosedByUser.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final SdkClosedByUser[] newArray(int i) {
                return new SdkClosedByUser[i];
            }
        }

        private SdkClosedByUser() {
            super(null, 1, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/MerchantError$TimeoutException;", "Lspay/sdk/api/MerchantError;", "description", "", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class TimeoutException extends MerchantError {
        public static final Parcelable.Creator<TimeoutException> CREATOR = new Creator();
        private final String description;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TimeoutException> {
            @Override // android.os.Parcelable.Creator
            public final TimeoutException createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TimeoutException(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final TimeoutException[] newArray(int i) {
                return new TimeoutException[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TimeoutException(String description) {
            super(description, null);
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
        }

        public static /* synthetic */ TimeoutException copy$default(TimeoutException timeoutException, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = timeoutException.getDescription();
            }
            return timeoutException.copy(str);
        }

        public final String component1() {
            return getDescription();
        }

        public final TimeoutException copy(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new TimeoutException(description);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TimeoutException) && Intrinsics.areEqual(getDescription(), ((TimeoutException) other).getDescription());
        }

        @Override // spay.sdk.api.MerchantError
        public String getDescription() {
            return this.description;
        }

        public int hashCode() {
            return getDescription().hashCode();
        }

        public String toString() {
            return "TimeoutException(description=" + getDescription() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.description);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lspay/sdk/api/MerchantError$UnexpectedError;", "Lspay/sdk/api/MerchantError;", "description", "", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UnexpectedError extends MerchantError {
        public static final Parcelable.Creator<UnexpectedError> CREATOR = new Creator();
        private final String description;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<UnexpectedError> {
            @Override // android.os.Parcelable.Creator
            public final UnexpectedError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new UnexpectedError(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final UnexpectedError[] newArray(int i) {
                return new UnexpectedError[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnexpectedError(String description) {
            super(description, null);
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
        }

        public static /* synthetic */ UnexpectedError copy$default(UnexpectedError unexpectedError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unexpectedError.getDescription();
            }
            return unexpectedError.copy(str);
        }

        public final String component1() {
            return getDescription();
        }

        public final UnexpectedError copy(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new UnexpectedError(description);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnexpectedError) && Intrinsics.areEqual(getDescription(), ((UnexpectedError) other).getDescription());
        }

        @Override // spay.sdk.api.MerchantError
        public String getDescription() {
            return this.description;
        }

        public int hashCode() {
            return getDescription().hashCode();
        }

        public String toString() {
            return "UnexpectedError(description=" + getDescription() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.description);
        }
    }

    private MerchantError(String str) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }

    public /* synthetic */ MerchantError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, null);
    }

    public /* synthetic */ MerchantError(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
