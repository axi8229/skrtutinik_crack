package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterCodeLocale.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/EnterCodeSubTitle;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "phone", "", "sms", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getPhone", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "Ljava/lang/String;", "getSms", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EnterCodeSubTitle implements Parcelable {
    public static final Parcelable.Creator<EnterCodeSubTitle> CREATOR = new Creator();
    private final TitleWithParam phone;
    private final String sms;

    /* compiled from: EnterCodeLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EnterCodeSubTitle> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterCodeSubTitle createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EnterCodeSubTitle(TitleWithParam.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterCodeSubTitle[] newArray(int i) {
            return new EnterCodeSubTitle[i];
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
        if (!(other instanceof EnterCodeSubTitle)) {
            return false;
        }
        EnterCodeSubTitle enterCodeSubTitle = (EnterCodeSubTitle) other;
        return Intrinsics.areEqual(this.phone, enterCodeSubTitle.phone) && Intrinsics.areEqual(this.sms, enterCodeSubTitle.sms);
    }

    public int hashCode() {
        return (this.phone.hashCode() * 31) + this.sms.hashCode();
    }

    public String toString() {
        return "EnterCodeSubTitle(phone=" + this.phone + ", sms=" + this.sms + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.phone.writeToParcel(parcel, flags);
        parcel.writeString(this.sms);
    }

    public EnterCodeSubTitle(TitleWithParam phone, String sms) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(sms, "sms");
        this.phone = phone;
        this.sms = sms;
    }
}
