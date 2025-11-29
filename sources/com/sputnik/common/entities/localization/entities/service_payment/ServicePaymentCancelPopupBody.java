package com.sputnik.common.entities.localization.entities.service_payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentCancelPopupLocale.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentCancelPopupBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "continueUseButton", "stopButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "getSubtitle", "()Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getContinueUseButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getStopButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServicePaymentCancelPopupBody implements Parcelable {
    public static final Parcelable.Creator<ServicePaymentCancelPopupBody> CREATOR = new Creator();

    @SerializedName("continue_use_button")
    private final TextTitle continueUseButton;

    @SerializedName("stop_button")
    private final TextTitle stopButton;
    private final TextWithParam subtitle;
    private final String title;

    /* compiled from: ServicePaymentCancelPopupLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ServicePaymentCancelPopupBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentCancelPopupBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            TextWithParam textWithParamCreateFromParcel = TextWithParam.CREATOR.createFromParcel(parcel);
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new ServicePaymentCancelPopupBody(string, textWithParamCreateFromParcel, creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentCancelPopupBody[] newArray(int i) {
            return new ServicePaymentCancelPopupBody[i];
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
        if (!(other instanceof ServicePaymentCancelPopupBody)) {
            return false;
        }
        ServicePaymentCancelPopupBody servicePaymentCancelPopupBody = (ServicePaymentCancelPopupBody) other;
        return Intrinsics.areEqual(this.title, servicePaymentCancelPopupBody.title) && Intrinsics.areEqual(this.subtitle, servicePaymentCancelPopupBody.subtitle) && Intrinsics.areEqual(this.continueUseButton, servicePaymentCancelPopupBody.continueUseButton) && Intrinsics.areEqual(this.stopButton, servicePaymentCancelPopupBody.stopButton);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.continueUseButton.hashCode()) * 31) + this.stopButton.hashCode();
    }

    public String toString() {
        return "ServicePaymentCancelPopupBody(title=" + this.title + ", subtitle=" + this.subtitle + ", continueUseButton=" + this.continueUseButton + ", stopButton=" + this.stopButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        this.subtitle.writeToParcel(parcel, flags);
        this.continueUseButton.writeToParcel(parcel, flags);
        this.stopButton.writeToParcel(parcel, flags);
    }

    public ServicePaymentCancelPopupBody(String title, TextWithParam subtitle, TextTitle continueUseButton, TextTitle stopButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(continueUseButton, "continueUseButton");
        Intrinsics.checkNotNullParameter(stopButton, "stopButton");
        this.title = title;
        this.subtitle = subtitle;
        this.continueUseButton = continueUseButton;
        this.stopButton = stopButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextWithParam getSubtitle() {
        return this.subtitle;
    }

    public final TextTitle getContinueUseButton() {
        return this.continueUseButton;
    }

    public final TextTitle getStopButton() {
        return this.stopButton;
    }
}
