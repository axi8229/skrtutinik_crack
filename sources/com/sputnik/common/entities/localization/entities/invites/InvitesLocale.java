package com.sputnik.common.entities.localization.entities.invites;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvitesBodyLocale.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/invites/InvitesLocale;", "Landroid/os/Parcelable;", "", "toolbar", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "btnAccept", "btnDecline", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getToolbar", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getBtnAccept", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getBtnDecline", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InvitesLocale implements Parcelable {
    public static final Parcelable.Creator<InvitesLocale> CREATOR = new Creator();

    @SerializedName("accept_button")
    private final TextTitle btnAccept;

    @SerializedName("decline_button")
    private final TextTitle btnDecline;
    private final String title;
    private final String toolbar;

    /* compiled from: InvitesBodyLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InvitesLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final InvitesLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new InvitesLocale(string, string2, creator.createFromParcel(parcel), parcel.readInt() == 0 ? null : creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final InvitesLocale[] newArray(int i) {
            return new InvitesLocale[i];
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
        if (!(other instanceof InvitesLocale)) {
            return false;
        }
        InvitesLocale invitesLocale = (InvitesLocale) other;
        return Intrinsics.areEqual(this.toolbar, invitesLocale.toolbar) && Intrinsics.areEqual(this.title, invitesLocale.title) && Intrinsics.areEqual(this.btnAccept, invitesLocale.btnAccept) && Intrinsics.areEqual(this.btnDecline, invitesLocale.btnDecline);
    }

    public int hashCode() {
        String str = this.toolbar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.btnAccept.hashCode()) * 31;
        TextTitle textTitle = this.btnDecline;
        return iHashCode2 + (textTitle != null ? textTitle.hashCode() : 0);
    }

    public String toString() {
        return "InvitesLocale(toolbar=" + this.toolbar + ", title=" + this.title + ", btnAccept=" + this.btnAccept + ", btnDecline=" + this.btnDecline + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.toolbar);
        parcel.writeString(this.title);
        this.btnAccept.writeToParcel(parcel, flags);
        TextTitle textTitle = this.btnDecline;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
    }

    public InvitesLocale(String str, String str2, TextTitle btnAccept, TextTitle textTitle) {
        Intrinsics.checkNotNullParameter(btnAccept, "btnAccept");
        this.toolbar = str;
        this.title = str2;
        this.btnAccept = btnAccept;
        this.btnDecline = textTitle;
    }

    public final String getToolbar() {
        return this.toolbar;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextTitle getBtnAccept() {
        return this.btnAccept;
    }

    public final TextTitle getBtnDecline() {
        return this.btnDecline;
    }
}
