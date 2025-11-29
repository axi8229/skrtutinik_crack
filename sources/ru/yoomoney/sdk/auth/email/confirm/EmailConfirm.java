package ru.yoomoney.sdk.auth.email.confirm;

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
import ru.yoomoney.sdk.auth.b;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailConfirm {
    public static final EmailConfirm INSTANCE = new EmailConfirm();

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0012\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&¨\u0006'"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "", "()V", "CheckExpiration", "CodeChanged", "CodeInvalid", "CodeValid", "ConfirmEmailFail", "ConfirmEmailSuccess", "ConfirmEmailTechnicalError", "Expired", "Forgot", "ForgotEmailSuccess", "OffersChecked", "RestartProcess", "Retry", "SendAnalyticsForScreen", "ShowHelp", "StopTimer", "Submit", "ToEmailEntered", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CodeChanged;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CodeInvalid;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CodeValid;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ConfirmEmailFail;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ConfirmEmailSuccess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ConfirmEmailTechnicalError;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Expired;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ForgotEmailSuccess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$OffersChecked;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ShowHelp;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$StopTimer;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ToEmailEntered;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CheckExpiration extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CheckExpiration(ProcessType processType, String processId, OffsetDateTime expireAt) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                this.processType = processType;
                this.processId = processId;
                this.expireAt = expireAt;
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
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
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
                return this.expireAt.hashCode() + a.a(this.processId, this.processType.hashCode() * 31, 31);
            }

            public String toString() {
                return "CheckExpiration(processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CodeChanged;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "code", "", "secretLength", "", "(Ljava/lang/String;I)V", "getCode", "()Ljava/lang/String;", "getSecretLength", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CodeChanged extends Action {
            private final String code;
            private final int secretLength;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CodeChanged(String code, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
                this.secretLength = i;
            }

            public static /* synthetic */ CodeChanged copy$default(CodeChanged codeChanged, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = codeChanged.code;
                }
                if ((i2 & 2) != 0) {
                    i = codeChanged.secretLength;
                }
                return codeChanged.copy(str, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            /* renamed from: component2, reason: from getter */
            public final int getSecretLength() {
                return this.secretLength;
            }

            public final CodeChanged copy(String code, int secretLength) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new CodeChanged(code, secretLength);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CodeChanged)) {
                    return false;
                }
                CodeChanged codeChanged = (CodeChanged) other;
                return Intrinsics.areEqual(this.code, codeChanged.code) && this.secretLength == codeChanged.secretLength;
            }

            public final String getCode() {
                return this.code;
            }

            public final int getSecretLength() {
                return this.secretLength;
            }

            public int hashCode() {
                return Integer.hashCode(this.secretLength) + (this.code.hashCode() * 31);
            }

            public String toString() {
                return "CodeChanged(code=" + this.code + ", secretLength=" + this.secretLength + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CodeInvalid;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "code", "", "secretLength", "", "(Ljava/lang/String;I)V", "getCode", "()Ljava/lang/String;", "getSecretLength", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CodeInvalid extends Action {
            private final String code;
            private final int secretLength;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CodeInvalid(String code, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
                this.secretLength = i;
            }

            public static /* synthetic */ CodeInvalid copy$default(CodeInvalid codeInvalid, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = codeInvalid.code;
                }
                if ((i2 & 2) != 0) {
                    i = codeInvalid.secretLength;
                }
                return codeInvalid.copy(str, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            /* renamed from: component2, reason: from getter */
            public final int getSecretLength() {
                return this.secretLength;
            }

            public final CodeInvalid copy(String code, int secretLength) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new CodeInvalid(code, secretLength);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CodeInvalid)) {
                    return false;
                }
                CodeInvalid codeInvalid = (CodeInvalid) other;
                return Intrinsics.areEqual(this.code, codeInvalid.code) && this.secretLength == codeInvalid.secretLength;
            }

            public final String getCode() {
                return this.code;
            }

            public final int getSecretLength() {
                return this.secretLength;
            }

            public int hashCode() {
                return Integer.hashCode(this.secretLength) + (this.code.hashCode() * 31);
            }

            public String toString() {
                return "CodeInvalid(code=" + this.code + ", secretLength=" + this.secretLength + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$CodeValid;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "code", "", "secretLength", "", "(Ljava/lang/String;I)V", "getCode", "()Ljava/lang/String;", "getSecretLength", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CodeValid extends Action {
            private final String code;
            private final int secretLength;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CodeValid(String code, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
                this.secretLength = i;
            }

            public static /* synthetic */ CodeValid copy$default(CodeValid codeValid, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = codeValid.code;
                }
                if ((i2 & 2) != 0) {
                    i = codeValid.secretLength;
                }
                return codeValid.copy(str, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            /* renamed from: component2, reason: from getter */
            public final int getSecretLength() {
                return this.secretLength;
            }

            public final CodeValid copy(String code, int secretLength) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new CodeValid(code, secretLength);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CodeValid)) {
                    return false;
                }
                CodeValid codeValid = (CodeValid) other;
                return Intrinsics.areEqual(this.code, codeValid.code) && this.secretLength == codeValid.secretLength;
            }

            public final String getCode() {
                return this.code;
            }

            public final int getSecretLength() {
                return this.secretLength;
            }

            public int hashCode() {
                return Integer.hashCode(this.secretLength) + (this.code.hashCode() * 31);
            }

            public String toString() {
                return "CodeValid(code=" + this.code + ", secretLength=" + this.secretLength + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ConfirmEmailFail;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "(Lru/yoomoney/sdk/auth/api/model/ProcessError;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmEmailFail extends Action {
            private final ProcessError error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmEmailFail(ProcessError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ ConfirmEmailFail copy$default(ConfirmEmailFail confirmEmailFail, ProcessError processError, int i, Object obj) {
                if ((i & 1) != 0) {
                    processError = confirmEmailFail.error;
                }
                return confirmEmailFail.copy(processError);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            public final ConfirmEmailFail copy(ProcessError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ConfirmEmailFail(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmEmailFail) && Intrinsics.areEqual(this.error, ((ConfirmEmailFail) other).error);
            }

            public final ProcessError getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ConfirmEmailFail(error=" + this.error + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ConfirmEmailSuccess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmEmailSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmEmailSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ConfirmEmailSuccess copy$default(ConfirmEmailSuccess confirmEmailSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = confirmEmailSuccess.process;
                }
                return confirmEmailSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ConfirmEmailSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ConfirmEmailSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmEmailSuccess) && Intrinsics.areEqual(this.process, ((ConfirmEmailSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ConfirmEmailSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ConfirmEmailTechnicalError;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmEmailTechnicalError extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmEmailTechnicalError(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ConfirmEmailTechnicalError copy$default(ConfirmEmailTechnicalError confirmEmailTechnicalError, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = confirmEmailTechnicalError.failure;
                }
                return confirmEmailTechnicalError.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ConfirmEmailTechnicalError copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ConfirmEmailTechnicalError(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmEmailTechnicalError) && Intrinsics.areEqual(this.failure, ((ConfirmEmailTechnicalError) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ConfirmEmailTechnicalError(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Expired;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Forgot extends Action {
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Forgot(ProcessType processType, String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
            }

            public static /* synthetic */ Forgot copy$default(Forgot forgot, ProcessType processType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = forgot.processType;
                }
                if ((i & 2) != 0) {
                    str = forgot.processId;
                }
                return forgot.copy(processType, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final Forgot copy(ProcessType processType, String processId) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new Forgot(processType, processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Forgot)) {
                    return false;
                }
                Forgot forgot = (Forgot) other;
                return this.processType == forgot.processType && Intrinsics.areEqual(this.processId, forgot.processId);
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
                return "Forgot(processType=" + this.processType + ", processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ForgotEmailSuccess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ForgotEmailSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ForgotEmailSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ForgotEmailSuccess copy$default(ForgotEmailSuccess forgotEmailSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = forgotEmailSuccess.process;
                }
                return forgotEmailSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ForgotEmailSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ForgotEmailSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ForgotEmailSuccess) && Intrinsics.areEqual(this.process, ((ForgotEmailSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ForgotEmailSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$OffersChecked;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "isChecked", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Retry extends Action {
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Retry(ProcessType processType, String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
            }

            public static /* synthetic */ Retry copy$default(Retry retry, ProcessType processType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = retry.processType;
                }
                if ((i & 2) != 0) {
                    str = retry.processId;
                }
                return retry.copy(processType, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final Retry copy(ProcessType processType, String processId) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new Retry(processType, processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Retry)) {
                    return false;
                }
                Retry retry = (Retry) other;
                return this.processType == retry.processType && Intrinsics.areEqual(this.processId, retry.processId);
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
                return "Retry(processType=" + this.processType + ", processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ShowHelp;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowHelp extends Action {
            public static final ShowHelp INSTANCE = new ShowHelp();

            private ShowHelp() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowHelp.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$StopTimer;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class StopTimer extends Action {
            public static final StopTimer INSTANCE = new StopTimer();

            private StopTimer() {
                super(null);
            }

            public String toString() {
                String simpleName = StopTimer.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Submit extends Action {
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Submit(ProcessType processType, String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
            }

            public static /* synthetic */ Submit copy$default(Submit submit, ProcessType processType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = submit.processType;
                }
                if ((i & 2) != 0) {
                    str = submit.processId;
                }
                return submit.copy(processType, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final Submit copy(ProcessType processType, String processId) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new Submit(processType, processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Submit)) {
                    return false;
                }
                Submit submit = (Submit) other;
                return this.processType == submit.processType && Intrinsics.areEqual(this.processId, submit.processId);
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
                return "Submit(processType=" + this.processType + ", processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ToEmailEntered;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ToEmailEntered extends Action {
            public static final ToEmailEntered INSTANCE = new ToEmailEntered();

            private ToEmailEntered() {
                super(null);
            }

            public String toString() {
                String simpleName = ToEmailEntered.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "action", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "", "()V", "ResetProcess", "ShowExpireDialog", "ShowFailure", "ShowHelp", "ShowNextStep", "ToEmailEntered", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowHelp;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ToEmailEntered;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowHelp;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowHelp extends Effect {
            public static final ShowHelp INSTANCE = new ShowHelp();

            private ShowHelp() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowHelp.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect$ToEmailEntered;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ToEmailEntered extends Effect {
            public static final ToEmailEntered INSTANCE = new ToEmailEntered();

            private ToEmailEntered() {
                super(null);
            }

            public String toString() {
                String simpleName = ToEmailEntered.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "", "()V", "Invalid", "Progress", "Valid", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Invalid;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Progress;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Valid;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Invalid;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "code", "", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "nextResendFrom", "Lorg/threeten/bp/OffsetDateTime;", "isEnabledRetry", "", "offersIsChecked", "secretLength", "", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/model/ProcessError;Lorg/threeten/bp/OffsetDateTime;ZZI)V", "getCode", "()Ljava/lang/String;", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "()Z", "getNextResendFrom", "()Lorg/threeten/bp/OffsetDateTime;", "getOffersIsChecked", "getSecretLength", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Invalid extends State {
            private final String code;
            private final ProcessError error;
            private final boolean isEnabledRetry;
            private final OffsetDateTime nextResendFrom;
            private final boolean offersIsChecked;
            private final int secretLength;

            public Invalid() {
                this(null, null, null, false, false, 0, 63, null);
            }

            public static /* synthetic */ Invalid copy$default(Invalid invalid, String str, ProcessError processError, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = invalid.code;
                }
                if ((i2 & 2) != 0) {
                    processError = invalid.error;
                }
                ProcessError processError2 = processError;
                if ((i2 & 4) != 0) {
                    offsetDateTime = invalid.nextResendFrom;
                }
                OffsetDateTime offsetDateTime2 = offsetDateTime;
                if ((i2 & 8) != 0) {
                    z = invalid.isEnabledRetry;
                }
                boolean z3 = z;
                if ((i2 & 16) != 0) {
                    z2 = invalid.offersIsChecked;
                }
                boolean z4 = z2;
                if ((i2 & 32) != 0) {
                    i = invalid.secretLength;
                }
                return invalid.copy(str, processError2, offsetDateTime2, z3, z4, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            /* renamed from: component3, reason: from getter */
            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsEnabledRetry() {
                return this.isEnabledRetry;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            /* renamed from: component6, reason: from getter */
            public final int getSecretLength() {
                return this.secretLength;
            }

            public final Invalid copy(String code, ProcessError error, OffsetDateTime nextResendFrom, boolean isEnabledRetry, boolean offersIsChecked, int secretLength) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new Invalid(code, error, nextResendFrom, isEnabledRetry, offersIsChecked, secretLength);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invalid)) {
                    return false;
                }
                Invalid invalid = (Invalid) other;
                return Intrinsics.areEqual(this.code, invalid.code) && Intrinsics.areEqual(this.error, invalid.error) && Intrinsics.areEqual(this.nextResendFrom, invalid.nextResendFrom) && this.isEnabledRetry == invalid.isEnabledRetry && this.offersIsChecked == invalid.offersIsChecked && this.secretLength == invalid.secretLength;
            }

            public final String getCode() {
                return this.code;
            }

            public final ProcessError getError() {
                return this.error;
            }

            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public final int getSecretLength() {
                return this.secretLength;
            }

            public int hashCode() {
                int iHashCode = this.code.hashCode() * 31;
                ProcessError processError = this.error;
                int iHashCode2 = (iHashCode + (processError == null ? 0 : processError.hashCode())) * 31;
                OffsetDateTime offsetDateTime = this.nextResendFrom;
                return Integer.hashCode(this.secretLength) + b.a(this.offersIsChecked, b.a(this.isEnabledRetry, (iHashCode2 + (offsetDateTime != null ? offsetDateTime.hashCode() : 0)) * 31, 31), 31);
            }

            public final boolean isEnabledRetry() {
                return this.isEnabledRetry;
            }

            public String toString() {
                return "Invalid(code=" + this.code + ", error=" + this.error + ", nextResendFrom=" + this.nextResendFrom + ", isEnabledRetry=" + this.isEnabledRetry + ", offersIsChecked=" + this.offersIsChecked + ", secretLength=" + this.secretLength + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invalid(String code, ProcessError processError, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
                this.error = processError;
                this.nextResendFrom = offsetDateTime;
                this.isEnabledRetry = z;
                this.offersIsChecked = z2;
                this.secretLength = i;
            }

            public /* synthetic */ Invalid(String str, ProcessError processError, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : processError, (i2 & 4) == 0 ? offsetDateTime : null, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? 0 : i);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Progress;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "code", "", "nextResendFrom", "Lorg/threeten/bp/OffsetDateTime;", "isEnabledRetry", "", "offersIsChecked", "secretLength", "", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZZI)V", "getCode", "()Ljava/lang/String;", "()Z", "getNextResendFrom", "()Lorg/threeten/bp/OffsetDateTime;", "getOffersIsChecked", "getSecretLength", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Progress extends State {
            private final String code;
            private final boolean isEnabledRetry;
            private final OffsetDateTime nextResendFrom;
            private final boolean offersIsChecked;
            private final int secretLength;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Progress(String code, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
                this.nextResendFrom = offsetDateTime;
                this.isEnabledRetry = z;
                this.offersIsChecked = z2;
                this.secretLength = i;
            }

            public static /* synthetic */ Progress copy$default(Progress progress, String str, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = progress.code;
                }
                if ((i2 & 2) != 0) {
                    offsetDateTime = progress.nextResendFrom;
                }
                OffsetDateTime offsetDateTime2 = offsetDateTime;
                if ((i2 & 4) != 0) {
                    z = progress.isEnabledRetry;
                }
                boolean z3 = z;
                if ((i2 & 8) != 0) {
                    z2 = progress.offersIsChecked;
                }
                boolean z4 = z2;
                if ((i2 & 16) != 0) {
                    i = progress.secretLength;
                }
                return progress.copy(str, offsetDateTime2, z3, z4, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            /* renamed from: component2, reason: from getter */
            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsEnabledRetry() {
                return this.isEnabledRetry;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            /* renamed from: component5, reason: from getter */
            public final int getSecretLength() {
                return this.secretLength;
            }

            public final Progress copy(String code, OffsetDateTime nextResendFrom, boolean isEnabledRetry, boolean offersIsChecked, int secretLength) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new Progress(code, nextResendFrom, isEnabledRetry, offersIsChecked, secretLength);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Progress)) {
                    return false;
                }
                Progress progress = (Progress) other;
                return Intrinsics.areEqual(this.code, progress.code) && Intrinsics.areEqual(this.nextResendFrom, progress.nextResendFrom) && this.isEnabledRetry == progress.isEnabledRetry && this.offersIsChecked == progress.offersIsChecked && this.secretLength == progress.secretLength;
            }

            public final String getCode() {
                return this.code;
            }

            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public final int getSecretLength() {
                return this.secretLength;
            }

            public int hashCode() {
                int iHashCode = this.code.hashCode() * 31;
                OffsetDateTime offsetDateTime = this.nextResendFrom;
                return Integer.hashCode(this.secretLength) + b.a(this.offersIsChecked, b.a(this.isEnabledRetry, (iHashCode + (offsetDateTime == null ? 0 : offsetDateTime.hashCode())) * 31, 31), 31);
            }

            public final boolean isEnabledRetry() {
                return this.isEnabledRetry;
            }

            public String toString() {
                return "Progress(code=" + this.code + ", nextResendFrom=" + this.nextResendFrom + ", isEnabledRetry=" + this.isEnabledRetry + ", offersIsChecked=" + this.offersIsChecked + ", secretLength=" + this.secretLength + ")";
            }

            public /* synthetic */ Progress(String str, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i2 & 2) != 0 ? null : offsetDateTime, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, i);
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Valid;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "code", "", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "nextResendFrom", "Lorg/threeten/bp/OffsetDateTime;", "isEnabledRetry", "", "offersIsChecked", "secretLength", "", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/model/ProcessError;Lorg/threeten/bp/OffsetDateTime;ZZI)V", "getCode", "()Ljava/lang/String;", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "()Z", "getNextResendFrom", "()Lorg/threeten/bp/OffsetDateTime;", "getOffersIsChecked", "getSecretLength", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Valid extends State {
            private final String code;
            private final ProcessError error;
            private final boolean isEnabledRetry;
            private final OffsetDateTime nextResendFrom;
            private final boolean offersIsChecked;
            private final int secretLength;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(String code, ProcessError processError, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
                this.error = processError;
                this.nextResendFrom = offsetDateTime;
                this.isEnabledRetry = z;
                this.offersIsChecked = z2;
                this.secretLength = i;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, String str, ProcessError processError, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = valid.code;
                }
                if ((i2 & 2) != 0) {
                    processError = valid.error;
                }
                ProcessError processError2 = processError;
                if ((i2 & 4) != 0) {
                    offsetDateTime = valid.nextResendFrom;
                }
                OffsetDateTime offsetDateTime2 = offsetDateTime;
                if ((i2 & 8) != 0) {
                    z = valid.isEnabledRetry;
                }
                boolean z3 = z;
                if ((i2 & 16) != 0) {
                    z2 = valid.offersIsChecked;
                }
                boolean z4 = z2;
                if ((i2 & 32) != 0) {
                    i = valid.secretLength;
                }
                return valid.copy(str, processError2, offsetDateTime2, z3, z4, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            /* renamed from: component3, reason: from getter */
            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsEnabledRetry() {
                return this.isEnabledRetry;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            /* renamed from: component6, reason: from getter */
            public final int getSecretLength() {
                return this.secretLength;
            }

            public final Valid copy(String code, ProcessError error, OffsetDateTime nextResendFrom, boolean isEnabledRetry, boolean offersIsChecked, int secretLength) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new Valid(code, error, nextResendFrom, isEnabledRetry, offersIsChecked, secretLength);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics.areEqual(this.code, valid.code) && Intrinsics.areEqual(this.error, valid.error) && Intrinsics.areEqual(this.nextResendFrom, valid.nextResendFrom) && this.isEnabledRetry == valid.isEnabledRetry && this.offersIsChecked == valid.offersIsChecked && this.secretLength == valid.secretLength;
            }

            public final String getCode() {
                return this.code;
            }

            public final ProcessError getError() {
                return this.error;
            }

            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            public final boolean getOffersIsChecked() {
                return this.offersIsChecked;
            }

            public final int getSecretLength() {
                return this.secretLength;
            }

            public int hashCode() {
                int iHashCode = this.code.hashCode() * 31;
                ProcessError processError = this.error;
                int iHashCode2 = (iHashCode + (processError == null ? 0 : processError.hashCode())) * 31;
                OffsetDateTime offsetDateTime = this.nextResendFrom;
                return Integer.hashCode(this.secretLength) + b.a(this.offersIsChecked, b.a(this.isEnabledRetry, (iHashCode2 + (offsetDateTime != null ? offsetDateTime.hashCode() : 0)) * 31, 31), 31);
            }

            public final boolean isEnabledRetry() {
                return this.isEnabledRetry;
            }

            public String toString() {
                return "Valid(code=" + this.code + ", error=" + this.error + ", nextResendFrom=" + this.nextResendFrom + ", isEnabledRetry=" + this.isEnabledRetry + ", offersIsChecked=" + this.offersIsChecked + ", secretLength=" + this.secretLength + ")";
            }

            public /* synthetic */ Valid(String str, ProcessError processError, OffsetDateTime offsetDateTime, boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i2 & 2) != 0 ? null : processError, (i2 & 4) == 0 ? offsetDateTime : null, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) == 0 ? i : 0);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private EmailConfirm() {
    }
}
