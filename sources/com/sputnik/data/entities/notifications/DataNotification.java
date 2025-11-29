package com.sputnik.data.entities.notifications;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.buttons.ColorsButton;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataNotification.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001:\u00011Bg\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0015J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b&\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b'\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b(\u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b)\u0010\u0013R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b-\u0010\u0013R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010.\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/sputnik/data/entities/notifications/DataNotification;", "Landroid/os/Parcelable;", "", "id", "", "identifier", "identifierHuman", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", CrashHianalyticsData.MESSAGE, "", "viewed", "createdAt", "", "Lcom/sputnik/data/entities/notifications/DataNotification$DataButton;", "buttons", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getIdentifier", "getIdentifierHuman", "getTitle", "getDeeplink", "getMessage", "Ljava/lang/Boolean;", "getViewed", "()Ljava/lang/Boolean;", "getCreatedAt", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "DataButton", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataNotification implements Parcelable {
    public static final Parcelable.Creator<DataNotification> CREATOR = new Creator();
    private final List<DataButton> buttons;

    @SerializedName("created_at")
    private final String createdAt;
    private final String deeplink;
    private final Integer id;
    private final String identifier;

    @SerializedName("identifier_human")
    private final String identifierHuman;
    private final String message;
    private final String title;
    private final Boolean viewed;

    /* compiled from: DataNotification.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataNotification> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataNotification createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string6 = parcel.readString();
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(DataButton.CREATOR.createFromParcel(parcel));
                }
            }
            return new DataNotification(numValueOf, string, string2, string3, string4, string5, boolValueOf, string6, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataNotification[] newArray(int i) {
            return new DataNotification[i];
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
        if (!(other instanceof DataNotification)) {
            return false;
        }
        DataNotification dataNotification = (DataNotification) other;
        return Intrinsics.areEqual(this.id, dataNotification.id) && Intrinsics.areEqual(this.identifier, dataNotification.identifier) && Intrinsics.areEqual(this.identifierHuman, dataNotification.identifierHuman) && Intrinsics.areEqual(this.title, dataNotification.title) && Intrinsics.areEqual(this.deeplink, dataNotification.deeplink) && Intrinsics.areEqual(this.message, dataNotification.message) && Intrinsics.areEqual(this.viewed, dataNotification.viewed) && Intrinsics.areEqual(this.createdAt, dataNotification.createdAt) && Intrinsics.areEqual(this.buttons, dataNotification.buttons);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.identifierHuman;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deeplink;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.message;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.viewed;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.createdAt;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<DataButton> list = this.buttons;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "DataNotification(id=" + this.id + ", identifier=" + this.identifier + ", identifierHuman=" + this.identifierHuman + ", title=" + this.title + ", deeplink=" + this.deeplink + ", message=" + this.message + ", viewed=" + this.viewed + ", createdAt=" + this.createdAt + ", buttons=" + this.buttons + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.identifier);
        parcel.writeString(this.identifierHuman);
        parcel.writeString(this.title);
        parcel.writeString(this.deeplink);
        parcel.writeString(this.message);
        Boolean bool = this.viewed;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.createdAt);
        List<DataButton> list = this.buttons;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<DataButton> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public DataNotification(Integer num, String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, List<DataButton> list) {
        this.id = num;
        this.identifier = str;
        this.identifierHuman = str2;
        this.title = str3;
        this.deeplink = str4;
        this.message = str5;
        this.viewed = bool;
        this.createdAt = str6;
        this.buttons = list;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getIdentifierHuman() {
        return this.identifierHuman;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Boolean getViewed() {
        return this.viewed;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final List<DataButton> getButtons() {
        return this.buttons;
    }

    /* compiled from: DataNotification.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b!\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\"\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b#\u0010\f¨\u0006$"}, d2 = {"Lcom/sputnik/data/entities/notifications/DataNotification$DataButton;", "Landroid/os/Parcelable;", "", "type", "Lcom/sputnik/domain/entities/buttons/ColorsButton;", RemoteMessageConst.Notification.COLOR, "deeplink", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "link", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/buttons/ColorsButton;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getType", "Lcom/sputnik/domain/entities/buttons/ColorsButton;", "getColor", "()Lcom/sputnik/domain/entities/buttons/ColorsButton;", "getDeeplink", "getTitle", "getLink", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataButton implements Parcelable {
        public static final Parcelable.Creator<DataButton> CREATOR = new Creator();
        private final ColorsButton color;
        private final String deeplink;
        private final String link;
        private final String title;
        private final String type;

        /* compiled from: DataNotification.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataButton> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataButton createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DataButton(parcel.readString(), parcel.readInt() == 0 ? null : ColorsButton.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataButton[] newArray(int i) {
                return new DataButton[i];
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
            if (!(other instanceof DataButton)) {
                return false;
            }
            DataButton dataButton = (DataButton) other;
            return Intrinsics.areEqual(this.type, dataButton.type) && this.color == dataButton.color && Intrinsics.areEqual(this.deeplink, dataButton.deeplink) && Intrinsics.areEqual(this.title, dataButton.title) && Intrinsics.areEqual(this.link, dataButton.link);
        }

        public int hashCode() {
            String str = this.type;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            ColorsButton colorsButton = this.color;
            int iHashCode2 = (iHashCode + (colorsButton == null ? 0 : colorsButton.hashCode())) * 31;
            String str2 = this.deeplink;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.title;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.link;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "DataButton(type=" + this.type + ", color=" + this.color + ", deeplink=" + this.deeplink + ", title=" + this.title + ", link=" + this.link + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.type);
            ColorsButton colorsButton = this.color;
            if (colorsButton == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(colorsButton.name());
            }
            parcel.writeString(this.deeplink);
            parcel.writeString(this.title);
            parcel.writeString(this.link);
        }

        public DataButton(String str, ColorsButton colorsButton, String str2, String str3, String str4) {
            this.type = str;
            this.color = colorsButton;
            this.deeplink = str2;
            this.title = str3;
            this.link = str4;
        }

        public final String getType() {
            return this.type;
        }

        public final ColorsButton getColor() {
            return this.color;
        }

        public final String getDeeplink() {
            return this.deeplink;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getLink() {
            return this.link;
        }
    }
}
