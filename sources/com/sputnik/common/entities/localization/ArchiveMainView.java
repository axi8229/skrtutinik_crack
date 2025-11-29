package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010\u000eR\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b)\u0010\u000e¨\u0006*"}, d2 = {"Lcom/sputnik/common/entities/localization/ArchiveMainView;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/ArchiveMainButtonTitles;", "actionView", "Lcom/sputnik/common/entities/localization/TextListTitles;", "partnerView", "Lcom/sputnik/common/entities/localization/ArchiveMainSubscriptionView;", "subscriptionView", "", "infoLabel", "error", "<init>", "(Lcom/sputnik/common/entities/localization/ArchiveMainButtonTitles;Lcom/sputnik/common/entities/localization/TextListTitles;Lcom/sputnik/common/entities/localization/ArchiveMainSubscriptionView;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/ArchiveMainButtonTitles;", "getActionView", "()Lcom/sputnik/common/entities/localization/ArchiveMainButtonTitles;", "Lcom/sputnik/common/entities/localization/TextListTitles;", "getPartnerView", "()Lcom/sputnik/common/entities/localization/TextListTitles;", "Lcom/sputnik/common/entities/localization/ArchiveMainSubscriptionView;", "getSubscriptionView", "()Lcom/sputnik/common/entities/localization/ArchiveMainSubscriptionView;", "Ljava/lang/String;", "getInfoLabel", "getError", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ArchiveMainView implements Parcelable {
    public static final Parcelable.Creator<ArchiveMainView> CREATOR = new Creator();

    @SerializedName("action_view")
    private final ArchiveMainButtonTitles actionView;
    private final String error;

    @SerializedName("info_label")
    private final String infoLabel;

    @SerializedName("partner_view")
    private final TextListTitles partnerView;

    @SerializedName("subscription_view")
    private final ArchiveMainSubscriptionView subscriptionView;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ArchiveMainView> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArchiveMainView createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ArchiveMainView(parcel.readInt() == 0 ? null : ArchiveMainButtonTitles.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextListTitles.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ArchiveMainSubscriptionView.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArchiveMainView[] newArray(int i) {
            return new ArchiveMainView[i];
        }
    }

    public ArchiveMainView() {
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
        if (!(other instanceof ArchiveMainView)) {
            return false;
        }
        ArchiveMainView archiveMainView = (ArchiveMainView) other;
        return Intrinsics.areEqual(this.actionView, archiveMainView.actionView) && Intrinsics.areEqual(this.partnerView, archiveMainView.partnerView) && Intrinsics.areEqual(this.subscriptionView, archiveMainView.subscriptionView) && Intrinsics.areEqual(this.infoLabel, archiveMainView.infoLabel) && Intrinsics.areEqual(this.error, archiveMainView.error);
    }

    public int hashCode() {
        ArchiveMainButtonTitles archiveMainButtonTitles = this.actionView;
        int iHashCode = (archiveMainButtonTitles == null ? 0 : archiveMainButtonTitles.hashCode()) * 31;
        TextListTitles textListTitles = this.partnerView;
        int iHashCode2 = (iHashCode + (textListTitles == null ? 0 : textListTitles.hashCode())) * 31;
        ArchiveMainSubscriptionView archiveMainSubscriptionView = this.subscriptionView;
        int iHashCode3 = (iHashCode2 + (archiveMainSubscriptionView == null ? 0 : archiveMainSubscriptionView.hashCode())) * 31;
        String str = this.infoLabel;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.error;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ArchiveMainView(actionView=" + this.actionView + ", partnerView=" + this.partnerView + ", subscriptionView=" + this.subscriptionView + ", infoLabel=" + this.infoLabel + ", error=" + this.error + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ArchiveMainButtonTitles archiveMainButtonTitles = this.actionView;
        if (archiveMainButtonTitles == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            archiveMainButtonTitles.writeToParcel(parcel, flags);
        }
        TextListTitles textListTitles = this.partnerView;
        if (textListTitles == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textListTitles.writeToParcel(parcel, flags);
        }
        ArchiveMainSubscriptionView archiveMainSubscriptionView = this.subscriptionView;
        if (archiveMainSubscriptionView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            archiveMainSubscriptionView.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.infoLabel);
        parcel.writeString(this.error);
    }

    public ArchiveMainView(ArchiveMainButtonTitles archiveMainButtonTitles, TextListTitles textListTitles, ArchiveMainSubscriptionView archiveMainSubscriptionView, String str, String str2) {
        this.actionView = archiveMainButtonTitles;
        this.partnerView = textListTitles;
        this.subscriptionView = archiveMainSubscriptionView;
        this.infoLabel = str;
        this.error = str2;
    }

    public /* synthetic */ ArchiveMainView(ArchiveMainButtonTitles archiveMainButtonTitles, TextListTitles textListTitles, ArchiveMainSubscriptionView archiveMainSubscriptionView, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : archiveMainButtonTitles, (i & 2) != 0 ? null : textListTitles, (i & 4) != 0 ? null : archiveMainSubscriptionView, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }

    public final ArchiveMainButtonTitles getActionView() {
        return this.actionView;
    }

    public final TextListTitles getPartnerView() {
        return this.partnerView;
    }

    public final ArchiveMainSubscriptionView getSubscriptionView() {
        return this.subscriptionView;
    }

    public final String getInfoLabel() {
        return this.infoLabel;
    }

    public final String getError() {
        return this.error;
    }
}
