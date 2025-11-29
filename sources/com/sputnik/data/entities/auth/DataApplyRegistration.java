package com.sputnik.data.entities.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataApplyRegistration.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/data/entities/auth/DataApplyRegistration;", "Landroid/os/Parcelable;", "", "phone", "locale", "platform", "app", "", CrashHianalyticsData.TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getPhone", "getLocale", "getPlatform", "getApp", "J", "getTime", "()J", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataApplyRegistration implements Parcelable {
    public static final Parcelable.Creator<DataApplyRegistration> CREATOR = new Creator();
    private final String app;
    private final String locale;
    private final String phone;
    private final String platform;
    private final long time;

    /* compiled from: DataApplyRegistration.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataApplyRegistration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataApplyRegistration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataApplyRegistration(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataApplyRegistration[] newArray(int i) {
            return new DataApplyRegistration[i];
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
        if (!(other instanceof DataApplyRegistration)) {
            return false;
        }
        DataApplyRegistration dataApplyRegistration = (DataApplyRegistration) other;
        return Intrinsics.areEqual(this.phone, dataApplyRegistration.phone) && Intrinsics.areEqual(this.locale, dataApplyRegistration.locale) && Intrinsics.areEqual(this.platform, dataApplyRegistration.platform) && Intrinsics.areEqual(this.app, dataApplyRegistration.app) && this.time == dataApplyRegistration.time;
    }

    public int hashCode() {
        String str = this.phone;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.locale;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.platform;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.app;
        return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "DataApplyRegistration(phone=" + this.phone + ", locale=" + this.locale + ", platform=" + this.platform + ", app=" + this.app + ", time=" + this.time + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.phone);
        parcel.writeString(this.locale);
        parcel.writeString(this.platform);
        parcel.writeString(this.app);
        parcel.writeLong(this.time);
    }

    public DataApplyRegistration(String str, String str2, String str3, String str4, long j) {
        this.phone = str;
        this.locale = str2;
        this.platform = str3;
        this.app = str4;
        this.time = j;
    }

    public /* synthetic */ DataApplyRegistration(String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "android" : str3, str4, (i & 16) != 0 ? System.currentTimeMillis() / 1000 : j);
    }
}
