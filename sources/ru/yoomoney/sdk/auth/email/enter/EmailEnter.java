package ru.yoomoney.sdk.auth.email.enter;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.b;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailEnter {
    public static final EmailEnter INSTANCE = new EmailEnter();

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000e\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u000e\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "", "()V", "ChangeEmail", "CheckExpiration", "ConfirmEmail", "ConfirmEmailSuccess", "EmailChanged", "Expired", "OffersChecked", "RestartProcess", "SendAnalyticsForScreen", "SendAnalyticsFromTwoFa", "SendEmail", "SendEmailRegistrationSuccess", "SendEmailSuccess", "ShowFailure", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ChangeEmail;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ConfirmEmail;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ConfirmEmailSuccess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$EmailChanged;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$Expired;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$OffersChecked;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendAnalyticsFromTwoFa;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmailRegistrationSuccess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmailSuccess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ShowFailure;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ChangeEmail;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", Scopes.EMAIL, "", "(Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChangeEmail extends Action {
            private final String email;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChangeEmail(String email) {
                super(null);
                Intrinsics.checkNotNullParameter(email, "email");
                this.email = email;
            }

            public static /* synthetic */ ChangeEmail copy$default(ChangeEmail changeEmail, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = changeEmail.email;
                }
                return changeEmail.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getEmail() {
                return this.email;
            }

            public final ChangeEmail copy(String email) {
                Intrinsics.checkNotNullParameter(email, "email");
                return new ChangeEmail(email);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeEmail) && Intrinsics.areEqual(this.email, ((ChangeEmail) other).email);
            }

            public final String getEmail() {
                return this.email;
            }

            public int hashCode() {
                return this.email.hashCode();
            }

            public String toString() {
                return "ChangeEmail(email=" + this.email + ")";
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CheckExpiration extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CheckExpiration(ProcessType processType, String processId, OffsetDateTime offsetDateTime) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
                this.expireAt = offsetDateTime;
            }

            public static /* synthetic */ CheckExpiration copy$default(CheckExpiration checkExpiration, ProcessType processType, String str, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = checkExpiration.processType;
                }
                if ((i & 2) != 0) {
                    str = checkExpiration.processId;
                }
                if ((i & 4) != 0) {
                    offsetDateTime = checkExpiration.expireAt;
                }
                return checkExpiration.copy(processType, str, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component3, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final CheckExpiration copy(ProcessType processType, String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new CheckExpiration(processType, processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CheckExpiration)) {
                    return false;
                }
                CheckExpiration checkExpiration = (CheckExpiration) other;
                return this.processType == checkExpiration.processType && Intrinsics.areEqual(this.processId, checkExpiration.processId) && Intrinsics.areEqual(this.expireAt, checkExpiration.expireAt);
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

            public int hashCode() {
                int iA = a.a(this.processId, this.processType.hashCode() * 31, 31);
                OffsetDateTime offsetDateTime = this.expireAt;
                return iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode());
            }

            public String toString() {
                return "CheckExpiration(processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ConfirmEmail;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmEmail extends Action {
            private final String processId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmEmail(String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processId = processId;
            }

            public static /* synthetic */ ConfirmEmail copy$default(ConfirmEmail confirmEmail, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = confirmEmail.processId;
                }
                return confirmEmail.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final ConfirmEmail copy(String processId) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new ConfirmEmail(processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmEmail) && Intrinsics.areEqual(this.processId, ((ConfirmEmail) other).processId);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public int hashCode() {
                return this.processId.hashCode();
            }

            public String toString() {
                return "ConfirmEmail(processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ConfirmEmailSuccess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmEmailSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmEmailSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ConfirmEmailSuccess copy$default(ConfirmEmailSuccess confirmEmailSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = confirmEmailSuccess.process;
                }
                return confirmEmailSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final ConfirmEmailSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ConfirmEmailSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmEmailSuccess) && Intrinsics.areEqual(this.process, ((ConfirmEmailSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ConfirmEmailSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$EmailChanged;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", Scopes.EMAIL, "", "isValidEmail", "", "(Ljava/lang/String;Z)V", "getEmail", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EmailChanged extends Action {
            private final String email;
            private final boolean isValidEmail;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmailChanged(String email, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(email, "email");
                this.email = email;
                this.isValidEmail = z;
            }

            public static /* synthetic */ EmailChanged copy$default(EmailChanged emailChanged, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = emailChanged.email;
                }
                if ((i & 2) != 0) {
                    z = emailChanged.isValidEmail;
                }
                return emailChanged.copy(str, z);
            }

            /* renamed from: component1, reason: from getter */
            public final String getEmail() {
                return this.email;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsValidEmail() {
                return this.isValidEmail;
            }

            public final EmailChanged copy(String email, boolean isValidEmail) {
                Intrinsics.checkNotNullParameter(email, "email");
                return new EmailChanged(email, isValidEmail);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmailChanged)) {
                    return false;
                }
                EmailChanged emailChanged = (EmailChanged) other;
                return Intrinsics.areEqual(this.email, emailChanged.email) && this.isValidEmail == emailChanged.isValidEmail;
            }

            public final String getEmail() {
                return this.email;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isValidEmail) + (this.email.hashCode() * 31);
            }

            public final boolean isValidEmail() {
                return this.isValidEmail;
            }

            public String toString() {
                return "EmailChanged(email=" + this.email + ", isValidEmail=" + this.isValidEmail + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$Expired;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$OffersChecked;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "isChecked", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class OffersChecked extends Action {
            private final boolean isChecked;

            public OffersChecked(boolean z) {
                super(null);
                this.isChecked = z;
            }

            public static /* synthetic */ OffersChecked copy$default(OffersChecked offersChecked, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = offersChecked.isChecked;
                }
                return offersChecked.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsChecked() {
                return this.isChecked;
            }

            public final OffersChecked copy(boolean isChecked) {
                return new OffersChecked(isChecked);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OffersChecked) && this.isChecked == ((OffersChecked) other).isChecked;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isChecked);
            }

            public final boolean isChecked() {
                return this.isChecked;
            }

            public String toString() {
                return "OffersChecked(isChecked=" + this.isChecked + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendAnalyticsFromTwoFa;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendAnalyticsFromTwoFa extends Action {
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendAnalyticsFromTwoFa(ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.processType = processType;
            }

            public static /* synthetic */ SendAnalyticsFromTwoFa copy$default(SendAnalyticsFromTwoFa sendAnalyticsFromTwoFa, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = sendAnalyticsFromTwoFa.processType;
                }
                return sendAnalyticsFromTwoFa.copy(processType);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final SendAnalyticsFromTwoFa copy(ProcessType processType) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                return new SendAnalyticsFromTwoFa(processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendAnalyticsFromTwoFa) && this.processType == ((SendAnalyticsFromTwoFa) other).processType;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.processType.hashCode();
            }

            public String toString() {
                return "SendAnalyticsFromTwoFa(processType=" + this.processType + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendEmail extends Action {
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendEmail(ProcessType processType, String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
            }

            public static /* synthetic */ SendEmail copy$default(SendEmail sendEmail, ProcessType processType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = sendEmail.processType;
                }
                if ((i & 2) != 0) {
                    str = sendEmail.processId;
                }
                return sendEmail.copy(processType, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final SendEmail copy(ProcessType processType, String processId) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new SendEmail(processType, processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SendEmail)) {
                    return false;
                }
                SendEmail sendEmail = (SendEmail) other;
                return this.processType == sendEmail.processType && Intrinsics.areEqual(this.processId, sendEmail.processId);
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
                return "SendEmail(processType=" + this.processType + ", processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmailRegistrationSuccess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendEmailRegistrationSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendEmailRegistrationSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ SendEmailRegistrationSuccess copy$default(SendEmailRegistrationSuccess sendEmailRegistrationSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = sendEmailRegistrationSuccess.process;
                }
                return sendEmailRegistrationSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final SendEmailRegistrationSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new SendEmailRegistrationSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendEmailRegistrationSuccess) && Intrinsics.areEqual(this.process, ((SendEmailRegistrationSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "SendEmailRegistrationSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmailSuccess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendEmailSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendEmailSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ SendEmailSuccess copy$default(SendEmailSuccess sendEmailSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = sendEmailSuccess.process;
                }
                return sendEmailSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final SendEmailSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new SendEmailSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendEmailSuccess) && Intrinsics.areEqual(this.process, ((SendEmailSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "SendEmailSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$ShowFailure;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;", "action", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", "", "()V", "ResetProcess", "ShowExpireDialog", "ShowFailure", "ShowNextRegistrationStep", "ShowNextStep", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowNextRegistrationStep;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowNextRegistrationStep;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;", "", "()V", "Content", "Loading", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Content;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Loading;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Content;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;", Scopes.EMAIL, "", "emailIsValid", "", "offersIsChecked", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "(Ljava/lang/String;ZZLru/yoomoney/sdk/auth/api/model/ProcessError;)V", "getEmail", "()Ljava/lang/String;", "getEmailIsValid", "()Z", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "getOffersIsChecked", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final String email;
            private final boolean emailIsValid;
            private final ProcessError error;
            private final boolean offersIsChecked;

            public Content() {
                this(null, false, false, null, 15, null);
            }

            public static /* synthetic */ Content copy$default(Content content, String str, boolean z, boolean z2, ProcessError processError, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.email;
                }
                if ((i & 2) != 0) {
                    z = content.emailIsValid;
                }
                if ((i & 4) != 0) {
                    z2 = content.offersIsChecked;
                }
                if ((i & 8) != 0) {
                    processError = content.error;
                }
                return content.copy(str, z, z2, processError);
            }

            /* renamed from: component1, reason: from getter */
            public final String getEmail() {
                return this.email;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getEmailIsValid() {
                return this.emailIsValid;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            /* renamed from: component4, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            public final Content copy(String email, boolean emailIsValid, boolean offersIsChecked, ProcessError error) {
                Intrinsics.checkNotNullParameter(email, "email");
                return new Content(email, emailIsValid, offersIsChecked, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.email, content.email) && this.emailIsValid == content.emailIsValid && this.offersIsChecked == content.offersIsChecked && Intrinsics.areEqual(this.error, content.error);
            }

            public final String getEmail() {
                return this.email;
            }

            public final boolean getEmailIsValid() {
                return this.emailIsValid;
            }

            public final ProcessError getError() {
                return this.error;
            }

            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public int hashCode() {
                int iA = b.a(this.offersIsChecked, b.a(this.emailIsValid, this.email.hashCode() * 31, 31), 31);
                ProcessError processError = this.error;
                return iA + (processError == null ? 0 : processError.hashCode());
            }

            public String toString() {
                return "Content(email=" + this.email + ", emailIsValid=" + this.emailIsValid + ", offersIsChecked=" + this.offersIsChecked + ", error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(String email, boolean z, boolean z2, ProcessError processError) {
                super(null);
                Intrinsics.checkNotNullParameter(email, "email");
                this.email = email;
                this.emailIsValid = z;
                this.offersIsChecked = z2;
                this.error = processError;
            }

            public /* synthetic */ Content(String str, boolean z, boolean z2, ProcessError processError, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : processError);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Loading;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;", "content", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Content;", "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Content;)V", "getContent", "()Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Content;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Loading extends State {
            private final Content content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(Content content) {
                super(null);
                Intrinsics.checkNotNullParameter(content, "content");
                this.content = content;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, Content content, int i, Object obj) {
                if ((i & 1) != 0) {
                    content = loading.content;
                }
                return loading.copy(content);
            }

            /* renamed from: component1, reason: from getter */
            public final Content getContent() {
                return this.content;
            }

            public final Loading copy(Content content) {
                Intrinsics.checkNotNullParameter(content, "content");
                return new Loading(content);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.content, ((Loading) other).content);
            }

            public final Content getContent() {
                return this.content;
            }

            public int hashCode() {
                return this.content.hashCode();
            }

            public String toString() {
                return "Loading(content=" + this.content + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private EmailEnter() {
    }
}
