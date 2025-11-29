package com.sputnik.common.entities.demo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DemoModeLocale.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/demo/DemoModeLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "endRegistrationButton", "", "notice", "main", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getEndRegistrationButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Ljava/lang/String;", "getNotice", "getMain", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DemoModeLocale implements Parcelable {
    public static final Parcelable.Creator<DemoModeLocale> CREATOR = new Creator();

    @SerializedName("end_registration_button")
    private final TextTitle endRegistrationButton;
    private final TextTitle main;
    private final String notice;

    /* compiled from: DemoModeLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DemoModeLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DemoModeLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DemoModeLocale(parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DemoModeLocale[] newArray(int i) {
            return new DemoModeLocale[i];
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
        if (!(other instanceof DemoModeLocale)) {
            return false;
        }
        DemoModeLocale demoModeLocale = (DemoModeLocale) other;
        return Intrinsics.areEqual(this.endRegistrationButton, demoModeLocale.endRegistrationButton) && Intrinsics.areEqual(this.notice, demoModeLocale.notice) && Intrinsics.areEqual(this.main, demoModeLocale.main);
    }

    public int hashCode() {
        TextTitle textTitle = this.endRegistrationButton;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        String str = this.notice;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        TextTitle textTitle2 = this.main;
        return iHashCode2 + (textTitle2 != null ? textTitle2.hashCode() : 0);
    }

    public String toString() {
        return "DemoModeLocale(endRegistrationButton=" + this.endRegistrationButton + ", notice=" + this.notice + ", main=" + this.main + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        TextTitle textTitle = this.endRegistrationButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.notice);
        TextTitle textTitle2 = this.main;
        if (textTitle2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle2.writeToParcel(parcel, flags);
        }
    }

    public DemoModeLocale(TextTitle textTitle, String str, TextTitle textTitle2) {
        this.endRegistrationButton = textTitle;
        this.notice = str;
        this.main = textTitle2;
    }

    public final TextTitle getEndRegistrationButton() {
        return this.endRegistrationButton;
    }

    public final String getNotice() {
        return this.notice;
    }
}
