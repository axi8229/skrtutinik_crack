package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010\u000f¨\u0006-"}, d2 = {"Lcom/sputnik/common/entities/localization/FaceRecognitionMainBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "topView", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainActionView;", "actionView", "Lcom/sputnik/common/entities/localization/TextListTitles;", "partnerView", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainSubscriptionView;", "subscriptionView", "", "infoLabel", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/FaceRecognitionMainActionView;Lcom/sputnik/common/entities/localization/TextListTitles;Lcom/sputnik/common/entities/localization/FaceRecognitionMainSubscriptionView;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getTopView", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainActionView;", "getActionView", "()Lcom/sputnik/common/entities/localization/FaceRecognitionMainActionView;", "Lcom/sputnik/common/entities/localization/TextListTitles;", "getPartnerView", "()Lcom/sputnik/common/entities/localization/TextListTitles;", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainSubscriptionView;", "getSubscriptionView", "()Lcom/sputnik/common/entities/localization/FaceRecognitionMainSubscriptionView;", "Ljava/lang/String;", "getInfoLabel", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FaceRecognitionMainBody implements Parcelable {
    public static final Parcelable.Creator<FaceRecognitionMainBody> CREATOR = new Creator();

    @SerializedName("action_view")
    private final FaceRecognitionMainActionView actionView;

    @SerializedName("info_label")
    private final String infoLabel;

    @SerializedName("partner_view")
    private final TextListTitles partnerView;

    @SerializedName("subscription_view")
    private final FaceRecognitionMainSubscriptionView subscriptionView;

    @SerializedName("top_view")
    private final TextTitle topView;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FaceRecognitionMainBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FaceRecognitionMainBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FaceRecognitionMainBody((TextTitle) parcel.readParcelable(FaceRecognitionMainBody.class.getClassLoader()), parcel.readInt() == 0 ? null : FaceRecognitionMainActionView.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextListTitles.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? FaceRecognitionMainSubscriptionView.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FaceRecognitionMainBody[] newArray(int i) {
            return new FaceRecognitionMainBody[i];
        }
    }

    public FaceRecognitionMainBody() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceRecognitionMainBody)) {
            return false;
        }
        FaceRecognitionMainBody faceRecognitionMainBody = (FaceRecognitionMainBody) other;
        return Intrinsics.areEqual(this.topView, faceRecognitionMainBody.topView) && Intrinsics.areEqual(this.actionView, faceRecognitionMainBody.actionView) && Intrinsics.areEqual(this.partnerView, faceRecognitionMainBody.partnerView) && Intrinsics.areEqual(this.subscriptionView, faceRecognitionMainBody.subscriptionView) && Intrinsics.areEqual(this.infoLabel, faceRecognitionMainBody.infoLabel);
    }

    public int hashCode() {
        TextTitle textTitle = this.topView;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        FaceRecognitionMainActionView faceRecognitionMainActionView = this.actionView;
        int iHashCode2 = (iHashCode + (faceRecognitionMainActionView == null ? 0 : faceRecognitionMainActionView.hashCode())) * 31;
        TextListTitles textListTitles = this.partnerView;
        int iHashCode3 = (iHashCode2 + (textListTitles == null ? 0 : textListTitles.hashCode())) * 31;
        FaceRecognitionMainSubscriptionView faceRecognitionMainSubscriptionView = this.subscriptionView;
        int iHashCode4 = (iHashCode3 + (faceRecognitionMainSubscriptionView == null ? 0 : faceRecognitionMainSubscriptionView.hashCode())) * 31;
        String str = this.infoLabel;
        return iHashCode4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FaceRecognitionMainBody(topView=" + this.topView + ", actionView=" + this.actionView + ", partnerView=" + this.partnerView + ", subscriptionView=" + this.subscriptionView + ", infoLabel=" + this.infoLabel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.topView, flags);
        FaceRecognitionMainActionView faceRecognitionMainActionView = this.actionView;
        if (faceRecognitionMainActionView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionMainActionView.writeToParcel(parcel, flags);
        }
        TextListTitles textListTitles = this.partnerView;
        if (textListTitles == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textListTitles.writeToParcel(parcel, flags);
        }
        FaceRecognitionMainSubscriptionView faceRecognitionMainSubscriptionView = this.subscriptionView;
        if (faceRecognitionMainSubscriptionView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionMainSubscriptionView.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.infoLabel);
    }

    public FaceRecognitionMainBody(TextTitle textTitle, FaceRecognitionMainActionView faceRecognitionMainActionView, TextListTitles textListTitles, FaceRecognitionMainSubscriptionView faceRecognitionMainSubscriptionView, String str) {
        this.topView = textTitle;
        this.actionView = faceRecognitionMainActionView;
        this.partnerView = textListTitles;
        this.subscriptionView = faceRecognitionMainSubscriptionView;
        this.infoLabel = str;
    }

    public /* synthetic */ FaceRecognitionMainBody(TextTitle textTitle, FaceRecognitionMainActionView faceRecognitionMainActionView, TextListTitles textListTitles, FaceRecognitionMainSubscriptionView faceRecognitionMainSubscriptionView, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : faceRecognitionMainActionView, (i & 4) != 0 ? null : textListTitles, (i & 8) != 0 ? null : faceRecognitionMainSubscriptionView, (i & 16) != 0 ? null : str);
    }

    public final FaceRecognitionMainActionView getActionView() {
        return this.actionView;
    }

    public final TextListTitles getPartnerView() {
        return this.partnerView;
    }

    public final FaceRecognitionMainSubscriptionView getSubscriptionView() {
        return this.subscriptionView;
    }

    public final String getInfoLabel() {
        return this.infoLabel;
    }
}
