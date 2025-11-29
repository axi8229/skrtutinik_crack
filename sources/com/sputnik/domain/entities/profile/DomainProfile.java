package com.sputnik.domain.entities.profile;

import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.domain.entities.auth.StateType;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: DomainProfile.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001:\u0001TB³\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u00102R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00103\u001a\u0004\b4\u0010'R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b5\u00102R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u00103\u001a\u0004\b6\u0010'R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b7\u0010'R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b\u000b\u00102R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u00100\u001a\u0004\b;\u00102R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u00100\u001a\u0004\b<\u00102R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u00100\u001a\u0004\b=\u00102R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\b>\u0010'R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b?\u0010'R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u00103\u001a\u0004\b@\u0010'R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u00103\u001a\u0004\bA\u0010'R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010B\u001a\u0004\bC\u0010DR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\bH\u00102R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\bI\u0010'R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\bJ\u0010'R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\bN\u00102R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\bO\u00102R\u0019\u0010 \u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\bP\u0010'R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006¢\u0006\f\n\u0004\b#\u0010Q\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lcom/sputnik/domain/entities/profile/DomainProfile;", "", "Lcom/sputnik/domain/entities/auth/StateType;", "state", "", "addressVerificationRequired", "", "apartment", "callIsEnabled", "firstName", "avatar", "isNeedFeedback", "Lcom/sputnik/domain/entities/profile/DomainProfileCardInfo;", "cardInfo", "faceRecognitionDataUploaded", "servicesPaidByPartner", "blocked", "blockingReason", "localization", "address", "addressWithApartment", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "navigationState", "", "blockLevel", "historyAvailable", "pushToken", "timezone", "Lcom/sputnik/domain/entities/profile/DomainSplashScreen;", "splashScreen", "loadingVideo", "richFunctionalityAvailable", "paymentMethod", "", "Lcom/sputnik/domain/entities/profile/DomainProfile$DomainAddress;", "addresses", "<init>", "(Lcom/sputnik/domain/entities/auth/StateType;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/domain/entities/profile/DomainProfileCardInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/profile/ProfileNavigationState;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/profile/DomainSplashScreen;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/auth/StateType;", "getState", "()Lcom/sputnik/domain/entities/auth/StateType;", "Ljava/lang/Boolean;", "getAddressVerificationRequired", "()Ljava/lang/Boolean;", "Ljava/lang/String;", "getApartment", "getCallIsEnabled", "getFirstName", "getAvatar", "Lcom/sputnik/domain/entities/profile/DomainProfileCardInfo;", "getCardInfo", "()Lcom/sputnik/domain/entities/profile/DomainProfileCardInfo;", "getFaceRecognitionDataUploaded", "getServicesPaidByPartner", "getBlocked", "getBlockingReason", "getLocalization", "getAddress", "getAddressWithApartment", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "getNavigationState", "()Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "Ljava/lang/Integer;", "getBlockLevel", "()Ljava/lang/Integer;", "getHistoryAvailable", "getPushToken", "getTimezone", "Lcom/sputnik/domain/entities/profile/DomainSplashScreen;", "getSplashScreen", "()Lcom/sputnik/domain/entities/profile/DomainSplashScreen;", "getLoadingVideo", "getRichFunctionalityAvailable", "getPaymentMethod", "Ljava/util/List;", "getAddresses", "()Ljava/util/List;", "DomainAddress", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainProfile {
    private final String address;
    private final Boolean addressVerificationRequired;
    private final String addressWithApartment;
    private final List<DomainAddress> addresses;
    private final String apartment;
    private final String avatar;
    private final Integer blockLevel;
    private final Boolean blocked;
    private final String blockingReason;
    private final Boolean callIsEnabled;
    private final DomainProfileCardInfo cardInfo;
    private final Boolean faceRecognitionDataUploaded;
    private final String firstName;
    private final Boolean historyAvailable;
    private final Boolean isNeedFeedback;
    private final Boolean loadingVideo;
    private final String localization;
    private final ProfileNavigationState navigationState;
    private final String paymentMethod;
    private final String pushToken;
    private final Boolean richFunctionalityAvailable;
    private final Boolean servicesPaidByPartner;
    private final DomainSplashScreen splashScreen;
    private final StateType state;
    private final String timezone;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainProfile)) {
            return false;
        }
        DomainProfile domainProfile = (DomainProfile) other;
        return this.state == domainProfile.state && Intrinsics.areEqual(this.addressVerificationRequired, domainProfile.addressVerificationRequired) && Intrinsics.areEqual(this.apartment, domainProfile.apartment) && Intrinsics.areEqual(this.callIsEnabled, domainProfile.callIsEnabled) && Intrinsics.areEqual(this.firstName, domainProfile.firstName) && Intrinsics.areEqual(this.avatar, domainProfile.avatar) && Intrinsics.areEqual(this.isNeedFeedback, domainProfile.isNeedFeedback) && Intrinsics.areEqual(this.cardInfo, domainProfile.cardInfo) && Intrinsics.areEqual(this.faceRecognitionDataUploaded, domainProfile.faceRecognitionDataUploaded) && Intrinsics.areEqual(this.servicesPaidByPartner, domainProfile.servicesPaidByPartner) && Intrinsics.areEqual(this.blocked, domainProfile.blocked) && Intrinsics.areEqual(this.blockingReason, domainProfile.blockingReason) && Intrinsics.areEqual(this.localization, domainProfile.localization) && Intrinsics.areEqual(this.address, domainProfile.address) && Intrinsics.areEqual(this.addressWithApartment, domainProfile.addressWithApartment) && Intrinsics.areEqual(this.navigationState, domainProfile.navigationState) && Intrinsics.areEqual(this.blockLevel, domainProfile.blockLevel) && Intrinsics.areEqual(this.historyAvailable, domainProfile.historyAvailable) && Intrinsics.areEqual(this.pushToken, domainProfile.pushToken) && Intrinsics.areEqual(this.timezone, domainProfile.timezone) && Intrinsics.areEqual(this.splashScreen, domainProfile.splashScreen) && Intrinsics.areEqual(this.loadingVideo, domainProfile.loadingVideo) && Intrinsics.areEqual(this.richFunctionalityAvailable, domainProfile.richFunctionalityAvailable) && Intrinsics.areEqual(this.paymentMethod, domainProfile.paymentMethod) && Intrinsics.areEqual(this.addresses, domainProfile.addresses);
    }

    public int hashCode() {
        StateType stateType = this.state;
        int iHashCode = (stateType == null ? 0 : stateType.hashCode()) * 31;
        Boolean bool = this.addressVerificationRequired;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.apartment;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool2 = this.callIsEnabled;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.firstName;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool3 = this.isNeedFeedback;
        int iHashCode7 = (iHashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        DomainProfileCardInfo domainProfileCardInfo = this.cardInfo;
        int iHashCode8 = (iHashCode7 + (domainProfileCardInfo == null ? 0 : domainProfileCardInfo.hashCode())) * 31;
        Boolean bool4 = this.faceRecognitionDataUploaded;
        int iHashCode9 = (iHashCode8 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.servicesPaidByPartner;
        int iHashCode10 = (iHashCode9 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.blocked;
        int iHashCode11 = (iHashCode10 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        String str4 = this.blockingReason;
        int iHashCode12 = (iHashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.localization;
        int iHashCode13 = (iHashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.address;
        int iHashCode14 = (iHashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.addressWithApartment;
        int iHashCode15 = (((iHashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.navigationState.hashCode()) * 31;
        Integer num = this.blockLevel;
        int iHashCode16 = (iHashCode15 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool7 = this.historyAvailable;
        int iHashCode17 = (iHashCode16 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        String str8 = this.pushToken;
        int iHashCode18 = (iHashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.timezone;
        int iHashCode19 = (iHashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
        DomainSplashScreen domainSplashScreen = this.splashScreen;
        int iHashCode20 = (iHashCode19 + (domainSplashScreen == null ? 0 : domainSplashScreen.hashCode())) * 31;
        Boolean bool8 = this.loadingVideo;
        int iHashCode21 = (iHashCode20 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.richFunctionalityAvailable;
        int iHashCode22 = (iHashCode21 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        String str10 = this.paymentMethod;
        return ((iHashCode22 + (str10 != null ? str10.hashCode() : 0)) * 31) + this.addresses.hashCode();
    }

    public String toString() {
        return "DomainProfile(state=" + this.state + ", addressVerificationRequired=" + this.addressVerificationRequired + ", apartment=" + this.apartment + ", callIsEnabled=" + this.callIsEnabled + ", firstName=" + this.firstName + ", avatar=" + this.avatar + ", isNeedFeedback=" + this.isNeedFeedback + ", cardInfo=" + this.cardInfo + ", faceRecognitionDataUploaded=" + this.faceRecognitionDataUploaded + ", servicesPaidByPartner=" + this.servicesPaidByPartner + ", blocked=" + this.blocked + ", blockingReason=" + this.blockingReason + ", localization=" + this.localization + ", address=" + this.address + ", addressWithApartment=" + this.addressWithApartment + ", navigationState=" + this.navigationState + ", blockLevel=" + this.blockLevel + ", historyAvailable=" + this.historyAvailable + ", pushToken=" + this.pushToken + ", timezone=" + this.timezone + ", splashScreen=" + this.splashScreen + ", loadingVideo=" + this.loadingVideo + ", richFunctionalityAvailable=" + this.richFunctionalityAvailable + ", paymentMethod=" + this.paymentMethod + ", addresses=" + this.addresses + ")";
    }

    public DomainProfile(StateType stateType, Boolean bool, String str, Boolean bool2, String str2, String str3, Boolean bool3, DomainProfileCardInfo domainProfileCardInfo, Boolean bool4, Boolean bool5, Boolean bool6, String str4, String str5, String str6, String str7, ProfileNavigationState navigationState, Integer num, Boolean bool7, String str8, String str9, DomainSplashScreen domainSplashScreen, Boolean bool8, Boolean bool9, String str10, List<DomainAddress> addresses) {
        Intrinsics.checkNotNullParameter(navigationState, "navigationState");
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        this.state = stateType;
        this.addressVerificationRequired = bool;
        this.apartment = str;
        this.callIsEnabled = bool2;
        this.firstName = str2;
        this.avatar = str3;
        this.isNeedFeedback = bool3;
        this.cardInfo = domainProfileCardInfo;
        this.faceRecognitionDataUploaded = bool4;
        this.servicesPaidByPartner = bool5;
        this.blocked = bool6;
        this.blockingReason = str4;
        this.localization = str5;
        this.address = str6;
        this.addressWithApartment = str7;
        this.navigationState = navigationState;
        this.blockLevel = num;
        this.historyAvailable = bool7;
        this.pushToken = str8;
        this.timezone = str9;
        this.splashScreen = domainSplashScreen;
        this.loadingVideo = bool8;
        this.richFunctionalityAvailable = bool9;
        this.paymentMethod = str10;
        this.addresses = addresses;
    }

    public final StateType getState() {
        return this.state;
    }

    public final Boolean getAddressVerificationRequired() {
        return this.addressVerificationRequired;
    }

    public final String getApartment() {
        return this.apartment;
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

    public final DomainProfileCardInfo getCardInfo() {
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

    public final String getLocalization() {
        return this.localization;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAddressWithApartment() {
        return this.addressWithApartment;
    }

    public /* synthetic */ DomainProfile(StateType stateType, Boolean bool, String str, Boolean bool2, String str2, String str3, Boolean bool3, DomainProfileCardInfo domainProfileCardInfo, Boolean bool4, Boolean bool5, Boolean bool6, String str4, String str5, String str6, String str7, ProfileNavigationState profileNavigationState, Integer num, Boolean bool7, String str8, String str9, DomainSplashScreen domainSplashScreen, Boolean bool8, Boolean bool9, String str10, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : stateType, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : bool3, (i & 128) != 0 ? null : domainProfileCardInfo, (i & 256) != 0 ? null : bool4, (i & 512) != 0 ? null : bool5, (i & 1024) != 0 ? null : bool6, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : str5, (i & 8192) != 0 ? null : str6, (i & 16384) != 0 ? null : str7, (32768 & i) != 0 ? new ProfileNavigationState.ToRegistrationState() : profileNavigationState, (65536 & i) != 0 ? null : num, (131072 & i) != 0 ? null : bool7, (262144 & i) != 0 ? null : str8, (524288 & i) != 0 ? null : str9, domainSplashScreen, (2097152 & i) != 0 ? null : bool8, (4194304 & i) != 0 ? null : bool9, (8388608 & i) != 0 ? null : str10, (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Integer getBlockLevel() {
        return this.blockLevel;
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

    public final DomainSplashScreen getSplashScreen() {
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

    public final List<DomainAddress> getAddresses() {
        return this.addresses;
    }

    /* compiled from: DomainProfile.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u0010R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b \u0010\u0010R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b!\u0010\u0010R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lcom/sputnik/domain/entities/profile/DomainProfile$DomainAddress;", "", "", "id", "", "fullAddress", "fullAddressWithApartment", "", "addressVerificationRequired", "apartment", "flatUUID", "entryUUID", UpdateKey.STATUS, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getFullAddress", "getFullAddressWithApartment", "Ljava/lang/Boolean;", "getAddressVerificationRequired", "()Ljava/lang/Boolean;", "getApartment", "getFlatUUID", "getEntryUUID", "getStatus", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainAddress {
        private final Boolean addressVerificationRequired;
        private final Integer apartment;
        private final String entryUUID;
        private final String flatUUID;
        private final String fullAddress;
        private final String fullAddressWithApartment;
        private final Integer id;
        private final String status;

        public DomainAddress() {
            this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainAddress)) {
                return false;
            }
            DomainAddress domainAddress = (DomainAddress) other;
            return Intrinsics.areEqual(this.id, domainAddress.id) && Intrinsics.areEqual(this.fullAddress, domainAddress.fullAddress) && Intrinsics.areEqual(this.fullAddressWithApartment, domainAddress.fullAddressWithApartment) && Intrinsics.areEqual(this.addressVerificationRequired, domainAddress.addressVerificationRequired) && Intrinsics.areEqual(this.apartment, domainAddress.apartment) && Intrinsics.areEqual(this.flatUUID, domainAddress.flatUUID) && Intrinsics.areEqual(this.entryUUID, domainAddress.entryUUID) && Intrinsics.areEqual(this.status, domainAddress.status);
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
            return "DomainAddress(id=" + this.id + ", fullAddress=" + this.fullAddress + ", fullAddressWithApartment=" + this.fullAddressWithApartment + ", addressVerificationRequired=" + this.addressVerificationRequired + ", apartment=" + this.apartment + ", flatUUID=" + this.flatUUID + ", entryUUID=" + this.entryUUID + ", status=" + this.status + ")";
        }

        public DomainAddress(Integer num, String str, String str2, Boolean bool, Integer num2, String str3, String str4, String str5) {
            this.id = num;
            this.fullAddress = str;
            this.fullAddressWithApartment = str2;
            this.addressVerificationRequired = bool;
            this.apartment = num2;
            this.flatUUID = str3;
            this.entryUUID = str4;
            this.status = str5;
        }

        public /* synthetic */ DomainAddress(Integer num, String str, String str2, Boolean bool, Integer num2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
