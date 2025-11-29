package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationBody.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationTelegram;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "numberInfo", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "getTitle", "()Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "getNumberInfo", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthorizationTelegram implements Parcelable {
    public static final Parcelable.Creator<AuthorizationTelegram> CREATOR = new Creator();

    @SerializedName("number_info")
    private final TextWithParam numberInfo;
    private final TextWithParam title;

    /* compiled from: AuthorizationBody.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthorizationTelegram> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationTelegram createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthorizationTelegram(parcel.readInt() == 0 ? null : TextWithParam.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextWithParam.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationTelegram[] newArray(int i) {
            return new AuthorizationTelegram[i];
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
        if (!(other instanceof AuthorizationTelegram)) {
            return false;
        }
        AuthorizationTelegram authorizationTelegram = (AuthorizationTelegram) other;
        return Intrinsics.areEqual(this.title, authorizationTelegram.title) && Intrinsics.areEqual(this.numberInfo, authorizationTelegram.numberInfo);
    }

    public int hashCode() {
        TextWithParam textWithParam = this.title;
        int iHashCode = (textWithParam == null ? 0 : textWithParam.hashCode()) * 31;
        TextWithParam textWithParam2 = this.numberInfo;
        return iHashCode + (textWithParam2 != null ? textWithParam2.hashCode() : 0);
    }

    public String toString() {
        return "AuthorizationTelegram(title=" + this.title + ", numberInfo=" + this.numberInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        TextWithParam textWithParam = this.title;
        if (textWithParam == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textWithParam.writeToParcel(parcel, flags);
        }
        TextWithParam textWithParam2 = this.numberInfo;
        if (textWithParam2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textWithParam2.writeToParcel(parcel, flags);
        }
    }

    public AuthorizationTelegram(TextWithParam textWithParam, TextWithParam textWithParam2) {
        this.title = textWithParam;
        this.numberInfo = textWithParam2;
    }

    public final TextWithParam getTitle() {
        return this.title;
    }

    public final TextWithParam getNumberInfo() {
        return this.numberInfo;
    }
}
