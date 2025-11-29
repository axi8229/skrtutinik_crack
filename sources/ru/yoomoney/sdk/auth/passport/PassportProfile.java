package ru.yoomoney.sdk.auth.passport;

import android.net.Uri;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.model.ConnectSocialAccountEnterOAuthCode;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfile {
    public static final PassportProfile INSTANCE = new PassportProfile();

    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:%\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001%()*+,-./0123456789:;<=>?@ABCDEFGHIJKL¨\u0006M"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "", "()V", "AccountFailed", "AccountSuccess", "AccountWithMessage", "BindSocialAccountError", "BindSocialAccountSuccess", "BindingSocialAccountFailed", "CancelBinding", "ChangeEmail", "ChangeEmailSuccess", "ChangeName", "ChangePassword", "ChangePhone", "ChangePhoneSuccess", "ConfirmChangeEmail", "ConfirmChangePassword", "ConfirmChangePhone", "Finish", "FinishWithCancel", "HandleAccountSuccess", "HandleBindEsiaResponse", "HandleBindSberIdResponse", "HandleBindVkIdResponse", "Init", "InitEmailProcess", "Nothing", "OpenSocialAccountDialog", "ShowChangeEmailDialog", "ShowChangePhoneDialog", "StartBindingSocialAccount", "StartBindingSocialAccountSuccess", "StartChangeFailed", "StartChangeSuccess", "StartEmailProcess", "StartUnbindSocialAccount", "UnbindSocialAccount", "UnbindSocialAccountFailed", "UnbindSocialAccountSuccess", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountWithMessage;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$BindSocialAccountError;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$BindSocialAccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$BindingSocialAccountFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$CancelBinding;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangeEmail;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangeEmailSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangeName;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangePassword;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangePhone;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangePhoneSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ConfirmChangeEmail;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ConfirmChangePassword;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ConfirmChangePhone;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$Finish;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$FinishWithCancel;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleAccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleBindEsiaResponse;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleBindSberIdResponse;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleBindVkIdResponse;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$Init;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$InitEmailProcess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$Nothing;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$OpenSocialAccountDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ShowChangeEmailDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ShowChangePhoneDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartBindingSocialAccount;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartBindingSocialAccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartChangeFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartChangeSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartEmailProcess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartUnbindSocialAccount;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$UnbindSocialAccount;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$UnbindSocialAccountFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$UnbindSocialAccountSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AccountFailed extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AccountFailed(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ AccountFailed copy$default(AccountFailed accountFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = accountFailed.failure;
                }
                return accountFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final AccountFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new AccountFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AccountFailed) && Intrinsics.areEqual(this.failure, ((AccountFailed) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "AccountFailed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AccountSuccess extends Action {
            private final UserAccount account;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AccountSuccess(UserAccount account, ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                this.account = account;
                this.processType = processType;
            }

            public static /* synthetic */ AccountSuccess copy$default(AccountSuccess accountSuccess, UserAccount userAccount, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = accountSuccess.account;
                }
                if ((i & 2) != 0) {
                    processType = accountSuccess.processType;
                }
                return accountSuccess.copy(userAccount, processType);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final AccountSuccess copy(UserAccount account, ProcessType processType) {
                Intrinsics.checkNotNullParameter(account, "account");
                return new AccountSuccess(account, processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AccountSuccess)) {
                    return false;
                }
                AccountSuccess accountSuccess = (AccountSuccess) other;
                return Intrinsics.areEqual(this.account, accountSuccess.account) && this.processType == accountSuccess.processType;
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                int iHashCode = this.account.hashCode() * 31;
                ProcessType processType = this.processType;
                return iHashCode + (processType == null ? 0 : processType.hashCode());
            }

            public String toString() {
                return "AccountSuccess(account=" + this.account + ", processType=" + this.processType + ")";
            }

            public /* synthetic */ AccountSuccess(UserAccount userAccount, ProcessType processType, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(userAccount, (i & 2) != 0 ? null : processType);
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountWithMessage;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "successMessage", "", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Ljava/lang/String;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getSuccessMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AccountWithMessage extends Action {
            private final UserAccount account;
            private final String successMessage;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AccountWithMessage(UserAccount account, String successMessage) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(successMessage, "successMessage");
                this.account = account;
                this.successMessage = successMessage;
            }

            public static /* synthetic */ AccountWithMessage copy$default(AccountWithMessage accountWithMessage, UserAccount userAccount, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = accountWithMessage.account;
                }
                if ((i & 2) != 0) {
                    str = accountWithMessage.successMessage;
                }
                return accountWithMessage.copy(userAccount, str);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final String getSuccessMessage() {
                return this.successMessage;
            }

            public final AccountWithMessage copy(UserAccount account, String successMessage) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(successMessage, "successMessage");
                return new AccountWithMessage(account, successMessage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AccountWithMessage)) {
                    return false;
                }
                AccountWithMessage accountWithMessage = (AccountWithMessage) other;
                return Intrinsics.areEqual(this.account, accountWithMessage.account) && Intrinsics.areEqual(this.successMessage, accountWithMessage.successMessage);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final String getSuccessMessage() {
                return this.successMessage;
            }

            public int hashCode() {
                return this.successMessage.hashCode() + (this.account.hashCode() * 31);
            }

            public String toString() {
                return "AccountWithMessage(account=" + this.account + ", successMessage=" + this.successMessage + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$BindSocialAccountError;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class BindSocialAccountError extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BindSocialAccountError(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ BindSocialAccountError copy$default(BindSocialAccountError bindSocialAccountError, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = bindSocialAccountError.failure;
                }
                return bindSocialAccountError.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final BindSocialAccountError copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new BindSocialAccountError(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BindSocialAccountError) && Intrinsics.areEqual(this.failure, ((BindSocialAccountError) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "BindSocialAccountError(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$BindSocialAccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "bindedServiceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getBindedServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class BindSocialAccountSuccess extends Action {
            private final UserAccount account;
            private final OauthServiceProvider bindedServiceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BindSocialAccountSuccess(UserAccount account, OauthServiceProvider bindedServiceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(bindedServiceProvider, "bindedServiceProvider");
                this.account = account;
                this.bindedServiceProvider = bindedServiceProvider;
            }

            public static /* synthetic */ BindSocialAccountSuccess copy$default(BindSocialAccountSuccess bindSocialAccountSuccess, UserAccount userAccount, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = bindSocialAccountSuccess.account;
                }
                if ((i & 2) != 0) {
                    oauthServiceProvider = bindSocialAccountSuccess.bindedServiceProvider;
                }
                return bindSocialAccountSuccess.copy(userAccount, oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final OauthServiceProvider getBindedServiceProvider() {
                return this.bindedServiceProvider;
            }

            public final BindSocialAccountSuccess copy(UserAccount account, OauthServiceProvider bindedServiceProvider) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(bindedServiceProvider, "bindedServiceProvider");
                return new BindSocialAccountSuccess(account, bindedServiceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BindSocialAccountSuccess)) {
                    return false;
                }
                BindSocialAccountSuccess bindSocialAccountSuccess = (BindSocialAccountSuccess) other;
                return Intrinsics.areEqual(this.account, bindSocialAccountSuccess.account) && this.bindedServiceProvider == bindSocialAccountSuccess.bindedServiceProvider;
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final OauthServiceProvider getBindedServiceProvider() {
                return this.bindedServiceProvider;
            }

            public int hashCode() {
                return this.bindedServiceProvider.hashCode() + (this.account.hashCode() * 31);
            }

            public String toString() {
                return "BindSocialAccountSuccess(account=" + this.account + ", bindedServiceProvider=" + this.bindedServiceProvider + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$BindingSocialAccountFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class BindingSocialAccountFailed extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BindingSocialAccountFailed(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ BindingSocialAccountFailed copy$default(BindingSocialAccountFailed bindingSocialAccountFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = bindingSocialAccountFailed.failure;
                }
                return bindingSocialAccountFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final BindingSocialAccountFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new BindingSocialAccountFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BindingSocialAccountFailed) && Intrinsics.areEqual(this.failure, ((BindingSocialAccountFailed) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "BindingSocialAccountFailed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$CancelBinding;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CancelBinding extends Action {
            public static final CancelBinding INSTANCE = new CancelBinding();

            private CancelBinding() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof CancelBinding);
            }

            public int hashCode() {
                return 761563152;
            }

            public String toString() {
                return "CancelBinding";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangeEmail;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangeEmail extends Action {
            public static final ChangeEmail INSTANCE = new ChangeEmail();

            private ChangeEmail() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ChangeEmail);
            }

            public int hashCode() {
                return -1151797135;
            }

            public String toString() {
                return "ChangeEmail";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangeEmailSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", Scopes.EMAIL, "", "(Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangeEmailSuccess extends Action {
            private final String email;

            public ChangeEmailSuccess(String str) {
                super(null);
                this.email = str;
            }

            public static /* synthetic */ ChangeEmailSuccess copy$default(ChangeEmailSuccess changeEmailSuccess, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = changeEmailSuccess.email;
                }
                return changeEmailSuccess.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getEmail() {
                return this.email;
            }

            public final ChangeEmailSuccess copy(String email) {
                return new ChangeEmailSuccess(email);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeEmailSuccess) && Intrinsics.areEqual(this.email, ((ChangeEmailSuccess) other).email);
            }

            public final String getEmail() {
                return this.email;
            }

            public int hashCode() {
                String str = this.email;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ChangeEmailSuccess(email=" + this.email + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangeName;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangeName extends Action {
            public static final ChangeName INSTANCE = new ChangeName();

            private ChangeName() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ChangeName);
            }

            public int hashCode() {
                return 794386198;
            }

            public String toString() {
                return "ChangeName";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangePassword;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangePassword extends Action {
            public static final ChangePassword INSTANCE = new ChangePassword();

            private ChangePassword() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ChangePassword);
            }

            public int hashCode() {
                return -238788186;
            }

            public String toString() {
                return "ChangePassword";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangePhone;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangePhone extends Action {
            public static final ChangePhone INSTANCE = new ChangePhone();

            private ChangePhone() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ChangePhone);
            }

            public int hashCode() {
                return -1141773757;
            }

            public String toString() {
                return "ChangePhone";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ChangePhoneSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "phone", "", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangePhoneSuccess extends Action {
            private final String phone;

            public ChangePhoneSuccess(String str) {
                super(null);
                this.phone = str;
            }

            public static /* synthetic */ ChangePhoneSuccess copy$default(ChangePhoneSuccess changePhoneSuccess, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = changePhoneSuccess.phone;
                }
                return changePhoneSuccess.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getPhone() {
                return this.phone;
            }

            public final ChangePhoneSuccess copy(String phone) {
                return new ChangePhoneSuccess(phone);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangePhoneSuccess) && Intrinsics.areEqual(this.phone, ((ChangePhoneSuccess) other).phone);
            }

            public final String getPhone() {
                return this.phone;
            }

            public int hashCode() {
                String str = this.phone;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ChangePhoneSuccess(phone=" + this.phone + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ConfirmChangeEmail;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmChangeEmail extends Action {
            public static final ConfirmChangeEmail INSTANCE = new ConfirmChangeEmail();

            private ConfirmChangeEmail() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ConfirmChangeEmail);
            }

            public int hashCode() {
                return -1527650137;
            }

            public String toString() {
                return "ConfirmChangeEmail";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ConfirmChangePassword;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmChangePassword extends Action {
            public static final ConfirmChangePassword INSTANCE = new ConfirmChangePassword();

            private ConfirmChangePassword() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ConfirmChangePassword);
            }

            public int hashCode() {
                return -295830096;
            }

            public String toString() {
                return "ConfirmChangePassword";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ConfirmChangePhone;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmChangePhone extends Action {
            public static final ConfirmChangePhone INSTANCE = new ConfirmChangePhone();

            private ConfirmChangePhone() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ConfirmChangePhone);
            }

            public int hashCode() {
                return -1517626759;
            }

            public String toString() {
                return "ConfirmChangePhone";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$Finish;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Finish extends Action {
            public static final Finish INSTANCE = new Finish();

            private Finish() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Finish);
            }

            public int hashCode() {
                return 510514894;
            }

            public String toString() {
                return "Finish";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$FinishWithCancel;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FinishWithCancel extends Action {
            public static final FinishWithCancel INSTANCE = new FinishWithCancel();

            private FinishWithCancel() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof FinishWithCancel);
            }

            public int hashCode() {
                return -1810323378;
            }

            public String toString() {
                return "FinishWithCancel";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleAccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class HandleAccountSuccess extends Action {
            private final UserAccount account;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleAccountSuccess(UserAccount account, ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                this.account = account;
                this.processType = processType;
            }

            public static /* synthetic */ HandleAccountSuccess copy$default(HandleAccountSuccess handleAccountSuccess, UserAccount userAccount, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = handleAccountSuccess.account;
                }
                if ((i & 2) != 0) {
                    processType = handleAccountSuccess.processType;
                }
                return handleAccountSuccess.copy(userAccount, processType);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final HandleAccountSuccess copy(UserAccount account, ProcessType processType) {
                Intrinsics.checkNotNullParameter(account, "account");
                return new HandleAccountSuccess(account, processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandleAccountSuccess)) {
                    return false;
                }
                HandleAccountSuccess handleAccountSuccess = (HandleAccountSuccess) other;
                return Intrinsics.areEqual(this.account, handleAccountSuccess.account) && this.processType == handleAccountSuccess.processType;
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                int iHashCode = this.account.hashCode() * 31;
                ProcessType processType = this.processType;
                return iHashCode + (processType == null ? 0 : processType.hashCode());
            }

            public String toString() {
                return "HandleAccountSuccess(account=" + this.account + ", processType=" + this.processType + ")";
            }

            public /* synthetic */ HandleAccountSuccess(UserAccount userAccount, ProcessType processType, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(userAccount, (i & 2) != 0 ? null : processType);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleBindEsiaResponse;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class HandleBindEsiaResponse extends Action {
            private final Uri uri;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleBindEsiaResponse(Uri uri) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.uri = uri;
            }

            public static /* synthetic */ HandleBindEsiaResponse copy$default(HandleBindEsiaResponse handleBindEsiaResponse, Uri uri, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = handleBindEsiaResponse.uri;
                }
                return handleBindEsiaResponse.copy(uri);
            }

            /* renamed from: component1, reason: from getter */
            public final Uri getUri() {
                return this.uri;
            }

            public final HandleBindEsiaResponse copy(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new HandleBindEsiaResponse(uri);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HandleBindEsiaResponse) && Intrinsics.areEqual(this.uri, ((HandleBindEsiaResponse) other).uri);
            }

            public final Uri getUri() {
                return this.uri;
            }

            public int hashCode() {
                return this.uri.hashCode();
            }

            public String toString() {
                return "HandleBindEsiaResponse(uri=" + this.uri + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleBindSberIdResponse;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "uri", "Landroid/net/Uri;", "returnUrl", "", "(Landroid/net/Uri;Ljava/lang/String;)V", "getReturnUrl", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class HandleBindSberIdResponse extends Action {
            private final String returnUrl;
            private final Uri uri;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleBindSberIdResponse(Uri uri, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.uri = uri;
                this.returnUrl = str;
            }

            public static /* synthetic */ HandleBindSberIdResponse copy$default(HandleBindSberIdResponse handleBindSberIdResponse, Uri uri, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = handleBindSberIdResponse.uri;
                }
                if ((i & 2) != 0) {
                    str = handleBindSberIdResponse.returnUrl;
                }
                return handleBindSberIdResponse.copy(uri, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Uri getUri() {
                return this.uri;
            }

            /* renamed from: component2, reason: from getter */
            public final String getReturnUrl() {
                return this.returnUrl;
            }

            public final HandleBindSberIdResponse copy(Uri uri, String returnUrl) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new HandleBindSberIdResponse(uri, returnUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandleBindSberIdResponse)) {
                    return false;
                }
                HandleBindSberIdResponse handleBindSberIdResponse = (HandleBindSberIdResponse) other;
                return Intrinsics.areEqual(this.uri, handleBindSberIdResponse.uri) && Intrinsics.areEqual(this.returnUrl, handleBindSberIdResponse.returnUrl);
            }

            public final String getReturnUrl() {
                return this.returnUrl;
            }

            public final Uri getUri() {
                return this.uri;
            }

            public int hashCode() {
                int iHashCode = this.uri.hashCode() * 31;
                String str = this.returnUrl;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "HandleBindSberIdResponse(uri=" + this.uri + ", returnUrl=" + this.returnUrl + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleBindVkIdResponse;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "token", "", "uuid", "redirectUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRedirectUrl", "()Ljava/lang/String;", "getToken", "getUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class HandleBindVkIdResponse extends Action {
            private final String redirectUrl;
            private final String token;
            private final String uuid;

            public HandleBindVkIdResponse(String str, String str2, String str3) {
                super(null);
                this.token = str;
                this.uuid = str2;
                this.redirectUrl = str3;
            }

            public static /* synthetic */ HandleBindVkIdResponse copy$default(HandleBindVkIdResponse handleBindVkIdResponse, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = handleBindVkIdResponse.token;
                }
                if ((i & 2) != 0) {
                    str2 = handleBindVkIdResponse.uuid;
                }
                if ((i & 4) != 0) {
                    str3 = handleBindVkIdResponse.redirectUrl;
                }
                return handleBindVkIdResponse.copy(str, str2, str3);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            /* renamed from: component3, reason: from getter */
            public final String getRedirectUrl() {
                return this.redirectUrl;
            }

            public final HandleBindVkIdResponse copy(String token, String uuid, String redirectUrl) {
                return new HandleBindVkIdResponse(token, uuid, redirectUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandleBindVkIdResponse)) {
                    return false;
                }
                HandleBindVkIdResponse handleBindVkIdResponse = (HandleBindVkIdResponse) other;
                return Intrinsics.areEqual(this.token, handleBindVkIdResponse.token) && Intrinsics.areEqual(this.uuid, handleBindVkIdResponse.uuid) && Intrinsics.areEqual(this.redirectUrl, handleBindVkIdResponse.redirectUrl);
            }

            public final String getRedirectUrl() {
                return this.redirectUrl;
            }

            public final String getToken() {
                return this.token;
            }

            public final String getUuid() {
                return this.uuid;
            }

            public int hashCode() {
                String str = this.token;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.uuid;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.redirectUrl;
                return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "HandleBindVkIdResponse(token=" + this.token + ", uuid=" + this.uuid + ", redirectUrl=" + this.redirectUrl + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$Init;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "accountToken", "", "(Ljava/lang/String;)V", "getAccountToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Init extends Action {
            private final String accountToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Init(String accountToken) {
                super(null);
                Intrinsics.checkNotNullParameter(accountToken, "accountToken");
                this.accountToken = accountToken;
            }

            public static /* synthetic */ Init copy$default(Init init, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = init.accountToken;
                }
                return init.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getAccountToken() {
                return this.accountToken;
            }

            public final Init copy(String accountToken) {
                Intrinsics.checkNotNullParameter(accountToken, "accountToken");
                return new Init(accountToken);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Init) && Intrinsics.areEqual(this.accountToken, ((Init) other).accountToken);
            }

            public final String getAccountToken() {
                return this.accountToken;
            }

            public int hashCode() {
                return this.accountToken.hashCode();
            }

            public String toString() {
                return "Init(accountToken=" + this.accountToken + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$InitEmailProcess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "accountToken", "", "(Ljava/lang/String;)V", "getAccountToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class InitEmailProcess extends Action {
            private final String accountToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitEmailProcess(String accountToken) {
                super(null);
                Intrinsics.checkNotNullParameter(accountToken, "accountToken");
                this.accountToken = accountToken;
            }

            public static /* synthetic */ InitEmailProcess copy$default(InitEmailProcess initEmailProcess, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = initEmailProcess.accountToken;
                }
                return initEmailProcess.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getAccountToken() {
                return this.accountToken;
            }

            public final InitEmailProcess copy(String accountToken) {
                Intrinsics.checkNotNullParameter(accountToken, "accountToken");
                return new InitEmailProcess(accountToken);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InitEmailProcess) && Intrinsics.areEqual(this.accountToken, ((InitEmailProcess) other).accountToken);
            }

            public final String getAccountToken() {
                return this.accountToken;
            }

            public int hashCode() {
                return this.accountToken.hashCode();
            }

            public String toString() {
                return "InitEmailProcess(accountToken=" + this.accountToken + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$Nothing;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Nothing extends Action {
            public static final Nothing INSTANCE = new Nothing();

            private Nothing() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Nothing);
            }

            public int hashCode() {
                return 1628431602;
            }

            public String toString() {
                return "Nothing";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$OpenSocialAccountDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class OpenSocialAccountDialog extends Action {
            private final OauthServiceProvider serviceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenSocialAccountDialog(OauthServiceProvider serviceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                this.serviceProvider = serviceProvider;
            }

            public static /* synthetic */ OpenSocialAccountDialog copy$default(OpenSocialAccountDialog openSocialAccountDialog, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    oauthServiceProvider = openSocialAccountDialog.serviceProvider;
                }
                return openSocialAccountDialog.copy(oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public final OpenSocialAccountDialog copy(OauthServiceProvider serviceProvider) {
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                return new OpenSocialAccountDialog(serviceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenSocialAccountDialog) && this.serviceProvider == ((OpenSocialAccountDialog) other).serviceProvider;
            }

            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public int hashCode() {
                return this.serviceProvider.hashCode();
            }

            public String toString() {
                return "OpenSocialAccountDialog(serviceProvider=" + this.serviceProvider + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ShowChangeEmailDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChangeEmailDialog extends Action {
            public static final ShowChangeEmailDialog INSTANCE = new ShowChangeEmailDialog();

            private ShowChangeEmailDialog() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowChangeEmailDialog);
            }

            public int hashCode() {
                return 155856156;
            }

            public String toString() {
                return "ShowChangeEmailDialog";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$ShowChangePhoneDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChangePhoneDialog extends Action {
            public static final ShowChangePhoneDialog INSTANCE = new ShowChangePhoneDialog();

            private ShowChangePhoneDialog() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowChangePhoneDialog);
            }

            public int hashCode() {
                return 1518795118;
            }

            public String toString() {
                return "ShowChangePhoneDialog";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartBindingSocialAccount;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class StartBindingSocialAccount extends Action {
            private final OauthServiceProvider serviceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartBindingSocialAccount(OauthServiceProvider serviceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                this.serviceProvider = serviceProvider;
            }

            public static /* synthetic */ StartBindingSocialAccount copy$default(StartBindingSocialAccount startBindingSocialAccount, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    oauthServiceProvider = startBindingSocialAccount.serviceProvider;
                }
                return startBindingSocialAccount.copy(oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public final StartBindingSocialAccount copy(OauthServiceProvider serviceProvider) {
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                return new StartBindingSocialAccount(serviceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartBindingSocialAccount) && this.serviceProvider == ((StartBindingSocialAccount) other).serviceProvider;
            }

            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public int hashCode() {
                return this.serviceProvider.hashCode();
            }

            public String toString() {
                return "StartBindingSocialAccount(serviceProvider=" + this.serviceProvider + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartBindingSocialAccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "process", "Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "(Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class StartBindingSocialAccountSuccess extends Action {
            private final ConnectSocialAccountEnterOAuthCode process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartBindingSocialAccountSuccess(ConnectSocialAccountEnterOAuthCode process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ StartBindingSocialAccountSuccess copy$default(StartBindingSocialAccountSuccess startBindingSocialAccountSuccess, ConnectSocialAccountEnterOAuthCode connectSocialAccountEnterOAuthCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    connectSocialAccountEnterOAuthCode = startBindingSocialAccountSuccess.process;
                }
                return startBindingSocialAccountSuccess.copy(connectSocialAccountEnterOAuthCode);
            }

            /* renamed from: component1, reason: from getter */
            public final ConnectSocialAccountEnterOAuthCode getProcess() {
                return this.process;
            }

            public final StartBindingSocialAccountSuccess copy(ConnectSocialAccountEnterOAuthCode process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new StartBindingSocialAccountSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartBindingSocialAccountSuccess) && Intrinsics.areEqual(this.process, ((StartBindingSocialAccountSuccess) other).process);
            }

            public final ConnectSocialAccountEnterOAuthCode getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "StartBindingSocialAccountSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartChangeFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class StartChangeFailed extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartChangeFailed(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ StartChangeFailed copy$default(StartChangeFailed startChangeFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = startChangeFailed.failure;
                }
                return startChangeFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final StartChangeFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new StartChangeFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartChangeFailed) && Intrinsics.areEqual(this.failure, ((StartChangeFailed) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "StartChangeFailed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartChangeSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class StartChangeSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartChangeSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ StartChangeSuccess copy$default(StartChangeSuccess startChangeSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = startChangeSuccess.process;
                }
                return startChangeSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final StartChangeSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new StartChangeSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartChangeSuccess) && Intrinsics.areEqual(this.process, ((StartChangeSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "StartChangeSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartEmailProcess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class StartEmailProcess extends Action {
            private final UserAccount account;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartEmailProcess(UserAccount account) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                this.account = account;
            }

            public static /* synthetic */ StartEmailProcess copy$default(StartEmailProcess startEmailProcess, UserAccount userAccount, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = startEmailProcess.account;
                }
                return startEmailProcess.copy(userAccount);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            public final StartEmailProcess copy(UserAccount account) {
                Intrinsics.checkNotNullParameter(account, "account");
                return new StartEmailProcess(account);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartEmailProcess) && Intrinsics.areEqual(this.account, ((StartEmailProcess) other).account);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public int hashCode() {
                return this.account.hashCode();
            }

            public String toString() {
                return "StartEmailProcess(account=" + this.account + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$StartUnbindSocialAccount;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class StartUnbindSocialAccount extends Action {
            private final OauthServiceProvider serviceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartUnbindSocialAccount(OauthServiceProvider serviceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                this.serviceProvider = serviceProvider;
            }

            public static /* synthetic */ StartUnbindSocialAccount copy$default(StartUnbindSocialAccount startUnbindSocialAccount, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    oauthServiceProvider = startUnbindSocialAccount.serviceProvider;
                }
                return startUnbindSocialAccount.copy(oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public final StartUnbindSocialAccount copy(OauthServiceProvider serviceProvider) {
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                return new StartUnbindSocialAccount(serviceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartUnbindSocialAccount) && this.serviceProvider == ((StartUnbindSocialAccount) other).serviceProvider;
            }

            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public int hashCode() {
                return this.serviceProvider.hashCode();
            }

            public String toString() {
                return "StartUnbindSocialAccount(serviceProvider=" + this.serviceProvider + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$UnbindSocialAccount;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UnbindSocialAccount extends Action {
            private final OauthServiceProvider serviceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UnbindSocialAccount(OauthServiceProvider serviceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                this.serviceProvider = serviceProvider;
            }

            public static /* synthetic */ UnbindSocialAccount copy$default(UnbindSocialAccount unbindSocialAccount, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    oauthServiceProvider = unbindSocialAccount.serviceProvider;
                }
                return unbindSocialAccount.copy(oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public final UnbindSocialAccount copy(OauthServiceProvider serviceProvider) {
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                return new UnbindSocialAccount(serviceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UnbindSocialAccount) && this.serviceProvider == ((UnbindSocialAccount) other).serviceProvider;
            }

            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public int hashCode() {
                return this.serviceProvider.hashCode();
            }

            public String toString() {
                return "UnbindSocialAccount(serviceProvider=" + this.serviceProvider + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$UnbindSocialAccountFailed;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UnbindSocialAccountFailed extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UnbindSocialAccountFailed(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ UnbindSocialAccountFailed copy$default(UnbindSocialAccountFailed unbindSocialAccountFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = unbindSocialAccountFailed.failure;
                }
                return unbindSocialAccountFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final UnbindSocialAccountFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new UnbindSocialAccountFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UnbindSocialAccountFailed) && Intrinsics.areEqual(this.failure, ((UnbindSocialAccountFailed) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "UnbindSocialAccountFailed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$UnbindSocialAccountSuccess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "unbindedServiceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getUnbindedServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UnbindSocialAccountSuccess extends Action {
            private final UserAccount account;
            private final OauthServiceProvider unbindedServiceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UnbindSocialAccountSuccess(UserAccount account, OauthServiceProvider unbindedServiceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(unbindedServiceProvider, "unbindedServiceProvider");
                this.account = account;
                this.unbindedServiceProvider = unbindedServiceProvider;
            }

            public static /* synthetic */ UnbindSocialAccountSuccess copy$default(UnbindSocialAccountSuccess unbindSocialAccountSuccess, UserAccount userAccount, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = unbindSocialAccountSuccess.account;
                }
                if ((i & 2) != 0) {
                    oauthServiceProvider = unbindSocialAccountSuccess.unbindedServiceProvider;
                }
                return unbindSocialAccountSuccess.copy(userAccount, oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final OauthServiceProvider getUnbindedServiceProvider() {
                return this.unbindedServiceProvider;
            }

            public final UnbindSocialAccountSuccess copy(UserAccount account, OauthServiceProvider unbindedServiceProvider) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(unbindedServiceProvider, "unbindedServiceProvider");
                return new UnbindSocialAccountSuccess(account, unbindedServiceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UnbindSocialAccountSuccess)) {
                    return false;
                }
                UnbindSocialAccountSuccess unbindSocialAccountSuccess = (UnbindSocialAccountSuccess) other;
                return Intrinsics.areEqual(this.account, unbindSocialAccountSuccess.account) && this.unbindedServiceProvider == unbindSocialAccountSuccess.unbindedServiceProvider;
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final OauthServiceProvider getUnbindedServiceProvider() {
                return this.unbindedServiceProvider;
            }

            public int hashCode() {
                return this.unbindedServiceProvider.hashCode() + (this.account.hashCode() * 31);
            }

            public String toString() {
                return "UnbindSocialAccountSuccess(account=" + this.account + ", unbindedServiceProvider=" + this.unbindedServiceProvider + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "action", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0010\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0010\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "", "()V", "ChangeName", "Finish", "FinishWithCancel", "OpenSocialAccountService", "ShowBindErrorDialog", "ShowBindSuccessDialog", "ShowChangeEmailConfirmDialog", "ShowChangeEmailSuccessDialog", "ShowChangePasswordConfirmDialog", "ShowChangePhoneConfirmDialog", "ShowChangePhoneSuccessDialog", "ShowFailure", "ShowNextStep", "ShowSocialAccountDialog", "ShowSuccessMessage", "ShowUnbindSocialAccountDialog", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ChangeName;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$Finish;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$FinishWithCancel;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$OpenSocialAccountService;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowBindErrorDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowBindSuccessDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangeEmailConfirmDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangeEmailSuccessDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangePasswordConfirmDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangePhoneConfirmDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangePhoneSuccessDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowSocialAccountDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowSuccessMessage;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowUnbindSocialAccountDialog;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ChangeName;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangeName extends Effect {
            private final String name;

            public ChangeName(String str) {
                super(null);
                this.name = str;
            }

            public static /* synthetic */ ChangeName copy$default(ChangeName changeName, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = changeName.name;
                }
                return changeName.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final ChangeName copy(String name) {
                return new ChangeName(name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeName) && Intrinsics.areEqual(this.name, ((ChangeName) other).name);
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                String str = this.name;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ChangeName(name=" + this.name + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$Finish;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Finish extends Effect {
            public static final Finish INSTANCE = new Finish();

            private Finish() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Finish);
            }

            public int hashCode() {
                return 1979264787;
            }

            public String toString() {
                return "Finish";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$FinishWithCancel;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FinishWithCancel extends Effect {
            private final Failure failure;

            public FinishWithCancel() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ FinishWithCancel copy$default(FinishWithCancel finishWithCancel, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = finishWithCancel.failure;
                }
                return finishWithCancel.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final FinishWithCancel copy(Failure failure) {
                return new FinishWithCancel(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FinishWithCancel) && Intrinsics.areEqual(this.failure, ((FinishWithCancel) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                Failure failure = this.failure;
                if (failure == null) {
                    return 0;
                }
                return failure.hashCode();
            }

            public String toString() {
                return "FinishWithCancel(failure=" + this.failure + ")";
            }

            public FinishWithCancel(Failure failure) {
                super(null);
                this.failure = failure;
            }

            public /* synthetic */ FinishWithCancel(Failure failure, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : failure);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$OpenSocialAccountService;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "process", "Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "(Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class OpenSocialAccountService extends Effect {
            private final ConnectSocialAccountEnterOAuthCode process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenSocialAccountService(ConnectSocialAccountEnterOAuthCode process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ OpenSocialAccountService copy$default(OpenSocialAccountService openSocialAccountService, ConnectSocialAccountEnterOAuthCode connectSocialAccountEnterOAuthCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    connectSocialAccountEnterOAuthCode = openSocialAccountService.process;
                }
                return openSocialAccountService.copy(connectSocialAccountEnterOAuthCode);
            }

            /* renamed from: component1, reason: from getter */
            public final ConnectSocialAccountEnterOAuthCode getProcess() {
                return this.process;
            }

            public final OpenSocialAccountService copy(ConnectSocialAccountEnterOAuthCode process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new OpenSocialAccountService(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenSocialAccountService) && Intrinsics.areEqual(this.process, ((OpenSocialAccountService) other).process);
            }

            public final ConnectSocialAccountEnterOAuthCode getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "OpenSocialAccountService(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowBindErrorDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowBindErrorDialog extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowBindErrorDialog(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowBindErrorDialog copy$default(ShowBindErrorDialog showBindErrorDialog, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showBindErrorDialog.failure;
                }
                return showBindErrorDialog.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowBindErrorDialog copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowBindErrorDialog(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowBindErrorDialog) && Intrinsics.areEqual(this.failure, ((ShowBindErrorDialog) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowBindErrorDialog(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowBindSuccessDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "provider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowBindSuccessDialog extends Effect {
            private final OauthServiceProvider provider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowBindSuccessDialog(OauthServiceProvider provider) {
                super(null);
                Intrinsics.checkNotNullParameter(provider, "provider");
                this.provider = provider;
            }

            public static /* synthetic */ ShowBindSuccessDialog copy$default(ShowBindSuccessDialog showBindSuccessDialog, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    oauthServiceProvider = showBindSuccessDialog.provider;
                }
                return showBindSuccessDialog.copy(oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final OauthServiceProvider getProvider() {
                return this.provider;
            }

            public final ShowBindSuccessDialog copy(OauthServiceProvider provider) {
                Intrinsics.checkNotNullParameter(provider, "provider");
                return new ShowBindSuccessDialog(provider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowBindSuccessDialog) && this.provider == ((ShowBindSuccessDialog) other).provider;
            }

            public final OauthServiceProvider getProvider() {
                return this.provider;
            }

            public int hashCode() {
                return this.provider.hashCode();
            }

            public String toString() {
                return "ShowBindSuccessDialog(provider=" + this.provider + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangeEmailConfirmDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChangeEmailConfirmDialog extends Effect {
            public static final ShowChangeEmailConfirmDialog INSTANCE = new ShowChangeEmailConfirmDialog();

            private ShowChangeEmailConfirmDialog() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowChangeEmailConfirmDialog);
            }

            public int hashCode() {
                return 754286681;
            }

            public String toString() {
                return "ShowChangeEmailConfirmDialog";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangeEmailSuccessDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", Scopes.EMAIL, "", "userHadEmail", "", "marketingAccepted", "(Ljava/lang/String;ZZ)V", "getEmail", "()Ljava/lang/String;", "getMarketingAccepted", "()Z", "getUserHadEmail", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChangeEmailSuccessDialog extends Effect {
            private final String email;
            private final boolean marketingAccepted;
            private final boolean userHadEmail;

            public ShowChangeEmailSuccessDialog(String str, boolean z, boolean z2) {
                super(null);
                this.email = str;
                this.userHadEmail = z;
                this.marketingAccepted = z2;
            }

            public static /* synthetic */ ShowChangeEmailSuccessDialog copy$default(ShowChangeEmailSuccessDialog showChangeEmailSuccessDialog, String str, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showChangeEmailSuccessDialog.email;
                }
                if ((i & 2) != 0) {
                    z = showChangeEmailSuccessDialog.userHadEmail;
                }
                if ((i & 4) != 0) {
                    z2 = showChangeEmailSuccessDialog.marketingAccepted;
                }
                return showChangeEmailSuccessDialog.copy(str, z, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getEmail() {
                return this.email;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getUserHadEmail() {
                return this.userHadEmail;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getMarketingAccepted() {
                return this.marketingAccepted;
            }

            public final ShowChangeEmailSuccessDialog copy(String email, boolean userHadEmail, boolean marketingAccepted) {
                return new ShowChangeEmailSuccessDialog(email, userHadEmail, marketingAccepted);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowChangeEmailSuccessDialog)) {
                    return false;
                }
                ShowChangeEmailSuccessDialog showChangeEmailSuccessDialog = (ShowChangeEmailSuccessDialog) other;
                return Intrinsics.areEqual(this.email, showChangeEmailSuccessDialog.email) && this.userHadEmail == showChangeEmailSuccessDialog.userHadEmail && this.marketingAccepted == showChangeEmailSuccessDialog.marketingAccepted;
            }

            public final String getEmail() {
                return this.email;
            }

            public final boolean getMarketingAccepted() {
                return this.marketingAccepted;
            }

            public final boolean getUserHadEmail() {
                return this.userHadEmail;
            }

            public int hashCode() {
                String str = this.email;
                return Boolean.hashCode(this.marketingAccepted) + b.a(this.userHadEmail, (str == null ? 0 : str.hashCode()) * 31, 31);
            }

            public String toString() {
                return "ShowChangeEmailSuccessDialog(email=" + this.email + ", userHadEmail=" + this.userHadEmail + ", marketingAccepted=" + this.marketingAccepted + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangePasswordConfirmDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChangePasswordConfirmDialog extends Effect {
            public static final ShowChangePasswordConfirmDialog INSTANCE = new ShowChangePasswordConfirmDialog();

            private ShowChangePasswordConfirmDialog() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowChangePasswordConfirmDialog);
            }

            public int hashCode() {
                return 316749760;
            }

            public String toString() {
                return "ShowChangePasswordConfirmDialog";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangePhoneConfirmDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChangePhoneConfirmDialog extends Effect {
            public static final ShowChangePhoneConfirmDialog INSTANCE = new ShowChangePhoneConfirmDialog();

            private ShowChangePhoneConfirmDialog() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowChangePhoneConfirmDialog);
            }

            public int hashCode() {
                return -165964857;
            }

            public String toString() {
                return "ShowChangePhoneConfirmDialog";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowChangePhoneSuccessDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "phone", "", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChangePhoneSuccessDialog extends Effect {
            private final String phone;

            public ShowChangePhoneSuccessDialog(String str) {
                super(null);
                this.phone = str;
            }

            public static /* synthetic */ ShowChangePhoneSuccessDialog copy$default(ShowChangePhoneSuccessDialog showChangePhoneSuccessDialog, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showChangePhoneSuccessDialog.phone;
                }
                return showChangePhoneSuccessDialog.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getPhone() {
                return this.phone;
            }

            public final ShowChangePhoneSuccessDialog copy(String phone) {
                return new ShowChangePhoneSuccessDialog(phone);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowChangePhoneSuccessDialog) && Intrinsics.areEqual(this.phone, ((ShowChangePhoneSuccessDialog) other).phone);
            }

            public final String getPhone() {
                return this.phone;
            }

            public int hashCode() {
                String str = this.phone;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ShowChangePhoneSuccessDialog(phone=" + this.phone + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowFailure copy$default(ShowFailure showFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showFailure.failure;
                }
                return showFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowFailure) && Intrinsics.areEqual(this.failure, ((ShowFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowFailure(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextStep extends Effect {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextStep(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextStep copy$default(ShowNextStep showNextStep, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = showNextStep.process;
                }
                return showNextStep.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ShowNextStep copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextStep) && Intrinsics.areEqual(this.process, ((ShowNextStep) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowNextStep(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowSocialAccountDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowSocialAccountDialog extends Effect {
            private final OauthServiceProvider serviceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowSocialAccountDialog(OauthServiceProvider serviceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                this.serviceProvider = serviceProvider;
            }

            public static /* synthetic */ ShowSocialAccountDialog copy$default(ShowSocialAccountDialog showSocialAccountDialog, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    oauthServiceProvider = showSocialAccountDialog.serviceProvider;
                }
                return showSocialAccountDialog.copy(oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public final ShowSocialAccountDialog copy(OauthServiceProvider serviceProvider) {
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                return new ShowSocialAccountDialog(serviceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowSocialAccountDialog) && this.serviceProvider == ((ShowSocialAccountDialog) other).serviceProvider;
            }

            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public int hashCode() {
                return this.serviceProvider.hashCode();
            }

            public String toString() {
                return "ShowSocialAccountDialog(serviceProvider=" + this.serviceProvider + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowSuccessMessage;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", CrashHianalyticsData.MESSAGE, "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowSuccessMessage extends Effect {
            private final String message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowSuccessMessage(String message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public static /* synthetic */ ShowSuccessMessage copy$default(ShowSuccessMessage showSuccessMessage, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showSuccessMessage.message;
                }
                return showSuccessMessage.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final ShowSuccessMessage copy(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                return new ShowSuccessMessage(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowSuccessMessage) && Intrinsics.areEqual(this.message, ((ShowSuccessMessage) other).message);
            }

            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "ShowSuccessMessage(message=" + this.message + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect$ShowUnbindSocialAccountDialog;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getServiceProvider", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowUnbindSocialAccountDialog extends Effect {
            private final OauthServiceProvider serviceProvider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowUnbindSocialAccountDialog(OauthServiceProvider serviceProvider) {
                super(null);
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                this.serviceProvider = serviceProvider;
            }

            public static /* synthetic */ ShowUnbindSocialAccountDialog copy$default(ShowUnbindSocialAccountDialog showUnbindSocialAccountDialog, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
                if ((i & 1) != 0) {
                    oauthServiceProvider = showUnbindSocialAccountDialog.serviceProvider;
                }
                return showUnbindSocialAccountDialog.copy(oauthServiceProvider);
            }

            /* renamed from: component1, reason: from getter */
            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public final ShowUnbindSocialAccountDialog copy(OauthServiceProvider serviceProvider) {
                Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
                return new ShowUnbindSocialAccountDialog(serviceProvider);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowUnbindSocialAccountDialog) && this.serviceProvider == ((ShowUnbindSocialAccountDialog) other).serviceProvider;
            }

            public final OauthServiceProvider getServiceProvider() {
                return this.serviceProvider;
            }

            public int hashCode() {
                return this.serviceProvider.hashCode();
            }

            public String toString() {
                return "ShowUnbindSocialAccountDialog(serviceProvider=" + this.serviceProvider + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "", "()V", "BindingProcess", "Content", "Error", "Init", "Loading", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$BindingProcess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Content;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Error;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Init;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Loading;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$State$BindingProcess;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "process", "Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getProcess", "()Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class BindingProcess extends State {
            private final UserAccount account;
            private final ConnectSocialAccountEnterOAuthCode process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BindingProcess(UserAccount account, ConnectSocialAccountEnterOAuthCode process) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(process, "process");
                this.account = account;
                this.process = process;
            }

            public static /* synthetic */ BindingProcess copy$default(BindingProcess bindingProcess, UserAccount userAccount, ConnectSocialAccountEnterOAuthCode connectSocialAccountEnterOAuthCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = bindingProcess.account;
                }
                if ((i & 2) != 0) {
                    connectSocialAccountEnterOAuthCode = bindingProcess.process;
                }
                return bindingProcess.copy(userAccount, connectSocialAccountEnterOAuthCode);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final ConnectSocialAccountEnterOAuthCode getProcess() {
                return this.process;
            }

            public final BindingProcess copy(UserAccount account, ConnectSocialAccountEnterOAuthCode process) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(process, "process");
                return new BindingProcess(account, process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BindingProcess)) {
                    return false;
                }
                BindingProcess bindingProcess = (BindingProcess) other;
                return Intrinsics.areEqual(this.account, bindingProcess.account) && Intrinsics.areEqual(this.process, bindingProcess.process);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final ConnectSocialAccountEnterOAuthCode getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode() + (this.account.hashCode() * 31);
            }

            public String toString() {
                return "BindingProcess(account=" + this.account + ", process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Content;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final UserAccount account;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(UserAccount account) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                this.account = account;
            }

            public static /* synthetic */ Content copy$default(Content content, UserAccount userAccount, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = content.account;
                }
                return content.copy(userAccount);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            public final Content copy(UserAccount account) {
                Intrinsics.checkNotNullParameter(account, "account");
                return new Content(account);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Content) && Intrinsics.areEqual(this.account, ((Content) other).account);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public int hashCode() {
                return this.account.hashCode();
            }

            public String toString() {
                return "Content(account=" + this.account + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Error;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Error extends State {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ Error copy$default(Error error, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = error.failure;
                }
                return error.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final Error copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Error(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.failure, ((Error) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Error(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Init;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Init extends State {
            public static final Init INSTANCE = new Init();

            private Init() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Init);
            }

            public int hashCode() {
                return 300872682;
            }

            public String toString() {
                return "Init";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Loading;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Loading extends State {
            private final UserAccount account;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(UserAccount account) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                this.account = account;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, UserAccount userAccount, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = loading.account;
                }
                return loading.copy(userAccount);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            public final Loading copy(UserAccount account) {
                Intrinsics.checkNotNullParameter(account, "account");
                return new Loading(account);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.account, ((Loading) other).account);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public int hashCode() {
                return this.account.hashCode();
            }

            public String toString() {
                return "Loading(account=" + this.account + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private PassportProfile() {
    }
}
