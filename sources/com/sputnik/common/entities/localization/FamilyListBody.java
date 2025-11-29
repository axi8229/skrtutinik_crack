package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b#\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b$\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b%\u0010\u000eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b&\u0010\u000e¨\u0006'"}, d2 = {"Lcom/sputnik/common/entities/localization/FamilyListBody;", "Landroid/os/Parcelable;", "", "admin", "self", "invitesTitle", "inviteButton", "leaveButton", "noInvites", "errorLimitExceeded", "invitesLeft", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAdmin", "getSelf", "getInvitesTitle", "getInviteButton", "getLeaveButton", "getNoInvites", "getErrorLimitExceeded", "getInvitesLeft", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FamilyListBody implements Parcelable {
    public static final Parcelable.Creator<FamilyListBody> CREATOR = new Creator();
    private final String admin;

    @SerializedName("error_limit_exceeded")
    private final String errorLimitExceeded;

    @SerializedName("invite_button")
    private final String inviteButton;

    @SerializedName("invites_left")
    private final String invitesLeft;

    @SerializedName("invites_title")
    private final String invitesTitle;

    @SerializedName("leave_button")
    private final String leaveButton;

    @SerializedName("no_invites")
    private final String noInvites;
    private final String self;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FamilyListBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyListBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FamilyListBody(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyListBody[] newArray(int i) {
            return new FamilyListBody[i];
        }
    }

    public FamilyListBody() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyListBody)) {
            return false;
        }
        FamilyListBody familyListBody = (FamilyListBody) other;
        return Intrinsics.areEqual(this.admin, familyListBody.admin) && Intrinsics.areEqual(this.self, familyListBody.self) && Intrinsics.areEqual(this.invitesTitle, familyListBody.invitesTitle) && Intrinsics.areEqual(this.inviteButton, familyListBody.inviteButton) && Intrinsics.areEqual(this.leaveButton, familyListBody.leaveButton) && Intrinsics.areEqual(this.noInvites, familyListBody.noInvites) && Intrinsics.areEqual(this.errorLimitExceeded, familyListBody.errorLimitExceeded) && Intrinsics.areEqual(this.invitesLeft, familyListBody.invitesLeft);
    }

    public int hashCode() {
        String str = this.admin;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.self;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.invitesTitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.inviteButton;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.leaveButton;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.noInvites;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.errorLimitExceeded;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.invitesLeft;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "FamilyListBody(admin=" + this.admin + ", self=" + this.self + ", invitesTitle=" + this.invitesTitle + ", inviteButton=" + this.inviteButton + ", leaveButton=" + this.leaveButton + ", noInvites=" + this.noInvites + ", errorLimitExceeded=" + this.errorLimitExceeded + ", invitesLeft=" + this.invitesLeft + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.admin);
        parcel.writeString(this.self);
        parcel.writeString(this.invitesTitle);
        parcel.writeString(this.inviteButton);
        parcel.writeString(this.leaveButton);
        parcel.writeString(this.noInvites);
        parcel.writeString(this.errorLimitExceeded);
        parcel.writeString(this.invitesLeft);
    }

    public FamilyListBody(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.admin = str;
        this.self = str2;
        this.invitesTitle = str3;
        this.inviteButton = str4;
        this.leaveButton = str5;
        this.noInvites = str6;
        this.errorLimitExceeded = str7;
        this.invitesLeft = str8;
    }

    public /* synthetic */ FamilyListBody(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) == 0 ? str8 : null);
    }

    public final String getAdmin() {
        return this.admin;
    }

    public final String getSelf() {
        return this.self;
    }

    public final String getInviteButton() {
        return this.inviteButton;
    }

    public final String getLeaveButton() {
        return this.leaveButton;
    }

    public final String getNoInvites() {
        return this.noInvites;
    }

    public final String getErrorLimitExceeded() {
        return this.errorLimitExceeded;
    }

    public final String getInvitesLeft() {
        return this.invitesLeft;
    }
}
