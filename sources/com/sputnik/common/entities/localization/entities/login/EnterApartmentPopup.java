package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmAddressLocale.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b(\u0010'¨\u0006)"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/EnterApartmentPopup;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "addressTitle", "Lcom/sputnik/common/entities/localization/entities/login/ApartmentTextField;", "apartmentTextField", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "doneButton", "cancelButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/login/ApartmentTextField;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBody", "getAddressTitle", "Lcom/sputnik/common/entities/localization/entities/login/ApartmentTextField;", "getApartmentTextField", "()Lcom/sputnik/common/entities/localization/entities/login/ApartmentTextField;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getDoneButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EnterApartmentPopup implements Parcelable {
    public static final Parcelable.Creator<EnterApartmentPopup> CREATOR = new Creator();

    @SerializedName("address_title")
    private final String addressTitle;

    @SerializedName("apartment_text_field")
    private final ApartmentTextField apartmentTextField;
    private final String body;

    @SerializedName("cancel_button")
    private final TextTitle cancelButton;

    @SerializedName("done_button")
    private final TextTitle doneButton;
    private final String title;

    /* compiled from: ConfirmAddressLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EnterApartmentPopup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterApartmentPopup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            ApartmentTextField apartmentTextFieldCreateFromParcel = ApartmentTextField.CREATOR.createFromParcel(parcel);
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new EnterApartmentPopup(string, string2, string3, apartmentTextFieldCreateFromParcel, creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterApartmentPopup[] newArray(int i) {
            return new EnterApartmentPopup[i];
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
        if (!(other instanceof EnterApartmentPopup)) {
            return false;
        }
        EnterApartmentPopup enterApartmentPopup = (EnterApartmentPopup) other;
        return Intrinsics.areEqual(this.title, enterApartmentPopup.title) && Intrinsics.areEqual(this.body, enterApartmentPopup.body) && Intrinsics.areEqual(this.addressTitle, enterApartmentPopup.addressTitle) && Intrinsics.areEqual(this.apartmentTextField, enterApartmentPopup.apartmentTextField) && Intrinsics.areEqual(this.doneButton, enterApartmentPopup.doneButton) && Intrinsics.areEqual(this.cancelButton, enterApartmentPopup.cancelButton);
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.body.hashCode()) * 31) + this.addressTitle.hashCode()) * 31) + this.apartmentTextField.hashCode()) * 31) + this.doneButton.hashCode()) * 31) + this.cancelButton.hashCode();
    }

    public String toString() {
        return "EnterApartmentPopup(title=" + this.title + ", body=" + this.body + ", addressTitle=" + this.addressTitle + ", apartmentTextField=" + this.apartmentTextField + ", doneButton=" + this.doneButton + ", cancelButton=" + this.cancelButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        parcel.writeString(this.addressTitle);
        this.apartmentTextField.writeToParcel(parcel, flags);
        this.doneButton.writeToParcel(parcel, flags);
        this.cancelButton.writeToParcel(parcel, flags);
    }

    public EnterApartmentPopup(String title, String body, String addressTitle, ApartmentTextField apartmentTextField, TextTitle doneButton, TextTitle cancelButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(addressTitle, "addressTitle");
        Intrinsics.checkNotNullParameter(apartmentTextField, "apartmentTextField");
        Intrinsics.checkNotNullParameter(doneButton, "doneButton");
        Intrinsics.checkNotNullParameter(cancelButton, "cancelButton");
        this.title = title;
        this.body = body;
        this.addressTitle = addressTitle;
        this.apartmentTextField = apartmentTextField;
        this.doneButton = doneButton;
        this.cancelButton = cancelButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getAddressTitle() {
        return this.addressTitle;
    }

    public final ApartmentTextField getApartmentTextField() {
        return this.apartmentTextField;
    }

    public final TextTitle getDoneButton() {
        return this.doneButton;
    }

    public final TextTitle getCancelButton() {
        return this.cancelButton;
    }
}
