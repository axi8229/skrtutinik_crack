package com.sputnik.common.entities.localization.entities.authorization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationNeedHelpLocale.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b\"\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010\f¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "mainText", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "otherMethodButton", "supportButton", "", "supportText", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getMainText", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOtherMethodButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSupportButton", "Ljava/lang/String;", "getSupportText", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthorizationNeedHelpLocale implements Parcelable {
    public static final Parcelable.Creator<AuthorizationNeedHelpLocale> CREATOR = new Creator();

    @SerializedName("main_text")
    private final TitleWithParam mainText;

    @SerializedName("other_method_button")
    private final TextTitle otherMethodButton;

    @SerializedName("support_button")
    private final TextTitle supportButton;

    @SerializedName("support_text")
    private final String supportText;

    /* compiled from: AuthorizationNeedHelpLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthorizationNeedHelpLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationNeedHelpLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthorizationNeedHelpLocale(parcel.readInt() == 0 ? null : TitleWithParam.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationNeedHelpLocale[] newArray(int i) {
            return new AuthorizationNeedHelpLocale[i];
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
        if (!(other instanceof AuthorizationNeedHelpLocale)) {
            return false;
        }
        AuthorizationNeedHelpLocale authorizationNeedHelpLocale = (AuthorizationNeedHelpLocale) other;
        return Intrinsics.areEqual(this.mainText, authorizationNeedHelpLocale.mainText) && Intrinsics.areEqual(this.otherMethodButton, authorizationNeedHelpLocale.otherMethodButton) && Intrinsics.areEqual(this.supportButton, authorizationNeedHelpLocale.supportButton) && Intrinsics.areEqual(this.supportText, authorizationNeedHelpLocale.supportText);
    }

    public int hashCode() {
        TitleWithParam titleWithParam = this.mainText;
        int iHashCode = (titleWithParam == null ? 0 : titleWithParam.hashCode()) * 31;
        TextTitle textTitle = this.otherMethodButton;
        int iHashCode2 = (iHashCode + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        TextTitle textTitle2 = this.supportButton;
        int iHashCode3 = (iHashCode2 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        String str = this.supportText;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AuthorizationNeedHelpLocale(mainText=" + this.mainText + ", otherMethodButton=" + this.otherMethodButton + ", supportButton=" + this.supportButton + ", supportText=" + this.supportText + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        TitleWithParam titleWithParam = this.mainText;
        if (titleWithParam == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            titleWithParam.writeToParcel(parcel, flags);
        }
        TextTitle textTitle = this.otherMethodButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
        TextTitle textTitle2 = this.supportButton;
        if (textTitle2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle2.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.supportText);
    }

    public AuthorizationNeedHelpLocale(TitleWithParam titleWithParam, TextTitle textTitle, TextTitle textTitle2, String str) {
        this.mainText = titleWithParam;
        this.otherMethodButton = textTitle;
        this.supportButton = textTitle2;
        this.supportText = str;
    }

    public final TitleWithParam getMainText() {
        return this.mainText;
    }

    public final TextTitle getOtherMethodButton() {
        return this.otherMethodButton;
    }

    public final TextTitle getSupportButton() {
        return this.supportButton;
    }

    public final String getSupportText() {
        return this.supportText;
    }
}
