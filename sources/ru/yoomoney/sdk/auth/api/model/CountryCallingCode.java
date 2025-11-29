package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "Landroid/os/Parcelable;", "phonePrefix", "", "countryCode", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getPhonePrefix", "getTitle", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CountryCallingCode implements Parcelable {
    public static final Parcelable.Creator<CountryCallingCode> CREATOR = new Creator();

    @SerializedName("countryCode")
    private final String countryCode;

    @SerializedName("phonePrefix")
    private final String phonePrefix;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CountryCallingCode> {
        @Override // android.os.Parcelable.Creator
        public final CountryCallingCode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CountryCallingCode(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CountryCallingCode[] newArray(int i) {
            return new CountryCallingCode[i];
        }
    }

    public CountryCallingCode(String phonePrefix, String countryCode, String title) {
        Intrinsics.checkNotNullParameter(phonePrefix, "phonePrefix");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(title, "title");
        this.phonePrefix = phonePrefix;
        this.countryCode = countryCode;
        this.title = title;
    }

    public static /* synthetic */ CountryCallingCode copy$default(CountryCallingCode countryCallingCode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countryCallingCode.phonePrefix;
        }
        if ((i & 2) != 0) {
            str2 = countryCallingCode.countryCode;
        }
        if ((i & 4) != 0) {
            str3 = countryCallingCode.title;
        }
        return countryCallingCode.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPhonePrefix() {
        return this.phonePrefix;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final CountryCallingCode copy(String phonePrefix, String countryCode, String title) {
        Intrinsics.checkNotNullParameter(phonePrefix, "phonePrefix");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(title, "title");
        return new CountryCallingCode(phonePrefix, countryCode, title);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryCallingCode)) {
            return false;
        }
        CountryCallingCode countryCallingCode = (CountryCallingCode) other;
        return Intrinsics.areEqual(this.phonePrefix, countryCallingCode.phonePrefix) && Intrinsics.areEqual(this.countryCode, countryCallingCode.countryCode) && Intrinsics.areEqual(this.title, countryCallingCode.title);
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getPhonePrefix() {
        return this.phonePrefix;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title.hashCode() + a.a(this.countryCode, this.phonePrefix.hashCode() * 31, 31);
    }

    public String toString() {
        return "CountryCallingCode(phonePrefix=" + this.phonePrefix + ", countryCode=" + this.countryCode + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.phonePrefix);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.title);
    }
}
