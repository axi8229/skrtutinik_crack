package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationBody.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b&\u0010%¨\u0006'"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationMain;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "description", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "callButton", "changeButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBody", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getDescription", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCallButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getChangeButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthorizationMain implements Parcelable {
    public static final Parcelable.Creator<AuthorizationMain> CREATOR = new Creator();
    private final String body;

    @SerializedName("call_button")
    private final TextTitle callButton;

    @SerializedName("change_button")
    private final TextTitle changeButton;
    private final TitleWithParam description;
    private final String title;

    /* compiled from: AuthorizationBody.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthorizationMain> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationMain createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthorizationMain(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TitleWithParam.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationMain[] newArray(int i) {
            return new AuthorizationMain[i];
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
        if (!(other instanceof AuthorizationMain)) {
            return false;
        }
        AuthorizationMain authorizationMain = (AuthorizationMain) other;
        return Intrinsics.areEqual(this.title, authorizationMain.title) && Intrinsics.areEqual(this.body, authorizationMain.body) && Intrinsics.areEqual(this.description, authorizationMain.description) && Intrinsics.areEqual(this.callButton, authorizationMain.callButton) && Intrinsics.areEqual(this.changeButton, authorizationMain.changeButton);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.body;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        TitleWithParam titleWithParam = this.description;
        int iHashCode3 = (iHashCode2 + (titleWithParam == null ? 0 : titleWithParam.hashCode())) * 31;
        TextTitle textTitle = this.callButton;
        int iHashCode4 = (iHashCode3 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        TextTitle textTitle2 = this.changeButton;
        return iHashCode4 + (textTitle2 != null ? textTitle2.hashCode() : 0);
    }

    public String toString() {
        return "AuthorizationMain(title=" + this.title + ", body=" + this.body + ", description=" + this.description + ", callButton=" + this.callButton + ", changeButton=" + this.changeButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        TitleWithParam titleWithParam = this.description;
        if (titleWithParam == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            titleWithParam.writeToParcel(parcel, flags);
        }
        TextTitle textTitle = this.callButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
        TextTitle textTitle2 = this.changeButton;
        if (textTitle2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle2.writeToParcel(parcel, flags);
        }
    }

    public AuthorizationMain(String str, String str2, TitleWithParam titleWithParam, TextTitle textTitle, TextTitle textTitle2) {
        this.title = str;
        this.body = str2;
        this.description = titleWithParam;
        this.callButton = textTitle;
        this.changeButton = textTitle2;
    }
}
