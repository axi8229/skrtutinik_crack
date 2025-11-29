package ru.yoomoney.sdk.auth.phone.confirm;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.b;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneConfirm {
    public static final PhoneConfirm INSTANCE = new PhoneConfirm();

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000e\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u000e\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "", "()V", "CodeChanged", "CodeInvalid", "CodeValid", "ConfirmPhoneFail", "ConfirmPhoneSuccess", "Expired", "Forgot", "ForgotPhoneSuccess", "RestartProcess", "Retry", "SendAnalyticsForScreen", "ShowHelp", "StopTimer", "TechnicalError", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeChanged;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeInvalid;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ConfirmPhoneFail;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ConfirmPhoneSuccess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Expired;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ForgotPhoneSuccess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ShowHelp;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$StopTimer;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$TechnicalError;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeChanged;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "secretLength", "", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;ILru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getSecretLength", "()I", "getValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CodeChanged extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;
            private final int secretLength;
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CodeChanged(String value, int i, ProcessType processType, String processId, OffsetDateTime expireAt) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                this.value = value;
                this.secretLength = i;
                this.processType = processType;
                this.processId = processId;
                this.expireAt = expireAt;
            }

            public static /* synthetic */ CodeChanged copy$default(CodeChanged codeChanged, String str, int i, ProcessType processType, String str2, OffsetDateTime offsetDateTime, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = codeChanged.value;
                }
                if ((i2 & 2) != 0) {
                    i = codeChanged.secretLength;
                }
                int i3 = i;
                if ((i2 & 4) != 0) {
                    processType = codeChanged.processType;
                }
                ProcessType processType2 = processType;
                if ((i2 & 8) != 0) {
                    str2 = codeChanged.processId;
                }
                String str3 = str2;
                if ((i2 & 16) != 0) {
                    offsetDateTime = codeChanged.expireAt;
                }
                return codeChanged.copy(str, i3, processType2, str3, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            /* renamed from: component2, reason: from getter */
            public final int getSecretLength() {
                return this.secretLength;
            }

            /* renamed from: component3, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component4, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component5, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final CodeChanged copy(String value, int secretLength, ProcessType processType, String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                return new CodeChanged(value, secretLength, processType, processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CodeChanged)) {
                    return false;
                }
                CodeChanged codeChanged = (CodeChanged) other;
                return Intrinsics.areEqual(this.value, codeChanged.value) && this.secretLength == codeChanged.secretLength && this.processType == codeChanged.processType && Intrinsics.areEqual(this.processId, codeChanged.processId) && Intrinsics.areEqual(this.expireAt, codeChanged.expireAt);
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

            public final int getSecretLength() {
                return this.secretLength;
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.expireAt.hashCode() + a.a(this.processId, (this.processType.hashCode() + ru.yoomoney.sdk.auth.api.account.model.a.a(this.secretLength, this.value.hashCode() * 31, 31)) * 31, 31);
            }

            public String toString() {
                return "CodeChanged(value=" + this.value + ", secretLength=" + this.secretLength + ", processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeInvalid;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CodeInvalid extends Action {
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CodeInvalid(String value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public static /* synthetic */ CodeInvalid copy$default(CodeInvalid codeInvalid, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = codeInvalid.value;
                }
                return codeInvalid.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final CodeInvalid copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new CodeInvalid(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CodeInvalid) && Intrinsics.areEqual(this.value, ((CodeInvalid) other).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "CodeInvalid(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CodeValid extends Action {
            private final String processId;
            private final ProcessType processType;
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CodeValid(String value, String processId, ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.value = value;
                this.processId = processId;
                this.processType = processType;
            }

            public static /* synthetic */ CodeValid copy$default(CodeValid codeValid, String str, String str2, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = codeValid.value;
                }
                if ((i & 2) != 0) {
                    str2 = codeValid.processId;
                }
                if ((i & 4) != 0) {
                    processType = codeValid.processType;
                }
                return codeValid.copy(str, str2, processType);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component3, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final CodeValid copy(String value, String processId, ProcessType processType) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(processType, "processType");
                return new CodeValid(value, processId, processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CodeValid)) {
                    return false;
                }
                CodeValid codeValid = (CodeValid) other;
                return Intrinsics.areEqual(this.value, codeValid.value) && Intrinsics.areEqual(this.processId, codeValid.processId) && this.processType == codeValid.processType;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.processType.hashCode() + a.a(this.processId, this.value.hashCode() * 31, 31);
            }

            public String toString() {
                return "CodeValid(value=" + this.value + ", processId=" + this.processId + ", processType=" + this.processType + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ConfirmPhoneFail;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "error", "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmPhoneFail extends Action {
            private final Failure error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmPhoneFail(Failure error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ ConfirmPhoneFail copy$default(ConfirmPhoneFail confirmPhoneFail, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = confirmPhoneFail.error;
                }
                return confirmPhoneFail.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getError() {
                return this.error;
            }

            public final ConfirmPhoneFail copy(Failure error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ConfirmPhoneFail(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmPhoneFail) && Intrinsics.areEqual(this.error, ((ConfirmPhoneFail) other).error);
            }

            public final Failure getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ConfirmPhoneFail(error=" + this.error + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ConfirmPhoneSuccess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmPhoneSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmPhoneSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ConfirmPhoneSuccess copy$default(ConfirmPhoneSuccess confirmPhoneSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = confirmPhoneSuccess.process;
                }
                return confirmPhoneSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ConfirmPhoneSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ConfirmPhoneSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmPhoneSuccess) && Intrinsics.areEqual(this.process, ((ConfirmPhoneSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ConfirmPhoneSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Expired;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ForgotPhoneSuccess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ForgotPhoneSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ForgotPhoneSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ForgotPhoneSuccess copy$default(ForgotPhoneSuccess forgotPhoneSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = forgotPhoneSuccess.process;
                }
                return forgotPhoneSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ForgotPhoneSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ForgotPhoneSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ForgotPhoneSuccess) && Intrinsics.areEqual(this.process, ((ForgotPhoneSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ForgotPhoneSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ShowHelp;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$StopTimer;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$TechnicalError;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class TechnicalError extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TechnicalError(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ TechnicalError copy$default(TechnicalError technicalError, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = technicalError.failure;
                }
                return technicalError.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final TechnicalError copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new TechnicalError(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TechnicalError) && Intrinsics.areEqual(this.failure, ((TechnicalError) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "TechnicalError(failure=" + this.failure + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;", "action", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", "", "()V", "ResetProcess", "ShowExpireDialog", "ShowFailure", "ShowHelp", "ShowNextStep", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowHelp;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowHelp;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;", "", "()V", "Content", "Progress", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Content;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Progress;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Content;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;", "confirmCode", "", "isEnabledRetryAction", "", "nextResendFrom", "Lorg/threeten/bp/OffsetDateTime;", "error", "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Ljava/lang/String;ZLorg/threeten/bp/OffsetDateTime;Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getConfirmCode", "()Ljava/lang/String;", "getError", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "()Z", "getNextResendFrom", "()Lorg/threeten/bp/OffsetDateTime;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final String confirmCode;
            private final Failure error;
            private final boolean isEnabledRetryAction;
            private final OffsetDateTime nextResendFrom;

            public Content() {
                this(null, false, null, null, 15, null);
            }

            public static /* synthetic */ Content copy$default(Content content, String str, boolean z, OffsetDateTime offsetDateTime, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.confirmCode;
                }
                if ((i & 2) != 0) {
                    z = content.isEnabledRetryAction;
                }
                if ((i & 4) != 0) {
                    offsetDateTime = content.nextResendFrom;
                }
                if ((i & 8) != 0) {
                    failure = content.error;
                }
                return content.copy(str, z, offsetDateTime, failure);
            }

            /* renamed from: component1, reason: from getter */
            public final String getConfirmCode() {
                return this.confirmCode;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsEnabledRetryAction() {
                return this.isEnabledRetryAction;
            }

            /* renamed from: component3, reason: from getter */
            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            /* renamed from: component4, reason: from getter */
            public final Failure getError() {
                return this.error;
            }

            public final Content copy(String confirmCode, boolean isEnabledRetryAction, OffsetDateTime nextResendFrom, Failure error) {
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                return new Content(confirmCode, isEnabledRetryAction, nextResendFrom, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.confirmCode, content.confirmCode) && this.isEnabledRetryAction == content.isEnabledRetryAction && Intrinsics.areEqual(this.nextResendFrom, content.nextResendFrom) && Intrinsics.areEqual(this.error, content.error);
            }

            public final String getConfirmCode() {
                return this.confirmCode;
            }

            public final Failure getError() {
                return this.error;
            }

            public final OffsetDateTime getNextResendFrom() {
                return this.nextResendFrom;
            }

            public int hashCode() {
                int iA = b.a(this.isEnabledRetryAction, this.confirmCode.hashCode() * 31, 31);
                OffsetDateTime offsetDateTime = this.nextResendFrom;
                int iHashCode = (iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode())) * 31;
                Failure failure = this.error;
                return iHashCode + (failure != null ? failure.hashCode() : 0);
            }

            public final boolean isEnabledRetryAction() {
                return this.isEnabledRetryAction;
            }

            public String toString() {
                return "Content(confirmCode=" + this.confirmCode + ", isEnabledRetryAction=" + this.isEnabledRetryAction + ", nextResendFrom=" + this.nextResendFrom + ", error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(String confirmCode, boolean z, OffsetDateTime offsetDateTime, Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                this.confirmCode = confirmCode;
                this.isEnabledRetryAction = z;
                this.nextResendFrom = offsetDateTime;
                this.error = failure;
            }

            public /* synthetic */ Content(String str, boolean z, OffsetDateTime offsetDateTime, Failure failure, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : offsetDateTime, (i & 8) != 0 ? null : failure);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Progress;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;", "confirmCode", "", "isEnabledRetryAction", "", "(Ljava/lang/String;Z)V", "getConfirmCode", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Progress extends State {
            private final String confirmCode;
            private final boolean isEnabledRetryAction;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Progress(String confirmCode, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                this.confirmCode = confirmCode;
                this.isEnabledRetryAction = z;
            }

            public static /* synthetic */ Progress copy$default(Progress progress, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = progress.confirmCode;
                }
                if ((i & 2) != 0) {
                    z = progress.isEnabledRetryAction;
                }
                return progress.copy(str, z);
            }

            /* renamed from: component1, reason: from getter */
            public final String getConfirmCode() {
                return this.confirmCode;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsEnabledRetryAction() {
                return this.isEnabledRetryAction;
            }

            public final Progress copy(String confirmCode, boolean isEnabledRetryAction) {
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                return new Progress(confirmCode, isEnabledRetryAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Progress)) {
                    return false;
                }
                Progress progress = (Progress) other;
                return Intrinsics.areEqual(this.confirmCode, progress.confirmCode) && this.isEnabledRetryAction == progress.isEnabledRetryAction;
            }

            public final String getConfirmCode() {
                return this.confirmCode;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isEnabledRetryAction) + (this.confirmCode.hashCode() * 31);
            }

            public final boolean isEnabledRetryAction() {
                return this.isEnabledRetryAction;
            }

            public String toString() {
                return "Progress(confirmCode=" + this.confirmCode + ", isEnabledRetryAction=" + this.isEnabledRetryAction + ")";
            }

            public /* synthetic */ Progress(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? false : z);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private PhoneConfirm() {
    }
}
