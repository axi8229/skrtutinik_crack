package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/sputnik/common/entities/localization/BottomSheetStandardPromo;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "btnSubscribe", "btnOtherTariffs", "caution", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "getBtnSubscribe", "getBtnOtherTariffs", "getCaution", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BottomSheetStandardPromo implements Parcelable {
    public static final Parcelable.Creator<BottomSheetStandardPromo> CREATOR = new Creator();

    @SerializedName("btn_other_tariffs")
    private final String btnOtherTariffs;

    @SerializedName("btn_subscribe")
    private final String btnSubscribe;
    private final String caution;
    private final String subtitle;
    private final String title;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BottomSheetStandardPromo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BottomSheetStandardPromo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BottomSheetStandardPromo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BottomSheetStandardPromo[] newArray(int i) {
            return new BottomSheetStandardPromo[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomSheetStandardPromo)) {
            return false;
        }
        BottomSheetStandardPromo bottomSheetStandardPromo = (BottomSheetStandardPromo) other;
        return Intrinsics.areEqual(this.title, bottomSheetStandardPromo.title) && Intrinsics.areEqual(this.subtitle, bottomSheetStandardPromo.subtitle) && Intrinsics.areEqual(this.btnSubscribe, bottomSheetStandardPromo.btnSubscribe) && Intrinsics.areEqual(this.btnOtherTariffs, bottomSheetStandardPromo.btnOtherTariffs) && Intrinsics.areEqual(this.caution, bottomSheetStandardPromo.caution);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.btnSubscribe;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.btnOtherTariffs;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.caution;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "BottomSheetStandardPromo(title=" + this.title + ", subtitle=" + this.subtitle + ", btnSubscribe=" + this.btnSubscribe + ", btnOtherTariffs=" + this.btnOtherTariffs + ", caution=" + this.caution + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.btnSubscribe);
        parcel.writeString(this.btnOtherTariffs);
        parcel.writeString(this.caution);
    }

    public BottomSheetStandardPromo(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.subtitle = str2;
        this.btnSubscribe = str3;
        this.btnOtherTariffs = str4;
        this.caution = str5;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getBtnOtherTariffs() {
        return this.btnOtherTariffs;
    }

    public final String getCaution() {
        return this.caution;
    }
}
