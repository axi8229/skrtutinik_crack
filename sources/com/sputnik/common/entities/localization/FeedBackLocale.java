package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/sputnik/common/entities/localization/FeedBackLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/FeedBackNavigation;", "navigation", "Lcom/sputnik/common/entities/localization/FeedBackBody;", "body", "Lcom/sputnik/common/entities/localization/Popup1;", "popup1", "Lcom/sputnik/common/entities/localization/Popup2;", "popup2", "<init>", "(Lcom/sputnik/common/entities/localization/FeedBackNavigation;Lcom/sputnik/common/entities/localization/FeedBackBody;Lcom/sputnik/common/entities/localization/Popup1;Lcom/sputnik/common/entities/localization/Popup2;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/FeedBackNavigation;", "getNavigation", "()Lcom/sputnik/common/entities/localization/FeedBackNavigation;", "Lcom/sputnik/common/entities/localization/FeedBackBody;", "getBody", "()Lcom/sputnik/common/entities/localization/FeedBackBody;", "Lcom/sputnik/common/entities/localization/Popup1;", "getPopup1", "()Lcom/sputnik/common/entities/localization/Popup1;", "Lcom/sputnik/common/entities/localization/Popup2;", "getPopup2", "()Lcom/sputnik/common/entities/localization/Popup2;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FeedBackLocale implements Parcelable {
    public static final Parcelable.Creator<FeedBackLocale> CREATOR = new Creator();
    private final FeedBackBody body;
    private final FeedBackNavigation navigation;
    private final Popup1 popup1;
    private final Popup2 popup2;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FeedBackLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeedBackLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeedBackLocale(parcel.readInt() == 0 ? null : FeedBackNavigation.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FeedBackBody.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Popup1.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Popup2.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeedBackLocale[] newArray(int i) {
            return new FeedBackLocale[i];
        }
    }

    public FeedBackLocale() {
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
        if (!(other instanceof FeedBackLocale)) {
            return false;
        }
        FeedBackLocale feedBackLocale = (FeedBackLocale) other;
        return Intrinsics.areEqual(this.navigation, feedBackLocale.navigation) && Intrinsics.areEqual(this.body, feedBackLocale.body) && Intrinsics.areEqual(this.popup1, feedBackLocale.popup1) && Intrinsics.areEqual(this.popup2, feedBackLocale.popup2);
    }

    public int hashCode() {
        FeedBackNavigation feedBackNavigation = this.navigation;
        int iHashCode = (feedBackNavigation == null ? 0 : feedBackNavigation.hashCode()) * 31;
        FeedBackBody feedBackBody = this.body;
        int iHashCode2 = (iHashCode + (feedBackBody == null ? 0 : feedBackBody.hashCode())) * 31;
        Popup1 popup1 = this.popup1;
        int iHashCode3 = (iHashCode2 + (popup1 == null ? 0 : popup1.hashCode())) * 31;
        Popup2 popup2 = this.popup2;
        return iHashCode3 + (popup2 != null ? popup2.hashCode() : 0);
    }

    public String toString() {
        return "FeedBackLocale(navigation=" + this.navigation + ", body=" + this.body + ", popup1=" + this.popup1 + ", popup2=" + this.popup2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        FeedBackNavigation feedBackNavigation = this.navigation;
        if (feedBackNavigation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            feedBackNavigation.writeToParcel(parcel, flags);
        }
        FeedBackBody feedBackBody = this.body;
        if (feedBackBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            feedBackBody.writeToParcel(parcel, flags);
        }
        Popup1 popup1 = this.popup1;
        if (popup1 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            popup1.writeToParcel(parcel, flags);
        }
        Popup2 popup2 = this.popup2;
        if (popup2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            popup2.writeToParcel(parcel, flags);
        }
    }

    public FeedBackLocale(FeedBackNavigation feedBackNavigation, FeedBackBody feedBackBody, Popup1 popup1, Popup2 popup2) {
        this.navigation = feedBackNavigation;
        this.body = feedBackBody;
        this.popup1 = popup1;
        this.popup2 = popup2;
    }

    public /* synthetic */ FeedBackLocale(FeedBackNavigation feedBackNavigation, FeedBackBody feedBackBody, Popup1 popup1, Popup2 popup2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : feedBackNavigation, (i & 2) != 0 ? null : feedBackBody, (i & 4) != 0 ? null : popup1, (i & 8) != 0 ? null : popup2);
    }

    public final FeedBackNavigation getNavigation() {
        return this.navigation;
    }

    public final FeedBackBody getBody() {
        return this.body;
    }

    public final Popup1 getPopup1() {
        return this.popup1;
    }

    public final Popup2 getPopup2() {
        return this.popup2;
    }
}
