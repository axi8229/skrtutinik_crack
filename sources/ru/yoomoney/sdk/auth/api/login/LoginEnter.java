package ru.yoomoney.sdk.auth.api.login;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginEnter {
    public static final LoginEnter INSTANCE = new LoginEnter();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "", "()V", "CheckExpiration", "EnterIdentifierSuccess", "Expired", "LoginChanged", "LoginEnterFailure", "RestartProcess", "ShowMigrationDescriptionScreen", "Submit", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$EnterIdentifierSuccess;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$Expired;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$LoginChanged;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$LoginEnterFailure;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$ShowMigrationDescriptionScreen;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$Submit;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CheckExpiration extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CheckExpiration(String processId, OffsetDateTime expireAt) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                this.processId = processId;
                this.expireAt = expireAt;
            }

            public static /* synthetic */ CheckExpiration copy$default(CheckExpiration checkExpiration, String str, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = checkExpiration.processId;
                }
                if ((i & 2) != 0) {
                    offsetDateTime = checkExpiration.expireAt;
                }
                return checkExpiration.copy(str, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final CheckExpiration copy(String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                return new CheckExpiration(processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CheckExpiration)) {
                    return false;
                }
                CheckExpiration checkExpiration = (CheckExpiration) other;
                return Intrinsics.areEqual(this.processId, checkExpiration.processId) && Intrinsics.areEqual(this.expireAt, checkExpiration.expireAt);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public int hashCode() {
                return this.expireAt.hashCode() + (this.processId.hashCode() * 31);
            }

            public String toString() {
                return "CheckExpiration(processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$EnterIdentifierSuccess;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EnterIdentifierSuccess extends Action {
            private final LoginProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnterIdentifierSuccess(LoginProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ EnterIdentifierSuccess copy$default(EnterIdentifierSuccess enterIdentifierSuccess, LoginProcess loginProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = enterIdentifierSuccess.process;
                }
                return enterIdentifierSuccess.copy(loginProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getProcess() {
                return this.process;
            }

            public final EnterIdentifierSuccess copy(LoginProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new EnterIdentifierSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EnterIdentifierSuccess) && Intrinsics.areEqual(this.process, ((EnterIdentifierSuccess) other).process);
            }

            public final LoginProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "EnterIdentifierSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$Expired;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Expired extends Action {
            public static final Expired INSTANCE = new Expired();

            private Expired() {
                super(null);
            }

            public String toString() {
                String simpleName = Expired.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$LoginChanged;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoginChanged extends Action {
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoginChanged(String value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public static /* synthetic */ LoginChanged copy$default(LoginChanged loginChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loginChanged.value;
                }
                return loginChanged.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final LoginChanged copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new LoginChanged(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoginChanged) && Intrinsics.areEqual(this.value, ((LoginChanged) other).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "LoginChanged(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$LoginEnterFailure;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoginEnterFailure extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoginEnterFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ LoginEnterFailure copy$default(LoginEnterFailure loginEnterFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = loginEnterFailure.failure;
                }
                return loginEnterFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final LoginEnterFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new LoginEnterFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoginEnterFailure) && Intrinsics.areEqual(this.failure, ((LoginEnterFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "LoginEnterFailure(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RestartProcess extends Action {
            public static final RestartProcess INSTANCE = new RestartProcess();

            private RestartProcess() {
                super(null);
            }

            public String toString() {
                String simpleName = RestartProcess.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$ShowMigrationDescriptionScreen;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowMigrationDescriptionScreen extends Action {
            public static final ShowMigrationDescriptionScreen INSTANCE = new ShowMigrationDescriptionScreen();

            private ShowMigrationDescriptionScreen() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowMigrationDescriptionScreen.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action$Submit;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Submit extends Action {
            private final String processId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Submit(String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processId = processId;
            }

            public static /* synthetic */ Submit copy$default(Submit submit, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = submit.processId;
                }
                return submit.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final Submit copy(String processId) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new Submit(processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Submit) && Intrinsics.areEqual(this.processId, ((Submit) other).processId);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public int hashCode() {
                return this.processId.hashCode();
            }

            public String toString() {
                return "Submit(processId=" + this.processId + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;", "action", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", "", "()V", "OpenMigrationDescriptionScreen", "ResetProcess", "ShowExpireDialog", "ShowFailure", "ShowNextStep", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$OpenMigrationDescriptionScreen;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$OpenMigrationDescriptionScreen;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenMigrationDescriptionScreen extends Effect {
            public static final OpenMigrationDescriptionScreen INSTANCE = new OpenMigrationDescriptionScreen();

            private OpenMigrationDescriptionScreen() {
                super(null);
            }

            public String toString() {
                String simpleName = OpenMigrationDescriptionScreen.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ResetProcess extends Effect {
            public static final ResetProcess INSTANCE = new ResetProcess();

            private ResetProcess() {
                super(null);
            }

            public String toString() {
                String simpleName = ResetProcess.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowExpireDialog extends Effect {
            public static final ShowExpireDialog INSTANCE = new ShowExpireDialog();

            private ShowExpireDialog() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowExpireDialog.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Lru/yoomoney/sdk/auth/api/model/Failure;Ljava/lang/String;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Effect {
            private final Failure failure;
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFailure(Failure failure, String value) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                Intrinsics.checkNotNullParameter(value, "value");
                this.failure = failure;
                this.value = value;
            }

            public static /* synthetic */ ShowFailure copy$default(ShowFailure showFailure, Failure failure, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showFailure.failure;
                }
                if ((i & 2) != 0) {
                    str = showFailure.value;
                }
                return showFailure.copy(failure, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            /* renamed from: component2, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final ShowFailure copy(Failure failure, String value) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                Intrinsics.checkNotNullParameter(value, "value");
                return new ShowFailure(failure, value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowFailure)) {
                    return false;
                }
                ShowFailure showFailure = (ShowFailure) other;
                return Intrinsics.areEqual(this.failure, showFailure.failure) && Intrinsics.areEqual(this.value, showFailure.value);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode() + (this.failure.hashCode() * 31);
            }

            public String toString() {
                return "ShowFailure(failure=" + this.failure + ", value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextStep extends Effect {
            private final LoginProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextStep(LoginProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextStep copy$default(ShowNextStep showNextStep, LoginProcess loginProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = showNextStep.process;
                }
                return showNextStep.copy(loginProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getProcess() {
                return this.process;
            }

            public final ShowNextStep copy(LoginProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextStep) && Intrinsics.areEqual(this.process, ((ShowNextStep) other).process);
            }

            public final LoginProcess getProcess() {
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;", "", "()V", "Content", "Progress", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Content;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Progress;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Content;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final String value;

            public Content() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Content copy$default(Content content, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.value;
                }
                return content.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final Content copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Content(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Content) && Intrinsics.areEqual(this.value, ((Content) other).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "Content(value=" + this.value + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(String value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public /* synthetic */ Content(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Progress;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Progress extends State {
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Progress(String value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public static /* synthetic */ Progress copy$default(Progress progress, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = progress.value;
                }
                return progress.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final Progress copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Progress(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Progress) && Intrinsics.areEqual(this.value, ((Progress) other).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "Progress(value=" + this.value + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private LoginEnter() {
    }
}
