package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationBody.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b!\u0010\u001f¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/WaitingScreen;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "continueButton", "doneButton", "instructionsButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getContinueButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getDoneButton", "getInstructionsButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WaitingScreen implements Parcelable {
    public static final Parcelable.Creator<WaitingScreen> CREATOR = new Creator();

    @SerializedName("continue_button")
    private final TextTitle continueButton;

    @SerializedName("done_button")
    private final TextTitle doneButton;

    @SerializedName("instructions_button")
    private final TextTitle instructionsButton;
    private final String title;

    /* compiled from: AuthorizationBody.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WaitingScreen> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WaitingScreen createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WaitingScreen(parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WaitingScreen[] newArray(int i) {
            return new WaitingScreen[i];
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
        if (!(other instanceof WaitingScreen)) {
            return false;
        }
        WaitingScreen waitingScreen = (WaitingScreen) other;
        return Intrinsics.areEqual(this.title, waitingScreen.title) && Intrinsics.areEqual(this.continueButton, waitingScreen.continueButton) && Intrinsics.areEqual(this.doneButton, waitingScreen.doneButton) && Intrinsics.areEqual(this.instructionsButton, waitingScreen.instructionsButton);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        TextTitle textTitle = this.continueButton;
        int iHashCode2 = (iHashCode + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        TextTitle textTitle2 = this.doneButton;
        int iHashCode3 = (iHashCode2 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        TextTitle textTitle3 = this.instructionsButton;
        return iHashCode3 + (textTitle3 != null ? textTitle3.hashCode() : 0);
    }

    public String toString() {
        return "WaitingScreen(title=" + this.title + ", continueButton=" + this.continueButton + ", doneButton=" + this.doneButton + ", instructionsButton=" + this.instructionsButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        TextTitle textTitle = this.continueButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
        TextTitle textTitle2 = this.doneButton;
        if (textTitle2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle2.writeToParcel(parcel, flags);
        }
        TextTitle textTitle3 = this.instructionsButton;
        if (textTitle3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle3.writeToParcel(parcel, flags);
        }
    }

    public WaitingScreen(String str, TextTitle textTitle, TextTitle textTitle2, TextTitle textTitle3) {
        this.title = str;
        this.continueButton = textTitle;
        this.doneButton = textTitle2;
        this.instructionsButton = textTitle3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextTitle getContinueButton() {
        return this.continueButton;
    }

    public final TextTitle getDoneButton() {
        return this.doneButton;
    }

    public final TextTitle getInstructionsButton() {
        return this.instructionsButton;
    }
}
