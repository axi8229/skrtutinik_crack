package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\nR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/ManageCamerasBottomView;", "Landroid/os/Parcelable;", "", "titleWidget", "titleMainScreen", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "saveButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitleWidget", "getTitleMainScreen", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSaveButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ManageCamerasBottomView implements Parcelable {
    public static final Parcelable.Creator<ManageCamerasBottomView> CREATOR = new Creator();

    @SerializedName("save_button")
    private final TextTitle saveButton;

    @SerializedName("title_main_screen")
    private final String titleMainScreen;

    @SerializedName("title_widget")
    private final String titleWidget;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ManageCamerasBottomView> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ManageCamerasBottomView createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ManageCamerasBottomView(parcel.readString(), parcel.readString(), (TextTitle) parcel.readParcelable(ManageCamerasBottomView.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ManageCamerasBottomView[] newArray(int i) {
            return new ManageCamerasBottomView[i];
        }
    }

    public ManageCamerasBottomView() {
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
        if (!(other instanceof ManageCamerasBottomView)) {
            return false;
        }
        ManageCamerasBottomView manageCamerasBottomView = (ManageCamerasBottomView) other;
        return Intrinsics.areEqual(this.titleWidget, manageCamerasBottomView.titleWidget) && Intrinsics.areEqual(this.titleMainScreen, manageCamerasBottomView.titleMainScreen) && Intrinsics.areEqual(this.saveButton, manageCamerasBottomView.saveButton);
    }

    public int hashCode() {
        String str = this.titleWidget;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.titleMainScreen;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        TextTitle textTitle = this.saveButton;
        return iHashCode2 + (textTitle != null ? textTitle.hashCode() : 0);
    }

    public String toString() {
        return "ManageCamerasBottomView(titleWidget=" + this.titleWidget + ", titleMainScreen=" + this.titleMainScreen + ", saveButton=" + this.saveButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.titleWidget);
        parcel.writeString(this.titleMainScreen);
        parcel.writeParcelable(this.saveButton, flags);
    }

    public ManageCamerasBottomView(String str, String str2, TextTitle textTitle) {
        this.titleWidget = str;
        this.titleMainScreen = str2;
        this.saveButton = textTitle;
    }

    public /* synthetic */ ManageCamerasBottomView(String str, String str2, TextTitle textTitle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : textTitle);
    }

    public final String getTitleWidget() {
        return this.titleWidget;
    }

    public final String getTitleMainScreen() {
        return this.titleMainScreen;
    }

    public final TextTitle getSaveButton() {
        return this.saveButton;
    }
}
