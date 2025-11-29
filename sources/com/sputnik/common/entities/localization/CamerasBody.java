package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b&\u0010\"R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0010R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b,\u0010\u0010R\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b-\u0010\u0010¨\u0006."}, d2 = {"Lcom/sputnik/common/entities/localization/CamerasBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "loader", "Lcom/sputnik/common/entities/localization/TextSubtitle;", "noCameras", "listButton", "Lcom/sputnik/common/entities/localization/CamerasDoor;", "doorLabels", "", "btnPromoWantMore", "onboarding", "locked", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/TextSubtitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/CamerasDoor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getLoader", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/TextSubtitle;", "getNoCameras", "()Lcom/sputnik/common/entities/localization/TextSubtitle;", "getListButton", "Lcom/sputnik/common/entities/localization/CamerasDoor;", "getDoorLabels", "()Lcom/sputnik/common/entities/localization/CamerasDoor;", "Ljava/lang/String;", "getBtnPromoWantMore", "getOnboarding", "getLocked", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CamerasBody implements Parcelable {
    public static final Parcelable.Creator<CamerasBody> CREATOR = new Creator();

    @SerializedName("btn_promo_want_more")
    private final String btnPromoWantMore;

    @SerializedName("door_label")
    private final CamerasDoor doorLabels;

    @SerializedName("live_button")
    private final TextTitle listButton;
    private final TextTitle loader;
    private final String locked;

    @SerializedName("no_cameras")
    private final TextSubtitle noCameras;
    private final String onboarding;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CamerasBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CamerasBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CamerasBody((TextTitle) parcel.readParcelable(CamerasBody.class.getClassLoader()), parcel.readInt() == 0 ? null : TextSubtitle.CREATOR.createFromParcel(parcel), (TextTitle) parcel.readParcelable(CamerasBody.class.getClassLoader()), parcel.readInt() != 0 ? CamerasDoor.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CamerasBody[] newArray(int i) {
            return new CamerasBody[i];
        }
    }

    public CamerasBody() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CamerasBody)) {
            return false;
        }
        CamerasBody camerasBody = (CamerasBody) other;
        return Intrinsics.areEqual(this.loader, camerasBody.loader) && Intrinsics.areEqual(this.noCameras, camerasBody.noCameras) && Intrinsics.areEqual(this.listButton, camerasBody.listButton) && Intrinsics.areEqual(this.doorLabels, camerasBody.doorLabels) && Intrinsics.areEqual(this.btnPromoWantMore, camerasBody.btnPromoWantMore) && Intrinsics.areEqual(this.onboarding, camerasBody.onboarding) && Intrinsics.areEqual(this.locked, camerasBody.locked);
    }

    public int hashCode() {
        TextTitle textTitle = this.loader;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        TextSubtitle textSubtitle = this.noCameras;
        int iHashCode2 = (iHashCode + (textSubtitle == null ? 0 : textSubtitle.hashCode())) * 31;
        TextTitle textTitle2 = this.listButton;
        int iHashCode3 = (iHashCode2 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        CamerasDoor camerasDoor = this.doorLabels;
        int iHashCode4 = (iHashCode3 + (camerasDoor == null ? 0 : camerasDoor.hashCode())) * 31;
        String str = this.btnPromoWantMore;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.onboarding;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.locked;
        return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "CamerasBody(loader=" + this.loader + ", noCameras=" + this.noCameras + ", listButton=" + this.listButton + ", doorLabels=" + this.doorLabels + ", btnPromoWantMore=" + this.btnPromoWantMore + ", onboarding=" + this.onboarding + ", locked=" + this.locked + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.loader, flags);
        TextSubtitle textSubtitle = this.noCameras;
        if (textSubtitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textSubtitle.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.listButton, flags);
        CamerasDoor camerasDoor = this.doorLabels;
        if (camerasDoor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            camerasDoor.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.btnPromoWantMore);
        parcel.writeString(this.onboarding);
        parcel.writeString(this.locked);
    }

    public CamerasBody(TextTitle textTitle, TextSubtitle textSubtitle, TextTitle textTitle2, CamerasDoor camerasDoor, String str, String str2, String str3) {
        this.loader = textTitle;
        this.noCameras = textSubtitle;
        this.listButton = textTitle2;
        this.doorLabels = camerasDoor;
        this.btnPromoWantMore = str;
        this.onboarding = str2;
        this.locked = str3;
    }

    public /* synthetic */ CamerasBody(TextTitle textTitle, TextSubtitle textSubtitle, TextTitle textTitle2, CamerasDoor camerasDoor, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : textSubtitle, (i & 4) != 0 ? null : textTitle2, (i & 8) != 0 ? null : camerasDoor, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3);
    }

    public final TextTitle getLoader() {
        return this.loader;
    }

    public final CamerasDoor getDoorLabels() {
        return this.doorLabels;
    }

    public final String getOnboarding() {
        return this.onboarding;
    }

    public final String getLocked() {
        return this.locked;
    }
}
