package com.sputnik.common.entities.localization.entities.family_invites;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FamilyInvitesLocale.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001:\u0004/012BI\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale;", "Landroid/os/Parcelable;", "", "", "invitesStatuses", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$SendFamilyInviteLocale;", "sendInvite", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$LeaveFromFamilyLocale;", "leaveFromFamily", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$RemoveFromFamilyLocale;", "removeFromFamily", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$ResentFamilyInviteLocale;", "resendInvite", "<init>", "(Ljava/util/List;Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$SendFamilyInviteLocale;Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$LeaveFromFamilyLocale;Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$RemoveFromFamilyLocale;Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$ResentFamilyInviteLocale;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getInvitesStatuses", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$SendFamilyInviteLocale;", "getSendInvite", "()Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$SendFamilyInviteLocale;", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$LeaveFromFamilyLocale;", "getLeaveFromFamily", "()Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$LeaveFromFamilyLocale;", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$RemoveFromFamilyLocale;", "getRemoveFromFamily", "()Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$RemoveFromFamilyLocale;", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$ResentFamilyInviteLocale;", "getResendInvite", "()Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$ResentFamilyInviteLocale;", "LeaveFromFamilyLocale", "RemoveFromFamilyLocale", "ResentFamilyInviteLocale", "SendFamilyInviteLocale", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FamilyInvitesLocale implements Parcelable {
    public static final Parcelable.Creator<FamilyInvitesLocale> CREATOR = new Creator();

    @SerializedName("invites_statuses")
    private final List<String> invitesStatuses;

    @SerializedName("leave_from_family")
    private final LeaveFromFamilyLocale leaveFromFamily;

    @SerializedName("remove_from_family")
    private final RemoveFromFamilyLocale removeFromFamily;

    @SerializedName("resend_invite")
    private final ResentFamilyInviteLocale resendInvite;

    @SerializedName("send_invite")
    private final SendFamilyInviteLocale sendInvite;

    /* compiled from: FamilyInvitesLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FamilyInvitesLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyInvitesLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FamilyInvitesLocale(parcel.createStringArrayList(), parcel.readInt() == 0 ? null : SendFamilyInviteLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : LeaveFromFamilyLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : RemoveFromFamilyLocale.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ResentFamilyInviteLocale.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyInvitesLocale[] newArray(int i) {
            return new FamilyInvitesLocale[i];
        }
    }

    public FamilyInvitesLocale() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyInvitesLocale)) {
            return false;
        }
        FamilyInvitesLocale familyInvitesLocale = (FamilyInvitesLocale) other;
        return Intrinsics.areEqual(this.invitesStatuses, familyInvitesLocale.invitesStatuses) && Intrinsics.areEqual(this.sendInvite, familyInvitesLocale.sendInvite) && Intrinsics.areEqual(this.leaveFromFamily, familyInvitesLocale.leaveFromFamily) && Intrinsics.areEqual(this.removeFromFamily, familyInvitesLocale.removeFromFamily) && Intrinsics.areEqual(this.resendInvite, familyInvitesLocale.resendInvite);
    }

    public int hashCode() {
        List<String> list = this.invitesStatuses;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        SendFamilyInviteLocale sendFamilyInviteLocale = this.sendInvite;
        int iHashCode2 = (iHashCode + (sendFamilyInviteLocale == null ? 0 : sendFamilyInviteLocale.hashCode())) * 31;
        LeaveFromFamilyLocale leaveFromFamilyLocale = this.leaveFromFamily;
        int iHashCode3 = (iHashCode2 + (leaveFromFamilyLocale == null ? 0 : leaveFromFamilyLocale.hashCode())) * 31;
        RemoveFromFamilyLocale removeFromFamilyLocale = this.removeFromFamily;
        int iHashCode4 = (iHashCode3 + (removeFromFamilyLocale == null ? 0 : removeFromFamilyLocale.hashCode())) * 31;
        ResentFamilyInviteLocale resentFamilyInviteLocale = this.resendInvite;
        return iHashCode4 + (resentFamilyInviteLocale != null ? resentFamilyInviteLocale.hashCode() : 0);
    }

    public String toString() {
        return "FamilyInvitesLocale(invitesStatuses=" + this.invitesStatuses + ", sendInvite=" + this.sendInvite + ", leaveFromFamily=" + this.leaveFromFamily + ", removeFromFamily=" + this.removeFromFamily + ", resendInvite=" + this.resendInvite + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.invitesStatuses);
        SendFamilyInviteLocale sendFamilyInviteLocale = this.sendInvite;
        if (sendFamilyInviteLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sendFamilyInviteLocale.writeToParcel(parcel, flags);
        }
        LeaveFromFamilyLocale leaveFromFamilyLocale = this.leaveFromFamily;
        if (leaveFromFamilyLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            leaveFromFamilyLocale.writeToParcel(parcel, flags);
        }
        RemoveFromFamilyLocale removeFromFamilyLocale = this.removeFromFamily;
        if (removeFromFamilyLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            removeFromFamilyLocale.writeToParcel(parcel, flags);
        }
        ResentFamilyInviteLocale resentFamilyInviteLocale = this.resendInvite;
        if (resentFamilyInviteLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            resentFamilyInviteLocale.writeToParcel(parcel, flags);
        }
    }

    public FamilyInvitesLocale(List<String> list, SendFamilyInviteLocale sendFamilyInviteLocale, LeaveFromFamilyLocale leaveFromFamilyLocale, RemoveFromFamilyLocale removeFromFamilyLocale, ResentFamilyInviteLocale resentFamilyInviteLocale) {
        this.invitesStatuses = list;
        this.sendInvite = sendFamilyInviteLocale;
        this.leaveFromFamily = leaveFromFamilyLocale;
        this.removeFromFamily = removeFromFamilyLocale;
        this.resendInvite = resentFamilyInviteLocale;
    }

    public /* synthetic */ FamilyInvitesLocale(List list, SendFamilyInviteLocale sendFamilyInviteLocale, LeaveFromFamilyLocale leaveFromFamilyLocale, RemoveFromFamilyLocale removeFromFamilyLocale, ResentFamilyInviteLocale resentFamilyInviteLocale, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : sendFamilyInviteLocale, (i & 4) != 0 ? null : leaveFromFamilyLocale, (i & 8) != 0 ? null : removeFromFamilyLocale, (i & 16) != 0 ? null : resentFamilyInviteLocale);
    }

    public final List<String> getInvitesStatuses() {
        return this.invitesStatuses;
    }

    public final SendFamilyInviteLocale getSendInvite() {
        return this.sendInvite;
    }

    public final LeaveFromFamilyLocale getLeaveFromFamily() {
        return this.leaveFromFamily;
    }

    public final RemoveFromFamilyLocale getRemoveFromFamily() {
        return this.removeFromFamily;
    }

    public final ResentFamilyInviteLocale getResendInvite() {
        return this.resendInvite;
    }

    /* compiled from: FamilyInvitesLocale.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b%\u0010\r¨\u0006&"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$SendFamilyInviteLocale;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "phoneLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "sendButton", "cancelButton", "errorAlreadyExists", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "getPhoneLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSendButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "getErrorAlreadyExists", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SendFamilyInviteLocale implements Parcelable {
        public static final Parcelable.Creator<SendFamilyInviteLocale> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("error_already_exists")
        private final String errorAlreadyExists;

        @SerializedName("phone_label")
        private final String phoneLabel;

        @SerializedName("send_button")
        private final TextTitle sendButton;
        private final String subtitle;
        private final String title;

        /* compiled from: FamilyInvitesLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SendFamilyInviteLocale> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SendFamilyInviteLocale createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SendFamilyInviteLocale(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SendFamilyInviteLocale[] newArray(int i) {
                return new SendFamilyInviteLocale[i];
            }
        }

        public SendFamilyInviteLocale() {
            this(null, null, null, null, null, null, 63, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendFamilyInviteLocale)) {
                return false;
            }
            SendFamilyInviteLocale sendFamilyInviteLocale = (SendFamilyInviteLocale) other;
            return Intrinsics.areEqual(this.title, sendFamilyInviteLocale.title) && Intrinsics.areEqual(this.subtitle, sendFamilyInviteLocale.subtitle) && Intrinsics.areEqual(this.phoneLabel, sendFamilyInviteLocale.phoneLabel) && Intrinsics.areEqual(this.sendButton, sendFamilyInviteLocale.sendButton) && Intrinsics.areEqual(this.cancelButton, sendFamilyInviteLocale.cancelButton) && Intrinsics.areEqual(this.errorAlreadyExists, sendFamilyInviteLocale.errorAlreadyExists);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.subtitle;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phoneLabel;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            TextTitle textTitle = this.sendButton;
            int iHashCode4 = (iHashCode3 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            int iHashCode5 = (iHashCode4 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
            String str4 = this.errorAlreadyExists;
            return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "SendFamilyInviteLocale(title=" + this.title + ", subtitle=" + this.subtitle + ", phoneLabel=" + this.phoneLabel + ", sendButton=" + this.sendButton + ", cancelButton=" + this.cancelButton + ", errorAlreadyExists=" + this.errorAlreadyExists + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            parcel.writeString(this.phoneLabel);
            TextTitle textTitle = this.sendButton;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.cancelButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.errorAlreadyExists);
        }

        public SendFamilyInviteLocale(String str, String str2, String str3, TextTitle textTitle, TextTitle textTitle2, String str4) {
            this.title = str;
            this.subtitle = str2;
            this.phoneLabel = str3;
            this.sendButton = textTitle;
            this.cancelButton = textTitle2;
            this.errorAlreadyExists = str4;
        }

        public /* synthetic */ SendFamilyInviteLocale(String str, String str2, String str3, TextTitle textTitle, TextTitle textTitle2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : textTitle, (i & 16) != 0 ? null : textTitle2, (i & 32) != 0 ? null : str4);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getPhoneLabel() {
            return this.phoneLabel;
        }

        public final TextTitle getSendButton() {
            return this.sendButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }

        public final String getErrorAlreadyExists() {
            return this.errorAlreadyExists;
        }
    }

    /* compiled from: FamilyInvitesLocale.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$LeaveFromFamilyLocale;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "cancelButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class LeaveFromFamilyLocale implements Parcelable {
        public static final Parcelable.Creator<LeaveFromFamilyLocale> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("ok_button")
        private final TextTitle okButton;
        private final String subtitle;
        private final String title;

        /* compiled from: FamilyInvitesLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<LeaveFromFamilyLocale> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LeaveFromFamilyLocale createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new LeaveFromFamilyLocale(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LeaveFromFamilyLocale[] newArray(int i) {
                return new LeaveFromFamilyLocale[i];
            }
        }

        public LeaveFromFamilyLocale() {
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
            if (!(other instanceof LeaveFromFamilyLocale)) {
                return false;
            }
            LeaveFromFamilyLocale leaveFromFamilyLocale = (LeaveFromFamilyLocale) other;
            return Intrinsics.areEqual(this.title, leaveFromFamilyLocale.title) && Intrinsics.areEqual(this.subtitle, leaveFromFamilyLocale.subtitle) && Intrinsics.areEqual(this.okButton, leaveFromFamilyLocale.okButton) && Intrinsics.areEqual(this.cancelButton, leaveFromFamilyLocale.cancelButton);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.subtitle;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.okButton;
            int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            return iHashCode3 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "LeaveFromFamilyLocale(title=" + this.title + ", subtitle=" + this.subtitle + ", okButton=" + this.okButton + ", cancelButton=" + this.cancelButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            TextTitle textTitle = this.okButton;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.cancelButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
        }

        public LeaveFromFamilyLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2) {
            this.title = str;
            this.subtitle = str2;
            this.okButton = textTitle;
            this.cancelButton = textTitle2;
        }

        public /* synthetic */ LeaveFromFamilyLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : textTitle, (i & 8) != 0 ? null : textTitle2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final TextTitle getOkButton() {
            return this.okButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }
    }

    /* compiled from: FamilyInvitesLocale.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$RemoveFromFamilyLocale;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "cancelButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class RemoveFromFamilyLocale implements Parcelable {
        public static final Parcelable.Creator<RemoveFromFamilyLocale> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("ok_button")
        private final TextTitle okButton;
        private final String subtitle;
        private final String title;

        /* compiled from: FamilyInvitesLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<RemoveFromFamilyLocale> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RemoveFromFamilyLocale createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new RemoveFromFamilyLocale(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RemoveFromFamilyLocale[] newArray(int i) {
                return new RemoveFromFamilyLocale[i];
            }
        }

        public RemoveFromFamilyLocale() {
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
            if (!(other instanceof RemoveFromFamilyLocale)) {
                return false;
            }
            RemoveFromFamilyLocale removeFromFamilyLocale = (RemoveFromFamilyLocale) other;
            return Intrinsics.areEqual(this.title, removeFromFamilyLocale.title) && Intrinsics.areEqual(this.subtitle, removeFromFamilyLocale.subtitle) && Intrinsics.areEqual(this.okButton, removeFromFamilyLocale.okButton) && Intrinsics.areEqual(this.cancelButton, removeFromFamilyLocale.cancelButton);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.subtitle;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.okButton;
            int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            return iHashCode3 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "RemoveFromFamilyLocale(title=" + this.title + ", subtitle=" + this.subtitle + ", okButton=" + this.okButton + ", cancelButton=" + this.cancelButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            TextTitle textTitle = this.okButton;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.cancelButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
        }

        public RemoveFromFamilyLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2) {
            this.title = str;
            this.subtitle = str2;
            this.okButton = textTitle;
            this.cancelButton = textTitle2;
        }

        public /* synthetic */ RemoveFromFamilyLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : textTitle, (i & 8) != 0 ? null : textTitle2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final TextTitle getOkButton() {
            return this.okButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }
    }

    /* compiled from: FamilyInvitesLocale.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale$ResentFamilyInviteLocale;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "cancelButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ResentFamilyInviteLocale implements Parcelable {
        public static final Parcelable.Creator<ResentFamilyInviteLocale> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("ok_button")
        private final TextTitle okButton;
        private final String subtitle;
        private final String title;

        /* compiled from: FamilyInvitesLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ResentFamilyInviteLocale> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResentFamilyInviteLocale createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ResentFamilyInviteLocale(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResentFamilyInviteLocale[] newArray(int i) {
                return new ResentFamilyInviteLocale[i];
            }
        }

        public ResentFamilyInviteLocale() {
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
            if (!(other instanceof ResentFamilyInviteLocale)) {
                return false;
            }
            ResentFamilyInviteLocale resentFamilyInviteLocale = (ResentFamilyInviteLocale) other;
            return Intrinsics.areEqual(this.title, resentFamilyInviteLocale.title) && Intrinsics.areEqual(this.subtitle, resentFamilyInviteLocale.subtitle) && Intrinsics.areEqual(this.okButton, resentFamilyInviteLocale.okButton) && Intrinsics.areEqual(this.cancelButton, resentFamilyInviteLocale.cancelButton);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.subtitle;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.okButton;
            int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            return iHashCode3 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "ResentFamilyInviteLocale(title=" + this.title + ", subtitle=" + this.subtitle + ", okButton=" + this.okButton + ", cancelButton=" + this.cancelButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            TextTitle textTitle = this.okButton;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.cancelButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
        }

        public ResentFamilyInviteLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2) {
            this.title = str;
            this.subtitle = str2;
            this.okButton = textTitle;
            this.cancelButton = textTitle2;
        }

        public /* synthetic */ ResentFamilyInviteLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : textTitle, (i & 8) != 0 ? null : textTitle2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final TextTitle getOkButton() {
            return this.okButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }
    }
}
