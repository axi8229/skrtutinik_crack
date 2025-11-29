package com.sputnik.common.entities.localization.entities.blocking;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWith1Param;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebtPopupLocale.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b'\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b(\u0010\u0011R\u001a\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b)\u0010&R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/blocking/DebtPopupBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "payTitleLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "argueButton", "checkTitleLabel", "partnerTitleLabel", "payButton", "Lcom/sputnik/common/entities/localization/entities/blocking/PromiseButton;", "promiseButton", "Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "offer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/blocking/PromiseButton;Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getPayTitleLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getArgueButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCheckTitleLabel", "getPartnerTitleLabel", "getPayButton", "Lcom/sputnik/common/entities/localization/entities/blocking/PromiseButton;", "getPromiseButton", "()Lcom/sputnik/common/entities/localization/entities/blocking/PromiseButton;", "Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "getOffer", "()Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DebtPopupBody implements Parcelable {
    public static final Parcelable.Creator<DebtPopupBody> CREATOR = new Creator();

    @SerializedName("argue_button")
    private final TextTitle argueButton;

    @SerializedName("check_title_label")
    private final String checkTitleLabel;
    private final TextWith1Param offer;

    @SerializedName("partner_title_label")
    private final String partnerTitleLabel;

    @SerializedName("pay_button")
    private final TextTitle payButton;

    @SerializedName("pay_title_label")
    private final String payTitleLabel;

    @SerializedName("promise_button")
    private final PromiseButton promiseButton;
    private final String title;

    /* compiled from: DebtPopupLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DebtPopupBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DebtPopupBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new DebtPopupBody(string, string2, creator.createFromParcel(parcel), parcel.readString(), parcel.readString(), creator.createFromParcel(parcel), PromiseButton.CREATOR.createFromParcel(parcel), TextWith1Param.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DebtPopupBody[] newArray(int i) {
            return new DebtPopupBody[i];
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
        if (!(other instanceof DebtPopupBody)) {
            return false;
        }
        DebtPopupBody debtPopupBody = (DebtPopupBody) other;
        return Intrinsics.areEqual(this.title, debtPopupBody.title) && Intrinsics.areEqual(this.payTitleLabel, debtPopupBody.payTitleLabel) && Intrinsics.areEqual(this.argueButton, debtPopupBody.argueButton) && Intrinsics.areEqual(this.checkTitleLabel, debtPopupBody.checkTitleLabel) && Intrinsics.areEqual(this.partnerTitleLabel, debtPopupBody.partnerTitleLabel) && Intrinsics.areEqual(this.payButton, debtPopupBody.payButton) && Intrinsics.areEqual(this.promiseButton, debtPopupBody.promiseButton) && Intrinsics.areEqual(this.offer, debtPopupBody.offer);
    }

    public int hashCode() {
        return (((((((((((((this.title.hashCode() * 31) + this.payTitleLabel.hashCode()) * 31) + this.argueButton.hashCode()) * 31) + this.checkTitleLabel.hashCode()) * 31) + this.partnerTitleLabel.hashCode()) * 31) + this.payButton.hashCode()) * 31) + this.promiseButton.hashCode()) * 31) + this.offer.hashCode();
    }

    public String toString() {
        return "DebtPopupBody(title=" + this.title + ", payTitleLabel=" + this.payTitleLabel + ", argueButton=" + this.argueButton + ", checkTitleLabel=" + this.checkTitleLabel + ", partnerTitleLabel=" + this.partnerTitleLabel + ", payButton=" + this.payButton + ", promiseButton=" + this.promiseButton + ", offer=" + this.offer + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.payTitleLabel);
        this.argueButton.writeToParcel(parcel, flags);
        parcel.writeString(this.checkTitleLabel);
        parcel.writeString(this.partnerTitleLabel);
        this.payButton.writeToParcel(parcel, flags);
        this.promiseButton.writeToParcel(parcel, flags);
        this.offer.writeToParcel(parcel, flags);
    }

    public DebtPopupBody(String title, String payTitleLabel, TextTitle argueButton, String checkTitleLabel, String partnerTitleLabel, TextTitle payButton, PromiseButton promiseButton, TextWith1Param offer) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(payTitleLabel, "payTitleLabel");
        Intrinsics.checkNotNullParameter(argueButton, "argueButton");
        Intrinsics.checkNotNullParameter(checkTitleLabel, "checkTitleLabel");
        Intrinsics.checkNotNullParameter(partnerTitleLabel, "partnerTitleLabel");
        Intrinsics.checkNotNullParameter(payButton, "payButton");
        Intrinsics.checkNotNullParameter(promiseButton, "promiseButton");
        Intrinsics.checkNotNullParameter(offer, "offer");
        this.title = title;
        this.payTitleLabel = payTitleLabel;
        this.argueButton = argueButton;
        this.checkTitleLabel = checkTitleLabel;
        this.partnerTitleLabel = partnerTitleLabel;
        this.payButton = payButton;
        this.promiseButton = promiseButton;
        this.offer = offer;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPayTitleLabel() {
        return this.payTitleLabel;
    }

    public final TextTitle getArgueButton() {
        return this.argueButton;
    }

    public final String getPartnerTitleLabel() {
        return this.partnerTitleLabel;
    }

    public final TextTitle getPayButton() {
        return this.payButton;
    }

    public final PromiseButton getPromiseButton() {
        return this.promiseButton;
    }

    public final TextWith1Param getOffer() {
        return this.offer;
    }
}
