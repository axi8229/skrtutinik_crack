package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/CountryPickerLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/CountryPickerBody;", "body", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/CountryPickerBody;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/CountryPickerBody;", "getBody", "()Lcom/sputnik/common/entities/localization/CountryPickerBody;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CountryPickerLocale implements Parcelable {
    public static final Parcelable.Creator<CountryPickerLocale> CREATOR = new Creator();
    private final CountryPickerBody body;
    private final TextTitle navigation;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CountryPickerLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CountryPickerLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CountryPickerLocale((TextTitle) parcel.readParcelable(CountryPickerLocale.class.getClassLoader()), parcel.readInt() == 0 ? null : CountryPickerBody.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CountryPickerLocale[] newArray(int i) {
            return new CountryPickerLocale[i];
        }
    }

    public CountryPickerLocale() {
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
        if (!(other instanceof CountryPickerLocale)) {
            return false;
        }
        CountryPickerLocale countryPickerLocale = (CountryPickerLocale) other;
        return Intrinsics.areEqual(this.navigation, countryPickerLocale.navigation) && Intrinsics.areEqual(this.body, countryPickerLocale.body);
    }

    public int hashCode() {
        TextTitle textTitle = this.navigation;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        CountryPickerBody countryPickerBody = this.body;
        return iHashCode + (countryPickerBody != null ? countryPickerBody.hashCode() : 0);
    }

    public String toString() {
        return "CountryPickerLocale(navigation=" + this.navigation + ", body=" + this.body + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.navigation, flags);
        CountryPickerBody countryPickerBody = this.body;
        if (countryPickerBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            countryPickerBody.writeToParcel(parcel, flags);
        }
    }

    public CountryPickerLocale(TextTitle textTitle, CountryPickerBody countryPickerBody) {
        this.navigation = textTitle;
        this.body = countryPickerBody;
    }

    public /* synthetic */ CountryPickerLocale(TextTitle textTitle, CountryPickerBody countryPickerBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : countryPickerBody);
    }

    public final TextTitle getNavigation() {
        return this.navigation;
    }

    public final CountryPickerBody getBody() {
        return this.body;
    }
}
