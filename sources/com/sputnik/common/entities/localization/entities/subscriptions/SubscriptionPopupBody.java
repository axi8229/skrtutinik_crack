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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPopupBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "doneButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getDoneButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubscriptionPopupBody implements Parcelable {
    public static final Parcelable.Creator<SubscriptionPopupBody> CREATOR = new Creator();

    @SerializedName("done_button")
    private final TextTitle doneButton;
    private final String title;

    /* compiled from: SubscriptionsLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionPopupBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubscriptionPopupBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubscriptionPopupBody(parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubscriptionPopupBody[] newArray(int i) {
            return new SubscriptionPopupBody[i];
        }
    }

    public SubscriptionPopupBody() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionPopupBody)) {
            return false;
        }
        SubscriptionPopupBody subscriptionPopupBody = (SubscriptionPopupBody) other;
        return Intrinsics.areEqual(this.title, subscriptionPopupBody.title) && Intrinsics.areEqual(this.doneButton, subscriptionPopupBody.doneButton);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        TextTitle textTitle = this.doneButton;
        return iHashCode + (textTitle != null ? textTitle.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionPopupBody(title=" + this.title + ", doneButton=" + this.doneButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        TextTitle textTitle = this.doneButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
    }

    public SubscriptionPopupBody(String str, TextTitle textTitle) {
        this.title = str;
        this.doneButton = textTitle;
    }

    public /* synthetic */ SubscriptionPopupBody(String str, TextTitle textTitle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : textTitle);
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextTitle getDoneButton() {
        return this.doneButton;
    }
}
