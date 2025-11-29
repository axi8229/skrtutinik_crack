package ru.yoomoney.sdk.auth.api.enrollment.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000b¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessSetPassword;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "isEmailSet", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZZ)V", "getAddToBackStack", "()Z", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnrollmentProcessSetPassword extends EnrollmentProcess {
    public static final Parcelable.Creator<EnrollmentProcessSetPassword> CREATOR = new Creator();

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    @SerializedName("isEmailSet")
    private final boolean isEmailSet;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EnrollmentProcessSetPassword> {
        @Override // android.os.Parcelable.Creator
        public final EnrollmentProcessSetPassword createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EnrollmentProcessSetPassword(parcel.readString(), (OffsetDateTime) parcel.readSerializable(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final EnrollmentProcessSetPassword[] newArray(int i) {
            return new EnrollmentProcessSetPassword[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrollmentProcessSetPassword(String id, OffsetDateTime expireAt, boolean z, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.isEmailSet = z2;
    }

    public static /* synthetic */ EnrollmentProcessSetPassword copy$default(EnrollmentProcessSetPassword enrollmentProcessSetPassword, String str, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enrollmentProcessSetPassword.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = enrollmentProcessSetPassword.expireAt;
        }
        if ((i & 4) != 0) {
            z = enrollmentProcessSetPassword.addToBackStack;
        }
        if ((i & 8) != 0) {
            z2 = enrollmentProcessSetPassword.isEmailSet;
        }
        return enrollmentProcessSetPassword.copy(str, offsetDateTime, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsEmailSet() {
        return this.isEmailSet;
    }

    public final EnrollmentProcessSetPassword copy(String id, OffsetDateTime expireAt, boolean addToBackStack, boolean isEmailSet) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        return new EnrollmentProcessSetPassword(id, expireAt, addToBackStack, isEmailSet);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnrollmentProcessSetPassword)) {
            return false;
        }
        EnrollmentProcessSetPassword enrollmentProcessSetPassword = (EnrollmentProcessSetPassword) other;
        return Intrinsics.areEqual(this.id, enrollmentProcessSetPassword.id) && Intrinsics.areEqual(this.expireAt, enrollmentProcessSetPassword.expireAt) && this.addToBackStack == enrollmentProcessSetPassword.addToBackStack && this.isEmailSet == enrollmentProcessSetPassword.isEmailSet;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isEmailSet) + b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31);
    }

    public final boolean isEmailSet() {
        return this.isEmailSet;
    }

    public String toString() {
        return "EnrollmentProcessSetPassword(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", isEmailSet=" + this.isEmailSet + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeSerializable(this.expireAt);
        parcel.writeInt(this.addToBackStack ? 1 : 0);
        parcel.writeInt(this.isEmailSet ? 1 : 0);
    }
}
