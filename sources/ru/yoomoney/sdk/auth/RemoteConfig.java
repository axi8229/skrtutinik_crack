package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\bo\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B©\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010(J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J±\u0003\u0010s\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010t\u001a\u00020uHÖ\u0001J\u0013\u0010v\u001a\u00020\u00032\b\u0010w\u001a\u0004\u0018\u00010xHÖ\u0003J\t\u0010y\u001a\u00020uHÖ\u0001J\t\u0010z\u001a\u00020\u0005HÖ\u0001J\u0019\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020uHÖ\u0001R\u0013\u0010'\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010&\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0013\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010*R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010*R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010*R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010*R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010*R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0013\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010*R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010*R\u0013\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bF\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00100R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010*R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010*R\u0013\u0010!\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*R\u0013\u0010 \u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010*R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010*R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u0010*¨\u0006\u0080\u0001"}, d2 = {"Lru/yoomoney/sdk/auth/RemoteConfig;", "Landroid/os/Parcelable;", "restorePasswordEnabled", "", "userAgreementTitle", "", "userWithEmailAgreementTitle", "emailCheckboxVisible", "emailCheckboxTitle", "addEmailTitle", "migrationScreenTitle", "migrationScreenSubtitle", "migrationScreenButtonSubtitle", "hardMigrationScreenTitle", "hardMigrationScreenSubtitle", "hardMigrationScreenButtonSubtitle", "oauthNotFoundTitle", "oauthNotFoundText", "oauthNotFoundEnrollmentTitle", "oauthNotFoundLoginTitle", "openSberIdDialogText", "sberIdBoundSuccessText", "sberIdUnboundDialogText", "emailConfirmScreenTitle", "emailConfirmScreenDescription", "emailConfirmLabel", "emailConfirmOffersTitle", "emailConfirmScreenOtherEmailTitle", "emailEnterScreenTitle", "emailEnterScreenSubtitle", "emailEnterActionText", "selectAccountEnrollmentScreenTitle", "selectAccountEnrollmentScreenSubtitle", "selectAccountEnrollmentScreenAgreementTitle", "passwordEnterScreenTitle", "passwordEnterScreenForceLoginWarning", "passwordEnterScreenWarning", "acceptTermsScreenTitle", "acceptTermsScreenDescription", "acceptTermsScreenActionText", "(ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAcceptTermsScreenActionText", "()Ljava/lang/String;", "getAcceptTermsScreenDescription", "getAcceptTermsScreenTitle", "getAddEmailTitle", "getEmailCheckboxTitle", "getEmailCheckboxVisible", "()Z", "getEmailConfirmLabel", "getEmailConfirmOffersTitle", "getEmailConfirmScreenDescription", "getEmailConfirmScreenOtherEmailTitle", "getEmailConfirmScreenTitle", "getEmailEnterActionText", "getEmailEnterScreenSubtitle", "getEmailEnterScreenTitle", "getHardMigrationScreenButtonSubtitle", "getHardMigrationScreenSubtitle", "getHardMigrationScreenTitle", "getMigrationScreenButtonSubtitle", "getMigrationScreenSubtitle", "getMigrationScreenTitle", "getOauthNotFoundEnrollmentTitle", "getOauthNotFoundLoginTitle", "getOauthNotFoundText", "getOauthNotFoundTitle", "getOpenSberIdDialogText", "getPasswordEnterScreenForceLoginWarning", "getPasswordEnterScreenTitle", "getPasswordEnterScreenWarning", "getRestorePasswordEnabled", "getSberIdBoundSuccessText", "getSberIdUnboundDialogText", "getSelectAccountEnrollmentScreenAgreementTitle", "getSelectAccountEnrollmentScreenSubtitle", "getSelectAccountEnrollmentScreenTitle", "getUserAgreementTitle", "getUserWithEmailAgreementTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RemoteConfig implements Parcelable {
    public static final Parcelable.Creator<RemoteConfig> CREATOR = new Creator();
    private final String acceptTermsScreenActionText;
    private final String acceptTermsScreenDescription;
    private final String acceptTermsScreenTitle;
    private final String addEmailTitle;
    private final String emailCheckboxTitle;
    private final boolean emailCheckboxVisible;
    private final String emailConfirmLabel;
    private final String emailConfirmOffersTitle;
    private final String emailConfirmScreenDescription;
    private final String emailConfirmScreenOtherEmailTitle;
    private final String emailConfirmScreenTitle;
    private final String emailEnterActionText;
    private final String emailEnterScreenSubtitle;
    private final String emailEnterScreenTitle;
    private final String hardMigrationScreenButtonSubtitle;
    private final String hardMigrationScreenSubtitle;
    private final String hardMigrationScreenTitle;
    private final String migrationScreenButtonSubtitle;
    private final String migrationScreenSubtitle;
    private final String migrationScreenTitle;
    private final String oauthNotFoundEnrollmentTitle;
    private final String oauthNotFoundLoginTitle;
    private final String oauthNotFoundText;
    private final String oauthNotFoundTitle;
    private final String openSberIdDialogText;
    private final String passwordEnterScreenForceLoginWarning;
    private final String passwordEnterScreenTitle;
    private final String passwordEnterScreenWarning;
    private final boolean restorePasswordEnabled;
    private final String sberIdBoundSuccessText;
    private final String sberIdUnboundDialogText;
    private final String selectAccountEnrollmentScreenAgreementTitle;
    private final String selectAccountEnrollmentScreenSubtitle;
    private final String selectAccountEnrollmentScreenTitle;
    private final String userAgreementTitle;
    private final String userWithEmailAgreementTitle;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RemoteConfig> {
        @Override // android.os.Parcelable.Creator
        public final RemoteConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RemoteConfig(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final RemoteConfig[] newArray(int i) {
            return new RemoteConfig[i];
        }
    }

    public RemoteConfig(boolean z, String userAgreementTitle, String userWithEmailAgreementTitle, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32) {
        Intrinsics.checkNotNullParameter(userAgreementTitle, "userAgreementTitle");
        Intrinsics.checkNotNullParameter(userWithEmailAgreementTitle, "userWithEmailAgreementTitle");
        this.restorePasswordEnabled = z;
        this.userAgreementTitle = userAgreementTitle;
        this.userWithEmailAgreementTitle = userWithEmailAgreementTitle;
        this.emailCheckboxVisible = z2;
        this.emailCheckboxTitle = str;
        this.addEmailTitle = str2;
        this.migrationScreenTitle = str3;
        this.migrationScreenSubtitle = str4;
        this.migrationScreenButtonSubtitle = str5;
        this.hardMigrationScreenTitle = str6;
        this.hardMigrationScreenSubtitle = str7;
        this.hardMigrationScreenButtonSubtitle = str8;
        this.oauthNotFoundTitle = str9;
        this.oauthNotFoundText = str10;
        this.oauthNotFoundEnrollmentTitle = str11;
        this.oauthNotFoundLoginTitle = str12;
        this.openSberIdDialogText = str13;
        this.sberIdBoundSuccessText = str14;
        this.sberIdUnboundDialogText = str15;
        this.emailConfirmScreenTitle = str16;
        this.emailConfirmScreenDescription = str17;
        this.emailConfirmLabel = str18;
        this.emailConfirmOffersTitle = str19;
        this.emailConfirmScreenOtherEmailTitle = str20;
        this.emailEnterScreenTitle = str21;
        this.emailEnterScreenSubtitle = str22;
        this.emailEnterActionText = str23;
        this.selectAccountEnrollmentScreenTitle = str24;
        this.selectAccountEnrollmentScreenSubtitle = str25;
        this.selectAccountEnrollmentScreenAgreementTitle = str26;
        this.passwordEnterScreenTitle = str27;
        this.passwordEnterScreenForceLoginWarning = str28;
        this.passwordEnterScreenWarning = str29;
        this.acceptTermsScreenTitle = str30;
        this.acceptTermsScreenDescription = str31;
        this.acceptTermsScreenActionText = str32;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getRestorePasswordEnabled() {
        return this.restorePasswordEnabled;
    }

    /* renamed from: component10, reason: from getter */
    public final String getHardMigrationScreenTitle() {
        return this.hardMigrationScreenTitle;
    }

    /* renamed from: component11, reason: from getter */
    public final String getHardMigrationScreenSubtitle() {
        return this.hardMigrationScreenSubtitle;
    }

    /* renamed from: component12, reason: from getter */
    public final String getHardMigrationScreenButtonSubtitle() {
        return this.hardMigrationScreenButtonSubtitle;
    }

    /* renamed from: component13, reason: from getter */
    public final String getOauthNotFoundTitle() {
        return this.oauthNotFoundTitle;
    }

    /* renamed from: component14, reason: from getter */
    public final String getOauthNotFoundText() {
        return this.oauthNotFoundText;
    }

    /* renamed from: component15, reason: from getter */
    public final String getOauthNotFoundEnrollmentTitle() {
        return this.oauthNotFoundEnrollmentTitle;
    }

    /* renamed from: component16, reason: from getter */
    public final String getOauthNotFoundLoginTitle() {
        return this.oauthNotFoundLoginTitle;
    }

    /* renamed from: component17, reason: from getter */
    public final String getOpenSberIdDialogText() {
        return this.openSberIdDialogText;
    }

    /* renamed from: component18, reason: from getter */
    public final String getSberIdBoundSuccessText() {
        return this.sberIdBoundSuccessText;
    }

    /* renamed from: component19, reason: from getter */
    public final String getSberIdUnboundDialogText() {
        return this.sberIdUnboundDialogText;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserAgreementTitle() {
        return this.userAgreementTitle;
    }

    /* renamed from: component20, reason: from getter */
    public final String getEmailConfirmScreenTitle() {
        return this.emailConfirmScreenTitle;
    }

    /* renamed from: component21, reason: from getter */
    public final String getEmailConfirmScreenDescription() {
        return this.emailConfirmScreenDescription;
    }

    /* renamed from: component22, reason: from getter */
    public final String getEmailConfirmLabel() {
        return this.emailConfirmLabel;
    }

    /* renamed from: component23, reason: from getter */
    public final String getEmailConfirmOffersTitle() {
        return this.emailConfirmOffersTitle;
    }

    /* renamed from: component24, reason: from getter */
    public final String getEmailConfirmScreenOtherEmailTitle() {
        return this.emailConfirmScreenOtherEmailTitle;
    }

    /* renamed from: component25, reason: from getter */
    public final String getEmailEnterScreenTitle() {
        return this.emailEnterScreenTitle;
    }

    /* renamed from: component26, reason: from getter */
    public final String getEmailEnterScreenSubtitle() {
        return this.emailEnterScreenSubtitle;
    }

    /* renamed from: component27, reason: from getter */
    public final String getEmailEnterActionText() {
        return this.emailEnterActionText;
    }

    /* renamed from: component28, reason: from getter */
    public final String getSelectAccountEnrollmentScreenTitle() {
        return this.selectAccountEnrollmentScreenTitle;
    }

    /* renamed from: component29, reason: from getter */
    public final String getSelectAccountEnrollmentScreenSubtitle() {
        return this.selectAccountEnrollmentScreenSubtitle;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserWithEmailAgreementTitle() {
        return this.userWithEmailAgreementTitle;
    }

    /* renamed from: component30, reason: from getter */
    public final String getSelectAccountEnrollmentScreenAgreementTitle() {
        return this.selectAccountEnrollmentScreenAgreementTitle;
    }

    /* renamed from: component31, reason: from getter */
    public final String getPasswordEnterScreenTitle() {
        return this.passwordEnterScreenTitle;
    }

    /* renamed from: component32, reason: from getter */
    public final String getPasswordEnterScreenForceLoginWarning() {
        return this.passwordEnterScreenForceLoginWarning;
    }

    /* renamed from: component33, reason: from getter */
    public final String getPasswordEnterScreenWarning() {
        return this.passwordEnterScreenWarning;
    }

    /* renamed from: component34, reason: from getter */
    public final String getAcceptTermsScreenTitle() {
        return this.acceptTermsScreenTitle;
    }

    /* renamed from: component35, reason: from getter */
    public final String getAcceptTermsScreenDescription() {
        return this.acceptTermsScreenDescription;
    }

    /* renamed from: component36, reason: from getter */
    public final String getAcceptTermsScreenActionText() {
        return this.acceptTermsScreenActionText;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getEmailCheckboxVisible() {
        return this.emailCheckboxVisible;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEmailCheckboxTitle() {
        return this.emailCheckboxTitle;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAddEmailTitle() {
        return this.addEmailTitle;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMigrationScreenTitle() {
        return this.migrationScreenTitle;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMigrationScreenSubtitle() {
        return this.migrationScreenSubtitle;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMigrationScreenButtonSubtitle() {
        return this.migrationScreenButtonSubtitle;
    }

    public final RemoteConfig copy(boolean restorePasswordEnabled, String userAgreementTitle, String userWithEmailAgreementTitle, boolean emailCheckboxVisible, String emailCheckboxTitle, String addEmailTitle, String migrationScreenTitle, String migrationScreenSubtitle, String migrationScreenButtonSubtitle, String hardMigrationScreenTitle, String hardMigrationScreenSubtitle, String hardMigrationScreenButtonSubtitle, String oauthNotFoundTitle, String oauthNotFoundText, String oauthNotFoundEnrollmentTitle, String oauthNotFoundLoginTitle, String openSberIdDialogText, String sberIdBoundSuccessText, String sberIdUnboundDialogText, String emailConfirmScreenTitle, String emailConfirmScreenDescription, String emailConfirmLabel, String emailConfirmOffersTitle, String emailConfirmScreenOtherEmailTitle, String emailEnterScreenTitle, String emailEnterScreenSubtitle, String emailEnterActionText, String selectAccountEnrollmentScreenTitle, String selectAccountEnrollmentScreenSubtitle, String selectAccountEnrollmentScreenAgreementTitle, String passwordEnterScreenTitle, String passwordEnterScreenForceLoginWarning, String passwordEnterScreenWarning, String acceptTermsScreenTitle, String acceptTermsScreenDescription, String acceptTermsScreenActionText) {
        Intrinsics.checkNotNullParameter(userAgreementTitle, "userAgreementTitle");
        Intrinsics.checkNotNullParameter(userWithEmailAgreementTitle, "userWithEmailAgreementTitle");
        return new RemoteConfig(restorePasswordEnabled, userAgreementTitle, userWithEmailAgreementTitle, emailCheckboxVisible, emailCheckboxTitle, addEmailTitle, migrationScreenTitle, migrationScreenSubtitle, migrationScreenButtonSubtitle, hardMigrationScreenTitle, hardMigrationScreenSubtitle, hardMigrationScreenButtonSubtitle, oauthNotFoundTitle, oauthNotFoundText, oauthNotFoundEnrollmentTitle, oauthNotFoundLoginTitle, openSberIdDialogText, sberIdBoundSuccessText, sberIdUnboundDialogText, emailConfirmScreenTitle, emailConfirmScreenDescription, emailConfirmLabel, emailConfirmOffersTitle, emailConfirmScreenOtherEmailTitle, emailEnterScreenTitle, emailEnterScreenSubtitle, emailEnterActionText, selectAccountEnrollmentScreenTitle, selectAccountEnrollmentScreenSubtitle, selectAccountEnrollmentScreenAgreementTitle, passwordEnterScreenTitle, passwordEnterScreenForceLoginWarning, passwordEnterScreenWarning, acceptTermsScreenTitle, acceptTermsScreenDescription, acceptTermsScreenActionText);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteConfig)) {
            return false;
        }
        RemoteConfig remoteConfig = (RemoteConfig) other;
        return this.restorePasswordEnabled == remoteConfig.restorePasswordEnabled && Intrinsics.areEqual(this.userAgreementTitle, remoteConfig.userAgreementTitle) && Intrinsics.areEqual(this.userWithEmailAgreementTitle, remoteConfig.userWithEmailAgreementTitle) && this.emailCheckboxVisible == remoteConfig.emailCheckboxVisible && Intrinsics.areEqual(this.emailCheckboxTitle, remoteConfig.emailCheckboxTitle) && Intrinsics.areEqual(this.addEmailTitle, remoteConfig.addEmailTitle) && Intrinsics.areEqual(this.migrationScreenTitle, remoteConfig.migrationScreenTitle) && Intrinsics.areEqual(this.migrationScreenSubtitle, remoteConfig.migrationScreenSubtitle) && Intrinsics.areEqual(this.migrationScreenButtonSubtitle, remoteConfig.migrationScreenButtonSubtitle) && Intrinsics.areEqual(this.hardMigrationScreenTitle, remoteConfig.hardMigrationScreenTitle) && Intrinsics.areEqual(this.hardMigrationScreenSubtitle, remoteConfig.hardMigrationScreenSubtitle) && Intrinsics.areEqual(this.hardMigrationScreenButtonSubtitle, remoteConfig.hardMigrationScreenButtonSubtitle) && Intrinsics.areEqual(this.oauthNotFoundTitle, remoteConfig.oauthNotFoundTitle) && Intrinsics.areEqual(this.oauthNotFoundText, remoteConfig.oauthNotFoundText) && Intrinsics.areEqual(this.oauthNotFoundEnrollmentTitle, remoteConfig.oauthNotFoundEnrollmentTitle) && Intrinsics.areEqual(this.oauthNotFoundLoginTitle, remoteConfig.oauthNotFoundLoginTitle) && Intrinsics.areEqual(this.openSberIdDialogText, remoteConfig.openSberIdDialogText) && Intrinsics.areEqual(this.sberIdBoundSuccessText, remoteConfig.sberIdBoundSuccessText) && Intrinsics.areEqual(this.sberIdUnboundDialogText, remoteConfig.sberIdUnboundDialogText) && Intrinsics.areEqual(this.emailConfirmScreenTitle, remoteConfig.emailConfirmScreenTitle) && Intrinsics.areEqual(this.emailConfirmScreenDescription, remoteConfig.emailConfirmScreenDescription) && Intrinsics.areEqual(this.emailConfirmLabel, remoteConfig.emailConfirmLabel) && Intrinsics.areEqual(this.emailConfirmOffersTitle, remoteConfig.emailConfirmOffersTitle) && Intrinsics.areEqual(this.emailConfirmScreenOtherEmailTitle, remoteConfig.emailConfirmScreenOtherEmailTitle) && Intrinsics.areEqual(this.emailEnterScreenTitle, remoteConfig.emailEnterScreenTitle) && Intrinsics.areEqual(this.emailEnterScreenSubtitle, remoteConfig.emailEnterScreenSubtitle) && Intrinsics.areEqual(this.emailEnterActionText, remoteConfig.emailEnterActionText) && Intrinsics.areEqual(this.selectAccountEnrollmentScreenTitle, remoteConfig.selectAccountEnrollmentScreenTitle) && Intrinsics.areEqual(this.selectAccountEnrollmentScreenSubtitle, remoteConfig.selectAccountEnrollmentScreenSubtitle) && Intrinsics.areEqual(this.selectAccountEnrollmentScreenAgreementTitle, remoteConfig.selectAccountEnrollmentScreenAgreementTitle) && Intrinsics.areEqual(this.passwordEnterScreenTitle, remoteConfig.passwordEnterScreenTitle) && Intrinsics.areEqual(this.passwordEnterScreenForceLoginWarning, remoteConfig.passwordEnterScreenForceLoginWarning) && Intrinsics.areEqual(this.passwordEnterScreenWarning, remoteConfig.passwordEnterScreenWarning) && Intrinsics.areEqual(this.acceptTermsScreenTitle, remoteConfig.acceptTermsScreenTitle) && Intrinsics.areEqual(this.acceptTermsScreenDescription, remoteConfig.acceptTermsScreenDescription) && Intrinsics.areEqual(this.acceptTermsScreenActionText, remoteConfig.acceptTermsScreenActionText);
    }

    public final String getAcceptTermsScreenActionText() {
        return this.acceptTermsScreenActionText;
    }

    public final String getAcceptTermsScreenDescription() {
        return this.acceptTermsScreenDescription;
    }

    public final String getAcceptTermsScreenTitle() {
        return this.acceptTermsScreenTitle;
    }

    public final String getAddEmailTitle() {
        return this.addEmailTitle;
    }

    public final String getEmailCheckboxTitle() {
        return this.emailCheckboxTitle;
    }

    public final boolean getEmailCheckboxVisible() {
        return this.emailCheckboxVisible;
    }

    public final String getEmailConfirmLabel() {
        return this.emailConfirmLabel;
    }

    public final String getEmailConfirmOffersTitle() {
        return this.emailConfirmOffersTitle;
    }

    public final String getEmailConfirmScreenDescription() {
        return this.emailConfirmScreenDescription;
    }

    public final String getEmailConfirmScreenOtherEmailTitle() {
        return this.emailConfirmScreenOtherEmailTitle;
    }

    public final String getEmailConfirmScreenTitle() {
        return this.emailConfirmScreenTitle;
    }

    public final String getEmailEnterActionText() {
        return this.emailEnterActionText;
    }

    public final String getEmailEnterScreenSubtitle() {
        return this.emailEnterScreenSubtitle;
    }

    public final String getEmailEnterScreenTitle() {
        return this.emailEnterScreenTitle;
    }

    public final String getHardMigrationScreenButtonSubtitle() {
        return this.hardMigrationScreenButtonSubtitle;
    }

    public final String getHardMigrationScreenSubtitle() {
        return this.hardMigrationScreenSubtitle;
    }

    public final String getHardMigrationScreenTitle() {
        return this.hardMigrationScreenTitle;
    }

    public final String getMigrationScreenButtonSubtitle() {
        return this.migrationScreenButtonSubtitle;
    }

    public final String getMigrationScreenSubtitle() {
        return this.migrationScreenSubtitle;
    }

    public final String getMigrationScreenTitle() {
        return this.migrationScreenTitle;
    }

    public final String getOauthNotFoundEnrollmentTitle() {
        return this.oauthNotFoundEnrollmentTitle;
    }

    public final String getOauthNotFoundLoginTitle() {
        return this.oauthNotFoundLoginTitle;
    }

    public final String getOauthNotFoundText() {
        return this.oauthNotFoundText;
    }

    public final String getOauthNotFoundTitle() {
        return this.oauthNotFoundTitle;
    }

    public final String getOpenSberIdDialogText() {
        return this.openSberIdDialogText;
    }

    public final String getPasswordEnterScreenForceLoginWarning() {
        return this.passwordEnterScreenForceLoginWarning;
    }

    public final String getPasswordEnterScreenTitle() {
        return this.passwordEnterScreenTitle;
    }

    public final String getPasswordEnterScreenWarning() {
        return this.passwordEnterScreenWarning;
    }

    public final boolean getRestorePasswordEnabled() {
        return this.restorePasswordEnabled;
    }

    public final String getSberIdBoundSuccessText() {
        return this.sberIdBoundSuccessText;
    }

    public final String getSberIdUnboundDialogText() {
        return this.sberIdUnboundDialogText;
    }

    public final String getSelectAccountEnrollmentScreenAgreementTitle() {
        return this.selectAccountEnrollmentScreenAgreementTitle;
    }

    public final String getSelectAccountEnrollmentScreenSubtitle() {
        return this.selectAccountEnrollmentScreenSubtitle;
    }

    public final String getSelectAccountEnrollmentScreenTitle() {
        return this.selectAccountEnrollmentScreenTitle;
    }

    public final String getUserAgreementTitle() {
        return this.userAgreementTitle;
    }

    public final String getUserWithEmailAgreementTitle() {
        return this.userWithEmailAgreementTitle;
    }

    public int hashCode() {
        int iA = b.a(this.emailCheckboxVisible, a.a(this.userWithEmailAgreementTitle, a.a(this.userAgreementTitle, Boolean.hashCode(this.restorePasswordEnabled) * 31, 31), 31), 31);
        String str = this.emailCheckboxTitle;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.addEmailTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.migrationScreenTitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.migrationScreenSubtitle;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.migrationScreenButtonSubtitle;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.hardMigrationScreenTitle;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.hardMigrationScreenSubtitle;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.hardMigrationScreenButtonSubtitle;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.oauthNotFoundTitle;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.oauthNotFoundText;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.oauthNotFoundEnrollmentTitle;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.oauthNotFoundLoginTitle;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.openSberIdDialogText;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.sberIdBoundSuccessText;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.sberIdUnboundDialogText;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.emailConfirmScreenTitle;
        int iHashCode16 = (iHashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.emailConfirmScreenDescription;
        int iHashCode17 = (iHashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.emailConfirmLabel;
        int iHashCode18 = (iHashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.emailConfirmOffersTitle;
        int iHashCode19 = (iHashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.emailConfirmScreenOtherEmailTitle;
        int iHashCode20 = (iHashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.emailEnterScreenTitle;
        int iHashCode21 = (iHashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.emailEnterScreenSubtitle;
        int iHashCode22 = (iHashCode21 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.emailEnterActionText;
        int iHashCode23 = (iHashCode22 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.selectAccountEnrollmentScreenTitle;
        int iHashCode24 = (iHashCode23 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.selectAccountEnrollmentScreenSubtitle;
        int iHashCode25 = (iHashCode24 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.selectAccountEnrollmentScreenAgreementTitle;
        int iHashCode26 = (iHashCode25 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.passwordEnterScreenTitle;
        int iHashCode27 = (iHashCode26 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.passwordEnterScreenForceLoginWarning;
        int iHashCode28 = (iHashCode27 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.passwordEnterScreenWarning;
        int iHashCode29 = (iHashCode28 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.acceptTermsScreenTitle;
        int iHashCode30 = (iHashCode29 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.acceptTermsScreenDescription;
        int iHashCode31 = (iHashCode30 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.acceptTermsScreenActionText;
        return iHashCode31 + (str32 != null ? str32.hashCode() : 0);
    }

    public String toString() {
        return "RemoteConfig(restorePasswordEnabled=" + this.restorePasswordEnabled + ", userAgreementTitle=" + this.userAgreementTitle + ", userWithEmailAgreementTitle=" + this.userWithEmailAgreementTitle + ", emailCheckboxVisible=" + this.emailCheckboxVisible + ", emailCheckboxTitle=" + this.emailCheckboxTitle + ", addEmailTitle=" + this.addEmailTitle + ", migrationScreenTitle=" + this.migrationScreenTitle + ", migrationScreenSubtitle=" + this.migrationScreenSubtitle + ", migrationScreenButtonSubtitle=" + this.migrationScreenButtonSubtitle + ", hardMigrationScreenTitle=" + this.hardMigrationScreenTitle + ", hardMigrationScreenSubtitle=" + this.hardMigrationScreenSubtitle + ", hardMigrationScreenButtonSubtitle=" + this.hardMigrationScreenButtonSubtitle + ", oauthNotFoundTitle=" + this.oauthNotFoundTitle + ", oauthNotFoundText=" + this.oauthNotFoundText + ", oauthNotFoundEnrollmentTitle=" + this.oauthNotFoundEnrollmentTitle + ", oauthNotFoundLoginTitle=" + this.oauthNotFoundLoginTitle + ", openSberIdDialogText=" + this.openSberIdDialogText + ", sberIdBoundSuccessText=" + this.sberIdBoundSuccessText + ", sberIdUnboundDialogText=" + this.sberIdUnboundDialogText + ", emailConfirmScreenTitle=" + this.emailConfirmScreenTitle + ", emailConfirmScreenDescription=" + this.emailConfirmScreenDescription + ", emailConfirmLabel=" + this.emailConfirmLabel + ", emailConfirmOffersTitle=" + this.emailConfirmOffersTitle + ", emailConfirmScreenOtherEmailTitle=" + this.emailConfirmScreenOtherEmailTitle + ", emailEnterScreenTitle=" + this.emailEnterScreenTitle + ", emailEnterScreenSubtitle=" + this.emailEnterScreenSubtitle + ", emailEnterActionText=" + this.emailEnterActionText + ", selectAccountEnrollmentScreenTitle=" + this.selectAccountEnrollmentScreenTitle + ", selectAccountEnrollmentScreenSubtitle=" + this.selectAccountEnrollmentScreenSubtitle + ", selectAccountEnrollmentScreenAgreementTitle=" + this.selectAccountEnrollmentScreenAgreementTitle + ", passwordEnterScreenTitle=" + this.passwordEnterScreenTitle + ", passwordEnterScreenForceLoginWarning=" + this.passwordEnterScreenForceLoginWarning + ", passwordEnterScreenWarning=" + this.passwordEnterScreenWarning + ", acceptTermsScreenTitle=" + this.acceptTermsScreenTitle + ", acceptTermsScreenDescription=" + this.acceptTermsScreenDescription + ", acceptTermsScreenActionText=" + this.acceptTermsScreenActionText + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.restorePasswordEnabled ? 1 : 0);
        parcel.writeString(this.userAgreementTitle);
        parcel.writeString(this.userWithEmailAgreementTitle);
        parcel.writeInt(this.emailCheckboxVisible ? 1 : 0);
        parcel.writeString(this.emailCheckboxTitle);
        parcel.writeString(this.addEmailTitle);
        parcel.writeString(this.migrationScreenTitle);
        parcel.writeString(this.migrationScreenSubtitle);
        parcel.writeString(this.migrationScreenButtonSubtitle);
        parcel.writeString(this.hardMigrationScreenTitle);
        parcel.writeString(this.hardMigrationScreenSubtitle);
        parcel.writeString(this.hardMigrationScreenButtonSubtitle);
        parcel.writeString(this.oauthNotFoundTitle);
        parcel.writeString(this.oauthNotFoundText);
        parcel.writeString(this.oauthNotFoundEnrollmentTitle);
        parcel.writeString(this.oauthNotFoundLoginTitle);
        parcel.writeString(this.openSberIdDialogText);
        parcel.writeString(this.sberIdBoundSuccessText);
        parcel.writeString(this.sberIdUnboundDialogText);
        parcel.writeString(this.emailConfirmScreenTitle);
        parcel.writeString(this.emailConfirmScreenDescription);
        parcel.writeString(this.emailConfirmLabel);
        parcel.writeString(this.emailConfirmOffersTitle);
        parcel.writeString(this.emailConfirmScreenOtherEmailTitle);
        parcel.writeString(this.emailEnterScreenTitle);
        parcel.writeString(this.emailEnterScreenSubtitle);
        parcel.writeString(this.emailEnterActionText);
        parcel.writeString(this.selectAccountEnrollmentScreenTitle);
        parcel.writeString(this.selectAccountEnrollmentScreenSubtitle);
        parcel.writeString(this.selectAccountEnrollmentScreenAgreementTitle);
        parcel.writeString(this.passwordEnterScreenTitle);
        parcel.writeString(this.passwordEnterScreenForceLoginWarning);
        parcel.writeString(this.passwordEnterScreenWarning);
        parcel.writeString(this.acceptTermsScreenTitle);
        parcel.writeString(this.acceptTermsScreenDescription);
        parcel.writeString(this.acceptTermsScreenActionText);
    }

    public /* synthetic */ RemoteConfig(boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, str, str2, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (32768 & i) != 0 ? null : str14, (65536 & i) != 0 ? null : str15, (131072 & i) != 0 ? null : str16, (262144 & i) != 0 ? null : str17, (524288 & i) != 0 ? null : str18, (1048576 & i) != 0 ? null : str19, (2097152 & i) != 0 ? null : str20, (4194304 & i) != 0 ? null : str21, (8388608 & i) != 0 ? null : str22, (16777216 & i) != 0 ? null : str23, (33554432 & i) != 0 ? null : str24, (67108864 & i) != 0 ? null : str25, (134217728 & i) != 0 ? null : str26, (268435456 & i) != 0 ? null : str27, (536870912 & i) != 0 ? null : str28, (1073741824 & i) != 0 ? null : str29, (i & Integer.MIN_VALUE) != 0 ? null : str30, (i2 & 1) != 0 ? null : str31, (i2 & 2) != 0 ? null : str32, (i2 & 4) != 0 ? null : str33, (i2 & 8) != 0 ? null : str34);
    }
}
