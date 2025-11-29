package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/FamilyMemberBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "adminButton", "deleteButton", "", "deleteMessage", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getAdminButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getDeleteButton", "Ljava/lang/String;", "getDeleteMessage", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FamilyMemberBody implements Parcelable {
    public static final Parcelable.Creator<FamilyMemberBody> CREATOR = new Creator();

    @SerializedName("admin_button")
    private final TextTitle adminButton;

    @SerializedName("delete_button")
    private final TextTitle deleteButton;

    @SerializedName("delete_message")
    private final String deleteMessage;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FamilyMemberBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyMemberBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FamilyMemberBody((TextTitle) parcel.readParcelable(FamilyMemberBody.class.getClassLoader()), (TextTitle) parcel.readParcelable(FamilyMemberBody.class.getClassLoader()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyMemberBody[] newArray(int i) {
            return new FamilyMemberBody[i];
        }
    }

    public FamilyMemberBody() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyMemberBody)) {
            return false;
        }
        FamilyMemberBody familyMemberBody = (FamilyMemberBody) other;
        return Intrinsics.areEqual(this.adminButton, familyMemberBody.adminButton) && Intrinsics.areEqual(this.deleteButton, familyMemberBody.deleteButton) && Intrinsics.areEqual(this.deleteMessage, familyMemberBody.deleteMessage);
    }

    public int hashCode() {
        TextTitle textTitle = this.adminButton;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        TextTitle textTitle2 = this.deleteButton;
        int iHashCode2 = (iHashCode + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        String str = this.deleteMessage;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FamilyMemberBody(adminButton=" + this.adminButton + ", deleteButton=" + this.deleteButton + ", deleteMessage=" + this.deleteMessage + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.adminButton, flags);
        parcel.writeParcelable(this.deleteButton, flags);
        parcel.writeString(this.deleteMessage);
    }

    public FamilyMemberBody(TextTitle textTitle, TextTitle textTitle2, String str) {
        this.adminButton = textTitle;
        this.deleteButton = textTitle2;
        this.deleteMessage = str;
    }

    public /* synthetic */ FamilyMemberBody(TextTitle textTitle, TextTitle textTitle2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : textTitle2, (i & 4) != 0 ? null : str);
    }

    public final TextTitle getAdminButton() {
        return this.adminButton;
    }

    public final TextTitle getDeleteButton() {
        return this.deleteButton;
    }

    public final String getDeleteMessage() {
        return this.deleteMessage;
    }
}
