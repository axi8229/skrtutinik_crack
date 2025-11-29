package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0019\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ProcessError;", "Landroid/os/Parcelable;", "()V", "Lru/yoomoney/sdk/auth/api/model/ErrorAccountForRecoveryNotFound;", "Lru/yoomoney/sdk/auth/api/model/ErrorAccountNotFound;", "Lru/yoomoney/sdk/auth/api/model/ErrorCodeExpired;", "Lru/yoomoney/sdk/auth/api/model/ErrorContactTechnicalSupport;", "Lru/yoomoney/sdk/auth/api/model/ErrorEmailAlreadyTaken;", "Lru/yoomoney/sdk/auth/api/model/ErrorEmailQuarantined;", "Lru/yoomoney/sdk/auth/api/model/ErrorFraudSuspected;", "Lru/yoomoney/sdk/auth/api/model/ErrorInvalidCode;", "Lru/yoomoney/sdk/auth/api/model/ErrorInvalidOauthSecret;", "Lru/yoomoney/sdk/auth/api/model/ErrorInvalidPassword;", "Lru/yoomoney/sdk/auth/api/model/ErrorInvalidPasswordOrAccount;", "Lru/yoomoney/sdk/auth/api/model/ErrorMaxSucceededPasswordAttemptsReached;", "Lru/yoomoney/sdk/auth/api/model/ErrorMaxWrongPasswordAttemptsReached;", "Lru/yoomoney/sdk/auth/api/model/ErrorOauthAccountNotConnected;", "Lru/yoomoney/sdk/auth/api/model/ErrorPasswordRequirementsViolated;", "Lru/yoomoney/sdk/auth/api/model/ErrorPhoneIsAlreadyAssignedToAccountWithoutEmail;", "Lru/yoomoney/sdk/auth/api/model/ErrorPhoneIsSameAsCurrent;", "Lru/yoomoney/sdk/auth/api/model/ErrorProcessingRequest;", "Lru/yoomoney/sdk/auth/api/model/ErrorSocialAccountAlreadyBound;", "Lru/yoomoney/sdk/auth/api/model/ErrorTooFrequentlyResend;", "Lru/yoomoney/sdk/auth/api/model/ErrorTooManyLinkedAccountsToPhone;", "Lru/yoomoney/sdk/auth/api/model/ErrorUserTemporaryBanned;", "Lru/yoomoney/sdk/auth/api/model/NotNeedMigration;", "Lru/yoomoney/sdk/auth/api/model/NotRegistered;", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ProcessError implements Parcelable {
    private ProcessError() {
    }

    public /* synthetic */ ProcessError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
