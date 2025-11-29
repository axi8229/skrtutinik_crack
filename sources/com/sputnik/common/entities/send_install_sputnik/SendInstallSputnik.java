package com.sputnik.common.entities.send_install_sputnik;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SendInstallSputnik.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001:\u0002()B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik;", "Landroid/os/Parcelable;", "", "header", "Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$Description;", "description", "Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$FieldsTitles;", "fieldsTitles", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "sendButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$Description;Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$FieldsTitles;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getHeader", "Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$Description;", "getDescription", "()Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$Description;", "Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$FieldsTitles;", "getFieldsTitles", "()Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$FieldsTitles;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSendButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Description", "FieldsTitles", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SendInstallSputnik implements Parcelable {
    public static final Parcelable.Creator<SendInstallSputnik> CREATOR = new Creator();
    private final Description description;

    @SerializedName("fields_titles")
    private final FieldsTitles fieldsTitles;
    private final String header;

    @SerializedName("send_button")
    private final TextTitle sendButton;

    /* compiled from: SendInstallSputnik.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SendInstallSputnik> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendInstallSputnik createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SendInstallSputnik(parcel.readString(), parcel.readInt() == 0 ? null : Description.CREATOR.createFromParcel(parcel), FieldsTitles.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendInstallSputnik[] newArray(int i) {
            return new SendInstallSputnik[i];
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
        if (!(other instanceof SendInstallSputnik)) {
            return false;
        }
        SendInstallSputnik sendInstallSputnik = (SendInstallSputnik) other;
        return Intrinsics.areEqual(this.header, sendInstallSputnik.header) && Intrinsics.areEqual(this.description, sendInstallSputnik.description) && Intrinsics.areEqual(this.fieldsTitles, sendInstallSputnik.fieldsTitles) && Intrinsics.areEqual(this.sendButton, sendInstallSputnik.sendButton);
    }

    public int hashCode() {
        String str = this.header;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Description description = this.description;
        int iHashCode2 = (((iHashCode + (description == null ? 0 : description.hashCode())) * 31) + this.fieldsTitles.hashCode()) * 31;
        TextTitle textTitle = this.sendButton;
        return iHashCode2 + (textTitle != null ? textTitle.hashCode() : 0);
    }

    public String toString() {
        return "SendInstallSputnik(header=" + this.header + ", description=" + this.description + ", fieldsTitles=" + this.fieldsTitles + ", sendButton=" + this.sendButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.header);
        Description description = this.description;
        if (description == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            description.writeToParcel(parcel, flags);
        }
        this.fieldsTitles.writeToParcel(parcel, flags);
        TextTitle textTitle = this.sendButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
    }

    public SendInstallSputnik(String str, Description description, FieldsTitles fieldsTitles, TextTitle textTitle) {
        Intrinsics.checkNotNullParameter(fieldsTitles, "fieldsTitles");
        this.header = str;
        this.description = description;
        this.fieldsTitles = fieldsTitles;
        this.sendButton = textTitle;
    }

    public final Description getDescription() {
        return this.description;
    }

    public final FieldsTitles getFieldsTitles() {
        return this.fieldsTitles;
    }

    public final TextTitle getSendButton() {
        return this.sendButton;
    }

    /* compiled from: SendInstallSputnik.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$Description;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "text", "notion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getText", "getNotion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Description implements Parcelable {
        public static final Parcelable.Creator<Description> CREATOR = new Creator();
        private final String notion;
        private final String text;
        private final String title;

        /* compiled from: SendInstallSputnik.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Description> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Description createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Description(parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Description[] newArray(int i) {
                return new Description[i];
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
            if (!(other instanceof Description)) {
                return false;
            }
            Description description = (Description) other;
            return Intrinsics.areEqual(this.title, description.title) && Intrinsics.areEqual(this.text, description.text) && Intrinsics.areEqual(this.notion, description.notion);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.text;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.notion;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Description(title=" + this.title + ", text=" + this.text + ", notion=" + this.notion + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.text);
            parcel.writeString(this.notion);
        }

        public Description(String str, String str2, String str3) {
            this.title = str;
            this.text = str2;
            this.notion = str3;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getText() {
            return this.text;
        }

        public final String getNotion() {
            return this.notion;
        }
    }

    /* compiled from: SendInstallSputnik.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik$FieldsTitles;", "Landroid/os/Parcelable;", "", "city", "street", "buildingNumber", Scopes.EMAIL, "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCity", "getStreet", "getBuildingNumber", "getEmail", "getPhone", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FieldsTitles implements Parcelable {
        public static final Parcelable.Creator<FieldsTitles> CREATOR = new Creator();

        @SerializedName("building_number")
        private final String buildingNumber;
        private final String city;
        private final String email;
        private final String phone;
        private final String street;

        /* compiled from: SendInstallSputnik.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FieldsTitles> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FieldsTitles createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FieldsTitles(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FieldsTitles[] newArray(int i) {
                return new FieldsTitles[i];
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
            if (!(other instanceof FieldsTitles)) {
                return false;
            }
            FieldsTitles fieldsTitles = (FieldsTitles) other;
            return Intrinsics.areEqual(this.city, fieldsTitles.city) && Intrinsics.areEqual(this.street, fieldsTitles.street) && Intrinsics.areEqual(this.buildingNumber, fieldsTitles.buildingNumber) && Intrinsics.areEqual(this.email, fieldsTitles.email) && Intrinsics.areEqual(this.phone, fieldsTitles.phone);
        }

        public int hashCode() {
            String str = this.city;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.street;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.buildingNumber;
            return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.email.hashCode()) * 31) + this.phone.hashCode();
        }

        public String toString() {
            return "FieldsTitles(city=" + this.city + ", street=" + this.street + ", buildingNumber=" + this.buildingNumber + ", email=" + this.email + ", phone=" + this.phone + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.city);
            parcel.writeString(this.street);
            parcel.writeString(this.buildingNumber);
            parcel.writeString(this.email);
            parcel.writeString(this.phone);
        }

        public FieldsTitles(String str, String str2, String str3, String email, String phone) {
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.city = str;
            this.street = str2;
            this.buildingNumber = str3;
            this.email = email;
            this.phone = phone;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getStreet() {
            return this.street;
        }

        public final String getBuildingNumber() {
            return this.buildingNumber;
        }

        public final String getPhone() {
            return this.phone;
        }
    }
}
