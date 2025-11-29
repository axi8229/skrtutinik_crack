package ru.yoomoney.sdk.auth.api.enrollment.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006("}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessSetPhone;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "countryCallingCodes", "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "prefilledPhone", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLjava/util/List;Ljava/lang/String;)V", "getAddToBackStack", "()Z", "getCountryCallingCodes", "()Ljava/util/List;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "getPrefilledPhone", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnrollmentProcessSetPhone extends EnrollmentProcess {
    public static final Parcelable.Creator<EnrollmentProcessSetPhone> CREATOR = new Creator();

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("countryCallingCodes")
    private final List<CountryCallingCode> countryCallingCodes;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    @SerializedName("prefilledPhone")
    private final String prefilledPhone;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EnrollmentProcessSetPhone> {
        @Override // android.os.Parcelable.Creator
        public final EnrollmentProcessSetPhone createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            OffsetDateTime offsetDateTime = (OffsetDateTime) parcel.readSerializable();
            boolean z = parcel.readInt() != 0;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(CountryCallingCode.CREATOR.createFromParcel(parcel));
            }
            return new EnrollmentProcessSetPhone(string, offsetDateTime, z, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final EnrollmentProcessSetPhone[] newArray(int i) {
            return new EnrollmentProcessSetPhone[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrollmentProcessSetPhone(String id, OffsetDateTime expireAt, boolean z, List<CountryCallingCode> countryCallingCodes, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.countryCallingCodes = countryCallingCodes;
        this.prefilledPhone = str;
    }

    public static /* synthetic */ EnrollmentProcessSetPhone copy$default(EnrollmentProcessSetPhone enrollmentProcessSetPhone, String str, OffsetDateTime offsetDateTime, boolean z, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enrollmentProcessSetPhone.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = enrollmentProcessSetPhone.expireAt;
        }
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if ((i & 4) != 0) {
            z = enrollmentProcessSetPhone.addToBackStack;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            list = enrollmentProcessSetPhone.countryCallingCodes;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            str2 = enrollmentProcessSetPhone.prefilledPhone;
        }
        return enrollmentProcessSetPhone.copy(str, offsetDateTime2, z2, list2, str2);
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

    public final List<CountryCallingCode> component4() {
        return this.countryCallingCodes;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPrefilledPhone() {
        return this.prefilledPhone;
    }

    public final EnrollmentProcessSetPhone copy(String id, OffsetDateTime expireAt, boolean addToBackStack, List<CountryCallingCode> countryCallingCodes, String prefilledPhone) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
        return new EnrollmentProcessSetPhone(id, expireAt, addToBackStack, countryCallingCodes, prefilledPhone);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnrollmentProcessSetPhone)) {
            return false;
        }
        EnrollmentProcessSetPhone enrollmentProcessSetPhone = (EnrollmentProcessSetPhone) other;
        return Intrinsics.areEqual(this.id, enrollmentProcessSetPhone.id) && Intrinsics.areEqual(this.expireAt, enrollmentProcessSetPhone.expireAt) && this.addToBackStack == enrollmentProcessSetPhone.addToBackStack && Intrinsics.areEqual(this.countryCallingCodes, enrollmentProcessSetPhone.countryCallingCodes) && Intrinsics.areEqual(this.prefilledPhone, enrollmentProcessSetPhone.prefilledPhone);
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final List<CountryCallingCode> getCountryCallingCodes() {
        return this.countryCallingCodes;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public String getId() {
        return this.id;
    }

    public final String getPrefilledPhone() {
        return this.prefilledPhone;
    }

    public int hashCode() {
        int iHashCode = (this.countryCallingCodes.hashCode() + b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31)) * 31;
        String str = this.prefilledPhone;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "EnrollmentProcessSetPhone(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", countryCallingCodes=" + this.countryCallingCodes + ", prefilledPhone=" + this.prefilledPhone + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeSerializable(this.expireAt);
        parcel.writeInt(this.addToBackStack ? 1 : 0);
        List<CountryCallingCode> list = this.countryCallingCodes;
        parcel.writeInt(list.size());
        Iterator<CountryCallingCode> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.prefilledPhone);
    }
}
