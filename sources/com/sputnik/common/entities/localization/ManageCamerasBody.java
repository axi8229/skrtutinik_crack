package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/common/entities/localization/ManageCamerasBody;", "Landroid/os/Parcelable;", "", "", "sectionTitles", "sectionTitlesMainScreen", "tabs", "Lcom/sputnik/common/entities/localization/ManageCamerasBottomView;", "bottomView", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/sputnik/common/entities/localization/ManageCamerasBottomView;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getSectionTitles", "()Ljava/util/List;", "getSectionTitlesMainScreen", "getTabs", "Lcom/sputnik/common/entities/localization/ManageCamerasBottomView;", "getBottomView", "()Lcom/sputnik/common/entities/localization/ManageCamerasBottomView;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ManageCamerasBody implements Parcelable {
    public static final Parcelable.Creator<ManageCamerasBody> CREATOR = new Creator();

    @SerializedName("bottom_view")
    private final ManageCamerasBottomView bottomView;

    @SerializedName("section_titles_widget")
    private final List<String> sectionTitles;

    @SerializedName("section_titles_main_screen")
    private final List<String> sectionTitlesMainScreen;

    @SerializedName("tabs")
    private final List<String> tabs;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ManageCamerasBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ManageCamerasBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ManageCamerasBody(parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : ManageCamerasBottomView.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ManageCamerasBody[] newArray(int i) {
            return new ManageCamerasBody[i];
        }
    }

    public ManageCamerasBody() {
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
        if (!(other instanceof ManageCamerasBody)) {
            return false;
        }
        ManageCamerasBody manageCamerasBody = (ManageCamerasBody) other;
        return Intrinsics.areEqual(this.sectionTitles, manageCamerasBody.sectionTitles) && Intrinsics.areEqual(this.sectionTitlesMainScreen, manageCamerasBody.sectionTitlesMainScreen) && Intrinsics.areEqual(this.tabs, manageCamerasBody.tabs) && Intrinsics.areEqual(this.bottomView, manageCamerasBody.bottomView);
    }

    public int hashCode() {
        List<String> list = this.sectionTitles;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.sectionTitlesMainScreen;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.tabs;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        ManageCamerasBottomView manageCamerasBottomView = this.bottomView;
        return iHashCode3 + (manageCamerasBottomView != null ? manageCamerasBottomView.hashCode() : 0);
    }

    public String toString() {
        return "ManageCamerasBody(sectionTitles=" + this.sectionTitles + ", sectionTitlesMainScreen=" + this.sectionTitlesMainScreen + ", tabs=" + this.tabs + ", bottomView=" + this.bottomView + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.sectionTitles);
        parcel.writeStringList(this.sectionTitlesMainScreen);
        parcel.writeStringList(this.tabs);
        ManageCamerasBottomView manageCamerasBottomView = this.bottomView;
        if (manageCamerasBottomView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            manageCamerasBottomView.writeToParcel(parcel, flags);
        }
    }

    public ManageCamerasBody(List<String> list, List<String> list2, List<String> list3, ManageCamerasBottomView manageCamerasBottomView) {
        this.sectionTitles = list;
        this.sectionTitlesMainScreen = list2;
        this.tabs = list3;
        this.bottomView = manageCamerasBottomView;
    }

    public /* synthetic */ ManageCamerasBody(List list, List list2, List list3, ManageCamerasBottomView manageCamerasBottomView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : manageCamerasBottomView);
    }

    public final List<String> getSectionTitles() {
        return this.sectionTitles;
    }

    public final List<String> getSectionTitlesMainScreen() {
        return this.sectionTitlesMainScreen;
    }

    public final List<String> getTabs() {
        return this.tabs;
    }

    public final ManageCamerasBottomView getBottomView() {
        return this.bottomView;
    }
}
