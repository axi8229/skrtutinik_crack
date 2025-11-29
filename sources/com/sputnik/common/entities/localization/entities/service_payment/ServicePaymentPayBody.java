package com.sputnik.common.entities.localization.entities.service_payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentPayLocale.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b!\u0010\fR\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentPayBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/service_payment/CheckBlock;", "checkBlock", "sumLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "payButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/service_payment/CheckBlock;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/service_payment/CheckBlock;", "getCheckBlock", "()Lcom/sputnik/common/entities/localization/entities/service_payment/CheckBlock;", "getSumLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getPayButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServicePaymentPayBody implements Parcelable {
    public static final Parcelable.Creator<ServicePaymentPayBody> CREATOR = new Creator();

    @SerializedName("check_block")
    private final CheckBlock checkBlock;

    @SerializedName("pay_button")
    private final TextTitle payButton;

    @SerializedName("sum_label")
    private final String sumLabel;
    private final String title;

    /* compiled from: ServicePaymentPayLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ServicePaymentPayBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentPayBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ServicePaymentPayBody(parcel.readString(), CheckBlock.CREATOR.createFromParcel(parcel), parcel.readString(), TextTitle.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentPayBody[] newArray(int i) {
            return new ServicePaymentPayBody[i];
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
        if (!(other instanceof ServicePaymentPayBody)) {
            return false;
        }
        ServicePaymentPayBody servicePaymentPayBody = (ServicePaymentPayBody) other;
        return Intrinsics.areEqual(this.title, servicePaymentPayBody.title) && Intrinsics.areEqual(this.checkBlock, servicePaymentPayBody.checkBlock) && Intrinsics.areEqual(this.sumLabel, servicePaymentPayBody.sumLabel) && Intrinsics.areEqual(this.payButton, servicePaymentPayBody.payButton);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.checkBlock.hashCode()) * 31) + this.sumLabel.hashCode()) * 31) + this.payButton.hashCode();
    }

    public String toString() {
        return "ServicePaymentPayBody(title=" + this.title + ", checkBlock=" + this.checkBlock + ", sumLabel=" + this.sumLabel + ", payButton=" + this.payButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        this.checkBlock.writeToParcel(parcel, flags);
        parcel.writeString(this.sumLabel);
        this.payButton.writeToParcel(parcel, flags);
    }

    public ServicePaymentPayBody(String title, CheckBlock checkBlock, String sumLabel, TextTitle payButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(checkBlock, "checkBlock");
        Intrinsics.checkNotNullParameter(sumLabel, "sumLabel");
        Intrinsics.checkNotNullParameter(payButton, "payButton");
        this.title = title;
        this.checkBlock = checkBlock;
        this.sumLabel = sumLabel;
        this.payButton = payButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CheckBlock getCheckBlock() {
        return this.checkBlock;
    }

    public final String getSumLabel() {
        return this.sumLabel;
    }

    public final TextTitle getPayButton() {
        return this.payButton;
    }
}
