package ru.yoomoney.sdk.auth.select;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectAccount {
    public static final SelectAccount INSTANCE = new SelectAccount();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\f\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "", "()V", "CreateNewAccount", "EnrollmentSuccess", "Expired", "MigrateAccount", "PasswordRecoverySelectAccountSuccess", "RegistrationSuccess", "RestartProcess", "SelectAccount", "SelectAccountSuccess", "SendAnalyticsForScreen", "ShowContent", "ShowFailure", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$CreateNewAccount;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$EnrollmentSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$Expired;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$MigrateAccount;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$PasswordRecoverySelectAccountSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$RegistrationSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SelectAccount;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SelectAccountSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$ShowContent;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$ShowFailure;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$CreateNewAccount;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "prefilledEmail", "addToBackStack", "", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Ljava/lang/String;Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/ProcessType;)V", "getAddToBackStack", "()Z", "getPrefilledEmail", "()Ljava/lang/String;", "getProcessId", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CreateNewAccount extends Action {
            private final boolean addToBackStack;
            private final String prefilledEmail;
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateNewAccount(String processId, String str, boolean z, ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.processId = processId;
                this.prefilledEmail = str;
                this.addToBackStack = z;
                this.processType = processType;
            }

            public static /* synthetic */ CreateNewAccount copy$default(CreateNewAccount createNewAccount, String str, String str2, boolean z, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = createNewAccount.processId;
                }
                if ((i & 2) != 0) {
                    str2 = createNewAccount.prefilledEmail;
                }
                if ((i & 4) != 0) {
                    z = createNewAccount.addToBackStack;
                }
                if ((i & 8) != 0) {
                    processType = createNewAccount.processType;
                }
                return createNewAccount.copy(str, str2, z, processType);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getPrefilledEmail() {
                return this.prefilledEmail;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getAddToBackStack() {
                return this.addToBackStack;
            }

            /* renamed from: component4, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final CreateNewAccount copy(String processId, String prefilledEmail, boolean addToBackStack, ProcessType processType) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(processType, "processType");
                return new CreateNewAccount(processId, prefilledEmail, addToBackStack, processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateNewAccount)) {
                    return false;
                }
                CreateNewAccount createNewAccount = (CreateNewAccount) other;
                return Intrinsics.areEqual(this.processId, createNewAccount.processId) && Intrinsics.areEqual(this.prefilledEmail, createNewAccount.prefilledEmail) && this.addToBackStack == createNewAccount.addToBackStack && this.processType == createNewAccount.processType;
            }

            public final boolean getAddToBackStack() {
                return this.addToBackStack;
            }

            public final String getPrefilledEmail() {
                return this.prefilledEmail;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                int iHashCode = this.processId.hashCode() * 31;
                String str = this.prefilledEmail;
                return this.processType.hashCode() + ru.yoomoney.sdk.auth.b.a(this.addToBackStack, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
            }

            public String toString() {
                return "CreateNewAccount(processId=" + this.processId + ", prefilledEmail=" + this.prefilledEmail + ", addToBackStack=" + this.addToBackStack + ", processType=" + this.processType + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$EnrollmentSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "enrollmentProcess", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "(Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;)V", "getEnrollmentProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EnrollmentSuccess extends Action {
            private final EnrollmentProcess enrollmentProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnrollmentSuccess(EnrollmentProcess enrollmentProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(enrollmentProcess, "enrollmentProcess");
                this.enrollmentProcess = enrollmentProcess;
            }

            public static /* synthetic */ EnrollmentSuccess copy$default(EnrollmentSuccess enrollmentSuccess, EnrollmentProcess enrollmentProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    enrollmentProcess = enrollmentSuccess.enrollmentProcess;
                }
                return enrollmentSuccess.copy(enrollmentProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final EnrollmentProcess getEnrollmentProcess() {
                return this.enrollmentProcess;
            }

            public final EnrollmentSuccess copy(EnrollmentProcess enrollmentProcess) {
                Intrinsics.checkNotNullParameter(enrollmentProcess, "enrollmentProcess");
                return new EnrollmentSuccess(enrollmentProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EnrollmentSuccess) && Intrinsics.areEqual(this.enrollmentProcess, ((EnrollmentSuccess) other).enrollmentProcess);
            }

            public final EnrollmentProcess getEnrollmentProcess() {
                return this.enrollmentProcess;
            }

            public int hashCode() {
                return this.enrollmentProcess.hashCode();
            }

            public String toString() {
                return "EnrollmentSuccess(enrollmentProcess=" + this.enrollmentProcess + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$Expired;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$MigrateAccount;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "uid", "", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getUid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class MigrateAccount extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;
            private final String uid;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MigrateAccount(String uid, ProcessType processType, String processId, OffsetDateTime offsetDateTime) {
                super(null);
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.uid = uid;
                this.processType = processType;
                this.processId = processId;
                this.expireAt = offsetDateTime;
            }

            public static /* synthetic */ MigrateAccount copy$default(MigrateAccount migrateAccount, String str, ProcessType processType, String str2, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = migrateAccount.uid;
                }
                if ((i & 2) != 0) {
                    processType = migrateAccount.processType;
                }
                if ((i & 4) != 0) {
                    str2 = migrateAccount.processId;
                }
                if ((i & 8) != 0) {
                    offsetDateTime = migrateAccount.expireAt;
                }
                return migrateAccount.copy(str, processType, str2, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUid() {
                return this.uid;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component3, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component4, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final MigrateAccount copy(String uid, ProcessType processType, String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new MigrateAccount(uid, processType, processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MigrateAccount)) {
                    return false;
                }
                MigrateAccount migrateAccount = (MigrateAccount) other;
                return Intrinsics.areEqual(this.uid, migrateAccount.uid) && this.processType == migrateAccount.processType && Intrinsics.areEqual(this.processId, migrateAccount.processId) && Intrinsics.areEqual(this.expireAt, migrateAccount.expireAt);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final String getUid() {
                return this.uid;
            }

            public int hashCode() {
                int iA = ru.yoomoney.sdk.auth.a.a(this.processId, (this.processType.hashCode() + (this.uid.hashCode() * 31)) * 31, 31);
                OffsetDateTime offsetDateTime = this.expireAt;
                return iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode());
            }

            public String toString() {
                return "MigrateAccount(uid=" + this.uid + ", processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$PasswordRecoverySelectAccountSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "passwordRecoveryProcess", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;)V", "getPasswordRecoveryProcess", "()Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PasswordRecoverySelectAccountSuccess extends Action {
            private final PasswordRecoveryProcess passwordRecoveryProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PasswordRecoverySelectAccountSuccess(PasswordRecoveryProcess passwordRecoveryProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(passwordRecoveryProcess, "passwordRecoveryProcess");
                this.passwordRecoveryProcess = passwordRecoveryProcess;
            }

            public static /* synthetic */ PasswordRecoverySelectAccountSuccess copy$default(PasswordRecoverySelectAccountSuccess passwordRecoverySelectAccountSuccess, PasswordRecoveryProcess passwordRecoveryProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    passwordRecoveryProcess = passwordRecoverySelectAccountSuccess.passwordRecoveryProcess;
                }
                return passwordRecoverySelectAccountSuccess.copy(passwordRecoveryProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final PasswordRecoveryProcess getPasswordRecoveryProcess() {
                return this.passwordRecoveryProcess;
            }

            public final PasswordRecoverySelectAccountSuccess copy(PasswordRecoveryProcess passwordRecoveryProcess) {
                Intrinsics.checkNotNullParameter(passwordRecoveryProcess, "passwordRecoveryProcess");
                return new PasswordRecoverySelectAccountSuccess(passwordRecoveryProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PasswordRecoverySelectAccountSuccess) && Intrinsics.areEqual(this.passwordRecoveryProcess, ((PasswordRecoverySelectAccountSuccess) other).passwordRecoveryProcess);
            }

            public final PasswordRecoveryProcess getPasswordRecoveryProcess() {
                return this.passwordRecoveryProcess;
            }

            public int hashCode() {
                return this.passwordRecoveryProcess.hashCode();
            }

            public String toString() {
                return "PasswordRecoverySelectAccountSuccess(passwordRecoveryProcess=" + this.passwordRecoveryProcess + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$RegistrationSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "registrationProcess", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getRegistrationProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RegistrationSuccess extends Action {
            private final RegistrationProcess registrationProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RegistrationSuccess(RegistrationProcess registrationProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(registrationProcess, "registrationProcess");
                this.registrationProcess = registrationProcess;
            }

            public static /* synthetic */ RegistrationSuccess copy$default(RegistrationSuccess registrationSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = registrationSuccess.registrationProcess;
                }
                return registrationSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getRegistrationProcess() {
                return this.registrationProcess;
            }

            public final RegistrationSuccess copy(RegistrationProcess registrationProcess) {
                Intrinsics.checkNotNullParameter(registrationProcess, "registrationProcess");
                return new RegistrationSuccess(registrationProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RegistrationSuccess) && Intrinsics.areEqual(this.registrationProcess, ((RegistrationSuccess) other).registrationProcess);
            }

            public final RegistrationProcess getRegistrationProcess() {
                return this.registrationProcess;
            }

            public int hashCode() {
                return this.registrationProcess.hashCode();
            }

            public String toString() {
                return "RegistrationSuccess(registrationProcess=" + this.registrationProcess + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SelectAccount;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "uid", "", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getUid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SelectAccount extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;
            private final String uid;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectAccount(String uid, ProcessType processType, String processId, OffsetDateTime offsetDateTime) {
                super(null);
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.uid = uid;
                this.processType = processType;
                this.processId = processId;
                this.expireAt = offsetDateTime;
            }

            public static /* synthetic */ SelectAccount copy$default(SelectAccount selectAccount, String str, ProcessType processType, String str2, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selectAccount.uid;
                }
                if ((i & 2) != 0) {
                    processType = selectAccount.processType;
                }
                if ((i & 4) != 0) {
                    str2 = selectAccount.processId;
                }
                if ((i & 8) != 0) {
                    offsetDateTime = selectAccount.expireAt;
                }
                return selectAccount.copy(str, processType, str2, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUid() {
                return this.uid;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component3, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component4, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final SelectAccount copy(String uid, ProcessType processType, String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new SelectAccount(uid, processType, processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectAccount)) {
                    return false;
                }
                SelectAccount selectAccount = (SelectAccount) other;
                return Intrinsics.areEqual(this.uid, selectAccount.uid) && this.processType == selectAccount.processType && Intrinsics.areEqual(this.processId, selectAccount.processId) && Intrinsics.areEqual(this.expireAt, selectAccount.expireAt);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final String getUid() {
                return this.uid;
            }

            public int hashCode() {
                int iA = ru.yoomoney.sdk.auth.a.a(this.processId, (this.processType.hashCode() + (this.uid.hashCode() * 31)) * 31, 31);
                OffsetDateTime offsetDateTime = this.expireAt;
                return iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode());
            }

            public String toString() {
                return "SelectAccount(uid=" + this.uid + ", processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SelectAccountSuccess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "loginProcess", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;)V", "getLoginProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SelectAccountSuccess extends Action {
            private final LoginProcess loginProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectAccountSuccess(LoginProcess loginProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(loginProcess, "loginProcess");
                this.loginProcess = loginProcess;
            }

            public static /* synthetic */ SelectAccountSuccess copy$default(SelectAccountSuccess selectAccountSuccess, LoginProcess loginProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = selectAccountSuccess.loginProcess;
                }
                return selectAccountSuccess.copy(loginProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getLoginProcess() {
                return this.loginProcess;
            }

            public final SelectAccountSuccess copy(LoginProcess loginProcess) {
                Intrinsics.checkNotNullParameter(loginProcess, "loginProcess");
                return new SelectAccountSuccess(loginProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectAccountSuccess) && Intrinsics.areEqual(this.loginProcess, ((SelectAccountSuccess) other).loginProcess);
            }

            public final LoginProcess getLoginProcess() {
                return this.loginProcess;
            }

            public int hashCode() {
                return this.loginProcess.hashCode();
            }

            public String toString() {
                return "SelectAccountSuccess(loginProcess=" + this.loginProcess + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendAnalyticsForScreen extends Action {
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendAnalyticsForScreen(ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.processType = processType;
            }

            public static /* synthetic */ SendAnalyticsForScreen copy$default(SendAnalyticsForScreen sendAnalyticsForScreen, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = sendAnalyticsForScreen.processType;
                }
                return sendAnalyticsForScreen.copy(processType);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final SendAnalyticsForScreen copy(ProcessType processType) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                return new SendAnalyticsForScreen(processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendAnalyticsForScreen) && this.processType == ((SendAnalyticsForScreen) other).processType;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.processType.hashCode();
            }

            public String toString() {
                return "SendAnalyticsForScreen(processType=" + this.processType + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$ShowContent;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowContent extends Action {
            public static final ShowContent INSTANCE = new ShowContent();

            private ShowContent() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowContent.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Action$ShowFailure;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Action {
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

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/select/SelectAccount$State;", "action", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "", "()V", "ResetProcess", "ShowEnrollmentStep", "ShowExpireDialog", "ShowFailure", "ShowLoginStep", "ShowMigrationStep", "ShowPasswordRecoveryStep", "ShowRegistrationStep", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowEnrollmentStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowLoginStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowMigrationStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowPasswordRecoveryStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowRegistrationStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowEnrollmentStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "enrollmentProcess", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "(Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;)V", "getEnrollmentProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowEnrollmentStep extends Effect {
            private final EnrollmentProcess enrollmentProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowEnrollmentStep(EnrollmentProcess enrollmentProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(enrollmentProcess, "enrollmentProcess");
                this.enrollmentProcess = enrollmentProcess;
            }

            public static /* synthetic */ ShowEnrollmentStep copy$default(ShowEnrollmentStep showEnrollmentStep, EnrollmentProcess enrollmentProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    enrollmentProcess = showEnrollmentStep.enrollmentProcess;
                }
                return showEnrollmentStep.copy(enrollmentProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final EnrollmentProcess getEnrollmentProcess() {
                return this.enrollmentProcess;
            }

            public final ShowEnrollmentStep copy(EnrollmentProcess enrollmentProcess) {
                Intrinsics.checkNotNullParameter(enrollmentProcess, "enrollmentProcess");
                return new ShowEnrollmentStep(enrollmentProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowEnrollmentStep) && Intrinsics.areEqual(this.enrollmentProcess, ((ShowEnrollmentStep) other).enrollmentProcess);
            }

            public final EnrollmentProcess getEnrollmentProcess() {
                return this.enrollmentProcess;
            }

            public int hashCode() {
                return this.enrollmentProcess.hashCode();
            }

            public String toString() {
                return "ShowEnrollmentStep(enrollmentProcess=" + this.enrollmentProcess + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowLoginStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "loginProcess", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;)V", "getLoginProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowLoginStep extends Effect {
            private final LoginProcess loginProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowLoginStep(LoginProcess loginProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(loginProcess, "loginProcess");
                this.loginProcess = loginProcess;
            }

            public static /* synthetic */ ShowLoginStep copy$default(ShowLoginStep showLoginStep, LoginProcess loginProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = showLoginStep.loginProcess;
                }
                return showLoginStep.copy(loginProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getLoginProcess() {
                return this.loginProcess;
            }

            public final ShowLoginStep copy(LoginProcess loginProcess) {
                Intrinsics.checkNotNullParameter(loginProcess, "loginProcess");
                return new ShowLoginStep(loginProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowLoginStep) && Intrinsics.areEqual(this.loginProcess, ((ShowLoginStep) other).loginProcess);
            }

            public final LoginProcess getLoginProcess() {
                return this.loginProcess;
            }

            public int hashCode() {
                return this.loginProcess.hashCode();
            }

            public String toString() {
                return "ShowLoginStep(loginProcess=" + this.loginProcess + ")";
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowMigrationStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "uid", "", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getUid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowMigrationStep extends Effect {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;
            private final String uid;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowMigrationStep(String uid, ProcessType processType, String processId, OffsetDateTime offsetDateTime) {
                super(null);
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.uid = uid;
                this.processType = processType;
                this.processId = processId;
                this.expireAt = offsetDateTime;
            }

            public static /* synthetic */ ShowMigrationStep copy$default(ShowMigrationStep showMigrationStep, String str, ProcessType processType, String str2, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showMigrationStep.uid;
                }
                if ((i & 2) != 0) {
                    processType = showMigrationStep.processType;
                }
                if ((i & 4) != 0) {
                    str2 = showMigrationStep.processId;
                }
                if ((i & 8) != 0) {
                    offsetDateTime = showMigrationStep.expireAt;
                }
                return showMigrationStep.copy(str, processType, str2, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUid() {
                return this.uid;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component3, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component4, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final ShowMigrationStep copy(String uid, ProcessType processType, String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new ShowMigrationStep(uid, processType, processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowMigrationStep)) {
                    return false;
                }
                ShowMigrationStep showMigrationStep = (ShowMigrationStep) other;
                return Intrinsics.areEqual(this.uid, showMigrationStep.uid) && this.processType == showMigrationStep.processType && Intrinsics.areEqual(this.processId, showMigrationStep.processId) && Intrinsics.areEqual(this.expireAt, showMigrationStep.expireAt);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final String getUid() {
                return this.uid;
            }

            public int hashCode() {
                int iA = ru.yoomoney.sdk.auth.a.a(this.processId, (this.processType.hashCode() + (this.uid.hashCode() * 31)) * 31, 31);
                OffsetDateTime offsetDateTime = this.expireAt;
                return iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode());
            }

            public String toString() {
                return "ShowMigrationStep(uid=" + this.uid + ", processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowPasswordRecoveryStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "passwordRecoveryProcess", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;)V", "getPasswordRecoveryProcess", "()Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowPasswordRecoveryStep extends Effect {
            private final PasswordRecoveryProcess passwordRecoveryProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowPasswordRecoveryStep(PasswordRecoveryProcess passwordRecoveryProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(passwordRecoveryProcess, "passwordRecoveryProcess");
                this.passwordRecoveryProcess = passwordRecoveryProcess;
            }

            public static /* synthetic */ ShowPasswordRecoveryStep copy$default(ShowPasswordRecoveryStep showPasswordRecoveryStep, PasswordRecoveryProcess passwordRecoveryProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    passwordRecoveryProcess = showPasswordRecoveryStep.passwordRecoveryProcess;
                }
                return showPasswordRecoveryStep.copy(passwordRecoveryProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final PasswordRecoveryProcess getPasswordRecoveryProcess() {
                return this.passwordRecoveryProcess;
            }

            public final ShowPasswordRecoveryStep copy(PasswordRecoveryProcess passwordRecoveryProcess) {
                Intrinsics.checkNotNullParameter(passwordRecoveryProcess, "passwordRecoveryProcess");
                return new ShowPasswordRecoveryStep(passwordRecoveryProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowPasswordRecoveryStep) && Intrinsics.areEqual(this.passwordRecoveryProcess, ((ShowPasswordRecoveryStep) other).passwordRecoveryProcess);
            }

            public final PasswordRecoveryProcess getPasswordRecoveryProcess() {
                return this.passwordRecoveryProcess;
            }

            public int hashCode() {
                return this.passwordRecoveryProcess.hashCode();
            }

            public String toString() {
                return "ShowPasswordRecoveryStep(passwordRecoveryProcess=" + this.passwordRecoveryProcess + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$Effect$ShowRegistrationStep;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "registrationProcess", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getRegistrationProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowRegistrationStep extends Effect {
            private final RegistrationProcess registrationProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowRegistrationStep(RegistrationProcess registrationProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(registrationProcess, "registrationProcess");
                this.registrationProcess = registrationProcess;
            }

            public static /* synthetic */ ShowRegistrationStep copy$default(ShowRegistrationStep showRegistrationStep, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = showRegistrationStep.registrationProcess;
                }
                return showRegistrationStep.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getRegistrationProcess() {
                return this.registrationProcess;
            }

            public final ShowRegistrationStep copy(RegistrationProcess registrationProcess) {
                Intrinsics.checkNotNullParameter(registrationProcess, "registrationProcess");
                return new ShowRegistrationStep(registrationProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowRegistrationStep) && Intrinsics.areEqual(this.registrationProcess, ((ShowRegistrationStep) other).registrationProcess);
            }

            public final RegistrationProcess getRegistrationProcess() {
                return this.registrationProcess;
            }

            public int hashCode() {
                return this.registrationProcess.hashCode();
            }

            public String toString() {
                return "ShowRegistrationStep(registrationProcess=" + this.registrationProcess + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$State;", "", "()V", "Content", "Lru/yoomoney/sdk/auth/select/SelectAccount$State$Content;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccount$State$Content;", "Lru/yoomoney/sdk/auth/select/SelectAccount$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Content extends State {
            public static final Content INSTANCE = new Content();

            private Content() {
                super(null);
            }

            public String toString() {
                String simpleName = Content.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private SelectAccount() {
    }
}
