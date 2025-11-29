package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationBody.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b \u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010\u000b¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AutoSendSmsScreen;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "smsText", "sendSmsButton", "continueOnTabletButton", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getTitle", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "Ljava/lang/String;", "getSmsText", "getSendSmsButton", "getContinueOnTabletButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AutoSendSmsScreen implements Parcelable {
    public static final Parcelable.Creator<AutoSendSmsScreen> CREATOR = new Creator();

    @SerializedName("continue_on_tablet_button")
    private final String continueOnTabletButton;

    @SerializedName("send_sms_button")
    private final String sendSmsButton;

    @SerializedName("sms_text")
    private final String smsText;
    private final TitleWithParam title;

    /* compiled from: AuthorizationBody.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AutoSendSmsScreen> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AutoSendSmsScreen createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AutoSendSmsScreen(parcel.readInt() == 0 ? null : TitleWithParam.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AutoSendSmsScreen[] newArray(int i) {
            return new AutoSendSmsScreen[i];
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
        if (!(other instanceof AutoSendSmsScreen)) {
            return false;
        }
        AutoSendSmsScreen autoSendSmsScreen = (AutoSendSmsScreen) other;
        return Intrinsics.areEqual(this.title, autoSendSmsScreen.title) && Intrinsics.areEqual(this.smsText, autoSendSmsScreen.smsText) && Intrinsics.areEqual(this.sendSmsButton, autoSendSmsScreen.sendSmsButton) && Intrinsics.areEqual(this.continueOnTabletButton, autoSendSmsScreen.continueOnTabletButton);
    }

    public int hashCode() {
        TitleWithParam titleWithParam = this.title;
        int iHashCode = (titleWithParam == null ? 0 : titleWithParam.hashCode()) * 31;
        String str = this.smsText;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sendSmsButton;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.continueOnTabletButton;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AutoSendSmsScreen(title=" + this.title + ", smsText=" + this.smsText + ", sendSmsButton=" + this.sendSmsButton + ", continueOnTabletButton=" + this.continueOnTabletButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        TitleWithParam titleWithParam = this.title;
        if (titleWithParam == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            titleWithParam.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.smsText);
        parcel.writeString(this.sendSmsButton);
        parcel.writeString(this.continueOnTabletButton);
    }

    public AutoSendSmsScreen(TitleWithParam titleWithParam, String str, String str2, String str3) {
        this.title = titleWithParam;
        this.smsText = str;
        this.sendSmsButton = str2;
        this.continueOnTabletButton = str3;
    }

    public final TitleWithParam getTitle() {
        return this.title;
    }

    public final String getSmsText() {
        return this.smsText;
    }

    public final String getSendSmsButton() {
        return this.sendSmsButton;
    }

    public final String getContinueOnTabletButton() {
        return this.continueOnTabletButton;
    }
}
