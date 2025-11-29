package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bU\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\b\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001Bá\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010(\u001a\u00020\u0014\u0012\b\b\u0002\u0010)\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00100\u001a\u00020\u0014¢\u0006\u0002\u00101J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u0014HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0014HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010EJ\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010k\u001a\u00020\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\"HÆ\u0003J\t\u0010p\u001a\u00020\u0014HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010'HÆ\u0003J\t\u0010s\u001a\u00020\u0014HÆ\u0003J\t\u0010t\u001a\u00020\u0014HÆ\u0003J\u0011\u0010u\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010/HÆ\u0003J\t\u0010y\u001a\u00020\u0014HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u000bHÆ\u0003J\t\u0010~\u001a\u00020\rHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jú\u0002\u0010\u0080\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020\u0014HÆ\u0001¢\u0006\u0003\u0010\u0081\u0001J\n\u0010\u0082\u0001\u001a\u00020\u001bHÖ\u0001J\u0016\u0010\u0083\u0001\u001a\u00020\u00142\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001HÖ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u001bHÖ\u0001J\n\u0010\u0087\u0001\u001a\u00020\u0005HÖ\u0001J\u001e\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010)\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010#\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b>\u0010;R\u0011\u0010(\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b?\u0010;R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010;R\u0013\u0010-\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u00103R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010F\u001a\u0004\bD\u0010ER\u0011\u0010\u0018\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u00100\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bX\u0010;R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u00103R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\\\u00103R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u00103R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u00103R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u00103¨\u0006\u0091\u0001"}, d2 = {"Lru/yoomoney/sdk/auth/Config;", "Landroid/os/Parcelable;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/Config$Origin;", "authCenterClientId", "", "authCenterClientSecret", "yandexClientId", YooMoneyAuth.KEY_ACCESS_TOKEN, "yandexPassportToken", "processType", "Lru/yoomoney/sdk/auth/Config$ProcessType;", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "phoneIdentifier", "Lru/yoomoney/sdk/auth/PhoneIdentifier;", "style", "Lru/yoomoney/sdk/auth/Style;", "apiHost", "isDebugMode", "", "supportEmail", "supportHelpUrl", "supportPhone", "migrationBannerVisible", "migrationBannerText", "migrationBannerTextColor", "", "migrationBannerButtonText", "migrationBannerImageUrl", QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "prefilledData", "Lru/yoomoney/sdk/auth/PrefilledData;", "enableAutoEnrollment", "oauthParams", "Lru/yoomoney/sdk/auth/OauthParams;", "qrAuthConfig", "Lru/yoomoney/sdk/auth/QrAuthConfig;", YooMoneyAuth.KEY_IDENTIFICATION_ACCESSIBLE, "confirmationHelpActionVisible", "availableSocialAccounts", "", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "loginContextId", "emailFillingReason", "Lru/yoomoney/sdk/auth/Config$EmailFillingReason;", "showServices", "(Lru/yoomoney/sdk/auth/Config$Origin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/Config$ProcessType;Lru/yoomoney/sdk/auth/Config$ProductType;Lru/yoomoney/sdk/auth/PhoneIdentifier;Lru/yoomoney/sdk/auth/Style;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/RemoteConfig;Lru/yoomoney/sdk/auth/PrefilledData;ZLru/yoomoney/sdk/auth/OauthParams;Lru/yoomoney/sdk/auth/QrAuthConfig;ZZLjava/util/List;Ljava/lang/String;Lru/yoomoney/sdk/auth/Config$EmailFillingReason;Z)V", "getAccessToken", "()Ljava/lang/String;", "getApiHost", "getApplicationUserAgent", "getAuthCenterClientId", "getAuthCenterClientSecret", "getAvailableSocialAccounts", "()Ljava/util/List;", "getConfirmationHelpActionVisible", "()Z", "getEmailFillingReason", "()Lru/yoomoney/sdk/auth/Config$EmailFillingReason;", "getEnableAutoEnrollment", "getIdentificationAccessible", "getLoginContextId", "getMigrationBannerButtonText", "getMigrationBannerImageUrl", "getMigrationBannerText", "getMigrationBannerTextColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMigrationBannerVisible", "getOauthParams", "()Lru/yoomoney/sdk/auth/OauthParams;", "getOrigin", "()Lru/yoomoney/sdk/auth/Config$Origin;", "getPhoneIdentifier", "()Lru/yoomoney/sdk/auth/PhoneIdentifier;", "getPrefilledData", "()Lru/yoomoney/sdk/auth/PrefilledData;", "getProcessType", "()Lru/yoomoney/sdk/auth/Config$ProcessType;", "getProductType", "()Lru/yoomoney/sdk/auth/Config$ProductType;", "getQrAuthConfig", "()Lru/yoomoney/sdk/auth/QrAuthConfig;", "getRemoteConfig", "()Lru/yoomoney/sdk/auth/RemoteConfig;", "getShowServices", "getStyle", "()Lru/yoomoney/sdk/auth/Style;", "getSupportEmail", "getSupportHelpUrl", "getSupportPhone", "getYandexClientId", "getYandexPassportToken", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lru/yoomoney/sdk/auth/Config$Origin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/Config$ProcessType;Lru/yoomoney/sdk/auth/Config$ProductType;Lru/yoomoney/sdk/auth/PhoneIdentifier;Lru/yoomoney/sdk/auth/Style;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/RemoteConfig;Lru/yoomoney/sdk/auth/PrefilledData;ZLru/yoomoney/sdk/auth/OauthParams;Lru/yoomoney/sdk/auth/QrAuthConfig;ZZLjava/util/List;Ljava/lang/String;Lru/yoomoney/sdk/auth/Config$EmailFillingReason;Z)Lru/yoomoney/sdk/auth/Config;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "EmailFillingReason", "Origin", "ProcessType", "ProductType", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Config implements Parcelable {
    public static final Parcelable.Creator<Config> CREATOR = new Creator();
    private final String accessToken;
    private final String apiHost;
    private final String applicationUserAgent;
    private final String authCenterClientId;
    private final String authCenterClientSecret;
    private final List<OauthServiceProvider> availableSocialAccounts;
    private final boolean confirmationHelpActionVisible;
    private final EmailFillingReason emailFillingReason;
    private final boolean enableAutoEnrollment;
    private final boolean identificationAccessible;
    private final boolean isDebugMode;
    private final String loginContextId;
    private final String migrationBannerButtonText;
    private final String migrationBannerImageUrl;
    private final String migrationBannerText;
    private final Integer migrationBannerTextColor;
    private final boolean migrationBannerVisible;
    private final OauthParams oauthParams;
    private final Origin origin;
    private final PhoneIdentifier phoneIdentifier;
    private final PrefilledData prefilledData;
    private final ProcessType processType;
    private final ProductType productType;
    private final QrAuthConfig qrAuthConfig;
    private final RemoteConfig remoteConfig;
    private final boolean showServices;
    private final Style style;
    private final String supportEmail;
    private final String supportHelpUrl;
    private final String supportPhone;
    private final String yandexClientId;
    private final String yandexPassportToken;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Config> {
        @Override // android.os.Parcelable.Creator
        public final Config createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Origin originValueOf = Origin.valueOf(parcel.readString());
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            ProcessType processTypeValueOf = ProcessType.valueOf(parcel.readString());
            ProductType productTypeValueOf = ProductType.valueOf(parcel.readString());
            PhoneIdentifier phoneIdentifierCreateFromParcel = parcel.readInt() == 0 ? null : PhoneIdentifier.CREATOR.createFromParcel(parcel);
            Style styleCreateFromParcel = parcel.readInt() == 0 ? null : Style.CREATOR.createFromParcel(parcel);
            String string6 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            String string10 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            String string13 = parcel.readString();
            RemoteConfig remoteConfigCreateFromParcel = parcel.readInt() == 0 ? null : RemoteConfig.CREATOR.createFromParcel(parcel);
            PrefilledData prefilledDataCreateFromParcel = parcel.readInt() == 0 ? null : PrefilledData.CREATOR.createFromParcel(parcel);
            boolean z3 = parcel.readInt() != 0;
            OauthParams oauthParamsCreateFromParcel = parcel.readInt() == 0 ? null : OauthParams.CREATOR.createFromParcel(parcel);
            QrAuthConfig qrAuthConfigCreateFromParcel = parcel.readInt() == 0 ? null : QrAuthConfig.CREATOR.createFromParcel(parcel);
            boolean z4 = parcel.readInt() != 0;
            boolean z5 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(OauthServiceProvider.valueOf(parcel.readString()));
                }
                arrayList = arrayList2;
            }
            return new Config(originValueOf, string, string2, string3, string4, string5, processTypeValueOf, productTypeValueOf, phoneIdentifierCreateFromParcel, styleCreateFromParcel, string6, z, string7, string8, string9, z2, string10, numValueOf, string11, string12, string13, remoteConfigCreateFromParcel, prefilledDataCreateFromParcel, z3, oauthParamsCreateFromParcel, qrAuthConfigCreateFromParcel, z4, z5, arrayList, parcel.readString(), parcel.readInt() == 0 ? null : EmailFillingReason.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final Config[] newArray(int i) {
            return new Config[i];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/auth/Config$EmailFillingReason;", "", "(Ljava/lang/String;I)V", "UPGRADE_STATUS", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EmailFillingReason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EmailFillingReason[] $VALUES;
        public static final EmailFillingReason UPGRADE_STATUS = new EmailFillingReason("UPGRADE_STATUS", 0);

        private static final /* synthetic */ EmailFillingReason[] $values() {
            return new EmailFillingReason[]{UPGRADE_STATUS};
        }

        static {
            EmailFillingReason[] emailFillingReasonArr$values = $values();
            $VALUES = emailFillingReasonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(emailFillingReasonArr$values);
        }

        private EmailFillingReason(String str, int i) {
        }

        public static EnumEntries<EmailFillingReason> getEntries() {
            return $ENTRIES;
        }

        public static EmailFillingReason valueOf(String str) {
            return (EmailFillingReason) Enum.valueOf(EmailFillingReason.class, str);
        }

        public static EmailFillingReason[] values() {
            return (EmailFillingReason[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/Config$Origin;", "", "(Ljava/lang/String;I)V", "WALLET", "CHECKOUT", "CORPORATE_BANKING", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Origin {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Origin[] $VALUES;
        public static final Origin WALLET = new Origin("WALLET", 0);
        public static final Origin CHECKOUT = new Origin("CHECKOUT", 1);
        public static final Origin CORPORATE_BANKING = new Origin("CORPORATE_BANKING", 2);

        private static final /* synthetic */ Origin[] $values() {
            return new Origin[]{WALLET, CHECKOUT, CORPORATE_BANKING};
        }

        static {
            Origin[] originArr$values = $values();
            $VALUES = originArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(originArr$values);
        }

        private Origin(String str, int i) {
        }

        public static EnumEntries<Origin> getEntries() {
            return $ENTRIES;
        }

        public static Origin valueOf(String str) {
            return (Origin) Enum.valueOf(Origin.class, str);
        }

        public static Origin[] values() {
            return (Origin[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/Config$ProcessType;", "", "(Ljava/lang/String;I)V", "ENROLLMENT", "REGISTRATION", "LOGIN", "MIGRATION", "EMAIL", "PROFILE", "LOGIN_SBER", "LOGIN_VK", "LOGIN_ESIA", "QR_AUTH", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ProcessType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProcessType[] $VALUES;
        public static final ProcessType ENROLLMENT = new ProcessType("ENROLLMENT", 0);
        public static final ProcessType REGISTRATION = new ProcessType("REGISTRATION", 1);
        public static final ProcessType LOGIN = new ProcessType("LOGIN", 2);
        public static final ProcessType MIGRATION = new ProcessType("MIGRATION", 3);
        public static final ProcessType EMAIL = new ProcessType("EMAIL", 4);
        public static final ProcessType PROFILE = new ProcessType("PROFILE", 5);
        public static final ProcessType LOGIN_SBER = new ProcessType("LOGIN_SBER", 6);
        public static final ProcessType LOGIN_VK = new ProcessType("LOGIN_VK", 7);
        public static final ProcessType LOGIN_ESIA = new ProcessType("LOGIN_ESIA", 8);
        public static final ProcessType QR_AUTH = new ProcessType("QR_AUTH", 9);

        private static final /* synthetic */ ProcessType[] $values() {
            return new ProcessType[]{ENROLLMENT, REGISTRATION, LOGIN, MIGRATION, EMAIL, PROFILE, LOGIN_SBER, LOGIN_VK, LOGIN_ESIA, QR_AUTH};
        }

        static {
            ProcessType[] processTypeArr$values = $values();
            $VALUES = processTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(processTypeArr$values);
        }

        private ProcessType(String str, int i) {
        }

        public static EnumEntries<ProcessType> getEntries() {
            return $ENTRIES;
        }

        public static ProcessType valueOf(String str) {
            return (ProcessType) Enum.valueOf(ProcessType.class, str);
        }

        public static ProcessType[] values() {
            return (ProcessType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/Config$ProductType;", "", "(Ljava/lang/String;I)V", "DEFAULT", "WEBBANKIR", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ProductType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProductType[] $VALUES;
        public static final ProductType DEFAULT = new ProductType("DEFAULT", 0);
        public static final ProductType WEBBANKIR = new ProductType("WEBBANKIR", 1);

        private static final /* synthetic */ ProductType[] $values() {
            return new ProductType[]{DEFAULT, WEBBANKIR};
        }

        static {
            ProductType[] productTypeArr$values = $values();
            $VALUES = productTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(productTypeArr$values);
        }

        private ProductType(String str, int i) {
        }

        public static EnumEntries<ProductType> getEntries() {
            return $ENTRIES;
        }

        public static ProductType valueOf(String str) {
            return (ProductType) Enum.valueOf(ProductType.class, str);
        }

        public static ProductType[] values() {
            return (ProductType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Config(Origin origin, String authCenterClientId, String str, String str2, String str3, String str4, ProcessType processType, ProductType productType, PhoneIdentifier phoneIdentifier, Style style, String apiHost, boolean z, String supportEmail, String supportHelpUrl, String supportPhone, boolean z2, String str5, Integer num, String str6, String str7, String str8, RemoteConfig remoteConfig, PrefilledData prefilledData, boolean z3, OauthParams oauthParams, QrAuthConfig qrAuthConfig, boolean z4, boolean z5, List<? extends OauthServiceProvider> list, String str9, EmailFillingReason emailFillingReason, boolean z6) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
        Intrinsics.checkNotNullParameter(processType, "processType");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        Intrinsics.checkNotNullParameter(supportEmail, "supportEmail");
        Intrinsics.checkNotNullParameter(supportHelpUrl, "supportHelpUrl");
        Intrinsics.checkNotNullParameter(supportPhone, "supportPhone");
        this.origin = origin;
        this.authCenterClientId = authCenterClientId;
        this.authCenterClientSecret = str;
        this.yandexClientId = str2;
        this.accessToken = str3;
        this.yandexPassportToken = str4;
        this.processType = processType;
        this.productType = productType;
        this.phoneIdentifier = phoneIdentifier;
        this.style = style;
        this.apiHost = apiHost;
        this.isDebugMode = z;
        this.supportEmail = supportEmail;
        this.supportHelpUrl = supportHelpUrl;
        this.supportPhone = supportPhone;
        this.migrationBannerVisible = z2;
        this.migrationBannerText = str5;
        this.migrationBannerTextColor = num;
        this.migrationBannerButtonText = str6;
        this.migrationBannerImageUrl = str7;
        this.applicationUserAgent = str8;
        this.remoteConfig = remoteConfig;
        this.prefilledData = prefilledData;
        this.enableAutoEnrollment = z3;
        this.oauthParams = oauthParams;
        this.qrAuthConfig = qrAuthConfig;
        this.identificationAccessible = z4;
        this.confirmationHelpActionVisible = z5;
        this.availableSocialAccounts = list;
        this.loginContextId = str9;
        this.emailFillingReason = emailFillingReason;
        this.showServices = z6;
    }

    /* renamed from: component1, reason: from getter */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* renamed from: component10, reason: from getter */
    public final Style getStyle() {
        return this.style;
    }

    /* renamed from: component11, reason: from getter */
    public final String getApiHost() {
        return this.apiHost;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsDebugMode() {
        return this.isDebugMode;
    }

    /* renamed from: component13, reason: from getter */
    public final String getSupportEmail() {
        return this.supportEmail;
    }

    /* renamed from: component14, reason: from getter */
    public final String getSupportHelpUrl() {
        return this.supportHelpUrl;
    }

    /* renamed from: component15, reason: from getter */
    public final String getSupportPhone() {
        return this.supportPhone;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getMigrationBannerVisible() {
        return this.migrationBannerVisible;
    }

    /* renamed from: component17, reason: from getter */
    public final String getMigrationBannerText() {
        return this.migrationBannerText;
    }

    /* renamed from: component18, reason: from getter */
    public final Integer getMigrationBannerTextColor() {
        return this.migrationBannerTextColor;
    }

    /* renamed from: component19, reason: from getter */
    public final String getMigrationBannerButtonText() {
        return this.migrationBannerButtonText;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthCenterClientId() {
        return this.authCenterClientId;
    }

    /* renamed from: component20, reason: from getter */
    public final String getMigrationBannerImageUrl() {
        return this.migrationBannerImageUrl;
    }

    /* renamed from: component21, reason: from getter */
    public final String getApplicationUserAgent() {
        return this.applicationUserAgent;
    }

    /* renamed from: component22, reason: from getter */
    public final RemoteConfig getRemoteConfig() {
        return this.remoteConfig;
    }

    /* renamed from: component23, reason: from getter */
    public final PrefilledData getPrefilledData() {
        return this.prefilledData;
    }

    /* renamed from: component24, reason: from getter */
    public final boolean getEnableAutoEnrollment() {
        return this.enableAutoEnrollment;
    }

    /* renamed from: component25, reason: from getter */
    public final OauthParams getOauthParams() {
        return this.oauthParams;
    }

    /* renamed from: component26, reason: from getter */
    public final QrAuthConfig getQrAuthConfig() {
        return this.qrAuthConfig;
    }

    /* renamed from: component27, reason: from getter */
    public final boolean getIdentificationAccessible() {
        return this.identificationAccessible;
    }

    /* renamed from: component28, reason: from getter */
    public final boolean getConfirmationHelpActionVisible() {
        return this.confirmationHelpActionVisible;
    }

    public final List<OauthServiceProvider> component29() {
        return this.availableSocialAccounts;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthCenterClientSecret() {
        return this.authCenterClientSecret;
    }

    /* renamed from: component30, reason: from getter */
    public final String getLoginContextId() {
        return this.loginContextId;
    }

    /* renamed from: component31, reason: from getter */
    public final EmailFillingReason getEmailFillingReason() {
        return this.emailFillingReason;
    }

    /* renamed from: component32, reason: from getter */
    public final boolean getShowServices() {
        return this.showServices;
    }

    /* renamed from: component4, reason: from getter */
    public final String getYandexClientId() {
        return this.yandexClientId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component6, reason: from getter */
    public final String getYandexPassportToken() {
        return this.yandexPassportToken;
    }

    /* renamed from: component7, reason: from getter */
    public final ProcessType getProcessType() {
        return this.processType;
    }

    /* renamed from: component8, reason: from getter */
    public final ProductType getProductType() {
        return this.productType;
    }

    /* renamed from: component9, reason: from getter */
    public final PhoneIdentifier getPhoneIdentifier() {
        return this.phoneIdentifier;
    }

    public final Config copy(Origin origin, String authCenterClientId, String authCenterClientSecret, String yandexClientId, String accessToken, String yandexPassportToken, ProcessType processType, ProductType productType, PhoneIdentifier phoneIdentifier, Style style, String apiHost, boolean isDebugMode, String supportEmail, String supportHelpUrl, String supportPhone, boolean migrationBannerVisible, String migrationBannerText, Integer migrationBannerTextColor, String migrationBannerButtonText, String migrationBannerImageUrl, String applicationUserAgent, RemoteConfig remoteConfig, PrefilledData prefilledData, boolean enableAutoEnrollment, OauthParams oauthParams, QrAuthConfig qrAuthConfig, boolean identificationAccessible, boolean confirmationHelpActionVisible, List<? extends OauthServiceProvider> availableSocialAccounts, String loginContextId, EmailFillingReason emailFillingReason, boolean showServices) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
        Intrinsics.checkNotNullParameter(processType, "processType");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        Intrinsics.checkNotNullParameter(supportEmail, "supportEmail");
        Intrinsics.checkNotNullParameter(supportHelpUrl, "supportHelpUrl");
        Intrinsics.checkNotNullParameter(supportPhone, "supportPhone");
        return new Config(origin, authCenterClientId, authCenterClientSecret, yandexClientId, accessToken, yandexPassportToken, processType, productType, phoneIdentifier, style, apiHost, isDebugMode, supportEmail, supportHelpUrl, supportPhone, migrationBannerVisible, migrationBannerText, migrationBannerTextColor, migrationBannerButtonText, migrationBannerImageUrl, applicationUserAgent, remoteConfig, prefilledData, enableAutoEnrollment, oauthParams, qrAuthConfig, identificationAccessible, confirmationHelpActionVisible, availableSocialAccounts, loginContextId, emailFillingReason, showServices);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Config)) {
            return false;
        }
        Config config = (Config) other;
        return this.origin == config.origin && Intrinsics.areEqual(this.authCenterClientId, config.authCenterClientId) && Intrinsics.areEqual(this.authCenterClientSecret, config.authCenterClientSecret) && Intrinsics.areEqual(this.yandexClientId, config.yandexClientId) && Intrinsics.areEqual(this.accessToken, config.accessToken) && Intrinsics.areEqual(this.yandexPassportToken, config.yandexPassportToken) && this.processType == config.processType && this.productType == config.productType && Intrinsics.areEqual(this.phoneIdentifier, config.phoneIdentifier) && Intrinsics.areEqual(this.style, config.style) && Intrinsics.areEqual(this.apiHost, config.apiHost) && this.isDebugMode == config.isDebugMode && Intrinsics.areEqual(this.supportEmail, config.supportEmail) && Intrinsics.areEqual(this.supportHelpUrl, config.supportHelpUrl) && Intrinsics.areEqual(this.supportPhone, config.supportPhone) && this.migrationBannerVisible == config.migrationBannerVisible && Intrinsics.areEqual(this.migrationBannerText, config.migrationBannerText) && Intrinsics.areEqual(this.migrationBannerTextColor, config.migrationBannerTextColor) && Intrinsics.areEqual(this.migrationBannerButtonText, config.migrationBannerButtonText) && Intrinsics.areEqual(this.migrationBannerImageUrl, config.migrationBannerImageUrl) && Intrinsics.areEqual(this.applicationUserAgent, config.applicationUserAgent) && Intrinsics.areEqual(this.remoteConfig, config.remoteConfig) && Intrinsics.areEqual(this.prefilledData, config.prefilledData) && this.enableAutoEnrollment == config.enableAutoEnrollment && Intrinsics.areEqual(this.oauthParams, config.oauthParams) && Intrinsics.areEqual(this.qrAuthConfig, config.qrAuthConfig) && this.identificationAccessible == config.identificationAccessible && this.confirmationHelpActionVisible == config.confirmationHelpActionVisible && Intrinsics.areEqual(this.availableSocialAccounts, config.availableSocialAccounts) && Intrinsics.areEqual(this.loginContextId, config.loginContextId) && this.emailFillingReason == config.emailFillingReason && this.showServices == config.showServices;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getApiHost() {
        return this.apiHost;
    }

    public final String getApplicationUserAgent() {
        return this.applicationUserAgent;
    }

    public final String getAuthCenterClientId() {
        return this.authCenterClientId;
    }

    public final String getAuthCenterClientSecret() {
        return this.authCenterClientSecret;
    }

    public final List<OauthServiceProvider> getAvailableSocialAccounts() {
        return this.availableSocialAccounts;
    }

    public final boolean getConfirmationHelpActionVisible() {
        return this.confirmationHelpActionVisible;
    }

    public final EmailFillingReason getEmailFillingReason() {
        return this.emailFillingReason;
    }

    public final boolean getEnableAutoEnrollment() {
        return this.enableAutoEnrollment;
    }

    public final boolean getIdentificationAccessible() {
        return this.identificationAccessible;
    }

    public final String getLoginContextId() {
        return this.loginContextId;
    }

    public final String getMigrationBannerButtonText() {
        return this.migrationBannerButtonText;
    }

    public final String getMigrationBannerImageUrl() {
        return this.migrationBannerImageUrl;
    }

    public final String getMigrationBannerText() {
        return this.migrationBannerText;
    }

    public final Integer getMigrationBannerTextColor() {
        return this.migrationBannerTextColor;
    }

    public final boolean getMigrationBannerVisible() {
        return this.migrationBannerVisible;
    }

    public final OauthParams getOauthParams() {
        return this.oauthParams;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final PhoneIdentifier getPhoneIdentifier() {
        return this.phoneIdentifier;
    }

    public final PrefilledData getPrefilledData() {
        return this.prefilledData;
    }

    public final ProcessType getProcessType() {
        return this.processType;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public final QrAuthConfig getQrAuthConfig() {
        return this.qrAuthConfig;
    }

    public final RemoteConfig getRemoteConfig() {
        return this.remoteConfig;
    }

    public final boolean getShowServices() {
        return this.showServices;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final String getSupportEmail() {
        return this.supportEmail;
    }

    public final String getSupportHelpUrl() {
        return this.supportHelpUrl;
    }

    public final String getSupportPhone() {
        return this.supportPhone;
    }

    public final String getYandexClientId() {
        return this.yandexClientId;
    }

    public final String getYandexPassportToken() {
        return this.yandexPassportToken;
    }

    public int hashCode() {
        int iA = a.a(this.authCenterClientId, this.origin.hashCode() * 31, 31);
        String str = this.authCenterClientSecret;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.yandexClientId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accessToken;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.yandexPassportToken;
        int iHashCode4 = (this.productType.hashCode() + ((this.processType.hashCode() + ((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31)) * 31)) * 31;
        PhoneIdentifier phoneIdentifier = this.phoneIdentifier;
        int iHashCode5 = (iHashCode4 + (phoneIdentifier == null ? 0 : phoneIdentifier.hashCode())) * 31;
        Style style = this.style;
        int iA2 = b.a(this.migrationBannerVisible, a.a(this.supportPhone, a.a(this.supportHelpUrl, a.a(this.supportEmail, b.a(this.isDebugMode, a.a(this.apiHost, (iHashCode5 + (style == null ? 0 : style.hashCode())) * 31, 31), 31), 31), 31), 31), 31);
        String str5 = this.migrationBannerText;
        int iHashCode6 = (iA2 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.migrationBannerTextColor;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.migrationBannerButtonText;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.migrationBannerImageUrl;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.applicationUserAgent;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        RemoteConfig remoteConfig = this.remoteConfig;
        int iHashCode11 = (iHashCode10 + (remoteConfig == null ? 0 : remoteConfig.hashCode())) * 31;
        PrefilledData prefilledData = this.prefilledData;
        int iA3 = b.a(this.enableAutoEnrollment, (iHashCode11 + (prefilledData == null ? 0 : prefilledData.hashCode())) * 31, 31);
        OauthParams oauthParams = this.oauthParams;
        int iHashCode12 = (iA3 + (oauthParams == null ? 0 : oauthParams.hashCode())) * 31;
        QrAuthConfig qrAuthConfig = this.qrAuthConfig;
        int iA4 = b.a(this.confirmationHelpActionVisible, b.a(this.identificationAccessible, (iHashCode12 + (qrAuthConfig == null ? 0 : qrAuthConfig.hashCode())) * 31, 31), 31);
        List<OauthServiceProvider> list = this.availableSocialAccounts;
        int iHashCode13 = (iA4 + (list == null ? 0 : list.hashCode())) * 31;
        String str9 = this.loginContextId;
        int iHashCode14 = (iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        EmailFillingReason emailFillingReason = this.emailFillingReason;
        return Boolean.hashCode(this.showServices) + ((iHashCode14 + (emailFillingReason != null ? emailFillingReason.hashCode() : 0)) * 31);
    }

    public final boolean isDebugMode() {
        return this.isDebugMode;
    }

    public String toString() {
        return "Config(origin=" + this.origin + ", authCenterClientId=" + this.authCenterClientId + ", authCenterClientSecret=" + this.authCenterClientSecret + ", yandexClientId=" + this.yandexClientId + ", accessToken=" + this.accessToken + ", yandexPassportToken=" + this.yandexPassportToken + ", processType=" + this.processType + ", productType=" + this.productType + ", phoneIdentifier=" + this.phoneIdentifier + ", style=" + this.style + ", apiHost=" + this.apiHost + ", isDebugMode=" + this.isDebugMode + ", supportEmail=" + this.supportEmail + ", supportHelpUrl=" + this.supportHelpUrl + ", supportPhone=" + this.supportPhone + ", migrationBannerVisible=" + this.migrationBannerVisible + ", migrationBannerText=" + this.migrationBannerText + ", migrationBannerTextColor=" + this.migrationBannerTextColor + ", migrationBannerButtonText=" + this.migrationBannerButtonText + ", migrationBannerImageUrl=" + this.migrationBannerImageUrl + ", applicationUserAgent=" + this.applicationUserAgent + ", remoteConfig=" + this.remoteConfig + ", prefilledData=" + this.prefilledData + ", enableAutoEnrollment=" + this.enableAutoEnrollment + ", oauthParams=" + this.oauthParams + ", qrAuthConfig=" + this.qrAuthConfig + ", identificationAccessible=" + this.identificationAccessible + ", confirmationHelpActionVisible=" + this.confirmationHelpActionVisible + ", availableSocialAccounts=" + this.availableSocialAccounts + ", loginContextId=" + this.loginContextId + ", emailFillingReason=" + this.emailFillingReason + ", showServices=" + this.showServices + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.origin.name());
        parcel.writeString(this.authCenterClientId);
        parcel.writeString(this.authCenterClientSecret);
        parcel.writeString(this.yandexClientId);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.yandexPassportToken);
        parcel.writeString(this.processType.name());
        parcel.writeString(this.productType.name());
        PhoneIdentifier phoneIdentifier = this.phoneIdentifier;
        if (phoneIdentifier == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            phoneIdentifier.writeToParcel(parcel, flags);
        }
        Style style = this.style;
        if (style == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            style.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.apiHost);
        parcel.writeInt(this.isDebugMode ? 1 : 0);
        parcel.writeString(this.supportEmail);
        parcel.writeString(this.supportHelpUrl);
        parcel.writeString(this.supportPhone);
        parcel.writeInt(this.migrationBannerVisible ? 1 : 0);
        parcel.writeString(this.migrationBannerText);
        Integer num = this.migrationBannerTextColor;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.migrationBannerButtonText);
        parcel.writeString(this.migrationBannerImageUrl);
        parcel.writeString(this.applicationUserAgent);
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            remoteConfig.writeToParcel(parcel, flags);
        }
        PrefilledData prefilledData = this.prefilledData;
        if (prefilledData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            prefilledData.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.enableAutoEnrollment ? 1 : 0);
        OauthParams oauthParams = this.oauthParams;
        if (oauthParams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            oauthParams.writeToParcel(parcel, flags);
        }
        QrAuthConfig qrAuthConfig = this.qrAuthConfig;
        if (qrAuthConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            qrAuthConfig.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.identificationAccessible ? 1 : 0);
        parcel.writeInt(this.confirmationHelpActionVisible ? 1 : 0);
        List<OauthServiceProvider> list = this.availableSocialAccounts;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<OauthServiceProvider> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next().name());
            }
        }
        parcel.writeString(this.loginContextId);
        EmailFillingReason emailFillingReason = this.emailFillingReason;
        if (emailFillingReason == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(emailFillingReason.name());
        }
        parcel.writeInt(this.showServices ? 1 : 0);
    }

    public /* synthetic */ Config(Origin origin, String str, String str2, String str3, String str4, String str5, ProcessType processType, ProductType productType, PhoneIdentifier phoneIdentifier, Style style, String str6, boolean z, String str7, String str8, String str9, boolean z2, String str10, Integer num, String str11, String str12, String str13, RemoteConfig remoteConfig, PrefilledData prefilledData, boolean z3, OauthParams oauthParams, QrAuthConfig qrAuthConfig, boolean z4, boolean z5, List list, String str14, EmailFillingReason emailFillingReason, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(origin, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, processType, (i & 128) != 0 ? ProductType.DEFAULT : productType, (i & 256) != 0 ? null : phoneIdentifier, (i & 512) != 0 ? null : style, str6, (i & 2048) != 0 ? false : z, str7, str8, str9, (32768 & i) != 0 ? false : z2, (65536 & i) != 0 ? null : str10, (131072 & i) != 0 ? null : num, (262144 & i) != 0 ? null : str11, (524288 & i) != 0 ? null : str12, (1048576 & i) != 0 ? null : str13, (2097152 & i) != 0 ? null : remoteConfig, (4194304 & i) != 0 ? null : prefilledData, (8388608 & i) != 0 ? false : z3, (16777216 & i) != 0 ? null : oauthParams, (33554432 & i) != 0 ? null : qrAuthConfig, (67108864 & i) != 0 ? false : z4, (134217728 & i) != 0 ? true : z5, (268435456 & i) != 0 ? null : list, (536870912 & i) != 0 ? null : str14, (1073741824 & i) != 0 ? null : emailFillingReason, (i & Integer.MIN_VALUE) != 0 ? true : z6);
    }
}
