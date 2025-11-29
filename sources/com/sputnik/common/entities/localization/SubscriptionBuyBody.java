package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/sputnik/common/entities/localization/SubscriptionBuyBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "buyButton", "Lcom/sputnik/common/entities/localization/SubscriptionLicense;", "license", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/SubscriptionLicense;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getBuyButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/SubscriptionLicense;", "getLicense", "()Lcom/sputnik/common/entities/localization/SubscriptionLicense;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubscriptionBuyBody implements Parcelable {
    public static final Parcelable.Creator<SubscriptionBuyBody> CREATOR = new Creator();

    @SerializedName("buy_button")
    private final TextTitle buyButton;
    private final SubscriptionLicense license;
    private final String title;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionBuyBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubscriptionBuyBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubscriptionBuyBody(parcel.readString(), (TextTitle) parcel.readParcelable(SubscriptionBuyBody.class.getClassLoader()), parcel.readInt() == 0 ? null : SubscriptionLicense.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubscriptionBuyBody[] newArray(int i) {
            return new SubscriptionBuyBody[i];
        }
    }

    public SubscriptionBuyBody() {
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
        if (!(other instanceof SubscriptionBuyBody)) {
            return false;
        }
        SubscriptionBuyBody subscriptionBuyBody = (SubscriptionBuyBody) other;
        return Intrinsics.areEqual(this.title, subscriptionBuyBody.title) && Intrinsics.areEqual(this.buyButton, subscriptionBuyBody.buyButton) && Intrinsics.areEqual(this.license, subscriptionBuyBody.license);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        TextTitle textTitle = this.buyButton;
        int iHashCode2 = (iHashCode + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        SubscriptionLicense subscriptionLicense = this.license;
        return iHashCode2 + (subscriptionLicense != null ? subscriptionLicense.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionBuyBody(title=" + this.title + ", buyButton=" + this.buyButton + ", license=" + this.license + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.buyButton, flags);
        SubscriptionLicense subscriptionLicense = this.license;
        if (subscriptionLicense == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            subscriptionLicense.writeToParcel(parcel, flags);
        }
    }

    public SubscriptionBuyBody(String str, TextTitle textTitle, SubscriptionLicense subscriptionLicense) {
        this.title = str;
        this.buyButton = textTitle;
        this.license = subscriptionLicense;
    }

    public /* synthetic */ SubscriptionBuyBody(String str, TextTitle textTitle, SubscriptionLicense subscriptionLicense, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : textTitle, (i & 4) != 0 ? null : subscriptionLicense);
    }

    public final TextTitle getBuyButton() {
        return this.buyButton;
    }

    public final SubscriptionLicense getLicense() {
        return this.license;
    }
}
