package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001:\u0001,BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b'\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/sputnik/common/entities/localization/ManageCamerasLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/ManageCamerasBody;", "body", "", "errorInWidget", "errorInMainScreen", "errorTooMuch", "Lcom/sputnik/common/entities/localization/ManageCamerasLocale$ResetCamerasSettingsLocale;", "resetCamerasSettings", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/ManageCamerasBody;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/ManageCamerasLocale$ResetCamerasSettingsLocale;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/ManageCamerasBody;", "getBody", "()Lcom/sputnik/common/entities/localization/ManageCamerasBody;", "Ljava/lang/String;", "getErrorInWidget", "getErrorInMainScreen", "getErrorTooMuch", "Lcom/sputnik/common/entities/localization/ManageCamerasLocale$ResetCamerasSettingsLocale;", "getResetCamerasSettings", "()Lcom/sputnik/common/entities/localization/ManageCamerasLocale$ResetCamerasSettingsLocale;", "ResetCamerasSettingsLocale", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ManageCamerasLocale implements Parcelable {
    public static final Parcelable.Creator<ManageCamerasLocale> CREATOR = new Creator();
    private final ManageCamerasBody body;

    @SerializedName("error_in_main_screen")
    private final String errorInMainScreen;

    @SerializedName("error_in_widget")
    private final String errorInWidget;

    @SerializedName("error_too_much")
    private final String errorTooMuch;
    private final TextTitle navigation;

    @SerializedName("reset_cameras_settings")
    private final ResetCamerasSettingsLocale resetCamerasSettings;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ManageCamerasLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ManageCamerasLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ManageCamerasLocale((TextTitle) parcel.readParcelable(ManageCamerasLocale.class.getClassLoader()), parcel.readInt() == 0 ? null : ManageCamerasBody.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? ResetCamerasSettingsLocale.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ManageCamerasLocale[] newArray(int i) {
            return new ManageCamerasLocale[i];
        }
    }

    public ManageCamerasLocale() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageCamerasLocale)) {
            return false;
        }
        ManageCamerasLocale manageCamerasLocale = (ManageCamerasLocale) other;
        return Intrinsics.areEqual(this.navigation, manageCamerasLocale.navigation) && Intrinsics.areEqual(this.body, manageCamerasLocale.body) && Intrinsics.areEqual(this.errorInWidget, manageCamerasLocale.errorInWidget) && Intrinsics.areEqual(this.errorInMainScreen, manageCamerasLocale.errorInMainScreen) && Intrinsics.areEqual(this.errorTooMuch, manageCamerasLocale.errorTooMuch) && Intrinsics.areEqual(this.resetCamerasSettings, manageCamerasLocale.resetCamerasSettings);
    }

    public int hashCode() {
        TextTitle textTitle = this.navigation;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        ManageCamerasBody manageCamerasBody = this.body;
        int iHashCode2 = (iHashCode + (manageCamerasBody == null ? 0 : manageCamerasBody.hashCode())) * 31;
        String str = this.errorInWidget;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorInMainScreen;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.errorTooMuch;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ResetCamerasSettingsLocale resetCamerasSettingsLocale = this.resetCamerasSettings;
        return iHashCode5 + (resetCamerasSettingsLocale != null ? resetCamerasSettingsLocale.hashCode() : 0);
    }

    public String toString() {
        return "ManageCamerasLocale(navigation=" + this.navigation + ", body=" + this.body + ", errorInWidget=" + this.errorInWidget + ", errorInMainScreen=" + this.errorInMainScreen + ", errorTooMuch=" + this.errorTooMuch + ", resetCamerasSettings=" + this.resetCamerasSettings + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.navigation, flags);
        ManageCamerasBody manageCamerasBody = this.body;
        if (manageCamerasBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            manageCamerasBody.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.errorInWidget);
        parcel.writeString(this.errorInMainScreen);
        parcel.writeString(this.errorTooMuch);
        ResetCamerasSettingsLocale resetCamerasSettingsLocale = this.resetCamerasSettings;
        if (resetCamerasSettingsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            resetCamerasSettingsLocale.writeToParcel(parcel, flags);
        }
    }

    public ManageCamerasLocale(TextTitle textTitle, ManageCamerasBody manageCamerasBody, String str, String str2, String str3, ResetCamerasSettingsLocale resetCamerasSettingsLocale) {
        this.navigation = textTitle;
        this.body = manageCamerasBody;
        this.errorInWidget = str;
        this.errorInMainScreen = str2;
        this.errorTooMuch = str3;
        this.resetCamerasSettings = resetCamerasSettingsLocale;
    }

    public /* synthetic */ ManageCamerasLocale(TextTitle textTitle, ManageCamerasBody manageCamerasBody, String str, String str2, String str3, ResetCamerasSettingsLocale resetCamerasSettingsLocale, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : manageCamerasBody, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : resetCamerasSettingsLocale);
    }

    public final TextTitle getNavigation() {
        return this.navigation;
    }

    public final ManageCamerasBody getBody() {
        return this.body;
    }

    public final String getErrorInWidget() {
        return this.errorInWidget;
    }

    public final String getErrorInMainScreen() {
        return this.errorInMainScreen;
    }

    public final String getErrorTooMuch() {
        return this.errorTooMuch;
    }

    public final ResetCamerasSettingsLocale getResetCamerasSettings() {
        return this.resetCamerasSettings;
    }

    /* compiled from: LocalizationModel.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/ManageCamerasLocale$ResetCamerasSettingsLocale;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "cancelButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ResetCamerasSettingsLocale implements Parcelable {
        public static final Parcelable.Creator<ResetCamerasSettingsLocale> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("ok_button")
        private final TextTitle okButton;
        private final String subtitle;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String title;

        /* compiled from: LocalizationModel.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ResetCamerasSettingsLocale> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResetCamerasSettingsLocale createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ResetCamerasSettingsLocale(parcel.readString(), parcel.readString(), (TextTitle) parcel.readParcelable(ResetCamerasSettingsLocale.class.getClassLoader()), (TextTitle) parcel.readParcelable(ResetCamerasSettingsLocale.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResetCamerasSettingsLocale[] newArray(int i) {
                return new ResetCamerasSettingsLocale[i];
            }
        }

        public ResetCamerasSettingsLocale() {
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
            if (!(other instanceof ResetCamerasSettingsLocale)) {
                return false;
            }
            ResetCamerasSettingsLocale resetCamerasSettingsLocale = (ResetCamerasSettingsLocale) other;
            return Intrinsics.areEqual(this.title, resetCamerasSettingsLocale.title) && Intrinsics.areEqual(this.subtitle, resetCamerasSettingsLocale.subtitle) && Intrinsics.areEqual(this.okButton, resetCamerasSettingsLocale.okButton) && Intrinsics.areEqual(this.cancelButton, resetCamerasSettingsLocale.cancelButton);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.subtitle;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.okButton;
            int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            return iHashCode3 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "ResetCamerasSettingsLocale(title=" + this.title + ", subtitle=" + this.subtitle + ", okButton=" + this.okButton + ", cancelButton=" + this.cancelButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            parcel.writeParcelable(this.okButton, flags);
            parcel.writeParcelable(this.cancelButton, flags);
        }

        public ResetCamerasSettingsLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2) {
            this.title = str;
            this.subtitle = str2;
            this.okButton = textTitle;
            this.cancelButton = textTitle2;
        }

        public /* synthetic */ ResetCamerasSettingsLocale(String str, String str2, TextTitle textTitle, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : textTitle, (i & 8) != 0 ? null : textTitle2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final TextTitle getOkButton() {
            return this.okButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }
    }
}
