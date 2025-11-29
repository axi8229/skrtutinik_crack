package ru.yoomoney.sdk.two_fa.exception;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuleViolationFailure.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;", "Lru/yoomoney/sdk/two_fa/exception/Failure;", "()V", "ActiveSessionIsExpiredFailure", "InvalidSecretFailure", "NoAttemptsLeftFailure", "VelocityCheckFailure", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$ActiveSessionIsExpiredFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$InvalidSecretFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$NoAttemptsLeftFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$VelocityCheckFailure;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RulesViolationFailure extends Failure {
    public static final int $stable = 0;

    public /* synthetic */ RulesViolationFailure(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RulesViolationFailure() {
        super(null);
    }

    /* compiled from: RuleViolationFailure.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$ActiveSessionIsExpiredFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ActiveSessionIsExpiredFailure extends RulesViolationFailure {
        public static final int $stable = 0;
        public static final ActiveSessionIsExpiredFailure INSTANCE = new ActiveSessionIsExpiredFailure();
        public static final Parcelable.Creator<ActiveSessionIsExpiredFailure> CREATOR = new Creator();

        /* compiled from: RuleViolationFailure.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ActiveSessionIsExpiredFailure> {
            @Override // android.os.Parcelable.Creator
            public final ActiveSessionIsExpiredFailure createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return ActiveSessionIsExpiredFailure.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final ActiveSessionIsExpiredFailure[] newArray(int i) {
                return new ActiveSessionIsExpiredFailure[i];
            }
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

        private ActiveSessionIsExpiredFailure() {
            super(null);
        }
    }

    /* compiled from: RuleViolationFailure.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$NoAttemptsLeftFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NoAttemptsLeftFailure extends RulesViolationFailure {
        public static final int $stable = 0;
        public static final NoAttemptsLeftFailure INSTANCE = new NoAttemptsLeftFailure();
        public static final Parcelable.Creator<NoAttemptsLeftFailure> CREATOR = new Creator();

        /* compiled from: RuleViolationFailure.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoAttemptsLeftFailure> {
            @Override // android.os.Parcelable.Creator
            public final NoAttemptsLeftFailure createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return NoAttemptsLeftFailure.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final NoAttemptsLeftFailure[] newArray(int i) {
                return new NoAttemptsLeftFailure[i];
            }
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

        private NoAttemptsLeftFailure() {
            super(null);
        }
    }

    /* compiled from: RuleViolationFailure.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$InvalidSecretFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InvalidSecretFailure extends RulesViolationFailure {
        public static final int $stable = 0;
        public static final InvalidSecretFailure INSTANCE = new InvalidSecretFailure();
        public static final Parcelable.Creator<InvalidSecretFailure> CREATOR = new Creator();

        /* compiled from: RuleViolationFailure.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<InvalidSecretFailure> {
            @Override // android.os.Parcelable.Creator
            public final InvalidSecretFailure createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return InvalidSecretFailure.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final InvalidSecretFailure[] newArray(int i) {
                return new InvalidSecretFailure[i];
            }
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

        private InvalidSecretFailure() {
            super(null);
        }
    }

    /* compiled from: RuleViolationFailure.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure$VelocityCheckFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VelocityCheckFailure extends RulesViolationFailure {
        public static final int $stable = 0;
        public static final VelocityCheckFailure INSTANCE = new VelocityCheckFailure();
        public static final Parcelable.Creator<VelocityCheckFailure> CREATOR = new Creator();

        /* compiled from: RuleViolationFailure.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<VelocityCheckFailure> {
            @Override // android.os.Parcelable.Creator
            public final VelocityCheckFailure createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return VelocityCheckFailure.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final VelocityCheckFailure[] newArray(int i) {
                return new VelocityCheckFailure[i];
            }
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

        private VelocityCheckFailure() {
            super(null);
        }
    }
}
