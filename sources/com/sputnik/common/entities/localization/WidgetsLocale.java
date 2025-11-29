package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b!\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\"\u0010\f¨\u0006#"}, d2 = {"Lcom/sputnik/common/entities/localization/WidgetsLocale;", "Landroid/os/Parcelable;", "", "successTitle", "failureTitle", "wrongWidget", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "settings", "noAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSuccessTitle", "getFailureTitle", "getWrongWidget", "getTitle", "getSettings", "getNoAddress", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WidgetsLocale implements Parcelable {
    public static final Parcelable.Creator<WidgetsLocale> CREATOR = new Creator();

    @SerializedName("failure_title")
    private final String failureTitle;

    @SerializedName("no_address")
    private final String noAddress;
    private final String settings;

    @SerializedName("success_title")
    private final String successTitle;
    private final String title;

    @SerializedName("wrong_widget")
    private final String wrongWidget;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WidgetsLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetsLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WidgetsLocale(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetsLocale[] newArray(int i) {
            return new WidgetsLocale[i];
        }
    }

    public WidgetsLocale() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetsLocale)) {
            return false;
        }
        WidgetsLocale widgetsLocale = (WidgetsLocale) other;
        return Intrinsics.areEqual(this.successTitle, widgetsLocale.successTitle) && Intrinsics.areEqual(this.failureTitle, widgetsLocale.failureTitle) && Intrinsics.areEqual(this.wrongWidget, widgetsLocale.wrongWidget) && Intrinsics.areEqual(this.title, widgetsLocale.title) && Intrinsics.areEqual(this.settings, widgetsLocale.settings) && Intrinsics.areEqual(this.noAddress, widgetsLocale.noAddress);
    }

    public int hashCode() {
        String str = this.successTitle;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.failureTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.wrongWidget;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.settings;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.noAddress;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "WidgetsLocale(successTitle=" + this.successTitle + ", failureTitle=" + this.failureTitle + ", wrongWidget=" + this.wrongWidget + ", title=" + this.title + ", settings=" + this.settings + ", noAddress=" + this.noAddress + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.successTitle);
        parcel.writeString(this.failureTitle);
        parcel.writeString(this.wrongWidget);
        parcel.writeString(this.title);
        parcel.writeString(this.settings);
        parcel.writeString(this.noAddress);
    }

    public WidgetsLocale(String str, String str2, String str3, String str4, String str5, String str6) {
        this.successTitle = str;
        this.failureTitle = str2;
        this.wrongWidget = str3;
        this.title = str4;
        this.settings = str5;
        this.noAddress = str6;
    }

    public /* synthetic */ WidgetsLocale(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getSuccessTitle() {
        return this.successTitle;
    }

    public final String getFailureTitle() {
        return this.failureTitle;
    }

    public final String getWrongWidget() {
        return this.wrongWidget;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSettings() {
        return this.settings;
    }

    public final String getNoAddress() {
        return this.noAddress;
    }
}
