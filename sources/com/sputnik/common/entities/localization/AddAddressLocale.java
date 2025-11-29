package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/AddAddressLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/AddAddressNavigation;", "navigation", "Lcom/sputnik/common/entities/localization/AddAddressBody;", "body", "<init>", "(Lcom/sputnik/common/entities/localization/AddAddressNavigation;Lcom/sputnik/common/entities/localization/AddAddressBody;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/AddAddressNavigation;", "getNavigation", "()Lcom/sputnik/common/entities/localization/AddAddressNavigation;", "Lcom/sputnik/common/entities/localization/AddAddressBody;", "getBody", "()Lcom/sputnik/common/entities/localization/AddAddressBody;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AddAddressLocale implements Parcelable {
    public static final Parcelable.Creator<AddAddressLocale> CREATOR = new Creator();
    private final AddAddressBody body;
    private final AddAddressNavigation navigation;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddAddressLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddAddressLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddAddressLocale(parcel.readInt() == 0 ? null : AddAddressNavigation.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? AddAddressBody.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddAddressLocale[] newArray(int i) {
            return new AddAddressLocale[i];
        }
    }

    public AddAddressLocale() {
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
        if (!(other instanceof AddAddressLocale)) {
            return false;
        }
        AddAddressLocale addAddressLocale = (AddAddressLocale) other;
        return Intrinsics.areEqual(this.navigation, addAddressLocale.navigation) && Intrinsics.areEqual(this.body, addAddressLocale.body);
    }

    public int hashCode() {
        AddAddressNavigation addAddressNavigation = this.navigation;
        int iHashCode = (addAddressNavigation == null ? 0 : addAddressNavigation.hashCode()) * 31;
        AddAddressBody addAddressBody = this.body;
        return iHashCode + (addAddressBody != null ? addAddressBody.hashCode() : 0);
    }

    public String toString() {
        return "AddAddressLocale(navigation=" + this.navigation + ", body=" + this.body + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        AddAddressNavigation addAddressNavigation = this.navigation;
        if (addAddressNavigation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            addAddressNavigation.writeToParcel(parcel, flags);
        }
        AddAddressBody addAddressBody = this.body;
        if (addAddressBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            addAddressBody.writeToParcel(parcel, flags);
        }
    }

    public AddAddressLocale(AddAddressNavigation addAddressNavigation, AddAddressBody addAddressBody) {
        this.navigation = addAddressNavigation;
        this.body = addAddressBody;
    }

    public /* synthetic */ AddAddressLocale(AddAddressNavigation addAddressNavigation, AddAddressBody addAddressBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : addAddressNavigation, (i & 2) != 0 ? null : addAddressBody);
    }

    public final AddAddressNavigation getNavigation() {
        return this.navigation;
    }

    public final AddAddressBody getBody() {
        return this.body;
    }
}
