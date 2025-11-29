package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmAddressLocale.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressPopup;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "continueButton", "errorButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getContinueButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getErrorButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConfirmAddressPopup implements Parcelable {
    public static final Parcelable.Creator<ConfirmAddressPopup> CREATOR = new Creator();

    @SerializedName("continue_button")
    private final TextTitle continueButton;

    @SerializedName("error_button")
    private final TextTitle errorButton;
    private final String title;

    /* compiled from: ConfirmAddressLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ConfirmAddressPopup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConfirmAddressPopup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new ConfirmAddressPopup(string, creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConfirmAddressPopup[] newArray(int i) {
            return new ConfirmAddressPopup[i];
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
        if (!(other instanceof ConfirmAddressPopup)) {
            return false;
        }
        ConfirmAddressPopup confirmAddressPopup = (ConfirmAddressPopup) other;
        return Intrinsics.areEqual(this.title, confirmAddressPopup.title) && Intrinsics.areEqual(this.continueButton, confirmAddressPopup.continueButton) && Intrinsics.areEqual(this.errorButton, confirmAddressPopup.errorButton);
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.continueButton.hashCode()) * 31) + this.errorButton.hashCode();
    }

    public String toString() {
        return "ConfirmAddressPopup(title=" + this.title + ", continueButton=" + this.continueButton + ", errorButton=" + this.errorButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        this.continueButton.writeToParcel(parcel, flags);
        this.errorButton.writeToParcel(parcel, flags);
    }

    public ConfirmAddressPopup(String title, TextTitle continueButton, TextTitle errorButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(continueButton, "continueButton");
        Intrinsics.checkNotNullParameter(errorButton, "errorButton");
        this.title = title;
        this.continueButton = continueButton;
        this.errorButton = errorButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextTitle getContinueButton() {
        return this.continueButton;
    }

    public final TextTitle getErrorButton() {
        return this.errorButton;
    }
}
