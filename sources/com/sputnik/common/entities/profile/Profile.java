package com.sputnik.common.entities.profile;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.domain.entities.auth.StateType;
import com.sputnik.domain.entities.profile.DomainProfile;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Profile.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020#2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J¦\u0002\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00103\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020.HÖ\u0001¢\u0006\u0004\b5\u00100J \u0010:\u001a\u0002092\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020.HÖ\u0001¢\u0006\u0004\b:\u0010;R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010?\u001a\u0004\b@\u0010-R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010?\u001a\u0004\bA\u0010-R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010<\u001a\u0004\b\u0007\u0010>R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010DR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010<\u001a\u0004\bE\u0010>R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010<\u001a\u0004\bF\u0010>R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010<\u001a\u0004\bG\u0010>R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010?\u001a\u0004\bH\u0010-R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010?\u001a\u0004\bI\u0010-R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010?\u001a\u0004\bJ\u0010-R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010?\u001a\u0004\bK\u0010-R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010?\u001a\u0004\bO\u0010-R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010<\u001a\u0004\bP\u0010>R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010?\u001a\u0004\bQ\u0010-R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010?\u001a\u0004\bR\u0010-R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010S\u001a\u0004\bT\u0010UR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010?\u001a\u0004\bV\u0010-R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010<\u001a\u0004\bW\u0010>R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010<\u001a\u0004\bX\u0010>R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010?\u001a\u0004\bY\u0010-R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010Z\u001a\u0004\b[\u0010\\¨\u0006]"}, d2 = {"Lcom/sputnik/common/entities/profile/Profile;", "Landroid/os/Parcelable;", "", "callIsEnabled", "", "firstName", "avatar", "isNeedFeedback", "Lcom/sputnik/common/entities/profile/ProfileCardInfo;", "cardInfo", "faceRecognitionDataUploaded", "servicesPaidByPartner", "blocked", "blockingReason", "localization", "address", "addressWithApartment", "Lcom/sputnik/common/BlockingLevel;", "blockLevel", "apartment", "historyAvailable", "pushToken", "timezone", "Lcom/sputnik/common/entities/profile/SplashScreen;", "splashScreen", "rawAddress", "loadingVideo", "richFunctionalityAvailable", "paymentMethod", "", "Lcom/sputnik/common/entities/addresses/UserAddress;", "addresses", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/common/entities/profile/ProfileCardInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/BlockingLevel;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/profile/SplashScreen;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "Lcom/sputnik/domain/entities/profile/DomainProfile$DomainAddress;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "getNavigationStateForDomainAddress", "(Lcom/sputnik/domain/entities/profile/DomainProfile$DomainAddress;)Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "Lcom/sputnik/domain/entities/profile/DomainProfile;", "input", "getNavigationState", "(Lcom/sputnik/domain/entities/profile/DomainProfile;)Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/common/entities/profile/ProfileCardInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/BlockingLevel;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/profile/SplashScreen;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)Lcom/sputnik/common/entities/profile/Profile;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "getCallIsEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/String;", "getFirstName", "getAvatar", "Lcom/sputnik/common/entities/profile/ProfileCardInfo;", "getCardInfo", "()Lcom/sputnik/common/entities/profile/ProfileCardInfo;", "getFaceRecognitionDataUploaded", "getServicesPaidByPartner", "getBlocked", "getBlockingReason", "getLocalization", "getAddress", "getAddressWithApartment", "Lcom/sputnik/common/BlockingLevel;", "getBlockLevel", "()Lcom/sputnik/common/BlockingLevel;", "getApartment", "getHistoryAvailable", "getPushToken", "getTimezone", "Lcom/sputnik/common/entities/profile/SplashScreen;", "getSplashScreen", "()Lcom/sputnik/common/entities/profile/SplashScreen;", "getRawAddress", "getLoadingVideo", "getRichFunctionalityAvailable", "getPaymentMethod", "Ljava/util/List;", "getAddresses", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Creator();
    private final String address;
    private final String addressWithApartment;
    private final List<UserAddress> addresses;
    private final String apartment;
    private final String avatar;
    private final BlockingLevel blockLevel;
    private final Boolean blocked;
    private final String blockingReason;
    private final Boolean callIsEnabled;
    private final ProfileCardInfo cardInfo;
    private final Boolean faceRecognitionDataUploaded;
    private final String firstName;
    private final Boolean historyAvailable;
    private final Boolean isNeedFeedback;
    private final Boolean loadingVideo;
    private final String localization;
    private final String paymentMethod;
    private final String pushToken;
    private final String rawAddress;
    private final Boolean richFunctionalityAvailable;
    private final Boolean servicesPaidByPartner;
    private final SplashScreen splashScreen;
    private final String timezone;

    /* compiled from: Profile.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Profile> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Profile createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string = parcel.readString();
            String string2 = parcel.readString();
            Boolean boolValueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            ProfileCardInfo profileCardInfoCreateFromParcel = parcel.readInt() == 0 ? null : ProfileCardInfo.CREATOR.createFromParcel(parcel);
            Boolean boolValueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf4 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf5 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            BlockingLevel blockingLevelValueOf = BlockingLevel.valueOf(parcel.readString());
            String string7 = parcel.readString();
            Boolean boolValueOf6 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            SplashScreen splashScreenCreateFromParcel = parcel.readInt() == 0 ? null : SplashScreen.CREATOR.createFromParcel(parcel);
            String string10 = parcel.readString();
            Boolean boolValueOf7 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf8 = parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null;
            String string11 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(UserAddress.CREATOR.createFromParcel(parcel));
            }
            return new Profile(boolValueOf, string, string2, boolValueOf2, profileCardInfoCreateFromParcel, boolValueOf3, boolValueOf4, boolValueOf5, string3, string4, string5, string6, blockingLevelValueOf, string7, boolValueOf6, string8, string9, splashScreenCreateFromParcel, string10, boolValueOf7, boolValueOf8, string11, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Profile[] newArray(int i) {
            return new Profile[i];
        }
    }

    public final Profile copy(Boolean callIsEnabled, String firstName, String avatar, Boolean isNeedFeedback, ProfileCardInfo cardInfo, Boolean faceRecognitionDataUploaded, Boolean servicesPaidByPartner, Boolean blocked, String blockingReason, String localization, String address, String addressWithApartment, BlockingLevel blockLevel, String apartment, Boolean historyAvailable, String pushToken, String timezone, SplashScreen splashScreen, String rawAddress, Boolean loadingVideo, Boolean richFunctionalityAvailable, String paymentMethod, List<UserAddress> addresses) {
        Intrinsics.checkNotNullParameter(blockLevel, "blockLevel");
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        return new Profile(callIsEnabled, firstName, avatar, isNeedFeedback, cardInfo, faceRecognitionDataUploaded, servicesPaidByPartner, blocked, blockingReason, localization, address, addressWithApartment, blockLevel, apartment, historyAvailable, pushToken, timezone, splashScreen, rawAddress, loadingVideo, richFunctionalityAvailable, paymentMethod, addresses);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) other;
        return Intrinsics.areEqual(this.callIsEnabled, profile.callIsEnabled) && Intrinsics.areEqual(this.firstName, profile.firstName) && Intrinsics.areEqual(this.avatar, profile.avatar) && Intrinsics.areEqual(this.isNeedFeedback, profile.isNeedFeedback) && Intrinsics.areEqual(this.cardInfo, profile.cardInfo) && Intrinsics.areEqual(this.faceRecognitionDataUploaded, profile.faceRecognitionDataUploaded) && Intrinsics.areEqual(this.servicesPaidByPartner, profile.servicesPaidByPartner) && Intrinsics.areEqual(this.blocked, profile.blocked) && Intrinsics.areEqual(this.blockingReason, profile.blockingReason) && Intrinsics.areEqual(this.localization, profile.localization) && Intrinsics.areEqual(this.address, profile.address) && Intrinsics.areEqual(this.addressWithApartment, profile.addressWithApartment) && this.blockLevel == profile.blockLevel && Intrinsics.areEqual(this.apartment, profile.apartment) && Intrinsics.areEqual(this.historyAvailable, profile.historyAvailable) && Intrinsics.areEqual(this.pushToken, profile.pushToken) && Intrinsics.areEqual(this.timezone, profile.timezone) && Intrinsics.areEqual(this.splashScreen, profile.splashScreen) && Intrinsics.areEqual(this.rawAddress, profile.rawAddress) && Intrinsics.areEqual(this.loadingVideo, profile.loadingVideo) && Intrinsics.areEqual(this.richFunctionalityAvailable, profile.richFunctionalityAvailable) && Intrinsics.areEqual(this.paymentMethod, profile.paymentMethod) && Intrinsics.areEqual(this.addresses, profile.addresses);
    }

    public int hashCode() {
        Boolean bool = this.callIsEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.firstName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool2 = this.isNeedFeedback;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        ProfileCardInfo profileCardInfo = this.cardInfo;
        int iHashCode5 = (iHashCode4 + (profileCardInfo == null ? 0 : profileCardInfo.hashCode())) * 31;
        Boolean bool3 = this.faceRecognitionDataUploaded;
        int iHashCode6 = (iHashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.servicesPaidByPartner;
        int iHashCode7 = (iHashCode6 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.blocked;
        int iHashCode8 = (iHashCode7 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        String str3 = this.blockingReason;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.localization;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.address;
        int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.addressWithApartment;
        int iHashCode12 = (((iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.blockLevel.hashCode()) * 31;
        String str7 = this.apartment;
        int iHashCode13 = (iHashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool6 = this.historyAvailable;
        int iHashCode14 = (iHashCode13 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        String str8 = this.pushToken;
        int iHashCode15 = (iHashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.timezone;
        int iHashCode16 = (iHashCode15 + (str9 == null ? 0 : str9.hashCode())) * 31;
        SplashScreen splashScreen = this.splashScreen;
        int iHashCode17 = (iHashCode16 + (splashScreen == null ? 0 : splashScreen.hashCode())) * 31;
        String str10 = this.rawAddress;
        int iHashCode18 = (iHashCode17 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Boolean bool7 = this.loadingVideo;
        int iHashCode19 = (iHashCode18 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.richFunctionalityAvailable;
        int iHashCode20 = (iHashCode19 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        String str11 = this.paymentMethod;
        return ((iHashCode20 + (str11 != null ? str11.hashCode() : 0)) * 31) + this.addresses.hashCode();
    }

    public String toString() {
        return "Profile(callIsEnabled=" + this.callIsEnabled + ", firstName=" + this.firstName + ", avatar=" + this.avatar + ", isNeedFeedback=" + this.isNeedFeedback + ", cardInfo=" + this.cardInfo + ", faceRecognitionDataUploaded=" + this.faceRecognitionDataUploaded + ", servicesPaidByPartner=" + this.servicesPaidByPartner + ", blocked=" + this.blocked + ", blockingReason=" + this.blockingReason + ", localization=" + this.localization + ", address=" + this.address + ", addressWithApartment=" + this.addressWithApartment + ", blockLevel=" + this.blockLevel + ", apartment=" + this.apartment + ", historyAvailable=" + this.historyAvailable + ", pushToken=" + this.pushToken + ", timezone=" + this.timezone + ", splashScreen=" + this.splashScreen + ", rawAddress=" + this.rawAddress + ", loadingVideo=" + this.loadingVideo + ", richFunctionalityAvailable=" + this.richFunctionalityAvailable + ", paymentMethod=" + this.paymentMethod + ", addresses=" + this.addresses + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Boolean bool = this.callIsEnabled;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.firstName);
        parcel.writeString(this.avatar);
        Boolean bool2 = this.isNeedFeedback;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        ProfileCardInfo profileCardInfo = this.cardInfo;
        if (profileCardInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profileCardInfo.writeToParcel(parcel, flags);
        }
        Boolean bool3 = this.faceRecognitionDataUploaded;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.servicesPaidByPartner;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.blocked;
        if (bool5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.blockingReason);
        parcel.writeString(this.localization);
        parcel.writeString(this.address);
        parcel.writeString(this.addressWithApartment);
        parcel.writeString(this.blockLevel.name());
        parcel.writeString(this.apartment);
        Boolean bool6 = this.historyAvailable;
        if (bool6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.pushToken);
        parcel.writeString(this.timezone);
        SplashScreen splashScreen = this.splashScreen;
        if (splashScreen == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            splashScreen.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.rawAddress);
        Boolean bool7 = this.loadingVideo;
        if (bool7 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool7.booleanValue() ? 1 : 0);
        }
        Boolean bool8 = this.richFunctionalityAvailable;
        if (bool8 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool8.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.paymentMethod);
        List<UserAddress> list = this.addresses;
        parcel.writeInt(list.size());
        Iterator<UserAddress> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public Profile(Boolean bool, String str, String str2, Boolean bool2, ProfileCardInfo profileCardInfo, Boolean bool3, Boolean bool4, Boolean bool5, String str3, String str4, String str5, String str6, BlockingLevel blockLevel, String str7, Boolean bool6, String str8, String str9, SplashScreen splashScreen, String str10, Boolean bool7, Boolean bool8, String str11, List<UserAddress> addresses) {
        Intrinsics.checkNotNullParameter(blockLevel, "blockLevel");
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        this.callIsEnabled = bool;
        this.firstName = str;
        this.avatar = str2;
        this.isNeedFeedback = bool2;
        this.cardInfo = profileCardInfo;
        this.faceRecognitionDataUploaded = bool3;
        this.servicesPaidByPartner = bool4;
        this.blocked = bool5;
        this.blockingReason = str3;
        this.localization = str4;
        this.address = str5;
        this.addressWithApartment = str6;
        this.blockLevel = blockLevel;
        this.apartment = str7;
        this.historyAvailable = bool6;
        this.pushToken = str8;
        this.timezone = str9;
        this.splashScreen = splashScreen;
        this.rawAddress = str10;
        this.loadingVideo = bool7;
        this.richFunctionalityAvailable = bool8;
        this.paymentMethod = str11;
        this.addresses = addresses;
    }

    public final Boolean getCallIsEnabled() {
        return this.callIsEnabled;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: isNeedFeedback, reason: from getter */
    public final Boolean getIsNeedFeedback() {
        return this.isNeedFeedback;
    }

    public final ProfileCardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final Boolean getFaceRecognitionDataUploaded() {
        return this.faceRecognitionDataUploaded;
    }

    public final Boolean getBlocked() {
        return this.blocked;
    }

    public final String getBlockingReason() {
        return this.blockingReason;
    }

    public final String getLocalization() {
        return this.localization;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAddressWithApartment() {
        return this.addressWithApartment;
    }

    public final String getApartment() {
        return this.apartment;
    }

    public final Boolean getHistoryAvailable() {
        return this.historyAvailable;
    }

    public final SplashScreen getSplashScreen() {
        return this.splashScreen;
    }

    public final String getRawAddress() {
        return this.rawAddress;
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

    public final List<UserAddress> getAddresses() {
        return this.addresses;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.sputnik.domain.entities.profile.ProfileNavigationState getNavigationStateForDomainAddress(com.sputnik.domain.entities.profile.DomainProfile.DomainAddress r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L8
            java.lang.String r1 = r5.getEntryUUID()
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = 0
            if (r1 != 0) goto L16
            if (r5 == 0) goto L13
            java.lang.String r1 = r5.getFullAddress()
            goto L14
        L13:
            r1 = r0
        L14:
            if (r1 == 0) goto L2c
        L16:
            if (r5 == 0) goto L23
            java.lang.Boolean r1 = r5.getAddressVerificationRequired()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            goto L24
        L23:
            r1 = r2
        L24:
            if (r1 == 0) goto L2c
            com.sputnik.domain.entities.profile.ProfileNavigationState$ToVerifyAddressState r5 = new com.sputnik.domain.entities.profile.ProfileNavigationState$ToVerifyAddressState
            r5.<init>()
            goto L57
        L2c:
            if (r5 == 0) goto L33
            java.lang.String r1 = r5.getEntryUUID()
            goto L34
        L33:
            r1 = r0
        L34:
            if (r1 != 0) goto L3e
            if (r5 == 0) goto L3c
            java.lang.String r0 = r5.getFullAddress()
        L3c:
            if (r0 == 0) goto L52
        L3e:
            if (r5 == 0) goto L4a
            java.lang.Boolean r5 = r5.getAddressVerificationRequired()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
        L4a:
            if (r2 == 0) goto L52
            com.sputnik.domain.entities.profile.ProfileNavigationState$ToEnterFlatNumberState r5 = new com.sputnik.domain.entities.profile.ProfileNavigationState$ToEnterFlatNumberState
            r5.<init>()
            goto L57
        L52:
            com.sputnik.domain.entities.profile.ProfileNavigationState$ToIntercomState r5 = new com.sputnik.domain.entities.profile.ProfileNavigationState$ToIntercomState
            r5.<init>()
        L57:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.entities.profile.Profile.getNavigationStateForDomainAddress(com.sputnik.domain.entities.profile.DomainProfile$DomainAddress):com.sputnik.domain.entities.profile.ProfileNavigationState");
    }

    public final ProfileNavigationState getNavigationState(DomainProfile input) {
        Object next;
        Intrinsics.checkNotNullParameter(input, "input");
        Iterator<T> it = input.getAddresses().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DomainProfile.DomainAddress) next).getApartment() != null) {
                break;
            }
        }
        boolean z = next != null;
        String firstName = input.getFirstName();
        if (firstName == null || StringsKt.isBlank(firstName)) {
            return new ProfileNavigationState.ToRegistrationState();
        }
        if (input.getState() == StateType.registered || input.getAddresses().isEmpty()) {
            return new ProfileNavigationState.ToIntercomState();
        }
        if (Intrinsics.areEqual(input.getAddressVerificationRequired(), Boolean.TRUE)) {
            return new ProfileNavigationState.ToVerifyAddressState();
        }
        if (Intrinsics.areEqual(input.getAddressVerificationRequired(), Boolean.FALSE) && input.getApartment() == null) {
            return new ProfileNavigationState.ToEnterFlatNumberState();
        }
        if (!z) {
            return getNavigationStateForDomainAddress((DomainProfile.DomainAddress) CollectionsKt.first((List) input.getAddresses()));
        }
        return new ProfileNavigationState.ToActivatedState();
    }
}
