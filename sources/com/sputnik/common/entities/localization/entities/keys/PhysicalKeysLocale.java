package com.sputnik.common.entities.localization.entities.keys;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.localization.entities.common.TitleWithSubtitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhysicalKeysLocale.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001:\u00079:;<=>?BM\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b1\u00102R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u00103\u001a\u0004\b4\u00105R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u00106\u001a\u0004\b7\u00108¨\u0006@"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main;", "main", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$AddKey;", "addKey", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$EditKey;", "editKey", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$DeleteKey;", "deleteKey", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$ErrorPopup;", "errorPopup", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Notifications;", "notifications", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$NeedSubscriptionPopup;", "registerKeyErrorPopup", "<init>", "(Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$AddKey;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$EditKey;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$DeleteKey;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$ErrorPopup;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Notifications;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$NeedSubscriptionPopup;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main;", "getMain", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$AddKey;", "getAddKey", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$AddKey;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$EditKey;", "getEditKey", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$EditKey;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$DeleteKey;", "getDeleteKey", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$DeleteKey;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$ErrorPopup;", "getErrorPopup", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$ErrorPopup;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Notifications;", "getNotifications", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Notifications;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$NeedSubscriptionPopup;", "getRegisterKeyErrorPopup", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$NeedSubscriptionPopup;", "AddKey", "DeleteKey", "EditKey", "ErrorPopup", "Main", "NeedSubscriptionPopup", "Notifications", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PhysicalKeysLocale implements Parcelable {
    public static final Parcelable.Creator<PhysicalKeysLocale> CREATOR = new Creator();

    @SerializedName("add_key")
    private final AddKey addKey;

    @SerializedName("delete_key")
    private final DeleteKey deleteKey;

    @SerializedName("edit_key")
    private final EditKey editKey;

    @SerializedName("error_popup")
    private final ErrorPopup errorPopup;
    private final Main main;
    private final Notifications notifications;

    @SerializedName("register_key_error_popup")
    private final NeedSubscriptionPopup registerKeyErrorPopup;

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhysicalKeysLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhysicalKeysLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhysicalKeysLocale(parcel.readInt() == 0 ? null : Main.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AddKey.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : EditKey.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DeleteKey.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ErrorPopup.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Notifications.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? NeedSubscriptionPopup.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhysicalKeysLocale[] newArray(int i) {
            return new PhysicalKeysLocale[i];
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
        if (!(other instanceof PhysicalKeysLocale)) {
            return false;
        }
        PhysicalKeysLocale physicalKeysLocale = (PhysicalKeysLocale) other;
        return Intrinsics.areEqual(this.main, physicalKeysLocale.main) && Intrinsics.areEqual(this.addKey, physicalKeysLocale.addKey) && Intrinsics.areEqual(this.editKey, physicalKeysLocale.editKey) && Intrinsics.areEqual(this.deleteKey, physicalKeysLocale.deleteKey) && Intrinsics.areEqual(this.errorPopup, physicalKeysLocale.errorPopup) && Intrinsics.areEqual(this.notifications, physicalKeysLocale.notifications) && Intrinsics.areEqual(this.registerKeyErrorPopup, physicalKeysLocale.registerKeyErrorPopup);
    }

    public int hashCode() {
        Main main = this.main;
        int iHashCode = (main == null ? 0 : main.hashCode()) * 31;
        AddKey addKey = this.addKey;
        int iHashCode2 = (iHashCode + (addKey == null ? 0 : addKey.hashCode())) * 31;
        EditKey editKey = this.editKey;
        int iHashCode3 = (iHashCode2 + (editKey == null ? 0 : editKey.hashCode())) * 31;
        DeleteKey deleteKey = this.deleteKey;
        int iHashCode4 = (iHashCode3 + (deleteKey == null ? 0 : deleteKey.hashCode())) * 31;
        ErrorPopup errorPopup = this.errorPopup;
        int iHashCode5 = (iHashCode4 + (errorPopup == null ? 0 : errorPopup.hashCode())) * 31;
        Notifications notifications = this.notifications;
        int iHashCode6 = (iHashCode5 + (notifications == null ? 0 : notifications.hashCode())) * 31;
        NeedSubscriptionPopup needSubscriptionPopup = this.registerKeyErrorPopup;
        return iHashCode6 + (needSubscriptionPopup != null ? needSubscriptionPopup.hashCode() : 0);
    }

    public String toString() {
        return "PhysicalKeysLocale(main=" + this.main + ", addKey=" + this.addKey + ", editKey=" + this.editKey + ", deleteKey=" + this.deleteKey + ", errorPopup=" + this.errorPopup + ", notifications=" + this.notifications + ", registerKeyErrorPopup=" + this.registerKeyErrorPopup + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Main main = this.main;
        if (main == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            main.writeToParcel(parcel, flags);
        }
        AddKey addKey = this.addKey;
        if (addKey == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            addKey.writeToParcel(parcel, flags);
        }
        EditKey editKey = this.editKey;
        if (editKey == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            editKey.writeToParcel(parcel, flags);
        }
        DeleteKey deleteKey = this.deleteKey;
        if (deleteKey == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            deleteKey.writeToParcel(parcel, flags);
        }
        ErrorPopup errorPopup = this.errorPopup;
        if (errorPopup == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            errorPopup.writeToParcel(parcel, flags);
        }
        Notifications notifications = this.notifications;
        if (notifications == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            notifications.writeToParcel(parcel, flags);
        }
        NeedSubscriptionPopup needSubscriptionPopup = this.registerKeyErrorPopup;
        if (needSubscriptionPopup == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            needSubscriptionPopup.writeToParcel(parcel, flags);
        }
    }

    public PhysicalKeysLocale(Main main, AddKey addKey, EditKey editKey, DeleteKey deleteKey, ErrorPopup errorPopup, Notifications notifications, NeedSubscriptionPopup needSubscriptionPopup) {
        this.main = main;
        this.addKey = addKey;
        this.editKey = editKey;
        this.deleteKey = deleteKey;
        this.errorPopup = errorPopup;
        this.notifications = notifications;
        this.registerKeyErrorPopup = needSubscriptionPopup;
    }

    public final Main getMain() {
        return this.main;
    }

    public final AddKey getAddKey() {
        return this.addKey;
    }

    public final EditKey getEditKey() {
        return this.editKey;
    }

    public final DeleteKey getDeleteKey() {
        return this.deleteKey;
    }

    public final ErrorPopup getErrorPopup() {
        return this.errorPopup;
    }

    public final Notifications getNotifications() {
        return this.notifications;
    }

    public final NeedSubscriptionPopup getRegisterKeyErrorPopup() {
        return this.registerKeyErrorPopup;
    }

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001:\u0002-.B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;", "buyView", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$RegisterView;", "registerView", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$EmptyView;", "emptyView", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$RegisterView;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$EmptyView;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;", "getBuyView", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$RegisterView;", "getRegisterView", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$RegisterView;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$EmptyView;", "getEmptyView", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$EmptyView;", "EmptyView", "RegisterView", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Main implements Parcelable {
        public static final Parcelable.Creator<Main> CREATOR = new Creator();

        @SerializedName("buy_view")
        private final TitleWithSubtitle buyView;

        @SerializedName("empty_view")
        private final EmptyView emptyView;
        private final TextTitle navigation;

        @SerializedName("register_view")
        private final RegisterView registerView;
        private final String title;

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Main> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Main createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Main(parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : TitleWithSubtitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : RegisterView.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? EmptyView.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Main[] newArray(int i) {
                return new Main[i];
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
            if (!(other instanceof Main)) {
                return false;
            }
            Main main = (Main) other;
            return Intrinsics.areEqual(this.navigation, main.navigation) && Intrinsics.areEqual(this.title, main.title) && Intrinsics.areEqual(this.buyView, main.buyView) && Intrinsics.areEqual(this.registerView, main.registerView) && Intrinsics.areEqual(this.emptyView, main.emptyView);
        }

        public int hashCode() {
            TextTitle textTitle = this.navigation;
            int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
            String str = this.title;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            TitleWithSubtitle titleWithSubtitle = this.buyView;
            int iHashCode3 = (iHashCode2 + (titleWithSubtitle == null ? 0 : titleWithSubtitle.hashCode())) * 31;
            RegisterView registerView = this.registerView;
            int iHashCode4 = (iHashCode3 + (registerView == null ? 0 : registerView.hashCode())) * 31;
            EmptyView emptyView = this.emptyView;
            return iHashCode4 + (emptyView != null ? emptyView.hashCode() : 0);
        }

        public String toString() {
            return "Main(navigation=" + this.navigation + ", title=" + this.title + ", buyView=" + this.buyView + ", registerView=" + this.registerView + ", emptyView=" + this.emptyView + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            TextTitle textTitle = this.navigation;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.title);
            TitleWithSubtitle titleWithSubtitle = this.buyView;
            if (titleWithSubtitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                titleWithSubtitle.writeToParcel(parcel, flags);
            }
            RegisterView registerView = this.registerView;
            if (registerView == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                registerView.writeToParcel(parcel, flags);
            }
            EmptyView emptyView = this.emptyView;
            if (emptyView == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                emptyView.writeToParcel(parcel, flags);
            }
        }

        public Main(TextTitle textTitle, String str, TitleWithSubtitle titleWithSubtitle, RegisterView registerView, EmptyView emptyView) {
            this.navigation = textTitle;
            this.title = str;
            this.buyView = titleWithSubtitle;
            this.registerView = registerView;
            this.emptyView = emptyView;
        }

        public final TextTitle getNavigation() {
            return this.navigation;
        }

        public final String getTitle() {
            return this.title;
        }

        public final TitleWithSubtitle getBuyView() {
            return this.buyView;
        }

        public final RegisterView getRegisterView() {
            return this.registerView;
        }

        public final EmptyView getEmptyView() {
            return this.emptyView;
        }

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$RegisterView;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "registerButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getRegisterButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RegisterView implements Parcelable {
            public static final Parcelable.Creator<RegisterView> CREATOR = new Creator();

            @SerializedName("register_button")
            private final TextTitle registerButton;
            private final String title;

            /* compiled from: PhysicalKeysLocale.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<RegisterView> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final RegisterView createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new RegisterView(parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel));
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final RegisterView[] newArray(int i) {
                    return new RegisterView[i];
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
                if (!(other instanceof RegisterView)) {
                    return false;
                }
                RegisterView registerView = (RegisterView) other;
                return Intrinsics.areEqual(this.title, registerView.title) && Intrinsics.areEqual(this.registerButton, registerView.registerButton);
            }

            public int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                TextTitle textTitle = this.registerButton;
                return iHashCode + (textTitle != null ? textTitle.hashCode() : 0);
            }

            public String toString() {
                return "RegisterView(title=" + this.title + ", registerButton=" + this.registerButton + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.title);
                TextTitle textTitle = this.registerButton;
                if (textTitle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    textTitle.writeToParcel(parcel, flags);
                }
            }

            public RegisterView(String str, TextTitle textTitle) {
                this.title = str;
                this.registerButton = textTitle;
            }

            public final String getTitle() {
                return this.title;
            }

            public final TextTitle getRegisterButton() {
                return this.registerButton;
            }
        }

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Main$EmptyView;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EmptyView implements Parcelable {
            public static final Parcelable.Creator<EmptyView> CREATOR = new Creator();
            private final String title;

            /* compiled from: PhysicalKeysLocale.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<EmptyView> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final EmptyView createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new EmptyView(parcel.readString());
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final EmptyView[] newArray(int i) {
                    return new EmptyView[i];
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
                return (other instanceof EmptyView) && Intrinsics.areEqual(this.title, ((EmptyView) other).title);
            }

            public int hashCode() {
                String str = this.title;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "EmptyView(title=" + this.title + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.title);
            }

            public EmptyView(String str) {
                this.title = str;
            }

            public final String getTitle() {
                return this.title;
            }
        }
    }

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b%\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b&\u0010\u001f¨\u0006'"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$AddKey;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "numberView", "nameView", "registerButton", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getNumberView", "()Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getNameView", "getRegisterButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AddKey implements Parcelable {
        public static final Parcelable.Creator<AddKey> CREATOR = new Creator();

        @SerializedName("name_view")
        private final TextPlaceHolder nameView;
        private final TextTitle navigation;

        @SerializedName("number_view")
        private final TextPlaceHolder numberView;

        @SerializedName("register_button")
        private final TextTitle registerButton;
        private final String title;

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AddKey> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AddKey createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AddKey(parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : TextPlaceHolder.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextPlaceHolder.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AddKey[] newArray(int i) {
                return new AddKey[i];
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
            if (!(other instanceof AddKey)) {
                return false;
            }
            AddKey addKey = (AddKey) other;
            return Intrinsics.areEqual(this.navigation, addKey.navigation) && Intrinsics.areEqual(this.title, addKey.title) && Intrinsics.areEqual(this.numberView, addKey.numberView) && Intrinsics.areEqual(this.nameView, addKey.nameView) && Intrinsics.areEqual(this.registerButton, addKey.registerButton);
        }

        public int hashCode() {
            TextTitle textTitle = this.navigation;
            int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
            String str = this.title;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            TextPlaceHolder textPlaceHolder = this.numberView;
            int iHashCode3 = (iHashCode2 + (textPlaceHolder == null ? 0 : textPlaceHolder.hashCode())) * 31;
            TextPlaceHolder textPlaceHolder2 = this.nameView;
            int iHashCode4 = (iHashCode3 + (textPlaceHolder2 == null ? 0 : textPlaceHolder2.hashCode())) * 31;
            TextTitle textTitle2 = this.registerButton;
            return iHashCode4 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "AddKey(navigation=" + this.navigation + ", title=" + this.title + ", numberView=" + this.numberView + ", nameView=" + this.nameView + ", registerButton=" + this.registerButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            TextTitle textTitle = this.navigation;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.title);
            TextPlaceHolder textPlaceHolder = this.numberView;
            if (textPlaceHolder == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textPlaceHolder.writeToParcel(parcel, flags);
            }
            TextPlaceHolder textPlaceHolder2 = this.nameView;
            if (textPlaceHolder2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textPlaceHolder2.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.registerButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
        }

        public AddKey(TextTitle textTitle, String str, TextPlaceHolder textPlaceHolder, TextPlaceHolder textPlaceHolder2, TextTitle textTitle2) {
            this.navigation = textTitle;
            this.title = str;
            this.numberView = textPlaceHolder;
            this.nameView = textPlaceHolder2;
            this.registerButton = textTitle2;
        }

        public final TextTitle getNavigation() {
            return this.navigation;
        }

        public final String getTitle() {
            return this.title;
        }

        public final TextPlaceHolder getNumberView() {
            return this.numberView;
        }

        public final TextPlaceHolder getNameView() {
            return this.nameView;
        }

        public final TextTitle getRegisterButton() {
            return this.registerButton;
        }
    }

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b$\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b%\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b&\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b'\u0010 ¨\u0006("}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$EditKey;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "nameView", "saveButton", "blockButton", "unblockButton", "deleteButton", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getNameView", "()Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getSaveButton", "getBlockButton", "getUnblockButton", "getDeleteButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class EditKey implements Parcelable {
        public static final Parcelable.Creator<EditKey> CREATOR = new Creator();

        @SerializedName("block_button")
        private final TextTitle blockButton;

        @SerializedName("delete_button")
        private final TextTitle deleteButton;

        @SerializedName("name_view")
        private final TextPlaceHolder nameView;
        private final TextTitle navigation;

        @SerializedName("save_button")
        private final TextTitle saveButton;

        @SerializedName("unblock_button")
        private final TextTitle unblockButton;

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<EditKey> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EditKey createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new EditKey(parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextPlaceHolder.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EditKey[] newArray(int i) {
                return new EditKey[i];
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
            if (!(other instanceof EditKey)) {
                return false;
            }
            EditKey editKey = (EditKey) other;
            return Intrinsics.areEqual(this.navigation, editKey.navigation) && Intrinsics.areEqual(this.nameView, editKey.nameView) && Intrinsics.areEqual(this.saveButton, editKey.saveButton) && Intrinsics.areEqual(this.blockButton, editKey.blockButton) && Intrinsics.areEqual(this.unblockButton, editKey.unblockButton) && Intrinsics.areEqual(this.deleteButton, editKey.deleteButton);
        }

        public int hashCode() {
            TextTitle textTitle = this.navigation;
            int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
            TextPlaceHolder textPlaceHolder = this.nameView;
            int iHashCode2 = (iHashCode + (textPlaceHolder == null ? 0 : textPlaceHolder.hashCode())) * 31;
            TextTitle textTitle2 = this.saveButton;
            int iHashCode3 = (iHashCode2 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
            TextTitle textTitle3 = this.blockButton;
            int iHashCode4 = (iHashCode3 + (textTitle3 == null ? 0 : textTitle3.hashCode())) * 31;
            TextTitle textTitle4 = this.unblockButton;
            int iHashCode5 = (iHashCode4 + (textTitle4 == null ? 0 : textTitle4.hashCode())) * 31;
            TextTitle textTitle5 = this.deleteButton;
            return iHashCode5 + (textTitle5 != null ? textTitle5.hashCode() : 0);
        }

        public String toString() {
            return "EditKey(navigation=" + this.navigation + ", nameView=" + this.nameView + ", saveButton=" + this.saveButton + ", blockButton=" + this.blockButton + ", unblockButton=" + this.unblockButton + ", deleteButton=" + this.deleteButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            TextTitle textTitle = this.navigation;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextPlaceHolder textPlaceHolder = this.nameView;
            if (textPlaceHolder == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textPlaceHolder.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.saveButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
            TextTitle textTitle3 = this.blockButton;
            if (textTitle3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle3.writeToParcel(parcel, flags);
            }
            TextTitle textTitle4 = this.unblockButton;
            if (textTitle4 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle4.writeToParcel(parcel, flags);
            }
            TextTitle textTitle5 = this.deleteButton;
            if (textTitle5 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle5.writeToParcel(parcel, flags);
            }
        }

        public EditKey(TextTitle textTitle, TextPlaceHolder textPlaceHolder, TextTitle textTitle2, TextTitle textTitle3, TextTitle textTitle4, TextTitle textTitle5) {
            this.navigation = textTitle;
            this.nameView = textPlaceHolder;
            this.saveButton = textTitle2;
            this.blockButton = textTitle3;
            this.unblockButton = textTitle4;
            this.deleteButton = textTitle5;
        }

        public final TextTitle getNavigation() {
            return this.navigation;
        }

        public final TextPlaceHolder getNameView() {
            return this.nameView;
        }

        public final TextTitle getSaveButton() {
            return this.saveButton;
        }

        public final TextTitle getBlockButton() {
            return this.blockButton;
        }

        public final TextTitle getUnblockButton() {
            return this.unblockButton;
        }

        public final TextTitle getDeleteButton() {
            return this.deleteButton;
        }
    }

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$DeleteKey;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "confirmButton", "cancelButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getConfirmButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DeleteKey implements Parcelable {
        public static final Parcelable.Creator<DeleteKey> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("confirm_button")
        private final TextTitle confirmButton;
        private final String subtitle;
        private final String title;

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DeleteKey> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DeleteKey createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DeleteKey(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DeleteKey[] newArray(int i) {
                return new DeleteKey[i];
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
            if (!(other instanceof DeleteKey)) {
                return false;
            }
            DeleteKey deleteKey = (DeleteKey) other;
            return Intrinsics.areEqual(this.title, deleteKey.title) && Intrinsics.areEqual(this.subtitle, deleteKey.subtitle) && Intrinsics.areEqual(this.confirmButton, deleteKey.confirmButton) && Intrinsics.areEqual(this.cancelButton, deleteKey.cancelButton);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.subtitle;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.confirmButton;
            int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            return iHashCode3 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "DeleteKey(title=" + this.title + ", subtitle=" + this.subtitle + ", confirmButton=" + this.confirmButton + ", cancelButton=" + this.cancelButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            TextTitle textTitle = this.confirmButton;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.cancelButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
        }

        public DeleteKey(String str, String str2, TextTitle textTitle, TextTitle textTitle2) {
            this.title = str;
            this.subtitle = str2;
            this.confirmButton = textTitle;
            this.cancelButton = textTitle2;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final TextTitle getConfirmButton() {
            return this.confirmButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }
    }

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$ErrorPopup;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "backButton", "supportButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getBackButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getSupportButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ErrorPopup implements Parcelable {
        public static final Parcelable.Creator<ErrorPopup> CREATOR = new Creator();

        @SerializedName("back_button")
        private final TextTitle backButton;

        @SerializedName("support_button")
        private final TextTitle supportButton;
        private final String title;

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ErrorPopup> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ErrorPopup createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ErrorPopup(parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ErrorPopup[] newArray(int i) {
                return new ErrorPopup[i];
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
            if (!(other instanceof ErrorPopup)) {
                return false;
            }
            ErrorPopup errorPopup = (ErrorPopup) other;
            return Intrinsics.areEqual(this.title, errorPopup.title) && Intrinsics.areEqual(this.backButton, errorPopup.backButton) && Intrinsics.areEqual(this.supportButton, errorPopup.supportButton);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            TextTitle textTitle = this.backButton;
            int iHashCode2 = (iHashCode + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.supportButton;
            return iHashCode2 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "ErrorPopup(title=" + this.title + ", backButton=" + this.backButton + ", supportButton=" + this.supportButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            TextTitle textTitle = this.backButton;
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
        }

        public ErrorPopup(String str, TextTitle textTitle, TextTitle textTitle2) {
            this.title = str;
            this.backButton = textTitle;
            this.supportButton = textTitle2;
        }

        public final String getTitle() {
            return this.title;
        }

        public final TextTitle getBackButton() {
            return this.backButton;
        }

        public final TextTitle getSupportButton() {
            return this.supportButton;
        }
    }

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$Notifications;", "Landroid/os/Parcelable;", "", "keyAddSuccess", "keyCommentUpdatesSuccess", "keyBlockedSuccess", "keyUnblockedSuccess", "keyDeletedSuccess", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getKeyAddSuccess", "getKeyCommentUpdatesSuccess", "getKeyBlockedSuccess", "getKeyUnblockedSuccess", "getKeyDeletedSuccess", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Notifications implements Parcelable {
        public static final Parcelable.Creator<Notifications> CREATOR = new Creator();

        @SerializedName("key_add_success")
        private final String keyAddSuccess;

        @SerializedName("key_blocked_success")
        private final String keyBlockedSuccess;

        @SerializedName("key_comment_updated_success")
        private final String keyCommentUpdatesSuccess;

        @SerializedName("key_deleted_success")
        private final String keyDeletedSuccess;

        @SerializedName("key_unblocked_success")
        private final String keyUnblockedSuccess;

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Notifications> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Notifications createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Notifications(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Notifications[] newArray(int i) {
                return new Notifications[i];
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
            if (!(other instanceof Notifications)) {
                return false;
            }
            Notifications notifications = (Notifications) other;
            return Intrinsics.areEqual(this.keyAddSuccess, notifications.keyAddSuccess) && Intrinsics.areEqual(this.keyCommentUpdatesSuccess, notifications.keyCommentUpdatesSuccess) && Intrinsics.areEqual(this.keyBlockedSuccess, notifications.keyBlockedSuccess) && Intrinsics.areEqual(this.keyUnblockedSuccess, notifications.keyUnblockedSuccess) && Intrinsics.areEqual(this.keyDeletedSuccess, notifications.keyDeletedSuccess);
        }

        public int hashCode() {
            String str = this.keyAddSuccess;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.keyCommentUpdatesSuccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.keyBlockedSuccess;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.keyUnblockedSuccess;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.keyDeletedSuccess;
            return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Notifications(keyAddSuccess=" + this.keyAddSuccess + ", keyCommentUpdatesSuccess=" + this.keyCommentUpdatesSuccess + ", keyBlockedSuccess=" + this.keyBlockedSuccess + ", keyUnblockedSuccess=" + this.keyUnblockedSuccess + ", keyDeletedSuccess=" + this.keyDeletedSuccess + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.keyAddSuccess);
            parcel.writeString(this.keyCommentUpdatesSuccess);
            parcel.writeString(this.keyBlockedSuccess);
            parcel.writeString(this.keyUnblockedSuccess);
            parcel.writeString(this.keyDeletedSuccess);
        }

        public Notifications(String str, String str2, String str3, String str4, String str5) {
            this.keyAddSuccess = str;
            this.keyCommentUpdatesSuccess = str2;
            this.keyBlockedSuccess = str3;
            this.keyUnblockedSuccess = str4;
            this.keyDeletedSuccess = str5;
        }

        public final String getKeyAddSuccess() {
            return this.keyAddSuccess;
        }

        public final String getKeyCommentUpdatesSuccess() {
            return this.keyCommentUpdatesSuccess;
        }

        public final String getKeyBlockedSuccess() {
            return this.keyBlockedSuccess;
        }

        public final String getKeyUnblockedSuccess() {
            return this.keyUnblockedSuccess;
        }

        public final String getKeyDeletedSuccess() {
            return this.keyDeletedSuccess;
        }
    }

    /* compiled from: PhysicalKeysLocale.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale$NeedSubscriptionPopup;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "subtitle", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getSubtitle", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NeedSubscriptionPopup implements Parcelable {
        public static final Parcelable.Creator<NeedSubscriptionPopup> CREATOR = new Creator();
        private final TitleWithParam subtitle;
        private final String title;

        /* compiled from: PhysicalKeysLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NeedSubscriptionPopup> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NeedSubscriptionPopup createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NeedSubscriptionPopup(parcel.readString(), parcel.readInt() == 0 ? null : TitleWithParam.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NeedSubscriptionPopup[] newArray(int i) {
                return new NeedSubscriptionPopup[i];
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
            if (!(other instanceof NeedSubscriptionPopup)) {
                return false;
            }
            NeedSubscriptionPopup needSubscriptionPopup = (NeedSubscriptionPopup) other;
            return Intrinsics.areEqual(this.title, needSubscriptionPopup.title) && Intrinsics.areEqual(this.subtitle, needSubscriptionPopup.subtitle);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            TitleWithParam titleWithParam = this.subtitle;
            return iHashCode + (titleWithParam != null ? titleWithParam.hashCode() : 0);
        }

        public String toString() {
            return "NeedSubscriptionPopup(title=" + this.title + ", subtitle=" + this.subtitle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            TitleWithParam titleWithParam = this.subtitle;
            if (titleWithParam == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                titleWithParam.writeToParcel(parcel, flags);
            }
        }

        public NeedSubscriptionPopup(String str, TitleWithParam titleWithParam) {
            this.title = str;
            this.subtitle = titleWithParam;
        }

        public final String getTitle() {
            return this.title;
        }

        public final TitleWithParam getSubtitle() {
            return this.subtitle;
        }
    }
}
