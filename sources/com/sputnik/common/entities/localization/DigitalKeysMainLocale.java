package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b(\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b)\u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b*\u0010!¨\u0006+"}, d2 = {"Lcom/sputnik/common/entities/localization/DigitalKeysMainLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/DigitalKeysMainBody;", "body", "Lcom/sputnik/common/entities/localization/DigitalKeysPopup;", "deletePopup", "refreshPopup", "sharePopUp", "copyPopUp", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/DigitalKeysMainBody;Lcom/sputnik/common/entities/localization/DigitalKeysPopup;Lcom/sputnik/common/entities/localization/DigitalKeysPopup;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/DigitalKeysMainBody;", "getBody", "()Lcom/sputnik/common/entities/localization/DigitalKeysMainBody;", "Lcom/sputnik/common/entities/localization/DigitalKeysPopup;", "getDeletePopup", "()Lcom/sputnik/common/entities/localization/DigitalKeysPopup;", "getRefreshPopup", "getSharePopUp", "getCopyPopUp", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DigitalKeysMainLocale implements Parcelable {
    public static final Parcelable.Creator<DigitalKeysMainLocale> CREATOR = new Creator();
    private final DigitalKeysMainBody body;

    @SerializedName("copy_popup")
    private final TextTitle copyPopUp;

    @SerializedName("delete_popup")
    private final DigitalKeysPopup deletePopup;
    private final TextTitle navigation;

    @SerializedName("refresh_popup")
    private final DigitalKeysPopup refreshPopup;

    @SerializedName("share_popup")
    private final TextTitle sharePopUp;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DigitalKeysMainLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DigitalKeysMainLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DigitalKeysMainLocale((TextTitle) parcel.readParcelable(DigitalKeysMainLocale.class.getClassLoader()), parcel.readInt() == 0 ? null : DigitalKeysMainBody.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DigitalKeysPopup.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? DigitalKeysPopup.CREATOR.createFromParcel(parcel) : null, (TextTitle) parcel.readParcelable(DigitalKeysMainLocale.class.getClassLoader()), (TextTitle) parcel.readParcelable(DigitalKeysMainLocale.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DigitalKeysMainLocale[] newArray(int i) {
            return new DigitalKeysMainLocale[i];
        }
    }

    public DigitalKeysMainLocale() {
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
        if (!(other instanceof DigitalKeysMainLocale)) {
            return false;
        }
        DigitalKeysMainLocale digitalKeysMainLocale = (DigitalKeysMainLocale) other;
        return Intrinsics.areEqual(this.navigation, digitalKeysMainLocale.navigation) && Intrinsics.areEqual(this.body, digitalKeysMainLocale.body) && Intrinsics.areEqual(this.deletePopup, digitalKeysMainLocale.deletePopup) && Intrinsics.areEqual(this.refreshPopup, digitalKeysMainLocale.refreshPopup) && Intrinsics.areEqual(this.sharePopUp, digitalKeysMainLocale.sharePopUp) && Intrinsics.areEqual(this.copyPopUp, digitalKeysMainLocale.copyPopUp);
    }

    public int hashCode() {
        TextTitle textTitle = this.navigation;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        DigitalKeysMainBody digitalKeysMainBody = this.body;
        int iHashCode2 = (iHashCode + (digitalKeysMainBody == null ? 0 : digitalKeysMainBody.hashCode())) * 31;
        DigitalKeysPopup digitalKeysPopup = this.deletePopup;
        int iHashCode3 = (iHashCode2 + (digitalKeysPopup == null ? 0 : digitalKeysPopup.hashCode())) * 31;
        DigitalKeysPopup digitalKeysPopup2 = this.refreshPopup;
        int iHashCode4 = (iHashCode3 + (digitalKeysPopup2 == null ? 0 : digitalKeysPopup2.hashCode())) * 31;
        TextTitle textTitle2 = this.sharePopUp;
        int iHashCode5 = (iHashCode4 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        TextTitle textTitle3 = this.copyPopUp;
        return iHashCode5 + (textTitle3 != null ? textTitle3.hashCode() : 0);
    }

    public String toString() {
        return "DigitalKeysMainLocale(navigation=" + this.navigation + ", body=" + this.body + ", deletePopup=" + this.deletePopup + ", refreshPopup=" + this.refreshPopup + ", sharePopUp=" + this.sharePopUp + ", copyPopUp=" + this.copyPopUp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.navigation, flags);
        DigitalKeysMainBody digitalKeysMainBody = this.body;
        if (digitalKeysMainBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            digitalKeysMainBody.writeToParcel(parcel, flags);
        }
        DigitalKeysPopup digitalKeysPopup = this.deletePopup;
        if (digitalKeysPopup == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            digitalKeysPopup.writeToParcel(parcel, flags);
        }
        DigitalKeysPopup digitalKeysPopup2 = this.refreshPopup;
        if (digitalKeysPopup2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            digitalKeysPopup2.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.sharePopUp, flags);
        parcel.writeParcelable(this.copyPopUp, flags);
    }

    public DigitalKeysMainLocale(TextTitle textTitle, DigitalKeysMainBody digitalKeysMainBody, DigitalKeysPopup digitalKeysPopup, DigitalKeysPopup digitalKeysPopup2, TextTitle textTitle2, TextTitle textTitle3) {
        this.navigation = textTitle;
        this.body = digitalKeysMainBody;
        this.deletePopup = digitalKeysPopup;
        this.refreshPopup = digitalKeysPopup2;
        this.sharePopUp = textTitle2;
        this.copyPopUp = textTitle3;
    }

    public /* synthetic */ DigitalKeysMainLocale(TextTitle textTitle, DigitalKeysMainBody digitalKeysMainBody, DigitalKeysPopup digitalKeysPopup, DigitalKeysPopup digitalKeysPopup2, TextTitle textTitle2, TextTitle textTitle3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : digitalKeysMainBody, (i & 4) != 0 ? null : digitalKeysPopup, (i & 8) != 0 ? null : digitalKeysPopup2, (i & 16) != 0 ? null : textTitle2, (i & 32) != 0 ? null : textTitle3);
    }

    public final TextTitle getNavigation() {
        return this.navigation;
    }

    public final DigitalKeysMainBody getBody() {
        return this.body;
    }

    public final DigitalKeysPopup getDeletePopup() {
        return this.deletePopup;
    }

    public final DigitalKeysPopup getRefreshPopup() {
        return this.refreshPopup;
    }

    public final TextTitle getSharePopUp() {
        return this.sharePopUp;
    }

    public final TextTitle getCopyPopUp() {
        return this.copyPopUp;
    }
}
