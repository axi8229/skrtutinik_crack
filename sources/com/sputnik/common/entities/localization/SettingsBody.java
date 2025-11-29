package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b'\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b(\u0010$R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b,\u0010+R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b-\u0010\u0012R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b1\u0010\u0012¨\u00062"}, d2 = {"Lcom/sputnik/common/entities/localization/SettingsBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "updateButton", "", "addressLabel", "addAddressButton", "changeAddressButton", "", "settingsItems", "sectionTitles", "noAddressTitle", "Lcom/sputnik/common/entities/localization/SettingsAddress;", "address", "btnPromoWantMore", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/sputnik/common/entities/localization/SettingsAddress;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getUpdateButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Ljava/lang/String;", "getAddressLabel", "getAddAddressButton", "getChangeAddressButton", "Ljava/util/List;", "getSettingsItems", "()Ljava/util/List;", "getSectionTitles", "getNoAddressTitle", "Lcom/sputnik/common/entities/localization/SettingsAddress;", "getAddress", "()Lcom/sputnik/common/entities/localization/SettingsAddress;", "getBtnPromoWantMore", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SettingsBody implements Parcelable {
    public static final Parcelable.Creator<SettingsBody> CREATOR = new Creator();

    @SerializedName("add_address_button")
    private final TextTitle addAddressButton;
    private final SettingsAddress address;

    @SerializedName("current_address_title_label")
    private final String addressLabel;

    @SerializedName("btn_promo_want_more")
    private final String btnPromoWantMore;

    @SerializedName("change_address_button")
    private final TextTitle changeAddressButton;

    @SerializedName("no_address_title")
    private final String noAddressTitle;

    @SerializedName("section_titles")
    private final List<String> sectionTitles;

    @SerializedName("setting_items")
    private final List<String> settingsItems;

    @SerializedName("update_button")
    private final TextTitle updateButton;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SettingsBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SettingsBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SettingsBody((TextTitle) parcel.readParcelable(SettingsBody.class.getClassLoader()), parcel.readString(), (TextTitle) parcel.readParcelable(SettingsBody.class.getClassLoader()), (TextTitle) parcel.readParcelable(SettingsBody.class.getClassLoader()), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt() == 0 ? null : SettingsAddress.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SettingsBody[] newArray(int i) {
            return new SettingsBody[i];
        }
    }

    public SettingsBody() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsBody)) {
            return false;
        }
        SettingsBody settingsBody = (SettingsBody) other;
        return Intrinsics.areEqual(this.updateButton, settingsBody.updateButton) && Intrinsics.areEqual(this.addressLabel, settingsBody.addressLabel) && Intrinsics.areEqual(this.addAddressButton, settingsBody.addAddressButton) && Intrinsics.areEqual(this.changeAddressButton, settingsBody.changeAddressButton) && Intrinsics.areEqual(this.settingsItems, settingsBody.settingsItems) && Intrinsics.areEqual(this.sectionTitles, settingsBody.sectionTitles) && Intrinsics.areEqual(this.noAddressTitle, settingsBody.noAddressTitle) && Intrinsics.areEqual(this.address, settingsBody.address) && Intrinsics.areEqual(this.btnPromoWantMore, settingsBody.btnPromoWantMore);
    }

    public int hashCode() {
        TextTitle textTitle = this.updateButton;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        String str = this.addressLabel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        TextTitle textTitle2 = this.addAddressButton;
        int iHashCode3 = (iHashCode2 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        TextTitle textTitle3 = this.changeAddressButton;
        int iHashCode4 = (iHashCode3 + (textTitle3 == null ? 0 : textTitle3.hashCode())) * 31;
        List<String> list = this.settingsItems;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.sectionTitles;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.noAddressTitle;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        SettingsAddress settingsAddress = this.address;
        int iHashCode8 = (iHashCode7 + (settingsAddress == null ? 0 : settingsAddress.hashCode())) * 31;
        String str3 = this.btnPromoWantMore;
        return iHashCode8 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SettingsBody(updateButton=" + this.updateButton + ", addressLabel=" + this.addressLabel + ", addAddressButton=" + this.addAddressButton + ", changeAddressButton=" + this.changeAddressButton + ", settingsItems=" + this.settingsItems + ", sectionTitles=" + this.sectionTitles + ", noAddressTitle=" + this.noAddressTitle + ", address=" + this.address + ", btnPromoWantMore=" + this.btnPromoWantMore + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.updateButton, flags);
        parcel.writeString(this.addressLabel);
        parcel.writeParcelable(this.addAddressButton, flags);
        parcel.writeParcelable(this.changeAddressButton, flags);
        parcel.writeStringList(this.settingsItems);
        parcel.writeStringList(this.sectionTitles);
        parcel.writeString(this.noAddressTitle);
        SettingsAddress settingsAddress = this.address;
        if (settingsAddress == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            settingsAddress.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.btnPromoWantMore);
    }

    public SettingsBody(TextTitle textTitle, String str, TextTitle textTitle2, TextTitle textTitle3, List<String> list, List<String> list2, String str2, SettingsAddress settingsAddress, String str3) {
        this.updateButton = textTitle;
        this.addressLabel = str;
        this.addAddressButton = textTitle2;
        this.changeAddressButton = textTitle3;
        this.settingsItems = list;
        this.sectionTitles = list2;
        this.noAddressTitle = str2;
        this.address = settingsAddress;
        this.btnPromoWantMore = str3;
    }

    public /* synthetic */ SettingsBody(TextTitle textTitle, String str, TextTitle textTitle2, TextTitle textTitle3, List list, List list2, String str2, SettingsAddress settingsAddress, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : textTitle2, (i & 8) != 0 ? null : textTitle3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : settingsAddress, (i & 256) == 0 ? str3 : null);
    }

    public final TextTitle getUpdateButton() {
        return this.updateButton;
    }

    public final String getAddressLabel() {
        return this.addressLabel;
    }

    public final TextTitle getAddAddressButton() {
        return this.addAddressButton;
    }

    public final TextTitle getChangeAddressButton() {
        return this.changeAddressButton;
    }

    public final List<String> getSettingsItems() {
        return this.settingsItems;
    }

    public final List<String> getSectionTitles() {
        return this.sectionTitles;
    }

    public final String getNoAddressTitle() {
        return this.noAddressTitle;
    }

    public final SettingsAddress getAddress() {
        return this.address;
    }

    public final String getBtnPromoWantMore() {
        return this.btnPromoWantMore;
    }
}
