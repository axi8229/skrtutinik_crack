package com.sputnik.common.entities.localization.entities.service_payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentSuccess.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b!\u0010\u001f¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "saveButton", "subscriptionButton", "profileButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSaveButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSubscriptionButton", "getProfileButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServicePaymentBody implements Parcelable {
    public static final Parcelable.Creator<ServicePaymentBody> CREATOR = new Creator();

    @SerializedName("profile_button")
    private final TextTitle profileButton;

    @SerializedName("save_button")
    private final TextTitle saveButton;

    @SerializedName("subscription_button")
    private final TextTitle subscriptionButton;
    private final String title;

    /* compiled from: ServicePaymentSuccess.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ServicePaymentBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new ServicePaymentBody(string, creator.createFromParcel(parcel), creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentBody[] newArray(int i) {
            return new ServicePaymentBody[i];
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
        if (!(other instanceof ServicePaymentBody)) {
            return false;
        }
        ServicePaymentBody servicePaymentBody = (ServicePaymentBody) other;
        return Intrinsics.areEqual(this.title, servicePaymentBody.title) && Intrinsics.areEqual(this.saveButton, servicePaymentBody.saveButton) && Intrinsics.areEqual(this.subscriptionButton, servicePaymentBody.subscriptionButton) && Intrinsics.areEqual(this.profileButton, servicePaymentBody.profileButton);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.saveButton.hashCode()) * 31) + this.subscriptionButton.hashCode()) * 31) + this.profileButton.hashCode();
    }

    public String toString() {
        return "ServicePaymentBody(title=" + this.title + ", saveButton=" + this.saveButton + ", subscriptionButton=" + this.subscriptionButton + ", profileButton=" + this.profileButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        this.saveButton.writeToParcel(parcel, flags);
        this.subscriptionButton.writeToParcel(parcel, flags);
        this.profileButton.writeToParcel(parcel, flags);
    }

    public ServicePaymentBody(String title, TextTitle saveButton, TextTitle subscriptionButton, TextTitle profileButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(saveButton, "saveButton");
        Intrinsics.checkNotNullParameter(subscriptionButton, "subscriptionButton");
        Intrinsics.checkNotNullParameter(profileButton, "profileButton");
        this.title = title;
        this.saveButton = saveButton;
        this.subscriptionButton = subscriptionButton;
        this.profileButton = profileButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextTitle getSaveButton() {
        return this.saveButton;
    }

    public final TextTitle getSubscriptionButton() {
        return this.subscriptionButton;
    }

    public final TextTitle getProfileButton() {
        return this.profileButton;
    }
}
