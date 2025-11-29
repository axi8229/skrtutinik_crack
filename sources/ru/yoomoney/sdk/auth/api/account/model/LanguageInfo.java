package ru.yoomoney.sdk.auth.api.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/LanguageInfo;", "Landroid/os/Parcelable;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lru/yoomoney/sdk/auth/api/account/model/Language;", "modifiable", "", "(Lru/yoomoney/sdk/auth/api/account/model/Language;Z)V", "getModifiable", "()Z", "getValue", "()Lru/yoomoney/sdk/auth/api/account/model/Language;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LanguageInfo implements Parcelable {
    public static final Parcelable.Creator<LanguageInfo> CREATOR = new Creator();

    @SerializedName("modifiable")
    private final boolean modifiable;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)
    private final Language value;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LanguageInfo> {
        @Override // android.os.Parcelable.Creator
        public final LanguageInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LanguageInfo(parcel.readInt() == 0 ? null : Language.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final LanguageInfo[] newArray(int i) {
            return new LanguageInfo[i];
        }
    }

    public LanguageInfo(Language language, boolean z) {
        this.value = language;
        this.modifiable = z;
    }

    public static /* synthetic */ LanguageInfo copy$default(LanguageInfo languageInfo, Language language, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            language = languageInfo.value;
        }
        if ((i & 2) != 0) {
            z = languageInfo.modifiable;
        }
        return languageInfo.copy(language, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Language getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getModifiable() {
        return this.modifiable;
    }

    public final LanguageInfo copy(Language value, boolean modifiable) {
        return new LanguageInfo(value, modifiable);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageInfo)) {
            return false;
        }
        LanguageInfo languageInfo = (LanguageInfo) other;
        return this.value == languageInfo.value && this.modifiable == languageInfo.modifiable;
    }

    public final boolean getModifiable() {
        return this.modifiable;
    }

    public final Language getValue() {
        return this.value;
    }

    public int hashCode() {
        Language language = this.value;
        return Boolean.hashCode(this.modifiable) + ((language == null ? 0 : language.hashCode()) * 31);
    }

    public String toString() {
        return "LanguageInfo(value=" + this.value + ", modifiable=" + this.modifiable + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Language language = this.value;
        if (language == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(language.name());
        }
        parcel.writeInt(this.modifiable ? 1 : 0);
    }
}
