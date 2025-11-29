package com.sputnik.data.entities.profile;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.domain.entities.auth.StateType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataProfile.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b.\b\u0087\b\u0018\u00002\u00020\u0001:\u0001bBå\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b1\u0010,J \u00106\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b6\u00107R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010:R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010;\u001a\u0004\b>\u0010=R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010B\u001a\u0004\bC\u0010*R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010B\u001a\u0004\bD\u0010*R\u001c\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010B\u001a\u0004\bE\u0010*R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\r\u0010B\u001a\u0004\bF\u0010*R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010B\u001a\u0004\bG\u0010*R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010B\u001a\u0004\bH\u0010*R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010B\u001a\u0004\bI\u0010*R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010;\u001a\u0004\bJ\u0010=R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010;\u001a\u0004\bN\u0010=R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010B\u001a\u0004\bO\u0010*R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010;\u001a\u0004\bP\u0010=R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010;\u001a\u0004\bQ\u0010=R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010;\u001a\u0004\bR\u0010=R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010B\u001a\u0004\bS\u0010*R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010?\u001a\u0004\bT\u0010AR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010B\u001a\u0004\bU\u0010*R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010;\u001a\u0004\bV\u0010=R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010B\u001a\u0004\bW\u0010*R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010B\u001a\u0004\bX\u0010*R\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010Y\u001a\u0004\bZ\u0010[R\u001c\u0010!\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010;\u001a\u0004\b\\\u0010=R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\b]\u0010=R\u001c\u0010#\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010B\u001a\u0004\b^\u0010*R\u001f\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006¢\u0006\f\n\u0004\b&\u0010_\u001a\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lcom/sputnik/data/entities/profile/DataProfile;", "Landroid/os/Parcelable;", "Lcom/sputnik/domain/entities/auth/StateType;", "state", "", "addressVerificationRequired", "callEnabled", "", "callType", "", "firstName", "fullAddress", "fullAddressWithApartment", "avatar", "apartment", "fcmToken", "about", "feedbackNeed", "Lcom/sputnik/data/entities/profile/DataProfileCardInfo;", "cardInfo", "trialAvailable", "faceRecognitionImage", "faceRecognitionDataUploaded", "servicesPaidByPartner", "blocked", "blockingReason", "blockLevel", "localization", "historyAvailable", "pushToken", "timezone", "Lcom/sputnik/data/entities/profile/DataSplashScreen;", "splashScreen", "loadingVideo", "richFunctionalityAvailable", "paymentMethod", "", "Lcom/sputnik/data/entities/profile/DataProfile$DataAddress;", "addresses", "<init>", "(Lcom/sputnik/domain/entities/auth/StateType;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/data/entities/profile/DataProfileCardInfo;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/data/entities/profile/DataSplashScreen;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/domain/entities/auth/StateType;", "getState", "()Lcom/sputnik/domain/entities/auth/StateType;", "Ljava/lang/Boolean;", "getAddressVerificationRequired", "()Ljava/lang/Boolean;", "getCallEnabled", "Ljava/lang/Integer;", "getCallType", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getFirstName", "getFullAddress", "getFullAddressWithApartment", "getAvatar", "getApartment", "getFcmToken", "getAbout", "getFeedbackNeed", "Lcom/sputnik/data/entities/profile/DataProfileCardInfo;", "getCardInfo", "()Lcom/sputnik/data/entities/profile/DataProfileCardInfo;", "getTrialAvailable", "getFaceRecognitionImage", "getFaceRecognitionDataUploaded", "getServicesPaidByPartner", "getBlocked", "getBlockingReason", "getBlockLevel", "getLocalization", "getHistoryAvailable", "getPushToken", "getTimezone", "Lcom/sputnik/data/entities/profile/DataSplashScreen;", "getSplashScreen", "()Lcom/sputnik/data/entities/profile/DataSplashScreen;", "getLoadingVideo", "getRichFunctionalityAvailable", "getPaymentMethod", "Ljava/util/List;", "getAddresses", "()Ljava/util/List;", "DataAddress", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataProfile implements Parcelable {
    public static final Parcelable.Creator<DataProfile> CREATOR = new Creator();
    private final String about;

    @SerializedName("address_verification_required")
    private final Boolean addressVerificationRequired;
    private final List<DataAddress> addresses;
    private final String apartment;
    private final String avatar;

    @SerializedName("block_level")
    private final Integer blockLevel;
    private final Boolean blocked;

    @SerializedName("blocking_reason")
    private final String blockingReason;

    @SerializedName("call_enabled")
    private final Boolean callEnabled;

    @SerializedName("call_type")
    private final Integer callType;

    @SerializedName("card_info")
    private final DataProfileCardInfo cardInfo;

    @SerializedName("face_recognition_data_uploaded")
    private final Boolean faceRecognitionDataUploaded;

    @SerializedName("face_recognition_image")
    private final String faceRecognitionImage;

    @SerializedName("fcm_token")
    private final String fcmToken;

    @SerializedName("feedback_required")
    private final Boolean feedbackNeed;

    @SerializedName("first_name")
    private final String firstName;

    @SerializedName("full_address")
    private final String fullAddress;

    @SerializedName("full_address_with_apt")
    private final String fullAddressWithApartment;

    @SerializedName("history_available")
    private final Boolean historyAvailable;

    @SerializedName("loading_video")
    private final Boolean loadingVideo;
    private final String localization;

    @SerializedName("payment_method")
    private final String paymentMethod;

    @SerializedName("device_push_token")
    private final String pushToken;

    @SerializedName("rich_functionality_available")
    private final Boolean richFunctionalityAvailable;

    @SerializedName("services_paid_by_partner")
    private final Boolean servicesPaidByPartner;

    @SerializedName("splash_screen")
    private final DataSplashScreen splashScreen;
    private final StateType state;
    private final String timezone;

    @SerializedName("trial_available")
    private final Boolean trialAvailable;

    /* compiled from: DataProfile.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataProfile> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataProfile createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Boolean boolValueOf4;
            Boolean boolValueOf5;
            Boolean boolValueOf6;
            Boolean boolValueOf7;
            Boolean boolValueOf8;
            Boolean boolValueOf9;
            Boolean boolValueOf10;
            DataProfileCardInfo dataProfileCardInfo;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            StateType stateTypeValueOf = parcel.readInt() == 0 ? null : StateType.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf3 = null;
            } else {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            DataProfileCardInfo dataProfileCardInfoCreateFromParcel = parcel.readInt() == 0 ? null : DataProfileCardInfo.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                boolValueOf4 = null;
            } else {
                boolValueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string8 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf5 = null;
            } else {
                boolValueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf6 = null;
            } else {
                boolValueOf6 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf7 = null;
            } else {
                boolValueOf7 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string9 = parcel.readString();
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string10 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf8 = null;
            } else {
                boolValueOf8 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            DataSplashScreen dataSplashScreenCreateFromParcel = parcel.readInt() == 0 ? null : DataSplashScreen.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                boolValueOf9 = null;
            } else {
                boolValueOf9 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf10 = null;
            } else {
                boolValueOf10 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string13 = parcel.readString();
            if (parcel.readInt() == 0) {
                dataProfileCardInfo = dataProfileCardInfoCreateFromParcel;
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                dataProfileCardInfo = dataProfileCardInfoCreateFromParcel;
                int i2 = 0;
                while (i2 != i) {
                    arrayList2.add(DataAddress.CREATOR.createFromParcel(parcel));
                    i2++;
                    i = i;
                }
                arrayList = arrayList2;
            }
            return new DataProfile(stateTypeValueOf, boolValueOf, boolValueOf2, numValueOf, string, string2, string3, string4, string5, string6, string7, boolValueOf3, dataProfileCardInfo, boolValueOf4, string8, boolValueOf5, boolValueOf6, boolValueOf7, string9, numValueOf2, string10, boolValueOf8, string11, string12, dataSplashScreenCreateFromParcel, boolValueOf9, boolValueOf10, string13, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataProfile[] newArray(int i) {
            return new DataProfile[i];
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
        if (!(other instanceof DataProfile)) {
            return false;
        }
        DataProfile dataProfile = (DataProfile) other;
        return this.state == dataProfile.state && Intrinsics.areEqual(this.addressVerificationRequired, dataProfile.addressVerificationRequired) && Intrinsics.areEqual(this.callEnabled, dataProfile.callEnabled) && Intrinsics.areEqual(this.callType, dataProfile.callType) && Intrinsics.areEqual(this.firstName, dataProfile.firstName) && Intrinsics.areEqual(this.fullAddress, dataProfile.fullAddress) && Intrinsics.areEqual(this.fullAddressWithApartment, dataProfile.fullAddressWithApartment) && Intrinsics.areEqual(this.avatar, dataProfile.avatar) && Intrinsics.areEqual(this.apartment, dataProfile.apartment) && Intrinsics.areEqual(this.fcmToken, dataProfile.fcmToken) && Intrinsics.areEqual(this.about, dataProfile.about) && Intrinsics.areEqual(this.feedbackNeed, dataProfile.feedbackNeed) && Intrinsics.areEqual(this.cardInfo, dataProfile.cardInfo) && Intrinsics.areEqual(this.trialAvailable, dataProfile.trialAvailable) && Intrinsics.areEqual(this.faceRecognitionImage, dataProfile.faceRecognitionImage) && Intrinsics.areEqual(this.faceRecognitionDataUploaded, dataProfile.faceRecognitionDataUploaded) && Intrinsics.areEqual(this.servicesPaidByPartner, dataProfile.servicesPaidByPartner) && Intrinsics.areEqual(this.blocked, dataProfile.blocked) && Intrinsics.areEqual(this.blockingReason, dataProfile.blockingReason) && Intrinsics.areEqual(this.blockLevel, dataProfile.blockLevel) && Intrinsics.areEqual(this.localization, dataProfile.localization) && Intrinsics.areEqual(this.historyAvailable, dataProfile.historyAvailable) && Intrinsics.areEqual(this.pushToken, dataProfile.pushToken) && Intrinsics.areEqual(this.timezone, dataProfile.timezone) && Intrinsics.areEqual(this.splashScreen, dataProfile.splashScreen) && Intrinsics.areEqual(this.loadingVideo, dataProfile.loadingVideo) && Intrinsics.areEqual(this.richFunctionalityAvailable, dataProfile.richFunctionalityAvailable) && Intrinsics.areEqual(this.paymentMethod, dataProfile.paymentMethod) && Intrinsics.areEqual(this.addresses, dataProfile.addresses);
    }

    public int hashCode() {
        StateType stateType = this.state;
        int iHashCode = (stateType == null ? 0 : stateType.hashCode()) * 31;
        Boolean bool = this.addressVerificationRequired;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.callEnabled;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.callType;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.firstName;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fullAddress;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fullAddressWithApartment;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.avatar;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.apartment;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.fcmToken;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.about;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool3 = this.feedbackNeed;
        int iHashCode12 = (iHashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        DataProfileCardInfo dataProfileCardInfo = this.cardInfo;
        int iHashCode13 = (iHashCode12 + (dataProfileCardInfo == null ? 0 : dataProfileCardInfo.hashCode())) * 31;
        Boolean bool4 = this.trialAvailable;
        int iHashCode14 = (iHashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str8 = this.faceRecognitionImage;
        int iHashCode15 = (iHashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool5 = this.faceRecognitionDataUploaded;
        int iHashCode16 = (iHashCode15 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.servicesPaidByPartner;
        int iHashCode17 = (iHashCode16 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.blocked;
        int iHashCode18 = (iHashCode17 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        String str9 = this.blockingReason;
        int iHashCode19 = (iHashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num2 = this.blockLevel;
        int iHashCode20 = (iHashCode19 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str10 = this.localization;
        int iHashCode21 = (iHashCode20 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Boolean bool8 = this.historyAvailable;
        int iHashCode22 = (iHashCode21 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        String str11 = this.pushToken;
        int iHashCode23 = (iHashCode22 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.timezone;
        int iHashCode24 = (iHashCode23 + (str12 == null ? 0 : str12.hashCode())) * 31;
        DataSplashScreen dataSplashScreen = this.splashScreen;
        int iHashCode25 = (iHashCode24 + (dataSplashScreen == null ? 0 : dataSplashScreen.hashCode())) * 31;
        Boolean bool9 = this.loadingVideo;
        int iHashCode26 = (iHashCode25 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.richFunctionalityAvailable;
        int iHashCode27 = (iHashCode26 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        String str13 = this.paymentMethod;
        int iHashCode28 = (iHashCode27 + (str13 == null ? 0 : str13.hashCode())) * 31;
        List<DataAddress> list = this.addresses;
        return iHashCode28 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "DataProfile(state=" + this.state + ", addressVerificationRequired=" + this.addressVerificationRequired + ", callEnabled=" + this.callEnabled + ", callType=" + this.callType + ", firstName=" + this.firstName + ", fullAddress=" + this.fullAddress + ", fullAddressWithApartment=" + this.fullAddressWithApartment + ", avatar=" + this.avatar + ", apartment=" + this.apartment + ", fcmToken=" + this.fcmToken + ", about=" + this.about + ", feedbackNeed=" + this.feedbackNeed + ", cardInfo=" + this.cardInfo + ", trialAvailable=" + this.trialAvailable + ", faceRecognitionImage=" + this.faceRecognitionImage + ", faceRecognitionDataUploaded=" + this.faceRecognitionDataUploaded + ", servicesPaidByPartner=" + this.servicesPaidByPartner + ", blocked=" + this.blocked + ", blockingReason=" + this.blockingReason + ", blockLevel=" + this.blockLevel + ", localization=" + this.localization + ", historyAvailable=" + this.historyAvailable + ", pushToken=" + this.pushToken + ", timezone=" + this.timezone + ", splashScreen=" + this.splashScreen + ", loadingVideo=" + this.loadingVideo + ", richFunctionalityAvailable=" + this.richFunctionalityAvailable + ", paymentMethod=" + this.paymentMethod + ", addresses=" + this.addresses + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        StateType stateType = this.state;
        if (stateType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(stateType.name());
        }
        Boolean bool = this.addressVerificationRequired;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.callEnabled;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Integer num = this.callType;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.firstName);
        parcel.writeString(this.fullAddress);
        parcel.writeString(this.fullAddressWithApartment);
        parcel.writeString(this.avatar);
        parcel.writeString(this.apartment);
        parcel.writeString(this.fcmToken);
        parcel.writeString(this.about);
        Boolean bool3 = this.feedbackNeed;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        DataProfileCardInfo dataProfileCardInfo = this.cardInfo;
        if (dataProfileCardInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataProfileCardInfo.writeToParcel(parcel, flags);
        }
        Boolean bool4 = this.trialAvailable;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.faceRecognitionImage);
        Boolean bool5 = this.faceRecognitionDataUploaded;
        if (bool5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        Boolean bool6 = this.servicesPaidByPartner;
        if (bool6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        Boolean bool7 = this.blocked;
        if (bool7 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool7.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.blockingReason);
        Integer num2 = this.blockLevel;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.localization);
        Boolean bool8 = this.historyAvailable;
        if (bool8 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool8.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.pushToken);
        parcel.writeString(this.timezone);
        DataSplashScreen dataSplashScreen = this.splashScreen;
        if (dataSplashScreen == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataSplashScreen.writeToParcel(parcel, flags);
        }
        Boolean bool9 = this.loadingVideo;
        if (bool9 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool9.booleanValue() ? 1 : 0);
        }
        Boolean bool10 = this.richFunctionalityAvailable;
        if (bool10 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool10.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.paymentMethod);
        List<DataAddress> list = this.addresses;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<DataAddress> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public DataProfile(StateType stateType, Boolean bool, Boolean bool2, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool3, DataProfileCardInfo dataProfileCardInfo, Boolean bool4, String str8, Boolean bool5, Boolean bool6, Boolean bool7, String str9, Integer num2, String str10, Boolean bool8, String str11, String str12, DataSplashScreen dataSplashScreen, Boolean bool9, Boolean bool10, String str13, List<DataAddress> list) {
        this.state = stateType;
        this.addressVerificationRequired = bool;
        this.callEnabled = bool2;
        this.callType = num;
        this.firstName = str;
        this.fullAddress = str2;
        this.fullAddressWithApartment = str3;
        this.avatar = str4;
        this.apartment = str5;
        this.fcmToken = str6;
        this.about = str7;
        this.feedbackNeed = bool3;
        this.cardInfo = dataProfileCardInfo;
        this.trialAvailable = bool4;
        this.faceRecognitionImage = str8;
        this.faceRecognitionDataUploaded = bool5;
        this.servicesPaidByPartner = bool6;
        this.blocked = bool7;
        this.blockingReason = str9;
        this.blockLevel = num2;
        this.localization = str10;
        this.historyAvailable = bool8;
        this.pushToken = str11;
        this.timezone = str12;
        this.splashScreen = dataSplashScreen;
        this.loadingVideo = bool9;
        this.richFunctionalityAvailable = bool10;
        this.paymentMethod = str13;
        this.addresses = list;
    }

    public final StateType getState() {
        return this.state;
    }

    public final Boolean getAddressVerificationRequired() {
        return this.addressVerificationRequired;
    }

    public final Boolean getCallEnabled() {
        return this.callEnabled;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final String getFullAddressWithApartment() {
        return this.fullAddressWithApartment;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getApartment() {
        return this.apartment;
    }

    public final Boolean getFeedbackNeed() {
        return this.feedbackNeed;
    }

    public final DataProfileCardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final Boolean getFaceRecognitionDataUploaded() {
        return this.faceRecognitionDataUploaded;
    }

    public final Boolean getServicesPaidByPartner() {
        return this.servicesPaidByPartner;
    }

    public final Boolean getBlocked() {
        return this.blocked;
    }

    public final String getBlockingReason() {
        return this.blockingReason;
    }

    public final Integer getBlockLevel() {
        return this.blockLevel;
    }

    public final String getLocalization() {
        return this.localization;
    }

    public final Boolean getHistoryAvailable() {
        return this.historyAvailable;
    }

    public final String getPushToken() {
        return this.pushToken;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final DataSplashScreen getSplashScreen() {
        return this.splashScreen;
    }

    public final Boolean getLoadingVideo() {
        return this.loadingVideo;
    }

    public final Boolean getRichFunctionalityAvailable() {
        return this.richFunctionalityAvailable;
    }

    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    public final List<DataAddress> getAddresses() {
        return this.addresses;
    }

    /* compiled from: DataProfile.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b#\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b'\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b(\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b)\u0010\u0010R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b*\u0010\u0010¨\u0006+"}, d2 = {"Lcom/sputnik/data/entities/profile/DataProfile$DataAddress;", "Landroid/os/Parcelable;", "", "id", "", "fullAddress", "fullAddressWithApartment", "", "addressVerificationRequired", "apartment", "flatUUID", "entryUUID", UpdateKey.STATUS, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getFullAddress", "getFullAddressWithApartment", "Ljava/lang/Boolean;", "getAddressVerificationRequired", "()Ljava/lang/Boolean;", "getApartment", "getFlatUUID", "getEntryUUID", "getStatus", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataAddress implements Parcelable {
        public static final Parcelable.Creator<DataAddress> CREATOR = new Creator();

        @SerializedName("address_verification_required")
        private final Boolean addressVerificationRequired;

        @SerializedName("apartment")
        private final Integer apartment;

        @SerializedName("entry_uuid")
        private final String entryUUID;

        @SerializedName("flat_uuid")
        private final String flatUUID;

        @SerializedName("full_address")
        private final String fullAddress;

        @SerializedName("full_address_with_apt")
        private final String fullAddressWithApartment;
        private final Integer id;
        private final String status;

        /* compiled from: DataProfile.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataAddress> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataAddress createFromParcel(Parcel parcel) {
                Boolean boolValueOf;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                String string = parcel.readString();
                String string2 = parcel.readString();
                if (parcel.readInt() == 0) {
                    boolValueOf = null;
                } else {
                    boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new DataAddress(numValueOf, string, string2, boolValueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataAddress[] newArray(int i) {
                return new DataAddress[i];
            }
        }

        public DataAddress() {
            this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataAddress)) {
                return false;
            }
            DataAddress dataAddress = (DataAddress) other;
            return Intrinsics.areEqual(this.id, dataAddress.id) && Intrinsics.areEqual(this.fullAddress, dataAddress.fullAddress) && Intrinsics.areEqual(this.fullAddressWithApartment, dataAddress.fullAddressWithApartment) && Intrinsics.areEqual(this.addressVerificationRequired, dataAddress.addressVerificationRequired) && Intrinsics.areEqual(this.apartment, dataAddress.apartment) && Intrinsics.areEqual(this.flatUUID, dataAddress.flatUUID) && Intrinsics.areEqual(this.entryUUID, dataAddress.entryUUID) && Intrinsics.areEqual(this.status, dataAddress.status);
        }

        public int hashCode() {
            Integer num = this.id;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.fullAddress;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.fullAddressWithApartment;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.addressVerificationRequired;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num2 = this.apartment;
            int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str3 = this.flatUUID;
            int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.entryUUID;
            int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.status;
            return iHashCode7 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "DataAddress(id=" + this.id + ", fullAddress=" + this.fullAddress + ", fullAddressWithApartment=" + this.fullAddressWithApartment + ", addressVerificationRequired=" + this.addressVerificationRequired + ", apartment=" + this.apartment + ", flatUUID=" + this.flatUUID + ", entryUUID=" + this.entryUUID + ", status=" + this.status + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Integer num = this.id;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.fullAddress);
            parcel.writeString(this.fullAddressWithApartment);
            Boolean bool = this.addressVerificationRequired;
            if (bool == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            }
            Integer num2 = this.apartment;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
            parcel.writeString(this.flatUUID);
            parcel.writeString(this.entryUUID);
            parcel.writeString(this.status);
        }

        public DataAddress(Integer num, String str, String str2, Boolean bool, Integer num2, String str3, String str4, String str5) {
            this.id = num;
            this.fullAddress = str;
            this.fullAddressWithApartment = str2;
            this.addressVerificationRequired = bool;
            this.apartment = num2;
            this.flatUUID = str3;
            this.entryUUID = str4;
            this.status = str5;
        }

        public /* synthetic */ DataAddress(Integer num, String str, String str2, Boolean bool, Integer num2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) == 0 ? str5 : null);
        }

        public final Integer getId() {
            return this.id;
        }

        public final String getFullAddress() {
            return this.fullAddress;
        }

        public final String getFullAddressWithApartment() {
            return this.fullAddressWithApartment;
        }

        public final Boolean getAddressVerificationRequired() {
            return this.addressVerificationRequired;
        }

        public final Integer getApartment() {
            return this.apartment;
        }

        public final String getFlatUUID() {
            return this.flatUUID;
        }

        public final String getEntryUUID() {
            return this.entryUUID;
        }

        public final String getStatus() {
            return this.status;
        }
    }
}
