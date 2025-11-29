package com.sputnik.common.entities.camera;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraObject.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJX\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0010R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010!\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010%R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b&\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b*\u0010)¨\u0006+"}, d2 = {"Lcom/sputnik/common/entities/camera/CameraObject;", "Landroid/os/Parcelable;", "", "mainScreenOrder", "", "uuid", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "widgetOrder", "", "mainScreen", "widget", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sputnik/common/entities/camera/CameraObject;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getMainScreenOrder", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getUuid", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getWidgetOrder", "Ljava/lang/Boolean;", "getMainScreen", "()Ljava/lang/Boolean;", "getWidget", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CameraObject implements Parcelable {
    public static final Parcelable.Creator<CameraObject> CREATOR = new Creator();
    private final Boolean mainScreen;
    private final Integer mainScreenOrder;
    private String title;
    private final String uuid;
    private final Boolean widget;
    private final Integer widgetOrder;

    /* compiled from: CameraObject.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CameraObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraObject createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            String string2 = parcel.readString();
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new CameraObject(numValueOf, string, string2, numValueOf2, boolValueOf, boolValueOf2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraObject[] newArray(int i) {
            return new CameraObject[i];
        }
    }

    public CameraObject() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CameraObject copy$default(CameraObject cameraObject, Integer num, String str, String str2, Integer num2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = cameraObject.mainScreenOrder;
        }
        if ((i & 2) != 0) {
            str = cameraObject.uuid;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = cameraObject.title;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            num2 = cameraObject.widgetOrder;
        }
        Integer num3 = num2;
        if ((i & 16) != 0) {
            bool = cameraObject.mainScreen;
        }
        Boolean bool3 = bool;
        if ((i & 32) != 0) {
            bool2 = cameraObject.widget;
        }
        return cameraObject.copy(num, str3, str4, num3, bool3, bool2);
    }

    public final CameraObject copy(Integer mainScreenOrder, String uuid, String title, Integer widgetOrder, Boolean mainScreen, Boolean widget) {
        return new CameraObject(mainScreenOrder, uuid, title, widgetOrder, mainScreen, widget);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraObject)) {
            return false;
        }
        CameraObject cameraObject = (CameraObject) other;
        return Intrinsics.areEqual(this.mainScreenOrder, cameraObject.mainScreenOrder) && Intrinsics.areEqual(this.uuid, cameraObject.uuid) && Intrinsics.areEqual(this.title, cameraObject.title) && Intrinsics.areEqual(this.widgetOrder, cameraObject.widgetOrder) && Intrinsics.areEqual(this.mainScreen, cameraObject.mainScreen) && Intrinsics.areEqual(this.widget, cameraObject.widget);
    }

    public int hashCode() {
        Integer num = this.mainScreenOrder;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.uuid;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.widgetOrder;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.mainScreen;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.widget;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "CameraObject(mainScreenOrder=" + this.mainScreenOrder + ", uuid=" + this.uuid + ", title=" + this.title + ", widgetOrder=" + this.widgetOrder + ", mainScreen=" + this.mainScreen + ", widget=" + this.widget + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.mainScreenOrder;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.uuid);
        parcel.writeString(this.title);
        Integer num2 = this.widgetOrder;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Boolean bool = this.mainScreen;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.widget;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }

    public CameraObject(Integer num, String str, String str2, Integer num2, Boolean bool, Boolean bool2) {
        this.mainScreenOrder = num;
        this.uuid = str;
        this.title = str2;
        this.widgetOrder = num2;
        this.mainScreen = bool;
        this.widget = bool2;
    }

    public /* synthetic */ CameraObject(Integer num, String str, String str2, Integer num2, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2);
    }

    public final Integer getMainScreenOrder() {
        return this.mainScreenOrder;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final Integer getWidgetOrder() {
        return this.widgetOrder;
    }

    public final Boolean getMainScreen() {
        return this.mainScreen;
    }

    public final Boolean getWidget() {
        return this.widget;
    }
}
