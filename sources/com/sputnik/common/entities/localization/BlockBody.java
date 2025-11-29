package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWith1Param;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b%\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b&\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b'\u0010#R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/sputnik/common/entities/localization/BlockBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "argueButton", "checkTitleLabel", "partnerTitleLabel", "payButton", "promiseButton", "Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "offer", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getArgueButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCheckTitleLabel", "getPartnerTitleLabel", "getPayButton", "getPromiseButton", "Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "getOffer", "()Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BlockBody implements Parcelable {
    public static final Parcelable.Creator<BlockBody> CREATOR = new Creator();

    @SerializedName("argue_button")
    private final TextTitle argueButton;

    @SerializedName("check_title_label")
    private final String checkTitleLabel;
    private final TextWith1Param offer;

    @SerializedName("partner_title_label")
    private final String partnerTitleLabel;

    @SerializedName("pay_button")
    private final TextTitle payButton;

    @SerializedName("promise_button")
    private final TextTitle promiseButton;
    private final String title;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BlockBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BlockBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BlockBody(parcel.readString(), (TextTitle) parcel.readParcelable(BlockBody.class.getClassLoader()), parcel.readString(), parcel.readString(), (TextTitle) parcel.readParcelable(BlockBody.class.getClassLoader()), (TextTitle) parcel.readParcelable(BlockBody.class.getClassLoader()), (TextWith1Param) parcel.readParcelable(BlockBody.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BlockBody[] newArray(int i) {
            return new BlockBody[i];
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
        if (!(other instanceof BlockBody)) {
            return false;
        }
        BlockBody blockBody = (BlockBody) other;
        return Intrinsics.areEqual(this.title, blockBody.title) && Intrinsics.areEqual(this.argueButton, blockBody.argueButton) && Intrinsics.areEqual(this.checkTitleLabel, blockBody.checkTitleLabel) && Intrinsics.areEqual(this.partnerTitleLabel, blockBody.partnerTitleLabel) && Intrinsics.areEqual(this.payButton, blockBody.payButton) && Intrinsics.areEqual(this.promiseButton, blockBody.promiseButton) && Intrinsics.areEqual(this.offer, blockBody.offer);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        TextTitle textTitle = this.argueButton;
        int iHashCode2 = (iHashCode + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        String str2 = this.checkTitleLabel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.partnerTitleLabel;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        TextTitle textTitle2 = this.payButton;
        int iHashCode5 = (iHashCode4 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        TextTitle textTitle3 = this.promiseButton;
        return ((iHashCode5 + (textTitle3 != null ? textTitle3.hashCode() : 0)) * 31) + this.offer.hashCode();
    }

    public String toString() {
        return "BlockBody(title=" + this.title + ", argueButton=" + this.argueButton + ", checkTitleLabel=" + this.checkTitleLabel + ", partnerTitleLabel=" + this.partnerTitleLabel + ", payButton=" + this.payButton + ", promiseButton=" + this.promiseButton + ", offer=" + this.offer + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.argueButton, flags);
        parcel.writeString(this.checkTitleLabel);
        parcel.writeString(this.partnerTitleLabel);
        parcel.writeParcelable(this.payButton, flags);
        parcel.writeParcelable(this.promiseButton, flags);
        parcel.writeParcelable(this.offer, flags);
    }

    public BlockBody(String str, TextTitle textTitle, String str2, String str3, TextTitle textTitle2, TextTitle textTitle3, TextWith1Param offer) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        this.title = str;
        this.argueButton = textTitle;
        this.checkTitleLabel = str2;
        this.partnerTitleLabel = str3;
        this.payButton = textTitle2;
        this.promiseButton = textTitle3;
        this.offer = offer;
    }

    public final String getTitle() {
        return this.title;
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

    public final TextTitle getPromiseButton() {
        return this.promiseButton;
    }
}
