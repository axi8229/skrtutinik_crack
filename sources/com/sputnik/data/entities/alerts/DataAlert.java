package com.sputnik.data.entities.alerts;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.data.entities.common.TextWith1Param;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataAlert.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001:\u0001)B3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/sputnik/data/entities/alerts/DataAlert;", "Landroid/os/Parcelable;", "", "version", "", "required", "Lcom/sputnik/data/entities/alerts/DataAlert$DataAlertAppearance;", "appearance", "", "Lcom/sputnik/data/entities/alerts/DataButton;", "buttons", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/sputnik/data/entities/alerts/DataAlert$DataAlertAppearance;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Boolean;", "getRequired", "()Ljava/lang/Boolean;", "Lcom/sputnik/data/entities/alerts/DataAlert$DataAlertAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/alerts/DataAlert$DataAlertAppearance;", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "DataAlertAppearance", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataAlert implements Parcelable {
    public static final Parcelable.Creator<DataAlert> CREATOR = new Creator();
    private final DataAlertAppearance appearance;
    private final List<DataButton> buttons;
    private final Boolean required;
    private final Integer version;

    /* compiled from: DataAlert.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataAlert> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataAlert createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            DataAlertAppearance dataAlertAppearanceCreateFromParcel = parcel.readInt() != 0 ? DataAlertAppearance.CREATOR.createFromParcel(parcel) : null;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(DataButton.CREATOR.createFromParcel(parcel));
            }
            return new DataAlert(numValueOf, boolValueOf, dataAlertAppearanceCreateFromParcel, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataAlert[] newArray(int i) {
            return new DataAlert[i];
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
        if (!(other instanceof DataAlert)) {
            return false;
        }
        DataAlert dataAlert = (DataAlert) other;
        return Intrinsics.areEqual(this.version, dataAlert.version) && Intrinsics.areEqual(this.required, dataAlert.required) && Intrinsics.areEqual(this.appearance, dataAlert.appearance) && Intrinsics.areEqual(this.buttons, dataAlert.buttons);
    }

    public int hashCode() {
        Integer num = this.version;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.required;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        DataAlertAppearance dataAlertAppearance = this.appearance;
        return ((iHashCode2 + (dataAlertAppearance != null ? dataAlertAppearance.hashCode() : 0)) * 31) + this.buttons.hashCode();
    }

    public String toString() {
        return "DataAlert(version=" + this.version + ", required=" + this.required + ", appearance=" + this.appearance + ", buttons=" + this.buttons + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.version;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.required;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        DataAlertAppearance dataAlertAppearance = this.appearance;
        if (dataAlertAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataAlertAppearance.writeToParcel(parcel, flags);
        }
        List<DataButton> list = this.buttons;
        parcel.writeInt(list.size());
        Iterator<DataButton> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public DataAlert(Integer num, Boolean bool, DataAlertAppearance dataAlertAppearance, List<DataButton> buttons) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        this.version = num;
        this.required = bool;
        this.appearance = dataAlertAppearance;
        this.buttons = buttons;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final Boolean getRequired() {
        return this.required;
    }

    public final DataAlertAppearance getAppearance() {
        return this.appearance;
    }

    public final List<DataButton> getButtons() {
        return this.buttons;
    }

    /* compiled from: DataAlert.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/alerts/DataAlert$DataAlertAppearance;", "Landroid/os/Parcelable;", "Lcom/sputnik/data/entities/common/TextWith1Param;", "body", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "<init>", "(Lcom/sputnik/data/entities/common/TextWith1Param;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/data/entities/common/TextWith1Param;", "getBody", "()Lcom/sputnik/data/entities/common/TextWith1Param;", "Ljava/lang/String;", "getTitle", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataAlertAppearance implements Parcelable {
        public static final Parcelable.Creator<DataAlertAppearance> CREATOR = new Creator();
        private final TextWith1Param body;
        private final String title;

        /* compiled from: DataAlert.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataAlertAppearance> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataAlertAppearance createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DataAlertAppearance(parcel.readInt() == 0 ? null : TextWith1Param.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataAlertAppearance[] newArray(int i) {
                return new DataAlertAppearance[i];
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
            if (!(other instanceof DataAlertAppearance)) {
                return false;
            }
            DataAlertAppearance dataAlertAppearance = (DataAlertAppearance) other;
            return Intrinsics.areEqual(this.body, dataAlertAppearance.body) && Intrinsics.areEqual(this.title, dataAlertAppearance.title);
        }

        public int hashCode() {
            TextWith1Param textWith1Param = this.body;
            int iHashCode = (textWith1Param == null ? 0 : textWith1Param.hashCode()) * 31;
            String str = this.title;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "DataAlertAppearance(body=" + this.body + ", title=" + this.title + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            TextWith1Param textWith1Param = this.body;
            if (textWith1Param == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textWith1Param.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.title);
        }

        public DataAlertAppearance(TextWith1Param textWith1Param, String str) {
            this.body = textWith1Param;
            this.title = str;
        }

        public final TextWith1Param getBody() {
            return this.body;
        }

        public final String getTitle() {
            return this.title;
        }
    }
}
