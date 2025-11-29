package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/sputnik/common/entities/localization/AddAddressBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "cityLabel", "streetLabel", "houseLabel", "appartmentLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "saveButton", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getCityLabel", "()Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getStreetLabel", "getHouseLabel", "getAppartmentLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSaveButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AddAddressBody implements Parcelable {
    public static final Parcelable.Creator<AddAddressBody> CREATOR = new Creator();

    @SerializedName("appartment_textfield")
    private final TextPlaceHolder appartmentLabel;

    @SerializedName("city_textfield")
    private final TextPlaceHolder cityLabel;

    @SerializedName("house_textfield")
    private final TextPlaceHolder houseLabel;

    @SerializedName("save_button")
    private final TextTitle saveButton;

    @SerializedName("street_textfield")
    private final TextPlaceHolder streetLabel;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddAddressBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddAddressBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddAddressBody((TextPlaceHolder) parcel.readParcelable(AddAddressBody.class.getClassLoader()), (TextPlaceHolder) parcel.readParcelable(AddAddressBody.class.getClassLoader()), (TextPlaceHolder) parcel.readParcelable(AddAddressBody.class.getClassLoader()), (TextPlaceHolder) parcel.readParcelable(AddAddressBody.class.getClassLoader()), (TextTitle) parcel.readParcelable(AddAddressBody.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddAddressBody[] newArray(int i) {
            return new AddAddressBody[i];
        }
    }

    public AddAddressBody() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddAddressBody)) {
            return false;
        }
        AddAddressBody addAddressBody = (AddAddressBody) other;
        return Intrinsics.areEqual(this.cityLabel, addAddressBody.cityLabel) && Intrinsics.areEqual(this.streetLabel, addAddressBody.streetLabel) && Intrinsics.areEqual(this.houseLabel, addAddressBody.houseLabel) && Intrinsics.areEqual(this.appartmentLabel, addAddressBody.appartmentLabel) && Intrinsics.areEqual(this.saveButton, addAddressBody.saveButton);
    }

    public int hashCode() {
        TextPlaceHolder textPlaceHolder = this.cityLabel;
        int iHashCode = (textPlaceHolder == null ? 0 : textPlaceHolder.hashCode()) * 31;
        TextPlaceHolder textPlaceHolder2 = this.streetLabel;
        int iHashCode2 = (iHashCode + (textPlaceHolder2 == null ? 0 : textPlaceHolder2.hashCode())) * 31;
        TextPlaceHolder textPlaceHolder3 = this.houseLabel;
        int iHashCode3 = (iHashCode2 + (textPlaceHolder3 == null ? 0 : textPlaceHolder3.hashCode())) * 31;
        TextPlaceHolder textPlaceHolder4 = this.appartmentLabel;
        int iHashCode4 = (iHashCode3 + (textPlaceHolder4 == null ? 0 : textPlaceHolder4.hashCode())) * 31;
        TextTitle textTitle = this.saveButton;
        return iHashCode4 + (textTitle != null ? textTitle.hashCode() : 0);
    }

    public String toString() {
        return "AddAddressBody(cityLabel=" + this.cityLabel + ", streetLabel=" + this.streetLabel + ", houseLabel=" + this.houseLabel + ", appartmentLabel=" + this.appartmentLabel + ", saveButton=" + this.saveButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.cityLabel, flags);
        parcel.writeParcelable(this.streetLabel, flags);
        parcel.writeParcelable(this.houseLabel, flags);
        parcel.writeParcelable(this.appartmentLabel, flags);
        parcel.writeParcelable(this.saveButton, flags);
    }

    public AddAddressBody(TextPlaceHolder textPlaceHolder, TextPlaceHolder textPlaceHolder2, TextPlaceHolder textPlaceHolder3, TextPlaceHolder textPlaceHolder4, TextTitle textTitle) {
        this.cityLabel = textPlaceHolder;
        this.streetLabel = textPlaceHolder2;
        this.houseLabel = textPlaceHolder3;
        this.appartmentLabel = textPlaceHolder4;
        this.saveButton = textTitle;
    }

    public /* synthetic */ AddAddressBody(TextPlaceHolder textPlaceHolder, TextPlaceHolder textPlaceHolder2, TextPlaceHolder textPlaceHolder3, TextPlaceHolder textPlaceHolder4, TextTitle textTitle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textPlaceHolder, (i & 2) != 0 ? null : textPlaceHolder2, (i & 4) != 0 ? null : textPlaceHolder3, (i & 8) != 0 ? null : textPlaceHolder4, (i & 16) != 0 ? null : textTitle);
    }

    public final TextPlaceHolder getCityLabel() {
        return this.cityLabel;
    }

    public final TextPlaceHolder getStreetLabel() {
        return this.streetLabel;
    }

    public final TextPlaceHolder getHouseLabel() {
        return this.houseLabel;
    }

    public final TextPlaceHolder getAppartmentLabel() {
        return this.appartmentLabel;
    }

    public final TextTitle getSaveButton() {
        return this.saveButton;
    }
}
