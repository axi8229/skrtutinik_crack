package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/FaceRecognitionMainLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainBody;", "body", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainRemovePopUp;", "removePopup", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/FaceRecognitionMainBody;Lcom/sputnik/common/entities/localization/FaceRecognitionMainRemovePopUp;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainBody;", "getBody", "()Lcom/sputnik/common/entities/localization/FaceRecognitionMainBody;", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainRemovePopUp;", "getRemovePopup", "()Lcom/sputnik/common/entities/localization/FaceRecognitionMainRemovePopUp;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FaceRecognitionMainLocale implements Parcelable {
    public static final Parcelable.Creator<FaceRecognitionMainLocale> CREATOR = new Creator();
    private final FaceRecognitionMainBody body;
    private final TextTitle navigation;

    @SerializedName("remove_popup")
    private final FaceRecognitionMainRemovePopUp removePopup;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FaceRecognitionMainLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FaceRecognitionMainLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FaceRecognitionMainLocale((TextTitle) parcel.readParcelable(FaceRecognitionMainLocale.class.getClassLoader()), parcel.readInt() == 0 ? null : FaceRecognitionMainBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? FaceRecognitionMainRemovePopUp.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FaceRecognitionMainLocale[] newArray(int i) {
            return new FaceRecognitionMainLocale[i];
        }
    }

    public FaceRecognitionMainLocale() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceRecognitionMainLocale)) {
            return false;
        }
        FaceRecognitionMainLocale faceRecognitionMainLocale = (FaceRecognitionMainLocale) other;
        return Intrinsics.areEqual(this.navigation, faceRecognitionMainLocale.navigation) && Intrinsics.areEqual(this.body, faceRecognitionMainLocale.body) && Intrinsics.areEqual(this.removePopup, faceRecognitionMainLocale.removePopup);
    }

    public int hashCode() {
        TextTitle textTitle = this.navigation;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        FaceRecognitionMainBody faceRecognitionMainBody = this.body;
        int iHashCode2 = (iHashCode + (faceRecognitionMainBody == null ? 0 : faceRecognitionMainBody.hashCode())) * 31;
        FaceRecognitionMainRemovePopUp faceRecognitionMainRemovePopUp = this.removePopup;
        return iHashCode2 + (faceRecognitionMainRemovePopUp != null ? faceRecognitionMainRemovePopUp.hashCode() : 0);
    }

    public String toString() {
        return "FaceRecognitionMainLocale(navigation=" + this.navigation + ", body=" + this.body + ", removePopup=" + this.removePopup + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.navigation, flags);
        FaceRecognitionMainBody faceRecognitionMainBody = this.body;
        if (faceRecognitionMainBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionMainBody.writeToParcel(parcel, flags);
        }
        FaceRecognitionMainRemovePopUp faceRecognitionMainRemovePopUp = this.removePopup;
        if (faceRecognitionMainRemovePopUp == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionMainRemovePopUp.writeToParcel(parcel, flags);
        }
    }

    public FaceRecognitionMainLocale(TextTitle textTitle, FaceRecognitionMainBody faceRecognitionMainBody, FaceRecognitionMainRemovePopUp faceRecognitionMainRemovePopUp) {
        this.navigation = textTitle;
        this.body = faceRecognitionMainBody;
        this.removePopup = faceRecognitionMainRemovePopUp;
    }

    public /* synthetic */ FaceRecognitionMainLocale(TextTitle textTitle, FaceRecognitionMainBody faceRecognitionMainBody, FaceRecognitionMainRemovePopUp faceRecognitionMainRemovePopUp, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : faceRecognitionMainBody, (i & 4) != 0 ? null : faceRecognitionMainRemovePopUp);
    }

    public final TextTitle getNavigation() {
        return this.navigation;
    }

    public final FaceRecognitionMainBody getBody() {
        return this.body;
    }

    public final FaceRecognitionMainRemovePopUp getRemovePopup() {
        return this.removePopup;
    }
}
