package com.sputnik.data.entities.popups;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPopupStory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/sputnik/data/entities/popups/DataButton;", "Landroid/os/Parcelable;", "", "text", "deeplink", "textColor", "backgroundColor", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "getDeeplink", "getTextColor", "getBackgroundColor", "getAction", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataButton implements Parcelable {
    public static final Parcelable.Creator<DataButton> CREATOR = new Creator();
    private final String action;

    @SerializedName("background-color")
    private final String backgroundColor;
    private final String deeplink;
    private final String text;

    @SerializedName("text-color")
    private final String textColor;

    /* compiled from: DataPopupStory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataButton> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataButton createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataButton(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
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
        return Intrinsics.areEqual(this.text, dataButton.text) && Intrinsics.areEqual(this.deeplink, dataButton.deeplink) && Intrinsics.areEqual(this.textColor, dataButton.textColor) && Intrinsics.areEqual(this.backgroundColor, dataButton.backgroundColor) && Intrinsics.areEqual(this.action, dataButton.action);
    }

    public int hashCode() {
        int iHashCode = ((((((this.text.hashCode() * 31) + this.deeplink.hashCode()) * 31) + this.textColor.hashCode()) * 31) + this.backgroundColor.hashCode()) * 31;
        String str = this.action;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DataButton(text=" + this.text + ", deeplink=" + this.deeplink + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", action=" + this.action + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.text);
        parcel.writeString(this.deeplink);
        parcel.writeString(this.textColor);
        parcel.writeString(this.backgroundColor);
        parcel.writeString(this.action);
    }

    public DataButton(String text, String deeplink, String textColor, String backgroundColor, String str) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        this.text = text;
        this.deeplink = deeplink;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.action = str;
    }

    public final String getText() {
        return this.text;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getAction() {
        return this.action;
    }
}
