package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmAddressLocale.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/BadAddressPopup;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "cancelButton", "supportButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBody", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSupportButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BadAddressPopup implements Parcelable {
    public static final Parcelable.Creator<BadAddressPopup> CREATOR = new Creator();
    private final String body;

    @SerializedName("cancel_button")
    private final TextTitle cancelButton;

    @SerializedName("support_button")
    private final TextTitle supportButton;
    private final String title;

    /* compiled from: ConfirmAddressLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BadAddressPopup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadAddressPopup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new BadAddressPopup(string, string2, creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadAddressPopup[] newArray(int i) {
            return new BadAddressPopup[i];
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
        if (!(other instanceof BadAddressPopup)) {
            return false;
        }
        BadAddressPopup badAddressPopup = (BadAddressPopup) other;
        return Intrinsics.areEqual(this.title, badAddressPopup.title) && Intrinsics.areEqual(this.body, badAddressPopup.body) && Intrinsics.areEqual(this.cancelButton, badAddressPopup.cancelButton) && Intrinsics.areEqual(this.supportButton, badAddressPopup.supportButton);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.body.hashCode()) * 31) + this.cancelButton.hashCode()) * 31) + this.supportButton.hashCode();
    }

    public String toString() {
        return "BadAddressPopup(title=" + this.title + ", body=" + this.body + ", cancelButton=" + this.cancelButton + ", supportButton=" + this.supportButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        this.cancelButton.writeToParcel(parcel, flags);
        this.supportButton.writeToParcel(parcel, flags);
    }

    public BadAddressPopup(String title, String body, TextTitle cancelButton, TextTitle supportButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(cancelButton, "cancelButton");
        Intrinsics.checkNotNullParameter(supportButton, "supportButton");
        this.title = title;
        this.body = body;
        this.cancelButton = cancelButton;
        this.supportButton = supportButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final TextTitle getCancelButton() {
        return this.cancelButton;
    }

    public final TextTitle getSupportButton() {
        return this.supportButton;
    }
}
