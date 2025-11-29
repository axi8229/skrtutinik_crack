package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/sputnik/common/entities/localization/NotificationLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/NotificationLocaleBody;", "register", "applyDomofon", "<init>", "(Lcom/sputnik/common/entities/localization/NotificationLocaleBody;Lcom/sputnik/common/entities/localization/NotificationLocaleBody;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/NotificationLocaleBody;", "getRegister", "()Lcom/sputnik/common/entities/localization/NotificationLocaleBody;", "getApplyDomofon", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NotificationLocale implements Parcelable {
    public static final Parcelable.Creator<NotificationLocale> CREATOR = new Creator();

    @SerializedName("apply_domofon")
    private final NotificationLocaleBody applyDomofon;
    private final NotificationLocaleBody register;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NotificationLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NotificationLocale(parcel.readInt() == 0 ? null : NotificationLocaleBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? NotificationLocaleBody.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationLocale[] newArray(int i) {
            return new NotificationLocale[i];
        }
    }

    public NotificationLocale() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationLocale)) {
            return false;
        }
        NotificationLocale notificationLocale = (NotificationLocale) other;
        return Intrinsics.areEqual(this.register, notificationLocale.register) && Intrinsics.areEqual(this.applyDomofon, notificationLocale.applyDomofon);
    }

    public int hashCode() {
        NotificationLocaleBody notificationLocaleBody = this.register;
        int iHashCode = (notificationLocaleBody == null ? 0 : notificationLocaleBody.hashCode()) * 31;
        NotificationLocaleBody notificationLocaleBody2 = this.applyDomofon;
        return iHashCode + (notificationLocaleBody2 != null ? notificationLocaleBody2.hashCode() : 0);
    }

    public String toString() {
        return "NotificationLocale(register=" + this.register + ", applyDomofon=" + this.applyDomofon + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        NotificationLocaleBody notificationLocaleBody = this.register;
        if (notificationLocaleBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            notificationLocaleBody.writeToParcel(parcel, flags);
        }
        NotificationLocaleBody notificationLocaleBody2 = this.applyDomofon;
        if (notificationLocaleBody2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            notificationLocaleBody2.writeToParcel(parcel, flags);
        }
    }

    public NotificationLocale(NotificationLocaleBody notificationLocaleBody, NotificationLocaleBody notificationLocaleBody2) {
        this.register = notificationLocaleBody;
        this.applyDomofon = notificationLocaleBody2;
    }

    public /* synthetic */ NotificationLocale(NotificationLocaleBody notificationLocaleBody, NotificationLocaleBody notificationLocaleBody2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : notificationLocaleBody, (i & 2) != 0 ? null : notificationLocaleBody2);
    }

    public final NotificationLocaleBody getRegister() {
        return this.register;
    }

    public final NotificationLocaleBody getApplyDomofon() {
        return this.applyDomofon;
    }
}
