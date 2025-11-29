package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "()V", "AuthorizationIssueLimitExceeded", "EmailAlreadyTaken", "FatalError", "PhoneNumberLimitReached", "ProcessExpired", "RegistrationForbidden", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$AuthorizationIssueLimitExceeded;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$EmailAlreadyTaken;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$FatalError;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$PhoneNumberLimitReached;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$ProcessExpired;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$RegistrationForbidden;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RegistrationProcessError extends ProcessError {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$AuthorizationIssueLimitExceeded;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AuthorizationIssueLimitExceeded extends RegistrationProcessError {
        public static final AuthorizationIssueLimitExceeded INSTANCE = new AuthorizationIssueLimitExceeded();
        public static final Parcelable.Creator<AuthorizationIssueLimitExceeded> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AuthorizationIssueLimitExceeded> {
            @Override // android.os.Parcelable.Creator
            public final AuthorizationIssueLimitExceeded createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return AuthorizationIssueLimitExceeded.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final AuthorizationIssueLimitExceeded[] newArray(int i) {
                return new AuthorizationIssueLimitExceeded[i];
            }
        }

        private AuthorizationIssueLimitExceeded() {
            super(null);
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$EmailAlreadyTaken;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EmailAlreadyTaken extends RegistrationProcessError {
        public static final EmailAlreadyTaken INSTANCE = new EmailAlreadyTaken();
        public static final Parcelable.Creator<EmailAlreadyTaken> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<EmailAlreadyTaken> {
            @Override // android.os.Parcelable.Creator
            public final EmailAlreadyTaken createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return EmailAlreadyTaken.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final EmailAlreadyTaken[] newArray(int i) {
                return new EmailAlreadyTaken[i];
            }
        }

        private EmailAlreadyTaken() {
            super(null);
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$FatalError;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FatalError extends RegistrationProcessError {
        public static final FatalError INSTANCE = new FatalError();
        public static final Parcelable.Creator<FatalError> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FatalError> {
            @Override // android.os.Parcelable.Creator
            public final FatalError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return FatalError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final FatalError[] newArray(int i) {
                return new FatalError[i];
            }
        }

        private FatalError() {
            super(null);
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$PhoneNumberLimitReached;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PhoneNumberLimitReached extends RegistrationProcessError {
        public static final PhoneNumberLimitReached INSTANCE = new PhoneNumberLimitReached();
        public static final Parcelable.Creator<PhoneNumberLimitReached> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PhoneNumberLimitReached> {
            @Override // android.os.Parcelable.Creator
            public final PhoneNumberLimitReached createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return PhoneNumberLimitReached.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final PhoneNumberLimitReached[] newArray(int i) {
                return new PhoneNumberLimitReached[i];
            }
        }

        private PhoneNumberLimitReached() {
            super(null);
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$ProcessExpired;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ProcessExpired extends RegistrationProcessError {
        public static final ProcessExpired INSTANCE = new ProcessExpired();
        public static final Parcelable.Creator<ProcessExpired> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ProcessExpired> {
            @Override // android.os.Parcelable.Creator
            public final ProcessExpired createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return ProcessExpired.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final ProcessExpired[] newArray(int i) {
                return new ProcessExpired[i];
            }
        }

        private ProcessExpired() {
            super(null);
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError$RegistrationForbidden;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationForbidden extends RegistrationProcessError {
        public static final RegistrationForbidden INSTANCE = new RegistrationForbidden();
        public static final Parcelable.Creator<RegistrationForbidden> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<RegistrationForbidden> {
            @Override // android.os.Parcelable.Creator
            public final RegistrationForbidden createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return RegistrationForbidden.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final RegistrationForbidden[] newArray(int i) {
                return new RegistrationForbidden[i];
            }
        }

        private RegistrationForbidden() {
            super(null);
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

    private RegistrationProcessError() {
        super(null);
    }

    public /* synthetic */ RegistrationProcessError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
