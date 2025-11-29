package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/SplashLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/SplashBody;", "body", "Lcom/sputnik/common/entities/localization/SplashErrorsLocale;", "errors", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "errorButton", "<init>", "(Lcom/sputnik/common/entities/localization/SplashBody;Lcom/sputnik/common/entities/localization/SplashErrorsLocale;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/SplashBody;", "getBody", "()Lcom/sputnik/common/entities/localization/SplashBody;", "Lcom/sputnik/common/entities/localization/SplashErrorsLocale;", "getErrors", "()Lcom/sputnik/common/entities/localization/SplashErrorsLocale;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getErrorButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SplashLocale implements Parcelable {
    public static final Parcelable.Creator<SplashLocale> CREATOR = new Creator();
    private final SplashBody body;

    @SerializedName("error_button")
    private final TextTitle errorButton;
    private final SplashErrorsLocale errors;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SplashLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SplashLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SplashLocale(parcel.readInt() == 0 ? null : SplashBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? SplashErrorsLocale.CREATOR.createFromParcel(parcel) : null, (TextTitle) parcel.readParcelable(SplashLocale.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SplashLocale[] newArray(int i) {
            return new SplashLocale[i];
        }
    }

    public SplashLocale() {
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
        if (!(other instanceof SplashLocale)) {
            return false;
        }
        SplashLocale splashLocale = (SplashLocale) other;
        return Intrinsics.areEqual(this.body, splashLocale.body) && Intrinsics.areEqual(this.errors, splashLocale.errors) && Intrinsics.areEqual(this.errorButton, splashLocale.errorButton);
    }

    public int hashCode() {
        SplashBody splashBody = this.body;
        int iHashCode = (splashBody == null ? 0 : splashBody.hashCode()) * 31;
        SplashErrorsLocale splashErrorsLocale = this.errors;
        int iHashCode2 = (iHashCode + (splashErrorsLocale == null ? 0 : splashErrorsLocale.hashCode())) * 31;
        TextTitle textTitle = this.errorButton;
        return iHashCode2 + (textTitle != null ? textTitle.hashCode() : 0);
    }

    public String toString() {
        return "SplashLocale(body=" + this.body + ", errors=" + this.errors + ", errorButton=" + this.errorButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        SplashBody splashBody = this.body;
        if (splashBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            splashBody.writeToParcel(parcel, flags);
        }
        SplashErrorsLocale splashErrorsLocale = this.errors;
        if (splashErrorsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            splashErrorsLocale.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.errorButton, flags);
    }

    public SplashLocale(SplashBody splashBody, SplashErrorsLocale splashErrorsLocale, TextTitle textTitle) {
        this.body = splashBody;
        this.errors = splashErrorsLocale;
        this.errorButton = textTitle;
    }

    public /* synthetic */ SplashLocale(SplashBody splashBody, SplashErrorsLocale splashErrorsLocale, TextTitle textTitle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : splashBody, (i & 2) != 0 ? null : splashErrorsLocale, (i & 4) != 0 ? null : textTitle);
    }

    public final SplashBody getBody() {
        return this.body;
    }

    public final SplashErrorsLocale getErrors() {
        return this.errors;
    }

    public final TextTitle getErrorButton() {
        return this.errorButton;
    }
}
