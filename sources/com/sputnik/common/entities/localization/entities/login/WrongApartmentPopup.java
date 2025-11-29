package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmAddressLocale.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/WrongApartmentPopup;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "bodies", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "changeButton", "supportButton", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getBodies", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getChangeButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSupportButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WrongApartmentPopup implements Parcelable {
    public static final Parcelable.Creator<WrongApartmentPopup> CREATOR = new Creator();
    private final List<String> bodies;

    @SerializedName("change_button")
    private final TextTitle changeButton;

    @SerializedName("support_button")
    private final TextTitle supportButton;
    private final String title;

    /* compiled from: ConfirmAddressLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WrongApartmentPopup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WrongApartmentPopup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new WrongApartmentPopup(string, arrayListCreateStringArrayList, creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WrongApartmentPopup[] newArray(int i) {
            return new WrongApartmentPopup[i];
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
        if (!(other instanceof WrongApartmentPopup)) {
            return false;
        }
        WrongApartmentPopup wrongApartmentPopup = (WrongApartmentPopup) other;
        return Intrinsics.areEqual(this.title, wrongApartmentPopup.title) && Intrinsics.areEqual(this.bodies, wrongApartmentPopup.bodies) && Intrinsics.areEqual(this.changeButton, wrongApartmentPopup.changeButton) && Intrinsics.areEqual(this.supportButton, wrongApartmentPopup.supportButton);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.bodies.hashCode()) * 31) + this.changeButton.hashCode()) * 31) + this.supportButton.hashCode();
    }

    public String toString() {
        return "WrongApartmentPopup(title=" + this.title + ", bodies=" + this.bodies + ", changeButton=" + this.changeButton + ", supportButton=" + this.supportButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeStringList(this.bodies);
        this.changeButton.writeToParcel(parcel, flags);
        this.supportButton.writeToParcel(parcel, flags);
    }

    public WrongApartmentPopup(String title, List<String> bodies, TextTitle changeButton, TextTitle supportButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bodies, "bodies");
        Intrinsics.checkNotNullParameter(changeButton, "changeButton");
        Intrinsics.checkNotNullParameter(supportButton, "supportButton");
        this.title = title;
        this.bodies = bodies;
        this.changeButton = changeButton;
        this.supportButton = supportButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getBodies() {
        return this.bodies;
    }

    public final TextTitle getChangeButton() {
        return this.changeButton;
    }

    public final TextTitle getSupportButton() {
        return this.supportButton;
    }
}
