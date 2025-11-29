package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b2\u0010\u0012R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b3\u0010$¨\u00064"}, d2 = {"Lcom/sputnik/common/entities/localization/DigitalKeysMainBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "topView", "Lcom/sputnik/common/entities/localization/DigitalKeysMainActionView;", "actionView", "Lcom/sputnik/common/entities/localization/DigitalKeysMainKeyView;", "keyView", "Lcom/sputnik/common/entities/localization/TextListTitles;", "partnerView", "Lcom/sputnik/common/entities/localization/DigitalKeysMainSubscriptionView;", "subscriptionView", "", "infoLabel", "attentionView", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/DigitalKeysMainActionView;Lcom/sputnik/common/entities/localization/DigitalKeysMainKeyView;Lcom/sputnik/common/entities/localization/TextListTitles;Lcom/sputnik/common/entities/localization/DigitalKeysMainSubscriptionView;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getTopView", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/DigitalKeysMainActionView;", "getActionView", "()Lcom/sputnik/common/entities/localization/DigitalKeysMainActionView;", "Lcom/sputnik/common/entities/localization/DigitalKeysMainKeyView;", "getKeyView", "()Lcom/sputnik/common/entities/localization/DigitalKeysMainKeyView;", "Lcom/sputnik/common/entities/localization/TextListTitles;", "getPartnerView", "()Lcom/sputnik/common/entities/localization/TextListTitles;", "Lcom/sputnik/common/entities/localization/DigitalKeysMainSubscriptionView;", "getSubscriptionView", "()Lcom/sputnik/common/entities/localization/DigitalKeysMainSubscriptionView;", "Ljava/lang/String;", "getInfoLabel", "getAttentionView", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DigitalKeysMainBody implements Parcelable {
    public static final Parcelable.Creator<DigitalKeysMainBody> CREATOR = new Creator();

    @SerializedName("action_view")
    private final DigitalKeysMainActionView actionView;

    @SerializedName("attention_view")
    private final TextTitle attentionView;

    @SerializedName("info_label")
    private final String infoLabel;

    @SerializedName("key_view")
    private final DigitalKeysMainKeyView keyView;

    @SerializedName("partner_view")
    private final TextListTitles partnerView;

    @SerializedName("subscription_view")
    private final DigitalKeysMainSubscriptionView subscriptionView;

    @SerializedName("top_view")
    private final TextTitle topView;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DigitalKeysMainBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DigitalKeysMainBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DigitalKeysMainBody((TextTitle) parcel.readParcelable(DigitalKeysMainBody.class.getClassLoader()), parcel.readInt() == 0 ? null : DigitalKeysMainActionView.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DigitalKeysMainKeyView.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextListTitles.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? DigitalKeysMainSubscriptionView.CREATOR.createFromParcel(parcel) : null, parcel.readString(), (TextTitle) parcel.readParcelable(DigitalKeysMainBody.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DigitalKeysMainBody[] newArray(int i) {
            return new DigitalKeysMainBody[i];
        }
    }

    public DigitalKeysMainBody() {
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
        if (!(other instanceof DigitalKeysMainBody)) {
            return false;
        }
        DigitalKeysMainBody digitalKeysMainBody = (DigitalKeysMainBody) other;
        return Intrinsics.areEqual(this.topView, digitalKeysMainBody.topView) && Intrinsics.areEqual(this.actionView, digitalKeysMainBody.actionView) && Intrinsics.areEqual(this.keyView, digitalKeysMainBody.keyView) && Intrinsics.areEqual(this.partnerView, digitalKeysMainBody.partnerView) && Intrinsics.areEqual(this.subscriptionView, digitalKeysMainBody.subscriptionView) && Intrinsics.areEqual(this.infoLabel, digitalKeysMainBody.infoLabel) && Intrinsics.areEqual(this.attentionView, digitalKeysMainBody.attentionView);
    }

    public int hashCode() {
        TextTitle textTitle = this.topView;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        DigitalKeysMainActionView digitalKeysMainActionView = this.actionView;
        int iHashCode2 = (iHashCode + (digitalKeysMainActionView == null ? 0 : digitalKeysMainActionView.hashCode())) * 31;
        DigitalKeysMainKeyView digitalKeysMainKeyView = this.keyView;
        int iHashCode3 = (iHashCode2 + (digitalKeysMainKeyView == null ? 0 : digitalKeysMainKeyView.hashCode())) * 31;
        TextListTitles textListTitles = this.partnerView;
        int iHashCode4 = (iHashCode3 + (textListTitles == null ? 0 : textListTitles.hashCode())) * 31;
        DigitalKeysMainSubscriptionView digitalKeysMainSubscriptionView = this.subscriptionView;
        int iHashCode5 = (iHashCode4 + (digitalKeysMainSubscriptionView == null ? 0 : digitalKeysMainSubscriptionView.hashCode())) * 31;
        String str = this.infoLabel;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        TextTitle textTitle2 = this.attentionView;
        return iHashCode6 + (textTitle2 != null ? textTitle2.hashCode() : 0);
    }

    public String toString() {
        return "DigitalKeysMainBody(topView=" + this.topView + ", actionView=" + this.actionView + ", keyView=" + this.keyView + ", partnerView=" + this.partnerView + ", subscriptionView=" + this.subscriptionView + ", infoLabel=" + this.infoLabel + ", attentionView=" + this.attentionView + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.topView, flags);
        DigitalKeysMainActionView digitalKeysMainActionView = this.actionView;
        if (digitalKeysMainActionView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            digitalKeysMainActionView.writeToParcel(parcel, flags);
        }
        DigitalKeysMainKeyView digitalKeysMainKeyView = this.keyView;
        if (digitalKeysMainKeyView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            digitalKeysMainKeyView.writeToParcel(parcel, flags);
        }
        TextListTitles textListTitles = this.partnerView;
        if (textListTitles == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textListTitles.writeToParcel(parcel, flags);
        }
        DigitalKeysMainSubscriptionView digitalKeysMainSubscriptionView = this.subscriptionView;
        if (digitalKeysMainSubscriptionView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            digitalKeysMainSubscriptionView.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.infoLabel);
        parcel.writeParcelable(this.attentionView, flags);
    }

    public DigitalKeysMainBody(TextTitle textTitle, DigitalKeysMainActionView digitalKeysMainActionView, DigitalKeysMainKeyView digitalKeysMainKeyView, TextListTitles textListTitles, DigitalKeysMainSubscriptionView digitalKeysMainSubscriptionView, String str, TextTitle textTitle2) {
        this.topView = textTitle;
        this.actionView = digitalKeysMainActionView;
        this.keyView = digitalKeysMainKeyView;
        this.partnerView = textListTitles;
        this.subscriptionView = digitalKeysMainSubscriptionView;
        this.infoLabel = str;
        this.attentionView = textTitle2;
    }

    public /* synthetic */ DigitalKeysMainBody(TextTitle textTitle, DigitalKeysMainActionView digitalKeysMainActionView, DigitalKeysMainKeyView digitalKeysMainKeyView, TextListTitles textListTitles, DigitalKeysMainSubscriptionView digitalKeysMainSubscriptionView, String str, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : digitalKeysMainActionView, (i & 4) != 0 ? null : digitalKeysMainKeyView, (i & 8) != 0 ? null : textListTitles, (i & 16) != 0 ? null : digitalKeysMainSubscriptionView, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : textTitle2);
    }

    public final DigitalKeysMainActionView getActionView() {
        return this.actionView;
    }

    public final DigitalKeysMainKeyView getKeyView() {
        return this.keyView;
    }

    public final TextListTitles getPartnerView() {
        return this.partnerView;
    }

    public final DigitalKeysMainSubscriptionView getSubscriptionView() {
        return this.subscriptionView;
    }

    public final String getInfoLabel() {
        return this.infoLabel;
    }

    public final TextTitle getAttentionView() {
        return this.attentionView;
    }
}
