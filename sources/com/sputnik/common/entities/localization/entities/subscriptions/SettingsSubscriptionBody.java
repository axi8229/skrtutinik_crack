package com.sputnik.common.entities.localization.entities.subscriptions;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionsLocale.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionInfoView;", "subscriptionInfoView", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "cancelButton", "stopButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionInfoView;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionInfoView;", "getSubscriptionInfoView", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionInfoView;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getStopButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SettingsSubscriptionBody implements Parcelable {
    public static final Parcelable.Creator<SettingsSubscriptionBody> CREATOR = new Creator();

    @SerializedName("cancel_button")
    private final TextTitle cancelButton;

    @SerializedName("stop_button")
    private final TextTitle stopButton;

    @SerializedName("subscription_info_view")
    private final SettingsSubscriptionInfoView subscriptionInfoView;
    private final String title;

    /* compiled from: SubscriptionsLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SettingsSubscriptionBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SettingsSubscriptionBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SettingsSubscriptionBody(parcel.readString(), parcel.readInt() == 0 ? null : SettingsSubscriptionInfoView.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SettingsSubscriptionBody[] newArray(int i) {
            return new SettingsSubscriptionBody[i];
        }
    }

    public SettingsSubscriptionBody() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsSubscriptionBody)) {
            return false;
        }
        SettingsSubscriptionBody settingsSubscriptionBody = (SettingsSubscriptionBody) other;
        return Intrinsics.areEqual(this.title, settingsSubscriptionBody.title) && Intrinsics.areEqual(this.subscriptionInfoView, settingsSubscriptionBody.subscriptionInfoView) && Intrinsics.areEqual(this.cancelButton, settingsSubscriptionBody.cancelButton) && Intrinsics.areEqual(this.stopButton, settingsSubscriptionBody.stopButton);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        SettingsSubscriptionInfoView settingsSubscriptionInfoView = this.subscriptionInfoView;
        int iHashCode2 = (iHashCode + (settingsSubscriptionInfoView == null ? 0 : settingsSubscriptionInfoView.hashCode())) * 31;
        TextTitle textTitle = this.cancelButton;
        int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        TextTitle textTitle2 = this.stopButton;
        return iHashCode3 + (textTitle2 != null ? textTitle2.hashCode() : 0);
    }

    public String toString() {
        return "SettingsSubscriptionBody(title=" + this.title + ", subscriptionInfoView=" + this.subscriptionInfoView + ", cancelButton=" + this.cancelButton + ", stopButton=" + this.stopButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        SettingsSubscriptionInfoView settingsSubscriptionInfoView = this.subscriptionInfoView;
        if (settingsSubscriptionInfoView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            settingsSubscriptionInfoView.writeToParcel(parcel, flags);
        }
        TextTitle textTitle = this.cancelButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
        TextTitle textTitle2 = this.stopButton;
        if (textTitle2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle2.writeToParcel(parcel, flags);
        }
    }

    public SettingsSubscriptionBody(String str, SettingsSubscriptionInfoView settingsSubscriptionInfoView, TextTitle textTitle, TextTitle textTitle2) {
        this.title = str;
        this.subscriptionInfoView = settingsSubscriptionInfoView;
        this.cancelButton = textTitle;
        this.stopButton = textTitle2;
    }

    public /* synthetic */ SettingsSubscriptionBody(String str, SettingsSubscriptionInfoView settingsSubscriptionInfoView, TextTitle textTitle, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : settingsSubscriptionInfoView, (i & 4) != 0 ? null : textTitle, (i & 8) != 0 ? null : textTitle2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final SettingsSubscriptionInfoView getSubscriptionInfoView() {
        return this.subscriptionInfoView;
    }

    public final TextTitle getCancelButton() {
        return this.cancelButton;
    }

    public final TextTitle getStopButton() {
        return this.stopButton;
    }
}
