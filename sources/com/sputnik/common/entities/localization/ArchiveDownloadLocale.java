package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\fR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b$\u0010\f¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/ArchiveDownloadLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/TextListTitles;", "body", "", "titleLeftLabel", "", "errors", "downloading", "<init>", "(Lcom/sputnik/common/entities/localization/TextListTitles;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/TextListTitles;", "getBody", "()Lcom/sputnik/common/entities/localization/TextListTitles;", "Ljava/lang/String;", "getTitleLeftLabel", "Ljava/util/List;", "getErrors", "()Ljava/util/List;", "getDownloading", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ArchiveDownloadLocale implements Parcelable {
    public static final Parcelable.Creator<ArchiveDownloadLocale> CREATOR = new Creator();
    private final TextListTitles body;
    private final String downloading;
    private final List<String> errors;

    @SerializedName("time_left_label")
    private final String titleLeftLabel;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ArchiveDownloadLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArchiveDownloadLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ArchiveDownloadLocale(parcel.readInt() == 0 ? null : TextListTitles.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArchiveDownloadLocale[] newArray(int i) {
            return new ArchiveDownloadLocale[i];
        }
    }

    public ArchiveDownloadLocale() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArchiveDownloadLocale)) {
            return false;
        }
        ArchiveDownloadLocale archiveDownloadLocale = (ArchiveDownloadLocale) other;
        return Intrinsics.areEqual(this.body, archiveDownloadLocale.body) && Intrinsics.areEqual(this.titleLeftLabel, archiveDownloadLocale.titleLeftLabel) && Intrinsics.areEqual(this.errors, archiveDownloadLocale.errors) && Intrinsics.areEqual(this.downloading, archiveDownloadLocale.downloading);
    }

    public int hashCode() {
        TextListTitles textListTitles = this.body;
        int iHashCode = (textListTitles == null ? 0 : textListTitles.hashCode()) * 31;
        String str = this.titleLeftLabel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.errors;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.downloading;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ArchiveDownloadLocale(body=" + this.body + ", titleLeftLabel=" + this.titleLeftLabel + ", errors=" + this.errors + ", downloading=" + this.downloading + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        TextListTitles textListTitles = this.body;
        if (textListTitles == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textListTitles.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.titleLeftLabel);
        parcel.writeStringList(this.errors);
        parcel.writeString(this.downloading);
    }

    public ArchiveDownloadLocale(TextListTitles textListTitles, String str, List<String> list, String str2) {
        this.body = textListTitles;
        this.titleLeftLabel = str;
        this.errors = list;
        this.downloading = str2;
    }

    public /* synthetic */ ArchiveDownloadLocale(TextListTitles textListTitles, String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textListTitles, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2);
    }

    public final List<String> getErrors() {
        return this.errors;
    }

    public final String getDownloading() {
        return this.downloading;
    }
}
