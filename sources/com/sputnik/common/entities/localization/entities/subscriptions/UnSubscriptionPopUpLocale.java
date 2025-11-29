package com.sputnik.common.entities.localization.entities.subscriptions;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionsLocale.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpBody;", "body", "stopSubscriptionPopup", "<init>", "(Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpBody;Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpBody;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpBody;", "getBody", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpBody;", "getStopSubscriptionPopup", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UnSubscriptionPopUpLocale implements Parcelable {
    public static final Parcelable.Creator<UnSubscriptionPopUpLocale> CREATOR = new Creator();
    private final UnSubscriptionPopUpBody body;

    @SerializedName("stop_subscription_popup")
    private final UnSubscriptionPopUpBody stopSubscriptionPopup;

    /* compiled from: SubscriptionsLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UnSubscriptionPopUpLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnSubscriptionPopUpLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UnSubscriptionPopUpLocale(parcel.readInt() == 0 ? null : UnSubscriptionPopUpBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? UnSubscriptionPopUpBody.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnSubscriptionPopUpLocale[] newArray(int i) {
            return new UnSubscriptionPopUpLocale[i];
        }
    }

    public UnSubscriptionPopUpLocale() {
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
        if (!(other instanceof UnSubscriptionPopUpLocale)) {
            return false;
        }
        UnSubscriptionPopUpLocale unSubscriptionPopUpLocale = (UnSubscriptionPopUpLocale) other;
        return Intrinsics.areEqual(this.body, unSubscriptionPopUpLocale.body) && Intrinsics.areEqual(this.stopSubscriptionPopup, unSubscriptionPopUpLocale.stopSubscriptionPopup);
    }

    public int hashCode() {
        UnSubscriptionPopUpBody unSubscriptionPopUpBody = this.body;
        int iHashCode = (unSubscriptionPopUpBody == null ? 0 : unSubscriptionPopUpBody.hashCode()) * 31;
        UnSubscriptionPopUpBody unSubscriptionPopUpBody2 = this.stopSubscriptionPopup;
        return iHashCode + (unSubscriptionPopUpBody2 != null ? unSubscriptionPopUpBody2.hashCode() : 0);
    }

    public String toString() {
        return "UnSubscriptionPopUpLocale(body=" + this.body + ", stopSubscriptionPopup=" + this.stopSubscriptionPopup + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        UnSubscriptionPopUpBody unSubscriptionPopUpBody = this.body;
        if (unSubscriptionPopUpBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            unSubscriptionPopUpBody.writeToParcel(parcel, flags);
        }
        UnSubscriptionPopUpBody unSubscriptionPopUpBody2 = this.stopSubscriptionPopup;
        if (unSubscriptionPopUpBody2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            unSubscriptionPopUpBody2.writeToParcel(parcel, flags);
        }
    }

    public UnSubscriptionPopUpLocale(UnSubscriptionPopUpBody unSubscriptionPopUpBody, UnSubscriptionPopUpBody unSubscriptionPopUpBody2) {
        this.body = unSubscriptionPopUpBody;
        this.stopSubscriptionPopup = unSubscriptionPopUpBody2;
    }

    public /* synthetic */ UnSubscriptionPopUpLocale(UnSubscriptionPopUpBody unSubscriptionPopUpBody, UnSubscriptionPopUpBody unSubscriptionPopUpBody2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : unSubscriptionPopUpBody, (i & 2) != 0 ? null : unSubscriptionPopUpBody2);
    }

    public final UnSubscriptionPopUpBody getBody() {
        return this.body;
    }
}
