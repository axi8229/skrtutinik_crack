package ru.yoomoney.sdk.auth.finishing.success;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingSuccess {
    public static final AuthFinishingSuccess INSTANCE = new AuthFinishingSuccess();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "", "()V", "FailAccount", "FailAcquire", "LoadAccount", "LoadAcquire", "LoadAppInfo", "NextRegistrationStep", "NextStep", "SuccessAccount", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$FailAccount;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$FailAcquire;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAccount;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAcquire;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAppInfo;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$NextRegistrationStep;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$NextStep;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$SuccessAccount;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$FailAccount;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getAccessToken", "()Ljava/lang/String;", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FailAccount extends Action {
            private final String accessToken;
            private final Failure failure;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailAccount(ProcessType processType, String accessToken, Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.processType = processType;
                this.accessToken = accessToken;
                this.failure = failure;
            }

            public static /* synthetic */ FailAccount copy$default(FailAccount failAccount, ProcessType processType, String str, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = failAccount.processType;
                }
                if ((i & 2) != 0) {
                    str = failAccount.accessToken;
                }
                if ((i & 4) != 0) {
                    failure = failAccount.failure;
                }
                return failAccount.copy(processType, str, failure);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getAccessToken() {
                return this.accessToken;
            }

            /* renamed from: component3, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final FailAccount copy(ProcessType processType, String accessToken, Failure failure) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new FailAccount(processType, accessToken, failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FailAccount)) {
                    return false;
                }
                FailAccount failAccount = (FailAccount) other;
                return this.processType == failAccount.processType && Intrinsics.areEqual(this.accessToken, failAccount.accessToken) && Intrinsics.areEqual(this.failure, failAccount.failure);
            }

            public final String getAccessToken() {
                return this.accessToken;
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.failure.hashCode() + a.a(this.accessToken, this.processType.hashCode() * 31, 31);
            }

            public String toString() {
                return "FailAccount(processType=" + this.processType + ", accessToken=" + this.accessToken + ", failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$FailAcquire;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FailAcquire extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailAcquire(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ FailAcquire copy$default(FailAcquire failAcquire, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = failAcquire.failure;
                }
                return failAcquire.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final FailAcquire copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new FailAcquire(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FailAcquire) && Intrinsics.areEqual(this.failure, ((FailAcquire) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "FailAcquire(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAccount;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "bindSocialAccountResult", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;)V", "getAccessToken", "()Ljava/lang/String;", "getBindSocialAccountResult", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadAccount extends Action {
            private final String accessToken;
            private final BindSocialAccountResult bindSocialAccountResult;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadAccount(ProcessType processType, String accessToken, BindSocialAccountResult bindSocialAccountResult) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                this.processType = processType;
                this.accessToken = accessToken;
                this.bindSocialAccountResult = bindSocialAccountResult;
            }

            public static /* synthetic */ LoadAccount copy$default(LoadAccount loadAccount, ProcessType processType, String str, BindSocialAccountResult bindSocialAccountResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = loadAccount.processType;
                }
                if ((i & 2) != 0) {
                    str = loadAccount.accessToken;
                }
                if ((i & 4) != 0) {
                    bindSocialAccountResult = loadAccount.bindSocialAccountResult;
                }
                return loadAccount.copy(processType, str, bindSocialAccountResult);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getAccessToken() {
                return this.accessToken;
            }

            /* renamed from: component3, reason: from getter */
            public final BindSocialAccountResult getBindSocialAccountResult() {
                return this.bindSocialAccountResult;
            }

            public final LoadAccount copy(ProcessType processType, String accessToken, BindSocialAccountResult bindSocialAccountResult) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                return new LoadAccount(processType, accessToken, bindSocialAccountResult);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadAccount)) {
                    return false;
                }
                LoadAccount loadAccount = (LoadAccount) other;
                return this.processType == loadAccount.processType && Intrinsics.areEqual(this.accessToken, loadAccount.accessToken) && Intrinsics.areEqual(this.bindSocialAccountResult, loadAccount.bindSocialAccountResult);
            }

            public final String getAccessToken() {
                return this.accessToken;
            }

            public final BindSocialAccountResult getBindSocialAccountResult() {
                return this.bindSocialAccountResult;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                int iA = a.a(this.accessToken, this.processType.hashCode() * 31, 31);
                BindSocialAccountResult bindSocialAccountResult = this.bindSocialAccountResult;
                return iA + (bindSocialAccountResult == null ? 0 : bindSocialAccountResult.hashCode());
            }

            public String toString() {
                return "LoadAccount(processType=" + this.processType + ", accessToken=" + this.accessToken + ", bindSocialAccountResult=" + this.bindSocialAccountResult + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAcquire;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadAcquire extends Action {
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadAcquire(ProcessType processType, String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
            }

            public static /* synthetic */ LoadAcquire copy$default(LoadAcquire loadAcquire, ProcessType processType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = loadAcquire.processType;
                }
                if ((i & 2) != 0) {
                    str = loadAcquire.processId;
                }
                return loadAcquire.copy(processType, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final LoadAcquire copy(ProcessType processType, String processId) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new LoadAcquire(processType, processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadAcquire)) {
                    return false;
                }
                LoadAcquire loadAcquire = (LoadAcquire) other;
                return this.processType == loadAcquire.processType && Intrinsics.areEqual(this.processId, loadAcquire.processId);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.processId.hashCode() + (this.processType.hashCode() * 31);
            }

            public String toString() {
                return "LoadAcquire(processType=" + this.processType + ", processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAppInfo;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "(Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;)V", "getApplicationInfo", "()Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadAppInfo extends Action {
            private final ApplicationInfo applicationInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadAppInfo(ApplicationInfo applicationInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                this.applicationInfo = applicationInfo;
            }

            public static /* synthetic */ LoadAppInfo copy$default(LoadAppInfo loadAppInfo, ApplicationInfo applicationInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    applicationInfo = loadAppInfo.applicationInfo;
                }
                return loadAppInfo.copy(applicationInfo);
            }

            /* renamed from: component1, reason: from getter */
            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public final LoadAppInfo copy(ApplicationInfo applicationInfo) {
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                return new LoadAppInfo(applicationInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadAppInfo) && Intrinsics.areEqual(this.applicationInfo, ((LoadAppInfo) other).applicationInfo);
            }

            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public int hashCode() {
                return this.applicationInfo.hashCode();
            }

            public String toString() {
                return "LoadAppInfo(applicationInfo=" + this.applicationInfo + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$NextRegistrationStep;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NextRegistrationStep extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NextRegistrationStep(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ NextRegistrationStep copy$default(NextRegistrationStep nextRegistrationStep, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = nextRegistrationStep.process;
                }
                return nextRegistrationStep.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final NextRegistrationStep copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new NextRegistrationStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NextRegistrationStep) && Intrinsics.areEqual(this.process, ((NextRegistrationStep) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "NextRegistrationStep(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$NextStep;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NextStep extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NextStep(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ NextStep copy$default(NextStep nextStep, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = nextStep.process;
                }
                return nextStep.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final NextStep copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new NextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NextStep) && Intrinsics.areEqual(this.process, ((NextStep) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "NextStep(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$SuccessAccount;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", YooMoneyAuth.KEY_USER_ACCOUNT, "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "bindSocialAccountResult", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;)V", "getAccessToken", "()Ljava/lang/String;", "getBindSocialAccountResult", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getUserAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SuccessAccount extends Action {
            private final String accessToken;
            private final BindSocialAccountResult bindSocialAccountResult;
            private final ProcessType processType;
            private final UserAccount userAccount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuccessAccount(ProcessType processType, String accessToken, UserAccount userAccount, BindSocialAccountResult bindSocialAccountResult) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                this.processType = processType;
                this.accessToken = accessToken;
                this.userAccount = userAccount;
                this.bindSocialAccountResult = bindSocialAccountResult;
            }

            public static /* synthetic */ SuccessAccount copy$default(SuccessAccount successAccount, ProcessType processType, String str, UserAccount userAccount, BindSocialAccountResult bindSocialAccountResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = successAccount.processType;
                }
                if ((i & 2) != 0) {
                    str = successAccount.accessToken;
                }
                if ((i & 4) != 0) {
                    userAccount = successAccount.userAccount;
                }
                if ((i & 8) != 0) {
                    bindSocialAccountResult = successAccount.bindSocialAccountResult;
                }
                return successAccount.copy(processType, str, userAccount, bindSocialAccountResult);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getAccessToken() {
                return this.accessToken;
            }

            /* renamed from: component3, reason: from getter */
            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            /* renamed from: component4, reason: from getter */
            public final BindSocialAccountResult getBindSocialAccountResult() {
                return this.bindSocialAccountResult;
            }

            public final SuccessAccount copy(ProcessType processType, String accessToken, UserAccount userAccount, BindSocialAccountResult bindSocialAccountResult) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                return new SuccessAccount(processType, accessToken, userAccount, bindSocialAccountResult);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuccessAccount)) {
                    return false;
                }
                SuccessAccount successAccount = (SuccessAccount) other;
                return this.processType == successAccount.processType && Intrinsics.areEqual(this.accessToken, successAccount.accessToken) && Intrinsics.areEqual(this.userAccount, successAccount.userAccount) && Intrinsics.areEqual(this.bindSocialAccountResult, successAccount.bindSocialAccountResult);
            }

            public final String getAccessToken() {
                return this.accessToken;
            }

            public final BindSocialAccountResult getBindSocialAccountResult() {
                return this.bindSocialAccountResult;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            public int hashCode() {
                int iHashCode = (this.userAccount.hashCode() + a.a(this.accessToken, this.processType.hashCode() * 31, 31)) * 31;
                BindSocialAccountResult bindSocialAccountResult = this.bindSocialAccountResult;
                return iHashCode + (bindSocialAccountResult == null ? 0 : bindSocialAccountResult.hashCode());
            }

            public String toString() {
                return "SuccessAccount(processType=" + this.processType + ", accessToken=" + this.accessToken + ", userAccount=" + this.userAccount + ", bindSocialAccountResult=" + this.bindSocialAccountResult + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", "action", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect;", "", "()V", "Finish", "ShowNextRegistrationStep", "ShowNextStep", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect$Finish;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect$ShowNextRegistrationStep;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect$Finish;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", YooMoneyAuth.KEY_USER_ACCOUNT, "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/model/UserAccount;)V", "getAccessToken", "()Ljava/lang/String;", "getUserAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Finish extends Effect {
            private final String accessToken;
            private final UserAccount userAccount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Finish(String accessToken, UserAccount userAccount) {
                super(null);
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                this.accessToken = accessToken;
                this.userAccount = userAccount;
            }

            public static /* synthetic */ Finish copy$default(Finish finish, String str, UserAccount userAccount, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = finish.accessToken;
                }
                if ((i & 2) != 0) {
                    userAccount = finish.userAccount;
                }
                return finish.copy(str, userAccount);
            }

            /* renamed from: component1, reason: from getter */
            public final String getAccessToken() {
                return this.accessToken;
            }

            /* renamed from: component2, reason: from getter */
            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            public final Finish copy(String accessToken, UserAccount userAccount) {
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                return new Finish(accessToken, userAccount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Finish)) {
                    return false;
                }
                Finish finish = (Finish) other;
                return Intrinsics.areEqual(this.accessToken, finish.accessToken) && Intrinsics.areEqual(this.userAccount, finish.userAccount);
            }

            public final String getAccessToken() {
                return this.accessToken;
            }

            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            public int hashCode() {
                return this.userAccount.hashCode() + (this.accessToken.hashCode() * 31);
            }

            public String toString() {
                return "Finish(accessToken=" + this.accessToken + ", userAccount=" + this.userAccount + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect$ShowNextRegistrationStep;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextRegistrationStep extends Effect {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextRegistrationStep(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextRegistrationStep copy$default(ShowNextRegistrationStep showNextRegistrationStep, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = showNextRegistrationStep.process;
                }
                return showNextRegistrationStep.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final ShowNextRegistrationStep copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextRegistrationStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextRegistrationStep) && Intrinsics.areEqual(this.process, ((ShowNextRegistrationStep) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowNextRegistrationStep(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", "", "()V", "Content", "ErrorAccount", "ErrorAcquire", "Progress", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Content;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAccount;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAcquire;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Progress;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Content;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "(Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;)V", "getApplicationInfo", "()Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final ApplicationInfo applicationInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(ApplicationInfo applicationInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                this.applicationInfo = applicationInfo;
            }

            public static /* synthetic */ Content copy$default(Content content, ApplicationInfo applicationInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    applicationInfo = content.applicationInfo;
                }
                return content.copy(applicationInfo);
            }

            /* renamed from: component1, reason: from getter */
            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public final Content copy(ApplicationInfo applicationInfo) {
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                return new Content(applicationInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Content) && Intrinsics.areEqual(this.applicationInfo, ((Content) other).applicationInfo);
            }

            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public int hashCode() {
                return this.applicationInfo.hashCode();
            }

            public String toString() {
                return "Content(applicationInfo=" + this.applicationInfo + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAccount;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getAccessToken", "()Ljava/lang/String;", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ErrorAccount extends State {
            private final String accessToken;
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ErrorAccount(String accessToken, Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.accessToken = accessToken;
                this.failure = failure;
            }

            public static /* synthetic */ ErrorAccount copy$default(ErrorAccount errorAccount, String str, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorAccount.accessToken;
                }
                if ((i & 2) != 0) {
                    failure = errorAccount.failure;
                }
                return errorAccount.copy(str, failure);
            }

            /* renamed from: component1, reason: from getter */
            public final String getAccessToken() {
                return this.accessToken;
            }

            /* renamed from: component2, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ErrorAccount copy(String accessToken, Failure failure) {
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ErrorAccount(accessToken, failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorAccount)) {
                    return false;
                }
                ErrorAccount errorAccount = (ErrorAccount) other;
                return Intrinsics.areEqual(this.accessToken, errorAccount.accessToken) && Intrinsics.areEqual(this.failure, errorAccount.failure);
            }

            public final String getAccessToken() {
                return this.accessToken;
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode() + (this.accessToken.hashCode() * 31);
            }

            public String toString() {
                return "ErrorAccount(accessToken=" + this.accessToken + ", failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAcquire;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ErrorAcquire extends State {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ErrorAcquire(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ErrorAcquire copy$default(ErrorAcquire errorAcquire, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = errorAcquire.failure;
                }
                return errorAcquire.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ErrorAcquire copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ErrorAcquire(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ErrorAcquire) && Intrinsics.areEqual(this.failure, ((ErrorAcquire) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ErrorAcquire(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Progress;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Progress extends State {
            public static final Progress INSTANCE = new Progress();

            private Progress() {
                super(null);
            }

            public String toString() {
                return Progress.class.getSimpleName();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private AuthFinishingSuccess() {
    }
}
