package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneLoginLocale.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginPrivacy;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "param1", "param2", "param3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getParam1", "getParam2", "getParam3", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PhoneLoginPrivacy implements Parcelable {
    public static final Parcelable.Creator<PhoneLoginPrivacy> CREATOR = new Creator();
    private final String param1;
    private final String param2;
    private final String param3;
    private final String title;

    /* compiled from: PhoneLoginLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneLoginPrivacy> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneLoginPrivacy createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneLoginPrivacy(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneLoginPrivacy[] newArray(int i) {
            return new PhoneLoginPrivacy[i];
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
        if (!(other instanceof PhoneLoginPrivacy)) {
            return false;
        }
        PhoneLoginPrivacy phoneLoginPrivacy = (PhoneLoginPrivacy) other;
        return Intrinsics.areEqual(this.title, phoneLoginPrivacy.title) && Intrinsics.areEqual(this.param1, phoneLoginPrivacy.param1) && Intrinsics.areEqual(this.param2, phoneLoginPrivacy.param2) && Intrinsics.areEqual(this.param3, phoneLoginPrivacy.param3);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.param1.hashCode()) * 31) + this.param2.hashCode()) * 31) + this.param3.hashCode();
    }

    public String toString() {
        return "PhoneLoginPrivacy(title=" + this.title + ", param1=" + this.param1 + ", param2=" + this.param2 + ", param3=" + this.param3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.param1);
        parcel.writeString(this.param2);
        parcel.writeString(this.param3);
    }

    public PhoneLoginPrivacy(String title, String param1, String param2, String param3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(param1, "param1");
        Intrinsics.checkNotNullParameter(param2, "param2");
        Intrinsics.checkNotNullParameter(param3, "param3");
        this.title = title;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getParam1() {
        return this.param1;
    }

    public final String getParam2() {
        return this.param2;
    }

    public final String getParam3() {
        return this.param3;
    }
}
